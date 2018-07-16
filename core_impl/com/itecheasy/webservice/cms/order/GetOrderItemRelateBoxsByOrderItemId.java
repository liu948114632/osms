package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getOrderItemRelateBoxsByOrderItemId complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getOrderItemRelateBoxsByOrderItemId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderItemId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOrderItemRelateBoxsByOrderItemId", propOrder = { "orderItemId" })
public class GetOrderItemRelateBoxsByOrderItemId {

	protected int orderItemId;

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

}
