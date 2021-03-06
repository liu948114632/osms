package com.itecheasy.test;

import com.itecheasy.core.fba.ReplenishmentTaskService;
import com.itecheasy.core.order.OrderSwMessageService;
import com.itecheasy.core.order.OrderTrackingMessageService;

/** 
 * @author whw
 * @date 2018-2-5 
 * @description TODO
 * @version 
 */
public class SWTest extends SprintTest{
	private OrderSwMessageService orderSwMessageService;
	private ReplenishmentTaskService replenishmentTaskService;
	private OrderTrackingMessageService orderTrackingMessageService;

	public void setOrderTrackingMessageService(OrderTrackingMessageService orderTrackingMessageService) {
		this.orderTrackingMessageService = orderTrackingMessageService;
	}

	public void setReplenishmentTaskService(ReplenishmentTaskService replenishmentTaskService) {
		this.replenishmentTaskService = replenishmentTaskService;
	}

	public void setOrderSwMessageService(OrderSwMessageService orderSwMessageService) {
		this.orderSwMessageService = orderSwMessageService;
	}

	public void syncSW(){
		System.out.println(orderSwMessageService.readMessage(1155));
	}
	
	public void read(){
		orderTrackingMessageService.processingOrderTracking();
	}


}
