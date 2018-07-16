package com.itecheasy.core.product;

import java.math.BigDecimal;

/**
 * @author wanghw
 * @date 2016-1-11
 * @description TODO
 * @version
 */
public class ProductFreight {
	private String productCode;
	private int shipping_method;
	private int country;
	private int currency; // 需要显示的币种
	private BigDecimal freight;
	private BigDecimal weight;

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getShipping_method() {
		return shipping_method;
	}

	public void setShipping_method(int shipping_method) {
		this.shipping_method = shipping_method;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

}
