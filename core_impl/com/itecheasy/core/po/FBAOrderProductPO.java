package com.itecheasy.core.po;

import java.math.BigDecimal;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-2-25
 * @description fba订单商品项
 * @version 1.1.7
 */
@Entity
@Table(name = "FBA_order_product")
public class FBAOrderProductPO {
	private int id;
	private int orderProductId;
	private BigDecimal freight;
	private int FBAStoreProductId;
	private int unitQty;
	private int orderId;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "order_product_id")
	public int getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	@Column(name = "freight")
	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	@Column(name = "FBA_store_product_id")
	public int getFBAStoreProductId() {
		return FBAStoreProductId;
	}

	public void setFBAStoreProductId(int fBAStoreProductId) {
		FBAStoreProductId = fBAStoreProductId;
	}

	@Column(name = "unit_qty")
	public int getUnitQty() {
		return unitQty;
	}

	public void setUnitQty(int unitQty) {
		this.unitQty = unitQty;
	}

	@Column(name="order_id")
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
