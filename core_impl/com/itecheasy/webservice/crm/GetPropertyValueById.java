
package com.itecheasy.webservice.crm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getPropertyValueById complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getPropertyValueById">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="propertyValueId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPropertyValueById", propOrder = {
    "propertyValueId"
})
public class GetPropertyValueById {

    protected int propertyValueId;

    /**
     * Gets the value of the propertyValueId property.
     * 
     */
    public int getPropertyValueId() {
        return propertyValueId;
    }

    /**
     * Sets the value of the propertyValueId property.
     * 
     */
    public void setPropertyValueId(int value) {
        this.propertyValueId = value;
    }

}
