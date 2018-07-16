package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getFedexAgentDeliveryShippingMethodResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getFedexAgentDeliveryShippingMethodResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFedexAgentDeliveryShippingMethodResponse", propOrder = { "_return" })
public class GetFedexAgentDeliveryShippingMethodResponse {

	@XmlElement(name = "return")
	protected int _return;

	/**
	 * Gets the value of the return property.
	 * 
	 */
	public int getReturn() {
		return _return;
	}

	/**
	 * Sets the value of the return property.
	 * 
	 */
	public void setReturn(int value) {
		this._return = value;
	}

}
