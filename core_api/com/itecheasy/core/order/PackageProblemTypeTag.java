package com.itecheasy.core.order;
/** 
 * @author wanghw
 * @date 2016-6-24 
 * @description TODO
 * @version 3.9.27
 */
public enum PackageProblemTypeTag {
	DMS_问题件_未妥投件(1),DMS_退件(2)
	;
	private int val;

	public int getVal() {
		return val;
	}
	
	private PackageProblemTypeTag(int val) {
		this.val=val;
	}
}


