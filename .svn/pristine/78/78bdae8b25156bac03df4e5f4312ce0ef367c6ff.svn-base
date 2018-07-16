package com.itecheasy.core.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.fba.ROrderSwMessageService;
import com.itecheasy.core.order.IOrderSchedule.OrderTableType;
import com.itecheasy.core.po.OrderPO;
import com.itecheasy.core.po.OrderPrepareProductPO;
import com.itecheasy.core.task.BaseOrderView;
import com.itecheasy.webservice.client.SwOrderClient;
import com.itecheasy.webservice.sw.ArrivalStatus;
import com.itecheasy.webservice.sw.Notification;
import com.itecheasy.webservice.sw.NotificationType;

/** 
 * @author whw
 * @date 2017-8-3 
 * @description TODO
 * @version 
 */
public class OrderSwMessageServiceImpl extends OrderServiceImpl implements OrderSwMessageService {
	private OrderMessageService orderMessageService;
	private IOrderSchedule orderSchedule;
	private ROrderSwMessageService rOrderSwMessageService;
	
	public void setrOrderSwMessageService(ROrderSwMessageService rOrderSwMessageService) {
		this.rOrderSwMessageService = rOrderSwMessageService;
	}

	public void setOrderSchedule(IOrderSchedule orderSchedule) {
		this.orderSchedule = orderSchedule;
	}

	public void setOrderMessageService(OrderMessageService orderMessageService) {
		this.orderMessageService = orderMessageService;
	}

	@Override
	public int readMessage(int maxId) {
		int _maxId=maxId;
		List<Notification> notifications=SwOrderClient.readMessage(maxId);
		if(CollectionUtils.isNotEmpty(notifications)){
			for (Notification notification : notifications) {
				if(_maxId<notification.getId())
					_maxId=notification.getId();
				
				
				String objectCode=notification.getObjectCode();
				 BaseOrderView order = orderSchedule.getOrderByCode(objectCode);
				if(order==null) continue;
				
				if(order.getTableType()==OrderTableType.ORDER.getVal())
					 processSW(notification, order);
				else if(order.getTableType()==OrderTableType.REPLENISHMENT_ORDER.getVal())
					rOrderSwMessageService.processSW(notification, order);
					
			}
		}
		return _maxId;
	}

	@Override
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
			orderMessageService.updateDeliveryCustomerService(order.getCode(), 
					message.getString(KEY_DELIVERY_CUSTOMER_SERVICE), 
					getOperator(operator), notification.getCreatedTime().toGregorianCalendar().getTime());
		}else if(notification.getType()==NotificationType.ORDER_DELIVERY){//订单发货(全部发货)
			allDelivery(order.getId(),
					DateUtils.convertDate(message.getString(KEY_DELIVERY_DATE),YYYY_MM_DD_HH_MM_SS),
					null, message.getDouble(KEY_FREIGHT), operator);
		}else if(notification.getType()==NotificationType.UPDATE_TRACE_CODE){//更新发货信息
			orderMessageService.updateTraceCode(order.getCode(), message.getString(KEY_TRACE_CODE),
					StringUtils.isEmpty(operator)?"SW":operator, 
					notification.getCreatedTime().toGregorianCalendar().getTime(), "");
			delivering2WS3rdProxy(order.getId());
		}
	}
	
	public void packageDelivery(int orderId,String packageCode,Date deliveryDate,String traceCode,double freight,
			String operator){
		OrderPO order=orderDao.getObject(orderId);
		delivery( deliveryDate, traceCode, freight, order);
		addOrderOperateLog(SW_MESSAGE+packageCode+"包裹发货"+traceCode, getOperator(operator), orderId);
	}
	
	public void allDelivery(int orderId,Date deliveryDate,String traceCode,double freight,
			String operator){
		OrderPO order=orderDao.getObject(orderId);
		delivery(deliveryDate, traceCode, freight, order);
		addOrderOperateLog(SW_MESSAGE+"全部发货", getOperator(operator), orderId);
	}

	private void delivery(Date deliveryDate, String traceCode, double freight, OrderPO order) {
		if(order.getDeliveryDate()==null){
			order.setDeliveryDate(deliveryDate);
		}
		order.setCostFreight(freight);
		
		if(order.getTrackingCode()==null||
				!order.getTrackingCode().equals(traceCode)){
			delivering2WS3rdProxy(order.getId());
		}
		if(StringUtils.isNotEmpty(traceCode))
			order.setTrackingCode(traceCode);
		if(order.getStatus()<OrderStatus.已发货.getVal()){
			order.setStatus(OrderStatus.已发货.getVal());
		}
		
		orderDao.mergeObject(order);
	}
	
	public void updateOrderStatus(int orderId,String orderArrivalStatus,String orderStatus,String operator){
		OrderPO order=orderDao.getObject(orderId);
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
		OrderPO order=orderDao.getObject(orderId);
		OrderPrepareProductPO po=orderPrepareProductDao.getObject(orderPrepareProductId);
		com.itecheasy.webservice.sw.OrderProductStatus swStatus=
				com.itecheasy.webservice.sw.OrderProductStatus.fromValue(orderProductStatus);
		
		if(po.getPrepareQty()!=readyQty){
			po.setPrepareQty(readyQty);
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
		OrderPO po=orderDao.getObject(orderId);
		String log=SW_MESSAGE+packageCode+"包裹出库";
		
		for (Integer id : orderPrepareProductIds) {
			OrderPrepareProductPO ppo=orderPrepareProductDao.getObject(id);
			ppo.setSwPackageStockOut(true);
			
			orderPrepareProductDao.updateObject(ppo);
		}
		
		String hql="from OrderPrepareProductPO where orderId=? and status!=12 and (swPackageStockOut=null or swPackageStockOut=false)";
		if(CollectionUtils.isEmpty(orderPrepareProductDao.findListByHql(hql, orderId))){
			//订单中所有包裹都出库了，更新osms订单状态为已出库；
			po.setStatus(OrderStatus.已出库.getVal());
			po.setOutDate(messageDate);
			addOrderOperateLog(log+",已全部出库,更新订单状态：已出库", operator, orderId);
		}else{
			if(po.getStatus()<OrderStatus.校对中.getVal()){
				po.setStatus(OrderStatus.校对中.getVal());//	sw系统订单中任意包裹出库，更新osms订单状态为校对中；
				log=log+",更新订单状态：校对中";
			}
			addOrderOperateLog(log, operator, orderId);
		}
	}
	
}
