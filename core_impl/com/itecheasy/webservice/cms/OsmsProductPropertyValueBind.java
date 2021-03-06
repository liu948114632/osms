
package com.itecheasy.webservice.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>osmsProductPropertyValueBind complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="osmsProductPropertyValueBind">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="propertyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="propertyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="propertyValue" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="propertyValueName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "osmsProductPropertyValueBind", propOrder = {
    "id",
    "productId",
    "propertyId",
    "propertyName",
    "propertyValue",
    "propertyValueName"
})
public class OsmsProductPropertyValueBind {

    protected int id;
    protected int productId;
    protected int propertyId;
    protected String propertyName;
    protected int propertyValue;
    protected String propertyValueName;

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
     * 获取propertyId属性的值。
     * 
     */
    public int getPropertyId() {
        return propertyId;
    }

    /**
     * 设置propertyId属性的值。
     * 
     */
    public void setPropertyId(int value) {
        this.propertyId = value;
    }

    /**
     * 获取propertyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * 设置propertyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyName(String value) {
        this.propertyName = value;
    }

    /**
     * 获取propertyValue属性的值。
     * 
     */
    public int getPropertyValue() {
        return propertyValue;
    }

    /**
     * 设置propertyValue属性的值。
     * 
     */
    public void setPropertyValue(int value) {
        this.propertyValue = value;
    }

    /**
     * 获取propertyValueName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyValueName() {
        return propertyValueName;
    }

    /**
     * 设置propertyValueName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyValueName(String value) {
        this.propertyValueName = value;
    }

}
