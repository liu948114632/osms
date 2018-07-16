package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getLastOrderWeighingRecordByOrderCodeResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getLastOrderWeighingRecordByOrderCodeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://osms.communication.itecheasy.com/}orderWeighingRecordInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLastOrderWeighingRecordByOrderCodeResponse", propOrder = { "_return" })
public class GetLastOrderWeighingRecordByOrderCodeResponse {

	@XmlElement(name = "return")
	protected OrderWeighingRecordInfo _return;

	/**
	 * Gets the value of the return property.
	 * 
	 * @return possible object is {@link OrderWeighingRecordInfo }
	 * 
	 */
	public OrderWeighingRecordInfo getReturn() {
		return _return;
	}

	/**
	 * Sets the value of the return property.
	 * 
	 * @param value
	 *            allowed object is {@link OrderWeighingRecordInfo }
	 * 
	 */
	public void setReturn(OrderWeighingRecordInfo value) {
		this._return = value;
	}

}
