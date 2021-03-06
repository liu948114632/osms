package com.itecheasy.webservice.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.log4j.Logger;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.Repository;
import com.itecheasy.core.order.BackDeliveryProcessType;
import com.itecheasy.core.order.OrderAddress;
import com.itecheasy.core.order.OrderDetail;
import com.itecheasy.core.order.OrderService;
import com.itecheasy.core.order.PackageProblemAttachment;
import com.itecheasy.core.product.BaseProductFreight;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.webservice.dms.AccountSetting;
import com.itecheasy.webservice.dms.Address;
import com.itecheasy.webservice.dms.BussinessException_Exception;
import com.itecheasy.webservice.dms.DMSBussinessException;
import com.itecheasy.webservice.dms.DMSBussinessException_Exception;
import com.itecheasy.webservice.dms.FileType;
import com.itecheasy.webservice.dms.MessageInfo;
import com.itecheasy.webservice.dms.OrderInfo;
import com.itecheasy.webservice.dms.OrderWebService;
import com.itecheasy.webservice.dms.OrderWebServiceImplService;
import com.itecheasy.webservice.dms.ShippingAmount;
import com.itecheasy.webservice.sw.PackageStatus;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author wanghw
 * @date 2015-5-19
 * @description dms服务
 * @version
 */
public class DMSClient {
	private static final String DMS_EXCEPTION = "DMS返回异常：";
	private static OrderWebService dms = null;
	private final static Logger logger = Logger.getLogger(DMSClient.class.getName());
	private static final ObjectMapper MAPPER = new ObjectMapper();


	private static void init() {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = com.itecheasy.webservice.dms.OrderWebServiceImplService.class.getResource(".");
			url = new URL(baseUrl, DeployProperties.getInstance().getProperty("dms.webservice.url"));
			OrderWebServiceImplService service = new OrderWebServiceImplService(url, new QName(
					"http://out.webservice.dms.itecheasy.com/", "OrderWebServiceImplService"));
			dms = service.getOrderWebServiceImplPort();

			Client client = ClientProxy.getClient(dms);
			HTTPConduit http = (HTTPConduit) client.getConduit();
			HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
			httpClientPolicy.setConnectionTimeout(1000 * 60 * 5);
			httpClientPolicy.setAllowChunking(false);
			httpClientPolicy.setReceiveTimeout(1000 * 60 * 5);
			http.setClient(httpClientPolicy);
		} catch (MalformedURLException e) {
			logger.error("Failed to create URL for the wsdl Location: '"
					+ DeployProperties.getInstance().getProperty("dms.webservice.url") + "', retrying as a local file");
			logger.error(e.getMessage());
			StaticUtils.addEmail("OSMS系统:DMS服务调用异常",
					e.getMessage() + "\r\n" + "Failed to create URL for the wsdl Location: '"
							+ DeployProperties.getInstance().getProperty("dms.webservice.url")
							+ "', retrying as a local file");
			dms=null;
			throw new RuntimeException(e.getMessage());
		}
	}


	/**
	 * 更新订单信息
	 *
	 * @param orderInfoJson
	 * @param accountSetting
	 */
	public static void updateOrderInfo(String orderInfoJson,AccountSetting accountSetting) {
		try {
			String s = MAPPER.writeValueAsString(orderInfoJson);
			dms.updateOrderInfo(s,accountSetting);

		} catch (IOException e) {

		} catch (DMSBussinessException_Exception e) {


		}

	}

	public static boolean addOrder(OrderDetail detail, ShopInfo shopInfo) throws BussinessException {
		if (dms == null) {
			init();
		}
		OrderInfo info = new OrderInfo();
		AccountSetting accountSetting = null;
		accountSetting = DMSUtils.convert2DMSObject(detail, info, shopInfo, accountSetting);
		try {
			dms.addOrder(info, accountSetting);
		} catch (DMSBussinessException_Exception e) {
			// 订单已存在货运系统
			if ("ORDER_HAS_PLACE".equals(e.getMessage())) {
				logger.info(MessageFormat.format("订单:{1}已经存在货运系统 {0}", e.getMessage(), detail.getCode()));
			} else {
				logger.error(e.getMessage());
				StaticUtils.addEmail(detail.getCode() + "订单出库失败", detail.getCode() + ":" + e.getMessage());
				return false;
			}
		}
		return true;
	}

	public static List<BaseProductFreight> getShippingAmounts(List<BaseProductFreight> freights) {
		if (dms == null) {
			init();
		}
		List<ShippingAmount> arg0 = new ArrayList<ShippingAmount>();
		ShippingAmount shippingAmount = null;
		for (BaseProductFreight productFreight : freights) {
			shippingAmount = new ShippingAmount();
			shippingAmount.setWeight(productFreight.getWeight());
			shippingAmount.setShippingMethod(productFreight.getShippingMethod());
			shippingAmount.setCountyId(productFreight.getCountyId());

			arg0.add(shippingAmount);
		}

		arg0 = dms.getAmount(arg0, null);
		for (BaseProductFreight productFreight : freights) {
			for (ShippingAmount arg : arg0) {
				if (productFreight.getCountyId().equals(arg.getCountyId())
						&& productFreight.getWeight().compareTo(arg.getWeight()) == 0
						&& productFreight.getShippingMethod().equals(arg.getShippingMethod())) {
					productFreight.setAmount(arg.getAmount());
					break;
				}
			}
		}

		return freights;
	}

//	public static void main(String[] args) {
//		List<ShippingAmount> arg0 = new ArrayList<ShippingAmount>();
//		ShippingAmount sa = new ShippingAmount();
//		sa.setCode("xxx");
//		sa.setCountyId(31);
//		sa.setShippingMethod(38);
//		sa.setWeight(new BigDecimal(1000));
//		arg0.add(sa);
//		arg0 = dms.getAmount(arg0, null);
//		System.out.println(arg0.get(0).getAmount());
//	}

	/**
	 * 获取dms的消息
	 * 
	 * @return
	 * @throws BussinessException
	 */
	public static List<MessageInfo> getMessage(AccountSetting accountSetting) throws BussinessException {
		if (dms == null) {
			init();
		}
		try {
			return dms.getDeliveryMessage(accountSetting);
		} catch (DMSBussinessException_Exception e) {
			e.printStackTrace();
			throw new BussinessException(DMS_EXCEPTION + e.getMessage());
		}
	}

	/**
	 * 确认消息
	 * 
	 * @param messageIds
	 * @throws BussinessException
	 */
	public static void comfirmMessage(List<Integer> messageIds, AccountSetting accountSetting)
			throws BussinessException {
		try {
			if (dms == null) {
				init();
			}
			dms.confirmDeliveryMessage(messageIds, accountSetting);
		} catch (DMSBussinessException_Exception e) {
			throw new BussinessException(DMS_EXCEPTION + e.getMessage());
		}
	}

	/**
	 * 是否偏远
	 * 
	 * @param country
	 * @param shppingMethod
	 * @param city
	 * @param zipCode
	 * @return
	 * @throws BussinessException
	 */
	public static boolean isRemote(Integer country, Integer shppingMethod, String city, String zipCode,
			AccountSetting accountSetting)  {
		try {
			if (dms == null) {
				init();
			}
			return dms.isRemoteArea(country, shppingMethod, city, zipCode, accountSetting);
		} catch (DMSBussinessException_Exception e) {
//			throw new BussinessException(DMS_EXCEPTION + e.getMessage());
		}
		return false;
	}

	public static void closeQuestion(String orderCode) throws BussinessException {
		try {
			if (dms == null) {
				init();
			}
			dms.closeQuestion(orderCode);
		} catch (DMSBussinessException_Exception e) {
			throw new BussinessException(DMS_EXCEPTION + e.getMessage());
		}
	}

	public static void receviceQuestion(String orderCode, String operatorName, String content,
			List<PackageProblemAttachment> files) throws BussinessException {
		try {
			if (dms == null) {
				init();
			}
			List<FileType> fileTypes = null;
			FileType fileType = null;
			if (CollectionUtils.isNotEmpty(files)) {
				fileTypes = new ArrayList<FileType>();
				for (PackageProblemAttachment file : files) {
					fileType = new FileType();
					fileType.setInput(file.getFile());
					fileType.setName(file.getFileName());
					fileTypes.add(fileType);
				}
			}
			dms.receviceQuestion(orderCode, operatorName, content, fileTypes);
		} catch (DMSBussinessException_Exception e) {
			throw new BussinessException(DMS_EXCEPTION + e.getMessage());
		}
	}

	public static void reopen(String orderCode, String operator) throws BussinessException {
		try {
			if (dms == null) {
				init();
			}
			dms.reopen(orderCode, operator);
		} catch (BussinessException_Exception e) {
			throw new BussinessException(DMS_EXCEPTION + e.getMessage());
		}
	}

	public static void confirmPackage(String orderCode, AccountSetting accountSetting) throws BussinessException {
		try {
			if (dms == null) {
				init();
			}
			dms.completePackageTrace(orderCode, accountSetting);
		} catch (DMSBussinessException_Exception e) {
			throw new BussinessException(DMS_EXCEPTION + e.getMessage());
		}
	}
	
	public static void updateOrderShippingAddress2(Repository oa, String orderCode, Integer webWeight,
			int shippingMethod, Integer cpfType, String cpfCode, String customerName, Boolean isRemote,
			AccountSetting accountSetting) throws BussinessException {
		// String orderCode, Integer shippingMethod, Address address, boolean
		// isRemote,
		// BigDecimal webFreight, AccountSetting accountSetting,boolean
		// isElectrified
		try {
			Address shippingAddress = new Address();
			shippingAddress.setFirstName(oa.getName() == null ? "null" : oa.getName());
			shippingAddress.setLastName("");
			shippingAddress.setPhone(oa.getPhone());
			shippingAddress.setFax("");
			shippingAddress.setAddress1(StringUtils.isNotEmpty(oa.getAddressLine1()) ? oa.getAddressLine1() : oa
					.getAddressLine2());
			shippingAddress.setAddress2(oa.getAddressLine2());
			shippingAddress.setCity(oa.getCity() == null ? "null" : oa.getCity());
			shippingAddress.setState(oa.getStateOrRegion() == null ? "null" : oa.getStateOrRegion());
			shippingAddress.setCountry(oa.getCountryId());
			shippingAddress.setZipCode(oa.getPostalCode());
			shippingAddress.setDestinationFulfillmentCenterId(oa.getRepositoryName());
			if (StringUtils.isNotEmpty(cpfCode)) {
				shippingAddress.setVat(cpfCode);
				DMSUtils.vatTypeChangeDMSVatType(cpfType, shippingAddress);
			}
//			shippingAddress.setEmail(customerAccount);
			if (isRemote == null) {
				isRemote = false;
			}
			if (dms == null) {
				init();
			}
			dms.updateOrderShippingAddress2(orderCode, shippingMethod, shippingAddress, isRemote,
					webWeight == null ? null : new BigDecimal(webWeight), accountSetting, isRemote);
		} catch (DMSBussinessException_Exception e) {
			StaticUtils.addEmail("DMS服务调用异常，方法调用失败updateOrderShippingAddress2", orderCode + ":" + e.getMessage());
		}
	}

	public static void updateOrderShippingAddress(OrderAddress oa, String orderCode, Integer webWeight,
			int shippingMethod, Integer cpfType, String cpfCode, String customerAccount, Boolean isRemote,
			AccountSetting accountSetting,int prepareType) throws BussinessException {
		// String orderCode, Integer shippingMethod, Address address, boolean
		// isRemote,
		// BigDecimal webFreight, AccountSetting accountSetting,boolean
		// isElectrified
		
		List<String> orderCodes=new ArrayList<String>();
		if(prepareType==OrderService.ORDER_PREPARE_TYPE_SW){
			 List<com.itecheasy.webservice.sw.Package>  packages=SwOrderClient.getPackagesByOrder(orderCode);
			 if(CollectionUtils.isNotEmpty(packages)){
				 for (com.itecheasy.webservice.sw.Package p : packages) {
					if(BooleanUtils.isFalse(p.isIsInstead())
							&&p.getStatus().ordinal()>=PackageStatus.IN_DELIVERY.ordinal()
							&&p.getStatus()!=PackageStatus.CANCEL){
						orderCodes.add(p.getCode());
					}
				}
			 }
		}else{
			orderCodes.add(orderCode);
		}
		
		
		for (String code : orderCodes) {
			try {
				Address shippingAddress = new Address();
				shippingAddress.setFirstName(oa.getName() == null ? "null" : oa.getName());
				shippingAddress.setLastName("");
				shippingAddress.setPhone(oa.getPhone());
				shippingAddress.setFax("");
				shippingAddress.setAddress1(StringUtils.isNotEmpty(oa.getAddressLine1()) ? oa.getAddressLine1() : oa
						.getAddressLine2());
				shippingAddress.setAddress2(oa.getAddressLine2());
				shippingAddress.setCity(oa.getCity() == null ? "null" : oa.getCity());
				shippingAddress.setState(oa.getStateOrRegion() == null ? "null" : oa.getStateOrRegion());
				shippingAddress.setCountry(oa.getCountryId());
				shippingAddress.setZipCode(oa.getPostalCode());
				if (StringUtils.isNotEmpty(cpfCode)) {
					shippingAddress.setVat(cpfCode);
					DMSUtils.vatTypeChangeDMSVatType(cpfType, shippingAddress);
				}
				shippingAddress.setEmail(customerAccount);
				if (isRemote == null) {
					isRemote = false;
				}
				if (dms == null) {
					init();
				}
				dms.updateOrderShippingAddress2(code, shippingMethod, shippingAddress, isRemote,
						webWeight == null ? null : new BigDecimal(webWeight), accountSetting, isRemote);
			} catch (DMSBussinessException_Exception e) {
				StaticUtils.addEmail("DMS服务调用异常，方法调用失败updateOrderShippingAddress2", code + ":" + e.getMessage());
			}
		}
	}

	/**
	 * dms退件处理 , 1 重发, 2 取消。3上架.
	 * 
	 * @param shop
	 * @param orderCode
	 */
	public static void updateBackOrderInfo(ShopInfo shop, String orderCode) {
		try {
			AccountSetting accountSetting = DMSUtils.getAccountSetting(shop.getShopSource().intValue());
			dms.updateBackOrderInfo(orderCode, "", BackDeliveryProcessType.上架.getVal(), "OSMS系统", accountSetting);

		} catch (Exception e) {
			StaticUtils.addEmail("DMS服务调用异常，方法调用失败updateBackOrderInfo", orderCode + ":" + e.getMessage());
		}
	}

	/**
	 * 
	 * 客服系统传递 预处理 结果, 预处理 结果类型有 0 : 弃件 , 1 : 国外上架, 2 : 国内上架 , 3 : 国内重发
	 * ,则在DMS在发送回复时,如有处理结果，则在消息中返回 processResult : 0 : 表示确认, 1 : 表示弃件.
	 * 如果DMS先处理，即无客服处理结果时,如有处理结果，则在消息中返回processResult : 2 : 丢包(有赔偿),3 : 丢包(无赔偿)
	 * 
	 * @param orderCode
	 *            订单编号
	 * @param opernatorName
	 *            操作人姓名
	 * @param type
	 *            处理类型: 0 : 弃件 , 1 : 国外上架, 2 : 国内上架 , 3 : 国内重发
	 * @param account
	 *            账号信息
	 * @throws DMSBussinessException
	 * 
	 */
	public static void receviceOrderQuestionProcessType(String orderCode, String opernatorName, Integer type,
			ShopInfo shop) throws BussinessException {
		AccountSetting accountSetting = DMSUtils.getAccountSetting(shop.getShopSource().intValue());

		try {
			if(dms==null)
				init();
			dms.receviceOrderQuestionProcessType(orderCode, opernatorName, type, accountSetting);
		} catch (DMSBussinessException_Exception e) {
			throw new BussinessException("DMS服务调用异常，方法调用失败receviceOrderQuestionProcessType:" + e.getMessage());
		}
	}

	public static void setFBAFlag(String orderCode, ShopInfo shop) {
		AccountSetting accountSetting = DMSUtils.getAccountSetting(shop.getShopSource().intValue());
		
		try {
			if(dms==null)
				init();
			dms.setFBAFlag(orderCode, true, accountSetting);
		} catch (DMSBussinessException_Exception e) {
			StaticUtils.addEmail("DMS服务调用异常，方法调用失败-->通知dms货运清单", orderCode + ":" + e.getMessage());
		}
	}
}
