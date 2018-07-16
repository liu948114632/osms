
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for invoiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="invoiceData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://amazon.core.itecheasy.com/}abstractMwsObject">
 *       &lt;sequence>
 *         &lt;element name="buyerSelectedInvoiceCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceRequirement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoiceData", propOrder = {
    "buyerSelectedInvoiceCategory",
    "invoiceInformation",
    "invoiceRequirement",
    "invoiceTitle"
})
public class InvoiceData
    extends AbstractMwsObject
{

    protected String buyerSelectedInvoiceCategory;
    protected String invoiceInformation;
    protected String invoiceRequirement;
    protected String invoiceTitle;

    /**
     * Gets the value of the buyerSelectedInvoiceCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerSelectedInvoiceCategory() {
        return buyerSelectedInvoiceCategory;
    }

    /**
     * Sets the value of the buyerSelectedInvoiceCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerSelectedInvoiceCategory(String value) {
        this.buyerSelectedInvoiceCategory = value;
    }

    /**
     * Gets the value of the invoiceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceInformation() {
        return invoiceInformation;
    }

    /**
     * Sets the value of the invoiceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceInformation(String value) {
        this.invoiceInformation = value;
    }

    /**
     * Gets the value of the invoiceRequirement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceRequirement() {
        return invoiceRequirement;
    }

    /**
     * Sets the value of the invoiceRequirement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceRequirement(String value) {
        this.invoiceRequirement = value;
    }

    /**
     * Gets the value of the invoiceTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * Sets the value of the invoiceTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceTitle(String value) {
        this.invoiceTitle = value;
    }

}
