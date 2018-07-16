package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for orderReadySellLackLog complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderReadySellLackLog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="execTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lockQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderReadySellLackLog", propOrder = { "createTime", "execTime", "id", "lockQuantity", "orderCode",
		"productId", "status" })
public class OrderReadySellLackLog {

	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar createTime;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar execTime;
	protected int id;
	protected int lockQuantity;
	protected String orderCode;
	protected int productId;
	protected int status;

	/**
	 * Gets the value of the createTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getCreateTime() {
		return createTime;
	}

	/**
	 * Sets the value of the createTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setCreateTime(XMLGregorianCalendar value) {
		this.createTime = value;
	}

	/**
	 * Gets the value of the execTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getExecTime() {
		return execTime;
	}

	/**
	 * Sets the value of the execTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setExecTime(XMLGregorianCalendar value) {
		this.execTime = value;
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
	 * Gets the value of the lockQuantity property.
	 * 
	 */
	public int getLockQuantity() {
		return lockQuantity;
	}

	/**
	 * Sets the value of the lockQuantity property.
	 * 
	 */
	public void setLockQuantity(int value) {
		this.lockQuantity = value;
	}

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
	 * Gets the value of the status property.
	 * 
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 */
	public void setStatus(int value) {
		this.status = value;
	}

}
