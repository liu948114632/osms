package com.itecheasy.webservice.cms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for osmsProductDetail complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="osmsProductDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="availableStock" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="category1Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category2Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category3Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categoryId1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryId2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryId3" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="colorCardPictureCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="costPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isGift" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isMix" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isProductPool" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isSmallQuantities" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isTs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="offlineStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="phProductId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="phSalePrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="primaryPictureCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productPictures" type="{http://osms.communication.itecheasy.com/}productPicture" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productPropertyValues" type="{http://osms.communication.itecheasy.com/}osmsProductPropertyValueBind" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reviewStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="seriesId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "osmsProductDetail", propOrder = { "availableStock", "category1Name", "category2Name", "category3Name",
		"categoryId1", "categoryId2", "categoryId3", "code", "colorCardPictureCode", "costPrice", "description", "id",
		"isGift", "isMix", "isProductPool", "isSmallQuantities", "isTs", "name", "offlineStatus", "phProductId",
		"phSalePrice", "primaryPictureCode", "productPictures", "productPropertyValues", "reviewStatus", "seriesId",
		"unit", "unitQuantity", "volume", "weight" })
public class OsmsProductDetail {

	protected double availableStock;
	protected String category1Name;
	protected String category2Name;
	protected String category3Name;
	protected int categoryId1;
	protected int categoryId2;
	protected int categoryId3;
	protected String code;
	protected String colorCardPictureCode;
	protected BigDecimal costPrice;
	protected String description;
	protected int id;
	protected boolean isGift;
	protected int isMix;
	protected boolean isProductPool;
	protected boolean isSmallQuantities;
	protected Boolean isTs;
	protected String name;
	protected int offlineStatus;
	protected int phProductId;
	protected BigDecimal phSalePrice;
	protected String primaryPictureCode;
	@XmlElement(nillable = true)
	protected List<ProductPicture> productPictures;
	@XmlElement(nillable = true)
	protected List<OsmsProductPropertyValueBind> productPropertyValues;
	protected Integer reviewStatus;
	protected int seriesId;
	protected String unit;
	protected int unitQuantity;
	protected BigDecimal volume;
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
	 * Gets the value of the category1Name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCategory1Name() {
		return category1Name;
	}

	/**
	 * Sets the value of the category1Name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCategory1Name(String value) {
		this.category1Name = value;
	}

	/**
	 * Gets the value of the category2Name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCategory2Name() {
		return category2Name;
	}

	/**
	 * Sets the value of the category2Name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCategory2Name(String value) {
		this.category2Name = value;
	}

	/**
	 * Gets the value of the category3Name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCategory3Name() {
		return category3Name;
	}

	/**
	 * Sets the value of the category3Name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCategory3Name(String value) {
		this.category3Name = value;
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
	 * Gets the value of the colorCardPictureCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getColorCardPictureCode() {
		return colorCardPictureCode;
	}

	/**
	 * Sets the value of the colorCardPictureCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setColorCardPictureCode(String value) {
		this.colorCardPictureCode = value;
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
	 * Gets the value of the isTs property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsTs() {
		return isTs;
	}

	/**
	 * Sets the value of the isTs property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIsTs(Boolean value) {
		this.isTs = value;
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
	 * Gets the value of the offlineStatus property.
	 * 
	 */
	public int getOfflineStatus() {
		return offlineStatus;
	}

	/**
	 * Sets the value of the offlineStatus property.
	 * 
	 */
	public void setOfflineStatus(int value) {
		this.offlineStatus = value;
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
	 * Gets the value of the productPictures property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the productPictures property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProductPictures().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ProductPicture }
	 * 
	 * 
	 */
	public List<ProductPicture> getProductPictures() {
		if (productPictures == null) {
			productPictures = new ArrayList<ProductPicture>();
		}
		return this.productPictures;
	}

	/**
	 * Gets the value of the productPropertyValues property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the productPropertyValues property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProductPropertyValues().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link OsmsProductPropertyValueBind }
	 * 
	 * 
	 */
	public List<OsmsProductPropertyValueBind> getProductPropertyValues() {
		if (productPropertyValues == null) {
			productPropertyValues = new ArrayList<OsmsProductPropertyValueBind>();
		}
		return this.productPropertyValues;
	}

	/**
	 * Gets the value of the reviewStatus property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getReviewStatus() {
		return reviewStatus;
	}

	/**
	 * Sets the value of the reviewStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setReviewStatus(Integer value) {
		this.reviewStatus = value;
	}

	/**
	 * Gets the value of the seriesId property.
	 * 
	 */
	public int getSeriesId() {
		return seriesId;
	}

	/**
	 * Sets the value of the seriesId property.
	 * 
	 */
	public void setSeriesId(int value) {
		this.seriesId = value;
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
