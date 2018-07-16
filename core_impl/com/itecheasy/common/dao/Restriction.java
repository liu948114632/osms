package com.itecheasy.common.dao;

public class Restriction{
	public static final String EQ = "eq";
	public static final String NOT_EQ = "notEq";
	public static final String GT = "gt";
	public static final String GE = "ge";
	public static final String LT = "lt";
	public static final String LE = "le";
	public static final String IS_NULL = "isNull";
	public static final String IS_NOT_NULL = "isNotNull";
	public static final String BETWEEN = "between";
	public static final String LIKE = "like";
	public static final String NOT_LIKE = "NotLike";
	public static final String JOIN_CONDITION = "join_condition";
	
	private Restriction(String type,String attributeName,Object... parms){
		this.type = type;
		this.attributeName = attributeName;
		this.parms = parms;
	}
	private String type;
	private String attributeName;
	private Object[] parms;
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public Object[] getParms() {
		return parms;
	}
	public void setParms(Object[] parms) {
		this.parms = parms;
	}
	public static Restriction eq(String attributeName,Object... parms){
		return new Restriction(EQ,attributeName,parms);
	}
	public static Restriction gt(String attributeName,Object... parms){
		return new Restriction(GT,attributeName,parms);
	}
	public static Restriction ge(String attributeName,Object... parms){
		return new Restriction(GE,attributeName,parms);
	}
	public static Restriction lt(String attributeName,Object... parms){
		return new Restriction(LT,attributeName,parms);
	}
	public static Restriction le(String attributeName,Object... parms){
		return new Restriction(LE,attributeName,parms);
	}
	public static Restriction isNull(String attributeName,Object... parms){
		return new Restriction(IS_NULL,attributeName,parms);
	}
	public static Restriction isNotNull(String attributeName,Object... parms){
		return new Restriction(IS_NOT_NULL,attributeName,parms);
	}
	public static Restriction between(String attributeName,Object... parms){
		return new Restriction(BETWEEN,attributeName,parms);
	}
	public static Restriction notEq(String attributeName,Object... parms){
		return new Restriction(NOT_EQ,attributeName,parms);
	}
	public static Restriction like(String attributeName,Object... parms){
		return new Restriction(LIKE,attributeName,parms);
	}
	public static Restriction notLike(String attributeName,Object... parms){
		return new Restriction(NOT_LIKE,attributeName,parms);
	}
	public static Restriction joinCondition(String constantString){
		return new Restriction(JOIN_CONDITION,constantString);
	}
	
	public String getType(){
		return type;
	}
}
