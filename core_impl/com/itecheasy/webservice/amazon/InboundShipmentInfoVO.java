
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for inboundShipmentInfoVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="inboundShipmentInfoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="areCasesRequired" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinationFulfillmentCenterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="labelPrepType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipFromAddress" type="{http://amazon.core.itecheasy.com/}addressVO" minOccurs="0"/>
 *         &lt;element name="shipmentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipmentStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inboundShipmentInfoVO", propOrder = {
    "areCasesRequired",
    "destinationFulfillmentCenterId",
    "labelPrepType",
    "shipFromAddress",
    "shipmentId",
    "shipmentName",
    "shipmentStatus"
})
public class InboundShipmentInfoVO {

    protected String areCasesRequired;
    protected String destinationFulfillmentCenterId;
    protected String labelPrepType;
    protected AddressVO shipFromAddress;
    protected String shipmentId;
    protected String shipmentName;
    protected String shipmentStatus;

    /**
     * Gets the value of the areCasesRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreCasesRequired() {
        return areCasesRequired;
    }

    /**
     * Sets the value of the areCasesRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreCasesRequired(String value) {
        this.areCasesRequired = value;
    }

    /**
     * Gets the value of the destinationFulfillmentCenterId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationFulfillmentCenterId() {
        return destinationFulfillmentCenterId;
    }

    /**
     * Sets the value of the destinationFulfillmentCenterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationFulfillmentCenterId(String value) {
        this.destinationFulfillmentCenterId = value;
    }

    /**
     * Gets the value of the labelPrepType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelPrepType() {
        return labelPrepType;
    }

    /**
     * Sets the value of the labelPrepType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelPrepType(String value) {
        this.labelPrepType = value;
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
     * Gets the value of the shipmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipmentId() {
        return shipmentId;
    }

    /**
     * Sets the value of the shipmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipmentId(String value) {
        this.shipmentId = value;
    }

    /**
     * Gets the value of the shipmentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipmentName() {
        return shipmentName;
    }

    /**
     * Sets the value of the shipmentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipmentName(String value) {
        this.shipmentName = value;
    }

    /**
     * Gets the value of the shipmentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipmentStatus() {
        return shipmentStatus;
    }

    /**
     * Sets the value of the shipmentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipmentStatus(String value) {
        this.shipmentStatus = value;
    }

}