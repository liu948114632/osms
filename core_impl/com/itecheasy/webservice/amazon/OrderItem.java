
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the asin property.
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
     * Sets the value of the asin property.
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
     * Gets the value of the codFee property.
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
     * Sets the value of the codFee property.
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
     * Gets the value of the codFeeDiscount property.
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
     * Sets the value of the codFeeDiscount property.
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
     * Gets the value of the conditionId property.
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
     * Sets the value of the conditionId property.
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
     * Gets the value of the conditionNote property.
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
     * Sets the value of the conditionNote property.
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
     * Gets the value of the conditionSubtypeId property.
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
     * Sets the value of the conditionSubtypeId property.
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
     * Gets the value of the giftMessageText property.
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
     * Sets the value of the giftMessageText property.
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
     * Gets the value of the giftWrapLevel property.
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
     * Sets the value of the giftWrapLevel property.
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
     * Gets the value of the giftWrapPrice property.
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
     * Sets the value of the giftWrapPrice property.
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
     * Gets the value of the giftWrapTax property.
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
     * Sets the value of the giftWrapTax property.
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
     * Gets the value of the invoiceData property.
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
     * Sets the value of the invoiceData property.
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
     * Gets the value of the itemPrice property.
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
     * Sets the value of the itemPrice property.
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
     * Gets the value of the itemTax property.
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
     * Sets the value of the itemTax property.
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
     * Gets the value of the orderItemId property.
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
     * Sets the value of the orderItemId property.
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
     * Gets the value of the pointsGranted property.
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
     * Sets the value of the pointsGranted property.
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
     * Gets the value of the promotionDiscount property.
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
     * Sets the value of the promotionDiscount property.
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
     * Gets the value of the quantityOrdered property.
     * 
     */
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    /**
     * Sets the value of the quantityOrdered property.
     * 
     */
    public void setQuantityOrdered(int value) {
        this.quantityOrdered = value;
    }

    /**
     * Gets the value of the quantityShipped property.
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
     * Sets the value of the quantityShipped property.
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
     * Gets the value of the scheduledDeliveryEndDate property.
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
     * Sets the value of the scheduledDeliveryEndDate property.
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
     * Gets the value of the scheduledDeliveryStartDate property.
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
     * Sets the value of the scheduledDeliveryStartDate property.
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
     * Gets the value of the shippingDiscount property.
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
     * Sets the value of the shippingDiscount property.
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
     * Gets the value of the shippingPrice property.
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
     * Sets the value of the shippingPrice property.
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
     * Gets the value of the shippingTax property.
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
     * Sets the value of the shippingTax property.
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
     * Gets the value of the title property.
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
     * Sets the value of the title property.
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
