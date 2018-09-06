
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getAmazonReport complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getAmazonReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="api" type="{http://amazon.core.itecheasy.com/}amazonConfigInfo" minOccurs="0"/>
 *         &lt;element name="reportConfig" type="{http://amazon.core.itecheasy.com/}reportConfigVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAmazonReport", propOrder = {
    "api",
    "reportConfig"
})
public class GetAmazonReport {

    protected AmazonConfigInfo api;
    protected ReportConfigVO reportConfig;

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
     * 获取reportConfig属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReportConfigVO }
     *     
     */
    public ReportConfigVO getReportConfig() {
        return reportConfig;
    }

    /**
     * 设置reportConfig属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReportConfigVO }
     *     
     */
    public void setReportConfig(ReportConfigVO value) {
        this.reportConfig = value;
    }

}
