package com.itecheasy.core.order;

/**
 * @author wanghw
 * @date 2015-6-24
 * @description TODO
 * @version
 */
public class UpdateOrderProductForm {
	private int fbaShopProductId;
	private int orderProductId;
	private String updateProductCode;
	private double qty;
	private int unitQty;
	private String productRemark;
	private String sku;

	public int getFbaShopProductId() {
		return fbaShopProductId;
	}

	public void setFbaShopProductId(int fbaShopProductId) {
		this.fbaShopProductId = fbaShopProductId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getUnitQty() {
		return unitQty;
	}

	public void setUnitQty(int unitQty) {
		this.unitQty = unitQty;
	}

	public String getProductRemark() {
		return productRemark;
	}

	public void setProductRemark(String productRemark) {
		this.productRemark = productRemark;
	}

	public int getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	public String getUpdateProductCode() {
		return updateProductCode;
	}

	public void setUpdateProductCode(String updateProductCode) {
		this.updateProductCode = updateProductCode;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

}
