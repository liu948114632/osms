
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>listInboundShipmentsResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="listInboundShipmentsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://amazon.core.itecheasy.com/}listInboundShipmentsResultVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listInboundShipmentsResponse", propOrder = {
    "_return"
})
public class ListInboundShipmentsResponse {

    @XmlElement(name = "return")
    protected ListInboundShipmentsResultVO _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ListInboundShipmentsResultVO }
     *     
     */
    public ListInboundShipmentsResultVO getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ListInboundShipmentsResultVO }
     *     
     */
    public void setReturn(ListInboundShipmentsResultVO value) {
        this._return = value;
    }

}
