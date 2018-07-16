
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getOrderItems complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getOrderItems">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amazonOrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="api" type="{http://amazon.core.itecheasy.com/}amazonConfigInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOrderItems", propOrder = {
    "amazonOrderId",
    "api"
})
public class GetOrderItems {

    protected String amazonOrderId;
    protected AmazonConfigInfo api;

    /**
     * Gets the value of the amazonOrderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    /**
     * Sets the value of the amazonOrderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonOrderId(String value) {
        this.amazonOrderId = value;
    }

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

}
