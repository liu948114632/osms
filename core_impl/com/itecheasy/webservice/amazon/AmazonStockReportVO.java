
package com.itecheasy.webservice.amazon;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>amazonStockReportVO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="amazonStockReportVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="afnFulfillableQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="afnInboundReceivingQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="afnInboundShippedQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="afnInboundWorkingQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="afnListingExists" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="afnReservedQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="afnTotalQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="afnUnsellableQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="afnWarehouseQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="amazonStockReportAsin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="condition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fbaSeaTransit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fnsku" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mfnFulfillableQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="mfnListingExists" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="perUnitVolume" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sku" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="syncFirst" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="syncLast" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="yourPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "amazonStockReportVO", propOrder = {
    "afnFulfillableQuantity",
    "afnInboundReceivingQuantity",
    "afnInboundShippedQuantity",
    "afnInboundWorkingQuantity",
    "afnListingExists",
    "afnReservedQuantity",
    "afnTotalQuantity",
    "afnUnsellableQuantity",
    "afnWarehouseQuantity",
    "amazonStockReportAsin",
    "condition",
    "fbaSeaTransit",
    "fnsku",
    "id",
    "mfnFulfillableQuantity",
    "mfnListingExists",
    "perUnitVolume",
    "productName",
    "shopId",
    "sku",
    "syncFirst",
    "syncLast",
    "yourPrice"
})
public class AmazonStockReportVO {

    protected Integer afnFulfillableQuantity;
    protected Integer afnInboundReceivingQuantity;
    protected Integer afnInboundShippedQuantity;
    protected Integer afnInboundWorkingQuantity;
    protected Integer afnListingExists;
    protected Integer afnReservedQuantity;
    protected Integer afnTotalQuantity;
    protected Integer afnUnsellableQuantity;
    protected Integer afnWarehouseQuantity;
    protected String amazonStockReportAsin;
    protected String condition;
    protected Integer fbaSeaTransit;
    protected String fnsku;
    protected int id;
    protected Integer mfnFulfillableQuantity;
    protected Integer mfnListingExists;
    protected BigDecimal perUnitVolume;
    protected String productName;
    protected Integer shopId;
    protected String sku;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar syncFirst;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar syncLast;
    protected BigDecimal yourPrice;

    /**
     * 获取afnFulfillableQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAfnFulfillableQuantity() {
        return afnFulfillableQuantity;
    }

    /**
     * 设置afnFulfillableQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAfnFulfillableQuantity(Integer value) {
        this.afnFulfillableQuantity = value;
    }

    /**
     * 获取afnInboundReceivingQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAfnInboundReceivingQuantity() {
        return afnInboundReceivingQuantity;
    }

    /**
     * 设置afnInboundReceivingQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAfnInboundReceivingQuantity(Integer value) {
        this.afnInboundReceivingQuantity = value;
    }

    /**
     * 获取afnInboundShippedQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAfnInboundShippedQuantity() {
        return afnInboundShippedQuantity;
    }

    /**
     * 设置afnInboundShippedQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAfnInboundShippedQuantity(Integer value) {
        this.afnInboundShippedQuantity = value;
    }

    /**
     * 获取afnInboundWorkingQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAfnInboundWorkingQuantity() {
        return afnInboundWorkingQuantity;
    }

    /**
     * 设置afnInboundWorkingQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAfnInboundWorkingQuantity(Integer value) {
        this.afnInboundWorkingQuantity = value;
    }

    /**
     * 获取afnListingExists属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAfnListingExists() {
        return afnListingExists;
    }

    /**
     * 设置afnListingExists属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAfnListingExists(Integer value) {
        this.afnListingExists = value;
    }

    /**
     * 获取afnReservedQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAfnReservedQuantity() {
        return afnReservedQuantity;
    }

    /**
     * 设置afnReservedQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAfnReservedQuantity(Integer value) {
        this.afnReservedQuantity = value;
    }

    /**
     * 获取afnTotalQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAfnTotalQuantity() {
        return afnTotalQuantity;
    }

    /**
     * 设置afnTotalQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAfnTotalQuantity(Integer value) {
        this.afnTotalQuantity = value;
    }

    /**
     * 获取afnUnsellableQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAfnUnsellableQuantity() {
        return afnUnsellableQuantity;
    }

    /**
     * 设置afnUnsellableQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAfnUnsellableQuantity(Integer value) {
        this.afnUnsellableQuantity = value;
    }

    /**
     * 获取afnWarehouseQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAfnWarehouseQuantity() {
        return afnWarehouseQuantity;
    }

    /**
     * 设置afnWarehouseQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAfnWarehouseQuantity(Integer value) {
        this.afnWarehouseQuantity = value;
    }

    /**
     * 获取amazonStockReportAsin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmazonStockReportAsin() {
        return amazonStockReportAsin;
    }

    /**
     * 设置amazonStockReportAsin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonStockReportAsin(String value) {
        this.amazonStockReportAsin = value;
    }

    /**
     * 获取condition属性的值。
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
     * 设置condition属性的值。
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
     * 获取fbaSeaTransit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFbaSeaTransit() {
        return fbaSeaTransit;
    }

    /**
     * 设置fbaSeaTransit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFbaSeaTransit(Integer value) {
        this.fbaSeaTransit = value;
    }

    /**
     * 获取fnsku属性的值。
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
     * 设置fnsku属性的值。
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
     * 获取id属性的值。
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * 获取mfnFulfillableQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMfnFulfillableQuantity() {
        return mfnFulfillableQuantity;
    }

    /**
     * 设置mfnFulfillableQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMfnFulfillableQuantity(Integer value) {
        this.mfnFulfillableQuantity = value;
    }

    /**
     * 获取mfnListingExists属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMfnListingExists() {
        return mfnListingExists;
    }

    /**
     * 设置mfnListingExists属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMfnListingExists(Integer value) {
        this.mfnListingExists = value;
    }

    /**
     * 获取perUnitVolume属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPerUnitVolume() {
        return perUnitVolume;
    }

    /**
     * 设置perUnitVolume属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPerUnitVolume(BigDecimal value) {
        this.perUnitVolume = value;
    }

    /**
     * 获取productName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置productName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * 获取shopId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置shopId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setShopId(Integer value) {
        this.shopId = value;
    }

    /**
     * 获取sku属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSku() {
        return sku;
    }

    /**
     * 设置sku属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSku(String value) {
        this.sku = value;
    }

    /**
     * 获取syncFirst属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSyncFirst() {
        return syncFirst;
    }

    /**
     * 设置syncFirst属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSyncFirst(XMLGregorianCalendar value) {
        this.syncFirst = value;
    }

    /**
     * 获取syncLast属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSyncLast() {
        return syncLast;
    }

    /**
     * 设置syncLast属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSyncLast(XMLGregorianCalendar value) {
        this.syncLast = value;
    }

    /**
     * 获取yourPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getYourPrice() {
        return yourPrice;
    }

    /**
     * 设置yourPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setYourPrice(BigDecimal value) {
        this.yourPrice = value;
    }

}
