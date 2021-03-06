
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>orderItem complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="orderItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://amazon.core.itecheasy.com/}abstractMwsObject">
 *       &lt;sequence>
 *         &lt;element name="ASIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODFee" type="{http://amazon.core.itecheasy.com/}money" minOccurs="0"/>
 *         &lt;element name="CODFeeDiscount" type="{http://amazon.core.itecheasy.com/}money" minOccurs="0"/>
 *         &lt;element name="conditionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="conditionNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="conditionSubtypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="giftMessageText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="giftWrapLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="giftWrapPrice" type="{http://amazon.core.itecheasy.com/}money" minOccurs="0"/>
 *         &lt;element name="giftWrapTax" type="{http://amazon.core.itecheasy.com/}money" minOccurs="0"/>
 *         &lt;element name="invoiceData" type="{http://amazon.core.itecheasy.com/}invoiceData" minOccurs="0"/>
 *         &lt;element name="itemPrice" type="{http://amazon.core.itecheasy.com/}money" minOccurs="0"/>
 *         &lt;element name="itemTax" type="{http://amazon.core.itecheasy.com/}money" minOccurs="0"/>
 *         &lt;element name="orderItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pointsGranted" type="{http://amazon.core.itecheasy.com/}pointsGrantedDetail" minOccurs="0"/>
 *         &lt;element name="promotionDiscount" type="{http://amazon.core.itecheasy.com/}money" minOccurs="0"/>
 *         &lt;element name="promotionIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="quantityOrdered" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantityShipped" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="scheduledDeliveryEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scheduledDeliveryStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sellerSKU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shippingDiscount" type="{http://amazon.core.itecheasy.com/}money" minOccurs="0"/>
 *         &lt;element name="shippingPrice" type="{http://amazon.core.itecheasy.com/}money" minOccurs="0"/>
 *         &lt;element name="shippingTax" type="{http://amazon.core.itecheasy.com/}money" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderItem", propOrder = {
    "asin",
    "codFee",
    "codFeeDiscount",
    "conditionId",
    "conditionNote",
    "conditionSubtypeId",
    "giftMessageText",
    "giftWrapLevel",
    "giftWrapPrice",
    "giftWrapTax",
    "invoiceData",
    "itemPrice",
    "itemTax",
    "orderItemId",
    "pointsGranted",
    "promotionDiscount",
    "promotionIds",
    "quantityOrdered",
    "quantityShipped",
    "scheduledDeliveryEndDate",
    "scheduledDeliveryStartDate",
    "sellerSKU",
    "shippingDiscount",
    "shippingPrice",
    "shippingTax",
    "title"
})
public class OrderItem
    extends AbstractMwsObject
{

    @XmlElement(name = "ASIN")
    protected String asin;
    @XmlElement(name = "CODFee")
    protected Money codFee;
    @XmlElement(name = "CODFeeDiscount")
    protected Money codFeeDiscount;
    protected String conditionId;
    protected String conditionNote;
    protected String conditionSubtypeId;
    protected String giftMessageText;
    protected String giftWrapLevel;
    protected Money giftWrapPrice;
    protected Money giftWrapTax;
    protected InvoiceData invoiceData;
    protected Money itemPrice;
    protected Money itemTax;
    protected String orderItemId;
    protected PointsGrantedDetail pointsGranted;
    protected Money promotionDiscount;
    @XmlElement(nillable = true)
    protected List<String> promotionIds;
    protected int quantityOrdered;
    protected Integer quantityShipped;
    protected String scheduledDeliveryEndDate;
    protected String scheduledDeliveryStartDate;
    protected String sellerSKU;
    protected Money shippingDiscount;
    protected Money shippingPrice;
    protected Money shippingTax;
    protected String title;

    /**
     * 获取asin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASIN() {
        return asin;
    }

    /**
     * 设置asin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASIN(String value) {
        this.asin = value;
    }

    /**
     * 获取codFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCODFee() {
        return codFee;
    }

    /**
     * 设置codFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCODFee(Money value) {
        this.codFee = value;
    }

    /**
     * 获取codFeeDiscount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCODFeeDiscount() {
        return codFeeDiscount;
    }

    /**
     * 设置codFeeDiscount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCODFeeDiscount(Money value) {
        this.codFeeDiscount = value;
    }

    /**
     * 获取conditionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConditionId() {
        return conditionId;
    }

    /**
     * 设置conditionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConditionId(String value) {
        this.conditionId = value;
    }

    /**
     * 获取conditionNote属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConditionNote() {
        return conditionNote;
    }

    /**
     * 设置conditionNote属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConditionNote(String value) {
        this.conditionNote = value;
    }

    /**
     * 获取conditionSubtypeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConditionSubtypeId() {
        return conditionSubtypeId;
    }

    /**
     * 设置conditionSubtypeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConditionSubtypeId(String value) {
        this.conditionSubtypeId = value;
    }

    /**
     * 获取giftMessageText属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftMessageText() {
        return giftMessageText;
    }

    /**
     * 设置giftMessageText属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftMessageText(String value) {
        this.giftMessageText = value;
    }

    /**
     * 获取giftWrapLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftWrapLevel() {
        return giftWrapLevel;
    }

    /**
     * 设置giftWrapLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftWrapLevel(String value) {
        this.giftWrapLevel = value;
    }

    /**
     * 获取giftWrapPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getGiftWrapPrice() {
        return giftWrapPrice;
    }

    /**
     * 设置giftWrapPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setGiftWrapPrice(Money value) {
        this.giftWrapPrice = value;
    }

    /**
     * 获取giftWrapTax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getGiftWrapTax() {
        return giftWrapTax;
    }

    /**
     * 设置giftWrapTax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setGiftWrapTax(Money value) {
        this.giftWrapTax = value;
    }

    /**
     * 获取invoiceData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link InvoiceData }
     *     
     */
    public InvoiceData getInvoiceData() {
        return invoiceData;
    }

    /**
     * 设置invoiceData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceData }
     *     
     */
    public void setInvoiceData(InvoiceData value) {
        this.invoiceData = value;
    }

    /**
     * 获取itemPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getItemPrice() {
        return itemPrice;
    }

    /**
     * 设置itemPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setItemPrice(Money value) {
        this.itemPrice = value;
    }

    /**
     * 获取itemTax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getItemTax() {
        return itemTax;
    }

    /**
     * 设置itemTax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setItemTax(Money value) {
        this.itemTax = value;
    }

    /**
     * 获取orderItemId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderItemId() {
        return orderItemId;
    }

    /**
     * 设置orderItemId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderItemId(String value) {
        this.orderItemId = value;
    }

    /**
     * 获取pointsGranted属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PointsGrantedDetail }
     *     
     */
    public PointsGrantedDetail getPointsGranted() {
        return pointsGranted;
    }

    /**
     * 设置pointsGranted属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PointsGrantedDetail }
     *     
     */
    public void setPointsGranted(PointsGrantedDetail value) {
        this.pointsGranted = value;
    }

    /**
     * 获取promotionDiscount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getPromotionDiscount() {
        return promotionDiscount;
    }

    /**
     * 设置promotionDiscount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setPromotionDiscount(Money value) {
        this.promotionDiscount = value;
    }

    /**
     * Gets the value of the promotionIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the promotionIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPromotionIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPromotionIds() {
        if (promotionIds == null) {
            promotionIds = new ArrayList<String>();
        }
        return this.promotionIds;
    }

    /**
     * 获取quantityOrdered属性的值。
     * 
     */
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    /**
     * 设置quantityOrdered属性的值。
     * 
     */
    public void setQuantityOrdered(int value) {
        this.quantityOrdered = value;
    }

    /**
     * 获取quantityShipped属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuantityShipped() {
        return quantityShipped;
    }

    /**
     * 设置quantityShipped属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuantityShipped(Integer value) {
        this.quantityShipped = value;
    }

    /**
     * 获取scheduledDeliveryEndDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduledDeliveryEndDate() {
        return scheduledDeliveryEndDate;
    }

    /**
     * 设置scheduledDeliveryEndDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduledDeliveryEndDate(String value) {
        this.scheduledDeliveryEndDate = value;
    }

    /**
     * 获取scheduledDeliveryStartDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduledDeliveryStartDate() {
        return scheduledDeliveryStartDate;
    }

    /**
     * 设置scheduledDeliveryStartDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduledDeliveryStartDate(String value) {
        this.scheduledDeliveryStartDate = value;
    }

    /**
     * 获取sellerSKU属性的值。
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
     * 设置sellerSKU属性的值。
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
     * 获取shippingDiscount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getShippingDiscount() {
        return shippingDiscount;
    }

    /**
     * 设置shippingDiscount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setShippingDiscount(Money value) {
        this.shippingDiscount = value;
    }

    /**
     * 获取shippingPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getShippingPrice() {
        return shippingPrice;
    }

    /**
     * 设置shippingPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setShippingPrice(Money value) {
        this.shippingPrice = value;
    }

    /**
     * 获取shippingTax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getShippingTax() {
        return shippingTax;
    }

    /**
     * 设置shippingTax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setShippingTax(Money value) {
        this.shippingTax = value;
    }

    /**
     * 获取title属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置title属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
