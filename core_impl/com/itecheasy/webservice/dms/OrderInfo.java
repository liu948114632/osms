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
 * Java class for orderInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="boxs" type="{http://out.webservice.dms.itecheasy.com/}boxInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="canDeliveryFlag" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryDept" type="{http://out.webservice.dms.itecheasy.com/}deliveryDeptInfo" minOccurs="0"/>
 *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ebayBuymail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="electrified" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="freeShippingMethodIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="freeShippingRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="invoiceRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isFreeShipping" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isReimburseFreight" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isRemote" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isTextile" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="merchandiserEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchandiserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderRemind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="perWebFreight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="physicalWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="placeOrderTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="reimburseAmountRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="relatedCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sellUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendGroupId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="shippingAddress" type="{http://out.webservice.dms.itecheasy.com/}address" minOccurs="0"/>
 *         &lt;element name="shippingMethod" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="totalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="webFreight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="webWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="wide" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderInfo", propOrder = { "boxs", "canDeliveryFlag", "code", "deliveryDept", "department",
		"ebayBuymail", "electrified", "freeShippingMethodIds", "freeShippingRemark", "hight", "invoiceRemark",
		"isFreeShipping", "isReimburseFreight", "isRemote", "isTextile", "length", "merchandiserEmail",
		"merchandiserName", "orderRemind", "perWebFreight", "physicalWeight", "placeOrderTime", "reimburseAmountRate",
		"relatedCode", "remark", "sellUserID", "sendGroupId", "shippingAddress", "shippingMethod", "source",
		"totalAmount", "transactionId", "transactionTime", "volume", "webFreight", "webWeight", "wide" })
public class OrderInfo {

	@XmlElement(nillable = true)
	protected List<BoxInfo> boxs;
	protected Integer canDeliveryFlag;
	protected String code;
	protected DeliveryDeptInfo deliveryDept;
	protected String department;
	protected String ebayBuymail;
	protected Boolean electrified;
	protected String freeShippingMethodIds;
	protected String freeShippingRemark;
	protected Integer hight;
	protected String invoiceRemark;
	protected Boolean isFreeShipping;
	protected Boolean isReimburseFreight;
	protected Boolean isRemote;
	protected Boolean isTextile;
	protected Integer length;
	protected String merchandiserEmail;
	protected String merchandiserName;
	protected String orderRemind;
	protected BigDecimal perWebFreight;
	protected BigDecimal physicalWeight;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar placeOrderTime;
	protected BigDecimal reimburseAmountRate;
	protected String relatedCode;
	protected String remark;
	protected String sellUserID;
	protected Integer sendGroupId;
	protected Address shippingAddress;
	protected Integer shippingMethod;
	protected Integer source;
	protected BigDecimal totalAmount;
	protected String transactionId;
	protected String transactionTime;
	protected BigDecimal volume;
	protected BigDecimal webFreight;
	protected BigDecimal webWeight;
	protected Integer wide;

	/**
	 * Gets the value of the boxs property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the boxs property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBoxs().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link BoxInfo }
	 * 
	 * 
	 */
	public List<BoxInfo> getBoxs() {
		if (boxs == null) {
			boxs = new ArrayList<BoxInfo>();
		}
		return this.boxs;
	}

	/**
	 * Gets the value of the canDeliveryFlag property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCanDeliveryFlag() {
		return canDeliveryFlag;
	}

	/**
	 * Sets the value of the canDeliveryFlag property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCanDeliveryFlag(Integer value) {
		this.canDeliveryFlag = value;
	}

	/**
	 * Gets the value of the code property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the value of the code property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 * Gets the value of the deliveryDept property.
	 * 
	 * @return possible object is {@link DeliveryDeptInfo }
	 * 
	 */
	public DeliveryDeptInfo getDeliveryDept() {
		return deliveryDept;
	}

	/**
	 * Sets the value of the deliveryDept property.
	 * 
	 * @param value
	 *            allowed object is {@link DeliveryDeptInfo }
	 * 
	 */
	public void setDeliveryDept(DeliveryDeptInfo value) {
		this.deliveryDept = value;
	}

	/**
	 * Gets the value of the department property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the value of the department property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDepartment(String value) {
		this.department = value;
	}

	/**
	 * Gets the value of the ebayBuymail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEbayBuymail() {
		return ebayBuymail;
	}

	/**
	 * Sets the value of the ebayBuymail property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEbayBuymail(String value) {
		this.ebayBuymail = value;
	}

	/**
	 * Gets the value of the electrified property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isElectrified() {
		return electrified;
	}

	/**
	 * Sets the value of the electrified property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setElectrified(Boolean value) {
		this.electrified = value;
	}

	/**
	 * Gets the value of the freeShippingMethodIds property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFreeShippingMethodIds() {
		return freeShippingMethodIds;
	}

	/**
	 * Sets the value of the freeShippingMethodIds property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFreeShippingMethodIds(String value) {
		this.freeShippingMethodIds = value;
	}

	/**
	 * Gets the value of the freeShippingRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFreeShippingRemark() {
		return freeShippingRemark;
	}

	/**
	 * Sets the value of the freeShippingRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFreeShippingRemark(String value) {
		this.freeShippingRemark = value;
	}

	/**
	 * Gets the value of the hight property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getHight() {
		return hight;
	}

	/**
	 * Sets the value of the hight property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setHight(Integer value) {
		this.hight = value;
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
	 * Gets the value of the isFreeShipping property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsFreeShipping() {
		return isFreeShipping;
	}

	/**
	 * Sets the value of the isFreeShipping property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsFreeShipping(Boolean value) {
		this.isFreeShipping = value;
	}

	/**
	 * Gets the value of the isReimburseFreight property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsReimburseFreight() {
		return isReimburseFreight;
	}

	/**
	 * Sets the value of the isReimburseFreight property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsReimburseFreight(Boolean value) {
		this.isReimburseFreight = value;
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
	 * Gets the value of the isTextile property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsTextile() {
		return isTextile;
	}

	/**
	 * Sets the value of the isTextile property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsTextile(Boolean value) {
		this.isTextile = value;
	}

	/**
	 * Gets the value of the length property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * Sets the value of the length property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setLength(Integer value) {
		this.length = value;
	}

	/**
	 * Gets the value of the merchandiserEmail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMerchandiserEmail() {
		return merchandiserEmail;
	}

	/**
	 * Sets the value of the merchandiserEmail property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMerchandiserEmail(String value) {
		this.merchandiserEmail = value;
	}

	/**
	 * Gets the value of the merchandiserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMerchandiserName() {
		return merchandiserName;
	}

	/**
	 * Sets the value of the merchandiserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMerchandiserName(String value) {
		this.merchandiserName = value;
	}

	/**
	 * Gets the value of the orderRemind property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderRemind() {
		return orderRemind;
	}

	/**
	 * Sets the value of the orderRemind property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderRemind(String value) {
		this.orderRemind = value;
	}

	/**
	 * Gets the value of the perWebFreight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPerWebFreight() {
		return perWebFreight;
	}

	/**
	 * Sets the value of the perWebFreight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPerWebFreight(BigDecimal value) {
		this.perWebFreight = value;
	}

	/**
	 * Gets the value of the physicalWeight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPhysicalWeight() {
		return physicalWeight;
	}

	/**
	 * Sets the value of the physicalWeight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPhysicalWeight(BigDecimal value) {
		this.physicalWeight = value;
	}

	/**
	 * Gets the value of the placeOrderTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getPlaceOrderTime() {
		return placeOrderTime;
	}

	/**
	 * Sets the value of the placeOrderTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setPlaceOrderTime(XMLGregorianCalendar value) {
		this.placeOrderTime = value;
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
	 * Gets the value of the relatedCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRelatedCode() {
		return relatedCode;
	}

	/**
	 * Sets the value of the relatedCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRelatedCode(String value) {
		this.relatedCode = value;
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
	 * Gets the value of the sellUserID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSellUserID() {
		return sellUserID;
	}

	/**
	 * Sets the value of the sellUserID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSellUserID(String value) {
		this.sellUserID = value;
	}

	/**
	 * Gets the value of the sendGroupId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getSendGroupId() {
		return sendGroupId;
	}

	/**
	 * Sets the value of the sendGroupId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setSendGroupId(Integer value) {
		this.sendGroupId = value;
	}

	/**
	 * Gets the value of the shippingAddress property.
	 * 
	 * @return possible object is {@link Address }
	 * 
	 */
	public Address getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * Sets the value of the shippingAddress property.
	 * 
	 * @param value
	 *            allowed object is {@link Address }
	 * 
	 */
	public void setShippingAddress(Address value) {
		this.shippingAddress = value;
	}

	/**
	 * Gets the value of the shippingMethod property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getShippingMethod() {
		return shippingMethod;
	}

	/**
	 * Sets the value of the shippingMethod property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setShippingMethod(Integer value) {
		this.shippingMethod = value;
	}

	/**
	 * Gets the value of the source property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getSource() {
		return source;
	}

	/**
	 * Sets the value of the source property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setSource(Integer value) {
		this.source = value;
	}

	/**
	 * Gets the value of the totalAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Sets the value of the totalAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setTotalAmount(BigDecimal value) {
		this.totalAmount = value;
	}

	/**
	 * Gets the value of the transactionId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * Sets the value of the transactionId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionId(String value) {
		this.transactionId = value;
	}

	/**
	 * Gets the value of the transactionTime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionTime() {
		return transactionTime;
	}

	/**
	 * Sets the value of the transactionTime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionTime(String value) {
		this.transactionTime = value;
	}

	/**
	 * Gets the value of the volume property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getVolume() {
		return volume;
	}

	/**
	 * Sets the value of the volume property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setVolume(BigDecimal value) {
		this.volume = value;
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

	/**
	 * Gets the value of the webWeight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getWebWeight() {
		return webWeight;
	}

	/**
	 * Sets the value of the webWeight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setWebWeight(BigDecimal value) {
		this.webWeight = value;
	}

	/**
	 * Gets the value of the wide property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getWide() {
		return wide;
	}

	/**
	 * Sets the value of the wide property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setWide(Integer value) {
		this.wide = value;
	}

	public void setBoxs(List<BoxInfo> boxs) {
		this.boxs = boxs;
	}

}
