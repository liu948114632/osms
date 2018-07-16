package com.itecheasy.core.order;

import com.itecheasy.core.task.BaseOrderView;
import com.itecheasy.webservice.sw.Notification;

/** 
 * @author whw
 * @date 2017-8-3 
 * @description TODO
 * @version 
 */
public interface OrderSwMessageService extends OrderService{
	int readMessage(int maxId);
	
	void processSW(Notification notification, BaseOrderView order);
}
