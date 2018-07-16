
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cancelOrder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancelOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cancels" type="{http://amazon.core.itecheasy.com/}cancelOrderBO" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "cancelOrder", propOrder = {
    "cancels",
    "api"
})
public class CancelOrder {

    protected List<CancelOrderBO> cancels;
    protected AmazonConfigInfo api;

    /**
     * Gets the value of the cancels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CancelOrderBO }
     * 
     * 
     */
    public List<CancelOrderBO> getCancels() {
        if (cancels == null) {
            cancels = new ArrayList<CancelOrderBO>();
        }
        return this.cancels;
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
