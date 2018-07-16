package com.itecheasy.core.product;

import java.math.BigDecimal;

/** 
 * @author whw
 * @date 2018-2-28 
 * @description TODO
 * @version 
 */
public class OsmsStock {
	private int cmsProductId;
	private int productId;
	private String cmsProductCode;
	private double availableQuantity;
	private double realFreezeQuantity;
	
	private BigDecimal fbaStock; //fba备货库存
	private BigDecimal orderStock;//订单备货库存
	public int getCmsProductId() {
		return cmsProductId;
	}
	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCmsProductCode() {
		return cmsProductCode;
	}
	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}
	public BigDecimal getFbaStock() {
		return fbaStock==null?BigDecimal.ZERO:fbaStock;
	}
	public void setFbaStock(BigDecimal fbaStock) {
		this.fbaStock = fbaStock;
	}
	public BigDecimal getOrderStock() {
		return orderStock==null?BigDecimal.ZERO:orderStock;
	}
	public void setOrderStock(BigDecimal orderStock) {
		this.orderStock = orderStock;
	}
	public double getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public double getRealFreezeQuantity() {
		return realFreezeQuantity;
	}
	public void setRealFreezeQuantity(double realFreezeQuantity) {
		this.realFreezeQuantity = realFreezeQuantity;
	}
}
