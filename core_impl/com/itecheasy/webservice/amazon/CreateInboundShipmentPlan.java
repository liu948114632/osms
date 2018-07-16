
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createInboundShipmentPlan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createInboundShipmentPlan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="api" type="{http://amazon.core.itecheasy.com/}amazonConfigInfo" minOccurs="0"/>
 *         &lt;element name="itemList" type="{http://amazon.core.itecheasy.com/}inboundItemVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="shipFromAddress" type="{http://amazon.core.itecheasy.com/}addressVO" minOccurs="0"/>
 *         &lt;element name="shipToCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createInboundShipmentPlan", propOrder = {
    "api",
    "itemList",
    "shipFromAddress",
    "shipToCountryCode"
})
public class CreateInboundShipmentPlan {

    protected AmazonConfigInfo api;
    protected List<InboundItemVO> itemList;
    protected AddressVO shipFromAddress;
    protected String shipToCountryCode;

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
     * Gets the value of the itemList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InboundItemVO }
     * 
     * 
     */
    public List<InboundItemVO> getItemList() {
        if (itemList == null) {
            itemList = new ArrayList<InboundItemVO>();
        }
        return this.itemList;
    }

    /**
     * Gets the value of the shipFromAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressVO }
     *     
     */
    public AddressVO getShipFromAddress() {
        return shipFromAddress;
    }

    /**
     * Sets the value of the shipFromAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressVO }
     *     
     */
    public void setShipFromAddress(AddressVO value) {
        this.shipFromAddress = value;
    }

    /**
     * Gets the value of the shipToCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipToCountryCode() {
        return shipToCountryCode;
    }

    /**
     * Sets the value of the shipToCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipToCountryCode(String value) {
        this.shipToCountryCode = value;
    }

}
