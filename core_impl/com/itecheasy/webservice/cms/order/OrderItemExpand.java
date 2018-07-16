package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for orderItemExpand complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderItemExpand">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ebayItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ebayItemTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fbaBarCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fbaBarNew" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fbaBarTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderItemExpand", propOrder = { "ebayItemId", "ebayItemTitle", "fbaBarCode", "fbaBarNew",
		"fbaBarTitle", "id", "transNo" })
public class OrderItemExpand {

	protected String ebayItemId;
	protected String ebayItemTitle;
	protected String fbaBarCode;
	protected String fbaBarNew;
	protected String fbaBarTitle;
	protected int id;
	protected String transNo;

	/**
	 * Gets the value of the ebayItemId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEbayItemId() {
		return ebayItemId;
	}

	/**
	 * Sets the value of the ebayItemId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEbayItemId(String value) {
		this.ebayItemId = value;
	}

	/**
	 * Gets the value of the ebayItemTitle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEbayItemTitle() {
		return ebayItemTitle;
	}

	/**
	 * Sets the value of the ebayItemTitle property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEbayItemTitle(String value) {
		this.ebayItemTitle = value;
	}

	/**
	 * Gets the value of the fbaBarCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFbaBarCode() {
		return fbaBarCode;
	}

	/**
	 * Sets the value of the fbaBarCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFbaBarCode(String value) {
		this.fbaBarCode = value;
	}

	/**
	 * Gets the value of the fbaBarNew property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFbaBarNew() {
		return fbaBarNew;
	}

	/**
	 * Sets the value of the fbaBarNew property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFbaBarNew(String value) {
		this.fbaBarNew = value;
	}

	/**
	 * Gets the value of the fbaBarTitle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFbaBarTitle() {
		return fbaBarTitle;
	}

	/**
	 * Sets the value of the fbaBarTitle property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFbaBarTitle(String value) {
		this.fbaBarTitle = value;
	}

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
	 * Gets the value of the transNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransNo() {
		return transNo;
	}

	/**
	 * Sets the value of the transNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransNo(String value) {
		this.transNo = value;
	}

}
