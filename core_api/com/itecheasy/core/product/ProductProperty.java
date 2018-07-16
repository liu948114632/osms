package com.itecheasy.core.product;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
public class ProductProperty {
	private int productId;
	private int propertyId;
	private int propertyValue;
	private String propertyName;
	private String propertyValueName;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(int propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValueName() {
		return propertyValueName;
	}

	public void setPropertyValueName(String propertyValueName) {
		this.propertyValueName = propertyValueName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + propertyId;
		result = prime * result + propertyValue;
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
		ProductProperty other = (ProductProperty) obj;
		if (propertyId != other.propertyId)
			return false;
		if (propertyValue != other.propertyValue)
			return false;
		return true;
	}


}
