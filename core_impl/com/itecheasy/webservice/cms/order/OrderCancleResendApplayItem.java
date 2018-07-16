package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for orderCancleResendApplayItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderCancleResendApplayItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applayId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="collectTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="collectUserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isReceived" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orderStatusSnap" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="processStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="receiveDepartmentIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnDepartmentId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stockOutId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderCancleResendApplayItem", propOrder = { "applayId", "collectTime", "collectUserId", "id",
		"isReceived", "orderId", "orderStatusSnap", "processStatus", "receiveDepartmentIds", "returnDepartmentId",
		"stockOutId" })
public class OrderCancleResendApplayItem {

	protected int applayId;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar collectTime;
	protected int collectUserId;
	protected int id;
	protected Boolean isReceived;
	protected int orderId;
	protected int orderStatusSnap;
	protected int processStatus;
	protected String receiveDepartmentIds;
	protected int returnDepartmentId;
	protected int stockOutId;

	/**
	 * Gets the value of the applayId property.
	 * 
	 */
	public int getApplayId() {
		return applayId;
	}

	/**
	 * Sets the value of the applayId property.
	 * 
	 */
	public void setApplayId(int value) {
		this.applayId = value;
	}

	/**
	 * Gets the value of the collectTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getCollectTime() {
		return collectTime;
	}

	/**
	 * Sets the value of the collectTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setCollectTime(XMLGregorianCalendar value) {
		this.collectTime = value;
	}

	/**
	 * Gets the value of the collectUserId property.
	 * 
	 */
	public int getCollectUserId() {
		return collectUserId;
	}

	/**
	 * Sets the value of the collectUserId property.
	 * 
	 */
	public void setCollectUserId(int value) {
		this.collectUserId = value;
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
	 * Gets the value of the isReceived property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsReceived() {
		return isReceived;
	}

	/**
	 * Sets the value of the isReceived property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsReceived(Boolean value) {
		this.isReceived = value;
	}

	/**
	 * Gets the value of the orderId property.
	 * 
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Sets the value of the orderId property.
	 * 
	 */
	public void setOrderId(int value) {
		this.orderId = value;
	}

	/**
	 * Gets the value of the orderStatusSnap property.
	 * 
	 */
	public int getOrderStatusSnap() {
		return orderStatusSnap;
	}

	/**
	 * Sets the value of the orderStatusSnap property.
	 * 
	 */
	public void setOrderStatusSnap(int value) {
		this.orderStatusSnap = value;
	}

	/**
	 * Gets the value of the processStatus property.
	 * 
	 */
	public int getProcessStatus() {
		return processStatus;
	}

	/**
	 * Sets the value of the processStatus property.
	 * 
	 */
	public void setProcessStatus(int value) {
		this.processStatus = value;
	}

	/**
	 * Gets the value of the receiveDepartmentIds property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReceiveDepartmentIds() {
		return receiveDepartmentIds;
	}

	/**
	 * Sets the value of the receiveDepartmentIds property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReceiveDepartmentIds(String value) {
		this.receiveDepartmentIds = value;
	}

	/**
	 * Gets the value of the returnDepartmentId property.
	 * 
	 */
	public int getReturnDepartmentId() {
		return returnDepartmentId;
	}

	/**
	 * Sets the value of the returnDepartmentId property.
	 * 
	 */
	public void setReturnDepartmentId(int value) {
		this.returnDepartmentId = value;
	}

	/**
	 * Gets the value of the stockOutId property.
	 * 
	 */
	public int getStockOutId() {
		return stockOutId;
	}

	/**
	 * Sets the value of the stockOutId property.
	 * 
	 */
	public void setStockOutId(int value) {
		this.stockOutId = value;
	}

}
