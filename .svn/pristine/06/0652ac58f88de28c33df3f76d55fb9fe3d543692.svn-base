package com.itecheasy.core.order;

/**
 * @author wanghw
 * @date 2016-2-23
 * @description 问题件状态
 * @version 1.1.7
 */
public enum PackageProblemStatus {
	处理中(0),DMS_已关闭(1),OSMS_COLSED(2);
	private int val;

	public int getVal() {
		return val;
	}

	private PackageProblemStatus(int val) {
		this.val=val;
	}
	
	public static int getVal(String name){
		for (PackageProblemStatus status : PackageProblemStatus.values()) {
			if(status.toString().equals(name)){
				return status.getVal();
			}
		}
		return 0;
	}
}
