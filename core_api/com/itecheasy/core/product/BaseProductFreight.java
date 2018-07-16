package com.itecheasy.core.product;

import java.math.BigDecimal;

/**
 * @author wanghw
 * @date 2016-1-13
 * @description TODO
 * @version
 */
public class BaseProductFreight {
	protected BigDecimal amount;
	protected String code;
	protected Integer countyId;
	protected Integer shippingMethod;
	protected BigDecimal weight;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCountyId() {
		return countyId;
	}

	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}

	public Integer getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(Integer shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countyId == null) ? 0 : countyId.hashCode());
		result = prime * result + ((shippingMethod == null) ? 0 : shippingMethod.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		BaseProductFreight other = (BaseProductFreight) obj;
		if (countyId == null) {
			if (other.countyId != null)
				return false;
		} else if (!countyId.equals(other.countyId))
			return false;
		if (shippingMethod == null) {
			if (other.shippingMethod != null)
				return false;
		} else if (!shippingMethod.equals(other.shippingMethod))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

}
