
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>inboundItemVO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="inboundItemVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sellerSKU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inboundItemVO", propOrder = {
    "quantity",
    "sellerSKU"
})
public class InboundItemVO {

    protected int quantity;
    protected String sellerSKU;

    /**
     * 获取quantity属性的值。
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * 设置quantity属性的值。
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * 获取sellerSKU属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerSKU() {
        return sellerSKU;
    }

    /**
     * 设置sellerSKU属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerSKU(String value) {
        this.sellerSKU = value;
    }

}
