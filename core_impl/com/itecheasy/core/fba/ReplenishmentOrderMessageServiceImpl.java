package com.itecheasy.core.fba;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.communication.order.Command2CMS;
import com.itecheasy.communication.order.CommandReplenishment2CMS;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.PackageStatus.PackageTraceStatus;
import com.itecheasy.core.order.OrderApplyOperatType;
import com.itecheasy.core.order.OrderApplyType;
import com.itecheasy.core.order.OrderService.OrderProblemType;
import com.itecheasy.core.order.OrderService.OrderProductStatus;
import com.itecheasy.core.order.OrderService.OrderStatus;
import com.itecheasy.core.po.ReplenishmentOrderItemPO;
import com.itecheasy.core.po.ReplenishmentOrderPO;
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
public class ReplenishmentOrderMessageServiceImpl extends ReplenishmentOrderServiceImpl implements ReplenishmentOrderMessageService{
	private final static Logger LOGGER=Logger.getLogger(ReplenishmentOrderServiceImpl.class);
	
	@Override
	public void updateDeliveryCustomerService(String orderCode, String deliveryCustomerServiceName, String operator,
			Date operateTime) {
		ReplenishmentOrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setDeliveryCustomerService(deliveryCustomerServiceName);
			// 通讯cms
			addOrderOperateLog("DMS消息:更新货运客服“" + deliveryCustomerServiceName + "”", operator, po.getId(), operateTime);
		}
	}
	
	@Override
	public void processPackageStatus(String orderCode, PackageTraceStatus status, String operator, Date operateTime) {
		ReplenishmentOrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setPackageStatus(status);
			addOrderOperateLog("同步dms包裹状态:" + status != null ? status.getEnName() : "未知", operator, po.getId(),
					operateTime);
		}
	}
	
	@Override
	public boolean updateFreight(String orderCode, Double freight, String operator, Date operateTime) {
		ReplenishmentOrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setCostFreight(freight);
			// 通讯cms
//			Command2CMS.orderDeliver(orderCode);

			addOrderOperateLog("DMS消息：更新发货成本", operator, po.getId(), operateTime);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateTraceCode(String orderCode, String traceCode, String operator, Date operateTime
			,String trackingUrl) {
		ReplenishmentOrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setTrackingCode(traceCode);
			if (po.getDeliveryDate() == null) {
				po.setDeliveryDate(operateTime);
			}
			addOrderOperateLog("DMS消息：更新订单跟踪号:" + traceCode, operator, po.getId(), operateTime);
			replenishmentOrderDao.mergeObject(po);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateShippingMethod(String orderCode, int shippingMethodId, String operator, Date operateTime) {
		ReplenishmentOrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setShippingMethod(shippingMethodId);
			addOrderOperateLog("DMS消息：更新货运方式", operator, po.getId(), operateTime);
			replenishmentOrderDao.mergeObject(po);
			return true;
		}
		return false;
	}
	
	@Override
	public void updateDeliveryFromMessage(String orderCode, String traceCode, Double costFreight,
			Date deliveryDate,Date operateTime,String operator,
			String trackingUrl) {
		ReplenishmentOrderPO order=getOrderPOByCode(orderCode);   //这个code在之前就保存在本地数据库中
		
		if (order.getDeliveryDate() == null) {
			order.setDeliveryDate(deliveryDate);
		}
		order.setTrackingCode(traceCode);
		order.setCostFreight(costFreight);
		
		if (order.getStatus() < OrderStatus.已发货.getVal()) {
			order.setStatus(OrderStatus.已发货.getVal());   //不用update也能更新
			// 通讯cms发货
			addOrderOperateLog("DMS消息：订单发货", operator, order.getId(), operateTime);
		} else if (order.getStatus() == OrderStatus.已发货.getVal()) {
			// 通讯cms重新发货
			addOrderOperateLog("DMS消息：订单重新发货", operator, order.getId(), operateTime);
		} else {
			addOrderOperateLog("DMS消息：订单状态不对", operator, order.getId(), operateTime);
		}
		CommandReplenishment2CMS.orderDeliver(orderCode);
	}
	

	@Override
	public void orderComplete(String orderCode, String operator, Date operateTime) {
		ReplenishmentOrderPO po = getOrderPOByCode(orderCode);
		if (po != null) {
			po.setStatus(OrderStatus.完成.getVal());
			// 通讯cms
			Command2CMS.completeOrder(orderCode);
			addOrderOperateLog("DMS消息:订单已确认", operator, po.getId(), operateTime);
		}
	}
	
	
	@Override
	public void updateOrderFromMessage(com.itecheasy.webservice.cms.order.Order cmsOrder, BaseOrderView orderView,
			Date operatorTime) {
		ReplenishmentOrderPO order=replenishmentOrderDao.getObject(orderView.getId());
		
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
//				orderCancelResendService.complateOrderOperating(cmsOrder.getCode());
				return ;
			}
		}
		//同步小批量是否生成下架单
//		order.setIsSmallLotOrderOffShelveing(cmsOrder.isIsSmallLotOrderOffShelveing());
		// 同步状态
		if (order.getStatus() != cmsOrder.getStatus()) {
			int _old_status=order.getStatus();
			//防止消息延迟，订单状态倒回
			if(cmsOrder.getStatus()==OrderStatus.发货中.getVal()&&
					order.getStatus()==OrderStatus.已发货.getVal()){
				return;
			}
			order.setStatus(cmsOrder.getStatus());
			addOrderOperateLog("同步cms状态:" + OrderStatus.getName(cmsOrder.getStatus()), "CMS",
					order.getId(), operatorTime);
			
			//打包中状态 通知货运单-->2017-01-20 消息同步不及时，状态直接跳过 打包中，导致没有通知dms
			if(_old_status<OrderStatus.打包中.getVal()
					&&cmsOrder.getStatus()>=OrderStatus.打包中.getVal()){
				notifyShippingList2OthenSystem(order.getId(), "系统");
			}
			// 同步状态
			switch (cmsOrder.getStatus()) {
			case 50:// 打包中
				// 同步cms子箱
				List<OrderItemDetail> items = CMSOrderClient.getOrderItemByOrderId(cmsOrder.getId());
				for (OrderItemDetail item : items) {
					ReplenishmentOrderItemPO po = replenishmentOrderItemDao.getObject(item.getBusinessId());
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
		replenishmentOrderDao.updateObject(order);
	}
	
	
	@Override
	public void updateOrderItemFromMessage(OrderItem cmsOrderItem, Date operatorTime) {
		ReplenishmentOrderItemPO po = replenishmentOrderItemDao.getObject(cmsOrderItem.getBusinessId());
		if (po == null) {
			LOGGER.info(MessageFormat.format("订单项{0}不存在", cmsOrderItem.getBusinessId()));
			return ;
		}
		if (po.getStatus()==12) {
			LOGGER.info(MessageFormat.format("订单项{0}已经取消", cmsOrderItem.getBusinessId()));
			return ;
		}
		po.setBranchRemark(cmsOrderItem.getBranchRemark());
		po.setPurchaseRemark(cmsOrderItem.getPurchaseRemark());
		double cmsPrepare = new BigDecimal(cmsOrderItem.getPreparedQuantity()).divide(
				new BigDecimal(cmsOrderItem.getUnitQuantity()), 2, 4).doubleValue();
		if (cmsPrepare > po.getOrderedQuantity()) {
			cmsPrepare = new Double(po.getOrderedQuantity()).intValue();
		}
		int _status = po.getStatus();
		ReplenishmentOrderPO order = replenishmentOrderDao.getObject(po.getReplenishmentOrderId());
		if (cmsOrderItem.getStatus() != 12 ) {
			if (po.getPreparedQuantity() != cmsPrepare) {
				po.setPreparedQuantity(cmsPrepare);
				addOrderOperateLog("cms更新商品项:" + po.getCmsProductCode() + "已备量为" + po.getPreparedQuantity(), "CMS",
						po.getReplenishmentOrderId(), operatorTime);
				LOGGER.info(MessageFormat.format("订单{0}已备量{1}-->{2}", order.getCode(),_status,cmsOrderItem.getStatus()));
			}
		}
		//防止重复读消息 2016-11-11
		if(cmsOrderItem.getStatus()==_status)
			return;
		//已备货变成备货中
		if(cmsOrderItem.getStatus()<=OrderProductStatus.断货.getVal()){
			if (order != null) {
				if(_status==OrderProductStatus.已备货.getVal()){
					order.setOrderItemPrepareNum(order.getOrderItemPrepareNum() -1);
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
		else 	if (cmsOrderItem.getStatus() == OrderProductStatus.已备货.getVal()) {
			if (order != null) {
				if(_status<=OrderProductStatus.断货.getVal()){
					order.setOrderItemPrepareNum(order.getOrderItemPrepareNum() + 1);
					LOGGER.info(MessageFormat.format("订单{0}备货项+1", order.getCode()));
				}
				
				if (order.getOrderItemPrepareNum() > order.getOrderItemNum()) {
					order.setOrderItemPrepareNum(order.getOrderItemNum());
				}
			}
		}
		
		po.setStatus(cmsOrderItem.getStatus());
		replenishmentOrderDao.mergeObject(order);
		replenishmentOrderItemDao.mergeObject(po);
		
		//2017-08-16  清楚断货异常 
		if(_status==OrderProductStatus.断货.getVal()){
			if(order.getProblemStatus()==1&&hasOutOfStock(order.getId())){
				order.setProblemStatus(0);
				order.setProblemVal(order.getProblemVal() -OrderProblemType.断货.getVal());
				order.setProblemType(0);
			}
		}
	}
	
	private boolean hasOutOfStock(int orderId){
		String hql="from ReplenishmentOrderItemPO where replenishmentOrderId=? and status=4";
		return CollectionUtils.isEmpty(replenishmentOrderDao.findListByHql(hql,orderId));
		
	}
	
	
	@Override
	public void syncBackTagFromMessage(String orderCode, boolean backTag) {
		ReplenishmentOrderPO po = getOrderPOByCode(orderCode);
		po.setIsbackTag(backTag);

		this.addOrderOperateLog("订单打回标记同步为:" + (backTag ? "true" : "false"), "CMS", po.getId());
	}
	
	@Override
	public void confirmResendOrder(String orderCode, int status, String operator) throws BussinessException {
		ReplenishmentOrderPO po = this.getOrderPOByCode(orderCode);
		po.setAwaitConfirmResend(false);
		po.setStatus(status);
		po.setShippingListStatus(ReplenishmentShippingListStatus.审核不通过.getVal());

		this.addOrderOperateLog("申请重发成功，订单状态变为" + OrderStatus.getName(status), operator, po.getId());

		// 取消订单 打待重发标记
		if (po.isOrderCancelTag()) {
			// 同票订单待重发，打回后直接取消订单
			// 取消同票
			this.cancelTicketGroup(po.getId(), "OSMS");
			// 取消订单
			this.cancelOrderCommunication(po.getId(), "OSMS");
		}
	}
	
	@Override
	public void setResendTagFromMessage(String orderCode, String operator) {
		ReplenishmentOrderPO po = this.getOrderPOByCode(orderCode);
		if(!po.isAwaitConfirmResend()){
			po.setAwaitConfirmResend(true);
			po.setOldStatus(po.getStatus());
			
			orderCancelResendService.applyOrderOperating(po.getCode(), OrderApplyType.RESEND.getVal());
			addOrderOperateLog("同步cms消息：订单重发", operator, po.getId());
		}
	}
	
	
	@Override
	public void refuseCancelOrder(String orderCode, String reason, String operator) {
		ReplenishmentOrderPO po = getOrderPOByCode(orderCode);
		po.setAwaitConfirmCancel(false);
		sendEmail2Customerservices(po.getMerchandiserId(), "订单" + po.getCode() + "后端无法取消", "订单" + po.getCode()
				+ "后端确认无法取消，原因:" + reason);

		this.addOrderOperateLog(OrderStatus.getName(po.getOldStatus()) + "的订单取消失败。原因" + reason, operator, po.getId());
	}
	
	@Override
	public void confirmCacelOrder(String orderCode, String operator, String remark) {
		ReplenishmentOrderPO po = this.getOrderPOByCode(orderCode);
		if (po != null) {
			po.setAwaitConfirmCancel(false);
			if(po.getStatus()!=OrderStatus.取消.getVal())
				setReplenishment4CancelOrder(po);
			replenishmentOrderDao.mergeObject(po);
			addOrderOperateLog(remark, operator, po.getId());
		}
	}
	
	@Override
	public void refuseResendOrder(String orderCode, String reason, int type, String operator) throws BussinessException {
		boolean _need_to_send_mail = true;
		ReplenishmentOrderPO po = this.getOrderPOByCode(orderCode);
		String comment = "";
		po.setAwaitConfirmResend(false);
		// 订单丢失
		String subject = "订单" + po.getCode() + "申请重发失败";
		if (type == OrderApplyOperatType.ORDER_MISS.getVal()) {
				setReplenishment4CancelOrder(po);
				comment = OrderStatus.getName(po.getOldStatus()) + "订单，申请订单重发失败，原因为订单丢失，自动将订单状态改为取消";
			// 取消订单 打待确认标记
			if (po.isOrderCancelTag()) {
				comment = "同票订单" + po.getCode() + "取消成功.";
				subject = "同票订单" + po.getCode() + "取消成功";
				po.setOrderCancelTag(false);
			}
		}
		// 订单无法追回
		else if (type == OrderApplyOperatType.COULD_NOT_RETRIEVE.getVal()) {
			comment = OrderStatus.getName(po.getOldStatus()) + "订单，申请订单重发失败，原因为" + reason;
			// 取消订单 打待确认标记
			if (po.isOrderCancelTag()) {
				comment = OrderStatus.getName(po.getOldStatus()) + "订单" + po.getCode() + ",后端确认无法取消，原因" + reason;
				subject = "订单" + po.getCode() + "无法取消";
				po.setOrderCancelTag(false);
			}
		}
		// 撤销申请
		else if (type == OrderApplyOperatType.UNDO_APPLY.getVal()) {
			comment = OrderStatus.getName(po.getOldStatus()) + "订单，申请订单重发失败，原因为" + reason;
			_need_to_send_mail = false;
			// 取消订单 打待确认标记
			if (po.isOrderCancelTag()) {
				comment = OrderStatus.getName(po.getOldStatus()) + "订单" + po.getCode() + ",后端确认无法取消，原因" + reason;
				subject = "订单" + po.getCode() + "无法取消";
				po.setOrderCancelTag(false);
				_need_to_send_mail = true;
			}
		}
		// 发送邮件
		if (_need_to_send_mail) {
			sendEmail2Customerservices(po.getMerchandiserId(), subject, comment);
		}
		this.addOrderOperateLog(comment, operator, po.getId());
	}
	
	public void autoUpdateOrderProductsOrderedQuantity(int replenishmentOrderItemId,String operator,double newOrderedQuantity){
		ReplenishmentOrderItemPO item=replenishmentOrderItemDao.getObject(replenishmentOrderItemId);
		ReplenishmentOrderPO po=replenishmentOrderDao.getObject(item.getReplenishmentOrderId());
		
		StringBuilder remark=new StringBuilder("确认变更单");
		if (item.getOrderedQuantity() != newOrderedQuantity) {
			remark.append(MessageFormat.format("：修改订购量：“{0}”为“{1}”;", String.valueOf(item.getOrderedQuantity()),
					newOrderedQuantity));
			
			//设置补货数量
			setReplenishment(item.getFbaShopProductId(), (int)item.getOrderedQuantity(),(int)newOrderedQuantity);
			
			// 更新订单成本价
			po.setCostPrice(po.getCostPrice()-item.getCostPrice());
			item.setCostPrice(new BigDecimal(item.getCostPrice()).multiply(
					new BigDecimal(newOrderedQuantity).divide(
							new BigDecimal(item.getOrderedQuantity()),3, 4)
					).setScale(3, 4).doubleValue());
			po.setCostPrice(po.getCostPrice()+item.getCostPrice());
			
			item.setOrderedQuantity(newOrderedQuantity);
			if (item.getPreparedQuantity() >= item.getOrderedQuantity()) {
				if (item.getStatus() != OrderProductStatus.已备货.getVal()) {
					po.setOrderItemPrepareNum(po.getOrderItemPrepareNum() + 1);
				}
				item.setPreparedQuantity(item.getOrderedQuantity());
				item.setStatus(OrderProductStatus.已备货.getVal());
			} else {
				if (item.getStatus() == OrderProductStatus.已备货.getVal()) {
					po.setOrderItemPrepareNum(po.getOrderItemPrepareNum() - 1);
				}
				item.setStatus(OrderProductStatus.备货中.getVal());
			}
			updateOrderStatusByOrderProduct(po);
			replenishmentOrderItemDao.mergeObject(item);
			CommandReplenishment2CMS.updateOrderProductAmount(po.getCode(), po.getCostPrice(), po.getCostFreight());
		}
		addOrderOperateLog(remark.toString(), operator, po.getId());
		
	}
	
	public void autoCancelOrderProducts(int orderId, String operator,int... replenishmentOrderProductIds){
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);

		StringBuilder cancleOrderItemIds = new StringBuilder();
		StringBuilder cancelReason = new StringBuilder();

		for (int i = 0; i < replenishmentOrderProductIds.length; i++) {
			ReplenishmentOrderItemPO item = replenishmentOrderItemDao.getObject(replenishmentOrderProductIds[i]);
			cancelOrderProduct(item, po, operator, cancleOrderItemIds);
			addOrderOperateLog("取消商品：" + item.getCmsProductCode(), operator, po.getId());
			cancelReason.append(",").append(0);
		}

		updateOrderStatusByOrderProduct(po);
		//取消订单
		if(po.getOrderItemNum()==0){//所有商品项取消，取消订单
			cancelOrderCommunication(po.getId(), operator);
			return;
		}
		cancelOrderProducts$changeOrder(po, cancleOrderItemIds, cancelReason,operator);

	}
	
	@Override
	public void moreBatchAuditWait(int orderItemId, Integer taskProductId) {
		// TODO Auto-generated method stub
		
	}
}
