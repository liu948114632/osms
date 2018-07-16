package com.itecheasy.core.order;

/**
 * @author wanghw
 * @date 2017-1-11
 * @description TODO
 * @version 1.2.2
 */
public class BaseOrderItem {
	private int id;
	/**
	 * 计划备货数
	 * 
	 */
	private double orderQty;
	/**
	 * 实际备货数
	 * 
	 */
	private double prepareQty;
	/**
	 * 订单项状态：备货中(1), 断货(4), 已备货(8), 完成(10), 取消(12);
	 * 
	 */
	private int status;
	/**
	 * 备货商品id
	 * 
	 */
	private int cmsProductId;

	private String cmsProductCode;
	/**
	 * 批量数量
	 * 
	 */
	private int unitQty;
	/**
	 * 批量单位
	 * 
	 */
	private String unit;

	private double costPrice;

	private int orderId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(double orderQty) {
		this.orderQty = orderQty;
	}

	public double getPrepareQty() {
		return prepareQty;
	}

	public void setPrepareQty(double prepareQty) {
		this.prepareQty = prepareQty;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	public int getUnitQty() {
		return unitQty;
	}

	public void setUnitQty(int unitQty) {
		this.unitQty = unitQty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

}
