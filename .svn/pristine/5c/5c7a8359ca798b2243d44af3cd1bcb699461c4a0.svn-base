package com.itecheasy.communication.order;

import java.util.ArrayList;
import java.util.List;

import com.itecheasy.core.fba.UpdateOrdertProductInfo;
import com.itecheasy.core.order.IBaseOrder;
import com.itecheasy.core.order.Order;
import com.itecheasy.core.order.OrderAddress;
import com.itecheasy.core.order.OrderDetail;
import com.itecheasy.core.po.OrderPrepareProductPO;
import com.itecheasy.core.po.OrderProductPO;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.user.User;
import com.itecheasy.webservice.client.DMSUtils;

/** 
 * @author whw
 * @date 2017-8-2 
 * @description 订单通讯工具类
 * @version 
 */
public class CommandOrderUtils {
	public static boolean addOrder(OrderDetail detail, ShopInfo info,boolean isAuto){
		if(detail.getCmsPrepare()==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.addOrder(detail, info);
		}else if(detail.getCmsPrepare()==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			return Command2SW.addOrder(detail, info,isAuto);
		}
		
		return true;
	}
	
	
	public static void cancleOrder(String orderCode,User operator,int orderPrepareType) {
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.cancleOrder(orderCode);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.cancelOrder(orderCode, operator);
		}
	}
	
	public static void requestCheckOrder(String orderCode,int orderPrepareType) {
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.requestCheckOrder(orderCode);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
		}
	}
	
	public static void setQualityInspection(String orderCode, boolean isQualityInspection,int orderPrepareType){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.setQualityInspection(orderCode, isQualityInspection);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
		}
	}
	
	public static void updateOrderIsCanSend(String orderCode, boolean isSend,String OperatorName,int orderPrepareType) {
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.updateOrderIsCanSend(orderCode, isSend, OperatorName);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateSendMark(orderCode, isSend);
		}
	}
	
	
	public static void updateOrderProductAmount(String orderCode,int currency,Double orderAmout,Double shopShippingPrice
			,int orderPrepareType){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.updateOrderProductAmount(orderCode, currency, orderAmout, shopShippingPrice);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateOrderAmont(orderCode, currency, orderAmout, shopShippingPrice);
		}
	}
	
	public static void updateOrderItemRemarkToCMS(String orderCode,
			List<UpdateOrdertProductInfo> items,int orderPrepareType
			){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.updateOrderItemRemarkToCMS(orderCode, items);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateOrderProductRemark(orderCode, items);
		}
	}
	
	public static void updateOrder(Order order,String OperatorName,String shippingRemind,int orderPrepareType){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.updateOrder(order, OperatorName, shippingRemind);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateRemark(order.getCode(), shippingRemind, 
					order.getCPFCode(), order.getRemark(),
					DMSUtils.getThreshold(order.getOrderCurrency(), 
							order.getOrderAmount()-order.getShopShippingPrice(),order.getShippingMethod()));
		}
	}
	
	public static void addOrderItems(String remark, String orderCode, int orderStatus, 
			List<OrderPrepareProductPO> items,
			List<OrderProductPO> orderProducts,int shopType,int orderPrepareType){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.addOrderItems(remark, orderCode, orderStatus, items, orderProducts, shopType);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.addOrderProduct(orderCode, items, orderProducts);
		}
	}
	
	public static void updateOrderItemQuantity(String orderCode, int orderStatus,
			int orderPrepareProductId,double orderedQty,int unitQty
			,int orderPrepareType ,double shopItemPrice,int shopItemCurType
			) {
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.updateOrderItemQuantityToCMS(orderCode, orderStatus, orderPrepareProductId, unitQty*orderedQty);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateDemandQty(orderCode, orderPrepareProductId,shopItemPrice,shopItemCurType ,(int)orderedQty);
		}
	}
	
	public static void updateOrderaddress(String orderCode, OrderAddress oa, boolean isRemote,
			Integer CPFType,String CPFCode,int orderPrepareType ){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.updateOrderaddress(orderCode, oa, isRemote, CPFType, CPFCode);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateOrderAddress(orderCode, oa, CPFType, CPFCode, isRemote);
		}
	}
	
	public static void updateOrderDelivery(String orderCode, int deliveryId,Double shopShippingPrice,int currency,
			int orderPrepareType){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.updateOrderDelivery(orderCode, deliveryId, shopShippingPrice, currency);
		}else if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_SW){
			Command2SW.updateShippingMethod(orderCode, deliveryId);
		}
	}
	
	public static void cancleOrderItem(String orderCode, int orderStatus,
			String cancleOrderItemIds, String cancelReason,int orderPrepareType){
		if(orderPrepareType==IBaseOrder.ORDER_PREPARE_TYPE_CMS){
			Command2CMS.cancleOrderItem(orderCode, orderStatus, cancleOrderItemIds, cancelReason);
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
