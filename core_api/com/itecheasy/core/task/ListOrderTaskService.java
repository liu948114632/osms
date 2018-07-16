package com.itecheasy.core.task;
/** 
 * @author wanghw
 * @date 2015-5-14 
 * @description 订单自动任务
 * @version
 */
public interface ListOrderTaskService {
	public void listOrder();
	
	public void getOrders();
	
	public void syncEbayOrders();
	
	void checkOrders();
	
	void listSmtOrder();
	
	void downloadSmtOrder();
}
