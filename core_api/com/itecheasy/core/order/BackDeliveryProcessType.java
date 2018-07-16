package com.itecheasy.core.order;


/** 
 * @author wanghw
 * @date 2016-6-30 
 * @description 退件处理结果类型
 * @version 3.9.27
 */
public enum BackDeliveryProcessType {
	重发(1),取消(2),上架(3);
	private int val;
	public int getVal() {
		return val;
	}
	private BackDeliveryProcessType(int val) {
		this.val=val;
	}
	
	public static String getBackDeliveryProcessTypeText(Integer val){
		if(val!=null){
			for (BackDeliveryProcessType type : BackDeliveryProcessType.values()) {
				if(type.getVal()==val.intValue()){
					return type.name();
				}
			}
		}
		return "";
	}
	
}
