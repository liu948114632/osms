package com.itecheasy.webservice.sw;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for updateOrderAmont complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="updateOrderAmont">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderAmout" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="shippingPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateOrderAmont", propOrder = { "orderCode", "orderAmout", "shippingPrice" })
public class UpdateOrderAmont {

	protected String orderCode;
	protected BigDecimal orderAmout;
	protected BigDecimal shippingPrice;

	/**
	 * Gets the value of the orderCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * Sets the value of the orderCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderCode(String value) {
		this.orderCode = value;
	}

	/**
	 * Gets the value of the orderAmout property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getOrderAmout() {
		return orderAmout;
	}

	/**
	 * Sets the value of the orderAmout property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setOrderAmout(BigDecimal value) {
		this.orderAmout = value;
	}

	/**
	 * Gets the value of the shippingPrice property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getShippingPrice() {
		return shippingPrice;
	}

	/**
	 * Sets the value of the shippingPrice property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setShippingPrice(BigDecimal value) {
		this.shippingPrice = value;
	}

}
