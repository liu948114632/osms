package com.itecheasy.webservice.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for productPicture complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="productPicture">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orderIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pictureCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pictureName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="picturePrimitiveName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productPicture", propOrder = { "id", "orderIndex", "pictureCode", "pictureName",
		"picturePrimitiveName", "productId", "type" })
public class ProductPicture {

	protected int id;
	protected int orderIndex;
	protected String pictureCode;
	protected String pictureName;
	protected String picturePrimitiveName;
	protected int productId;
	protected int type;

	/**
	 * Gets the value of the id property.
	 * 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 */
	public void setId(int value) {
		this.id = value;
	}

	/**
	 * Gets the value of the orderIndex property.
	 * 
	 */
	public int getOrderIndex() {
		return orderIndex;
	}

	/**
	 * Sets the value of the orderIndex property.
	 * 
	 */
	public void setOrderIndex(int value) {
		this.orderIndex = value;
	}

	/**
	 * Gets the value of the pictureCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPictureCode() {
		return pictureCode;
	}

	/**
	 * Sets the value of the pictureCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPictureCode(String value) {
		this.pictureCode = value;
	}

	/**
	 * Gets the value of the pictureName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPictureName() {
		return pictureName;
	}

	/**
	 * Sets the value of the pictureName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPictureName(String value) {
		this.pictureName = value;
	}

	/**
	 * Gets the value of the picturePrimitiveName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPicturePrimitiveName() {
		return picturePrimitiveName;
	}

	/**
	 * Sets the value of the picturePrimitiveName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPicturePrimitiveName(String value) {
		this.picturePrimitiveName = value;
	}

	/**
	 * Gets the value of the productId property.
	 * 
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Sets the value of the productId property.
	 * 
	 */
	public void setProductId(int value) {
		this.productId = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 */
	public int getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 */
	public void setType(int value) {
		this.type = value;
	}

}
