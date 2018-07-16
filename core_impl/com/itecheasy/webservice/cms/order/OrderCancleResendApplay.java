package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for orderCancleResendApplay complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderCancleResendApplay">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applayOperaterCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applayOperaterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applayTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="applayType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmDepartmentId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="confirmOperaterCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmOperaterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operaterType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderCancleResendApplay", propOrder = { "applayOperaterCode", "applayOperaterName", "applayTime",
		"applayType", "cause", "confirmDepartmentId", "confirmOperaterCode", "confirmOperaterName", "confirmTime",
		"id", "operaterType" })
public class OrderCancleResendApplay {

	protected String applayOperaterCode;
	protected String applayOperaterName;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar applayTime;
	protected int applayType;
	protected String cause;
	protected Integer confirmDepartmentId;
	protected String confirmOperaterCode;
	protected String confirmOperaterName;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar confirmTime;
	protected int id;
	protected int operaterType;

	/**
	 * Gets the value of the applayOperaterCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getApplayOperaterCode() {
		return applayOperaterCode;
	}

	/**
	 * Sets the value of the applayOperaterCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setApplayOperaterCode(String value) {
		this.applayOperaterCode = value;
	}

	/**
	 * Gets the value of the applayOperaterName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getApplayOperaterName() {
		return applayOperaterName;
	}

	/**
	 * Sets the value of the applayOperaterName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setApplayOperaterName(String value) {
		this.applayOperaterName = value;
	}

	/**
	 * Gets the value of the applayTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getApplayTime() {
		return applayTime;
	}

	/**
	 * Sets the value of the applayTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setApplayTime(XMLGregorianCalendar value) {
		this.applayTime = value;
	}

	/**
	 * Gets the value of the applayType property.
	 * 
	 */
	public int getApplayType() {
		return applayType;
	}

	/**
	 * Sets the value of the applayType property.
	 * 
	 */
	public void setApplayType(int value) {
		this.applayType = value;
	}

	/**
	 * Gets the value of the cause property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCause() {
		return cause;
	}

	/**
	 * Sets the value of the cause property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCause(String value) {
		this.cause = value;
	}

	/**
	 * Gets the value of the confirmDepartmentId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getConfirmDepartmentId() {
		return confirmDepartmentId;
	}

	/**
	 * Sets the value of the confirmDepartmentId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setConfirmDepartmentId(Integer value) {
		this.confirmDepartmentId = value;
	}

	/**
	 * Gets the value of the confirmOperaterCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getConfirmOperaterCode() {
		return confirmOperaterCode;
	}

	/**
	 * Sets the value of the confirmOperaterCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setConfirmOperaterCode(String value) {
		this.confirmOperaterCode = value;
	}

	/**
	 * Gets the value of the confirmOperaterName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getConfirmOperaterName() {
		return confirmOperaterName;
	}

	/**
	 * Sets the value of the confirmOperaterName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setConfirmOperaterName(String value) {
		this.confirmOperaterName = value;
	}

	/**
	 * Gets the value of the confirmTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getConfirmTime() {
		return confirmTime;
	}

	/**
	 * Sets the value of the confirmTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setConfirmTime(XMLGregorianCalendar value) {
		this.confirmTime = value;
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
	 * Gets the value of the operaterType property.
	 * 
	 */
	public int getOperaterType() {
		return operaterType;
	}

	/**
	 * Sets the value of the operaterType property.
	 * 
	 */
	public void setOperaterType(int value) {
		this.operaterType = value;
	}

}
