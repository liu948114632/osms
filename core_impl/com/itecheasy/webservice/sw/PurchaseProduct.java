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
 * Java class for purchaseProduct complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="purchaseProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actualPurchaseQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="businessCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="changeMark" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="colorRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerServiceRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="demandDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="demandQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentaryPersonnelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expectArrivalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="factoryRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="goodsNumberCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="images" type="{http://osms.communication.itecheasy.com/}purchaseProductImage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isImageColor" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isUserCustom" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="mainMaterialCn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mainMaterialColorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mainMaterialColorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mainMaterialEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldDemandQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://osms.communication.itecheasy.com/}user" minOccurs="0"/>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderProductId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="photoBeforeDelivery" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="purchaseOrderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="purchaseOrderStatus" type="{http://osms.communication.itecheasy.com/}purchaseOrderStatus" minOccurs="0"/>
 *         &lt;element name="purchasePrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="purchaseQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="purchaseRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="purchaseTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="qualityInspectionQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="qualityInspectionRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="readyStock" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="receiveShipmentQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="receiveShipmentRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="receivingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="reimburseMark" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="reimburseStatus" type="{http://osms.communication.itecheasy.com/}reimburseStatus" minOccurs="0"/>
 *         &lt;element name="SKU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sizeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sizeItems" type="{http://osms.communication.itecheasy.com/}purchaseProductSizeItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sizeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sizeNormId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sizeUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://osms.communication.itecheasy.com/}purchaseProductStatus" minOccurs="0"/>
 *         &lt;element name="subMaterialCn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subMaterialColorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subMaterialColorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subMaterialEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supplier" type="{http://osms.communication.itecheasy.com/}supplier" minOccurs="0"/>
 *         &lt;element name="totalWaitReceiveShipmentQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="urgent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="waitPurchaseQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="waitReceiveShipmentQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "purchaseProduct", propOrder = { "actualPurchaseQty", "businessCode", "changeMark", "colorRemark",
		"customerServiceRemark", "demandDate", "demandQty", "description", "documentaryPersonnelName",
		"expectArrivalDate", "factoryRemark", "goodsNumberCode", "id", "images", "isImageColor", "isUserCustom",
		"mainMaterialCn", "mainMaterialColorCode", "mainMaterialColorName", "mainMaterialEn", "oldDemandQty",
		"operator", "orderCode", "orderProductId", "photoBeforeDelivery", "productCode", "productId", "productName",
		"productType", "productUnit", "purchaseOrderCode", "purchaseOrderStatus", "purchasePrice", "purchaseQty",
		"purchaseRemark", "purchaseTime", "qualityInspectionQty", "qualityInspectionRemark", "readyStock",
		"receiveShipmentQty", "receiveShipmentRemark", "receivingDate", "reimburseMark", "reimburseStatus", "sku",
		"sizeId", "sizeItems", "sizeName", "sizeNormId", "sizeUnit", "status", "subMaterialCn", "subMaterialColorCode",
		"subMaterialColorName", "subMaterialEn", "supplier", "totalWaitReceiveShipmentQty", "urgent",
		"waitPurchaseQty", "waitReceiveShipmentQty" })
public class PurchaseProduct {

	protected Integer actualPurchaseQty;
	protected String businessCode;
	protected Boolean changeMark;
	protected String colorRemark;
	protected String customerServiceRemark;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar demandDate;
	protected Integer demandQty;
	protected String description;
	protected String documentaryPersonnelName;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar expectArrivalDate;
	protected String factoryRemark;
	protected String goodsNumberCode;
	protected Integer id;
	@XmlElement(nillable = true)
	protected List<PurchaseProductImage> images;
	protected Boolean isImageColor;
	protected Boolean isUserCustom;
	protected String mainMaterialCn;
	protected String mainMaterialColorCode;
	protected String mainMaterialColorName;
	protected String mainMaterialEn;
	protected Integer oldDemandQty;
	protected User operator;
	protected String orderCode;
	protected Integer orderProductId;
	protected Boolean photoBeforeDelivery;
	protected String productCode;
	protected Integer productId;
	protected String productName;
	protected int productType;
	protected String productUnit;
	protected String purchaseOrderCode;
	protected PurchaseOrderStatus purchaseOrderStatus;
	protected BigDecimal purchasePrice;
	protected Integer purchaseQty;
	protected String purchaseRemark;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar purchaseTime;
	protected Integer qualityInspectionQty;
	protected String qualityInspectionRemark;
	protected Boolean readyStock;
	protected Integer receiveShipmentQty;
	protected String receiveShipmentRemark;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar receivingDate;
	protected Boolean reimburseMark;
	protected ReimburseStatus reimburseStatus;
	@XmlElement(name = "SKU")
	protected String sku;
	protected Integer sizeId;
	@XmlElement(nillable = true)
	protected List<PurchaseProductSizeItem> sizeItems;
	protected String sizeName;
	protected Integer sizeNormId;
	protected String sizeUnit;
	protected PurchaseProductStatus status;
	protected String subMaterialCn;
	protected String subMaterialColorCode;
	protected String subMaterialColorName;
	protected String subMaterialEn;
	protected Supplier supplier;
	protected Integer totalWaitReceiveShipmentQty;
	protected Boolean urgent;
	protected Integer waitPurchaseQty;
	protected Integer waitReceiveShipmentQty;

	/**
	 * Gets the value of the actualPurchaseQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getActualPurchaseQty() {
		return actualPurchaseQty;
	}

	/**
	 * Sets the value of the actualPurchaseQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setActualPurchaseQty(Integer value) {
		this.actualPurchaseQty = value;
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
	 * Gets the value of the changeMark property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isChangeMark() {
		return changeMark;
	}

	/**
	 * Sets the value of the changeMark property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setChangeMark(Boolean value) {
		this.changeMark = value;
	}

	/**
	 * Gets the value of the colorRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getColorRemark() {
		return colorRemark;
	}

	/**
	 * Sets the value of the colorRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setColorRemark(String value) {
		this.colorRemark = value;
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
	 * Gets the value of the demandDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDemandDate() {
		return demandDate;
	}

	/**
	 * Sets the value of the demandDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDemandDate(XMLGregorianCalendar value) {
		this.demandDate = value;
	}

	/**
	 * Gets the value of the demandQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getDemandQty() {
		return demandQty;
	}

	/**
	 * Sets the value of the demandQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setDemandQty(Integer value) {
		this.demandQty = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
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
	 * Gets the value of the expectArrivalDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getExpectArrivalDate() {
		return expectArrivalDate;
	}

	/**
	 * Sets the value of the expectArrivalDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setExpectArrivalDate(XMLGregorianCalendar value) {
		this.expectArrivalDate = value;
	}

	/**
	 * Gets the value of the factoryRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFactoryRemark() {
		return factoryRemark;
	}

	/**
	 * Sets the value of the factoryRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFactoryRemark(String value) {
		this.factoryRemark = value;
	}

	/**
	 * Gets the value of the goodsNumberCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGoodsNumberCode() {
		return goodsNumberCode;
	}

	/**
	 * Sets the value of the goodsNumberCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGoodsNumberCode(String value) {
		this.goodsNumberCode = value;
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
	 * Gets the value of the images property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the images property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getImages().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PurchaseProductImage }
	 * 
	 * 
	 */
	public List<PurchaseProductImage> getImages() {
		if (images == null) {
			images = new ArrayList<PurchaseProductImage>();
		}
		return this.images;
	}

	/**
	 * Gets the value of the isImageColor property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsImageColor() {
		return isImageColor;
	}

	/**
	 * Sets the value of the isImageColor property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsImageColor(Boolean value) {
		this.isImageColor = value;
	}

	/**
	 * Gets the value of the isUserCustom property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsUserCustom() {
		return isUserCustom;
	}

	/**
	 * Sets the value of the isUserCustom property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsUserCustom(Boolean value) {
		this.isUserCustom = value;
	}

	/**
	 * Gets the value of the mainMaterialCn property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMainMaterialCn() {
		return mainMaterialCn;
	}

	/**
	 * Sets the value of the mainMaterialCn property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMainMaterialCn(String value) {
		this.mainMaterialCn = value;
	}

	/**
	 * Gets the value of the mainMaterialColorCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMainMaterialColorCode() {
		return mainMaterialColorCode;
	}

	/**
	 * Sets the value of the mainMaterialColorCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMainMaterialColorCode(String value) {
		this.mainMaterialColorCode = value;
	}

	/**
	 * Gets the value of the mainMaterialColorName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMainMaterialColorName() {
		return mainMaterialColorName;
	}

	/**
	 * Sets the value of the mainMaterialColorName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMainMaterialColorName(String value) {
		this.mainMaterialColorName = value;
	}

	/**
	 * Gets the value of the mainMaterialEn property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMainMaterialEn() {
		return mainMaterialEn;
	}

	/**
	 * Sets the value of the mainMaterialEn property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMainMaterialEn(String value) {
		this.mainMaterialEn = value;
	}

	/**
	 * Gets the value of the oldDemandQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getOldDemandQty() {
		return oldDemandQty;
	}

	/**
	 * Sets the value of the oldDemandQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setOldDemandQty(Integer value) {
		this.oldDemandQty = value;
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
	 * Gets the value of the orderProductId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getOrderProductId() {
		return orderProductId;
	}

	/**
	 * Sets the value of the orderProductId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setOrderProductId(Integer value) {
		this.orderProductId = value;
	}

	/**
	 * Gets the value of the photoBeforeDelivery property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isPhotoBeforeDelivery() {
		return photoBeforeDelivery;
	}

	/**
	 * Sets the value of the photoBeforeDelivery property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setPhotoBeforeDelivery(Boolean value) {
		this.photoBeforeDelivery = value;
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
	 * Gets the value of the productId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * Sets the value of the productId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setProductId(Integer value) {
		this.productId = value;
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
	 * Gets the value of the productType property.
	 * 
	 */
	public int getProductType() {
		return productType;
	}

	/**
	 * Sets the value of the productType property.
	 * 
	 */
	public void setProductType(int value) {
		this.productType = value;
	}

	/**
	 * Gets the value of the productUnit property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductUnit() {
		return productUnit;
	}

	/**
	 * Sets the value of the productUnit property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductUnit(String value) {
		this.productUnit = value;
	}

	/**
	 * Gets the value of the purchaseOrderCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPurchaseOrderCode() {
		return purchaseOrderCode;
	}

	/**
	 * Sets the value of the purchaseOrderCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPurchaseOrderCode(String value) {
		this.purchaseOrderCode = value;
	}

	/**
	 * Gets the value of the purchaseOrderStatus property.
	 * 
	 * @return possible object is {@link PurchaseOrderStatus }
	 * 
	 */
	public PurchaseOrderStatus getPurchaseOrderStatus() {
		return purchaseOrderStatus;
	}

	/**
	 * Sets the value of the purchaseOrderStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link PurchaseOrderStatus }
	 * 
	 */
	public void setPurchaseOrderStatus(PurchaseOrderStatus value) {
		this.purchaseOrderStatus = value;
	}

	/**
	 * Gets the value of the purchasePrice property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * Sets the value of the purchasePrice property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPurchasePrice(BigDecimal value) {
		this.purchasePrice = value;
	}

	/**
	 * Gets the value of the purchaseQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getPurchaseQty() {
		return purchaseQty;
	}

	/**
	 * Sets the value of the purchaseQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setPurchaseQty(Integer value) {
		this.purchaseQty = value;
	}

	/**
	 * Gets the value of the purchaseRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPurchaseRemark() {
		return purchaseRemark;
	}

	/**
	 * Sets the value of the purchaseRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPurchaseRemark(String value) {
		this.purchaseRemark = value;
	}

	/**
	 * Gets the value of the purchaseTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getPurchaseTime() {
		return purchaseTime;
	}

	/**
	 * Sets the value of the purchaseTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setPurchaseTime(XMLGregorianCalendar value) {
		this.purchaseTime = value;
	}

	/**
	 * Gets the value of the qualityInspectionQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getQualityInspectionQty() {
		return qualityInspectionQty;
	}

	/**
	 * Sets the value of the qualityInspectionQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setQualityInspectionQty(Integer value) {
		this.qualityInspectionQty = value;
	}

	/**
	 * Gets the value of the qualityInspectionRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getQualityInspectionRemark() {
		return qualityInspectionRemark;
	}

	/**
	 * Sets the value of the qualityInspectionRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setQualityInspectionRemark(String value) {
		this.qualityInspectionRemark = value;
	}

	/**
	 * Gets the value of the readyStock property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isReadyStock() {
		return readyStock;
	}

	/**
	 * Sets the value of the readyStock property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setReadyStock(Boolean value) {
		this.readyStock = value;
	}

	/**
	 * Gets the value of the receiveShipmentQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getReceiveShipmentQty() {
		return receiveShipmentQty;
	}

	/**
	 * Sets the value of the receiveShipmentQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setReceiveShipmentQty(Integer value) {
		this.receiveShipmentQty = value;
	}

	/**
	 * Gets the value of the receiveShipmentRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReceiveShipmentRemark() {
		return receiveShipmentRemark;
	}

	/**
	 * Sets the value of the receiveShipmentRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReceiveShipmentRemark(String value) {
		this.receiveShipmentRemark = value;
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
	 * Gets the value of the reimburseMark property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isReimburseMark() {
		return reimburseMark;
	}

	/**
	 * Sets the value of the reimburseMark property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setReimburseMark(Boolean value) {
		this.reimburseMark = value;
	}

	/**
	 * Gets the value of the reimburseStatus property.
	 * 
	 * @return possible object is {@link ReimburseStatus }
	 * 
	 */
	public ReimburseStatus getReimburseStatus() {
		return reimburseStatus;
	}

	/**
	 * Sets the value of the reimburseStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link ReimburseStatus }
	 * 
	 */
	public void setReimburseStatus(ReimburseStatus value) {
		this.reimburseStatus = value;
	}

	/**
	 * Gets the value of the sku property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSKU() {
		return sku;
	}

	/**
	 * Sets the value of the sku property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSKU(String value) {
		this.sku = value;
	}

	/**
	 * Gets the value of the sizeId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getSizeId() {
		return sizeId;
	}

	/**
	 * Sets the value of the sizeId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setSizeId(Integer value) {
		this.sizeId = value;
	}

	/**
	 * Gets the value of the sizeItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the sizeItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSizeItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PurchaseProductSizeItem }
	 * 
	 * 
	 */
	public List<PurchaseProductSizeItem> getSizeItems() {
		if (sizeItems == null) {
			sizeItems = new ArrayList<PurchaseProductSizeItem>();
		}
		return this.sizeItems;
	}

	/**
	 * Gets the value of the sizeName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSizeName() {
		return sizeName;
	}

	/**
	 * Sets the value of the sizeName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSizeName(String value) {
		this.sizeName = value;
	}

	/**
	 * Gets the value of the sizeNormId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getSizeNormId() {
		return sizeNormId;
	}

	/**
	 * Sets the value of the sizeNormId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setSizeNormId(Integer value) {
		this.sizeNormId = value;
	}

	/**
	 * Gets the value of the sizeUnit property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSizeUnit() {
		return sizeUnit;
	}

	/**
	 * Sets the value of the sizeUnit property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSizeUnit(String value) {
		this.sizeUnit = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link PurchaseProductStatus }
	 * 
	 */
	public PurchaseProductStatus getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value
	 *            allowed object is {@link PurchaseProductStatus }
	 * 
	 */
	public void setStatus(PurchaseProductStatus value) {
		this.status = value;
	}

	/**
	 * Gets the value of the subMaterialCn property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSubMaterialCn() {
		return subMaterialCn;
	}

	/**
	 * Sets the value of the subMaterialCn property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSubMaterialCn(String value) {
		this.subMaterialCn = value;
	}

	/**
	 * Gets the value of the subMaterialColorCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSubMaterialColorCode() {
		return subMaterialColorCode;
	}

	/**
	 * Sets the value of the subMaterialColorCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSubMaterialColorCode(String value) {
		this.subMaterialColorCode = value;
	}

	/**
	 * Gets the value of the subMaterialColorName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSubMaterialColorName() {
		return subMaterialColorName;
	}

	/**
	 * Sets the value of the subMaterialColorName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSubMaterialColorName(String value) {
		this.subMaterialColorName = value;
	}

	/**
	 * Gets the value of the subMaterialEn property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSubMaterialEn() {
		return subMaterialEn;
	}

	/**
	 * Sets the value of the subMaterialEn property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSubMaterialEn(String value) {
		this.subMaterialEn = value;
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
	 * Gets the value of the totalWaitReceiveShipmentQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getTotalWaitReceiveShipmentQty() {
		return totalWaitReceiveShipmentQty;
	}

	/**
	 * Sets the value of the totalWaitReceiveShipmentQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setTotalWaitReceiveShipmentQty(Integer value) {
		this.totalWaitReceiveShipmentQty = value;
	}

	/**
	 * Gets the value of the urgent property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isUrgent() {
		return urgent;
	}

	/**
	 * Sets the value of the urgent property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setUrgent(Boolean value) {
		this.urgent = value;
	}

	/**
	 * Gets the value of the waitPurchaseQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getWaitPurchaseQty() {
		return waitPurchaseQty;
	}

	/**
	 * Sets the value of the waitPurchaseQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setWaitPurchaseQty(Integer value) {
		this.waitPurchaseQty = value;
	}

	/**
	 * Gets the value of the waitReceiveShipmentQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getWaitReceiveShipmentQty() {
		return waitReceiveShipmentQty;
	}

	/**
	 * Sets the value of the waitReceiveShipmentQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setWaitReceiveShipmentQty(Integer value) {
		this.waitReceiveShipmentQty = value;
	}

}
