
package com.itecheasy.webservice.cms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>findProducts complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
@XmlType(name = "findProducts", propOrder = {
    "pageSize",
    "currentPage",
    "categoryId1",
    "categoryId2",
    "categoryId3",
    "seriesId",
    "firstPropertyId",
    "secondPropertyId",
    "thirdPropertyId",
    "fourthPropertyId",
    "firstPropertyValueId",
    "secondPropertyValueId",
    "thirdPropertyValueId",
    "fourthPropertyValueId",
    "isProductPool",
    "isMix",
    "isGift",
    "productCodes",
    "productCode",
    "productName",
    "isSmallQuantites",
    "departmentId"
})
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
     * 获取pageSize属性的值。
     * 
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置pageSize属性的值。
     * 
     */
    public void setPageSize(int value) {
        this.pageSize = value;
    }

    /**
     * 获取currentPage属性的值。
     * 
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 设置currentPage属性的值。
     * 
     */
    public void setCurrentPage(int value) {
        this.currentPage = value;
    }

    /**
     * 获取categoryId1属性的值。
     * 
     */
    public int getCategoryId1() {
        return categoryId1;
    }

    /**
     * 设置categoryId1属性的值。
     * 
     */
    public void setCategoryId1(int value) {
        this.categoryId1 = value;
    }

    /**
     * 获取categoryId2属性的值。
     * 
     */
    public int getCategoryId2() {
        return categoryId2;
    }

    /**
     * 设置categoryId2属性的值。
     * 
     */
    public void setCategoryId2(int value) {
        this.categoryId2 = value;
    }

    /**
     * 获取categoryId3属性的值。
     * 
     */
    public int getCategoryId3() {
        return categoryId3;
    }

    /**
     * 设置categoryId3属性的值。
     * 
     */
    public void setCategoryId3(int value) {
        this.categoryId3 = value;
    }

    /**
     * 获取seriesId属性的值。
     * 
     */
    public int getSeriesId() {
        return seriesId;
    }

    /**
     * 设置seriesId属性的值。
     * 
     */
    public void setSeriesId(int value) {
        this.seriesId = value;
    }

    /**
     * 获取firstPropertyId属性的值。
     * 
     */
    public int getFirstPropertyId() {
        return firstPropertyId;
    }

    /**
     * 设置firstPropertyId属性的值。
     * 
     */
    public void setFirstPropertyId(int value) {
        this.firstPropertyId = value;
    }

    /**
     * 获取secondPropertyId属性的值。
     * 
     */
    public int getSecondPropertyId() {
        return secondPropertyId;
    }

    /**
     * 设置secondPropertyId属性的值。
     * 
     */
    public void setSecondPropertyId(int value) {
        this.secondPropertyId = value;
    }

    /**
     * 获取thirdPropertyId属性的值。
     * 
     */
    public int getThirdPropertyId() {
        return thirdPropertyId;
    }

    /**
     * 设置thirdPropertyId属性的值。
     * 
     */
    public void setThirdPropertyId(int value) {
        this.thirdPropertyId = value;
    }

    /**
     * 获取fourthPropertyId属性的值。
     * 
     */
    public int getFourthPropertyId() {
        return fourthPropertyId;
    }

    /**
     * 设置fourthPropertyId属性的值。
     * 
     */
    public void setFourthPropertyId(int value) {
        this.fourthPropertyId = value;
    }

    /**
     * 获取firstPropertyValueId属性的值。
     * 
     */
    public int getFirstPropertyValueId() {
        return firstPropertyValueId;
    }

    /**
     * 设置firstPropertyValueId属性的值。
     * 
     */
    public void setFirstPropertyValueId(int value) {
        this.firstPropertyValueId = value;
    }

    /**
     * 获取secondPropertyValueId属性的值。
     * 
     */
    public int getSecondPropertyValueId() {
        return secondPropertyValueId;
    }

    /**
     * 设置secondPropertyValueId属性的值。
     * 
     */
    public void setSecondPropertyValueId(int value) {
        this.secondPropertyValueId = value;
    }

    /**
     * 获取thirdPropertyValueId属性的值。
     * 
     */
    public int getThirdPropertyValueId() {
        return thirdPropertyValueId;
    }

    /**
     * 设置thirdPropertyValueId属性的值。
     * 
     */
    public void setThirdPropertyValueId(int value) {
        this.thirdPropertyValueId = value;
    }

    /**
     * 获取fourthPropertyValueId属性的值。
     * 
     */
    public int getFourthPropertyValueId() {
        return fourthPropertyValueId;
    }

    /**
     * 设置fourthPropertyValueId属性的值。
     * 
     */
    public void setFourthPropertyValueId(int value) {
        this.fourthPropertyValueId = value;
    }

    /**
     * 获取isProductPool属性的值。
     * 
     */
    public int getIsProductPool() {
        return isProductPool;
    }

    /**
     * 设置isProductPool属性的值。
     * 
     */
    public void setIsProductPool(int value) {
        this.isProductPool = value;
    }

    /**
     * 获取isMix属性的值。
     * 
     */
    public int getIsMix() {
        return isMix;
    }

    /**
     * 设置isMix属性的值。
     * 
     */
    public void setIsMix(int value) {
        this.isMix = value;
    }

    /**
     * 获取isGift属性的值。
     * 
     */
    public int getIsGift() {
        return isGift;
    }

    /**
     * 设置isGift属性的值。
     * 
     */
    public void setIsGift(int value) {
        this.isGift = value;
    }

    /**
     * Gets the value of the productCodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productCodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductCodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
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
     * 获取productCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 设置productCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * 获取productName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置productName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * 获取isSmallQuantites属性的值。
     * 
     */
    public int getIsSmallQuantites() {
        return isSmallQuantites;
    }

    /**
     * 设置isSmallQuantites属性的值。
     * 
     */
    public void setIsSmallQuantites(int value) {
        this.isSmallQuantites = value;
    }

    /**
     * 获取departmentId属性的值。
     * 
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置departmentId属性的值。
     * 
     */
    public void setDepartmentId(int value) {
        this.departmentId = value;
    }

}
