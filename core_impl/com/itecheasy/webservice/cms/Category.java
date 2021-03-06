
package com.itecheasy.webservice.cms;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>category complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="category">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="invoiceCnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceEnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isVolumeRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="level" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packageVolumeRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="parentID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="volumeRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="weightRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "category", propOrder = {
    "description",
    "hsCode",
    "id",
    "invoiceCnName",
    "invoiceEnName",
    "isVolumeRequired",
    "level",
    "name",
    "packageVolumeRate",
    "parentID",
    "type",
    "volumeRate",
    "weightRate"
})
public class Category {

    protected String description;
    protected String hsCode;
    protected int id;
    protected String invoiceCnName;
    protected String invoiceEnName;
    protected boolean isVolumeRequired;
    protected int level;
    protected String name;
    protected BigDecimal packageVolumeRate;
    protected int parentID;
    protected int type;
    protected BigDecimal volumeRate;
    protected BigDecimal weightRate;

    /**
     * 获取description属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置description属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * 获取hsCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHsCode() {
        return hsCode;
    }

    /**
     * 设置hsCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHsCode(String value) {
        this.hsCode = value;
    }

    /**
     * 获取id属性的值。
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * 获取invoiceCnName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceCnName() {
        return invoiceCnName;
    }

    /**
     * 设置invoiceCnName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceCnName(String value) {
        this.invoiceCnName = value;
    }

    /**
     * 获取invoiceEnName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceEnName() {
        return invoiceEnName;
    }

    /**
     * 设置invoiceEnName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceEnName(String value) {
        this.invoiceEnName = value;
    }

    /**
     * 获取isVolumeRequired属性的值。
     * 
     */
    public boolean isIsVolumeRequired() {
        return isVolumeRequired;
    }

    /**
     * 设置isVolumeRequired属性的值。
     * 
     */
    public void setIsVolumeRequired(boolean value) {
        this.isVolumeRequired = value;
    }

    /**
     * 获取level属性的值。
     * 
     */
    public int getLevel() {
        return level;
    }

    /**
     * 设置level属性的值。
     * 
     */
    public void setLevel(int value) {
        this.level = value;
    }

    /**
     * 获取name属性的值。
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
     * 设置name属性的值。
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
     * 获取packageVolumeRate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPackageVolumeRate() {
        return packageVolumeRate;
    }

    /**
     * 设置packageVolumeRate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPackageVolumeRate(BigDecimal value) {
        this.packageVolumeRate = value;
    }

    /**
     * 获取parentID属性的值。
     * 
     */
    public int getParentID() {
        return parentID;
    }

    /**
     * 设置parentID属性的值。
     * 
     */
    public void setParentID(int value) {
        this.parentID = value;
    }

    /**
     * 获取type属性的值。
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * 设置type属性的值。
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

    /**
     * 获取volumeRate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeRate() {
        return volumeRate;
    }

    /**
     * 设置volumeRate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeRate(BigDecimal value) {
        this.volumeRate = value;
    }

    /**
     * 获取weightRate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWeightRate() {
        return weightRate;
    }

    /**
     * 设置weightRate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWeightRate(BigDecimal value) {
        this.weightRate = value;
    }

}
