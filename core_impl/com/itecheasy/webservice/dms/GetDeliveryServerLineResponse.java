package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for GetDeliveryServerLineResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="GetDeliveryServerLineResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://out.webservice.dms.itecheasy.com/}serverLineInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDeliveryServerLineResponse", propOrder = { "_return" })
public class GetDeliveryServerLineResponse {

	@XmlElement(name = "return")
	protected ServerLineInfo _return;

	/**
	 * Gets the value of the return property.
	 * 
	 * @return possible object is {@link ServerLineInfo }
	 * 
	 */
	public ServerLineInfo getReturn() {
		return _return;
	}

	/**
	 * Sets the value of the return property.
	 * 
	 * @param value
	 *            allowed object is {@link ServerLineInfo }
	 * 
	 */
	public void setReturn(ServerLineInfo value) {
		this._return = value;
	}

}
