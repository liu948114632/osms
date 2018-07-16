
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listInboundShipmentsByNextTokenResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listInboundShipmentsByNextTokenResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://amazon.core.itecheasy.com/}listInboundShipmentsResultVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listInboundShipmentsByNextTokenResponse", propOrder = {
    "_return"
})
public class ListInboundShipmentsByNextTokenResponse {

    @XmlElement(name = "return")
    protected ListInboundShipmentsResultVO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link ListInboundShipmentsResultVO }
     *     
     */
    public ListInboundShipmentsResultVO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListInboundShipmentsResultVO }
     *     
     */
    public void setReturn(ListInboundShipmentsResultVO value) {
        this._return = value;
    }

}
