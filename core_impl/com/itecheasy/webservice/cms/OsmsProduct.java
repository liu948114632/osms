package com.itecheasy.webservice.cms;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for osmsProduct complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="osmsProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="availableStock" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="categoryId1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryId2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryId3" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="costPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="fbaeStock" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isGift" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isMix" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isProductPool" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isSmallQuantities" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phProductId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="phSalePrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="primaryPictureCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="realFreezeQuantity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="sellOrderStock" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "osmsProduct", propOrder = { "availableStock", "categoryId1", "categoryId2", "categoryId3", "code",
		"costPrice", "fbaeStock", "id", "isGift", "isMix", "isProductPool", "isSmallQuantities", "name", "phProductId",
		"phSalePrice", "primaryPictureCode", "realFreezeQuantity", "sellOrderStock", "unit", "unitQuantity", "weight" })
public class OsmsProduct {

	protected double availableStock;
	protected int categoryId1;
	protected int categoryId2;
	protected int categoryId3;
	protected String code;
	protected BigDecimal costPrice;
	protected BigDecimal fbaeStock;
	protected int id;
	protected boolean isGift;
	protected int isMix;
	protected boolean isProductPool;
	protected boolean isSmallQuantities;
	protected String name;
	protected int phProductId;
	protected BigDecimal phSalePrice;
	protected String primaryPictureCode;
	protected double realFreezeQuantity;
	protected BigDecimal sellOrderStock;
	protected String unit;
	protected int unitQuantity;
	protected BigDecimal weight;

	/**
	 * Gets the value of the availableStock property.
	 * 
	 */
	public double getAvailableStock() {
		return availableStock;
	}

	/**
	 * Sets the value of the availableStock property.
	 * 
	 */
	public void setAvailableStock(double value) {
		this.availableStock = value;
	}

	/**
	 * Gets the value of the categoryId1 property.
	 * 
	 */
	public int getCategoryId1() {
		return categoryId1;
	}

	/**
	 * Sets the value of the categoryId1 property.
	 * 
	 */
	public void setCategoryId1(int value) {
		this.categoryId1 = value;
	}

	/**
	 * Gets the value of the categoryId2 property.
	 * 
	 */
	public int getCategoryId2() {
		return categoryId2;
	}

	/**
	 * Sets the value of the categoryId2 property.
	 * 
	 */
	public void setCategoryId2(int value) {
		this.categoryId2 = value;
	}

	/**
	 * Gets the value of the categoryId3 property.
	 * 
	 */
	public int getCategoryId3() {
		return categoryId3;
	}

	/**
	 * Sets the value of the categoryId3 property.
	 * 
	 */
	public void setCategoryId3(int value) {
		this.categoryId3 = value;
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
	 * Gets the value of the fbaeStock property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getFbaeStock() {
		return fbaeStock;
	}

	/**
	 * Sets the value of the fbaeStock property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setFbaeStock(BigDecimal value) {
		this.fbaeStock = value;
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
	 * Gets the value of the isMix property.
	 * 
	 */
	public int getIsMix() {
		return isMix;
	}

	/**
	 * Sets the value of the isMix property.
	 * 
	 */
	public void setIsMix(int value) {
		this.isMix = value;
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
	 * Gets the value of the isSmallQuantities property.
	 * 
	 */
	public boolean isIsSmallQuantities() {
		return isSmallQuantities;
	}

	/**
	 * Sets the value of the isSmallQuantities property.
	 * 
	 */
	public void setIsSmallQuantities(boolean value) {
		this.isSmallQuantities = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the phProductId property.
	 * 
	 */
	public int getPhProductId() {
		return phProductId;
	}

	/**
	 * Sets the value of the phProductId property.
	 * 
	 */
	public void setPhProductId(int value) {
		this.phProductId = value;
	}

	/**
	 * Gets the value of the phSalePrice property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPhSalePrice() {
		return phSalePrice;
	}

	/**
	 * Sets the value of the phSalePrice property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPhSalePrice(BigDecimal value) {
		this.phSalePrice = value;
	}

	/**
	 * Gets the value of the primaryPictureCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPrimaryPictureCode() {
		return primaryPictureCode;
	}

	/**
	 * Sets the value of the primaryPictureCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPrimaryPictureCode(String value) {
		this.primaryPictureCode = value;
	}

	/**
	 * Gets the value of the realFreezeQuantity property.
	 * 
	 */
	public double getRealFreezeQuantity() {
		return realFreezeQuantity;
	}

	/**
	 * Sets the value of the realFreezeQuantity property.
	 * 
	 */
	public void setRealFreezeQuantity(double value) {
		this.realFreezeQuantity = value;
	}

	/**
	 * Gets the value of the sellOrderStock property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getSellOrderStock() {
		return sellOrderStock;
	}

	/**
	 * Sets the value of the sellOrderStock property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setSellOrderStock(BigDecimal value) {
		this.sellOrderStock = value;
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
