package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getInvoiceResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getInvoiceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://out.webservice.dms.itecheasy.com/}invoiceInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInvoiceResponse", propOrder = { "_return" })
public class GetInvoiceResponse {

	@XmlElement(name = "return")
	protected InvoiceInfo _return;

	/**
	 * Gets the value of the return property.
	 * 
	 * @return possible object is {@link InvoiceInfo }
	 * 
	 */
	public InvoiceInfo getReturn() {
		return _return;
	}

	/**
	 * Sets the value of the return property.
	 * 
	 * @param value
	 *            allowed object is {@link InvoiceInfo }
	 * 
	 */
	public void setReturn(InvoiceInfo value) {
		this._return = value;
	}

}
