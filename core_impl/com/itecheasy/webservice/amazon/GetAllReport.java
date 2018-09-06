
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getAllReport complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getAllReport">
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
@XmlType(name = "getAllReport", propOrder = {
    "requestReportVO",
    "api"
})
public class GetAllReport {

    protected RequestReportVO requestReportVO;
    protected AmazonConfigInfo api;

    /**
     * 获取requestReportVO属性的值。
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
     * 设置requestReportVO属性的值。
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

}
