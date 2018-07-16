
package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for camsProductPropertyValueBind complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="camsProductPropertyValueBind">
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
@XmlType(name = "camsProductPropertyValueBind", propOrder = {
    "id",
    "productId",
    "propertyId",
    "propertyName",
    "propertyValue",
    "propertyValueName"
})
public class CamsProductPropertyValueBind {

    protected int id;
    protected int productId;
    protected int propertyId;
    protected String propertyName;
    protected int propertyValue;
    protected String propertyValueName;

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
     * Gets the value of the propertyId property.
     * 
     */
    public int getPropertyId() {
        return propertyId;
    }

    /**
     * Sets the value of the propertyId property.
     * 
     */
    public void setPropertyId(int value) {
        this.propertyId = value;
    }

    /**
     * Gets the value of the propertyName property.
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
     * Sets the value of the propertyName property.
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
     * Gets the value of the propertyValue property.
     * 
     */
    public int getPropertyValue() {
        return propertyValue;
    }

    /**
     * Sets the value of the propertyValue property.
     * 
     */
    public void setPropertyValue(int value) {
        this.propertyValue = value;
    }

    /**
     * Gets the value of the propertyValueName property.
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
     * Sets the value of the propertyValueName property.
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
