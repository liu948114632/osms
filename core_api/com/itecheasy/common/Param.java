package com.itecheasy.common;

public class Param {
	public enum ParamType{
		String,
		DateTime
	}
	
	private String paramName;
	private Object paramValue;
	private ParamType ParamType;
	
	public Param(String paramName,Object paramValue)
	{
		this.paramName = paramName;
		this.paramValue =  paramValue;
		this.ParamType = ParamType.String;
	}
	
	public Param(String paramName,Object paramValue,ParamType ParamType)
	{
		this.paramName = paramName;
		this.paramValue =  paramValue;
		this.ParamType = ParamType;
	}
	
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public Object getParamValue() {
		return paramValue;
	}
	public void setParamValue(Object paramValue) {
		this.paramValue = paramValue;
	}
	public ParamType getParamType() {
		return ParamType;
	}
	public void setParamType(ParamType paramType) {
		ParamType = paramType;
	}
}
