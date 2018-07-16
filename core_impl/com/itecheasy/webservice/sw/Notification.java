package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for notification complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="notification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toSystemCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://osms.communication.itecheasy.com/}notificationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notification", propOrder = { "createdTime", "id", "message", "objectCode", "toSystemCode", "type" })
public class Notification {

	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar createdTime;
	protected int id;
	protected String message;
	protected String objectCode;
	protected String toSystemCode;
	protected NotificationType type;

	/**
	 * Gets the value of the createdTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getCreatedTime() {
		return createdTime;
	}

	/**
	 * Sets the value of the createdTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setCreatedTime(XMLGregorianCalendar value) {
		this.createdTime = value;
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
	 * Gets the value of the message property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the value of the message property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessage(String value) {
		this.message = value;
	}

	/**
	 * Gets the value of the objectCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getObjectCode() {
		return objectCode;
	}

	/**
	 * Sets the value of the objectCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObjectCode(String value) {
		this.objectCode = value;
	}

	/**
	 * Gets the value of the toSystemCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getToSystemCode() {
		return toSystemCode;
	}

	/**
	 * Sets the value of the toSystemCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setToSystemCode(String value) {
		this.toSystemCode = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link NotificationType }
	 * 
	 */
	public NotificationType getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link NotificationType }
	 * 
	 */
	public void setType(NotificationType value) {
		this.type = value;
	}

}
