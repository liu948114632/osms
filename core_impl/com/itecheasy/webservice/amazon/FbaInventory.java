
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for fbaInventory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fbaInventory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="asin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="condition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="earliestAvailabilityDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="earliestAvailabilityTimepointType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fnsku" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inStockSupplyQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sellerSKU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalSupplyQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fbaInventory", propOrder = {
    "asin",
    "condition",
    "earliestAvailabilityDate",
    "earliestAvailabilityTimepointType",
    "fnsku",
    "inStockSupplyQuantity",
    "sellerSKU",
    "totalSupplyQuantity"
})
public class FbaInventory {

    protected String asin;
    protected String condition;
    protected XMLGregorianCalendar earliestAvailabilityDate;
    protected String earliestAvailabilityTimepointType;
    protected String fnsku;
    protected Integer inStockSupplyQuantity;
    protected String sellerSKU;
    protected Integer totalSupplyQuantity;

    /**
     * Gets the value of the asin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsin() {
        return asin;
    }

    /**
     * Sets the value of the asin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsin(String value) {
        this.asin = value;
    }

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCondition(String value) {
        this.condition = value;
    }

    /**
     * Gets the value of the earliestAvailabilityDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEarliestAvailabilityDate() {
        return earliestAvailabilityDate;
    }

    /**
     * Sets the value of the earliestAvailabilityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEarliestAvailabilityDate(XMLGregorianCalendar value) {
        this.earliestAvailabilityDate = value;
    }

    /**
     * Gets the value of the earliestAvailabilityTimepointType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEarliestAvailabilityTimepointType() {
        return earliestAvailabilityTimepointType;
    }

    /**
     * Sets the value of the earliestAvailabilityTimepointType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEarliestAvailabilityTimepointType(String value) {
        this.earliestAvailabilityTimepointType = value;
    }

    /**
     * Gets the value of the fnsku property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFnsku() {
        return fnsku;
    }

    /**
     * Sets the value of the fnsku property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFnsku(String value) {
        this.fnsku = value;
    }

    /**
     * Gets the value of the inStockSupplyQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInStockSupplyQuantity() {
        return inStockSupplyQuantity;
    }

    /**
     * Sets the value of the inStockSupplyQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInStockSupplyQuantity(Integer value) {
        this.inStockSupplyQuantity = value;
    }

    /**
     * Gets the value of the sellerSKU property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerSKU() {
        return sellerSKU;
    }

    /**
     * Sets the value of the sellerSKU property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerSKU(String value) {
        this.sellerSKU = value;
    }

    /**
     * Gets the value of the totalSupplyQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalSupplyQuantity() {
        return totalSupplyQuantity;
    }

    /**
     * Sets the value of the totalSupplyQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalSupplyQuantity(Integer value) {
        this.totalSupplyQuantity = value;
    }

}
