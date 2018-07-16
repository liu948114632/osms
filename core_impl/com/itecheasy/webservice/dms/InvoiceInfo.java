package com.itecheasy.webservice.dms;

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
 * Java class for invoiceInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="invoiceInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="creater" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://out.webservice.dms.itecheasy.com/}currencyInfo" minOccurs="0"/>
 *         &lt;element name="deliveryOrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="freight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="items" type="{http://out.webservice.dms.itecheasy.com/}invoiceItemInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="percents" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="senderAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shippingMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoiceInfo", propOrder = { "address", "amount", "city", "country", "createTime", "creater",
		"currency", "deliveryOrderNo", "fax", "freight", "fullName", "items", "orderCode", "percents", "phone",
		"productAmount", "remark", "sender", "senderAddress", "shippingMethod", "status", "type" })
public class InvoiceInfo {

	protected String address;
	protected BigDecimal amount;
	protected String city;
	protected String country;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar createTime;
	protected String creater;
	protected CurrencyInfo currency;
	protected String deliveryOrderNo;
	protected String fax;
	protected BigDecimal freight;
	protected String fullName;
	@XmlElement(nillable = true)
	protected List<InvoiceItemInfo> items;
	protected String orderCode;
	protected Integer percents;
	protected String phone;
	protected BigDecimal productAmount;
	protected String remark;
	protected String sender;
	protected String senderAddress;
	protected String shippingMethod;
	protected String status;
	protected String type;

	/**
	 * Gets the value of the address property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the value of the address property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddress(String value) {
		this.address = value;
	}

	/**
	 * Gets the value of the amount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Sets the value of the amount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setAmount(BigDecimal value) {
		this.amount = value;
	}

	/**
	 * Gets the value of the city property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the value of the city property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCity(String value) {
		this.city = value;
	}

	/**
	 * Gets the value of the country property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the value of the country property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCountry(String value) {
		this.country = value;
	}

	/**
	 * Gets the value of the createTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getCreateTime() {
		return createTime;
	}

	/**
	 * Sets the value of the createTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setCreateTime(XMLGregorianCalendar value) {
		this.createTime = value;
	}

	/**
	 * Gets the value of the creater property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCreater() {
		return creater;
	}

	/**
	 * Sets the value of the creater property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCreater(String value) {
		this.creater = value;
	}

	/**
	 * Gets the value of the currency property.
	 * 
	 * @return possible object is {@link CurrencyInfo }
	 * 
	 */
	public CurrencyInfo getCurrency() {
		return currency;
	}

	/**
	 * Sets the value of the currency property.
	 * 
	 * @param value
	 *            allowed object is {@link CurrencyInfo }
	 * 
	 */
	public void setCurrency(CurrencyInfo value) {
		this.currency = value;
	}

	/**
	 * Gets the value of the deliveryOrderNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDeliveryOrderNo() {
		return deliveryOrderNo;
	}

	/**
	 * Sets the value of the deliveryOrderNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeliveryOrderNo(String value) {
		this.deliveryOrderNo = value;
	}

	/**
	 * Gets the value of the fax property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Sets the value of the fax property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFax(String value) {
		this.fax = value;
	}

	/**
	 * Gets the value of the freight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getFreight() {
		return freight;
	}

	/**
	 * Sets the value of the freight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setFreight(BigDecimal value) {
		this.freight = value;
	}

	/**
	 * Gets the value of the fullName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the value of the fullName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFullName(String value) {
		this.fullName = value;
	}

	/**
	 * Gets the value of the items property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the items property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link InvoiceItemInfo }
	 * 
	 * 
	 */
	public List<InvoiceItemInfo> getItems() {
		if (items == null) {
			items = new ArrayList<InvoiceItemInfo>();
		}
		return this.items;
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
	 * Gets the value of the percents property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getPercents() {
		return percents;
	}

	/**
	 * Sets the value of the percents property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setPercents(Integer value) {
		this.percents = value;
	}

	/**
	 * Gets the value of the phone property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the value of the phone property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPhone(String value) {
		this.phone = value;
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
	 * Gets the value of the sender property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Sets the value of the sender property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSender(String value) {
		this.sender = value;
	}

	/**
	 * Gets the value of the senderAddress property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSenderAddress() {
		return senderAddress;
	}

	/**
	 * Sets the value of the senderAddress property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSenderAddress(String value) {
		this.senderAddress = value;
	}

	/**
	 * Gets the value of the shippingMethod property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getShippingMethod() {
		return shippingMethod;
	}

	/**
	 * Sets the value of the shippingMethod property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setShippingMethod(String value) {
		this.shippingMethod = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setType(String value) {
		this.type = value;
	}

}
