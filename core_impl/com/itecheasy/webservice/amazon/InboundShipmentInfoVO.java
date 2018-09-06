
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>inboundShipmentInfoVO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="inboundShipmentInfoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
    "destinationFulfillmentCenterId",
    "labelPrepType",
    "shipFromAddress",
    "shipmentId",
    "shipmentName",
    "shipmentStatus"
})
public class InboundShipmentInfoVO {

    protected String destinationFulfillmentCenterId;
    protected String labelPrepType;
    protected AddressVO shipFromAddress;
    protected String shipmentId;
    protected String shipmentName;
    protected String shipmentStatus;

    /**
     * 获取destinationFulfillmentCenterId属性的值。
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
     * 设置destinationFulfillmentCenterId属性的值。
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
     * 获取labelPrepType属性的值。
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
     * 设置labelPrepType属性的值。
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
     * 获取shipFromAddress属性的值。
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
     * 设置shipFromAddress属性的值。
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
     * 获取shipmentId属性的值。
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
     * 设置shipmentId属性的值。
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
     * 获取shipmentName属性的值。
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
     * 设置shipmentName属性的值。
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
     * 获取shipmentStatus属性的值。
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
     * 设置shipmentStatus属性的值。
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
