package com.itecheasy.webservice.cms.order;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for orderExpandInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderExpandInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amCenterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amShipmentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ebayBuyerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ebayBuyerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ebaySellRecord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ebaySellerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ebaySellerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="freightPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="invoicePercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="invoiceRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isOnline" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isReimbursementShippingfee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isRemote" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="operatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderProductAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="transDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="transNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="webFreight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderExpandInfo", propOrder = { "amCenterId", "amShipmentId", "ebayBuyerEmail", "ebayBuyerId",
		"ebaySellRecord", "ebaySellerEmail", "ebaySellerId", "freightPercent", "id", "invoicePercent", "invoiceRemark",
		"isOnline", "isReimbursementShippingfee", "isRemote", "operatorName", "orderCode", "orderProductAmount",
		"transDate", "transNo", "webFreight" })
public class OrderExpandInfo {

	protected String amCenterId;
	protected String amShipmentId;
	protected String ebayBuyerEmail;
	protected String ebayBuyerId;
	protected String ebaySellRecord;
	protected String ebaySellerEmail;
	protected String ebaySellerId;
	protected BigDecimal freightPercent;
	protected int id;
	protected BigDecimal invoicePercent;
	protected String invoiceRemark;
	protected boolean isOnline;
	protected boolean isReimbursementShippingfee;
	protected boolean isRemote;
	protected String operatorName;
	protected String orderCode;
	protected BigDecimal orderProductAmount;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar transDate;
	protected String transNo;
	protected BigDecimal webFreight;

	/**
	 * Gets the value of the amCenterId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAmCenterId() {
		return amCenterId;
	}

	/**
	 * Sets the value of the amCenterId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAmCenterId(String value) {
		this.amCenterId = value;
	}

	/**
	 * Gets the value of the amShipmentId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAmShipmentId() {
		return amShipmentId;
	}

	/**
	 * Sets the value of the amShipmentId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAmShipmentId(String value) {
		this.amShipmentId = value;
	}

	/**
	 * Gets the value of the ebayBuyerEmail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEbayBuyerEmail() {
		return ebayBuyerEmail;
	}

	/**
	 * Sets the value of the ebayBuyerEmail property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEbayBuyerEmail(String value) {
		this.ebayBuyerEmail = value;
	}

	/**
	 * Gets the value of the ebayBuyerId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEbayBuyerId() {
		return ebayBuyerId;
	}

	/**
	 * Sets the value of the ebayBuyerId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEbayBuyerId(String value) {
		this.ebayBuyerId = value;
	}

	/**
	 * Gets the value of the ebaySellRecord property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEbaySellRecord() {
		return ebaySellRecord;
	}

	/**
	 * Sets the value of the ebaySellRecord property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEbaySellRecord(String value) {
		this.ebaySellRecord = value;
	}

	/**
	 * Gets the value of the ebaySellerEmail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEbaySellerEmail() {
		return ebaySellerEmail;
	}

	/**
	 * Sets the value of the ebaySellerEmail property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEbaySellerEmail(String value) {
		this.ebaySellerEmail = value;
	}

	/**
	 * Gets the value of the ebaySellerId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEbaySellerId() {
		return ebaySellerId;
	}

	/**
	 * Sets the value of the ebaySellerId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEbaySellerId(String value) {
		this.ebaySellerId = value;
	}

	/**
	 * Gets the value of the freightPercent property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getFreightPercent() {
		return freightPercent;
	}

	/**
	 * Sets the value of the freightPercent property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setFreightPercent(BigDecimal value) {
		this.freightPercent = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 */
	public void setId(int value) {
		this.id = value;
	}

	/**
	 * Gets the value of the invoicePercent property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getInvoicePercent() {
		return invoicePercent;
	}

	/**
	 * Sets the value of the invoicePercent property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setInvoicePercent(BigDecimal value) {
		this.invoicePercent = value;
	}

	/**
	 * Gets the value of the invoiceRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getInvoiceRemark() {
		return invoiceRemark;
	}

	/**
	 * Sets the value of the invoiceRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInvoiceRemark(String value) {
		this.invoiceRemark = value;
	}

	/**
	 * Gets the value of the isOnline property.
	 * 
	 */
	public boolean isIsOnline() {
		return isOnline;
	}

	/**
	 * Sets the value of the isOnline property.
	 * 
	 */
	public void setIsOnline(boolean value) {
		this.isOnline = value;
	}

	/**
	 * Gets the value of the isReimbursementShippingfee property.
	 * 
	 */
	public boolean isIsReimbursementShippingfee() {
		return isReimbursementShippingfee;
	}

	/**
	 * Sets the value of the isReimbursementShippingfee property.
	 * 
	 */
	public void setIsReimbursementShippingfee(boolean value) {
		this.isReimbursementShippingfee = value;
	}

	/**
	 * Gets the value of the isRemote property.
	 * 
	 */
	public boolean isIsRemote() {
		return isRemote;
	}

	/**
	 * Sets the value of the isRemote property.
	 * 
	 */
	public void setIsRemote(boolean value) {
		this.isRemote = value;
	}

	/**
	 * Gets the value of the operatorName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOperatorName() {
		return operatorName;
	}

	/**
	 * Sets the value of the operatorName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOperatorName(String value) {
		this.operatorName = value;
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
	 * Gets the value of the orderProductAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getOrderProductAmount() {
		return orderProductAmount;
	}

	/**
	 * Sets the value of the orderProductAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setOrderProductAmount(BigDecimal value) {
		this.orderProductAmount = value;
	}

	/**
	 * Gets the value of the transDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getTransDate() {
		return transDate;
	}

	/**
	 * Sets the value of the transDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setTransDate(XMLGregorianCalendar value) {
		this.transDate = value;
	}

	/**
	 * Gets the value of the transNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransNo() {
		return transNo;
	}

	/**
	 * Sets the value of the transNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransNo(String value) {
		this.transNo = value;
	}

	/**
	 * Gets the value of the webFreight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getWebFreight() {
		return webFreight;
	}

	/**
	 * Sets the value of the webFreight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setWebFreight(BigDecimal value) {
		this.webFreight = value;
	}

}
