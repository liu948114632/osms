package com.itecheasy.core.order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.OrderStatusCodeType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.TransactionType;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.order.dao.EbayOrderDataDao;
import com.itecheasy.core.po.EbayOrderDataPO;
import com.itecheasy.core.po.OrderPO;
import com.itecheasy.core.system.Country;
import com.itecheasy.core.system.Currency;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.ShopDevInfo;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.core.util.SystemEnumDicts.ShopType;
import com.itecheasy.webservice.client.EbayApiAccount;
import com.itecheasy.webservice.client.EbayClient;

/**
 * @author wanghw
 * @date 2016-7-26
 * @description ebay订单服务
 * @version 1.2.0
 */
public class EbayOrderServiceImpl extends OrderServiceImpl implements EbayOrderService {
	private final static Logger LOGGER=Logger.getLogger(EbayOrderServiceImpl.class);
	private int shopType = ShopType.EBAY.getVal();

	private EbayOrderDataDao ebayOrderDataDao;

	public void setEbayOrderDataDao(EbayOrderDataDao ebayOrderDataDao) {
		this.ebayOrderDataDao = ebayOrderDataDao;
	}

	private void logEbayFileOrderHistory(EbayOrderData data, int shopId) {
		EbayOrderDataPO po = BeanUtils.copyProperties(data, EbayOrderDataPO.class);
		po.setShopId(shopId);
		ebayOrderDataDao.addObject(po);
	}

	@Override
	public String importEbayOrder(List<EbayOrderData> datas, int shopId, int operator) throws BussinessException {
		Shop shop = systemService.getShop(shopId);
		ShopInfo shopInfo = systemService.getShopInfo(shopId);
		if (shop.getType() != shopType) {
			throw new BussinessException("不是ebay店铺，无法导入订单！");
		}

		StringBuilder remark = new StringBuilder();
		Map<String, OrderDetail> maps = new HashMap<String, OrderDetail>();
		List<String> exist = new ArrayList<String>();
		OrderDetail detail = null;
		// 1、数据验证
		int number=1;
		for (EbayOrderData ebayOrderData : datas) {
			boolean _same = false;
			if (maps.containsKey(ebayOrderData.getSalesRecordNumber())) {
				number++;
				detail = maps.get(ebayOrderData.getSalesRecordNumber());
				for (OrderProduct product : detail.getOrderItems()) {
					if (product.getTransactionId().equals(ebayOrderData.getTransactionID())
							&& product.getShopOrderItemId().equals(ebayOrderData.getItemNumber())) {
						_same = true;
						break;
					}

				}

				if (_same) {
					// 数据重复
					remark.append("SalesRecordNumber:").append(ebayOrderData.getSalesRecordNumber())
							.append("row:").append(number)
							.append(",ItemNumber:").append(ebayOrderData.getItemNumber()).append("文件中数据重复！");
				} else {
					OrderProduct product = new OrderProduct();
					convertData2Item(shop, ebayOrderData, product,detail);
					maps.get(ebayOrderData.getSalesRecordNumber()).getOrderItems().add(product);
					logEbayFileOrderHistory(ebayOrderData, shopId);
				}
			} else {
				number=1;
				String mark = requiredFiled4Order(ebayOrderData);
				if (mark != null) {
					remark.append(mark);
					continue;
				}

				if (getOrderByShopOrderCode(ebayOrderData.getPayPalTransactionID(), shopType) != null) {
					exist.add(ebayOrderData.getPayPalTransactionID());
					continue;
				}
				
				detail = convertData2OrderDetail(shopId, shop, shopInfo, ebayOrderData);
				maps.put(ebayOrderData.getSalesRecordNumber(), detail);
				logEbayFileOrderHistory(ebayOrderData, shopId);
			}
		}

		// 2、添加订单
		// 防止重复添加
		List<String> _adds = new ArrayList<String>();
		// 按导入顺序添加
		for (EbayOrderData ebayOrderData : datas) {
			if (maps.containsKey(ebayOrderData.getSalesRecordNumber())
					&& !_adds.contains(ebayOrderData.getSalesRecordNumber())) {
				_adds.add(ebayOrderData.getSalesRecordNumber());
				detail = maps.get(ebayOrderData.getSalesRecordNumber());
				addNewOrder(detail,profileService.getUserNameById(operator));
			}
		}

		// 3、返回处理结果
		if (exist.size() > 0) {
			remark.insert(0, "PaypalTransactionId:" + exist.toString() + "系统中已存在!");
		}
		if (_adds.size() > 0) {
			remark.insert(0, "SalesRecordNumber:" + _adds.toString() + "导入成功，其他将被忽略!情况如下：");
		}
		return remark.length() > 0 ? remark.toString() : null;
	}

	private void addNewOrder(OrderDetail detail,String operator) {
		checkNewOrder(detail);
		addOrder(detail, shopType , operator);
	}

	private OrderDetail convertData2OrderDetail(int shopId, Shop shop, ShopInfo shopInfo, EbayOrderData ebayOrderData) {
		OrderDetail detail = new OrderDetail();
		detail.setShopId(shopId);
		detail.setMerchandiserId(systemService.getMerchandiserByCode(shopInfo.getMerchandiserId()).getId());

		detail.setCustomerAccount(ebayOrderData.getBuyerEmail());
		detail.setCustomerName(ebayOrderData.getBuyerFullname());
		detail.setShopShippingPrice(0d);
		OrderAddress address = new OrderAddress();
		detail.setOrderAddress(address);
		detail.setShopOrderId(ebayOrderData.getOrderID());
		detail.setShopOrderLineItemId(ebayOrderData.getItemNumber() + "-"
				+ ebayOrderData.getTransactionID());
		detail.setShopSellRecordNumber(ebayOrderData.getSalesRecordNumber());
		detail.setIsSend(true);
		detail.setShopOrderStatus(ORDERSTATUS_DOWNLOAD);
		detail.setShopBuyerId(ebayOrderData.getUserId());
		detail.setShopSellRecordNumber(ebayOrderData.getSalesRecordNumber());
		detail.setShopOrderCode(ebayOrderData.getPayPalTransactionID());
		detail.setShopType(shopType);
		detail.setStatus(OrderStatus.准备货物.getVal());
		detail.setShopOrderDate(ebayOrderData.getSaleDate());
		detail.setShopId(shopId);
		detail.setOrderCurrency(shop.getCurrency());
		detail.setSendGroupId(null);
		detail.setOrderAmount(Double.valueOf(ebayOrderData.getTotalPrice()));
		detail.setShopShippingMethod(ebayOrderData.getShippingService());

		if ("ePacket delivery from China".equalsIgnoreCase(detail.getShopShippingMethod())) {
			detail.setEarliestDeliveryDate(DateUtils.addDays(detail.getShopOrderDate(), 9));
			detail.setLatestDeliveryDate(DateUtils.addDays(detail.getShopOrderDate(), 15));
		} else if ("Economy Int'l Shipping".equalsIgnoreCase(detail.getShopShippingMethod())) {
			detail.setEarliestDeliveryDate(DateUtils.addDays(detail.getShopOrderDate(), 18));
			detail.setLatestDeliveryDate(DateUtils.addDays(detail.getShopOrderDate(), 25));
		}

		detail.setEarliestShippingDate(DateUtils.addDays(detail.getShopOrderDate(), 3));
		detail.setLatestShipDate(DateUtils.addDays(detail.getShopOrderDate(), 5));
		address.setName(ebayOrderData.getBuyerFullname());
		address.setPhone(ebayOrderData.getBuyerPhoneNumber());
		address.setAddressLine1(ebayOrderData.getBuyerAddress1());
		address.setAddressLine2(ebayOrderData.getBuyerAddress2());
		address.setCity(ebayOrderData.getBuyerCity());
		String countryCode = systemService.getEbayCountryCode(ebayOrderData.getBuyerCountry());
		address.setCountryCode(countryCode);
		if (countryCode != null) {
			address.setCountryId(systemService.getCountryByCode(countryCode).getId());
			detail.setCountry(address.getCountryId());
		}

		address.setStateOrRegion(ebayOrderData.getBuyerState());
		address.setPostalCode(ebayOrderData.getBuyerZip());

		List<OrderProduct> items = new ArrayList<OrderProduct>();
		detail.setOrderItems(items);
		//多行则没有订单项
		if(StringUtils.isNotEmpty(ebayOrderData.getTransactionID())
				&&StringUtils.isNotEmpty(ebayOrderData.getItemNumber())){
			OrderProduct product = new OrderProduct();
			convertData2Item(shop, ebayOrderData, product,detail);
			items.add(product);
		}

		processOrderAddressSpecial(detail, address,shopInfo);

		return detail;
	}

	private void convertData2Item(Shop shop, EbayOrderData ebayOrderData, OrderProduct product,OrderDetail detail) {
		product.setShopOrderItemId(ebayOrderData.getItemNumber());
		product.setShopItemPrice(Double.valueOf(ebayOrderData.getSalePrice()));
		product.setShopItemCurtype(shop.getCurrency());
		product.setShopDiscount(0);
		product.setShopQuantityOrdered(Integer.valueOf(ebayOrderData.getQuantity()));
		product.setShopItemTitle(ebayOrderData.getItemTitle());
		product.setStatus(0);
		product.setTransactionId(ebayOrderData.getTransactionID());
		product.setCmsProductCode(ebayOrderData.getCustomLabel());
		product.setShopSellerSku(ebayOrderData.getCustomLabel());
		product.setShopOrderLineItemId(ebayOrderData.getItemNumber() + "-"
				+ ebayOrderData.getTransactionID());
		
		setOrderItemDetail(detail, product);
	}

	private String requiredFiled4Order(EbayOrderData data) throws BussinessException {
		// if(StringUtils.isEmpty(data.getItemNumber())){
		// throw new BussinessException("Item number是必须的");
		// }

		// if(StringUtils.isEmpty(data.getTransactionID())){
		// throw new BussinessException("transaction id是必须的");
		// }

		if (StringUtils.isEmpty(data.getPayPalTransactionID())) {
			return "record number:" + data.getSalesRecordNumber() + "没有PaypalTransactionId。";
		}

		// try {
		// Double.valueOf(data.getTotalPrice());
		// } catch (NumberFormatException e) {
		// throw new BussinessException("Total price不是数字");
		// }
		//
		// try {
		// Integer.valueOf(data.getQuantity());
		// } catch (NumberFormatException e) {
		// throw new BussinessException("Quantity不是数字");
		// }

		return null;
	}
	
//	private String requiredFiled4OrderItem(EbayOrderData data) throws BussinessException {
//		 if(StringUtils.isEmpty(data.getItemNumber())){
//		 throw new BussinessException("Item number是必须的");
//		 }
//
//		 if(StringUtils.isEmpty(data.getTransactionID())){
//		 throw new BussinessException("transaction id是必须的");
//		 }

//		if (StringUtils.isEmpty(data.getPayPalTransactionID())) {
//			return "record number:" + data.getSalesRecordNumber() + "没有PaypalTransactionId。";
//		}

//		 try {
//		 Double.valueOf(data.getTotalPrice());
//		 } catch (NumberFormatException e) {
//		 throw new BussinessException("Total price不是数字");
//		 }
//		 try {
//		 Integer.valueOf(data.getQuantity());
//		 } catch (NumberFormatException e) {
//		 throw new BussinessException("Quantity不是数字");
//		 }
//
//		return null;
//	}
	
	private Order existEbayOrder(OrderType orderType){
		if(orderType.getMonetaryDetails()!=null&&
				orderType.getMonetaryDetails().getPayments().getPayment()!=null
				){
			Order o= getOrderByShopOrderCode(orderType.getMonetaryDetails().getPayments().getPayment()[0].
					getReferenceID().getValue(),shopType);
			if(o==null){
				String shopOrderId=orderType.getOrderID();
				o=getOrderByShopOrderUnique(shopOrderId, shopType);
			}
			return o;
		}
		return null;
	}
	
	public void syncOrders(){
		List<ShopDevInfo> infos=shopService.getJointAccount(shopType);
		if(CollectionUtils.isEmpty(infos)){
			return;
		}
		
		Date current=new Date();
		for (ShopDevInfo dev : infos) {
			EbayApiAccount account= StaticUtils.convertEbayApiAccount(dev);
			OrderType[] orders;
			try {
				orders = EbayClient.getOrder(account,dev.getLastUpdatedAfter(),current);
				List<Shop> shops=systemService.getCacheShopsByDevAccount(dev.getId());
				if(CollectionUtils.isNotEmpty(shops)){
					ShopInfo info=systemService.getCacheShopInfo(shops.get(0).getId());
					if(orders!=null){
						processEbayOrderType(orders, shops.get(0), info);
					}
					systemService.setLastUpdateTime(dev.getId(),current );
				}
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				continue;
			}
		}
	}
	
	@Override
	public void downloadSimpleOrder(String shopOrderItemLineId,int shopId) throws Exception {
		OrderType[] orders=EbayClient.getSimpleorder(StaticUtils.convertEbayApiAccount(shopService.getAccount(shopId)), shopOrderItemLineId);
		processEbayOrderType(orders, systemService.getShop(shopId), 
				systemService.getCacheShopInfo(shopId));
	}

	private void processEbayOrderType(OrderType[] orders, Shop shop, ShopInfo info) {
		int merchandiser= systemService.getMerchandiserByCode(info.getMerchandiserId()).getId();
		for (OrderType orderType : orders) {
			//验证重复
			if(orderType.getPaidTime()!=null){//已付款
				if(orderType.getShippedTime()==null //未发货
//								&&orderType.getOrderStatus()!=OrderStatusCodeType.COMPLETED
				&&orderType.getOrderStatus()!=OrderStatusCodeType.SHIPPED
				&&orderType.getOrderStatus()!=OrderStatusCodeType.CANCELLED
				&&orderType.getOrderStatus()!=OrderStatusCodeType.CANCEL_PENDING ){
					Order o=existEbayOrder(orderType);
					if(o==null){
						OrderDetail detail=convert2orderDetail(orderType,shop,info);
						if(detail!=null){
							//添加
							detail.setMerchandiserId(merchandiser);
							addNewOrder(detail,SYSTEM_OPERATOR);
						}
					}
					continue;
				}
			}
			
			//更新-->2017-01-24 取消的订单付款时间没有了
			processOrderStatusChange(orderType.getShippedTime(),orderType.getOrderStatus(), existEbayOrder(orderType));
		}
	}
	
	
	private void processOrderStatusChange(Calendar ShippedTime, OrderStatusCodeType status, Order o) {
		if(o==null)
			return;
		if (status==OrderStatusCodeType.CANCELLED
				||status==OrderStatusCodeType.CANCEL_PENDING) {
			// --取消订单
			LOGGER.info("取消ebay订单"+o.getShopOrderId());
			cancelOrder(o.getId(), SYSTEM_OPERATOR);
		}else if(ShippedTime!=null){
			// --已发货，更新订单
			OrderPO po= orderDao.getObject(o.getId());
			po.setShopOrderStatus(ORDERSTATUS_SHIPPED);
			LOGGER.info("ebay订单"+o.getShopOrderId()+"已发货");
			orderDao.mergeObject(po);
		}
	}
	
	private OrderDetail convert2orderDetail(OrderType orderType, Shop shop,ShopInfo info) {
		OrderDetail detail=new OrderDetail();
		OrderAddress address=new OrderAddress();
		List<OrderProduct> orderItems=new ArrayList<OrderProduct>();
		detail.setOrderItems(orderItems);
		detail.setOrderAddress(address);
		detail.setIsSend(true);
		detail.setShopBuyerId(orderType.getBuyerUserID());
		detail.setCustomerName(orderType.getBuyerUserID());
		detail.setShopOrderId(orderType.getOrderID());
		detail.setOrderAmount(orderType.getAmountPaid().getValue());
		Currency c=systemService.getCurrencyByCode(orderType.getAmountPaid().getCurrencyID().value());
		if(c!=null){
			detail.setOrderCurrency(c.getId());
		}else{
			detail.setOrderCurrency(shop.getCurrency());
		}
		if(orderType.getBuyerTaxIdentifier().length>0){
			detail.setCPFCode(orderType.getBuyerTaxIdentifier()[0].getID());
		}
		detail.setShopOrderDate(convertTimeDiff(orderType.getCreatedTime().getTime(),info.getTimeDiff()));
		detail.setRemark(orderType.getBuyerCheckoutMessage());
		String tranId=null;
//		orderType.getCheckoutStatus().getEBayPaymentStatus().equals(PaymentStatusCodeType.NO_PAYMENT_FAILURE)
		try {
			tranId=orderType.getMonetaryDetails().getPayments().getPayment()[0].getReferenceID().getValue();
//			tranId=orderType.getExternalTransaction()[0].getExternalTransactionID();
		} catch (Exception e) {
			//未付款
			return null;
		}finally{
			detail.setShopOrderCode(tranId);
		}
		
		if(orderType.getShippingAddress()!=null){
			address.setName(orderType.getShippingAddress().getName());
//			detail.setCustomerName(orderType.getShippingAddress().getFirstName()
//					+" "+orderType.getShippingAddress().getLastName());
			address.setCity(orderType.getShippingAddress().getCityName());
			address.setCountryCode(orderType.getShippingAddress().getCountry().value());
			Country country=systemService.getCountryByCode(address.getCountryCode());
			if(country!=null){
				address.setCountryId(country.getId());
				detail.setCountry(address.getCountryId());
			}
			address.setPhone(orderType.getShippingAddress().getPhone());
			address.setPostalCode(orderType.getShippingAddress().getPostalCode());
			address.setAddressLine1(orderType.getShippingAddress().getStreet1());
			address.setAddressLine2(orderType.getShippingAddress().getStreet2());
			address.setStateOrRegion(orderType.getShippingAddress().getStateOrProvince());
		}
		if(orderType.getShippingServiceSelected()!=null){
			detail.setShopShippingMethod(orderType.getShippingServiceSelected().getShippingService());
		}
		if(orderType.getShippingDetails()!=null&&orderType.getShippingDetails().getSellingManagerSalesRecordNumber()!=null)
			detail.setShopSellRecordNumber(orderType.getShippingDetails().getSellingManagerSalesRecordNumber().toString());
		detail.setShopType(shopType);
		detail.setStatus(OrderStatus.准备货物.getVal());
		detail.setShopId(shop.getId());
		detail.setSendGroupId(null);
		detail.setShopOrderStatus(ORDERSTATUS_DOWNLOAD);
		detail.setShopShippingPrice(0d);
		detail.setShopPaymentMethod(orderType.getCheckoutStatus().getPaymentMethod().value());
		if(orderType.getTransactionArray().getTransaction()!=null){
			for (TransactionType tran : orderType.getTransactionArray().getTransaction()) {
				if(tran.getBuyer()!=null){
					detail.setShopBuyerEmail(tran.getBuyer().getEmail());
					if(StringUtils.isNotEmpty(tran.getBuyer().getEmail())
							&&"Invalid Request".equals(tran.getBuyer().getEmail())){
						detail.setCustomerAccount(StringUtils.isEmpty(tran.getBuyer().getStaticAlias())?tran.getBuyer().getEmail():tran.getBuyer().getStaticAlias());
					}else{
						detail.setCustomerAccount(tran.getBuyer().getEmail());
					}
//					if(StringUtils.isNotEmpty(tran.getBuyer().getUserFirstName())
//							&&StringUtils.isNotEmpty(tran.getBuyer().getUserLastName())){
//						detail.setCustomerName(tran.getBuyer().getUserFirstName()
//								+" "+tran.getBuyer().getUserLastName());
//					}
				}
				OrderProduct product=new OrderProduct();
				orderItems.add(product);
				product.setShopItemCurtype(detail.getOrderCurrency());
				product.setShopOrderLineItemId(tran.getOrderLineItemID());
				detail.setShopOrderLineItemId(tran.getOrderLineItemID());
				detail.setShopShippingPrice(detail.getShopShippingPrice()+ tran.getActualShippingCost().getValue());
				product.setShopQuantityOrdered(tran.getQuantityPurchased().intValue());
				//单价*下单数量
				product.setShopItemPrice(tran.getTransactionPrice().getValue()*product.getShopQuantityOrdered());
				if(tran.getShippingDetails()!=null&&tran.getShippingDetails().getSellingManagerSalesRecordNumber()!=null)
					product.setShopSellRecordNumber(tran.getShippingDetails().getSellingManagerSalesRecordNumber().toString());
				if(tran.getSellerDiscounts()!=null)
					product.setShopDiscount(tran.getSellerDiscounts().getSellerDiscount()[0].getItemDiscountAmount().getValue());
				ItemType item=tran.getItem();
				if(item!=null){
					product.setShopOrderItemId(item.getItemID());
					product.setShopItemTitle(item.getTitle());
					product.setTitle(item.getTitle());
					product.setStatus(0);
					product.setTransactionId(tran.getTransactionID());
					if(tran.getVariation()!=null)//2016-09-13 产品集取原子产品
						product.setCmsProductCode(tran.getVariation().getSKU());
					else
						product.setCmsProductCode(item.getSKU());
					product.setShopSellerSku(product.getCmsProductCode());
					setOrderItemDetail(detail, product);
				}
				
			}
		}
		
		detail.setEarliestDeliveryDate(DateUtils.addDays(detail.getShopOrderDate(), 18));
		detail.setLatestDeliveryDate(DateUtils.addDays(detail.getShopOrderDate(), 25));

		detail.setEarliestShippingDate(DateUtils.addDays(detail.getShopOrderDate(), 3));
		detail.setLatestShipDate(DateUtils.addDays(detail.getShopOrderDate(), 5));
		
//		detail.setEarliestDeliveryDate(po.getEarliestDeliveryDate());
//		detail.setEarliestShippingDate(po.getEarliestShippingDate());
//		detail.setLatestDeliveryDate(po.getLatestDeliveryDate());
//		detail.setLatestShipDate(po.getLatestShipDate());
//		detail.setShopShippingMethod(po.getShipmentServiceLevelCategory());
		
		return detail;
	}
	
	private Date convertTimeDiff(Date time,Integer diff){
		if(time==null||diff==null)
			return time;
		
		return DateUtils.addHours(time, diff);
	}

	private void setOrderItemDetail(OrderDetail detail, OrderProduct product) {
		StringBuilder sb = new StringBuilder();

		sb.append("<table style=\" width:520px;\"><tr><td colspan=\"2\" style=\"color:blue;text-decoration:underline;font-weight:bold;\">");
		sb.append(product.getShopItemTitle()).append("</td></tr>");
		sb.append("<tr><td style=\"font-weight:bold;width:115px;\">").append("Quantity:")
				.append("</td><td style=\"400px;\">").append(product.getShopQuantityOrdered()).append("</td></tr>");
		sb.append("<tr><td style=\"font-weight:bold;\">").append("SKU:").append("</td><td>")
				.append(product.getCmsProductCode()).append("</td></tr>");
		sb.append("<tr><td style=\"font-weight:bold;\">").append("Record Number:").append("</td><td>")
				.append(product.getShopSellRecordNumber()).append("</td></tr>");
		sb.append("<tr><td style=\"font-weight:bold;\">").append("Item ID:").append("</td><td>")
				.append(product.getShopOrderItemId()).append("</td></tr>");
		sb.append("<tr><td style=\"font-weight:bold;\">").append("Transaction ID:").append("</td><td>")
				.append(product.getTransactionId()).append("</td></tr>");
		sb.append("</table>");
		product.setProductDetail(sb.toString());
	}

	@Override
	public void cancelOrderTest(String shopOrderCode) throws BussinessException {
		Order o=this.getOrderByShopOrderCode(shopOrderCode, shopType);
		if(o==null){
			throw new BussinessException("paypal transcation ");
		}
		processOrderStatusChange(null,OrderStatusCodeType.CANCELLED, o);
	}
	
	@Override
	public void updateOrderStatusTest(String shopOrderCode) throws BussinessException {
		String hql = "SELECT * FROM dbo.[order] WITH(NOLOCK) WHERE shop_order_code=? AND  shop_type=? order by id desc";
		List<Object> params = new ArrayList<Object>();
		params.add(shopOrderCode);
		params.add(ShopType.EBAY.getVal());
		List<OrderPO> pos = orderDao.findListBySql(hql, params);
		if (CollectionUtils.isNotEmpty(pos)) {
			OrderPO o=pos.get(0);
			o.setShopOrderStatus(ORDERSTATUS_SHIPPED);
		}
	}
}
