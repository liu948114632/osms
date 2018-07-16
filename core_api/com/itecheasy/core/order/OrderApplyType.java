package com.itecheasy.core.order;
/** 
 * @author wanghw
 * @date 2016-2-19 
 * @description 订单申请类型
 * @version 1.1.7
 */
public enum OrderApplyType {
	CANCEL(1),RESEND(2),BACK(3),PUT_ON(4);
	private int val;
	
	public int getVal() {
		return val;
	}

	private OrderApplyType(int val){
		this.val=val;
	}
	
}

