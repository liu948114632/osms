package com.itecheasy.core.order;

import java.math.BigDecimal;

/**
 * @author wanghw
 * @date 2016-2-25
 * @description fba订单商品项
 * @version 1.1.7
 */
public class FBAOrderProduct {
	private int id;
	private int orderProductId;
	private BigDecimal freight;
	private int FBAStoreProductId;
	private int unitQty;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public int getFBAStoreProductId() {
		return FBAStoreProductId;
	}

	public void setFBAStoreProductId(int fBAStoreProductId) {
		FBAStoreProductId = fBAStoreProductId;
	}

	public int getUnitQty() {
		return unitQty;
	}

	public void setUnitQty(int unitQty) {
		this.unitQty = unitQty;
	}

}
