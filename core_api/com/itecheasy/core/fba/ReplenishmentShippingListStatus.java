package com.itecheasy.core.fba;
/** 
 * @author wanghw
 * @date 2016-12-6 
 * @description fba补货单 货运清单状态
 * @version 1.2.2
 */
public enum ReplenishmentShippingListStatus {
	未上传(0),已上传(1),审核通过(2),审核不通过(3);
	private int val;

	public int getVal() {
		return val;
	}
	
	private ReplenishmentShippingListStatus(int val) {
		this.val=val;
	}
}
