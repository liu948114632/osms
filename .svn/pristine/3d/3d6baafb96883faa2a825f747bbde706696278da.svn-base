package com.itecheasy.core.order;

import java.util.List;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.core.fba.ReplenishmentOrderMessageService;
import com.itecheasy.core.fba.ReplenishmentOrderService;
import com.itecheasy.core.order.dao.BaseOrderViewDao;
import com.itecheasy.core.order.dao.BaseOrderViewDetailDao;
import com.itecheasy.core.po.BaseOrderViewPO;
import com.itecheasy.core.task.BaseOrderDetailView;
import com.itecheasy.core.task.BaseOrderView;

/** 
 * @author wanghw
 * @date 2016-12-6 
 * @description TODO
 * @version 1.2.2
 */
public class OrderSchedule implements IOrderSchedule {
	private OrderService orderService;
	private ReplenishmentOrderService replenishmentOrderService;
	private BaseOrderViewDao baseOrderViewDao;
	private BaseOrderViewDetailDao baseOrderViewDetailDao;
	private OrderMessageService orderMessageService;
	private ReplenishmentOrderMessageService replenishmentOrderMessageService;
	
	

	public void setOrderMessageService(OrderMessageService orderMessageService) {
		this.orderMessageService = orderMessageService;
	}


	public void setReplenishmentOrderMessageService(ReplenishmentOrderMessageService replenishmentOrderMessageService) {
		this.replenishmentOrderMessageService = replenishmentOrderMessageService;
	}


	public void setBaseOrderViewDetailDao(BaseOrderViewDetailDao baseOrderViewDetailDao) {
		this.baseOrderViewDetailDao = baseOrderViewDetailDao;
	}


	public void setBaseOrderViewDao(BaseOrderViewDao baseOrderViewDao) {
		this.baseOrderViewDao = baseOrderViewDao;
	}


	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


	public void setReplenishmentOrderService(ReplenishmentOrderService replenishmentOrderService) {
		this.replenishmentOrderService = replenishmentOrderService;
	}

	@Override
	public IBaseOrder getInstance(String orderCode) {
		BaseOrderViewPO po= baseOrderViewDao.getObject(orderCode);
		return getInstance(po.getTableType());
	}
	
	@Override
	public IBaseOrderMessage getInstanceMessage(String orderCode) {
		BaseOrderViewPO po= baseOrderViewDao.getObject(orderCode);
		return getInstanceMessage(po.getTableType());
	}
	
	@Override
	public IBaseOrder getInstance(int tableType) {
		if(tableType==OrderTableType.ORDER.getVal()){
			return orderService;
		}else if(tableType==OrderTableType.REPLENISHMENT_ORDER.getVal()){
			return replenishmentOrderService;
		}
		return null;
	}
	
	@Override
	public IBaseOrderMessage getInstanceMessage(int tableType) {
		if(tableType==OrderTableType.ORDER.getVal()){
			return orderMessageService;
		}else if(tableType==OrderTableType.REPLENISHMENT_ORDER.getVal()){
			return replenishmentOrderMessageService;
		}
		return null;
	}
	
	@Override
	public List<BaseOrderDetailView> getTicketGrouypByGroupId(int sendGroupId){
		String hql="from BaseOrderDetailViewPO where sendGroupId=?";
		return BeanUtils.copyList(baseOrderViewDetailDao.findListByHql(hql, sendGroupId), BaseOrderDetailView.class);
	}
	
	@Override
	public BaseOrderDetailView getOrderDetailByCode(String orderCode) {
		return BeanUtils.copyProperties(baseOrderViewDetailDao.getObject(orderCode), BaseOrderDetailView.class);
	}
	
	@Override
	public BaseOrderView getOrderByCode(String orderCode) {
		return BeanUtils.copyProperties(baseOrderViewDao.getObject(orderCode), BaseOrderView.class);
	}
	
}
