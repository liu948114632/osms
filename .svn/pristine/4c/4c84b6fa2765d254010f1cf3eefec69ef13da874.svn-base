package com.itecheasy.communication.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.itecheasy.core.CurrencyUtils;
import com.itecheasy.core.fba.ReplenishmentOrder;
import com.itecheasy.core.fba.ReplenishmentOrderDetail;
import com.itecheasy.core.fba.ReplenishmentOrderItem;
import com.itecheasy.core.fba.Repository;
import com.itecheasy.core.fba.UpdateOrdertProductInfo;
import com.itecheasy.core.order.IBaseOrder;
import com.itecheasy.core.system.ShopDevInfo;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.user.User;

/** 
 * @author whw
 * @date 2017-8-2 
 * @description fba补货订单通讯工具类
 * @version 
 */
public class CommandReplenishmentOrderUtils {
	public static void addReplenishmentOrder(ReplenishmentOrderDetail detail, ShopInfo info,ShopDevInfo dev) {
		if(detail.getReplenishmentOrder().getCmsPrepare()==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.addOrder(detail, info, dev);
		}else if(detail.getReplenishmentOrder().getCmsPrepare()==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.addROrder(detail, info,false);
		}
	}
	
	public static void cancleOrder(String orderCode,User operator,int orderPrepareType) {
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.cancleOrder(orderCode);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.cancelOrder(orderCode, operator);
		}
	}
	
	public static void requestCheckOrder(String orderCode,int orderPrepareType) {
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.requestCheckOrder(orderCode);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
		}
	}
	
	public static void setQualityInspection(String orderCode, boolean isQualityInspection,int orderPrepareType){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.setQualityInspection(orderCode, isQualityInspection);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
		}
	}
	
	public static void updateOrderIsCanSend(String orderCode, boolean isSend,String OperatorName,int orderPrepareType) {
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.updateOrderIsCanSend(orderCode, isSend, OperatorName);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateSendMark(orderCode, isSend);
		}
	}
	
	
	public static void updateOrderProductAmount(String orderCode,Double orderAmout,Double shopShippingPrice
			,int orderPrepareType){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.updateOrderProductAmount(orderCode, orderAmout, shopShippingPrice);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateOrderAmont(orderCode, CurrencyUtils.RMB, orderAmout, shopShippingPrice);
		}
	}
	
	public static void updateOrderItemRemarkToCMS(String orderCode,
			List<UpdateOrdertProductInfo> items,int orderPrepareType
			){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.updateOrderItemRemarkToCMS(orderCode, items);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateOrderProductRemark(orderCode, items);
		}
	}
	
	public static void updateOrder(ReplenishmentOrder order,String OperatorName){
		if(order.getCmsPrepare()==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.updateOrder(order, OperatorName);
		}else if(order.getCmsPrepare()==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateRemark(order.getCode(), order.getDeliveryRemark(), 
					order.getCPFCode(), order.getRemark(),BigDecimal.valueOf(order.getSubTotalPercent())
					);
		}
	}
	
	public static void addOrderItems(String remark, String orderCode, int orderStatus,
			List<ReplenishmentOrderItem> items,String fbaBarcodeKey,int orderPrepareType){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.addOrderItems(remark, orderCode, orderStatus, items,fbaBarcodeKey );
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.addROrderProduct(orderCode, items,fbaBarcodeKey);
		}
	}
	
	public static void updateOrderItemQuantity(String orderCode, int orderStatus,
			int orderPrepareProductId,double orderedQty,int unitQty
			 ,double shopItemPrice,int orderPrepareType
			) {
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.updateOrderItemQuantityToCMS(orderCode, orderStatus, orderPrepareProductId, unitQty*orderedQty);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateDemandQty(orderCode, orderPrepareProductId,shopItemPrice,CurrencyUtils.RMB ,(int)orderedQty);
		}
	}
	
	public static void updateOrderaddress(String orderCode, Repository oa, boolean isRemote,
			Integer CPFType,String CPFCode,String customName,String repositoryName,int orderPrepareType ){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.updateOrderaddress(orderCode, oa, isRemote, CPFType, CPFCode, customName, repositoryName);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateROrderAddress(orderCode, oa, CPFType, CPFCode, isRemote);
		}
	}
	
	public static void updateOrderDelivery(String orderCode, int deliveryId,Double shopShippingPrice,int currency,
			int orderPrepareType){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.updateOrderDelivery(orderCode, deliveryId, shopShippingPrice, currency);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateShippingMethod(orderCode, deliveryId);
		}
	}
	
	public static void cancleOrderItem(String orderCode, int orderStatus,
			String cancleOrderItemIds, String cancelReason,int orderPrepareType){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			CommandReplenishment2CMS.cancleOrderItem(orderCode, orderStatus, cancleOrderItemIds, cancelReason);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			String[] ids=cancleOrderItemIds.split(",");
			List<Integer> list=new ArrayList<Integer>();
			for (String id : ids) {
				list.add(Integer.parseInt(id));
			}
			Command2SW.cancelOrderItem(orderCode, list);
		}
	}
	
	
}
