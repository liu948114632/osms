package com.itecheasy.webservice.crm;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for OrderItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="OrderItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShopCustomerOrderItem" type="{http://tempuri.org/}ShopCustomerOrderItem" minOccurs="0"/>
 *         &lt;element name="OrderItemId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="OrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CmsProductId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProductSetId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ReadyQty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ItemPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SalePrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CostPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Volume" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="IsPromote" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsProductPool" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Box" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="XFreight" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="JoinDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UpdateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CustomerRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BranchRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductImageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Discount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CSRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsPHReplaceProduct" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiveDateEnd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsGift" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ColorCardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecficationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MinBatchQty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ColorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ColorImageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessingStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PackageProductId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsGoOverseasWarehouse" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PromoteType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsBindStorage" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PromoteId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SellBy" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="WebsiteRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderItem", propOrder = { "shopCustomerOrderItem", "orderItemId", "orderId", "productId",
		"cmsProductId", "productSetId", "type", "quantity", "readyQty", "unit", "unitQuantity", "itemPrice",
		"salePrice", "costPrice", "weight", "volume", "isPromote", "isProductPool", "box", "status", "xFreight",
		"joinDate", "updateTime", "customerRemark", "branchRemark", "productCode", "productName", "productDescription",
		"productImageName", "discount", "csRemark", "isPHReplaceProduct", "code", "receiveDate", "receiveDateEnd",
		"isGift", "colorCardName", "specficationName", "minBatchQty", "colorCode", "colorImageName",
		"processingStatus", "packageProductId", "isGoOverseasWarehouse", "promoteType", "isBindStorage", "promoteId",
		"sellBy", "websiteRemark" })
public class OrderItem {

	@XmlElement(name = "ShopCustomerOrderItem")
	protected ShopCustomerOrderItem shopCustomerOrderItem;
	@XmlElement(name = "OrderItemId")
	protected int orderItemId;
	@XmlElement(name = "OrderId")
	protected String orderId;
	@XmlElement(name = "ProductId")
	protected int productId;
	@XmlElement(name = "CmsProductId")
	protected int cmsProductId;
	@XmlElement(name = "ProductSetId")
	protected int productSetId;
	@XmlElement(name = "Type")
	protected int type;
	@XmlElement(name = "Quantity")
	protected int quantity;
	@XmlElement(name = "ReadyQty")
	protected int readyQty;
	@XmlElement(name = "Unit")
	protected String unit;
	@XmlElement(name = "UnitQuantity")
	protected int unitQuantity;
	@XmlElement(name = "ItemPrice", required = true)
	protected BigDecimal itemPrice;
	@XmlElement(name = "SalePrice", required = true)
	protected BigDecimal salePrice;
	@XmlElement(name = "CostPrice", required = true)
	protected BigDecimal costPrice;
	@XmlElement(name = "Weight", required = true)
	protected BigDecimal weight;
	@XmlElement(name = "Volume", required = true)
	protected BigDecimal volume;
	@XmlElement(name = "IsPromote")
	protected boolean isPromote;
	@XmlElement(name = "IsProductPool")
	protected boolean isProductPool;
	@XmlElement(name = "Box")
	protected String box;
	@XmlElement(name = "Status")
	protected int status;
	@XmlElement(name = "XFreight", required = true)
	protected BigDecimal xFreight;
	@XmlElement(name = "JoinDate", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar joinDate;
	@XmlElement(name = "UpdateTime", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar updateTime;
	@XmlElement(name = "CustomerRemark")
	protected String customerRemark;
	@XmlElement(name = "BranchRemark")
	protected String branchRemark;
	@XmlElement(name = "ProductCode")
	protected String productCode;
	@XmlElement(name = "ProductName")
	protected String productName;
	@XmlElement(name = "ProductDescription")
	protected String productDescription;
	@XmlElement(name = "ProductImageName")
	protected String productImageName;
	@XmlElement(name = "Discount", required = true)
	protected BigDecimal discount;
	@XmlElement(name = "CSRemark")
	protected String csRemark;
	@XmlElement(name = "IsPHReplaceProduct")
	protected boolean isPHReplaceProduct;
	@XmlElement(name = "Code")
	protected String code;
	@XmlElement(name = "ReceiveDate")
	protected String receiveDate;
	@XmlElement(name = "ReceiveDateEnd")
	protected String receiveDateEnd;
	@XmlElement(name = "IsGift")
	protected boolean isGift;
	@XmlElement(name = "ColorCardName")
	protected String colorCardName;
	@XmlElement(name = "SpecficationName")
	protected String specficationName;
	@XmlElement(name = "MinBatchQty")
	protected int minBatchQty;
	@XmlElement(name = "ColorCode")
	protected String colorCode;
	@XmlElement(name = "ColorImageName")
	protected String colorImageName;
	@XmlElement(name = "ProcessingStatus")
	protected int processingStatus;
	@XmlElement(name = "PackageProductId")
	protected int packageProductId;
	@XmlElement(name = "IsGoOverseasWarehouse")
	protected boolean isGoOverseasWarehouse;
	@XmlElement(name = "PromoteType")
	protected int promoteType;
	@XmlElement(name = "IsBindStorage")
	protected boolean isBindStorage;
	@XmlElement(name = "PromoteId")
	protected int promoteId;
	@XmlElement(name = "SellBy")
	protected boolean sellBy;
	@XmlElement(name = "WebsiteRemark")
	protected String websiteRemark;

	/**
	 * Gets the value of the shopCustomerOrderItem property.
	 * 
	 * @return possible object is {@link ShopCustomerOrderItem }
	 * 
	 */
	public ShopCustomerOrderItem getShopCustomerOrderItem() {
		return shopCustomerOrderItem;
	}

	/**
	 * Sets the value of the shopCustomerOrderItem property.
	 * 
	 * @param value
	 *            allowed object is {@link ShopCustomerOrderItem }
	 * 
	 */
	public void setShopCustomerOrderItem(ShopCustomerOrderItem value) {
		this.shopCustomerOrderItem = value;
	}

	/**
	 * Gets the value of the orderItemId property.
	 * 
	 */
	public int getOrderItemId() {
		return orderItemId;
	}

	/**
	 * Sets the value of the orderItemId property.
	 * 
	 */
	public void setOrderItemId(int value) {
		this.orderItemId = value;
	}

	/**
	 * Gets the value of the orderId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * Sets the value of the orderId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderId(String value) {
		this.orderId = value;
	}

	/**
	 * Gets the value of the productId property.
	 * 
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Sets the value of the productId property.
	 * 
	 */
	public void setProductId(int value) {
		this.productId = value;
	}

	/**
	 * Gets the value of the cmsProductId property.
	 * 
	 */
	public int getCmsProductId() {
		return cmsProductId;
	}

	/**
	 * Sets the value of the cmsProductId property.
	 * 
	 */
	public void setCmsProductId(int value) {
		this.cmsProductId = value;
	}

	/**
	 * Gets the value of the productSetId property.
	 * 
	 */
	public int getProductSetId() {
		return productSetId;
	}

	/**
	 * Sets the value of the productSetId property.
	 * 
	 */
	public void setProductSetId(int value) {
		this.productSetId = value;
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
	 * Gets the value of the quantity property.
	 * 
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 */
	public void setQuantity(int value) {
		this.quantity = value;
	}

	/**
	 * Gets the value of the readyQty property.
	 * 
	 */
	public int getReadyQty() {
		return readyQty;
	}

	/**
	 * Sets the value of the readyQty property.
	 * 
	 */
	public void setReadyQty(int value) {
		this.readyQty = value;
	}

	/**
	 * Gets the value of the unit property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * Sets the value of the unit property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUnit(String value) {
		this.unit = value;
	}

	/**
	 * Gets the value of the unitQuantity property.
	 * 
	 */
	public int getUnitQuantity() {
		return unitQuantity;
	}

	/**
	 * Sets the value of the unitQuantity property.
	 * 
	 */
	public void setUnitQuantity(int value) {
		this.unitQuantity = value;
	}

	/**
	 * Gets the value of the itemPrice property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	/**
	 * Sets the value of the itemPrice property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setItemPrice(BigDecimal value) {
		this.itemPrice = value;
	}

	/**
	 * Gets the value of the salePrice property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}

	/**
	 * Sets the value of the salePrice property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setSalePrice(BigDecimal value) {
		this.salePrice = value;
	}

	/**
	 * Gets the value of the costPrice property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getCostPrice() {
		return costPrice;
	}

	/**
	 * Sets the value of the costPrice property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setCostPrice(BigDecimal value) {
		this.costPrice = value;
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
	 * Gets the value of the isPromote property.
	 * 
	 */
	public boolean isIsPromote() {
		return isPromote;
	}

	/**
	 * Sets the value of the isPromote property.
	 * 
	 */
	public void setIsPromote(boolean value) {
		this.isPromote = value;
	}

	/**
	 * Gets the value of the isProductPool property.
	 * 
	 */
	public boolean isIsProductPool() {
		return isProductPool;
	}

	/**
	 * Sets the value of the isProductPool property.
	 * 
	 */
	public void setIsProductPool(boolean value) {
		this.isProductPool = value;
	}

	/**
	 * Gets the value of the box property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBox() {
		return box;
	}

	/**
	 * Sets the value of the box property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBox(String value) {
		this.box = value;
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
	 * Gets the value of the xFreight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getXFreight() {
		return xFreight;
	}

	/**
	 * Sets the value of the xFreight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setXFreight(BigDecimal value) {
		this.xFreight = value;
	}

	/**
	 * Gets the value of the joinDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getJoinDate() {
		return joinDate;
	}

	/**
	 * Sets the value of the joinDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setJoinDate(XMLGregorianCalendar value) {
		this.joinDate = value;
	}

	/**
	 * Gets the value of the updateTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getUpdateTime() {
		return updateTime;
	}

	/**
	 * Sets the value of the updateTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setUpdateTime(XMLGregorianCalendar value) {
		this.updateTime = value;
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
	 * Gets the value of the productCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * Sets the value of the productCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductCode(String value) {
		this.productCode = value;
	}

	/**
	 * Gets the value of the productName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the value of the productName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductName(String value) {
		this.productName = value;
	}

	/**
	 * Gets the value of the productDescription property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * Sets the value of the productDescription property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductDescription(String value) {
		this.productDescription = value;
	}

	/**
	 * Gets the value of the productImageName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductImageName() {
		return productImageName;
	}

	/**
	 * Sets the value of the productImageName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductImageName(String value) {
		this.productImageName = value;
	}

	/**
	 * Gets the value of the discount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * Sets the value of the discount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setDiscount(BigDecimal value) {
		this.discount = value;
	}

	/**
	 * Gets the value of the csRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCSRemark() {
		return csRemark;
	}

	/**
	 * Sets the value of the csRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCSRemark(String value) {
		this.csRemark = value;
	}

	/**
	 * Gets the value of the isPHReplaceProduct property.
	 * 
	 */
	public boolean isIsPHReplaceProduct() {
		return isPHReplaceProduct;
	}

	/**
	 * Sets the value of the isPHReplaceProduct property.
	 * 
	 */
	public void setIsPHReplaceProduct(boolean value) {
		this.isPHReplaceProduct = value;
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
	 * Gets the value of the receiveDate property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReceiveDate() {
		return receiveDate;
	}

	/**
	 * Sets the value of the receiveDate property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReceiveDate(String value) {
		this.receiveDate = value;
	}

	/**
	 * Gets the value of the receiveDateEnd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReceiveDateEnd() {
		return receiveDateEnd;
	}

	/**
	 * Sets the value of the receiveDateEnd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReceiveDateEnd(String value) {
		this.receiveDateEnd = value;
	}

	/**
	 * Gets the value of the isGift property.
	 * 
	 */
	public boolean isIsGift() {
		return isGift;
	}

	/**
	 * Sets the value of the isGift property.
	 * 
	 */
	public void setIsGift(boolean value) {
		this.isGift = value;
	}

	/**
	 * Gets the value of the colorCardName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getColorCardName() {
		return colorCardName;
	}

	/**
	 * Sets the value of the colorCardName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setColorCardName(String value) {
		this.colorCardName = value;
	}

	/**
	 * Gets the value of the specficationName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSpecficationName() {
		return specficationName;
	}

	/**
	 * Sets the value of the specficationName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSpecficationName(String value) {
		this.specficationName = value;
	}

	/**
	 * Gets the value of the minBatchQty property.
	 * 
	 */
	public int getMinBatchQty() {
		return minBatchQty;
	}

	/**
	 * Sets the value of the minBatchQty property.
	 * 
	 */
	public void setMinBatchQty(int value) {
		this.minBatchQty = value;
	}

	/**
	 * Gets the value of the colorCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getColorCode() {
		return colorCode;
	}

	/**
	 * Sets the value of the colorCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setColorCode(String value) {
		this.colorCode = value;
	}

	/**
	 * Gets the value of the colorImageName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getColorImageName() {
		return colorImageName;
	}

	/**
	 * Sets the value of the colorImageName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setColorImageName(String value) {
		this.colorImageName = value;
	}

	/**
	 * Gets the value of the processingStatus property.
	 * 
	 */
	public int getProcessingStatus() {
		return processingStatus;
	}

	/**
	 * Sets the value of the processingStatus property.
	 * 
	 */
	public void setProcessingStatus(int value) {
		this.processingStatus = value;
	}

	/**
	 * Gets the value of the packageProductId property.
	 * 
	 */
	public int getPackageProductId() {
		return packageProductId;
	}

	/**
	 * Sets the value of the packageProductId property.
	 * 
	 */
	public void setPackageProductId(int value) {
		this.packageProductId = value;
	}

	/**
	 * Gets the value of the isGoOverseasWarehouse property.
	 * 
	 */
	public boolean isIsGoOverseasWarehouse() {
		return isGoOverseasWarehouse;
	}

	/**
	 * Sets the value of the isGoOverseasWarehouse property.
	 * 
	 */
	public void setIsGoOverseasWarehouse(boolean value) {
		this.isGoOverseasWarehouse = value;
	}

	/**
	 * Gets the value of the promoteType property.
	 * 
	 */
	public int getPromoteType() {
		return promoteType;
	}

	/**
	 * Sets the value of the promoteType property.
	 * 
	 */
	public void setPromoteType(int value) {
		this.promoteType = value;
	}

	/**
	 * Gets the value of the isBindStorage property.
	 * 
	 */
	public boolean isIsBindStorage() {
		return isBindStorage;
	}

	/**
	 * Sets the value of the isBindStorage property.
	 * 
	 */
	public void setIsBindStorage(boolean value) {
		this.isBindStorage = value;
	}

	/**
	 * Gets the value of the promoteId property.
	 * 
	 */
	public int getPromoteId() {
		return promoteId;
	}

	/**
	 * Sets the value of the promoteId property.
	 * 
	 */
	public void setPromoteId(int value) {
		this.promoteId = value;
	}

	/**
	 * Gets the value of the sellBy property.
	 * 
	 */
	public boolean isSellBy() {
		return sellBy;
	}

	/**
	 * Sets the value of the sellBy property.
	 * 
	 */
	public void setSellBy(boolean value) {
		this.sellBy = value;
	}

	/**
	 * Gets the value of the websiteRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWebsiteRemark() {
		return websiteRemark;
	}

	/**
	 * Sets the value of the websiteRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWebsiteRemark(String value) {
		this.websiteRemark = value;
	}

}
