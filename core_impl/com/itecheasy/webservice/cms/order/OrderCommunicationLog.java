package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for orderCommunicationLog complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderCommunicationLog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="command" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="executeTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modelType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operatorTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
@XmlType(name = "orderCommunicationLog", propOrder = { "command", "executeTime", "id", "modelType", "objectId",
		"operatorId", "operatorTime", "status" })
public class OrderCommunicationLog {

	protected String command;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar executeTime;
	protected int id;
	protected String modelType;
	protected String objectId;
	protected int operatorId;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar operatorTime;
	protected int status;

	/**
	 * Gets the value of the command property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * Sets the value of the command property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCommand(String value) {
		this.command = value;
	}

	/**
	 * Gets the value of the executeTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getExecuteTime() {
		return executeTime;
	}

	/**
	 * Sets the value of the executeTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setExecuteTime(XMLGregorianCalendar value) {
		this.executeTime = value;
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
	 * Gets the value of the modelType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getModelType() {
		return modelType;
	}

	/**
	 * Sets the value of the modelType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setModelType(String value) {
		this.modelType = value;
	}

	/**
	 * Gets the value of the objectId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getObjectId() {
		return objectId;
	}

	/**
	 * Sets the value of the objectId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObjectId(String value) {
		this.objectId = value;
	}

	/**
	 * Gets the value of the operatorId property.
	 * 
	 */
	public int getOperatorId() {
		return operatorId;
	}

	/**
	 * Sets the value of the operatorId property.
	 * 
	 */
	public void setOperatorId(int value) {
		this.operatorId = value;
	}

	/**
	 * Gets the value of the operatorTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getOperatorTime() {
		return operatorTime;
	}

	/**
	 * Sets the value of the operatorTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setOperatorTime(XMLGregorianCalendar value) {
		this.operatorTime = value;
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
