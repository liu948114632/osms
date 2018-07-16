
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for listOrdersResultAmazon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listOrdersResultAmazon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastUpdatedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="orders" type="{http://amazon.core.itecheasy.com/}orderAmazon" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listOrdersResultAmazon", propOrder = {
    "createdBefore",
    "lastUpdatedBefore",
    "orders"
})
public class ListOrdersResultAmazon {

    protected XMLGregorianCalendar createdBefore;
    protected XMLGregorianCalendar lastUpdatedBefore;
    @XmlElement(nillable = true)
    protected List<OrderAmazon> orders;

    /**
     * Gets the value of the createdBefore property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedBefore() {
        return createdBefore;
    }

    /**
     * Sets the value of the createdBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedBefore(XMLGregorianCalendar value) {
        this.createdBefore = value;
    }

    /**
     * Gets the value of the lastUpdatedBefore property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdatedBefore() {
        return lastUpdatedBefore;
    }

    /**
     * Sets the value of the lastUpdatedBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdatedBefore(XMLGregorianCalendar value) {
        this.lastUpdatedBefore = value;
    }

    /**
     * Gets the value of the orders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderAmazon }
     * 
     * 
     */
    public List<OrderAmazon> getOrders() {
        if (orders == null) {
            orders = new ArrayList<OrderAmazon>();
        }
        return this.orders;
    }

}
