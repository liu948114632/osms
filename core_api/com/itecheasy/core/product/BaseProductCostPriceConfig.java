package com.itecheasy.core.product;

/**
 * @author wanghw
 * @date 2016-1-11
 * @description TODO
 * @version
 */
public class BaseProductCostPriceConfig {
	private int id;
	private int currency;
	private int shippingMethod;
	private int country;

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(int shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + country;
		result = prime * result + currency;
		result = prime * result + shippingMethod;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseProductCostPriceConfig other = (BaseProductCostPriceConfig) obj;
		if (country != other.country)
			return false;
		if (currency != other.currency)
			return false;
		if (shippingMethod != other.shippingMethod)
			return false;
		return true;
	}

	
}
