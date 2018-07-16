package com.itecheasy.core.order;
/** 
 * @author wanghw
 * @date 2016-3-15 
 * @description TODO
 * @version 1.1.7
 */
public enum SymbolSql {
	EQ("="),NOT_EQ("<>"),GT(">"),GE(">="),LT("<"),LE("<=");
	
	private String val;
	
	public String getVal() {
		return val;
	}

	private SymbolSql(String val){
		this.val=val;
	}
	
}
