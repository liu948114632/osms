package com.itecheasy.webservice.cms.order;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="alreadyTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="boxApplyIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="boxCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="branchRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="collateMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="collateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="collateUserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="countryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cpfCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerServiceRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerSpecial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliverWeight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deliveryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="departmentId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estimateDeliverTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="freeShippingDeliveryIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isAddSendGropColor" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isCanDeliver" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isCheck" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isFirstWebOrder" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isFreeShipping" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isNeedProcessing" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isOrderPosition" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isOrderQuick" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isOversea" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isPendingOrder" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isPicked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isPreparedDeliver" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isQualityInspection" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isRemote" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="merchandiserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orderCostPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderExpand" type="{http://osms.communication.itecheasy.com/}orderExpandInfo" minOccurs="0"/>
 *         &lt;element name="orderPosition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderSizeType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="orderTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="payStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="preparedCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="priorityLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sendGroupId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shippingRemind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stockOutBranchRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stockOutTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="validOrderCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="waitCollateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="websiteWeight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="weighingTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="zip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order", propOrder = { "alreadyTime", "boxApplyIndex", "boxCount", "branchRemark", "city", "code",
		"collateMode", "collateTime", "collateUserId", "countryId", "cpfCode", "customerId", "customerName",
		"customerRemark", "customerServiceRemark", "customerSpecial", "deliverWeight", "deliveryId", "departmentId",
		"estimateDeliverTime", "freeShippingDeliveryIds", "id", "isAddSendGropColor", "isCanDeliver", "isCheck",
		"isFirstWebOrder", "isFreeShipping", "isNeedProcessing", "isOrderPosition", "isOrderQuick", "isOversea",
		"isPendingOrder", "isPicked", "isPreparedDeliver", "isQualityInspection", "isRemote", "merchandiserId",
		"orderCostPrice", "orderDiscount", "orderExpand", "orderPosition", "orderSizeType", "orderTime", "payStatus",
		"preparedCount", "priorityLevel", "sendGroupId", "shippingRemind", "source", "status", "stockOutBranchRemark",
		"stockOutTime", "subType", "type", "validOrderCount", "waitCollateTime", "websiteWeight", "weighingTime", "zip" })
public class Order {

	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar alreadyTime;
	protected int boxApplyIndex;
	protected int boxCount;
	protected String branchRemark;
	protected String city;
	protected String code;
	protected int collateMode;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar collateTime;
	protected int collateUserId;
	protected int countryId;
	protected String cpfCode;
	protected int customerId;
	protected String customerName;
	protected String customerRemark;
	protected String customerServiceRemark;
	protected String customerSpecial;
	protected int deliverWeight;
	protected int deliveryId;
	protected int departmentId;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar estimateDeliverTime;
	protected String freeShippingDeliveryIds;
	protected int id;
	protected Boolean isAddSendGropColor;
	protected boolean isCanDeliver;
	protected boolean isCheck;
	protected Boolean isFirstWebOrder;
	protected Boolean isFreeShipping;
	protected boolean isNeedProcessing;
	protected boolean isOrderPosition;
	protected boolean isOrderQuick;
	protected Boolean isOversea;
	protected boolean isPendingOrder;
	protected Boolean isPicked;
	protected boolean isPreparedDeliver;
	protected boolean isQualityInspection;
	protected boolean isRemote;
	protected int merchandiserId;
	protected BigDecimal orderCostPrice;
	protected BigDecimal orderDiscount;
	protected OrderExpandInfo orderExpand;
	protected String orderPosition;
	protected Integer orderSizeType;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar orderTime;
	protected int payStatus;
	protected int preparedCount;
	protected int priorityLevel;
	protected int sendGroupId;
	protected String shippingRemind;
	protected Integer source;
	protected int status;
	protected String stockOutBranchRemark;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar stockOutTime;
	protected int subType;
	protected int type;
	protected int validOrderCount;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar waitCollateTime;
	protected int websiteWeight;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar weighingTime;
	protected String zip;

	/**
	 * Gets the value of the alreadyTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getAlreadyTime() {
		return alreadyTime;
	}

	/**
	 * Sets the value of the alreadyTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setAlreadyTime(XMLGregorianCalendar value) {
		this.alreadyTime = value;
	}

	/**
	 * Gets the value of the boxApplyIndex property.
	 * 
	 */
	public int getBoxApplyIndex() {
		return boxApplyIndex;
	}

	/**
	 * Sets the value of the boxApplyIndex property.
	 * 
	 */
	public void setBoxApplyIndex(int value) {
		this.boxApplyIndex = value;
	}

	/**
	 * Gets the value of the boxCount property.
	 * 
	 */
	public int getBoxCount() {
		return boxCount;
	}

	/**
	 * Sets the value of the boxCount property.
	 * 
	 */
	public void setBoxCount(int value) {
		this.boxCount = value;
	}

	/**
	 * Gets the value of the branchRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBranchRemark() {
		return branchRemark;
	}

	/**
	 * Sets the value of the branchRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBranchRemark(String value) {
		this.branchRemark = value;
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
	 * Gets the value of the collateMode property.
	 * 
	 */
	public int getCollateMode() {
		return collateMode;
	}

	/**
	 * Sets the value of the collateMode property.
	 * 
	 */
	public void setCollateMode(int value) {
		this.collateMode = value;
	}

	/**
	 * Gets the value of the collateTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getCollateTime() {
		return collateTime;
	}

	/**
	 * Sets the value of the collateTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setCollateTime(XMLGregorianCalendar value) {
		this.collateTime = value;
	}

	/**
	 * Gets the value of the collateUserId property.
	 * 
	 */
	public int getCollateUserId() {
		return collateUserId;
	}

	/**
	 * Sets the value of the collateUserId property.
	 * 
	 */
	public void setCollateUserId(int value) {
		this.collateUserId = value;
	}

	/**
	 * Gets the value of the countryId property.
	 * 
	 */
	public int getCountryId() {
		return countryId;
	}

	/**
	 * Sets the value of the countryId property.
	 * 
	 */
	public void setCountryId(int value) {
		this.countryId = value;
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
	 * Gets the value of the customerId property.
	 * 
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the value of the customerId property.
	 * 
	 */
	public void setCustomerId(int value) {
		this.customerId = value;
	}

	/**
	 * Gets the value of the customerName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Sets the value of the customerName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCustomerName(String value) {
		this.customerName = value;
	}

	/**
	 * Gets the value of the customerRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCustomerRemark() {
		return customerRemark;
	}

	/**
	 * Sets the value of the customerRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCustomerRemark(String value) {
		this.customerRemark = value;
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
	 * Gets the value of the customerSpecial property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCustomerSpecial() {
		return customerSpecial;
	}

	/**
	 * Sets the value of the customerSpecial property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCustomerSpecial(String value) {
		this.customerSpecial = value;
	}

	/**
	 * Gets the value of the deliverWeight property.
	 * 
	 */
	public int getDeliverWeight() {
		return deliverWeight;
	}

	/**
	 * Sets the value of the deliverWeight property.
	 * 
	 */
	public void setDeliverWeight(int value) {
		this.deliverWeight = value;
	}

	/**
	 * Gets the value of the deliveryId property.
	 * 
	 */
	public int getDeliveryId() {
		return deliveryId;
	}

	/**
	 * Sets the value of the deliveryId property.
	 * 
	 */
	public void setDeliveryId(int value) {
		this.deliveryId = value;
	}

	/**
	 * Gets the value of the departmentId property.
	 * 
	 */
	public int getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the value of the departmentId property.
	 * 
	 */
	public void setDepartmentId(int value) {
		this.departmentId = value;
	}

	/**
	 * Gets the value of the estimateDeliverTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getEstimateDeliverTime() {
		return estimateDeliverTime;
	}

	/**
	 * Sets the value of the estimateDeliverTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setEstimateDeliverTime(XMLGregorianCalendar value) {
		this.estimateDeliverTime = value;
	}

	/**
	 * Gets the value of the freeShippingDeliveryIds property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFreeShippingDeliveryIds() {
		return freeShippingDeliveryIds;
	}

	/**
	 * Sets the value of the freeShippingDeliveryIds property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFreeShippingDeliveryIds(String value) {
		this.freeShippingDeliveryIds = value;
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
	 * Gets the value of the isAddSendGropColor property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsAddSendGropColor() {
		return isAddSendGropColor;
	}

	/**
	 * Sets the value of the isAddSendGropColor property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsAddSendGropColor(Boolean value) {
		this.isAddSendGropColor = value;
	}

	/**
	 * Gets the value of the isCanDeliver property.
	 * 
	 */
	public boolean isIsCanDeliver() {
		return isCanDeliver;
	}

	/**
	 * Sets the value of the isCanDeliver property.
	 * 
	 */
	public void setIsCanDeliver(boolean value) {
		this.isCanDeliver = value;
	}

	/**
	 * Gets the value of the isCheck property.
	 * 
	 */
	public boolean isIsCheck() {
		return isCheck;
	}

	/**
	 * Sets the value of the isCheck property.
	 * 
	 */
	public void setIsCheck(boolean value) {
		this.isCheck = value;
	}

	/**
	 * Gets the value of the isFirstWebOrder property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsFirstWebOrder() {
		return isFirstWebOrder;
	}

	/**
	 * Sets the value of the isFirstWebOrder property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsFirstWebOrder(Boolean value) {
		this.isFirstWebOrder = value;
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
	 * Gets the value of the isNeedProcessing property.
	 * 
	 */
	public boolean isIsNeedProcessing() {
		return isNeedProcessing;
	}

	/**
	 * Sets the value of the isNeedProcessing property.
	 * 
	 */
	public void setIsNeedProcessing(boolean value) {
		this.isNeedProcessing = value;
	}

	/**
	 * Gets the value of the isOrderPosition property.
	 * 
	 */
	public boolean isIsOrderPosition() {
		return isOrderPosition;
	}

	/**
	 * Sets the value of the isOrderPosition property.
	 * 
	 */
	public void setIsOrderPosition(boolean value) {
		this.isOrderPosition = value;
	}

	/**
	 * Gets the value of the isOrderQuick property.
	 * 
	 */
	public boolean isIsOrderQuick() {
		return isOrderQuick;
	}

	/**
	 * Sets the value of the isOrderQuick property.
	 * 
	 */
	public void setIsOrderQuick(boolean value) {
		this.isOrderQuick = value;
	}

	/**
	 * Gets the value of the isOversea property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsOversea() {
		return isOversea;
	}

	/**
	 * Sets the value of the isOversea property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsOversea(Boolean value) {
		this.isOversea = value;
	}

	/**
	 * Gets the value of the isPendingOrder property.
	 * 
	 */
	public boolean isIsPendingOrder() {
		return isPendingOrder;
	}

	/**
	 * Sets the value of the isPendingOrder property.
	 * 
	 */
	public void setIsPendingOrder(boolean value) {
		this.isPendingOrder = value;
	}

	/**
	 * Gets the value of the isPicked property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsPicked() {
		return isPicked;
	}

	/**
	 * Sets the value of the isPicked property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsPicked(Boolean value) {
		this.isPicked = value;
	}

	/**
	 * Gets the value of the isPreparedDeliver property.
	 * 
	 */
	public boolean isIsPreparedDeliver() {
		return isPreparedDeliver;
	}

	/**
	 * Sets the value of the isPreparedDeliver property.
	 * 
	 */
	public void setIsPreparedDeliver(boolean value) {
		this.isPreparedDeliver = value;
	}

	/**
	 * Gets the value of the isQualityInspection property.
	 * 
	 */
	public boolean isIsQualityInspection() {
		return isQualityInspection;
	}

	/**
	 * Sets the value of the isQualityInspection property.
	 * 
	 */
	public void setIsQualityInspection(boolean value) {
		this.isQualityInspection = value;
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
	 * Gets the value of the merchandiserId property.
	 * 
	 */
	public int getMerchandiserId() {
		return merchandiserId;
	}

	/**
	 * Sets the value of the merchandiserId property.
	 * 
	 */
	public void setMerchandiserId(int value) {
		this.merchandiserId = value;
	}

	/**
	 * Gets the value of the orderCostPrice property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getOrderCostPrice() {
		return orderCostPrice;
	}

	/**
	 * Sets the value of the orderCostPrice property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setOrderCostPrice(BigDecimal value) {
		this.orderCostPrice = value;
	}

	/**
	 * Gets the value of the orderDiscount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getOrderDiscount() {
		return orderDiscount;
	}

	/**
	 * Sets the value of the orderDiscount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setOrderDiscount(BigDecimal value) {
		this.orderDiscount = value;
	}

	/**
	 * Gets the value of the orderExpand property.
	 * 
	 * @return possible object is {@link OrderExpandInfo }
	 * 
	 */
	public OrderExpandInfo getOrderExpand() {
		return orderExpand;
	}

	/**
	 * Sets the value of the orderExpand property.
	 * 
	 * @param value
	 *            allowed object is {@link OrderExpandInfo }
	 * 
	 */
	public void setOrderExpand(OrderExpandInfo value) {
		this.orderExpand = value;
	}

	/**
	 * Gets the value of the orderPosition property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderPosition() {
		return orderPosition;
	}

	/**
	 * Sets the value of the orderPosition property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderPosition(String value) {
		this.orderPosition = value;
	}

	/**
	 * Gets the value of the orderSizeType property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getOrderSizeType() {
		return orderSizeType;
	}

	/**
	 * Sets the value of the orderSizeType property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setOrderSizeType(Integer value) {
		this.orderSizeType = value;
	}

	/**
	 * Gets the value of the orderTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getOrderTime() {
		return orderTime;
	}

	/**
	 * Sets the value of the orderTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setOrderTime(XMLGregorianCalendar value) {
		this.orderTime = value;
	}

	/**
	 * Gets the value of the payStatus property.
	 * 
	 */
	public int getPayStatus() {
		return payStatus;
	}

	/**
	 * Sets the value of the payStatus property.
	 * 
	 */
	public void setPayStatus(int value) {
		this.payStatus = value;
	}

	/**
	 * Gets the value of the preparedCount property.
	 * 
	 */
	public int getPreparedCount() {
		return preparedCount;
	}

	/**
	 * Sets the value of the preparedCount property.
	 * 
	 */
	public void setPreparedCount(int value) {
		this.preparedCount = value;
	}

	/**
	 * Gets the value of the priorityLevel property.
	 * 
	 */
	public int getPriorityLevel() {
		return priorityLevel;
	}

	/**
	 * Sets the value of the priorityLevel property.
	 * 
	 */
	public void setPriorityLevel(int value) {
		this.priorityLevel = value;
	}

	/**
	 * Gets the value of the sendGroupId property.
	 * 
	 */
	public int getSendGroupId() {
		return sendGroupId;
	}

	/**
	 * Sets the value of the sendGroupId property.
	 * 
	 */
	public void setSendGroupId(int value) {
		this.sendGroupId = value;
	}

	/**
	 * Gets the value of the shippingRemind property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getShippingRemind() {
		return shippingRemind;
	}

	/**
	 * Sets the value of the shippingRemind property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setShippingRemind(String value) {
		this.shippingRemind = value;
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
	 * Gets the value of the status property.
	 * 
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 */
	public void setStatus(int value) {
		this.status = value;
	}

	/**
	 * Gets the value of the stockOutBranchRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStockOutBranchRemark() {
		return stockOutBranchRemark;
	}

	/**
	 * Sets the value of the stockOutBranchRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStockOutBranchRemark(String value) {
		this.stockOutBranchRemark = value;
	}

	/**
	 * Gets the value of the stockOutTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getStockOutTime() {
		return stockOutTime;
	}

	/**
	 * Sets the value of the stockOutTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setStockOutTime(XMLGregorianCalendar value) {
		this.stockOutTime = value;
	}

	/**
	 * Gets the value of the subType property.
	 * 
	 */
	public int getSubType() {
		return subType;
	}

	/**
	 * Sets the value of the subType property.
	 * 
	 */
	public void setSubType(int value) {
		this.subType = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 */
	public int getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 */
	public void setType(int value) {
		this.type = value;
	}

	/**
	 * Gets the value of the validOrderCount property.
	 * 
	 */
	public int getValidOrderCount() {
		return validOrderCount;
	}

	/**
	 * Sets the value of the validOrderCount property.
	 * 
	 */
	public void setValidOrderCount(int value) {
		this.validOrderCount = value;
	}

	/**
	 * Gets the value of the waitCollateTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getWaitCollateTime() {
		return waitCollateTime;
	}

	/**
	 * Sets the value of the waitCollateTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setWaitCollateTime(XMLGregorianCalendar value) {
		this.waitCollateTime = value;
	}

	/**
	 * Gets the value of the websiteWeight property.
	 * 
	 */
	public int getWebsiteWeight() {
		return websiteWeight;
	}

	/**
	 * Sets the value of the websiteWeight property.
	 * 
	 */
	public void setWebsiteWeight(int value) {
		this.websiteWeight = value;
	}

	/**
	 * Gets the value of the weighingTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getWeighingTime() {
		return weighingTime;
	}

	/**
	 * Sets the value of the weighingTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setWeighingTime(XMLGregorianCalendar value) {
		this.weighingTime = value;
	}

	/**
	 * Gets the value of the zip property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Sets the value of the zip property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setZip(String value) {
		this.zip = value;
	}

}
