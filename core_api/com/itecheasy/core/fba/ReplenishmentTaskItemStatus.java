package com.itecheasy.core.fba;
/** 
 * @author wanghw
 * @date 2016-12-7 
 * @description 补货任务项状态
 * @version 1.2.2
 */
public enum ReplenishmentTaskItemStatus {
	未下单(1),已下单(2),已完成(3);
	private int val;

	public int getVal() {
		return val;
	}
	
	private ReplenishmentTaskItemStatus(int val) {
		this.val=val;
	}
}
