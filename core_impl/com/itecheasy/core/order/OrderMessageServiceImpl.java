package com.itecheasy.core.order;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.communication.order.Command2CMS;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.PackageStatus.PackageTraceStatus;
import com.itecheasy.core.fba.ReplenishmentTaskService;
import com.itecheasy.core.po.OrderPO;
import com.itecheasy.core.po.OrderPrepareProductPO;
import com.itecheasy.core.po.OrderProductPO;
import com.itecheasy.core.task.BaseOrderView;
import com.itecheasy.webservice.client.CMSOrderClient;
import com.itecheasy.webservice.cms.order.OrderItem;
import com.itecheasy.webservice.cms.order.OrderItemDetail;

/** 
 * @author wanghw
 * @date 2017-1-11 
 * @description TODO
 * @version 1.2.2
 */
public class OrderMessageServiceImpl extends OrderServiceImpl implements OrderMessageService {
	private final static Logger LOGGER=Logger.getLogger(OrderMessageServiceImpl.class);
	private ReplenishmentTaskService replenishmentTaskService;
	
	
	public void setReplenishmentTaskService(ReplenishmentTaskService replenishmentTaskService) {
		this.replenishmentTaskService = replenishmentTaskService;
	}


	@Override
	public void updateDeliveryFromMessage(String orderCode, String traceCode, Double costFreight,
			Date deliveryDate,Date operateTime,String operator,String trackingUrl) {
		OrderPO order=getOrderPOByCode(orderCode);
		
		if (order.getDeliveryDate() == null) {
			order.setDeliveryDate(deliveryDate);
		}
		order.setTrackingCode(traceCode);
		order.setCostFreight(costFreight);
		order.setTrackingUrl(trackingUrl);
		Command2CMS.orderDeliver(orderCode);
		
		if (order.getStatus() < OrderStatus.已发货.getVal()) {
			order.setStatus(OrderStatus.已发货.getVal());
			// 通讯cms发货
			addOrderOperateLog("DMS消息：订单发货", operator, order.getId(), operateTime);
		} else if (order.getStatus() == OrderStatus.已发货.getVal()) {
			// 通讯cms重新发货
			addOrderOperateLog("DMS消息：订单重新发货", operator, order.getId(), operateTime);
		} else {
			addOrderOperateLog("DMS消息：订单状态不对", operator, order.getId(), operateTime);
		}
		
		orderDao.updateObject(order);
	}
	
	
	@Override
	public void processPackageStatus(String orderCode, PackageTraceStatus status, String operator, Date operateTime) {
		OrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setPackageStatus(status);
			addOrderOperateLog("同步dms包裹状态:" + status != null ? status.getEnName() : "未知", operator, po.getId(),
					operateTime);
		}
	}
	
	@Override
	public void updateDeliveryCustomerService(String orderCode, String deliveryCustomerServiceName, String operator,
			Date operateTime) {
		OrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setDeliveryCustomerService(deliveryCustomerServiceName);
			// 通讯cms
			orderDao.updateObject(po);
			addOrderOperateLog("DMS消息:更新货运客服“" + deliveryCustomerServiceName + "”", operator, po.getId(), operateTime);
		}
	}
	
	@Override
	public void orderComplete(String orderCode, String operator, Date operateTime) {
		OrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setStatus(OrderStatus.完成.getVal());
			// 通讯cms
			Command2CMS.completeOrder(orderCode);
			addOrderOperateLog("DMS消息:订单已确认", operator, po.getId(), operateTime);
		}

	}
	
	@Override
	public boolean updateTraceCode(String orderCode, String traceCode, String operator, Date operateTime
			,String trackingUrl) {
		OrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setTrackingCode(traceCode);
			if (po.getDeliveryDate() == null) {
				po.setDeliveryDate(operateTime);
			}
			po.setTrackingUrl(trackingUrl);
			addOrderOperateLog("DMS消息：更新订单跟踪号:" + traceCode, operator, po.getId(), operateTime);
//			delivering2WS3rdProxy(po.getId());
			LOGGER.info("(DMS消息：更新订单跟踪号 "+po.getCode()+"):--"+po.getTrackingCode()+"--("+po.getDeliveryDate()+")");
			orderDao.updateObject(po);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateFreight(String orderCode, Double freight, String operator, Date operateTime) {
		OrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setCostFreight(freight);
			// 通讯cms
//			Command2CMS.orderDeliver(orderCode);

			addOrderOperateLog("DMS消息：更新发货成本", operator, po.getId(), operateTime);
			orderDao.updateObject(po);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateShippingMethod(String orderCode, int shippingMethodId, String operator, Date operateTime) {
		OrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setShippingMethod(shippingMethodId);
			addOrderOperateLog("DMS消息：更新货运方式", operator, po.getId(), operateTime);
			orderDao.updateObject(po);
			return true;
		}
		return false;
	}
	
	@Override
	public void updateOrderFromMessage(com.itecheasy.webservice.cms.order.Order cmsOrder, BaseOrderView orderView,
			Date operatorTime) {
		OrderPO order=orderDao.getObject(orderView.getId());
		if (order.getCmsPrepare()!=ORDER_PREPARE_TYPE_CMS) {
			return;
		}
		
		//打回
		if(order.getIsbackTag()){
			if(cmsOrder.getStatus()<=OrderStatus.已校对.getVal()&&order.getStatus()>cmsOrder.getStatus()){
				syncBackTagFromMessage(order.getCode(), false);
			}
		}
		
		//待重发
		if(order.isAwaitConfirmResend()){
			if(cmsOrder.getStatus()<=OrderStatus.已校对.getVal()){
				confirmResendOrder(cmsOrder.getCode(), cmsOrder.getStatus(), "CMS");
				return ;
			}
		}
		//同步小批量是否生成下架单
//		order.setIsSmallLotOrderOffShelveing(cmsOrder.isIsSmallLotOrderOffShelveing());
		// 同步状态
		if (order.getStatus() != cmsOrder.getStatus()) {
			if(cmsOrder.getStatus()==OrderStatus.发货中.getVal()&&
					order.getStatus()==OrderStatus.已发货.getVal()){
				return;
			}
			addOrderOperateLog("同步cms状态:" + OrderStatus.getName(cmsOrder.getStatus()), "CMS",
					order.getId(), operatorTime);
			// 同步状态
			order.setStatus(cmsOrder.getStatus());
			switch (cmsOrder.getStatus()) {
			case 50:// 打包中
				// 同步cms子箱
				List<OrderItemDetail> items = CMSOrderClient.getOrderItemByOrderId(cmsOrder.getId());
				for (OrderItemDetail item : items) {
					OrderPrepareProductPO po = orderPrepareProductDao.getObject(item.getBusinessId());
					if (po != null) {
						po.setBox(item.getBox());
					}
				}
				break;

			case 60: // 已出库
				if(cmsOrder.getStockOutTime()!=null){
					order.setOutDate(cmsOrder.getStockOutTime().toGregorianCalendar().getTime());
				}
				break;
			}

		}
		orderDao.updateObject(order);
	}
	
	@Override
	public void updateOrderItemFromMessage(OrderItem cmsOrderItem, Date operatorTime) {
		OrderPrepareProductPO po = orderPrepareProductDao.getObject(cmsOrderItem.getBusinessId());
		if (po == null) {
			LOGGER.info(MessageFormat.format("订单项{0}不存在", cmsOrderItem.getBusinessId()));
			return ;
		}
		if (po.getStatus()==12) {
			LOGGER.info(MessageFormat.format("订单项{0}已经取消", cmsOrderItem.getBusinessId()));
			return ;
		}
		int _status=po.getStatus();
		po.setBranchRemark(cmsOrderItem.getBranchRemark());
		po.setPurchaseRemark(cmsOrderItem.getPurchaseRemark());
		double cmsPrepare = new BigDecimal(cmsOrderItem.getPreparedQuantity()).divide(
				new BigDecimal(cmsOrderItem.getUnitQuantity()), 2, 4).doubleValue();
		if (cmsPrepare > po.getOrderQty()) {
			cmsPrepare = new Double(po.getOrderQty()).intValue();
		}
		if (cmsOrderItem.getStatus() != 12) {
			if (po.getPrepareQty() != cmsPrepare) {
				po.setPrepareQty(cmsPrepare);
				addOrderOperateLog("cms更新商品项:" + po.getCmsProductCode() + "已备量为" + po.getPrepareQty(), "CMS",
						po.getOrderId(), operatorTime);
			}
		}
		OrderPO order = orderDao.getObject(po.getOrderId());
		//防止重复读消息 2016-11-11
		if(cmsOrderItem.getStatus()==po.getStatus())
			return;
		
		//已备货变成备货中
		if (cmsOrderItem.getStatus() <= OrderProductStatus.断货.getVal()) {
			if (order != null) {
				if (_status == OrderProductStatus.已备货.getVal()) {
					order.setOrderItemPrepareNum(order.getOrderItemPrepareNum() - 1);
					LOGGER.info(MessageFormat.format("订单{0}备货项-1", order.getCode()));
				}
				// 通知OSMS更新对应订单商品状态为“断货”，同时更新订单问题状态为“有问题”，问题类型为“断货”
				if (cmsOrderItem.getStatus() == OrderProductStatus.断货.getVal()) {
					order.setProblemStatus(1);
					order.setProblemVal(order.getProblemVal() + OrderProblemType.断货.getVal());
					order.setProblemType(OrderProblemType.断货.getVal());
				}
			}
		}
		// 更新到货率
		else if (cmsOrderItem.getStatus() == OrderProductStatus.已备货.getVal()) {
			if (order != null) {
				if (_status <= OrderProductStatus.断货.getVal()) {
					order.setOrderItemPrepareNum(order.getOrderItemPrepareNum() + 1);
					LOGGER.info(MessageFormat.format("订单{0}备货项+1", order.getCode()));
					//v1.2.8 超批审核等待的商品已备货后，取消任务
					if(po.getMoreBatchAuditWaitTaskProductId()!=null){
						replenishmentTaskService.cancelMoreBatchWaitTaskProduct(po.getMoreBatchAuditWaitTaskProductId().intValue());
						po.setMoreBatchAuditWaitTaskProductId(null);
					}
				}

				if (order.getOrderItemPrepareNum() > order.getOrderItemNum()) {
					order.setOrderItemPrepareNum(order.getOrderItemNum());
				}
			}
		}
		
		po.setStatus(cmsOrderItem.getStatus());
		orderDao.mergeObject(order);
		orderPrepareProductDao.mergeObject(po);
		//2017-08-16  清楚断货异常 
		if(_status==OrderProductStatus.断货.getVal()&&hasOutOfStock(order.getId())){
			if(order.getProblemStatus()==1){
				calcOrderProblem(order, OrderProblemType.断货.getVal(), OrderProductStatus.断货.getVal());
			}
		}
	}
	
	private boolean hasOutOfStock(int orderId){
		String hql="from OrderPrepareProductPO where orderId=? and status=4";
		return CollectionUtils.isEmpty(orderDao.findListByHql(hql,orderId));
		
	}
	
	
	@Override
	public void confirmResendOrder(String orderCode, int status, String operator) throws BussinessException {
		OrderPO po = this.getOrderPOByCode(orderCode);
		po.setAwaitConfirmResend(false);
		po.setStatus(status);

		this.addOrderOperateLog("申请重发成功，订单状态变为" + OrderStatus.getName(status), operator, po.getId());

		// 取消订单 打待重发标记
		// 同票订单待重发，打回后直接取消订单
		if (po.isAmCanceledTag()) {
			// 取消同票
			this.cancelTicketGroup(po.getId(), "OSMS");
			// 取消订单
			this.cancelOrderCommunication(po.getId(), "OSMS");

			// 取消非cms备货商品
			cancelNotCMSPrepareProduct2email(po);
		}
		orderDao.updateObject(po);
	}

	@Override
	public void refuseResendOrder(String code, String reason, int type, String operator) throws BussinessException {
		boolean _need_to_send_mail = true;
		OrderPO po = this.getOrderPOByCode(code);
		String comment = "";
		po.setAwaitConfirmResend(false);
		// 订单丢失
		String subject = "订单" + po.getCode() + "申请重发失败";
		if (type == OrderApplyOperatType.ORDER_MISS.getVal()) {
			if (this.hasNotCMSPrepareProduct(po.getId())) {
				// 如果订单中包含非c3备货商品，则取消订单中c3备货的商品项，订单备货类型变为非c3备货，订单状态将以非c3备货为准。
				List<OrderProductPO> orderProductPos = this.getOrderProductNotCancel(po.getId());

				StringBuilder cancleOrderItemIds = new StringBuilder();
				StringBuilder cancelReason = new StringBuilder();

				for (OrderProductPO oppo : orderProductPos) {
					OrderPrepareProductPO ppo = getOrderPrepareProductByOrderProduct(oppo.getId());
					if (ppo.getCmsPrepare()!=ORDER_PREPARE_TYPE_CMS) {
						continue;
					}
					cancelOrderProduct(ppo, po, oppo, operator, cancleOrderItemIds);
					addOrderOperateLog("取消商品：" + ppo.getCmsProductCode(), operator, po.getId());
					cancelReason.append(",").append(0);
				}

				cancelOrderProducts$changeOrder(po, cancleOrderItemIds, cancelReason);

				comment = OrderStatus.getName(po.getOldStatus()) + "的c3包裹，申请订单重发失败，原因为订单丢失，自动取消订单中国内仓商品项";
			} else {
				// 如果订单为全部c3备货，则取消订单，记录日志：“已出库订单，申请订单重发失败，原因为订单丢失，自动将订单状态改为取消”
				po.setStatus(OrderStatus.取消.getVal());
				po.setShopOrderStatus(ORDER_SHOP_CANCELED);
				comment = OrderStatus.getName(po.getOldStatus()) + "订单，申请订单重发失败，原因为订单丢失，自动将订单状态改为取消";
			}
			// 取消订单 打待确认标记
			if (po.isAmCanceledTag()) {
				comment = "同票订单" + po.getCode() + "取消成功.";
				subject = "同票订单" + po.getCode() + "取消成功";
				po.setAmCanceledTag(false);
			}
		}
		// 订单无法追回
		else if (type == OrderApplyOperatType.COULD_NOT_RETRIEVE.getVal()) {
			comment = OrderStatus.getName(po.getOldStatus()) + "订单，申请订单重发失败，原因为" + reason;
			// 取消订单 打待确认标记
			if (po.isAmCanceledTag()) {
				comment = OrderStatus.getName(po.getOldStatus()) + "订单" + po.getCode() + ",后端确认无法取消，原因" + reason;
				subject = "订单" + po.getCode() + "无法取消";
				po.setAmCanceledTag(false);
			}
		}
		// 撤销申请
		else if (type == OrderApplyOperatType.UNDO_APPLY.getVal()) {
			comment = OrderStatus.getName(po.getOldStatus()) + "订单，申请订单重发失败，原因为" + reason;
			_need_to_send_mail = false;
			// 取消订单 打待确认标记
			if (po.isAmCanceledTag()) {
				comment = OrderStatus.getName(po.getOldStatus()) + "订单" + po.getCode() + ",后端确认无法取消，原因" + reason;
				subject = "订单" + po.getCode() + "无法取消";
				po.setAmCanceledTag(false);
				_need_to_send_mail = true;
			}
		}
		// 发送邮件
		if (_need_to_send_mail) {
			sendEmail2Customerservices(po.getMerchandiserId(), subject, comment);
		}
		this.addOrderOperateLog(comment, operator, po.getId());
		orderDao.updateObject(po);
	}


	@Override
	public void confirmCacelOrder(String orderCode, String operator, String remark) {
		OrderPO po = this.getOrderPOByCode(orderCode);
		if (po != null) {
			po.setAwaitConfirmCancel(false);
			po.setStatus(OrderStatus.取消.getVal());
			po.setShopOrderStatus(ORDER_SHOP_CANCELED);
			orderDao.mergeObject(po);
			addOrderOperateLog(remark, operator, po.getId());

			cancelNotCMSPrepareProduct2email(po);
			orderDao.updateObject(po);
		}
	}
	
	@Override
	public void syncBackTagFromMessage(String orderCode, boolean backTag) {
		OrderPO po = this.getOrderPOByCode(orderCode);
		po.setIsbackTag(backTag);
		// 在重发确认流程处理了
		// if(!backTag){
		// //同票订单待重发，打回后直接取消订单
		// if(po.isAmCanceledTag()&&po.isAwaitConfirmResend()){
		// //解除同票
		// po.setAwaitConfirmResend(false);
		// this.cancelTicketGroup(po.getId(), "OSMS取消订单");
		// cancelNotCMSPrepareProduct2email(po);
		// this.cancelOrderCommunication(po.getId(), "OSMS");
		// }
		// }
		orderDao.updateObject(po);
		this.addOrderOperateLog("订单打回标记同步为:" + (backTag ? "true" : "false"), "CMS", po.getId());
	}

	@Override
	public void setResendTagFromMessage(String orderCode, String operator) {
		OrderPO po = this.getOrderPOByCode(orderCode);
		if(!po.isAwaitConfirmResend()){
			po.setAwaitConfirmResend(true);
			po.setOldStatus(po.getStatus());
			
			orderCancelResendService.applyOrderOperating(po.getCode(), OrderApplyType.RESEND.getVal());
			addOrderOperateLog("同步cms消息：订单重发", operator, po.getId());
			orderDao.updateObject(po);
		}
	}
	
	
	@Override
	public void refuseCancelOrder(String orderCode, String reason, String operator) {
		OrderPO po = this.getOrderPOByCode(orderCode);
		po.setAwaitConfirmCancel(false);
		sendEmail2Customerservices(po.getMerchandiserId(), "订单" + po.getCode() + "后端无法取消", "订单" + po.getCode()
				+ "后端确认无法取消，原因:" + reason);

		this.addOrderOperateLog(OrderStatus.getName(po.getOldStatus()) + "的订单取消失败。原因" + reason, operator, po.getId());
		orderDao.updateObject(po);
	}

	/***************************************************变更单*******************************************************/
	
	public void autoUpdateOrderProductsOrderedQuantity(int orderItemId,String operator,double newOrderedQuantity){
		OrderPrepareProductPO old_ppo=orderPrepareProductDao.getObject(orderItemId);
		OrderPO po=orderDao.getObject(old_ppo.getOrderId());
		StringBuilder remark=new StringBuilder("确认变更单");
		if (old_ppo.getOrderQty() != newOrderedQuantity) {
			remark.append(MessageFormat.format("：修改订购量：“{0}”为“{1}”;", String.valueOf(old_ppo.getOrderQty()),
					newOrderedQuantity));
			// 更新订单成本价
			old_ppo.setCostPrice(new BigDecimal(old_ppo.getCostPrice())
			.multiply(new BigDecimal(newOrderedQuantity).divide(
					new BigDecimal(old_ppo.getOrderQty()),3, 4)
					).setScale(3, 4).doubleValue());
			
			old_ppo.setOrderQty(newOrderedQuantity);
			
			if (old_ppo.getPrepareQty() >= old_ppo.getOrderQty()) {
				if (old_ppo.getStatus() != OrderProductStatus.已备货.getVal()) {
					po.setOrderItemPrepareNum(po.getOrderItemPrepareNum() + 1);
				}
				old_ppo.setPrepareQty(old_ppo.getOrderQty());
				old_ppo.setStatus(OrderProductStatus.已备货.getVal());
			} else {
				if (old_ppo.getStatus() == OrderProductStatus.已备货.getVal()) {
					po.setOrderItemPrepareNum(po.getOrderItemPrepareNum() - 1);
				}
				old_ppo.setStatus(OrderProductStatus.备货中.getVal());
			}
			
			updateOrderStatusByOrderProduct(po);
		}
		orderDao.updateObject(po);
		if (remark.length() > 0) {
			addOrderOperateLog(remark.toString(), operator, po.getId());
		}
	}
	
	@Override
	public void autoCancelOrderProducts(int orderId, String operator, int... orderProductIds) {
		OrderPO po = orderDao.getObject(orderId);
		StringBuilder cancleOrderItemIds = new StringBuilder();
		StringBuilder cancelReason = new StringBuilder();
		for (int orderPrepareProductId : orderProductIds) {
			OrderPrepareProductPO ppo = orderPrepareProductDao.getObject(orderPrepareProductId);
			OrderProductPO oppo = orderProductDao.getObject(ppo.getOrderProductId());
			cancelOrderProduct(ppo, po, oppo, operator, cancleOrderItemIds);
			addOrderOperateLog("取消商品：" + ppo.getCmsProductCode(), operator, po.getId());
			cancelReason.append(",").append(0);
		}
			
		updateOrderStatusByOrderProduct(po);
		//取消订单
		if(po.getOrderItemNum()==0){//所有商品项取消，取消订单
			cancelOrderCommunication(po.getId(), operator);
			return ;
		}
		
		cancelOrderProducts$changeOrder(po, cancleOrderItemIds, cancelReason);
		orderDao.updateObject(po);
		
	}
	
	@Override
	public void moreBatchAuditWait(int orderItemId, Integer taskProductId) {
		OrderPrepareProductPO po= this.orderPrepareProductDao.getObject(orderItemId);
		if(po!=null){
			po.setMoreBatchAuditWaitTaskProductId(taskProductId);
		}
	}
}
