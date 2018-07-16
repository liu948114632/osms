
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transportContentVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transportContentVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://amazon.core.itecheasy.com/}baseVO">
 *       &lt;sequence>
 *         &lt;element name="carrierName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partnered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="shipmentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transportDetailInputVO" type="{http://amazon.core.itecheasy.com/}transportDetailInputVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transportContentVO", propOrder = {
    "carrierName",
    "partnered",
    "shipmentType",
    "transportDetailInputVO"
})
public class TransportContentVO
    extends BaseVO
{
    public Boolean getPartnered() {
        return partnered;
    }

    public void setTransportDetailInputVO(List<TransportDetailInputVO> transportDetailInputVO) {
        this.transportDetailInputVO = transportDetailInputVO;
    }

    protected String carrierName;
    protected Boolean partnered;
    protected String shipmentType;
    @XmlElement(nillable = true)
    protected List<TransportDetailInputVO> transportDetailInputVO;

    /**
     * Gets the value of the carrierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrierName() {
        return carrierName;
    }

    /**
     * Sets the value of the carrierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrierName(String value) {
        this.carrierName = value;
    }

    /**
     * Gets the value of the partnered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPartnered() {
        return partnered;
    }

    /**
     * Sets the value of the partnered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPartnered(Boolean value) {
        this.partnered = value;
    }

    /**
     * Gets the value of the shipmentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipmentType() {
        return shipmentType;
    }

    /**
     * Sets the value of the shipmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipmentType(String value) {
        this.shipmentType = value;
    }

    /**
     * Gets the value of the transportDetailInputVO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportDetailInputVO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportDetailInputVO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportDetailInputVO }
     * 
     * 
     */
    public List<TransportDetailInputVO> getTransportDetailInputVO() {
        if (transportDetailInputVO == null) {
            transportDetailInputVO = new ArrayList<TransportDetailInputVO>();
        }
        return this.transportDetailInputVO;
    }

}