package com.itecheasy.webservice.cms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for findProducts complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="findProducts">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="currentPage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryId1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryId2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryId3" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="seriesId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="firstPropertyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="secondPropertyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="thirdPropertyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fourthPropertyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="firstPropertyValueId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="secondPropertyValueId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="thirdPropertyValueId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fourthPropertyValueId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isProductPool" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isMix" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isGift" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productCodes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isSmallQuantites" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="departmentId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findProducts", propOrder = { "pageSize", "currentPage", "categoryId1", "categoryId2", "categoryId3",
		"seriesId", "firstPropertyId", "secondPropertyId", "thirdPropertyId", "fourthPropertyId",
		"firstPropertyValueId", "secondPropertyValueId", "thirdPropertyValueId", "fourthPropertyValueId",
		"isProductPool", "isMix", "isGift", "productCodes", "productCode", "productName", "isSmallQuantites",
		"departmentId" })
public class FindProducts {

	protected int pageSize;
	protected int currentPage;
	protected int categoryId1;
	protected int categoryId2;
	protected int categoryId3;
	protected int seriesId;
	protected int firstPropertyId;
	protected int secondPropertyId;
	protected int thirdPropertyId;
	protected int fourthPropertyId;
	protected int firstPropertyValueId;
	protected int secondPropertyValueId;
	protected int thirdPropertyValueId;
	protected int fourthPropertyValueId;
	protected int isProductPool;
	protected int isMix;
	protected int isGift;
	protected List<String> productCodes;
	protected String productCode;
	protected String productName;
	protected int isSmallQuantites;
	protected int departmentId;

	/**
	 * Gets the value of the pageSize property.
	 * 
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * Sets the value of the pageSize property.
	 * 
	 */
	public void setPageSize(int value) {
		this.pageSize = value;
	}

	/**
	 * Gets the value of the currentPage property.
	 * 
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * Sets the value of the currentPage property.
	 * 
	 */
	public void setCurrentPage(int value) {
		this.currentPage = value;
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
	 * Gets the value of the firstPropertyId property.
	 * 
	 */
	public int getFirstPropertyId() {
		return firstPropertyId;
	}

	/**
	 * Sets the value of the firstPropertyId property.
	 * 
	 */
	public void setFirstPropertyId(int value) {
		this.firstPropertyId = value;
	}

	/**
	 * Gets the value of the secondPropertyId property.
	 * 
	 */
	public int getSecondPropertyId() {
		return secondPropertyId;
	}

	/**
	 * Sets the value of the secondPropertyId property.
	 * 
	 */
	public void setSecondPropertyId(int value) {
		this.secondPropertyId = value;
	}

	/**
	 * Gets the value of the thirdPropertyId property.
	 * 
	 */
	public int getThirdPropertyId() {
		return thirdPropertyId;
	}

	/**
	 * Sets the value of the thirdPropertyId property.
	 * 
	 */
	public void setThirdPropertyId(int value) {
		this.thirdPropertyId = value;
	}

	/**
	 * Gets the value of the fourthPropertyId property.
	 * 
	 */
	public int getFourthPropertyId() {
		return fourthPropertyId;
	}

	/**
	 * Sets the value of the fourthPropertyId property.
	 * 
	 */
	public void setFourthPropertyId(int value) {
		this.fourthPropertyId = value;
	}

	/**
	 * Gets the value of the firstPropertyValueId property.
	 * 
	 */
	public int getFirstPropertyValueId() {
		return firstPropertyValueId;
	}

	/**
	 * Sets the value of the firstPropertyValueId property.
	 * 
	 */
	public void setFirstPropertyValueId(int value) {
		this.firstPropertyValueId = value;
	}

	/**
	 * Gets the value of the secondPropertyValueId property.
	 * 
	 */
	public int getSecondPropertyValueId() {
		return secondPropertyValueId;
	}

	/**
	 * Sets the value of the secondPropertyValueId property.
	 * 
	 */
	public void setSecondPropertyValueId(int value) {
		this.secondPropertyValueId = value;
	}

	/**
	 * Gets the value of the thirdPropertyValueId property.
	 * 
	 */
	public int getThirdPropertyValueId() {
		return thirdPropertyValueId;
	}

	/**
	 * Sets the value of the thirdPropertyValueId property.
	 * 
	 */
	public void setThirdPropertyValueId(int value) {
		this.thirdPropertyValueId = value;
	}

	/**
	 * Gets the value of the fourthPropertyValueId property.
	 * 
	 */
	public int getFourthPropertyValueId() {
		return fourthPropertyValueId;
	}

	/**
	 * Sets the value of the fourthPropertyValueId property.
	 * 
	 */
	public void setFourthPropertyValueId(int value) {
		this.fourthPropertyValueId = value;
	}

	/**
	 * Gets the value of the isProductPool property.
	 * 
	 */
	public int getIsProductPool() {
		return isProductPool;
	}

	/**
	 * Sets the value of the isProductPool property.
	 * 
	 */
	public void setIsProductPool(int value) {
		this.isProductPool = value;
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
	 * Gets the value of the isGift property.
	 * 
	 */
	public int getIsGift() {
		return isGift;
	}

	/**
	 * Sets the value of the isGift property.
	 * 
	 */
	public void setIsGift(int value) {
		this.isGift = value;
	}

	/**
	 * Gets the value of the productCodes property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the productCodes property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProductCodes().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getProductCodes() {
		if (productCodes == null) {
			productCodes = new ArrayList<String>();
		}
		return this.productCodes;
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
	 * Gets the value of the isSmallQuantites property.
	 * 
	 */
	public int getIsSmallQuantites() {
		return isSmallQuantites;
	}

	/**
	 * Sets the value of the isSmallQuantites property.
	 * 
	 */
	public void setIsSmallQuantites(int value) {
		this.isSmallQuantites = value;
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

}
