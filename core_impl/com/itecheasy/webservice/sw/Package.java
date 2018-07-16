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
 * Java class for package complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="package">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actualFreightAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="addressee" type="{http://osms.communication.itecheasy.com/}buyer" minOccurs="0"/>
 *         &lt;element name="boxQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="businessCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="delivery" type="{http://osms.communication.itecheasy.com/}delivery" minOccurs="0"/>
 *         &lt;element name="deliveryCustomerService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryExplanation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="deliveryTip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="detainedByCustomsEmail" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="documentaryPersonnelEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentaryPersonnelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enterQuestionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="enterQuestionPersonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="freightAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="freightForwardingCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="freightOrderRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hasPrintList" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="isDmsNewMessager" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isDmsQuestion" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isInstead" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isRemote" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="items" type="{http://osms.communication.itecheasy.com/}packageItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderSourcePlatform" type="{http://osms.communication.itecheasy.com/}orderSourcePlatform" minOccurs="0"/>
 *         &lt;element name="outStorageBy" type="{http://osms.communication.itecheasy.com/}user" minOccurs="0"/>
 *         &lt;element name="packageDMSQuestionStatus" type="{http://osms.communication.itecheasy.com/}packageDMSQuestionStatus" minOccurs="0"/>
 *         &lt;element name="packageShippingAddress" type="{http://osms.communication.itecheasy.com/}packageShippingAddress" minOccurs="0"/>
 *         &lt;element name="problemEmail" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="productAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="questionStatus" type="{http://osms.communication.itecheasy.com/}packageQuestionStatus" minOccurs="0"/>
 *         &lt;element name="releaseTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://osms.communication.itecheasy.com/}packageStatus" minOccurs="0"/>
 *         &lt;element name="traceStatus" type="{http://osms.communication.itecheasy.com/}packageTraceStatus" minOccurs="0"/>
 *         &lt;element name="traceTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="trailOrderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://osms.communication.itecheasy.com/}packageType" minOccurs="0"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "package", propOrder = { "actualFreightAmount", "addressee", "boxQty", "businessCode", "code",
		"delivery", "deliveryCustomerService", "deliveryExplanation", "deliveryTime", "deliveryTip",
		"detainedByCustomsEmail", "documentaryPersonnelEmail", "documentaryPersonnelName", "enterQuestionDate",
		"enterQuestionPersonName", "freightAmount", "freightForwardingCode", "freightOrderRemark", "hasPrintList",
		"id", "isDmsNewMessager", "isDmsQuestion", "isInstead", "isRemote", "items", "orderSourcePlatform",
		"outStorageBy", "packageDMSQuestionStatus", "packageShippingAddress", "problemEmail", "productAmount",
		"questionStatus", "releaseTime", "remark", "source", "status", "traceStatus", "traceTime", "trailOrderCode",
		"type", "weight" })
public class Package {

	protected BigDecimal actualFreightAmount;
	protected Buyer addressee;
	protected Integer boxQty;
	protected String businessCode;
	protected String code;
	protected Delivery delivery;
	protected String deliveryCustomerService;
	protected String deliveryExplanation;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar deliveryTime;
	protected String deliveryTip;
	protected Boolean detainedByCustomsEmail;
	protected String documentaryPersonnelEmail;
	protected String documentaryPersonnelName;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar enterQuestionDate;
	protected String enterQuestionPersonName;
	protected BigDecimal freightAmount;
	protected String freightForwardingCode;
	protected String freightOrderRemark;
	protected Boolean hasPrintList;
	protected Integer id;
	protected Boolean isDmsNewMessager;
	protected Boolean isDmsQuestion;
	protected Boolean isInstead;
	protected Boolean isRemote;
	@XmlElement(nillable = true)
	protected List<PackageItem> items;
	protected OrderSourcePlatform orderSourcePlatform;
	protected User outStorageBy;
	protected PackageDMSQuestionStatus packageDMSQuestionStatus;
	protected PackageShippingAddress packageShippingAddress;
	protected Boolean problemEmail;
	protected BigDecimal productAmount;
	protected PackageQuestionStatus questionStatus;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar releaseTime;
	protected String remark;
	protected int source;
	protected PackageStatus status;
	protected PackageTraceStatus traceStatus;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar traceTime;
	protected String trailOrderCode;
	protected PackageType type;
	protected BigDecimal weight;

	/**
	 * Gets the value of the actualFreightAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getActualFreightAmount() {
		return actualFreightAmount;
	}

	/**
	 * Sets the value of the actualFreightAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setActualFreightAmount(BigDecimal value) {
		this.actualFreightAmount = value;
	}

	/**
	 * Gets the value of the addressee property.
	 * 
	 * @return possible object is {@link Buyer }
	 * 
	 */
	public Buyer getAddressee() {
		return addressee;
	}

	/**
	 * Sets the value of the addressee property.
	 * 
	 * @param value
	 *            allowed object is {@link Buyer }
	 * 
	 */
	public void setAddressee(Buyer value) {
		this.addressee = value;
	}

	/**
	 * Gets the value of the boxQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getBoxQty() {
		return boxQty;
	}

	/**
	 * Sets the value of the boxQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setBoxQty(Integer value) {
		this.boxQty = value;
	}

	/**
	 * Gets the value of the businessCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBusinessCode() {
		return businessCode;
	}

	/**
	 * Sets the value of the businessCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBusinessCode(String value) {
		this.businessCode = value;
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
	 * Gets the value of the deliveryCustomerService property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDeliveryCustomerService() {
		return deliveryCustomerService;
	}

	/**
	 * Sets the value of the deliveryCustomerService property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeliveryCustomerService(String value) {
		this.deliveryCustomerService = value;
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
	 * Gets the value of the deliveryTip property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDeliveryTip() {
		return deliveryTip;
	}

	/**
	 * Sets the value of the deliveryTip property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeliveryTip(String value) {
		this.deliveryTip = value;
	}

	/**
	 * Gets the value of the detainedByCustomsEmail property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isDetainedByCustomsEmail() {
		return detainedByCustomsEmail;
	}

	/**
	 * Sets the value of the detainedByCustomsEmail property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setDetainedByCustomsEmail(Boolean value) {
		this.detainedByCustomsEmail = value;
	}

	/**
	 * Gets the value of the documentaryPersonnelEmail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDocumentaryPersonnelEmail() {
		return documentaryPersonnelEmail;
	}

	/**
	 * Sets the value of the documentaryPersonnelEmail property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDocumentaryPersonnelEmail(String value) {
		this.documentaryPersonnelEmail = value;
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
	 * Gets the value of the enterQuestionDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getEnterQuestionDate() {
		return enterQuestionDate;
	}

	/**
	 * Sets the value of the enterQuestionDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setEnterQuestionDate(XMLGregorianCalendar value) {
		this.enterQuestionDate = value;
	}

	/**
	 * Gets the value of the enterQuestionPersonName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEnterQuestionPersonName() {
		return enterQuestionPersonName;
	}

	/**
	 * Sets the value of the enterQuestionPersonName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEnterQuestionPersonName(String value) {
		this.enterQuestionPersonName = value;
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
	 * Gets the value of the freightForwardingCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFreightForwardingCode() {
		return freightForwardingCode;
	}

	/**
	 * Sets the value of the freightForwardingCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFreightForwardingCode(String value) {
		this.freightForwardingCode = value;
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
	 * Gets the value of the hasPrintList property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isHasPrintList() {
		return hasPrintList;
	}

	/**
	 * Sets the value of the hasPrintList property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setHasPrintList(Boolean value) {
		this.hasPrintList = value;
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
	 * Gets the value of the isDmsNewMessager property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsDmsNewMessager() {
		return isDmsNewMessager;
	}

	/**
	 * Sets the value of the isDmsNewMessager property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsDmsNewMessager(Boolean value) {
		this.isDmsNewMessager = value;
	}

	/**
	 * Gets the value of the isDmsQuestion property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsDmsQuestion() {
		return isDmsQuestion;
	}

	/**
	 * Sets the value of the isDmsQuestion property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsDmsQuestion(Boolean value) {
		this.isDmsQuestion = value;
	}

	/**
	 * Gets the value of the isInstead property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsInstead() {
		return isInstead;
	}

	/**
	 * Sets the value of the isInstead property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsInstead(Boolean value) {
		this.isInstead = value;
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
	 * {@link PackageItem }
	 * 
	 * 
	 */
	public List<PackageItem> getItems() {
		if (items == null) {
			items = new ArrayList<PackageItem>();
		}
		return this.items;
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
	 * Gets the value of the outStorageBy property.
	 * 
	 * @return possible object is {@link User }
	 * 
	 */
	public User getOutStorageBy() {
		return outStorageBy;
	}

	/**
	 * Sets the value of the outStorageBy property.
	 * 
	 * @param value
	 *            allowed object is {@link User }
	 * 
	 */
	public void setOutStorageBy(User value) {
		this.outStorageBy = value;
	}

	/**
	 * Gets the value of the packageDMSQuestionStatus property.
	 * 
	 * @return possible object is {@link PackageDMSQuestionStatus }
	 * 
	 */
	public PackageDMSQuestionStatus getPackageDMSQuestionStatus() {
		return packageDMSQuestionStatus;
	}

	/**
	 * Sets the value of the packageDMSQuestionStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link PackageDMSQuestionStatus }
	 * 
	 */
	public void setPackageDMSQuestionStatus(PackageDMSQuestionStatus value) {
		this.packageDMSQuestionStatus = value;
	}

	/**
	 * Gets the value of the packageShippingAddress property.
	 * 
	 * @return possible object is {@link PackageShippingAddress }
	 * 
	 */
	public PackageShippingAddress getPackageShippingAddress() {
		return packageShippingAddress;
	}

	/**
	 * Sets the value of the packageShippingAddress property.
	 * 
	 * @param value
	 *            allowed object is {@link PackageShippingAddress }
	 * 
	 */
	public void setPackageShippingAddress(PackageShippingAddress value) {
		this.packageShippingAddress = value;
	}

	/**
	 * Gets the value of the problemEmail property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isProblemEmail() {
		return problemEmail;
	}

	/**
	 * Sets the value of the problemEmail property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setProblemEmail(Boolean value) {
		this.problemEmail = value;
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
	 * Gets the value of the questionStatus property.
	 * 
	 * @return possible object is {@link PackageQuestionStatus }
	 * 
	 */
	public PackageQuestionStatus getQuestionStatus() {
		return questionStatus;
	}

	/**
	 * Sets the value of the questionStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link PackageQuestionStatus }
	 * 
	 */
	public void setQuestionStatus(PackageQuestionStatus value) {
		this.questionStatus = value;
	}

	/**
	 * Gets the value of the releaseTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getReleaseTime() {
		return releaseTime;
	}

	/**
	 * Sets the value of the releaseTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setReleaseTime(XMLGregorianCalendar value) {
		this.releaseTime = value;
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
	 * Gets the value of the source property.
	 * 
	 */
	public int getSource() {
		return source;
	}

	/**
	 * Sets the value of the source property.
	 * 
	 */
	public void setSource(int value) {
		this.source = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link PackageStatus }
	 * 
	 */
	public PackageStatus getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value
	 *            allowed object is {@link PackageStatus }
	 * 
	 */
	public void setStatus(PackageStatus value) {
		this.status = value;
	}

	/**
	 * Gets the value of the traceStatus property.
	 * 
	 * @return possible object is {@link PackageTraceStatus }
	 * 
	 */
	public PackageTraceStatus getTraceStatus() {
		return traceStatus;
	}

	/**
	 * Sets the value of the traceStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link PackageTraceStatus }
	 * 
	 */
	public void setTraceStatus(PackageTraceStatus value) {
		this.traceStatus = value;
	}

	/**
	 * Gets the value of the traceTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getTraceTime() {
		return traceTime;
	}

	/**
	 * Sets the value of the traceTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setTraceTime(XMLGregorianCalendar value) {
		this.traceTime = value;
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
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link PackageType }
	 * 
	 */
	public PackageType getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link PackageType }
	 * 
	 */
	public void setType(PackageType value) {
		this.type = value;
	}

	/**
	 * Gets the value of the weight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getWeight() {
		return weight;
	}

	/**
	 * Sets the value of the weight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setWeight(BigDecimal value) {
		this.weight = value;
	}

}
