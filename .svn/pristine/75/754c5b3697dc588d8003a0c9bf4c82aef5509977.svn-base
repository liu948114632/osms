package com.itecheasy.core.fba;
/** 
 * @author wanghw
 * @date 2016-12-7 
 * @description <i> (废弃)补货任务商品任务的状态(1 未下达、2 已下达、3 采购完成、4 无法处理、6 已结束、7 已取消、8排队中)</i>
 * @version 1.2.2
 * @version 1.2.8  cms办事处任务状态（10 未分配、20 已分配、30 采购中 40订货中、50加工中、55待入库、60 无法处理、70 已结束 80 已取消）
 */
public enum CMSTaskStatus {
	未下达(1),已下达(2),采购完成(3),无法处理(4),已结束(6),已取消(7),排队中(8),
	_未分配(10) , _已分配(20),_采购中(30) ,_订货中(40),加工中(50),待入库(55), _无法处理(60), _已结束(70)  ,_已取消(80);
	private int val;

	public int getVal() {
		return val;
	}
	
	private CMSTaskStatus(int val) {
		this.val=val;
	}
	
	public boolean equal(Integer val){
		if(val==null)
			return false;
		return val.intValue()==this.val;
	}
}
