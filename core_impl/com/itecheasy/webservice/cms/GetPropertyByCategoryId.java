package com.itecheasy.webservice.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getPropertyByCategoryId complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getPropertyByCategoryId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cateId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPropertyByCategoryId", propOrder = { "cateId" })
public class GetPropertyByCategoryId {

	protected int cateId;

	/**
	 * Gets the value of the cateId property.
	 * 
	 */
	public int getCateId() {
		return cateId;
	}

	/**
	 * Sets the value of the cateId property.
	 * 
	 */
	public void setCateId(int value) {
		this.cateId = value;
	}

}
