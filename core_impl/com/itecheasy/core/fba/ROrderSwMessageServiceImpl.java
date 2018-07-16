package com.itecheasy.core.fba;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itecheasy.core.po.OrderPO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.order.OrderService.OrderProductStatus;
import com.itecheasy.core.order.OrderService.OrderStatus;
import com.itecheasy.core.po.ReplenishmentOrderItemPO;
import com.itecheasy.core.po.ReplenishmentOrderPO;
import com.itecheasy.core.task.BaseOrderView;
import com.itecheasy.webservice.sw.ArrivalStatus;
import com.itecheasy.webservice.sw.Notification;
import com.itecheasy.webservice.sw.NotificationType;

/** 
 * @author whw
 * @date 2017-8-3 
 * @description TODO
 * @version 
 */
public class ROrderSwMessageServiceImpl extends ReplenishmentOrderServiceImpl implements ROrderSwMessageService {
	private ReplenishmentOrderMessageService replenishmentOrderMessageService;
	
	public void setReplenishmentOrderMessageService(ReplenishmentOrderMessageService replenishmentOrderMessageService) {
		this.replenishmentOrderMessageService = replenishmentOrderMessageService;
	}

	public void processSW(Notification notification, BaseOrderView order) {
		JSONObject message=JSONObject.fromObject(notification.getMessage());
		String operator="";
		if(message.containsKey(KEY_OPERATOR_NAME))
			operator = message.getString(KEY_OPERATOR_NAME);
		if(notification.getType()==NotificationType.ORDER_PACKAGE_OUT){//订单包裹出库
			//订单中所有包裹都出库了，更新osms订单状态为已出库；
			JSONArray jList=message.getJSONArray(KEY_BUSINESS_ID_LIST);
			List<Integer> ids=new ArrayList<Integer>();
			for (Object object : jList.toArray()) {
				ids.add(Integer.parseInt(object.toString()));
			}
			packageOut(order.getId(),message.getString(KEY_PACKAGE_CODE),ids,
					notification.getCreatedTime().toGregorianCalendar().getTime(),
					operator);
		}else if(notification.getType()==NotificationType.ORDER_ITEM_STATUS_CHANGE){//订单项状态
			updateOrderProduct(order.getId(), message.getInt(KEY_BUSINESS_ID), message.getString(KEY_ORDER_PRODUCT_STATUS), 
					message.getInt(KEY_READY_QTY), operator);
		}else if(notification.getType()==NotificationType.ORDER_STATUS_CHANGE){//订单备货状态
			updateOrderStatus(order.getId(), message.getString(KEY_ORDER_ARRIVAL_STATUS),
					message.getString(KEY_ORDER_STATUS), operator);
		}else if(notification.getType()==NotificationType.ORDER_PACKAGE_DELIVERY){//订单包裹发货(部分发货)
			packageDelivery(order.getId(), message.getString(KEY_PACKAGE_CODE),
					DateUtils.convertDate(message.getString(KEY_DELIVERY_DATE),YYYY_MM_DD_HH_MM_SS),
					message.getString(KEY_TRACE_CODE), message.getDouble(KEY_FREIGHT), operator);
		}else if(notification.getType()==NotificationType.SERVICE_CUSTOMER){//货运客服
			replenishmentOrderMessageService.updateDeliveryCustomerService(order.getCode(), 
					message.getString(KEY_DELIVERY_CUSTOMER_SERVICE), 
					getOperator(operator), notification.getCreatedTime().toGregorianCalendar().getTime());
		}else if(notification.getType()==NotificationType.ORDER_DELIVERY){//订单发货(全部发货)
			allDelivery(order.getId(),
					DateUtils.convertDate(message.getString(KEY_DELIVERY_DATE),YYYY_MM_DD_HH_MM_SS),
					null, message.getDouble(KEY_FREIGHT), operator);
		}else if(notification.getType()==NotificationType.UPDATE_TRACE_CODE){//更新发货信息
			replenishmentOrderMessageService.updateTraceCode(order.getCode(), message.getString(KEY_TRACE_CODE),
					StringUtils.isEmpty(operator)?"SW":operator, 
					notification.getCreatedTime().toGregorianCalendar().getTime(), "");
		}
	}
	
	public void packageDelivery(int orderId,String packageCode,Date deliveryDate,String traceCode,double freight,
			String operator){
		ReplenishmentOrderPO order=replenishmentOrderDao.getObject(orderId);
		delivery( deliveryDate, traceCode, freight, order);
		addOrderOperateLog(SW_MESSAGE+packageCode+"包裹发货"+traceCode, getOperator(operator), orderId);
	}
	
	public void allDelivery(int orderId,Date deliveryDate,String traceCode,double freight,
			String operator){
		ReplenishmentOrderPO order=replenishmentOrderDao.getObject(orderId);
		delivery(deliveryDate, traceCode, freight, order);
		addOrderOperateLog(SW_MESSAGE+"全部发货", getOperator(operator), orderId);
	}

	private void delivery(Date deliveryDate, String traceCode, double freight, ReplenishmentOrderPO order) {
		if(order.getDeliveryDate()==null){
			order.setDeliveryDate(deliveryDate);
		}
		order.setCostFreight(freight);
		
		if(order.getTrackingCode()==null||
				!order.getTrackingCode().equals(traceCode)){
		}
		if(StringUtils.isNotEmpty(traceCode))
			order.setTrackingCode(traceCode);
		if(order.getStatus()<OrderStatus.已发货.getVal()){
			order.setStatus(OrderStatus.已发货.getVal());
		}
		
		replenishmentOrderDao.mergeObject(order);
	}
	
	public void updateOrderStatus(int orderId,String orderArrivalStatus,String orderStatus,String operator){
		ReplenishmentOrderPO order=replenishmentOrderDao.getObject(orderId);
		ArrivalStatus arrivalStatus=ArrivalStatus.fromValue(orderArrivalStatus);
		String log=SW_MESSAGE;
		if((arrivalStatus==ArrivalStatus.ALL_ARRIVAL
				&&order.getStatus()<OrderStatus.已备货.getVal())){
			order.setStatus(OrderStatus.已备货.getVal());
			log+="更新订单状态为已备货";
			addOrderOperateLog(log, getOperator(operator), orderId);
		}else if(arrivalStatus!=ArrivalStatus.ALL_ARRIVAL
				&&order.getStatus()!=OrderStatus.准备货物.getVal()){
			order.setStatus(OrderStatus.准备货物.getVal());
			log+="更新订单状态为准备货物";
			addOrderOperateLog(log, getOperator(operator), orderId);
		}
	}
	
	public void updateOrderProduct(int orderId,int orderPrepareProductId,String orderProductStatus,int readyQty, String operator){
		ReplenishmentOrderPO order=replenishmentOrderDao.getObject(orderId);
		ReplenishmentOrderItemPO po=replenishmentOrderItemDao.getObject(orderPrepareProductId);
		com.itecheasy.webservice.sw.OrderProductStatus swStatus=
				com.itecheasy.webservice.sw.OrderProductStatus.fromValue(orderProductStatus);
		
		if(po.getPreparedQuantity()!=readyQty){
			po.setPreparedQuantity(readyQty);
			addOrderOperateLog(SW_MESSAGE+po.getCmsProductCode()+"已备量为"+readyQty, 
					getOperator(operator), orderId);
		}
		
		//以备货变成备货中
		if(swStatus==com.itecheasy.webservice.sw.OrderProductStatus.IN_PREPARATION){//备货中
			if (order != null) {
				if(po.getStatus()==OrderProductStatus.已备货.getVal()){
					order.setOrderItemPrepareNum(order.getOrderItemPrepareNum() -1);
					po.setStatus(OrderProductStatus.备货中.getVal());
				}
			}
		} else
		// 更新到货率
		if (swStatus==com.itecheasy.webservice.sw.OrderProductStatus.PREPARATION) {//已备货
			if (order != null) {
				if(po.getStatus()<=OrderProductStatus.备货中.getVal()){
					order.setOrderItemPrepareNum(order.getOrderItemPrepareNum() + 1);
					po.setStatus(OrderProductStatus.已备货.getVal());
				}
				if (order.getOrderItemPrepareNum() > order.getOrderItemNum()) {
					order.setOrderItemPrepareNum(order.getOrderItemNum());
				}
			}
		}
		
	}

	/**
	 * 消息操作人
	 * @param operator
	 * @return
	 */
	private String getOperator(String operator) {
		return StringUtils.isNotEmpty(operator)?operator:MESSAGE_SOURCE_SYSTEM;
	}
	
	
	public void packageOut(int orderId,String packageCode,List<Integer> orderPrepareProductIds,
			Date messageDate,String operator){
		ReplenishmentOrderPO po=replenishmentOrderDao.getObject(orderId);
		String log=SW_MESSAGE+packageCode+"包裹出库";
		
		for (Integer id : orderPrepareProductIds) {
			ReplenishmentOrderItemPO ppo=replenishmentOrderItemDao.getObject(id);
			ppo.setSwPackageStockOut(true);
			
			replenishmentOrderItemDao.updateObject(ppo);
		}
		
		String hql="from ReplenishmentOrderItemPO where replenishmentOrderId=? and status!=12 and (swPackageStockOut=null or swPackageStockOut=false)";
		if(CollectionUtils.isEmpty(replenishmentOrderItemDao.findListByHql(hql, orderId))){
			//订单中所有包裹都出库了，更新osms订单状态为已出库；
			po.setStatus(OrderStatus.已出库.getVal());
			po.setOutDate(messageDate);
			addOrderOperateLog(log+",已全部出库,更新订单状态：已出库", operator, orderId);
			
			notifyShippingList2OthenSystem(orderId, operator);
		}else{
			if(po.getStatus()<OrderStatus.校对中.getVal()){
				po.setStatus(OrderStatus.校对中.getVal());//	sw系统订单中任意包裹出库，更新osms订单状态为校对中；
				log=log+",更新订单状态：校对中";
			}
			addOrderOperateLog(log, operator, orderId);
		}
	}


}
