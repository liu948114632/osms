package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for purchaseProductSizeItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="purchaseProductSizeItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sizeItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sizeItemValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "purchaseProductSizeItem", propOrder = { "id", "sizeItem", "sizeItemValue" })
public class PurchaseProductSizeItem {

	protected Integer id;
	protected String sizeItem;
	protected String sizeItemValue;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setId(Integer value) {
		this.id = value;
	}

	/**
	 * Gets the value of the sizeItem property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSizeItem() {
		return sizeItem;
	}

	/**
	 * Sets the value of the sizeItem property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSizeItem(String value) {
		this.sizeItem = value;
	}

	/**
	 * Gets the value of the sizeItemValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSizeItemValue() {
		return sizeItemValue;
	}

	/**
	 * Sets the value of the sizeItemValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSizeItemValue(String value) {
		this.sizeItemValue = value;
	}

}
