
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for inboundShipmentVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="inboundShipmentVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="destinationFulfillmentCenterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="items" type="{http://amazon.core.itecheasy.com/}inboundItemVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="labelPrepType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipFromAddress" type="{http://amazon.core.itecheasy.com/}addressVO" minOccurs="0"/>
 *         &lt;element name="shipToAddress" type="{http://amazon.core.itecheasy.com/}addressVO" minOccurs="0"/>
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
@XmlType(name = "inboundShipmentVO", propOrder = {
    "destinationFulfillmentCenterId",
    "items",
    "labelPrepType",
    "shipFromAddress",
    "shipToAddress",
    "shipmentId",
    "shipmentName",
    "shipmentStatus"
})
public class InboundShipmentVO {

    protected String destinationFulfillmentCenterId;
    @XmlElement(nillable = true)
    protected List<InboundItemVO> items;
    protected String labelPrepType;

    public void setItems(List<InboundItemVO> items) {
        this.items = items;
    }

    protected AddressVO shipFromAddress;
    protected AddressVO shipToAddress;
    protected String shipmentId;
    protected String shipmentName;
    protected String shipmentStatus;

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
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InboundItemVO }
     * 
     * 
     */
    public List<InboundItemVO> getItems() {
        if (items == null) {
            items = new ArrayList<InboundItemVO>();
        }
        return this.items;
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
     * Gets the value of the shipToAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressVO }
     *     
     */
    public AddressVO getShipToAddress() {
        return shipToAddress;
    }

    /**
     * Sets the value of the shipToAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressVO }
     *     
     */
    public void setShipToAddress(AddressVO value) {
        this.shipToAddress = value;
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
