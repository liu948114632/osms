package com.itecheasy.webservice.sw;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for order complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="order">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountPayable" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="arrivalStatus" type="{http://osms.communication.itecheasy.com/}arrivalStatus" minOccurs="0"/>
 *         &lt;element name="associateCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="bankTransferPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="billingAddress" type="{http://osms.communication.itecheasy.com/}orderBillingAddress" minOccurs="0"/>
 *         &lt;element name="buyer" type="{http://osms.communication.itecheasy.com/}buyer" minOccurs="0"/>
 *         &lt;element name="cardPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cashAccountAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cashAccountPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="confirmTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="couponAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cpfCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerServiceRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="delivery" type="{http://osms.communication.itecheasy.com/}delivery" minOccurs="0"/>
 *         &lt;element name="deliveryExplanation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="documentaryPersonnelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expectDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="freightAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="freightDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="freightOrderRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="isRemote" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="language" type="{http://osms.communication.itecheasy.com/}language" minOccurs="0"/>
 *         &lt;element name="lastPayNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastPayTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="makeCollections" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://osms.communication.itecheasy.com/}user" minOccurs="0"/>
 *         &lt;element name="orderAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderProductSaveAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderProductSaveRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderProducts" type="{http://osms.communication.itecheasy.com/}orderProduct" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderSourcePlatform" type="{http://osms.communication.itecheasy.com/}orderSourcePlatform" minOccurs="0"/>
 *         &lt;element name="payPalPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="payTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="paymentStatus" type="{http://osms.communication.itecheasy.com/}paymentStatus" minOccurs="0"/>
 *         &lt;element name="paymentWay" type="{http://osms.communication.itecheasy.com/}paymentWay" minOccurs="0"/>
 *         &lt;element name="placeOrderDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="platformOrderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pointAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="pointPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="productAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="productQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="readyStockOrder" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="receivingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="reimburseAmountRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reminderStatus" type="{http://osms.communication.itecheasy.com/}reminderStatus" minOccurs="0"/>
 *         &lt;element name="saveAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="settlementStatus" type="{http://osms.communication.itecheasy.com/}settlementStatus" minOccurs="0"/>
 *         &lt;element name="settlementTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="shipmentID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shippingAddress" type="{http://osms.communication.itecheasy.com/}orderShippingAddress" minOccurs="0"/>
 *         &lt;element name="shippingMark" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="signDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="sourceType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="specialDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="status" type="{http://osms.communication.itecheasy.com/}orderStatus" minOccurs="0"/>
 *         &lt;element name="supplier" type="{http://osms.communication.itecheasy.com/}supplier" minOccurs="0"/>
 *         &lt;element name="systemSourceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tailoringTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeDifference" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="trailOrderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unprocessedMessagesQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="westernUnionPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order", propOrder = { "accountPayable", "arrivalStatus", "associateCharge",
		"bankTransferPaymentAmount", "billingAddress", "buyer", "cardPaymentAmount", "cashAccountAmount",
		"cashAccountPaymentAmount", "confirmTime", "couponAmount", "cpfCode", "customerServiceRemark", "delivery",
		"deliveryExplanation", "deliveryTime", "documentaryPersonnelName", "expectDate", "freightAmount",
		"freightDiscount", "freightOrderRemark", "id", "isRemote", "language", "lastPayNo", "lastPayTime",
		"lastUpdateDate", "makeCollections", "operator", "orderAmount", "orderCode", "orderProductSaveAmount",
		"orderProductSaveRate", "orderProducts", "orderSourcePlatform", "payPalPaymentAmount", "payTime",
		"paymentStatus", "paymentWay", "placeOrderDate", "platformOrderCode", "pointAmount", "pointPaymentAmount",
		"productAmount", "productQty", "readyStockOrder", "receivingDate", "reimburseAmountRate", "remark",
		"reminderStatus", "saveAmount", "settlementStatus", "settlementTime", "shipmentID", "shippingAddress",
		"shippingMark", "signDate", "sourceType", "specialDiscount", "status", "supplier", "systemSourceCode",
		"tailoringTime", "timeDifference", "trailOrderCode", "unprocessedMessagesQty", "westernUnionPaymentAmount" })
public class Order {

	protected BigDecimal accountPayable;
	protected ArrivalStatus arrivalStatus;
	protected BigDecimal associateCharge;
	protected BigDecimal bankTransferPaymentAmount;
	protected OrderBillingAddress billingAddress;
	protected Buyer buyer;
	protected BigDecimal cardPaymentAmount;
	protected BigDecimal cashAccountAmount;
	protected BigDecimal cashAccountPaymentAmount;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar confirmTime;
	protected BigDecimal couponAmount;
	protected String cpfCode;
	protected String customerServiceRemark;
	protected Delivery delivery;
	protected String deliveryExplanation;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar deliveryTime;
	protected String documentaryPersonnelName;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar expectDate;
	protected BigDecimal freightAmount;
	protected BigDecimal freightDiscount;
	protected String freightOrderRemark;
	protected Integer id;
	protected Boolean isRemote;
	protected Language language;
	protected String lastPayNo;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar lastPayTime;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar lastUpdateDate;
	protected BigDecimal makeCollections;
	protected User operator;
	protected BigDecimal orderAmount;
	protected String orderCode;
	protected BigDecimal orderProductSaveAmount;
	protected BigDecimal orderProductSaveRate;
	@XmlElement(nillable = true)
	protected List<OrderProduct> orderProducts;
	protected OrderSourcePlatform orderSourcePlatform;
	protected BigDecimal payPalPaymentAmount;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar payTime;
	protected PaymentStatus paymentStatus;
	protected PaymentWay paymentWay;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar placeOrderDate;
	protected String platformOrderCode;
	protected BigDecimal pointAmount;
	protected BigDecimal pointPaymentAmount;
	protected BigDecimal productAmount;
	protected Integer productQty;
	protected Boolean readyStockOrder;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar receivingDate;
	protected BigDecimal reimburseAmountRate;
	protected String remark;
	protected ReminderStatus reminderStatus;
	protected BigDecimal saveAmount;
	protected SettlementStatus settlementStatus;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar settlementTime;
	protected String shipmentID;
	protected OrderShippingAddress shippingAddress;
	protected boolean shippingMark;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar signDate;
	protected int sourceType;
	protected BigDecimal specialDiscount;
	protected OrderStatus status;
	protected Supplier supplier;
	protected String systemSourceCode;
	protected String tailoringTime;
	protected Long timeDifference;
	protected String trailOrderCode;
	protected Integer unprocessedMessagesQty;
	protected BigDecimal westernUnionPaymentAmount;

	/**
	 * Gets the value of the accountPayable property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getAccountPayable() {
		return accountPayable;
	}

	/**
	 * Sets the value of the accountPayable property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setAccountPayable(BigDecimal value) {
		this.accountPayable = value;
	}

	/**
	 * Gets the value of the arrivalStatus property.
	 * 
	 * @return possible object is {@link ArrivalStatus }
	 * 
	 */
	public ArrivalStatus getArrivalStatus() {
		return arrivalStatus;
	}

	/**
	 * Sets the value of the arrivalStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrivalStatus }
	 * 
	 */
	public void setArrivalStatus(ArrivalStatus value) {
		this.arrivalStatus = value;
	}

	/**
	 * Gets the value of the associateCharge property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getAssociateCharge() {
		return associateCharge;
	}

	/**
	 * Sets the value of the associateCharge property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setAssociateCharge(BigDecimal value) {
		this.associateCharge = value;
	}

	/**
	 * Gets the value of the bankTransferPaymentAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getBankTransferPaymentAmount() {
		return bankTransferPaymentAmount;
	}

	/**
	 * Sets the value of the bankTransferPaymentAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setBankTransferPaymentAmount(BigDecimal value) {
		this.bankTransferPaymentAmount = value;
	}

	/**
	 * Gets the value of the billingAddress property.
	 * 
	 * @return possible object is {@link OrderBillingAddress }
	 * 
	 */
	public OrderBillingAddress getBillingAddress() {
		return billingAddress;
	}

	/**
	 * Sets the value of the billingAddress property.
	 * 
	 * @param value
	 *            allowed object is {@link OrderBillingAddress }
	 * 
	 */
	public void setBillingAddress(OrderBillingAddress value) {
		this.billingAddress = value;
	}

	/**
	 * Gets the value of the buyer property.
	 * 
	 * @return possible object is {@link Buyer }
	 * 
	 */
	public Buyer getBuyer() {
		return buyer;
	}

	/**
	 * Sets the value of the buyer property.
	 * 
	 * @param value
	 *            allowed object is {@link Buyer }
	 * 
	 */
	public void setBuyer(Buyer value) {
		this.buyer = value;
	}

	/**
	 * Gets the value of the cardPaymentAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getCardPaymentAmount() {
		return cardPaymentAmount;
	}

	/**
	 * Sets the value of the cardPaymentAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setCardPaymentAmount(BigDecimal value) {
		this.cardPaymentAmount = value;
	}

	/**
	 * Gets the value of the cashAccountAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getCashAccountAmount() {
		return cashAccountAmount;
	}

	/**
	 * Sets the value of the cashAccountAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setCashAccountAmount(BigDecimal value) {
		this.cashAccountAmount = value;
	}

	/**
	 * Gets the value of the cashAccountPaymentAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getCashAccountPaymentAmount() {
		return cashAccountPaymentAmount;
	}

	/**
	 * Sets the value of the cashAccountPaymentAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setCashAccountPaymentAmount(BigDecimal value) {
		this.cashAccountPaymentAmount = value;
	}

	/**
	 * Gets the value of the confirmTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getConfirmTime() {
		return confirmTime;
	}

	/**
	 * Sets the value of the confirmTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setConfirmTime(XMLGregorianCalendar value) {
		this.confirmTime = value;
	}

	/**
	 * Gets the value of the couponAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getCouponAmount() {
		return couponAmount;
	}

	/**
	 * Sets the value of the couponAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setCouponAmount(BigDecimal value) {
		this.couponAmount = value;
	}

	/**
	 * Gets the value of the cpfCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCpfCode() {
		return cpfCode;
	}

	/**
	 * Sets the value of the cpfCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCpfCode(String value) {
		this.cpfCode = value;
	}

	/**
	 * Gets the value of the customerServiceRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCustomerServiceRemark() {
		return customerServiceRemark;
	}

	/**
	 * Sets the value of the customerServiceRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCustomerServiceRemark(String value) {
		this.customerServiceRemark = value;
	}

	/**
	 * Gets the value of the delivery property.
	 * 
	 * @return possible object is {@link Delivery }
	 * 
	 */
	public Delivery getDelivery() {
		return delivery;
	}

	/**
	 * Sets the value of the delivery property.
	 * 
	 * @param value
	 *            allowed object is {@link Delivery }
	 * 
	 */
	public void setDelivery(Delivery value) {
		this.delivery = value;
	}

	/**
	 * Gets the value of the deliveryExplanation property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDeliveryExplanation() {
		return deliveryExplanation;
	}

	/**
	 * Sets the value of the deliveryExplanation property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeliveryExplanation(String value) {
		this.deliveryExplanation = value;
	}

	/**
	 * Gets the value of the deliveryTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * Sets the value of the deliveryTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDeliveryTime(XMLGregorianCalendar value) {
		this.deliveryTime = value;
	}

	/**
	 * Gets the value of the documentaryPersonnelName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDocumentaryPersonnelName() {
		return documentaryPersonnelName;
	}

	/**
	 * Sets the value of the documentaryPersonnelName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDocumentaryPersonnelName(String value) {
		this.documentaryPersonnelName = value;
	}

	/**
	 * Gets the value of the expectDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getExpectDate() {
		return expectDate;
	}

	/**
	 * Sets the value of the expectDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setExpectDate(XMLGregorianCalendar value) {
		this.expectDate = value;
	}

	/**
	 * Gets the value of the freightAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getFreightAmount() {
		return freightAmount;
	}

	/**
	 * Sets the value of the freightAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setFreightAmount(BigDecimal value) {
		this.freightAmount = value;
	}

	/**
	 * Gets the value of the freightDiscount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getFreightDiscount() {
		return freightDiscount;
	}

	/**
	 * Sets the value of the freightDiscount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setFreightDiscount(BigDecimal value) {
		this.freightDiscount = value;
	}

	/**
	 * Gets the value of the freightOrderRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFreightOrderRemark() {
		return freightOrderRemark;
	}

	/**
	 * Sets the value of the freightOrderRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFreightOrderRemark(String value) {
		this.freightOrderRemark = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setId(Integer value) {
		this.id = value;
	}

	/**
	 * Gets the value of the isRemote property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsRemote() {
		return isRemote;
	}

	/**
	 * Sets the value of the isRemote property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsRemote(Boolean value) {
		this.isRemote = value;
	}

	/**
	 * Gets the value of the language property.
	 * 
	 * @return possible object is {@link Language }
	 * 
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * Sets the value of the language property.
	 * 
	 * @param value
	 *            allowed object is {@link Language }
	 * 
	 */
	public void setLanguage(Language value) {
		this.language = value;
	}

	/**
	 * Gets the value of the lastPayNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLastPayNo() {
		return lastPayNo;
	}

	/**
	 * Sets the value of the lastPayNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLastPayNo(String value) {
		this.lastPayNo = value;
	}

	/**
	 * Gets the value of the lastPayTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getLastPayTime() {
		return lastPayTime;
	}

	/**
	 * Sets the value of the lastPayTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setLastPayTime(XMLGregorianCalendar value) {
		this.lastPayTime = value;
	}

	/**
	 * Gets the value of the lastUpdateDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * Sets the value of the lastUpdateDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setLastUpdateDate(XMLGregorianCalendar value) {
		this.lastUpdateDate = value;
	}

	/**
	 * Gets the value of the makeCollections property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getMakeCollections() {
		return makeCollections;
	}

	/**
	 * Sets the value of the makeCollections property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setMakeCollections(BigDecimal value) {
		this.makeCollections = value;
	}

	/**
	 * Gets the value of the operator property.
	 * 
	 * @return possible object is {@link User }
	 * 
	 */
	public User getOperator() {
		return operator;
	}

	/**
	 * Sets the value of the operator property.
	 * 
	 * @param value
	 *            allowed object is {@link User }
	 * 
	 */
	public void setOperator(User value) {
		this.operator = value;
	}

	/**
	 * Gets the value of the orderAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	/**
	 * Sets the value of the orderAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setOrderAmount(BigDecimal value) {
		this.orderAmount = value;
	}

	/**
	 * Gets the value of the orderCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * Sets the value of the orderCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderCode(String value) {
		this.orderCode = value;
	}

	/**
	 * Gets the value of the orderProductSaveAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getOrderProductSaveAmount() {
		return orderProductSaveAmount;
	}

	/**
	 * Sets the value of the orderProductSaveAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setOrderProductSaveAmount(BigDecimal value) {
		this.orderProductSaveAmount = value;
	}

	/**
	 * Gets the value of the orderProductSaveRate property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getOrderProductSaveRate() {
		return orderProductSaveRate;
	}

	/**
	 * Sets the value of the orderProductSaveRate property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setOrderProductSaveRate(BigDecimal value) {
		this.orderProductSaveRate = value;
	}

	/**
	 * Gets the value of the orderProducts property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the orderProducts property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrderProducts().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link OrderProduct }
	 * 
	 * 
	 */
	public List<OrderProduct> getOrderProducts() {
		if (orderProducts == null) {
			orderProducts = new ArrayList<OrderProduct>();
		}
		return this.orderProducts;
	}

	/**
	 * Gets the value of the orderSourcePlatform property.
	 * 
	 * @return possible object is {@link OrderSourcePlatform }
	 * 
	 */
	public OrderSourcePlatform getOrderSourcePlatform() {
		return orderSourcePlatform;
	}

	/**
	 * Sets the value of the orderSourcePlatform property.
	 * 
	 * @param value
	 *            allowed object is {@link OrderSourcePlatform }
	 * 
	 */
	public void setOrderSourcePlatform(OrderSourcePlatform value) {
		this.orderSourcePlatform = value;
	}

	/**
	 * Gets the value of the payPalPaymentAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPayPalPaymentAmount() {
		return payPalPaymentAmount;
	}

	/**
	 * Sets the value of the payPalPaymentAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPayPalPaymentAmount(BigDecimal value) {
		this.payPalPaymentAmount = value;
	}

	/**
	 * Gets the value of the payTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getPayTime() {
		return payTime;
	}

	/**
	 * Sets the value of the payTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setPayTime(XMLGregorianCalendar value) {
		this.payTime = value;
	}

	/**
	 * Gets the value of the paymentStatus property.
	 * 
	 * @return possible object is {@link PaymentStatus }
	 * 
	 */
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * Sets the value of the paymentStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link PaymentStatus }
	 * 
	 */
	public void setPaymentStatus(PaymentStatus value) {
		this.paymentStatus = value;
	}

	/**
	 * Gets the value of the paymentWay property.
	 * 
	 * @return possible object is {@link PaymentWay }
	 * 
	 */
	public PaymentWay getPaymentWay() {
		return paymentWay;
	}

	/**
	 * Sets the value of the paymentWay property.
	 * 
	 * @param value
	 *            allowed object is {@link PaymentWay }
	 * 
	 */
	public void setPaymentWay(PaymentWay value) {
		this.paymentWay = value;
	}

	/**
	 * Gets the value of the placeOrderDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getPlaceOrderDate() {
		return placeOrderDate;
	}

	/**
	 * Sets the value of the placeOrderDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setPlaceOrderDate(XMLGregorianCalendar value) {
		this.placeOrderDate = value;
	}

	/**
	 * Gets the value of the platformOrderCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPlatformOrderCode() {
		return platformOrderCode;
	}

	/**
	 * Sets the value of the platformOrderCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlatformOrderCode(String value) {
		this.platformOrderCode = value;
	}

	/**
	 * Gets the value of the pointAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPointAmount() {
		return pointAmount;
	}

	/**
	 * Sets the value of the pointAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPointAmount(BigDecimal value) {
		this.pointAmount = value;
	}

	/**
	 * Gets the value of the pointPaymentAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPointPaymentAmount() {
		return pointPaymentAmount;
	}

	/**
	 * Sets the value of the pointPaymentAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPointPaymentAmount(BigDecimal value) {
		this.pointPaymentAmount = value;
	}

	/**
	 * Gets the value of the productAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getProductAmount() {
		return productAmount;
	}

	/**
	 * Sets the value of the productAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setProductAmount(BigDecimal value) {
		this.productAmount = value;
	}

	/**
	 * Gets the value of the productQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getProductQty() {
		return productQty;
	}

	/**
	 * Sets the value of the productQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setProductQty(Integer value) {
		this.productQty = value;
	}

	/**
	 * Gets the value of the readyStockOrder property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isReadyStockOrder() {
		return readyStockOrder;
	}

	/**
	 * Sets the value of the readyStockOrder property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setReadyStockOrder(Boolean value) {
		this.readyStockOrder = value;
	}

	/**
	 * Gets the value of the receivingDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getReceivingDate() {
		return receivingDate;
	}

	/**
	 * Sets the value of the receivingDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setReceivingDate(XMLGregorianCalendar value) {
		this.receivingDate = value;
	}

	/**
	 * Gets the value of the reimburseAmountRate property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getReimburseAmountRate() {
		return reimburseAmountRate;
	}

	/**
	 * Sets the value of the reimburseAmountRate property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setReimburseAmountRate(BigDecimal value) {
		this.reimburseAmountRate = value;
	}

	/**
	 * Gets the value of the remark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the value of the remark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRemark(String value) {
		this.remark = value;
	}

	/**
	 * Gets the value of the reminderStatus property.
	 * 
	 * @return possible object is {@link ReminderStatus }
	 * 
	 */
	public ReminderStatus getReminderStatus() {
		return reminderStatus;
	}

	/**
	 * Sets the value of the reminderStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link ReminderStatus }
	 * 
	 */
	public void setReminderStatus(ReminderStatus value) {
		this.reminderStatus = value;
	}

	/**
	 * Gets the value of the saveAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getSaveAmount() {
		return saveAmount;
	}

	/**
	 * Sets the value of the saveAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setSaveAmount(BigDecimal value) {
		this.saveAmount = value;
	}

	/**
	 * Gets the value of the settlementStatus property.
	 * 
	 * @return possible object is {@link SettlementStatus }
	 * 
	 */
	public SettlementStatus getSettlementStatus() {
		return settlementStatus;
	}

	/**
	 * Sets the value of the settlementStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link SettlementStatus }
	 * 
	 */
	public void setSettlementStatus(SettlementStatus value) {
		this.settlementStatus = value;
	}

	/**
	 * Gets the value of the settlementTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getSettlementTime() {
		return settlementTime;
	}

	/**
	 * Sets the value of the settlementTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setSettlementTime(XMLGregorianCalendar value) {
		this.settlementTime = value;
	}

	/**
	 * Gets the value of the shipmentID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getShipmentID() {
		return shipmentID;
	}

	/**
	 * Sets the value of the shipmentID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setShipmentID(String value) {
		this.shipmentID = value;
	}

	/**
	 * Gets the value of the shippingAddress property.
	 * 
	 * @return possible object is {@link OrderShippingAddress }
	 * 
	 */
	public OrderShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * Sets the value of the shippingAddress property.
	 * 
	 * @param value
	 *            allowed object is {@link OrderShippingAddress }
	 * 
	 */
	public void setShippingAddress(OrderShippingAddress value) {
		this.shippingAddress = value;
	}

	/**
	 * Gets the value of the shippingMark property.
	 * 
	 */
	public boolean isShippingMark() {
		return shippingMark;
	}

	/**
	 * Sets the value of the shippingMark property.
	 * 
	 */
	public void setShippingMark(boolean value) {
		this.shippingMark = value;
	}

	/**
	 * Gets the value of the signDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getSignDate() {
		return signDate;
	}

	/**
	 * Sets the value of the signDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setSignDate(XMLGregorianCalendar value) {
		this.signDate = value;
	}

	/**
	 * Gets the value of the sourceType property.
	 * 
	 */
	public int getSourceType() {
		return sourceType;
	}

	/**
	 * Sets the value of the sourceType property.
	 * 
	 */
	public void setSourceType(int value) {
		this.sourceType = value;
	}

	/**
	 * Gets the value of the specialDiscount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getSpecialDiscount() {
		return specialDiscount;
	}

	/**
	 * Sets the value of the specialDiscount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setSpecialDiscount(BigDecimal value) {
		this.specialDiscount = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link OrderStatus }
	 * 
	 */
	public OrderStatus getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value
	 *            allowed object is {@link OrderStatus }
	 * 
	 */
	public void setStatus(OrderStatus value) {
		this.status = value;
	}

	/**
	 * Gets the value of the supplier property.
	 * 
	 * @return possible object is {@link Supplier }
	 * 
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * Sets the value of the supplier property.
	 * 
	 * @param value
	 *            allowed object is {@link Supplier }
	 * 
	 */
	public void setSupplier(Supplier value) {
		this.supplier = value;
	}

	/**
	 * Gets the value of the systemSourceCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSystemSourceCode() {
		return systemSourceCode;
	}

	/**
	 * Sets the value of the systemSourceCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSystemSourceCode(String value) {
		this.systemSourceCode = value;
	}

	/**
	 * Gets the value of the tailoringTime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTailoringTime() {
		return tailoringTime;
	}

	/**
	 * Sets the value of the tailoringTime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTailoringTime(String value) {
		this.tailoringTime = value;
	}

	/**
	 * Gets the value of the timeDifference property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getTimeDifference() {
		return timeDifference;
	}

	/**
	 * Sets the value of the timeDifference property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setTimeDifference(Long value) {
		this.timeDifference = value;
	}

	/**
	 * Gets the value of the trailOrderCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTrailOrderCode() {
		return trailOrderCode;
	}

	/**
	 * Sets the value of the trailOrderCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTrailOrderCode(String value) {
		this.trailOrderCode = value;
	}

	/**
	 * Gets the value of the unprocessedMessagesQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getUnprocessedMessagesQty() {
		return unprocessedMessagesQty;
	}

	/**
	 * Sets the value of the unprocessedMessagesQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setUnprocessedMessagesQty(Integer value) {
		this.unprocessedMessagesQty = value;
	}

	/**
	 * Gets the value of the westernUnionPaymentAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getWesternUnionPaymentAmount() {
		return westernUnionPaymentAmount;
	}

	/**
	 * Sets the value of the westernUnionPaymentAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setWesternUnionPaymentAmount(BigDecimal value) {
		this.westernUnionPaymentAmount = value;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	
}
