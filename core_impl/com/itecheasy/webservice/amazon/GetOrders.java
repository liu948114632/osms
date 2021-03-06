
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>getOrders complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getOrders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="createdBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastUpdatedAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastUpdatedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="orderStatus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sellerOrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buyerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="api" type="{http://amazon.core.itecheasy.com/}amazonConfigInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOrders", propOrder = {
    "createdAfter",
    "createdBefore",
    "lastUpdatedAfter",
    "lastUpdatedBefore",
    "orderStatus",
    "sellerOrderId",
    "buyerEmail",
    "api"
})
public class GetOrders {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAfter;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdBefore;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdatedAfter;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdatedBefore;
    protected List<String> orderStatus;
    protected String sellerOrderId;
    protected String buyerEmail;
    protected AmazonConfigInfo api;

    /**
     * 获取createdAfter属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedAfter() {
        return createdAfter;
    }

    /**
     * 设置createdAfter属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedAfter(XMLGregorianCalendar value) {
        this.createdAfter = value;
    }

    /**
     * 获取createdBefore属性的值。
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
     * 设置createdBefore属性的值。
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
     * 获取lastUpdatedAfter属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdatedAfter() {
        return lastUpdatedAfter;
    }

    /**
     * 设置lastUpdatedAfter属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdatedAfter(XMLGregorianCalendar value) {
        this.lastUpdatedAfter = value;
    }

    /**
     * 获取lastUpdatedBefore属性的值。
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
     * 设置lastUpdatedBefore属性的值。
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
     * Gets the value of the orderStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOrderStatus() {
        if (orderStatus == null) {
            orderStatus = new ArrayList<String>();
        }
        return this.orderStatus;
    }

    /**
     * 获取sellerOrderId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }

    /**
     * 设置sellerOrderId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerOrderId(String value) {
        this.sellerOrderId = value;
    }

    /**
     * 获取buyerEmail属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerEmail() {
        return buyerEmail;
    }

    /**
     * 设置buyerEmail属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerEmail(String value) {
        this.buyerEmail = value;
    }

    /**
     * 获取api属性的值。
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
     * 设置api属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmazonConfigInfo }
     *     
     */
    public void setApi(AmazonConfigInfo value) {
        this.api = value;
    }

}
