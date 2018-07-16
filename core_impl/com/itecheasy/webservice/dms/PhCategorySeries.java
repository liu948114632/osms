
package com.itecheasy.webservice.dms;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for phCategorySeries complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="phCategorySeries">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="category1Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="category2Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="category3Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="firstProfitCoefficient" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isDefault" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isDefaultSmallLot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isSmallLot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="secondProfitCoefficient" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="thirdProfitCoefficient" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "phCategorySeries", propOrder = {
    "category1Id",
    "category2Id",
    "category3Id",
    "categoryId",
    "firstProfitCoefficient",
    "id",
    "isDefault",
    "isDefaultSmallLot",
    "isSmallLot",
    "name",
    "productCount",
    "secondProfitCoefficient",
    "thirdProfitCoefficient"
})
public class PhCategorySeries {

    protected int category1Id;
    protected int category2Id;
    protected int category3Id;
    protected int categoryId;
    protected BigDecimal firstProfitCoefficient;
    protected int id;
    protected boolean isDefault;
    protected Boolean isDefaultSmallLot;
    protected Boolean isSmallLot;
    protected String name;
    protected int productCount;
    protected BigDecimal secondProfitCoefficient;
    protected BigDecimal thirdProfitCoefficient;

    /**
     * Gets the value of the category1Id property.
     * 
     */
    public int getCategory1Id() {
        return category1Id;
    }

    /**
     * Sets the value of the category1Id property.
     * 
     */
    public void setCategory1Id(int value) {
        this.category1Id = value;
    }

    /**
     * Gets the value of the category2Id property.
     * 
     */
    public int getCategory2Id() {
        return category2Id;
    }

    /**
     * Sets the value of the category2Id property.
     * 
     */
    public void setCategory2Id(int value) {
        this.category2Id = value;
    }

    /**
     * Gets the value of the category3Id property.
     * 
     */
    public int getCategory3Id() {
        return category3Id;
    }

    /**
     * Sets the value of the category3Id property.
     * 
     */
    public void setCategory3Id(int value) {
        this.category3Id = value;
    }

    /**
     * Gets the value of the categoryId property.
     * 
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the value of the categoryId property.
     * 
     */
    public void setCategoryId(int value) {
        this.categoryId = value;
    }

    /**
     * Gets the value of the firstProfitCoefficient property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFirstProfitCoefficient() {
        return firstProfitCoefficient;
    }

    /**
     * Sets the value of the firstProfitCoefficient property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFirstProfitCoefficient(BigDecimal value) {
        this.firstProfitCoefficient = value;
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
     * Gets the value of the isDefault property.
     * 
     */
    public boolean isIsDefault() {
        return isDefault;
    }

    /**
     * Sets the value of the isDefault property.
     * 
     */
    public void setIsDefault(boolean value) {
        this.isDefault = value;
    }

    /**
     * Gets the value of the isDefaultSmallLot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDefaultSmallLot() {
        return isDefaultSmallLot;
    }

    /**
     * Sets the value of the isDefaultSmallLot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDefaultSmallLot(Boolean value) {
        this.isDefaultSmallLot = value;
    }

    /**
     * Gets the value of the isSmallLot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSmallLot() {
        return isSmallLot;
    }

    /**
     * Sets the value of the isSmallLot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSmallLot(Boolean value) {
        this.isSmallLot = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the productCount property.
     * 
     */
    public int getProductCount() {
        return productCount;
    }

    /**
     * Sets the value of the productCount property.
     * 
     */
    public void setProductCount(int value) {
        this.productCount = value;
    }

    /**
     * Gets the value of the secondProfitCoefficient property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSecondProfitCoefficient() {
        return secondProfitCoefficient;
    }

    /**
     * Sets the value of the secondProfitCoefficient property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSecondProfitCoefficient(BigDecimal value) {
        this.secondProfitCoefficient = value;
    }

    /**
     * Gets the value of the thirdProfitCoefficient property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getThirdProfitCoefficient() {
        return thirdProfitCoefficient;
    }

    /**
     * Sets the value of the thirdProfitCoefficient property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setThirdProfitCoefficient(BigDecimal value) {
        this.thirdProfitCoefficient = value;
    }

}
