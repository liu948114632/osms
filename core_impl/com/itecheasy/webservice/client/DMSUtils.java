package com.itecheasy.webservice.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.order.IBaseOrder;
import com.itecheasy.core.order.Order;
import com.itecheasy.core.order.OrderAddress;
import com.itecheasy.core.order.OrderDetail;
import com.itecheasy.core.order.OrderProduct;
import com.itecheasy.core.order.OrderService;
import com.itecheasy.core.product.ProductProperty;
import com.itecheasy.core.system.Merchandiser;
import com.itecheasy.core.system.SettingReimbursePercent;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.webservice.cms.order.OrderWeighingRecordInfo;
import com.itecheasy.webservice.cms.order.OrderWeighingRecordItemInfo;
import com.itecheasy.webservice.cms.order.OrderWeighingRecordProductInfo;
import com.itecheasy.webservice.dms.AccountSetting;
import com.itecheasy.webservice.dms.Address;
import com.itecheasy.webservice.dms.BoxInfo;
import com.itecheasy.webservice.dms.DeliveryDeptInfo;
import com.itecheasy.webservice.dms.OrderInfo;
import com.itecheasy.webservice.dms.OrderProductInfo;
import com.itecheasy.webservice.dms.VatTypeInfo;

/**
 * @author wanghw
 * @date 2015-5-27
 * @description 
 * @version
 */
public class DMSUtils {




	/**
	 * 纺织品判断
	 */
	private static List<String> TEXTILE_TAG=Arrays.asList(new String[]{"cloth","fiber", "Organza", 
			"Satin","silk","velvet","wool",
			"cotton","caddice","woven","nylon"});
	
	/**
	 * 限制国家判断
	 */
	private static List<String> PROPERTY_VALUE_LIST=Arrays.asList(new String[]{"Woven Cloth","Stainless Steel+Cloth","Plastic+Cloth",
		"Iron+Cloth","Elastic Fibre+Cloth","Cloth+Alloy","Cloth","Wood-Fiber","Wood+Nylon Fiber",
		"Plastic+Nylon Fiber","Aluminum+Nylon Fiber","Acrylic + Fiber","Organza","Iron+Organza",
		"Brass + Organza","Satin","Iron+Satin","Silk+Alloy","Silk","Velvet-Iron","Velvet + Wood",
		"Velvet","Wool+Rhinestone","Wool+Alloy","Wool Felt Beads","Wool","Wood-Wool","Acrylic + Wool",
		"Waxed Cotton Cord","Cotton","Woven Paper","Woven Cloth","Other Woven Beads","Wood+Nylon Fiber",
		"Plastic+Nylon Fiber","Nylon+Shell","Nylon+Rhinestone","Nylon+Lampwork","Nylon+Glass","Nylon+Alloy",
		"Nylon+Acrylic","Nylon","Aluminum+Nylon Fiber"});
	
    // 物流中心一Id
    public static final int Logistics1 = 12;

    // 物流中心二Id
    public static final int Logistics2 = 15;
	private OrderService orderService;
	private SystemService systemService;

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	private static DMSUtils utils = null;

	public void init() {
		utils = this;
		utils.orderService = this.orderService;
		utils.systemService=this.systemService;
	}
	
	public static DeliveryDeptInfo convertLogisticsToDmsDepartmentId(Integer logistics){
		if (logistics==null) {
			return DeliveryDeptInfo.DEPT_1;
		}
		if (logistics==Logistics1) {
			return DeliveryDeptInfo.DEPT_1;
		}
		if (logistics==Logistics2) {
			return DeliveryDeptInfo.DEPT_2;
		}
		return DeliveryDeptInfo.DEPT_1;
	}
	
	public static void convert2DMSAddress(OrderDetail detail,OrderAddress oa,Address dmsAddress){
		// 货运地址
				
	}
	
	@Deprecated
	public static AccountSetting convert2DMSObject(OrderDetail detail, OrderInfo info,
			ShopInfo shopInfo, AccountSetting accountSetting) throws BussinessException {
		Shop shop= utils.systemService.getShop(detail.getShopId());
		accountSetting = getAccountSetting(shopInfo.getShopSource().intValue());
		info.setCode(detail.getCode());
		info.setShippingMethod(detail.getShippingMethod());
		info.setWebFreight(new BigDecimal(detail.getShopShippingPrice()).setScale(2,4));
		info.setDepartment(convertToDmsDepartment(shopInfo.getShopSource().intValue()));
		
		Merchandiser  merchandiser =utils.systemService.getMerchandiserById(detail.getMerchandiserId());
		info.setMerchandiserName(merchandiser==null?"null":merchandiser.getMerchandiserName());
		info.setMerchandiserEmail(merchandiser==null?"null":merchandiser.getMerchandiserEmail());
		info.setWebWeight(new BigDecimal(detail.getWebWeight()).divide(new BigDecimal(1000), 3, 1));
		//报关运费
		info.setReimburseAmountRate(getThreshold(detail.getOrderCurrency(), detail.getOrderAmount(),detail.getShippingMethod()));
		info.setIsReimburseFreight(false);
		info.setPlaceOrderTime(DateUtils.getXMLGregorianCalendar(detail.getShopOrderDate()));
		//货运部门
		info.setDeliveryDept(convertLogisticsToDmsDepartmentId(detail.getLogistics()));
		// physicalWeight
		BigDecimal physicalWeight = new BigDecimal(0);
		for (OrderProduct orderProduct : detail.getOrderItems()) {
			if (orderProduct.getOrderPrepareProduct().getCmsPrepare()==IBaseOrder.ORDER_PREPARE_TYPE_CMS && orderProduct.getOrderPrepareProduct().getStatus() < 12) {
				physicalWeight = physicalWeight.add(new BigDecimal(orderProduct.getOrderPrepareProduct().getUnitWeight()
						* (orderProduct.getOrderPrepareProduct().getOrderQty() + orderProduct.getOrderPrepareProduct()
								.getPrepareQty())));
			}
		}

		info.setPhysicalWeight(physicalWeight.divide(new BigDecimal(1000), 3, 1));
		info.setIsFreeShipping(false);
		info.setPlaceOrderTime(DateUtils.getXMLGregorianCalendar(detail.getShopOrderDate()));

		// DMS v0.6.4.1
		// 1. 货运系统 制作海关发票 中的 商品总额， 货运系统不自行计算。
		// 改成由CRM出库到货运系统的时候，商品总额从CRM传过来。
		// 同票订单传累计商品价值
		if (detail.getSendGroupId() != null) {
			BigDecimal totalAmount = new BigDecimal(0);
			List<Order> orders = utils.orderService.getTicketGrouypByGroupId(detail.getSendGroupId());
			for (Order order : orders) {
				totalAmount = totalAmount.add(new BigDecimal(order.getOrderAmount()-detail.getShopShippingPrice()));
			}
			info.setTotalAmount(totalAmount.setScale( 2, 4));
		} else {
			info.setTotalAmount(new BigDecimal(detail.getOrderAmount()-detail.getShopShippingPrice()).setScale( 2, 4));
		}
		info.setTransactionId(detail.getShopOrderCode());
		info.setTransactionTime(DateUtils.convertDate(detail.getShopOrderDate()));
		// 订单提醒
		info.setOrderRemind(detail.getOrderAddress().getRemark());
		
		// 货运地址
		OrderAddress oa = detail.getOrderAddress();
		Address shippingAddress = new Address();
		shippingAddress.setFirstName(oa.getName()==null?"null":oa.getName());
		shippingAddress.setLastName("");
		shippingAddress.setPhone(StringUtils.isNotEmpty(oa.getPhone())?oa.getPhone():"000-0000-0000");
		shippingAddress.setFax("");
		shippingAddress.setAddress1(StringUtils.isEmpty(oa.getAddressLine1())?oa.getAddressLine2():oa.getAddressLine1());
		shippingAddress.setAddress2(oa.getAddressLine2());
		shippingAddress.setCity(oa.getCity());
		shippingAddress.setState(oa.getStateOrRegion());
		shippingAddress.setCountry(oa.getCountryId());
		shippingAddress.setZipCode(oa.getPostalCode());
		shippingAddress.setEmail(detail.getCustomerAccount());
		if (StringUtils.isNotEmpty(detail.getCPFCode())) {
			shippingAddress.setVat(detail.getCPFCode());
			vatTypeChangeDMSVatType(detail.getCPFType(), shippingAddress);
		}
		if (DMSClient.isRemote(oa.getCountryId(), detail.getShippingMethod(), oa.getCity(), oa.getPostalCode(),
				accountSetting))
			info.setIsRemote(true);
		else
			info.setIsRemote(false);
		info.setShippingAddress(shippingAddress);

		List<BoxInfo> boxList = new ArrayList<BoxInfo>();

		OrderWeighingRecordInfo rinfo = CMSOrderClient.getLastOrderWeighingRecordByOrderCode(detail.getCode());

		List<OrderWeighingRecordItemInfo> items = rinfo.getItems();
		BoxInfo boxInfo = null;
		List<OrderProductInfo> productList = null;
		OrderProductInfo orderProductInfo = null;
		for (OrderWeighingRecordItemInfo item : items) {
			// 如果该子箱在订单不存在商品项，则不传递到DMS
			if (CollectionUtils.isEmpty(item.getItems())) {
				continue;
			}

			boxInfo = new BoxInfo();
			boxInfo.setCode(String.valueOf(item.getBox()));
			boxInfo.setPhyWeight(item.getActualWeight().divide(new BigDecimal(1000), 3, 1));
			boxInfo.setLength(item.getLength());
			boxInfo.setWide(item.getWidth());
			boxInfo.setHight(item.getHeight());
			
			productList = new ArrayList<OrderProductInfo>();

			List<OrderWeighingRecordProductInfo> productInfos = item.getItems();
			for (OrderWeighingRecordProductInfo productInfo : productInfos) {
				OrderProduct orderproduct=utils.orderService.getOrderProductByOrderId(productInfo.getProductCode(), detail.getId());
//				if(orderproduct!=null){
//					//新增加的商品不需要通讯到dms
//					if(orderproduct.isGift()){
//						continue;
//					}
//				}
				// 商品信息
				orderProductInfo = new OrderProductInfo();
				orderProductInfo.setCode(productInfo.getProductCode());
				orderProductInfo.setChineseName(productInfo.getInvoiceCnName());
//				if (isTEXTILE(productInfo.getProductName())) {
//					info.setIsTextile(true);
//				}
				//:无属性,1:带电,2:带磁,4:纺织品
				
//				info.setIsTextile(orderproduct.getOrderPrepareProduct().isTextile());
//				info.setElectrified(orderproduct.getOrderPrepareProduct().isElectronic());
				orderProductInfo.setAttribute(0);
				if(orderproduct.getOrderPrepareProduct().isElectronic()){
					orderProductInfo.setAttribute(orderProductInfo.getAttribute()|1);
				}
				if(orderproduct.getOrderPrepareProduct().isMagnetism()){
					orderProductInfo.setAttribute(orderProductInfo.getAttribute()|2);
				}
				if(orderproduct.getOrderPrepareProduct().isTextile()){
					orderProductInfo.setAttribute(orderProductInfo.getAttribute()|4);
				}
				
				orderProductInfo.setEnglishName(productInfo.getCategoyName());
				orderProductInfo.setInvoiceCode(productInfo.getHsCode());
				orderProductInfo.setName(productInfo.getProductName());
				orderProductInfo.setClassification(productInfo.getClassification());
				orderProductInfo.setMaterial(productInfo.getMaterial());
				orderProductInfo.setUsage(productInfo.getUsage());
				orderProductInfo.setWeight(productInfo.getWeight().divide(new BigDecimal(1000), 3, 1));
				orderProductInfo.setBatch(new BigDecimal(productInfo.getUnitQuantity()));
				orderProductInfo.setBatchUnit(productInfo.getUnit());
				orderProductInfo.setUnitPrice(productInfo.getSalePrice());
				orderProductInfo.setQty(new BigDecimal(productInfo.getOrderQutity()).divide(
						new BigDecimal(productInfo.getUnitQuantity()), 2, 4));


				productList.add(orderProductInfo);
			}
			if(productList.size()>0){
				boxInfo.setProducts(productList);
				boxList.add(boxInfo);
			}

		}
		info.setBoxs(boxList);

		// 同时称重的订单
		if (StringUtils.isNotEmpty(rinfo.getOrderCodes()) && rinfo.getOrderCodes().indexOf(",") > 0) {
			info.setRelatedCode(rinfo.getOrderCodes());
		}
		
		info.setElectrified(detail.isElectronic());
		return accountSetting;
	}


	/**
	 * 判断带电
	 * @param categoryName1
	 * @param categoryName2
	 * @param categoryName3
	 * @param productPropertyValues
	 * @version 1.1.6
	 * @return
	 */
	public static boolean isElectronic$new(List<ProductProperty> productPropertyValues){
		if (CollectionUtils.isEmpty(productPropertyValues)) {
			return false;
		}
		for (ProductProperty productProperty : productPropertyValues) {
			String property=productProperty.getPropertyName();
			String propertyValue=productProperty.getPropertyValueName();
			if ("Feature".equalsIgnoreCase(property)) {
				if ("Built-in Battery".equalsIgnoreCase(propertyValue) || "Battery".equalsIgnoreCase(propertyValue)
						|| "External Battery".equalsIgnoreCase(propertyValue)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 带磁
	 * @param categoryName1
	 * @param categoryName2
	 * @param categoryName3
	 * @param productPropertyValues
	 * @version 1.1.6
	 * @return
	 */
	public static boolean isMagnetism(String categoryName1, String categoryName2, String categoryName3,
			List<ProductProperty> productPropertyValues){
		if (CollectionUtils.isEmpty(productPropertyValues)) {
			return false;
		}
//		商品属性为Material，属性值为Hematite、Magnetic Hematite
//		or 商品类别为
//		Jewelry Findings > Clasps > Magnetic Clasps
//		Jewelry Findings > Clasps > Slide Lock Clasps
//		Jewelry & Gift > Jewelry Set
//		Jewelry & Gift > Necklace
//		Jewelry & Gift > Bracelets & Bangles
//		Stringing Materials > Jewelry Making

		if("Jewelry Findings".equalsIgnoreCase(categoryName1)){
			if("Clasps".equalsIgnoreCase(categoryName2)){
				if("Magnetic Clasps".equalsIgnoreCase(categoryName3)
						||"Slide Lock Clasps".equalsIgnoreCase(categoryName3)){
					return true;
				}
			}
		}
		if("Jewelry & Gift".equalsIgnoreCase(categoryName1)){
			if("Jewelry Set".equalsIgnoreCase(categoryName2)||
					"Necklace".equalsIgnoreCase(categoryName2)||
					"Bracelets & Bangles".equalsIgnoreCase(categoryName2)){
				return true;
			}
		}
		if("Stringing Materials".equalsIgnoreCase(categoryName1)){
			if("Jewelry Making".equalsIgnoreCase(categoryName2)){
				return true;
			}
		}
		for (ProductProperty productProperty : productPropertyValues) {
			String property=productProperty.getPropertyName();
			String propertyValue=productProperty.getPropertyValueName();
			if ("Material".equalsIgnoreCase(property)) {
				if ("Hematite".equalsIgnoreCase(propertyValue)||
						"Magnetic Hematite".equalsIgnoreCase(propertyValue)) {
					return true;
				}
			}
		}		
		return false;
	}

	public static boolean isElectronic(String categoryName1, String categoryName2, String categoryName3,
			List<ProductProperty> productPropertyValues) {
//		return isElectronic$old(categoryName1, categoryName2, categoryName3, productPropertyValues);
		return isElectronic$new(productPropertyValues);
	}

	public static boolean isElectronic$old(String categoryName1, String categoryName2, String categoryName3,
			List<ProductProperty> productPropertyValues) {
		if (CollectionUtils.isEmpty(productPropertyValues)) {
			return false;
		}
		if ("Bike & Motorcycle Accessories".equalsIgnoreCase(categoryName1)
				|| "Car Accessories".equalsIgnoreCase(categoryName1)
				|| "Lights & Lighting".equalsIgnoreCase(categoryName1)
				|| "Mobile Phone Accessories".equalsIgnoreCase(categoryName1)) {
			for (ProductProperty productProperty : productPropertyValues) {
				String property=productProperty.getPropertyName();
				String propertyValue=productProperty.getPropertyValueName();
				if ("Feature".equalsIgnoreCase(property)) {
					if ("Built-in Battery".equalsIgnoreCase(propertyValue) || "Battery".equalsIgnoreCase(propertyValue)
							|| "External Battery".equalsIgnoreCase(propertyValue)) {
						// 'Built-in Battery','Battery','External Battery'
						return true;
					}
				}
			}

		}
		
		if ("Watch & Clock".equalsIgnoreCase(categoryName2) || "Measuring Tools".equalsIgnoreCase(categoryName3)) {
			for (ProductProperty productProperty : productPropertyValues) {
				String property=productProperty.getPropertyName();
				String propertyValue=productProperty.getPropertyValueName();
				if ("Feature".equalsIgnoreCase(property)) {
					if ("Built-in Battery".equalsIgnoreCase(propertyValue)) {
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	
	public static int electronicShippingMethod(String categoryName1, String categoryName2, String categoryName3,
			List<ProductProperty> productPropertyValues) {
		if ("Bike & Motorcycle Accessories".equalsIgnoreCase(categoryName1)
				|| "Car Accessories".equalsIgnoreCase(categoryName1)
				|| "Lights & Lighting".equalsIgnoreCase(categoryName1)
				|| "Mobile Phone Accessories".equalsIgnoreCase(categoryName1)) {
			for (ProductProperty productProperty : productPropertyValues) {
				String property = productProperty.getPropertyName();
				String propertyValue = productProperty.getPropertyValueName();
				if ("Feature".equalsIgnoreCase(property)) {
					if ("Built-in Battery".equalsIgnoreCase(propertyValue))
						return 116; // 内置电方式
					if ("Battery".equalsIgnoreCase(propertyValue))
						return 118; // 纯电方式
					if ("External Battery".equalsIgnoreCase(propertyValue))
						return 117; // 配置电方式
				}

			}
		}
		
		if ("Watch & Clock".equalsIgnoreCase(categoryName2) || "Measuring Tools".equalsIgnoreCase(categoryName3)) {
			for (ProductProperty productProperty : productPropertyValues) {
				String property = productProperty.getPropertyName();
				String propertyValue = productProperty.getPropertyValueName();
				if ("Feature".equalsIgnoreCase(property)) {
					if ("Feature".equalsIgnoreCase(property)) {
						if ("Built-in Battery".equalsIgnoreCase(propertyValue))
							return 118; // 纯电方式
					}
				}
			}
		}
		
		return 116;
	}
	
	
	
	/**
	 * 限制国家判断
	 * @param categoryName1
	 * @param categoryName2
	 * @param categoryName3
	 * @param productPropertyValues
	 * @param countryId
	 * @return
	 */
	public static boolean  islimit(String categoryName1, String categoryName2, String categoryName3,
			List<ProductProperty> productPropertyValues,int countryId){
		
		if(countryId==4){
			//阿根廷
			for (ProductProperty productProperty : productPropertyValues) {
				String property = productProperty.getPropertyName();
				String propertyValue = productProperty.getPropertyValueName();
				if ("Feature".equalsIgnoreCase(property)) {
					if ("Built-in Battery".equalsIgnoreCase(propertyValue))
						return true; 
					if ("Battery".equalsIgnoreCase(propertyValue))
						return true; 
					if ("External Battery".equalsIgnoreCase(propertyValue))
						return true; 
				}else if("Material".equalsIgnoreCase(property)){
					if (PROPERTY_VALUE_LIST.contains(propertyValue)) {
						return true;
					}
				}
				
			}
		}
		if(countryId==82||countryId==23){
			//波兰  捷克共和国
			if ("DIY Loom Bands".equalsIgnoreCase(categoryName3)) {
				return true;
			}
		}
		return false;
	}

	
	
	public static void vatTypeChangeDMSVatType(int TaxCodeType, Address shippingAddress) {
		// 税号类型0：其他税号 1：巴西税号2：欧盟税号
		if (TaxCodeType == 0) {
			shippingAddress.setVatType(VatTypeInfo.VAT);
		} else if (TaxCodeType == 1) {
			shippingAddress.setVatType(VatTypeInfo.CPF);
		} else if (TaxCodeType == 2) {

			shippingAddress.setVatType(VatTypeInfo.EORI);
		} else if (TaxCodeType == 3) {
			shippingAddress.setVatType(VatTypeInfo.FISCAL_CODE);
		}
	}

	public static String convertToDmsDepartment(int orderSource) {
		return utils.systemService.convertToDmsDepartment(orderSource);
	}
	
	public static AccountSetting getAccountSetting(int orderSource) {
		return utils.systemService.getAccountSetting(orderSource);
	}
	
	/**
	 * 将osms的订单来源转换成cms业务线
	 * 
	 * @param shopSource
	 * @see {@link OrderService.ShopSource}
	 * @return
	 */
	public static int getBussisType(int shopSource) {
		return utils.systemService.getCMSBussisType(shopSource);
	}
	
	@Deprecated
	public static AccountSetting getAccountSetting(Integer bussinessType){
		if (bussinessType==null) {
			bussinessType=1;
		}
		AccountSetting accountSetting=new AccountSetting();
		switch (bussinessType) {
		case 1: //wh-am
				accountSetting.setAccountNumber(DeployProperties.getInstance().getProperty("dms.wh_am.accountNumber"));
				accountSetting.setSignature(DeployProperties.getInstance().getProperty("dms.wh_am.signature"));
			break;
		case 2: //gz-am
				accountSetting.setAccountNumber(DeployProperties.getInstance().getProperty("dms.gz_am.accountNumber"));
				accountSetting.setSignature(DeployProperties.getInstance().getProperty("dms.gz_am.signature"));
			break;
		}
		return accountSetting;
	}
	
	/**
	 * 纺织品判断
	 * @param name
	 * @return
	 */
	public static boolean isTEXTILE(String name){
		for (String tag : TEXTILE_TAG) {
			if (StringUtils.containsIgnoreCase(name, tag)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 纺织品判断
	 * @param productPropertyValues
	 * @param name
	 * @version 1.1.6
	 * @return
	 */
	public static boolean isTextile$new(List<ProductProperty> productPropertyValues,String name){
		for (ProductProperty productProperty : productPropertyValues) {
			String property = productProperty.getPropertyName();
			String propertyValue = productProperty.getPropertyValueName();
			if("Material".equalsIgnoreCase(property)){
				if (PROPERTY_VALUE_LIST.contains(propertyValue)) {
					return true;
				}
			}
		}
		
		return isTEXTILE(name);
	}
	
	public static BigDecimal convert2USD(BigDecimal amaount,int currency){
		if(amaount.compareTo(new BigDecimal(0))==0){
			return new BigDecimal(0);
		}
		return utils.systemService.convert2USD(amaount, currency);
	}
	
	@Deprecated
	public static BigDecimal getSendGroupOrderAmount(double orderAmount,Integer sendGroupId,Double shopShippingPrice){
		if (sendGroupId != null) {
			BigDecimal totalAmount = new BigDecimal(0);
			List<Order> orders = utils.orderService.getTicketGrouypByGroupId(sendGroupId);
			for (Order order : orders) {
				totalAmount = totalAmount.add(new BigDecimal(order.getOrderAmount()-order.getShopShippingPrice()));
			}
			return totalAmount.setScale( 2, 4);
		} else {
			return new BigDecimal(orderAmount-shopShippingPrice).setScale( 2, 4);
		}
	}
	
	@Deprecated
	public static BigDecimal getThreshold(String currency,double amount){
		Double Threshold= utils.systemService.getCurrencyByCode(currency).getThreshold();
		//报关百分比
		if (Threshold!=null&&amount<Threshold) {
			return new BigDecimal(100);
		}else{
			return new BigDecimal(60);
		}
	}
	
	public static BigDecimal getThreshold(int currency,double amount,int shippingMethod){
		//v1.1.8 sp2
		SettingReimbursePercent  percent=utils.systemService.getCacheSettingReimbursePercentByShippingMethod(shippingMethod);
		if(percent!=null){
			BigDecimal  orderAmount=convert2USD(new BigDecimal(amount), currency);
			if(orderAmount.compareTo(percent.getThreshold())>-1){
				return percent.getOutOfThresholdToCalcForPercent().divide(orderAmount,4,4).multiply(new BigDecimal(100));
			}else{
				return new BigDecimal(100);
			}
			
		}
		if(currency==0){
			return new BigDecimal(100);
		}
		Double Threshold= utils.systemService.getCurrency(currency).getThreshold();
		//报关百分比
		if (Threshold!=null&&amount<Threshold) {
			return new BigDecimal(100);
		}else{
			return new BigDecimal(60);
		}
	}
	
	/**
	 * 
	 * @author wanghw
	 * @Date 2016-6-27 
	 * @Description 未妥投件处理类型
	 * 0 : 弃件  , 1 : 国外上架, 2 : 国内上架 , 3 : 国内重发
	 */
	public enum OrderQuestionProcessType{
		弃件,国外上架,国内上架,国内重发;
		
		public static String getOrderQuestionProcessTypeText(int val){
			for (OrderQuestionProcessType type : OrderQuestionProcessType.values()) {
				if(type.ordinal()==val){
					return type.name();
				}
			}
			return "";
		}
	}
	
	/**
	 *  0 : 表示确认, 1 : 表示弃件.2 : 丢包(有赔偿),3 : 丢包(无赔偿)
	 * @author wanghw
	 * @Date 2016-6-27 
	 * @Description DMS在发送回复时,如有处理结果，则在消息中返回 processResult 
	 */
	public enum OrderQuestionProcessResultType{
		无处理结果(-1),确认(0),弃件(1),丢包_有赔偿(2),丢包_无赔偿(3);
		
		private int val;
		
		public int getVal() {
			return val;
		}

		private OrderQuestionProcessResultType(int val) {
			this.val=val;
		}
		
		public static String getOrderQuestionProcessResultTypeText(Integer val){
			if(val!=null){
				for (OrderQuestionProcessResultType type : OrderQuestionProcessResultType.values()) {
					if(type.getVal()==val.intValue()){
						return type.name();
					}
				}
			}
			return "";
		}
		
		public boolean isEquals(Integer val){
			if(val==null)
				return false;
			
			if(val.intValue()==this.getVal())
				return true;
			
			return false;
		}
	}
	
	
	
	public static void main(String[] args) {

		OrderWeighingRecordInfo wa150616162910 = CMSOrderClient.getLastOrderWeighingRecordByOrderCode("WA150616162910");

		System.out.println("wa150616162910 = " + wa150616162910);

		System.out.println(OrderQuestionProcessType.getOrderQuestionProcessTypeText(2));
	}

}
