package com.itecheasy.core.fba;
/** 
 * @author wanghw
 * @date 2016-12-7 
 * @description 补货任务状态
 * @version 1.2.2
 */
public enum ReplenishmentTaskStatus {
	未申请(1) ,申请中(4), 审核不通过(5), 备货中(2), 已完成(3), 取消(6)
	;
	private int val;

	public int getVal() {
		return val;
	}
	
	private ReplenishmentTaskStatus(int val) {
		this.val=val;
	}
}
