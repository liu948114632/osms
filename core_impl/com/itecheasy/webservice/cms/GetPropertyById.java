package com.itecheasy.webservice.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getPropertyById complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getPropertyById">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="propertyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPropertyById", propOrder = { "propertyId" })
public class GetPropertyById {

	protected int propertyId;

	/**
	 * Gets the value of the propertyId property.
	 * 
	 */
	public int getPropertyId() {
		return propertyId;
	}

	/**
	 * Sets the value of the propertyId property.
	 * 
	 */
	public void setPropertyId(int value) {
		this.propertyId = value;
	}

}
