package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "product_property_value")
public class ProductPropertyValuePo {
	private int id;
	private int productId;
	private int propertyId;
	private int propertyValue;
	private String propertyName;
	private String propertyValueName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "product_id")
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "property_id")
	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	@Column(name = "property_value")
	public int getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(int propertyValue) {
		this.propertyValue = propertyValue;
	}

	@Column(name = "property_name")
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@Column(name = "property_value_name")
	public String getPropertyValueName() {
		return propertyValueName;
	}

	public void setPropertyValueName(String propertyValueName) {
		this.propertyValueName = propertyValueName;
	}

}
