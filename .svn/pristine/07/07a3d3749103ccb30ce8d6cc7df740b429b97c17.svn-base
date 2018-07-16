package com.itecheasy.core.order;

import java.util.Date;

import com.itecheasy.core.BussinessException;
import com.itecheasy.core.PackageStatus.PackageTraceStatus;
import com.itecheasy.core.task.BaseOrderView;
import com.itecheasy.webservice.cms.order.Order;
import com.itecheasy.webservice.cms.order.OrderItem;

/** 
 * @author wanghw
 * @date 2017-1-11 
 * @description TODO
 * @version 1.2.2
 */
public interface IBaseOrderMessage {
	/**
	 * dms发货消息
	 * @param orderCode
	 * @param traceCode
	 * @param costFreight
	 * @param operateTime
	 */
	void updateDeliveryFromMessage(String orderCode,String traceCode,Double costFreight,Date deliveryDate,
			Date operateTime,String operator,String trackingUrl);
	
	/**
	 * dms修改订单跟踪号
	 * @param orderCode
	 * @param traceCode
	 * @param operator
	 */
	public boolean updateTraceCode(String orderCode,String traceCode,String operator,Date operateTime,String trackingUrl);
	
	/**
	 * dms更新包裹
	 * @param orderId
	 * @param status
	 * @param operator
	 */
	void processPackageStatus(String orderCode,PackageTraceStatus status,String operator,Date operateTime);
	
	/**
	 * dms更新发货成本
	 * @param orderCode
	 * @param freight
	 * @param operator
	 * @return
	 */
	public boolean updateFreight(String orderCode,Double freight,String operator,Date operateTime);
	
	/**
	 * dms修改货运方式
	 * @param orderCode
	 * @param shippingMethodId
	 * @param operator
	 * @param operateTime
	 * @return
	 */
	public boolean updateShippingMethod(String orderCode,int shippingMethodId,String operator,Date operateTime);

	/**
	 * dms更新货运客服
	 * @param orderCode
	 * @param deliveryCustomerServiceName
	 * @param operator
	 * @param operateTime
	 */
	public void updateDeliveryCustomerService(String orderCode, String deliveryCustomerServiceName, String operator,
			Date operateTime);
	

	/**
	 * dms消息，完成订单，通讯cms
	 */
	public void orderComplete(String orderCode,String operator,Date operateTime);
	/************************************************dms**********************************************************/
	
	
	
	/**************************************************cms********************************************************/
	
	/**
	 * 同步订单
	 * @param cmsOrder
	 * @param orderView
	 * @param operatorTime
	 */
	void updateOrderFromMessage(Order cmsOrder, BaseOrderView orderView, Date operatorTime);
	
	/**
	 * 同步订单项
	 * @param cmsOrderItem
	 * @param operatorTime
	 */
	void updateOrderItemFromMessage(OrderItem cmsOrderItem, Date operatorTime);
	
	/**
	 * 修改打回标记
	 * @param orderCode
	 * @param backTag
	 */
	void syncBackTagFromMessage(String orderCode, boolean backTag);
	
	/**
	 * 确认重发订单重发
	 * 
	 * <ul>
	 * 若后端将订单状态改为“已备货”或准备货物
	 * <li>更新订单重发状态为否</li>
	 * <li>记录日志“申请重发成功，订单状态变为已备货/准备货物”</li></ul>
	 * @param orderCode
	 * @param operator
	 * @throws BussinessException
	 */
	void confirmResendOrder(String orderCode,int status,String operator)throws BussinessException;
	
	/**
	 * 拒绝重发
	 * @param orderCode
	 * @param reason
	 * @param type
	 * @param operator
	 * @throws BussinessException
	 */
	void refuseResendOrder(String orderCode,String reason,int type,String operator)throws BussinessException;
	
	
	/**
	 * 设置订单重发（dms申请重发，同步cms消息）
	 * @param orderCode
	 */
	void setResendTagFromMessage(String orderCode,String operator);
	
	/**
	 * 无法取消订单
	 * @param orderId
	 * @param reason
	 * @param operator
	 */
	void refuseCancelOrder(String orderCode,String reason,String operator);
	
	/**
	 * 确认取消。
	 * 	<pre>
	 * Cms后端确认可以处理 或 确认货丢了，
	 * 那OSMS可以单方面将订单取消待确认标记去掉，
	 * 订单状态改为已取消，不需通讯亚马逊平台
	 * </pre>
	 * @param orderCode
	 * @param operator
	 * @param remark
	 */
	void confirmCacelOrder(String orderCode,String operator ,String remark);
	
	/**
	 * 自动取消订单项<br>
	 * 自动确认变更单
	 * @param orderId
	 * @param operator
	 * @param orderProductIds
	 */
	public void autoCancelOrderProducts(int orderId, String operator,int... orderProductIds);
	
	/**
	 * 修改订购量<br>
	 * 自动确认变更单<br>
	 * 不通讯修改（cms自己做了处理）
	 * @param orderItemId
	 * @param operator
	 * @param newOrderedQuantity
	 */
	public void autoUpdateOrderProductsOrderedQuantity(int orderItemId,String operator,double newOrderedQuantity);
	
	/**
	 * 订单采购超批审核等待时
	 * @param orderItemId
	 * @version 1.2.8
	 */
	void moreBatchAuditWait(int orderItemId,Integer taskProductId);
	
}
