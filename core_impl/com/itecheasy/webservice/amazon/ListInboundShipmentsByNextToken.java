
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listInboundShipmentsByNextToken complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listInboundShipmentsByNextToken">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="api" type="{http://amazon.core.itecheasy.com/}amazonConfigInfo" minOccurs="0"/>
 *         &lt;element name="amazonShipmentStatusListVO" type="{http://amazon.core.itecheasy.com/}amazonShipmentStatusListVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listInboundShipmentsByNextToken", propOrder = {
    "api",
    "amazonShipmentStatusListVO"
})
public class ListInboundShipmentsByNextToken {

    protected AmazonConfigInfo api;
    protected AmazonShipmentStatusListVO amazonShipmentStatusListVO;

    /**
     * Gets the value of the api property.
     * 
     * @return
     *     possible object is
     *     {@link AmazonConfigInfo }
     *     
     */
    public AmazonConfigInfo getApi() {
        return api;
    }

    /**
     * Sets the value of the api property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmazonConfigInfo }
     *     
     */
    public void setApi(AmazonConfigInfo value) {
        this.api = value;
    }

    /**
     * Gets the value of the amazonShipmentStatusListVO property.
     * 
     * @return
     *     possible object is
     *     {@link AmazonShipmentStatusListVO }
     *     
     */
    public AmazonShipmentStatusListVO getAmazonShipmentStatusListVO() {
        return amazonShipmentStatusListVO;
    }

    /**
     * Sets the value of the amazonShipmentStatusListVO property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmazonShipmentStatusListVO }
     *     
     */
    public void setAmazonShipmentStatusListVO(AmazonShipmentStatusListVO value) {
        this.amazonShipmentStatusListVO = value;
    }

}
