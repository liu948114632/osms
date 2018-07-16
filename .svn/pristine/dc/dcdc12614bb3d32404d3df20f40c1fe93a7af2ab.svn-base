package com.itecheasy.communication.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.ConstantUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.communication.util.CData;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.UpdateOrdertProductInfo;
import com.itecheasy.core.order.IBaseOrder;
import com.itecheasy.core.order.Order;
import com.itecheasy.core.order.OrderAddress;
import com.itecheasy.core.order.OrderDetail;
import com.itecheasy.core.order.OrderProduct;
import com.itecheasy.core.po.OrderPrepareProductPO;
import com.itecheasy.core.po.OrderProductPO;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.util.SystemEnumDicts.ShopType;
import com.itecheasy.webservice.client.DMSUtils;

/**
 * @author wanghw
 * @date 2015-5-9
 * @description 通讯cms
 * @version
 */
public class Command2CMS {
	private static final String TARGET_DIRECTION_PATH = DeployProperties.getInstance().getProperty("commond.cms.url");
	private static final int ALL_PAY = 4;
	private static int TO_CMS_DIR = 8;

	// --生成订单 
	// --取消订单
	// --订单单号长度？？
	// --更新订单
	// --更新订单票号
	// --移除订单票号
	// --请求校对，（全部备货）
	// --更新货运方式
	// --更新货运地址
	// --订单发货
	// --完成订单
	// --更新订单是否可发货（同时判断订单状态， 请求待校对）
	// --取消订单项
	// --新增订单项


	public static void updateOrderProductAmount(String orderCode,int currency,Double orderAmout,Double shopShippingPrice){
		CData cdata = new CData("Order.OrderProductAmount", TO_CMS_DIR, "updateOrderProductAmount");
		cdata.addOperateData("OrderId", orderCode);
		cdata.addOperateData("OrderProductAmount", DMSUtils.convert2USD(new BigDecimal(orderAmout-shopShippingPrice)
		,currency));
		cdata.addOperateData("Freight", DMSUtils.convert2USD(new BigDecimal(shopShippingPrice)
		,currency));
		
		cdata.writeData(TARGET_DIRECTION_PATH);
	}
	
	private static BigDecimal getSubTotalPercent(OrderDetail detail){
		if(BooleanUtils.isTrue(detail.getIsOtherSystem()))
			return detail.getSubTotalPercent();
		
		return DMSUtils.getThreshold(detail.getOrderCurrency(), detail.getOrderAmount()-detail.getShopShippingPrice(),detail.getShippingMethod());
	}
	private static BigDecimal getSubTotalPercent2(Order detail){
		if(BooleanUtils.isTrue(detail.getIsOtherSystem()))
			return detail.getSubTotalPercent();
		
		return DMSUtils.getThreshold(detail.getOrderCurrency(), detail.getOrderAmount()-detail.getShopShippingPrice(),detail.getShippingMethod());
	}
	
	/**
	 * 新增订单
	 * 
	 * @param detail
	 * @param info
	 */
	public static void addOrder(OrderDetail detail, ShopInfo info) {
		CData cdata=null;
		//2018-02-02 非复制的fba订单
		if(BooleanUtils.isNotTrue(detail.getCopy())&&ConstantUtils.FULFILLMENTCHANNELS_AFN.equalsIgnoreCase(detail.getFulfillmentChannel())){
			cdata = new CData("ReportOrder.Add", TO_CMS_DIR, "add new order");//fba订单
		}else if(detail.getCmsPrepare()==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			cdata = new CData("Order.add", TO_CMS_DIR, "add new order");
		}else
			return ;
		Map<String, Object> orderInfo = new HashMap<String, Object>();
		orderInfo.put("OrderCode", detail.getCode());
		orderInfo.put("CmsOrderType", DMSUtils.getBussisType(info.getShopSource())); // string
		orderInfo.put("CustomerId", info.getCustomerId()); // int
		orderInfo.put("PayStatus", ALL_PAY); // int 默认全部付款
		orderInfo.put("PriorityLevel", 1); // int 订单优先级
		orderInfo.put("IsRemote", (detail.getRemote())); // bool
		orderInfo.put("IsOverSea", false); // bool 是否海外仓
		orderInfo.put("IsCanDeliver", detail.getIsSend()); // bool 可发货标识
		orderInfo.put("IsNeedProcessing", false); // bool 是否需要加工
		orderInfo.put("DeliveryId", detail.getShippingMethod()); // int 货运方式
		orderInfo.put("MerchandiserId", detail.getMerchandiserId()); // int 跟单员
		orderInfo.put("OrderDiscount", 1); // decimal 订单折扣
		orderInfo.put("IsQualityInspection", detail.getIsQualityInspection() == 1 ? true
				: false);// 质检
		orderInfo.put("IsFirstWebOrder", detail.isFirstWebOrder());
		orderInfo.put("IsFreeShipping", false);// 不免运费
		orderInfo.put("FreeShippingDeliveryIds", "");
		orderInfo.put("CpfCode", detail.getCPFCode());// 税号
		orderInfo.put("AutoDelayDate", detail.getEarliestShippingDate());// 预计发货日期
		orderInfo.put("CustomerServiceRemark", detail.getRemark()); // string
		orderInfo.put("ShippingRemind", detail.getOrderAddress().getRemark()); // string 发货备注
		
		 orderInfo.put("TaxCodeType", detail.getCPFType()==null?0:detail.getCPFType());//税号类型---------------------
         orderInfo.put("DmsInvoiceRemark", "");//DMS发票备注
         orderInfo.put("SubTotalPercent", getSubTotalPercent(detail));//发票金额百分比
         orderInfo.put("IsIncludeShippingFee", detail.getReimburseFreightPercent()!=null&&detail.getReimburseFreightPercent().compareTo(BigDecimal.ZERO)>0);//是否报运费
		 orderInfo.put("CustomsClearanceProportion ", detail.getReimburseFreightPercent()!=null?detail.getReimburseFreightPercent().doubleValue():0);//报关运费百分比
         orderInfo.put("Freight",
        		 DMSUtils.convert2USD(new BigDecimal(detail.getShopShippingPrice())
					,detail.getOrderCurrency()));//运费
         
         
         if(detail.getShopType()==ShopType.EBAY.getVal()){
        	 orderInfo.put("SellUserID", info.getEbaySellerId());//卖家销售ID
        	 orderInfo.put("EbayBuyEmail", detail.getCustomerAccount());//Ebay买家邮箱
        	 orderInfo.put("SellRecordNumber", "");//销售记录号
        	 orderInfo.put("BuyUserId", StringUtils.isNotEmpty(detail.getShopBuyerId())?
        			 detail.getShopBuyerId():"");//卖家ID，传的客户名称
         }else{
        	 orderInfo.put("SellUserID", "");//卖家销售ID
        	 orderInfo.put("EbayBuyEmail", "");//Ebay买家邮箱
        	 orderInfo.put("SellRecordNumber", "");//销售记录号
        	 orderInfo.put("BuyUserId", "");//卖家ID，传的客户名称
         }
         orderInfo.put("OrderProductAmount", 
        		 DMSUtils.convert2USD(new BigDecimal(detail.getOrderAmount()-detail.getShopShippingPrice())
					,detail.getOrderCurrency())
        		 ); //订单商品总金额，排除现金券的金额
         orderInfo.put("TransactionId", "");//支付凭证,随便获取一个支付信息，
         orderInfo.put("TransactionTime", "");
         
		cdata.addOperateData("Order", orderInfo);
		
		// 新增订单项
		List<Map<String, Object>> orderItemList = new ArrayList<Map<String, Object>>();
		Map<String, Object> orderItem = null;
		if (CollectionUtils.isNotEmpty(detail.getOrderItems())) {
			for (OrderProduct item : detail.getOrderItems()) {
				if (item.getOrderPrepareProduct().getStatus() == 12||item.getOrderPrepareProduct().getCmsPrepare()!=IBaseOrder.ORDER_PREPARE_TYPE_CMS
						||item.getOrderPrepareProduct().getCmsProductId()==0) {
					//	非C3备货的订单商品不通讯到C3-->2016-12-19 AFN订单匹配不上cms，不传cms
					continue;
				}
				orderItem = new HashMap<String, Object>();

				orderItem.put("BusinessId", item.getOrderPrepareProduct().getId()); // int
				orderItem.put("ProductId", item.getOrderPrepareProduct().getCmsProductId()); // int
				orderItem.put("OrderQuantity", item.getOrderPrepareProduct().getOrderQty()
						* item.getOrderPrepareProduct().getUnitQty()); // int
				orderItem.put("Unit", item.getOrderPrepareProduct().getUnit()); // string
				orderItem.put("UnitQuantity", item.getOrderPrepareProduct().getUnitQty()); // int
				orderItem.put("Weight", item.getOrderPrepareProduct().getUnitWeight() == null ? 0 : item
						.getOrderPrepareProduct().getUnitWeight()); // decimal
				orderItem.put("Volume", item.getOrderPrepareProduct().getUnitVolume() == null ? 0 : item
						.getOrderPrepareProduct().getUnitVolume()); // decimal ?
				orderItem.put("Type", 1); // int
				orderItem.put("IsPromote", item.getShopDiscount() > 0); // bool
																		// 是否促销
				orderItem.put("SalePrice", 
						DMSUtils.convert2USD(new BigDecimal(item.getShopItemPrice())
								,detail.getOrderCurrency())); // decimal
																		// 批量价格，原价
				orderItem.put("ItemPrice",
						DMSUtils.convert2USD(new BigDecimal(item.getShopItemPrice()-item.getShopDiscount()
								).divide(BigDecimal.valueOf(item.getOrderPrepareProduct().getOrderQty()),4,4)
						,detail.getOrderCurrency())); // 售价
				orderItem.put("CustomerRemark",item.getOrderPrepareProduct().getCustomerRemark() ); // string
				orderItem.put("CustomerServiceRemark", item.getOrderPrepareProduct().getCsRemark()); // string
				orderItem.put("ProcessingStatus", 10); // int

				if(detail.getShopType()==ShopType.EBAY.getVal()){
					orderItem.put("TransactionID", item.getTransactionId());
					orderItem.put("ItemID", item.getShopOrderItemId());
					orderItem.put("ItemTitle", item.getShopItemTitle());
				}else{
					orderItem.put("TransactionID", "");
					orderItem.put("ItemID", "");
					orderItem.put("ItemTitle", "");
				}
				orderItemList.add(orderItem);
			}
			// 货运地址
			OrderAddress oa = detail.getOrderAddress();
			Map<String, Object> shippingAddress = new HashMap<String, Object>();
            shippingAddress.put("Firstname", oa.getName()==null?"null":oa.getName());   //string
            shippingAddress.put("Lastname","");     //string
            shippingAddress.put("Address1", StringUtils.isEmpty(oa.getAddressLine1())?oa.getAddressLine2():oa.getAddressLine1());     //string
            shippingAddress.put("Address2", oa.getAddressLine2());     //string
            shippingAddress.put("City", oa.getCity());             //string
            shippingAddress.put("State", oa.getStateOrRegion());           //string
            shippingAddress.put("CountryId", oa.getCountryId());       //int
            shippingAddress.put("Zip", oa.getPostalCode());               //string
            shippingAddress.put("Phone", StringUtils.isNotEmpty(oa.getPhone())?oa.getPhone():"000-0000-0000");           //string
            shippingAddress.put("Fax", "");               //string
            shippingAddress.put("Port", "");             //string
            shippingAddress.put("CompanyName","");//string
            shippingAddress.put("TaxCodeType", detail.getCPFType()==null?0:detail.getCPFType());//税号类型 、本系统初始没有税号
            shippingAddress.put("CpfCode", detail.getCPFCode()==null?"":detail.getCPFCode());//税号
			
            cdata.addOperateData("ShippingAddress", shippingAddress);
			cdata.addOperateData("OrderItemList", orderItemList);
		}
		cdata.writeData(TARGET_DIRECTION_PATH);
	}
	
	/**
	 * 取消订单
	 * 
	 * @param orderCode
	 */
	public static void cancleOrder(String orderCode) {
		CData cdata = new CData("Order.Cancel", TO_CMS_DIR, "cancleOrder");
		cdata.addOperateData("OrderCode", orderCode);

		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 更新订单
	 * 
	 * @param orderCode
	 * @param isSend
	 * @param remark
	 */
	public static void updateOrder(Order order,String OperatorName,String shippingRemind) {
		CData cdata = new CData("Order.Update", TO_CMS_DIR, "updateOrder");
		cdata.addOperateData("OrderCode", order.getCode());
		cdata.addOperateData("PayStatus", ALL_PAY);
		cdata.addOperateData("OrderLevel", 1);
		cdata.addOperateData("IsSend", order.getIsSend());
		cdata.addOperateData("HandlerId", order.getMerchandiserId()); // 跟单员
		cdata.addOperateData("CustomerServiceRemark", order.getRemark());// 订单备注
		cdata.addOperateData("ShippingRemind", shippingRemind); // string 发货说明
		cdata.addOperateData("IsNeedProcessing", false);
		cdata.addOperateData("CpfCode", order.getCPFCode());
		cdata.addOperateData("OperatorName", OperatorName);
		
		
		cdata.addOperateData("IsRemote", order.getRemote()==null?false:order.getRemote());  //bool 是否偏远
		cdata.addOperateData("TaxCodeType", order.getCPFType()==null?0:order.getCPFType());//税号类型            
		cdata.addOperateData("DmsInvoiceRemark","");//DMS发票备注
		cdata.addOperateData("SubTotalPercent", getSubTotalPercent2(order));//发票金额百分比
		cdata.addOperateData("IsIncludeShippingFee", order.getReimburseFreightPercent()!=null&&order.getReimburseFreightPercent().compareTo(BigDecimal.ZERO)>0);//是否报运费
		cdata.addOperateData ("CustomsClearanceProportion", order.getReimburseFreightPercent()!=null?order.getReimburseFreightPercent().doubleValue():0);//报关运费百分比
		cdata.addOperateData("Freight", 
				DMSUtils.convert2USD(new BigDecimal(order.getShopShippingPrice())
				,order.getOrderCurrency()));//运费


		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 订单同票
	 * 
	 * @param sendGroupId
	 * @param OrderCodes
	 */
	public static void updateOrderGroup(int sendGroupId, String OrderCodes,String OperatorName) {
		CData cdata = new CData("Order.UpdateOrderGroupID", TO_CMS_DIR, "updateOrderGroup");
		cdata.addOperateData("SendGroupId", sendGroupId);
		cdata.addOperateData("OrderCodes", OrderCodes);
		cdata.addOperateData("OperatorName", OperatorName);

		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 取消订单同票
	 * 
	 * @param OrderCodes
	 */
	public static void removeOrderGroup(String OrderCodes,String OperatorName) {
		CData cdata = new CData("Order.RemoveOrderGroup", TO_CMS_DIR, "removeOrderGroup");
		cdata.addOperateData("OrderCodes", OrderCodes);
		cdata.addOperateData("OperatorName", OperatorName);

		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 请求校对
	 * 
	 * @param orderCode
	 */
	public static void requestCheckOrder(String orderCode) {
		CData cdata = new CData("Order.RequestCollateOrder", TO_CMS_DIR, "requestCheckOrder");
		cdata.addOperateData("OrderCode", orderCode);

		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 修改货运方式
	 * 
	 * @param orderCode
	 * @param deliveryId
	 */
	public static void updateOrderDelivery(String orderCode, int deliveryId,Double shopShippingPrice,int currency) {
		CData cdata = new CData("Order.UpdateDelivery", TO_CMS_DIR, "updateOrderDelivery");
		cdata.addOperateData("OrderCode", orderCode);
		cdata.addOperateData("DeliveryId", deliveryId);
		cdata.addOperateData("IsFreeShipping", false);
		cdata.addOperateData("FreeShippingDeliveryIds", "");
		cdata.addOperateData("Freight", DMSUtils.convert2USD(new BigDecimal(shopShippingPrice)
		,currency));//运费
		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 修改货运地址
	 * 
	 * @param orderId
	 * @param Orderaddress
	 * UpdateShippingInfo
	 */
	public static void updateOrderaddress(String orderCode, OrderAddress oa, boolean isRemote,
			Integer CPFType,String CPFCode) {
		CData cdata = new CData("Order.UpdateShippingInfo", TO_CMS_DIR, "updateOrderaddress");
		cdata.addOperateData("OrderCode", orderCode);
		cdata.addOperateData("CountryId", oa.getCountryId());
		cdata.addOperateData("City", oa.getCity());
		cdata.addOperateData("Zip", oa.getPostalCode());
		cdata.addOperateData("IsRemote", isRemote);
		
		cdata.addOperateData("State", oa.getStateOrRegion());    
		cdata.addOperateData("Firstname", oa.getName()==null?"null":oa.getName());   //string
		cdata.addOperateData("Lastname","");     //string
		cdata.addOperateData("Address1", StringUtils.isEmpty(oa.getAddressLine1())?oa.getAddressLine2():oa.getAddressLine1());     //string
		cdata.addOperateData("Address2", oa.getAddressLine2());     //string
		cdata.addOperateData("Phone", StringUtils.isNotEmpty(oa.getPhone())?oa.getPhone():"000-0000-0000");           //string
		cdata.addOperateData("Fax", "");               //string
		cdata.addOperateData("Port", "");             //string
		cdata.addOperateData("CompanyName","");//string
		cdata.addOperateData("TaxCodeType", CPFType==null?0:CPFType);//税号类型 、本系统初始没有税号
		cdata.addOperateData("CpfCode", CPFCode==null?"":CPFCode);//税号

		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 订单发货
	 * 
	 * @param orderCode
	 */
	public static void orderDeliver(String orderCode) {
		CData cdata = new CData("Order.SendToCustomer", TO_CMS_DIR, "orderDeliver");
		cdata.addOperateData("OrderCode", orderCode);

		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 更新订单可发货标识
	 * 
	 * @param orderCode
	 * @param isSend
	 */
	public static void updateOrderIsCanSend(String orderCode, boolean isSend,String OperatorName) {
		CData cdata = new CData("Order.UpdateIsCanSend", TO_CMS_DIR, "updateOrderIsCanSend");
		cdata.addOperateData("OrderCode", orderCode);
		cdata.addOperateData("IsSend", isSend);
		cdata.addOperateData("OperatorName", OperatorName);

		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 完成单个订单
	 * 
	 * @param orderCode
	 */
	public static void completeOrder(String orderCode) {
		String[] orderIds = new String[] { orderCode };
		completeOrder(orderIds);
	}

	/**
	 * 完成多个订单
	 * 
	 * @param orderCodes
	 */
	public static void completeOrder(String[] orderCodes) {
		StringBuilder sbOrderId = new StringBuilder();
		if (orderCodes != null && orderCodes.length > 0) {
			for (String id : orderCodes) {
				sbOrderId.append("," + id);
			}

			if (sbOrderId.length() > 1) {
				CData cdata = new CData("Order.CompleteOrder", TO_CMS_DIR, "completeOrder");
				cdata.addOperateData("OrderCodes", sbOrderId.toString().substring(1));

				cdata.writeData(TARGET_DIRECTION_PATH);
			}
		}
	}

	/**
	 * 取消订单项
	 * 
	 * @param orderCode
	 * @param orderStatus
	 * @param cancleOrderItemIds
	 * @param cancelReason
	 *            0、客户要求取消 1、挑选替代品取消 2、其他原因取消
	 */
	public static void cancleOrderItem(String orderCode, int orderStatus, String cancleOrderItemIds, String cancelReason) {
		CData cdata = new CData("OrderItem.Cancel", TO_CMS_DIR, "cancleOrderItem");
		cdata.addOperateData("OrderCode", orderCode);
		cdata.addOperateData("OrderStatus", orderStatus);
		cdata.addOperateData("OrderItemIds", cancleOrderItemIds);
		cdata.addOperateData("CancelReason", cancelReason);

		cdata.writeData(TARGET_DIRECTION_PATH);
	}
	
	public static void updateOrderItemQuantityToCMS(String orderId, int orderStatus,int bussinessId,double qty
			) {
		CData cdata = new CData("OrderItem.UpdateOrderQuantity", TO_CMS_DIR, "更新订单商品订购量");
		cdata.addOperateData("OrderCode", orderId);
        cdata.addOperateData("OrderStatus", orderStatus);
        cdata.addOperateData("BussinessId", bussinessId);
        cdata.addOperateData("OrderQuantity",qty);
		cdata.writeData(TARGET_DIRECTION_PATH);
	}
	
	public static void updateOrderItemRemarkToCMS(String orderCode,
			List<UpdateOrdertProductInfo> items
			) {
		if(CollectionUtils.isEmpty(items))
			return;
		CData cdata = new CData("OrderItem.UpdateRemark", TO_CMS_DIR, "更新订单项备注");
		cdata.addOperateData("OrderCode", orderCode);
		List<Map<String, Object>> orderItems=new ArrayList<Map<String,Object>>();
		Map<String, Object> orderItem=null;
		for (UpdateOrdertProductInfo item : items) {
			orderItem = new HashMap<String, Object>();
			
			orderItem.put("BusinessId", item.getOrderPrepareProductId());
			orderItem.put("CustomerRemark", item.getCustomerRemark());  //string
			orderItem.put("CustomerServiceRemark", item.getCsRemark()); //string
			
			orderItems.add(orderItem);
		}
        cdata.addOperateData("OrderItemList", orderItems);

		cdata.writeData(TARGET_DIRECTION_PATH);
	}
	
	public static void main(String[] args) {
		
//		String[] orders=new String[]{
//				"WA161106341110(1)",
//				"WA161106341110(2)",
//				"WA161106341110(3)",
//				"WA161106341110(4)",
//				"WA161106341110(5)",
//				"WA161106341110(6)",
//				"WA161106341110(7)"
//			};
//		for (String string : orders) {
//			cancleOrder(string);
//		}	
//		cancleOrder("WA170227358952");WA170330974446	1
//		WA170330606958	62
//		WA170330941700	62
//		WA170330456437	1
//		WA170331352891	1
//		WA170331212727	62
//		WA170331124449	1
//		WA170331104728	1
//		WA170331482369	62
//		WA170331868073	62
//		WA170331599194	1
//		cancleOrder("WE170508909198");
//		cancleOrder("WA170331104728");
//		cancleOrder("WA170331599194");
//		cancleOrder("WA170331352891");
//		cancleOrder("BC180507314063");
		
//		requestCheckOrder("WA180307230534");
//		requestCheckOrder("WA180307622634");
		
//		
		orderApplayCancle("WA180622190258", "王宏伟", "ite01485");
//		orderApplayCancle("WA170330606958", "王宏伟", "ite01485");
//		orderApplayCancle("WA170331212727", "王宏伟", "ite01485");
//		orderApplayCancle("WA170331482369", "王宏伟", "ite01485");
//		orderApplayCancle("WA170331868073", "王宏伟", "ite01485");
//		orderApplayCancle("WA160507602642", "王宏伟", "ite01485");
//		orderApplayCancle("WA161212327340", "OSMS系统", "");
//		cancleOrderItem("WA170601191542", 1, "433286", "0");
	}

	public static void addOrderItems(String remark, String orderCode, int orderStatus, 
			List<OrderPrepareProductPO> items,
			List<OrderProductPO> orderProducts,int shopType){
		CData cdata = new CData("OrderItem.Add", TO_CMS_DIR, "addOrderItem");

		// 订单
		cdata.addOperateData("OrderCode", orderCode); // string
		cdata.addOperateData("OrderStatus", orderStatus); // int

		// 新增订单项
		List<Map<String, Object>> orderItems=new ArrayList<Map<String,Object>>();
		
		for (int i = 0; i < items.size(); i++) {
			Map<String, Object> orderItem = new HashMap<String, Object>();
			OrderPrepareProductPO item=items.get(i);
			OrderProductPO orderProduct=orderProducts.get(i);
			
			orderItem.put("BusinessId", item.getId()); // int
			
			orderItem.put("ProductId", item.getCmsProductId()); // int
			orderItem.put("OrderQuantity", item.getOrderQty() * item.getUnitQty()); // int
			orderItem.put("Unit", item.getUnit()); // string
			orderItem.put("UnitQuantity", item.getUnitQty()); // int
			orderItem.put("Weight", item.getUnitWeight() == null ? 0 : item.getUnitWeight()); // decimal
			orderItem.put("Volume", item.getUnitVolume() == null ? 0 : item.getUnitVolume()); // decimal
			// ?
			orderItem.put("Type", 1); // int
			// 是否促销
			orderItem.put("IsPromote", orderProduct.getShopDiscount() > 0); // bool
			orderItem.put("SalePrice", 
					DMSUtils.convert2USD(new BigDecimal(orderProduct.getShopItemPrice())
							,orderProduct.getShopItemCurtype())); // decimal
			//批量价格，原价
			orderItem.put("ItemPrice",
					DMSUtils.convert2USD(new BigDecimal(orderProduct.getShopItemPrice()-orderProduct.getShopDiscount()
							).divide(BigDecimal.valueOf(item.getOrderQty()),4,4)
					,orderProduct.getShopItemCurtype())); // 售价
			orderItem.put("CustomerRemark", item.getCustomerRemark()); // string 订单备注
			orderItem.put("CustomerServiceRemark", item.getCsRemark()); // string
			orderItem.put("ProcessingStatus", 10); // int
			
			if(shopType==ShopType.EBAY.getVal()){
				orderItem.put("TransactionID", orderProduct.getTransactionId());
				orderItem.put("ItemID", orderProduct.getShopOrderItemId());
				orderItem.put("ItemTitle", orderProduct.getShopItemTitle());
			}else{
				orderItem.put("TransactionID", "");
				orderItem.put("ItemID", "");
				orderItem.put("ItemTitle", "");
			}
			orderItems.add(orderItem);
		}

		cdata.addOperateData("OrderItemList", orderItems);

		cdata.writeData(TARGET_DIRECTION_PATH);
	}
	
	/**
	 * 增加订单项 
	 * 
	 * @param orderCode
	 * @param orderStatus
	 * @param item
	 */
	public static void addOrderItem(String remark, String orderCode, 
			int orderStatus, OrderPrepareProductPO item,
			OrderProductPO orderProduct,int shopType) {
		CData cdata = new CData("OrderItem.Add", TO_CMS_DIR, "addOrderItem");

		// 订单
		cdata.addOperateData("OrderCode", orderCode); // string
		cdata.addOperateData("OrderStatus", orderStatus); // int

		// 新增订单项
		Map<String, Object> orderItem = new HashMap<String, Object>();

		orderItem.put("BusinessId", item.getId()); // int

		orderItem.put("ProductId", item.getCmsProductId()); // int
		orderItem.put("OrderQuantity", item.getOrderQty() * item.getUnitQty()); // int
		orderItem.put("Unit", item.getUnit()); // string
		orderItem.put("UnitQuantity", item.getUnitQty()); // int
		orderItem.put("Weight", item.getUnitWeight() == null ? 0 : item.getUnitWeight()); // decimal
		orderItem.put("Volume", item.getUnitVolume() == null ? 0 : item.getUnitVolume()); // decimal
																							// ?
		orderItem.put("Type", 1); // int
		orderItem.put("IsPromote", orderProduct.getShopDiscount() > 0); // bool
																		// 是否促销
		orderItem.put("SalePrice", 
				DMSUtils.convert2USD(new BigDecimal(orderProduct.getShopItemPrice())
						,orderProduct.getShopItemCurtype())); // decimal
																// 批量价格，原价
		orderItem.put("ItemPrice",
				DMSUtils.convert2USD(new BigDecimal(orderProduct.getShopItemPrice()-orderProduct.getShopDiscount()
						).divide(BigDecimal.valueOf(item.getOrderQty()),4,4)
				,orderProduct.getShopItemCurtype())); // 售价
		orderItem.put("CustomerRemark", item.getCustomerRemark()); // string 订单备注
		orderItem.put("CustomerServiceRemark", item.getCsRemark()); // string
		orderItem.put("ProcessingStatus", 10); // int
		
		
		if(shopType==ShopType.EBAY.getVal()){
			orderItem.put("TransactionID", orderProduct.getTransactionId());
			orderItem.put("ItemID", orderProduct.getShopOrderItemId());
			orderItem.put("ItemTitle", orderProduct.getShopItemTitle());
		}else{
			orderItem.put("TransactionID", "");
			orderItem.put("ItemID", "");
			orderItem.put("ItemTitle", "");
		}
		
		
		List<Map<String, Object>> orderItems=new ArrayList<Map<String,Object>>();
		orderItems.add(orderItem);
		cdata.addOperateData("OrderItemList", orderItems);

		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 修改需质检标识
	 * 
	 * @param orderCode
	 * @param isQualityInspection
	 */
	public static void setQualityInspection(String orderCode, boolean isQualityInspection) {
		CData cdata = new CData("Order.SetQuality", TO_CMS_DIR, "setQualityInspection");
		cdata.addOperateData("OrderCode", orderCode);
		cdata.addOperateData("IsQualityInspection", isQualityInspection);
		cdata.writeData(TARGET_DIRECTION_PATH);
	}
	
	public static void orderApplayCancle(String orderCodes, String applayUserName, String applayUserCode) {
		CData cdata = new CData("Order.CancleApplay", TO_CMS_DIR, "订单申请取消");
		cdata.addOperateData("OrderCodes", orderCodes);
		cdata.addOperateData("ApplayUserName", applayUserName);
		cdata.addOperateData("ApplayUserCode", applayUserCode);
		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	public static void orderApplayResend(String orderCodes, String applayUserName, String applayUserCode) {
		CData cdata = new CData("Order.ResendApplay", TO_CMS_DIR, "订单申请重发");
		cdata.addOperateData("OrderCodes", orderCodes);
		cdata.addOperateData("ApplayUserName", applayUserName);
		cdata.addOperateData("ApplayUserCode", applayUserCode);
		cdata.writeData(TARGET_DIRECTION_PATH);
	}
	
	/**
	 * 退件申请上架
	 * @param orderCodes
	 * @param applayUserName
	 * @param applayUserCode
	 */
	public static void orderApplyPutway(String orderCodes){
		//"OSMS系统",""Order.ShelveApplay
		CData cdata = new CData("Order.ShelveApplay", TO_CMS_DIR, "订单申请上架");
		cdata.addOperateData("OrderCodes", orderCodes);
		cdata.addOperateData("ApplayUserName", "OSMS系统");
		cdata.addOperateData("ApplayUserCode", "");
		cdata.writeData(TARGET_DIRECTION_PATH);
	}
	
	/**
	 * 更新变更单状态
	 * @param orderModifyRecordId
	 * @param remark
	 * @param status
	 */
	public static void UpdateOrderModifyRecordStatus(int orderModifyRecordId, String remark, int status) {
		CData cdata = new CData("Order.UpdateModificatoryRecordStatus", TO_CMS_DIR, "修改订单变更单的状态");

		cdata.addOperateData("Id", orderModifyRecordId);
		cdata.addOperateData("Status", status);
		cdata.addOperateData("Remark", remark);

		cdata.writeData(TARGET_DIRECTION_PATH);
	}
}
