package com.itecheasy.webservice.crm;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for FirstWayOrderInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="FirstWayOrderInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Freight" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OrderItemList" type="{http://tempuri.org/}ArrayOfOrderItem" minOccurs="0"/>
 *         &lt;element name="DeliveryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FirstWayOrderInfo", propOrder = { "orderId", "freight", "orderItemList", "deliveryDate" })
public class FirstWayOrderInfo {

	@XmlElement(name = "OrderId")
	protected String orderId;
	@XmlElement(name = "Freight", required = true)
	protected BigDecimal freight;
	@XmlElement(name = "OrderItemList")
	protected ArrayOfOrderItem orderItemList;
	@XmlElement(name = "DeliveryDate", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar deliveryDate;

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
	 * Gets the value of the freight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getFreight() {
		return freight;
	}

	/**
	 * Sets the value of the freight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setFreight(BigDecimal value) {
		this.freight = value;
	}

	/**
	 * Gets the value of the orderItemList property.
	 * 
	 * @return possible object is {@link ArrayOfOrderItem }
	 * 
	 */
	public ArrayOfOrderItem getOrderItemList() {
		return orderItemList;
	}

	/**
	 * Sets the value of the orderItemList property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfOrderItem }
	 * 
	 */
	public void setOrderItemList(ArrayOfOrderItem value) {
		this.orderItemList = value;
	}

	/**
	 * Gets the value of the deliveryDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * Sets the value of the deliveryDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDeliveryDate(XMLGregorianCalendar value) {
		this.deliveryDate = value;
	}

}
