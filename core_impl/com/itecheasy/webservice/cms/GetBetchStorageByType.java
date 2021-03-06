
package com.itecheasy.webservice.cms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getBetchStorageByType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getBetchStorageByType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productIds" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="storageType" type="{http://osms.communication.itecheasy.com/}storageType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBetchStorageByType", propOrder = {
    "productIds",
    "storageType"
})
public class GetBetchStorageByType {

    @XmlElement(type = Integer.class)
    protected List<Integer> productIds;
    @XmlSchemaType(name = "string")
    protected StorageType storageType;

    /**
     * Gets the value of the productIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getProductIds() {
        if (productIds == null) {
            productIds = new ArrayList<Integer>();
        }
        return this.productIds;
    }

    /**
     * 获取storageType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StorageType }
     *     
     */
    public StorageType getStorageType() {
        return storageType;
    }

    /**
     * 设置storageType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StorageType }
     *     
     */
    public void setStorageType(StorageType value) {
        this.storageType = value;
    }

}
