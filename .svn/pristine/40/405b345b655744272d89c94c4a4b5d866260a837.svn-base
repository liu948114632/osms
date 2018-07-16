
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listInboundShipmentsResultVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listInboundShipmentsResultVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inboundShipmentInfoVOList" type="{http://amazon.core.itecheasy.com/}inboundShipmentInfoVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nextToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listInboundShipmentsResultVO", propOrder = {
    "inboundShipmentInfoVOList",
    "nextToken"
})
public class ListInboundShipmentsResultVO {

    @XmlElement(nillable = true)
    protected List<InboundShipmentInfoVO> inboundShipmentInfoVOList;
    protected String nextToken;

    /**
     * Gets the value of the inboundShipmentInfoVOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inboundShipmentInfoVOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInboundShipmentInfoVOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InboundShipmentInfoVO }
     * 
     * 
     */
    public List<InboundShipmentInfoVO> getInboundShipmentInfoVOList() {
        if (inboundShipmentInfoVOList == null) {
            inboundShipmentInfoVOList = new ArrayList<InboundShipmentInfoVO>();
        }
        return this.inboundShipmentInfoVOList;
    }

    /**
     * Gets the value of the nextToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextToken() {
        return nextToken;
    }

    /**
     * Sets the value of the nextToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextToken(String value) {
        this.nextToken = value;
    }

}
