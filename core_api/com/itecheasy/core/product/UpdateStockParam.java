package com.itecheasy.core.product;
/** 
 * @author whw
 * @date 2018-2-24 
 * @description TODO
 * @version 
 */
public class UpdateStockParam {
	public enum UpdateStockHandle{
		/**
		 * 转换部门库存
		 */
		CONVERT,
		/**
		 * 共享
		 */
		SHARE
	}
	private Integer cmsProductId;
	private Integer productId;
	private Integer fbaStockQty; //FBA/海外仓备货库存
	private Integer sellingOrderStockQty; //自卖商品备货库存
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getFbaStockQty() {
		return fbaStockQty;
	}
	public void setFbaStockQty(Integer fbaStockQty) {
		this.fbaStockQty = fbaStockQty;
	}
	public Integer getSellingOrderStockQty() {
		return sellingOrderStockQty;
	}
	public void setSellingOrderStockQty(Integer sellingOrderStockQty) {
		this.sellingOrderStockQty = sellingOrderStockQty;
	}
	public Integer getCmsProductId() {
		return cmsProductId;
	}
	public void setCmsProductId(Integer cmsProductId) {
		this.cmsProductId = cmsProductId;
	}
	
	
}
