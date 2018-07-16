
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for putTransportContent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="putTransportContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="api" type="{http://amazon.core.itecheasy.com/}amazonConfigInfo" minOccurs="0"/>
 *         &lt;element name="transportContentVO" type="{http://amazon.core.itecheasy.com/}transportContentVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putTransportContent", propOrder = {
    "api",
    "transportContentVO"
})
public class PutTransportContent {

    protected AmazonConfigInfo api;
    protected TransportContentVO transportContentVO;

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
     * Gets the value of the transportContentVO property.
     * 
     * @return
     *     possible object is
     *     {@link TransportContentVO }
     *     
     */
    public TransportContentVO getTransportContentVO() {
        return transportContentVO;
    }

    /**
     * Sets the value of the transportContentVO property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportContentVO }
     *     
     */
    public void setTransportContentVO(TransportContentVO value) {
        this.transportContentVO = value;
    }

}
