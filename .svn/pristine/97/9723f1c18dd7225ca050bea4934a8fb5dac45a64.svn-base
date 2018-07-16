package com.itecheasy.core.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import com.alibaba.openapi.sdk.aeopenapi.param.OrderItemVO;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.order.dao.SmtOrderCommunicationLogDao;
import com.itecheasy.core.po.SmtOrderCommunicationLogPo;
import com.itecheasy.core.system.AmazonShippingMethod;
import com.itecheasy.core.system.Country;
import com.itecheasy.core.system.Currency;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.ShopDevInfo;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.core.util.SystemEnumDicts.ShopType;
import com.itecheasy.webservice.aliexpress.TpOpenChildOrderDTO;
import com.itecheasy.webservice.aliexpress.TpOpenOrderDetailDTO;
import com.itecheasy.webservice.client.AliExpressClient;

/** 
 * @author whw
 * @date 2017-5-18 
 * @description TODO
 * @version 3.9.42
 */
public class SmtOrderServiceImpl extends OrderServiceImpl implements SmtOrderService{
	private final static Logger LOGGER=Logger.getLogger(SmtOrderServiceImpl.class);
	private SmtOrderCommunicationLogDao smtOrderCommunicationLogDao;
	private int shopType = ShopType.SMT.getVal();

	public void setSmtOrderCommunicationLogDao(SmtOrderCommunicationLogDao smtOrderCommunicationLogDao) {
		this.smtOrderCommunicationLogDao = smtOrderCommunicationLogDao;
	}

	@Override
	public void listOrder() {
		List<ShopDevInfo> infos=shopService.getJointAccount(shopType);
		if(CollectionUtils.isEmpty(infos)){
			return;
		}

		for (ShopDevInfo info : infos) {
			List<Shop> shops=systemService.getCacheShopsByDevAccount(info.getId());
			if(CollectionUtils.isEmpty(shops))
				return;
			
			Shop shop=shops.get(0);
			try {
				List<OrderItemVO> vos = AliExpressClient.getOrderList(StaticUtils
						.convertAliexpressConfigInfo(info));
				Date currentDate=new Date();
				if (CollectionUtils.isNotEmpty(vos)) {
					for (OrderItemVO simpleOrderItemVO : vos) {
						addOrderCommunicationLog(shop.getId(), simpleOrderItemVO.getOrderId().toString(), "",
								simpleOrderItemVO.getOrderStatus(),
								new Date(currentDate.getTime()+simpleOrderItemVO.getTimeoutLeftTime()));
					}
				}
			} catch (Exception e) {
				StaticUtils.addEmail("smt订单获取失败", e.getMessage());
			}
		}
	}

	@Override
	public void downloadOrder() {
		String sql=" SELECT TOP 1 a.* FROM dbo.smt_order_communication_log  a WITH(NOLOCK) where  a.status<>1 " +
				" and create_time<?  order by a.dowm_count asc,a.create_time asc " ;
		List<Object> params=new ArrayList<Object>();
		params.add(org.apache.commons.lang.time.DateUtils.addMinutes(new Date(), 
				-Integer.valueOf(DeployProperties.getInstance().getProperty("Delay.to.download"))));
			List<SmtOrderCommunicationLogPo> pos= smtOrderCommunicationLogDao.findListBySql(sql, params);
		
		if(CollectionUtils.isNotEmpty(pos)){
			SmtOrderCommunicationLogPo po=pos.get(0);
			try {
				TpOpenOrderDetailDTO dto=AliExpressClient.getOrderById(systemService.getAliexpressConfigInfo(po.getShopId()), Long.valueOf(po.getShopOrderId()));
				if(dto!=null){
					Order o = getOrderByShopOrderCode(po.getShopOrderId(),
							ShopType.SMT.getVal());
					if(o==null){
						ShopInfo info = systemService.getCacheShopInfo(po.getShopId());
						OrderDetail detail=convert2orderDetail(dto,systemService.getShop(po.getShopId()),
								info);
						if(detail!=null){
							detail.setLatestShipDate(po.getTimeoutLeftTime());
							int merchandiser= systemService.getMerchandiserByCode(info.getMerchandiserId()).getId();
							//添加
							detail.setMerchandiserId(merchandiser);
							checkNewOrder(detail);
							addOrder(detail, shopType , SYSTEM_OPERATOR);
						}
					}else{
						//更新
						updateOrderShopStatus(dto.getOrderStatus(), po.getShopOrderId(), o);
					}
				}
				po.setStatus(1);
				po.setLastOperatorTime(new Date());
			} catch (Exception ex){
				LOGGER.error("下载订单失败:"+ po.getShopOrderId(),ex);
				po.setStatus(2);
				po.setDowmCount(po.getDowmCount()+1);
				po.setLastOperatorTime(new Date());
				po.setRemark(po.getRemark()+";下载订单失败:"+ po.getShopOrderId()+ex.getMessage());
			}
		}	
	}
	
	private OrderDetail convert2orderDetail(TpOpenOrderDetailDTO dto, Shop shop,ShopInfo info) {
		OrderDetail detail=new OrderDetail();
		OrderAddress address=new OrderAddress();
		List<OrderProduct> orderItems=new ArrayList<OrderProduct>();
		detail.setOrderItems(orderItems);
		detail.setOrderAddress(address);
		detail.setIsSend(true);
		detail.setShopBuyerId(dto.getBuyerloginid());
		if(StringUtils.isNotEmpty(dto.getBuyerInfo().getEmail())){
			detail.setCustomerAccount(dto.getBuyerInfo().getEmail());
		}else{
			detail.setCustomerAccount(dto.getBuyerloginid());
		}
		detail.setCustomerName(dto.getBuyerSignerFullname());
		detail.setShopOrderId(dto.getId().toString());
		detail.setOrderAmount(Double.valueOf(dto.getInitOderAmount().getAmount()));
		Currency c=systemService.getCurrencyByCode(dto.getOrderAmount().getCurrencyCode());
		if(c!=null){
			detail.setOrderCurrency(c.getId());
		}else{
			detail.setOrderCurrency(shop.getCurrency());
		}
		detail.setShopOrderDate(dto.getGmtCreate());
		detail.setRemark(dto.getMemo());
		detail.setShopOrderCode(dto.getId().toString());
		
		if(dto.getReceiptAddress()!=null){
			String phone = "";
			if(StringUtils.isNotEmpty(dto.getReceiptAddress().getPhoneNumber())){
				if(StringUtils.isNotEmpty(dto.getReceiptAddress().getPhoneCountry())){
					phone = dto.getReceiptAddress().getPhoneCountry().trim();
				}
				if( StringUtils.isNotEmpty(dto.getReceiptAddress().getPhoneArea())){
					if(phone != "") 
						phone += "-" + dto.getReceiptAddress().getPhoneArea().trim();
					else
						phone = dto.getReceiptAddress().getPhoneArea().trim();
				}
				if(phone != "") 
					phone += "-" + dto.getReceiptAddress().getPhoneNumber().trim();
				else
					phone = dto.getReceiptAddress().getPhoneNumber().trim();
				address.setPhone(phone);//电话：国家—区域-电话号码
			}else{
				address.setPhone(dto.getReceiptAddress().getMobileNo());
			}
			
			
			address.setName(dto.getReceiptAddress().getContactPerson());
			address.setCity(dto.getReceiptAddress().getCity());
			address.setCountryCode(dto.getReceiptAddress().getCountry());
			Country country=systemService.getCountryByCode(address.getCountryCode());
			if(country!=null){
				address.setCountryId(country.getId());
				detail.setCountry(address.getCountryId());
			}
			address.setPostalCode(dto.getReceiptAddress().getZip());
			address.setAddressLine1(dto.getReceiptAddress().getDetailAddress());
			address.setAddressLine2(dto.getReceiptAddress().getAddress2());
			address.setStateOrRegion(dto.getReceiptAddress().getProvince());
		}
		detail.setShopType(shopType);
		detail.setStatus(OrderStatus.准备货物.getVal());
		detail.setShopId(shop.getId());
		detail.setSendGroupId(null);
		detail.setShopOrderStatus(ORDERSTATUS_DOWNLOAD);
		detail.setShopShippingPrice(Double.valueOf(dto.getLogisticsAmount().getAmount()));
		detail.setShopPaymentMethod(dto.getPaymentType());
		Set<String> shopShippingMethods=new HashSet<String>();
		if(dto.getChildOrderList()!=null){
			for (TpOpenChildOrderDTO tran : dto.getChildOrderList()) {
				OrderProduct product=new OrderProduct();
				
				
				detail.setShopShippingMethod(tran.getLogisticsType());
				shopShippingMethods.add(tran.getLogisticsType());
				orderItems.add(product);
				product.setShopItemCurtype(detail.getOrderCurrency());
				product.setShopQuantityOrdered(tran.getProductCount());
				product.setShopOrderItemId(String.valueOf(tran.getProductId()));
				product.setShopItemTitle(tran.getProductName());
				product.setTitle(tran.getProductName());
				product.setStatus(0);
				product.setCmsProductCode(tran.getSkuCode());
				product.setShopSellerSku(tran.getSkuCode());
				product.setShopItemPrice(Double.valueOf(tran.getInitOrderAmt().getAmount()));
				setOrderItemDetail(detail, product);
				
			}
		}
//		detail.setEarliestDeliveryDate(DateUtils.addDays(detail.getShopOrderDate(), 18));
//		detail.setLatestDeliveryDate(DateUtils.addDays(detail.getShopOrderDate(), 25));
//
//		detail.setEarliestShippingDate(DateUtils.addDays(detail.getShopOrderDate(), 3));
//		detail.setLatestShipDate(DateUtils.addDays(dto.getGmtPaySuccess(), 5));
		//商品不同货运方式，则无法识别货运方式
		if(shopShippingMethods.size()>1)
			detail.setShippingMethod(-1);
		
		return detail;
	}
	
	
	private void setOrderItemDetail(OrderDetail detail, OrderProduct product) {
		StringBuilder sb = new StringBuilder();

		sb.append("<table style=\" width:520px;\"><tr><td colspan=\"2\" style=\"color:blue;text-decoration:underline;font-weight:bold;\">");
		sb.append(product.getTitle()).append("</td></tr>");
		sb.append("<tr><td style=\"font-weight:bold;width:115px;\">").append("Quantity:")
				.append("</td><td style=\"400px;\">").append(product.getShopQuantityOrdered()).append("</td></tr>");
		sb.append("<tr><td style=\"font-weight:bold;\">").append("SKU:").append("</td><td>")
				.append(product.getCmsProductCode()).append("</td></tr>");
		product.setProductDetail(sb.toString());
	}
	
	private void updateOrderShopStatus(String oredrStatus,String shopOrderId, Order o){
//		OrderPO po= orderDao.getObject(o.getId());
//		po.setShopOrderStatus(oredrStatus);
//		orderDao.mergeObject(po);
	}

	@Override
	public void addOrderCommunicationLog(int shopId, String smtOrderCode,
			String remark, String smtStatus,Date timeoutLeftTime) {
		String hql="from SmtOrderCommunicationLogPo where shopOrderId=?";
		SmtOrderCommunicationLogPo  po=smtOrderCommunicationLogDao.findByHql(hql, smtOrderCode);
		if(po==null){
			po=new SmtOrderCommunicationLogPo();
			po.setRemark(remark);
			po.setShopId(shopId);
			po.setOrderStatus(smtStatus);
			po.setShopOrderId(smtOrderCode);
			po.setTimeoutLeftTime(timeoutLeftTime);
			this.smtOrderCommunicationLogDao.addObject(po);
		}
	}
	
	@Override
	public void downloadOrderTest(int shopId, String result,int leftDays) {
		JSONObject json = JSONObject.fromObject(result);
		System.out.println(json);
		
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(AliExpressClient.dateFormats));   
		TpOpenOrderDetailDTO dto = (TpOpenOrderDetailDTO) JSONObject.toBean(json, TpOpenOrderDetailDTO.class);
		
		Order o = getOrderByShopOrderCode(dto.getId().toString(),
				ShopType.SMT.getVal());
		if(o==null){
			ShopInfo info = systemService.getCacheShopInfo(shopId);
			OrderDetail detail=convert2orderDetail(dto,systemService.getShop(shopId),
					info);
			if(detail!=null){
				detail.setLatestShipDate(DateUtils.addDays(new Date(),leftDays));
				int merchandiser= systemService.getMerchandiserByCode(info.getMerchandiserId()).getId();
				//添加
				detail.setMerchandiserId(merchandiser);
				checkNewOrder(detail);
				addOrder(detail, shopType , SYSTEM_OPERATOR);
			}
		}else{
			//更新
			updateOrderShopStatus(dto.getOrderStatus(), dto.getId().toString(), o);
		}
	}
	
	@Override
	public boolean checkShopShippingMethod(OrderDetail detail) {
		if(detail.getShippingMethod()>=0){
			String sql = "SELECT shippingMethod , carrierCode , carrierName  FROM dbo.[smt_2_shipping_method] WHERE carrierCode=?";
			List<Object> params=new ArrayList<Object>();
			params.add(detail.getShopShippingMethod());
			List<AmazonShippingMethod> methods = orderDao.findListBySql(sql, params, AmazonShippingMethod.class);
			if (CollectionUtils.isNotEmpty(methods)) {
				int shippingMethod=0;
				try {
					shippingMethod = Integer.valueOf(methods.get(0).getShippingMethod());
				} catch (NumberFormatException e) {
				}
				detail.setShippingMethod(shippingMethod);
			}
		}
		return true;
	}

	//不用的
	@Override
	public int checkShopShippingMethodReturnNum(OrderDetail detail,List productCodeLists) {
		return 0;
	}

}
