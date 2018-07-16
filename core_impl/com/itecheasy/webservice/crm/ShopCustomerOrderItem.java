package com.itecheasy.webservice.crm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ShopCustomerOrderItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ShopCustomerOrderItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="OrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderItemId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShopCustomerOrderItem", propOrder = { "id", "orderId", "orderItemId", "productCode", "transactionID",
		"itemID", "itemTitle" })
public class ShopCustomerOrderItem {

	@XmlElement(name = "Id")
	protected int id;
	@XmlElement(name = "OrderId")
	protected String orderId;
	@XmlElement(name = "OrderItemId")
	protected int orderItemId;
	@XmlElement(name = "ProductCode")
	protected String productCode;
	@XmlElement(name = "TransactionID")
	protected String transactionID;
	@XmlElement(name = "ItemID")
	protected String itemID;
	@XmlElement(name = "ItemTitle")
	protected String itemTitle;

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
	 * Gets the value of the orderId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * Sets the value of the orderId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderId(String value) {
		this.orderId = value;
	}

	/**
	 * Gets the value of the orderItemId property.
	 * 
	 */
	public int getOrderItemId() {
		return orderItemId;
	}

	/**
	 * Sets the value of the orderItemId property.
	 * 
	 */
	public void setOrderItemId(int value) {
		this.orderItemId = value;
	}

	/**
	 * Gets the value of the productCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * Sets the value of the productCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductCode(String value) {
		this.productCode = value;
	}

	/**
	 * Gets the value of the transactionID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionID() {
		return transactionID;
	}

	/**
	 * Sets the value of the transactionID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionID(String value) {
		this.transactionID = value;
	}

	/**
	 * Gets the value of the itemID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getItemID() {
		return itemID;
	}

	/**
	 * Sets the value of the itemID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setItemID(String value) {
		this.itemID = value;
	}

	/**
	 * Gets the value of the itemTitle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getItemTitle() {
		return itemTitle;
	}

	/**
	 * Sets the value of the itemTitle property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setItemTitle(String value) {
		this.itemTitle = value;
	}

}
