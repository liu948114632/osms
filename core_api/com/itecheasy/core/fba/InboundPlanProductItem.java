package com.itecheasy.core.fba;

/**
 * @author taozihao
 * @date 2018年6月7日 下午12:39:08
 * @description 补货计划的商品项
 */
public class InboundPlanProductItem {

	private String sku;
	private int quantity;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
