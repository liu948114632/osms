
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>updateInboundShipment complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="updateInboundShipment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="api" type="{http://amazon.core.itecheasy.com/}amazonConfigInfo" minOccurs="0"/>
 *         &lt;element name="inboundShipmentVO" type="{http://amazon.core.itecheasy.com/}inboundShipmentVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateInboundShipment", propOrder = {
    "api",
    "inboundShipmentVO"
})
public class UpdateInboundShipment {

    protected AmazonConfigInfo api;
    protected InboundShipmentVO inboundShipmentVO;

    /**
     * 获取api属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AmazonConfigInfo }
     *     
     */
    public AmazonConfigInfo getApi() {
        return api;
    }

    /**
     * 设置api属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmazonConfigInfo }
     *     
     */
    public void setApi(AmazonConfigInfo value) {
        this.api = value;
    }

    /**
     * 获取inboundShipmentVO属性的值。
     * 
     * @return
     *     possible object is
     *     {@link InboundShipmentVO }
     *     
     */
    public InboundShipmentVO getInboundShipmentVO() {
        return inboundShipmentVO;
    }

    /**
     * 设置inboundShipmentVO属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link InboundShipmentVO }
     *     
     */
    public void setInboundShipmentVO(InboundShipmentVO value) {
        this.inboundShipmentVO = value;
    }

}
