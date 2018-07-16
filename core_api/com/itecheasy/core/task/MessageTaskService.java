package com.itecheasy.core.task;

import com.itecheasy.core.BussinessException;

/** 
 * @author wanghw
 * @date 2015-5-20 
 * @description 其他系统消息处理自动任务
 * @version
 */
public interface MessageTaskService {
	
	public void processingDMSMessage()throws BussinessException;
	
	public void processingCMSMeseeage()throws BussinessException;
	
	public void processingModifyOrder();

	void syncFirstWayOrder();
}
