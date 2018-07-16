package com.itecheasy.common.dao;

public class Order {
	private String orderField;
	private OrderType type;
	
	public static enum OrderType{
		asc,
		desc
	}
	public Order(String orderField){
		this.orderField = orderField;
		this.type = OrderType.asc;
	}
	public Order(String orderField,OrderType type){
		this.orderField = orderField;
		this.type = type;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public OrderType getType() {
		return type;
	}
	public void setType(OrderType type) {
		this.type = type;
	}
	
	
}
