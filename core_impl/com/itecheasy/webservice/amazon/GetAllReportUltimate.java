
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAllReportUltimate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllReportUltimate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestReportVO" type="{http://amazon.core.itecheasy.com/}requestReportVO" minOccurs="0"/>
 *         &lt;element name="api" type="{http://amazon.core.itecheasy.com/}amazonConfigInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllReportUltimate", propOrder = {
    "requestReportVO",
    "api"
})
public class GetAllReportUltimate {

    protected RequestReportVO requestReportVO;
    protected AmazonConfigInfo api;

    /**
     * Gets the value of the requestReportVO property.
     * 
     * @return
     *     possible object is
     *     {@link RequestReportVO }
     *     
     */
    public RequestReportVO getRequestReportVO() {
        return requestReportVO;
    }

    /**
     * Sets the value of the requestReportVO property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestReportVO }
     *     
     */
    public void setRequestReportVO(RequestReportVO value) {
        this.requestReportVO = value;
    }

    /**
     * Gets the value of the api property.
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
     * Sets the value of the api property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmazonConfigInfo }
     *     
     */
    public void setApi(AmazonConfigInfo value) {
        this.api = value;
    }

}
