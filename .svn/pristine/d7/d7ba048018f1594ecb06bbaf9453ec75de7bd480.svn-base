
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listOrderItemsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listOrderItemsResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://amazon.core.itecheasy.com/}abstractMwsObject">
 *       &lt;sequence>
 *         &lt;element name="amazonOrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nextToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderItems" type="{http://amazon.core.itecheasy.com/}orderItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listOrderItemsResult", propOrder = {
    "amazonOrderId",
    "nextToken",
    "orderItems"
})
public class ListOrderItemsResult
    extends AbstractMwsObject
{

    protected String amazonOrderId;
    protected String nextToken;
    @XmlElement(nillable = true)
    protected List<OrderItem> orderItems;

    /**
     * Gets the value of the amazonOrderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    /**
     * Sets the value of the amazonOrderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonOrderId(String value) {
        this.amazonOrderId = value;
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

    /**
     * Gets the value of the orderItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderItem }
     * 
     * 
     */
    public List<OrderItem> getOrderItems() {
        if (orderItems == null) {
            orderItems = new ArrayList<OrderItem>();
        }
        return this.orderItems;
    }

}
