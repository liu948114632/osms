package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for BussinessException complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="BussinessException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorData" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BussinessException", propOrder = { "errorData", "errorCode" })
public class BussinessException {

	@XmlElement(required = true, nillable = true)
	protected String errorData;
	@XmlElement(required = true, nillable = true)
	protected String errorCode;

	/**
	 * Gets the value of the errorData property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getErrorData() {
		return errorData;
	}

	/**
	 * Sets the value of the errorData property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setErrorData(String value) {
		this.errorData = value;
	}

	/**
	 * Gets the value of the errorCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the value of the errorCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setErrorCode(String value) {
		this.errorCode = value;
	}

}
