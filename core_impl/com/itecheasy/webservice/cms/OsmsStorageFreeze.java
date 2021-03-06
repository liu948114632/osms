
package com.itecheasy.webservice.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>osmsStorageFreeze complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="osmsStorageFreeze">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="availableQuantity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="realFreezeQuantity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="shouldFreezeQuantity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "osmsStorageFreeze", propOrder = {
    "availableQuantity",
    "productCode",
    "productId",
    "realFreezeQuantity",
    "shouldFreezeQuantity"
})
public class OsmsStorageFreeze {

    protected Double availableQuantity;
    protected String productCode;
    protected int productId;
    protected Double realFreezeQuantity;
    protected Double shouldFreezeQuantity;

    /**
     * 获取availableQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAvailableQuantity() {
        return availableQuantity;
    }

    /**
     * 设置availableQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAvailableQuantity(Double value) {
        this.availableQuantity = value;
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
     * 获取productId属性的值。
     * 
     */
    public int getProductId() {
        return productId;
    }

    /**
     * 设置productId属性的值。
     * 
     */
    public void setProductId(int value) {
        this.productId = value;
    }

    /**
     * 获取realFreezeQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRealFreezeQuantity() {
        return realFreezeQuantity;
    }

    /**
     * 设置realFreezeQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRealFreezeQuantity(Double value) {
        this.realFreezeQuantity = value;
    }

    /**
     * 获取shouldFreezeQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getShouldFreezeQuantity() {
        return shouldFreezeQuantity;
    }

    /**
     * 设置shouldFreezeQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setShouldFreezeQuantity(Double value) {
        this.shouldFreezeQuantity = value;
    }

}
