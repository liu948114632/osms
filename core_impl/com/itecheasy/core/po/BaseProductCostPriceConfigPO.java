package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-1-11
 * @description TODO
 * @version
 */
@Entity
@Table(name="base_product_cost_price_config")
public class BaseProductCostPriceConfigPO {
	private int id;
	private int currency;
	private int shippingMethod;
	private int country;

	@Column
	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="shpping_method")
	public int getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(int shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	@Column(name="country")
	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

}
