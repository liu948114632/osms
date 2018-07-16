package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for orderTrackingAttachment complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderTrackingAttachment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attachmentCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attachmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="file" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="orderTrackingItemId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderTrackingAttachment", propOrder = { "attachmentCode", "attachmentName", "file", "id",
		"orderTrackingItemId", "type" })
public class OrderTrackingAttachment {

	protected String attachmentCode;
	protected String attachmentName;
	protected String file;
	protected Integer id;
	protected Integer orderTrackingItemId;
	protected Integer type;

	/**
	 * Gets the value of the attachmentCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAttachmentCode() {
		return attachmentCode;
	}

	/**
	 * Sets the value of the attachmentCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAttachmentCode(String value) {
		this.attachmentCode = value;
	}

	/**
	 * Gets the value of the attachmentName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAttachmentName() {
		return attachmentName;
	}

	/**
	 * Sets the value of the attachmentName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAttachmentName(String value) {
		this.attachmentName = value;
	}

	/**
	 * Gets the value of the file property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFile() {
		return file;
	}

	/**
	 * Sets the value of the file property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFile(String value) {
		this.file = value;
	}

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
	 * Gets the value of the orderTrackingItemId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getOrderTrackingItemId() {
		return orderTrackingItemId;
	}

	/**
	 * Sets the value of the orderTrackingItemId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setOrderTrackingItemId(Integer value) {
		this.orderTrackingItemId = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setType(Integer value) {
		this.type = value;
	}

}
