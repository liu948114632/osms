package com.itecheasy.communication.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.communication.util.CData;
import com.itecheasy.core.CurrencyUtils;
import com.itecheasy.core.fba.ReplenishmentOrder;
import com.itecheasy.core.fba.ReplenishmentOrderDetail;
import com.itecheasy.core.fba.ReplenishmentOrderItem;
import com.itecheasy.core.fba.Repository;
import com.itecheasy.core.fba.UpdateOrdertProductInfo;
import com.itecheasy.core.system.ShopDevInfo;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.webservice.client.DMSUtils;

/**
 * @author wanghw
 * @date 2015-5-9
 * @description 通讯cms
 * @version
 */
public class CommandReplenishment2CMS {
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

	public static void updateOrderProductAmount(String orderCode,double costPrice,Double costFreight) {
		CData cdata = new CData("Order.OrderProductAmount", TO_CMS_DIR, "updateOrderProductAmount");
		cdata.addOperateData("OrderId", orderCode);
		cdata.addOperateData("OrderProductAmount",
				DMSUtils.convert2USD(new BigDecimal(costPrice),CurrencyUtils.RMB));
		cdata.addOperateData("Freight", costFreight==null?0:DMSUtils.convert2USD(new BigDecimal(costFreight), 7));

		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	public static void addOrder(ReplenishmentOrderDetail detail, ShopInfo info,ShopDevInfo dev) {
		CData cdata = new CData("Order.add", TO_CMS_DIR, "add new order");
		Map<String, Object> orderInfo = new HashMap<String, Object>();
		orderInfo.put("OrderCode", detail.getReplenishmentOrder().getCode());
		orderInfo.put("CmsOrderType", 27); // string
		orderInfo.put("CustomerId", info.getCustomerId()); // int
		orderInfo.put("PayStatus", ALL_PAY); // int 默认全部付款
		orderInfo.put("PriorityLevel", 1); // int 订单优先级
		orderInfo.put("IsRemote", false); // bool
		orderInfo.put("IsOverSea", false); // bool 是否海外仓
		orderInfo.put("IsCanDeliver", detail.getReplenishmentOrder().getIsSend()); // bool
																					// 可发货标识
		orderInfo.put("IsNeedProcessing", false); // bool 是否需要加工
		orderInfo.put("DeliveryId", detail.getReplenishmentOrder().getShippingMethod()); // int
																							// 货运方式
		orderInfo.put("MerchandiserId", detail.getReplenishmentOrder().getMerchandiserId()); // int
																								// 跟单员
		orderInfo.put("OrderDiscount", 1); // decimal 订单折扣
		orderInfo.put("IsQualityInspection", detail.getReplenishmentOrder().getIsQualityInspection() == 1 ? true
				: false);// 质检
		orderInfo.put("IsFirstWebOrder", false);
		orderInfo.put("IsFreeShipping", false);// 不免运费
		orderInfo.put("FreeShippingDeliveryIds", "");
		orderInfo.put("CpfCode", detail.getReplenishmentOrder().getCPFCode());// 税号
		orderInfo.put("AutoDelayDate", detail.getReplenishmentOrder().getEarliestShippingDate());// 预计发货日期
		orderInfo.put("CustomerServiceRemark", detail.getReplenishmentOrder().getRemark()); // string
		orderInfo.put("ShippingRemind", detail.getReplenishmentOrder().getDeliveryRemark()); // string
																								// 发货备注

		orderInfo.put("TaxCodeType", detail.getReplenishmentOrder().getCPFType() == null ? 0 : detail
				.getReplenishmentOrder().getCPFType());// 税号类型---------------------
		orderInfo.put("DmsInvoiceRemark", "");// DMS发票备注
		orderInfo.put("SubTotalPercent", detail.getReplenishmentOrder().getSubTotalPercent());// 发票金额百分比
		orderInfo.put("IsIncludeShippingFee", false);// 是否报运费
		orderInfo.put("CustomsClearanceProportion ", 0);// 报关运费百分比
		orderInfo.put("Freight", 0);// 运费

		orderInfo.put("SellUserID", dev.getSellerID());// 卖家销售ID
		orderInfo.put("ShipmentId", detail.getReplenishmentOrder().getShipmentID());
		orderInfo.put("EbayBuyEmail", "");// Ebay买家邮箱
		orderInfo.put("SellRecordNumber", "");// 销售记录号
		orderInfo.put("BuyUserId", "");// 卖家ID，传的客户名称
		orderInfo.put("OrderProductAmount",  
				DMSUtils.convert2USD(new BigDecimal(detail.getReplenishmentOrder().getCostPrice()),CurrencyUtils.RMB)
		); // 订单商品总金额，排除现金券的金额
		orderInfo.put("TransactionId", "");// 支付凭证,随便获取一个支付信息，
		orderInfo.put("TransactionTime", "");

		cdata.addOperateData("Order", orderInfo);

		// 新增订单项
		List<Map<String, Object>> orderItemList = new ArrayList<Map<String, Object>>();
		Map<String, Object> orderItem = null;
		if (CollectionUtils.isNotEmpty(detail.getReplenishmentOrderItems())) {
			for (ReplenishmentOrderItem item : detail.getReplenishmentOrderItems()) {
				if (item.getStatus() == 12) {
					//  非C3备货的订单商品不通讯到C3
					continue;
				}
				orderItem = new HashMap<String, Object>();

				orderItem.put("BusinessId", item.getId()); // int
				orderItem.put("ProductId", item.getCmsProductId()); // int
				orderItem.put("OrderQuantity", item.getOrderedQuantity() * item.getUnitQty()); // int
				orderItem.put("Unit", item.getUnit()); // string
				orderItem.put("UnitQuantity", item.getUnitQty()); // int
				orderItem.put("Weight", item.getUnitWeight() == null ? 0 : item.getUnitWeight()); // decimal
				orderItem.put("Volume", item.getUnitVolume() == null ? 0 : item.getUnitVolume()); // decimal
																									// ?
				orderItem.put("Type", 1); // int
				orderItem.put("IsPromote", false); // bool
													// 是否促销
				orderItem.put("SalePrice", 0); // decimal
												// 批量价格，原价
				orderItem.put("ItemPrice", DMSUtils.convert2USD(BigDecimal.valueOf(item.getCostPrice()/item.getOrderedQuantity()), CurrencyUtils.RMB)); // 售价
				orderItem.put("CustomerRemark", item.getCustomerRemark()); // string
				orderItem.put("CustomerServiceRemark", item.getCsRemark()); // string
				orderItem.put("ProcessingStatus", 10); // int

				orderItem.put("TransactionID", "");
				orderItem.put("ItemID", item.getSku());
				orderItem.put("ItemTitle", "");
				orderItem.put("FbaBarCode", item.getFbaBarcodeSku());
				orderItem.put("FbaBarTitle", item.getFbaBarcodeName());
				orderItem.put("FbaBarNew", info.getFbaBarcodeKey());
//				FbaBarCode   FbaBarTitle
				orderItemList.add(orderItem);
			}
			// 货运地址
			Repository oa = detail.getRepository();
			Map<String, Object> shippingAddress = new HashMap<String, Object>();
			shippingAddress.put("Firstname", detail.getRepository().getName()); // string
			shippingAddress.put("Lastname", ""); // string
			shippingAddress.put("Address1",
					StringUtils.isEmpty(oa.getAddressLine1()) ? oa.getAddressLine2() : oa.getAddressLine1()); // string
			shippingAddress.put("Address2", oa.getAddressLine2()); // string
			shippingAddress.put("City", oa.getCity()); // string
			shippingAddress.put("State", oa.getStateOrRegion()); // string
			shippingAddress.put("CountryId", oa.getCountryId()); // int
			shippingAddress.put("Zip", oa.getPostalCode()); // string
			shippingAddress.put("Phone", StringUtils.isNotEmpty(oa.getPhone()) ? oa.getPhone() : "000-0000-0000"); // string
			shippingAddress.put("Fax", ""); // string
			shippingAddress.put("Port", ""); // string
			shippingAddress.put("CompanyName", "");// string
			shippingAddress.put("TaxCodeType", detail.getReplenishmentOrder().getCPFType() == null ? 0 : detail
					.getReplenishmentOrder().getCPFType());// 税号类型 、本系统初始没有税号
			shippingAddress.put("CpfCode", detail.getReplenishmentOrder().getCPFCode() == null ? "" : detail
					.getReplenishmentOrder().getCPFCode());// 税号
			shippingAddress.put("DestinationFulfillmentCenterId", detail.getRepository().getRepositoryName());
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
	 * @param order
	 * @param OperatorName
	 * @param shippingRemind 发货说明
	 */
	public static void updateOrder(ReplenishmentOrder order, String OperatorName) {
		CData cdata = new CData("Order.Update", TO_CMS_DIR, "updateOrder");
		cdata.addOperateData("OrderCode", order.getCode());
		cdata.addOperateData("PayStatus", ALL_PAY);
		cdata.addOperateData("OrderLevel", 1);
		cdata.addOperateData("IsSend", order.getIsSend());
		cdata.addOperateData("HandlerId", order.getMerchandiserId()); // 跟单员
		cdata.addOperateData("CustomerServiceRemark", order.getRemark());// 订单备注
		cdata.addOperateData("ShippingRemind", order.getDeliveryRemark()); // string 发货说明
		cdata.addOperateData("IsNeedProcessing", false);
		cdata.addOperateData("CpfCode", order.getCPFCode());
		cdata.addOperateData("OperatorName", OperatorName);

		cdata.addOperateData("IsRemote", false); // bool 是否偏远
		cdata.addOperateData("TaxCodeType", order.getCPFType() == null ? 0 : order.getCPFType());// 税号类型
		cdata.addOperateData("DmsInvoiceRemark", "");// DMS发票备注
		cdata.addOperateData("SubTotalPercent", order.getSubTotalPercent());// 发票金额百分比
		cdata.addOperateData("IsIncludeShippingFee", false);// 是否报运费
		cdata.addOperateData("CustomsClearanceProportion", 0);// 报关运费百分比
		cdata.addOperateData("Freight", 0);// 运费

		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 订单同票
	 * 
	 * @param sendGroupId
	 * @param OrderCodes
	 */
	public static void updateOrderGroup(int sendGroupId, String OrderCodes, String OperatorName) {
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
	public static void removeOrderGroup(String OrderCodes, String OperatorName) {
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
	public static void updateOrderDelivery(String orderCode, int deliveryId, Double shopShippingPrice, int currency) {
		CData cdata = new CData("Order.UpdateDelivery", TO_CMS_DIR, "updateOrderDelivery");
		cdata.addOperateData("OrderCode", orderCode);
		cdata.addOperateData("DeliveryId", deliveryId);
		cdata.addOperateData("IsFreeShipping", false);
		cdata.addOperateData("FreeShippingDeliveryIds", "");
		cdata.addOperateData("Freight", DMSUtils.convert2USD(new BigDecimal(shopShippingPrice), currency));// 运费
		cdata.writeData(TARGET_DIRECTION_PATH);
	}

	/**
	 * 修改货运地址
	 * 
	 * @param orderId
	 * @param Orderaddress
	 *            UpdateShippingInfo
	 */
	public static void updateOrderaddress(String orderCode, Repository oa, boolean isRemote,
			Integer CPFType,String CPFCode,String customName,String repositoryName) {
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
		cdata.addOperateData("DestinationFulfillmentCenterId", repositoryName);
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
	public static void updateOrderIsCanSend(String orderCode, boolean isSend, String OperatorName) {
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
	public static void CompleteOrder(String orderCode) {
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

	public static void updateOrderItemQuantityToCMS(String orderId, int orderStatus, int bussinessId, double qty) {
		CData cdata = new CData("OrderItem.UpdateOrderQuantity", TO_CMS_DIR, "更新订单商品订购量");
		cdata.addOperateData("OrderCode", orderId);
		cdata.addOperateData("OrderStatus", orderStatus);
		cdata.addOperateData("BussinessId", bussinessId);
		cdata.addOperateData("OrderQuantity", qty);
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

		// String[] orders=new String[]{
		// "WA161106341110(1)",
		// "WA161106341110(2)",
		// "WA161106341110(3)",
		// "WA161106341110(4)",
		// "WA161106341110(5)",
		// "WA161106341110(6)",
		// "WA161106341110(7)"
		// };
		// for (String string : orders) {
		// cancleOrder(string);
		// }
		cancleOrder("WE170530149754");
//		cancleOrderItem("WA170511241006", 1, "404957", "0");
		// orderApplayCancle("WA160913651880", "王宏伟", "ite01485");
		// orderApplayCancle("WA160507602642", "王宏伟", "ite01485");
	}

	public static void addOrderItems(String remark, String orderCode, int orderStatus,
			List<ReplenishmentOrderItem> items,String fbaBarcodeKey) {
		CData cdata = new CData("OrderItem.Add", TO_CMS_DIR, "addOrderItem");

		// 订单
		cdata.addOperateData("OrderCode", orderCode); // string
		cdata.addOperateData("OrderStatus", orderStatus); // int

		// 新增订单项
		List<Map<String, Object>> orderItems = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < items.size(); i++) {
			Map<String, Object> orderItem = new HashMap<String, Object>();
			ReplenishmentOrderItem item = items.get(i);

			orderItem.put("BusinessId", item.getId()); // int

			orderItem.put("ProductId", item.getCmsProductId()); // int
			orderItem.put("OrderQuantity", item.getOrderedQuantity() * item.getUnitQty()); // int
			orderItem.put("Unit", item.getUnit()); // string
			orderItem.put("UnitQuantity", item.getUnitQty()); // int
			orderItem.put("Weight", item.getUnitWeight() == null ? 0 : item.getUnitWeight()); // decimal
			orderItem.put("Volume", item.getUnitVolume() == null ? 0 : item.getUnitVolume()); // decimal
			// ?
			orderItem.put("Type", 1); // int
			// 是否促销
			orderItem.put("IsPromote", false); // bool
			orderItem.put("SalePrice", 0); // decimal
			// 批量价格，原价
			orderItem.put("ItemPrice", DMSUtils.convert2USD(BigDecimal.valueOf(item.getCostPrice()/item.getOrderedQuantity()), CurrencyUtils.RMB)); // 售价
			orderItem.put("CustomerRemark", item.getCustomerRemark()); // string 订单备注
			orderItem.put("CustomerServiceRemark", item.getCsRemark()); // string
			orderItem.put("ProcessingStatus", 10); // int

			orderItem.put("TransactionID", "");
			orderItem.put("ItemID", item.getSku());
			orderItem.put("ItemTitle", "");
			orderItem.put("FbaBarCode", item.getFbaBarcodeSku());
			orderItem.put("FbaBarTitle", item.getFbaBarcodeName());
			orderItem.put("FbaBarNew", fbaBarcodeKey);
			orderItems.add(orderItem);
		}

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
	 * 
	 * @param orderCodes
	 * @param applayUserName
	 * @param applayUserCode
	 */
	public static void orderApplyPutway(String orderCodes) {
		// "OSMS系统",""Order.ShelveApplay
		CData cdata = new CData("Order.ShelveApplay", TO_CMS_DIR, "订单申请上架");
		cdata.addOperateData("OrderCodes", orderCodes);
		cdata.addOperateData("ApplayUserName", "OSMS系统");
		cdata.addOperateData("ApplayUserCode", "");
		cdata.writeData(TARGET_DIRECTION_PATH);
	}
}
