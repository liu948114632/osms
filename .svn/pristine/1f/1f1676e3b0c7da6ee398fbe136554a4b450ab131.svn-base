package com.itecheasy.core.order;

import java.util.List;

import com.itecheasy.core.task.BaseOrderDetailView;
import com.itecheasy.core.task.BaseOrderView;

/**
 * @author wanghw
 * @date 2016-12-6
 * @description 订单表的类型，1、dbo.[order] 2、dbo.replenishment_order
 * @version 1.2.2
 */
public interface IOrderSchedule {
	IBaseOrder getInstance(String orderCode);
	IBaseOrderMessage getInstanceMessage(String orderCode);
	
	BaseOrderView getOrderByCode(String orderCode);
	
	/**
	 * detail
	 * @param orderCode
	 * @return
	 */
	BaseOrderDetailView getOrderDetailByCode(String orderCode);
	
	IBaseOrder getInstance(int tableType);
	
	IBaseOrderMessage getInstanceMessage(int tableType);

	/**
	 * 同票订单
	 * @param sendGroupId
	 * @return
	 */
	List<BaseOrderDetailView> getTicketGrouypByGroupId(int sendGroupId);
	public enum OrderTableType {
		ORDER(1), REPLENISHMENT_ORDER(2);
		private int val;

		public int getVal() {
			return val;
		}

		private OrderTableType(int val) {
			this.val = val;
		}
	}

}
