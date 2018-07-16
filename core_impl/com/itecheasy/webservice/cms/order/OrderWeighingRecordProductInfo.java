package com.itecheasy.webservice.cms.order;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for orderWeighingRecordProductInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderWeighingRecordProductInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="box" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="classification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceCnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceEnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="material" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderQutity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productCnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="salePrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="usage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
@XmlType(name = "orderWeighingRecordProductInfo", propOrder = { "box", "categoyName", "classification", "description",
		"hsCode", "invoiceCnName", "invoiceEnName", "material", "orderQutity", "productCnName", "productCode",
		"productId", "productName", "salePrice", "unit", "unitQuantity", "usage", "volume", "weight" })
public class OrderWeighingRecordProductInfo {

	protected int box;
	protected String categoyName;
	protected String classification;
	protected String description;
	protected String hsCode;
	protected String invoiceCnName;
	protected String invoiceEnName;
	protected String material;
	protected int orderQutity;
	protected String productCnName;
	protected String productCode;
	protected int productId;
	protected String productName;
	protected BigDecimal salePrice;
	protected String unit;
	protected int unitQuantity;
	protected String usage;
	protected BigDecimal volume;
	protected BigDecimal weight;

	/**
	 * Gets the value of the box property.
	 * 
	 */
	public int getBox() {
		return box;
	}

	/**
	 * Sets the value of the box property.
	 * 
	 */
	public void setBox(int value) {
		this.box = value;
	}

	/**
	 * Gets the value of the categoyName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCategoyName() {
		return categoyName;
	}

	/**
	 * Sets the value of the categoyName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCategoyName(String value) {
		this.categoyName = value;
	}

	/**
	 * Gets the value of the classification property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * Sets the value of the classification property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setClassification(String value) {
		this.classification = value;
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
	 * Gets the value of the hsCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHsCode() {
		return hsCode;
	}

	/**
	 * Sets the value of the hsCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHsCode(String value) {
		this.hsCode = value;
	}

	/**
	 * Gets the value of the invoiceCnName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getInvoiceCnName() {
		return invoiceCnName;
	}

	/**
	 * Sets the value of the invoiceCnName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInvoiceCnName(String value) {
		this.invoiceCnName = value;
	}

	/**
	 * Gets the value of the invoiceEnName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getInvoiceEnName() {
		return invoiceEnName;
	}

	/**
	 * Sets the value of the invoiceEnName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInvoiceEnName(String value) {
		this.invoiceEnName = value;
	}

	/**
	 * Gets the value of the material property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Sets the value of the material property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMaterial(String value) {
		this.material = value;
	}

	/**
	 * Gets the value of the orderQutity property.
	 * 
	 */
	public int getOrderQutity() {
		return orderQutity;
	}

	/**
	 * Sets the value of the orderQutity property.
	 * 
	 */
	public void setOrderQutity(int value) {
		this.orderQutity = value;
	}

	/**
	 * Gets the value of the productCnName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductCnName() {
		return productCnName;
	}

	/**
	 * Sets the value of the productCnName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductCnName(String value) {
		this.productCnName = value;
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
	 * Gets the value of the usage property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUsage() {
		return usage;
	}

	/**
	 * Sets the value of the usage property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUsage(String value) {
		this.usage = value;
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
