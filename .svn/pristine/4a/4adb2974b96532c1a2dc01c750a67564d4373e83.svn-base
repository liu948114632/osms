package com.itecheasy.core.order;

import java.util.Date;

import com.itecheasy.common.dao.Criteria;
import com.itecheasy.common.dao.Restriction;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.order.dao.OrderCancelResendApplyDao;
import com.itecheasy.core.po.OrderCancelResendApplyPO;

/** 
 * @author wanghw
 * @date 2016-12-9 
 * @description TODO
 * @version 1.2.2
 */
public class OrderCancelResendServiceImpl implements OrderCancelResendService{
	private OrderCancelResendApplyDao orderCancelResendApplyDao;

	public void setOrderCancelResendApplyDao(OrderCancelResendApplyDao orderCancelResendApplyDao) {
		this.orderCancelResendApplyDao = orderCancelResendApplyDao;
	}

	@Override
	public int applyOrderOperating(String orderCode, int orderApplyType) {
		OrderCancelResendApplyPO po=new OrderCancelResendApplyPO();
		po.setCreatedDate(new Date());
		po.setOrderCode(orderCode);
		po.setType(orderApplyType);
		po.setProcessStatus(OrderCancelResendProcessedStatus.确认中.getVal());
		return orderCancelResendApplyDao.addObject(po);
	}

	@Override
	@Deprecated
	public void complateOrderOperating(String orderCode) {
		String hql="from OrderCancelResendApplyPO where orderCode=? and processStatus<3";
		OrderCancelResendApplyPO po=orderCancelResendApplyDao.findByHql(hql, orderCode);
		if(po!=null){
			po.setProcessStatus(OrderCancelResendProcessedStatus.完成.getVal());
			po.setProcessDate(new Date());
			orderCancelResendApplyDao.mergeObject(po);
		}
	}
	
	@Override
	public void updateOrderApplyOperatingFromMessage(String orderCode, int status, int orderApplyType) {
		String hql="from OrderCancelResendApplyPO where orderCode=? and processStatus<3 and type=?";
		OrderCancelResendApplyPO po=orderCancelResendApplyDao.findByHql(hql, new Object[]{orderCode,orderApplyType});
		if(po==null){
			int id=applyOrderOperating(orderCode, orderApplyType);
			po=orderCancelResendApplyDao.getObject(id);
		}
		po.setProcessStatus(status);
		po.setProcessDate(new Date());
		orderCancelResendApplyDao.mergeObject(po);
	}
	
	@Override
	@Deprecated
	public void confirmOrderOperating(String orderCode) {
		String hql="from OrderCancelResendApplyPO where orderCode=? and processStatus<3";
		OrderCancelResendApplyPO po=orderCancelResendApplyDao.findByHql(hql, orderCode);
		if(po!=null){
			po.setProcessStatus(OrderCancelResendProcessedStatus.处理中.getVal());
			po.setProcessDate(new Date());
			orderCancelResendApplyDao.mergeObject(po);
		}
	}

	@Deprecated
	@Override
	public OrderCancelResendApply getOrderCancelResendApply(String orderCode, OrderApplyType type) {
		return null;
	}

	@Override
	public boolean existOrderCancelResendApply(String orderCode) {
		Criteria criteria=new Criteria(OrderCancelResendApplyPO.class);
		criteria.and(Restriction.eq("orderCode", orderCode));
		return CollectionUtils.isNotEmpty(orderCancelResendApplyDao.list(criteria));
	}

}
