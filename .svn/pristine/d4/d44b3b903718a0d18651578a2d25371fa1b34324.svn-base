
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for allReportUltimateVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="allReportUltimateVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="api" type="{http://amazon.core.itecheasy.com/}amazonConfigInfo" minOccurs="0"/>
 *         &lt;element name="byteArrayOutputStreamList" type="{http://amazon.core.itecheasy.com/}byteArrayOutputStream" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="json" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="step1VO" type="{http://amazon.core.itecheasy.com/}requestReportVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "allReportUltimateVO", propOrder = {
    "api",
    "byteArrayOutputStreamList",
    "json",
    "shopId",
    "step1VO"
})
public class AllReportUltimateVO {

    protected AmazonConfigInfo api;
    @XmlElement(nillable = true)
    protected List<ByteArrayOutputStream> byteArrayOutputStreamList;
    protected String json;
    protected Integer shopId;
    protected RequestReportVO step1VO;

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

    /**
     * Gets the value of the byteArrayOutputStreamList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the byteArrayOutputStreamList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getByteArrayOutputStreamList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ByteArrayOutputStream }
     * 
     * 
     */
    public List<ByteArrayOutputStream> getByteArrayOutputStreamList() {
        if (byteArrayOutputStreamList == null) {
            byteArrayOutputStreamList = new ArrayList<ByteArrayOutputStream>();
        }
        return this.byteArrayOutputStreamList;
    }

    /**
     * Gets the value of the json property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJson() {
        return json;
    }

    /**
     * Sets the value of the json property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJson(String value) {
        this.json = value;
    }

    /**
     * Gets the value of the shopId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * Sets the value of the shopId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setShopId(Integer value) {
        this.shopId = value;
    }

    /**
     * Gets the value of the step1VO property.
     * 
     * @return
     *     possible object is
     *     {@link RequestReportVO }
     *     
     */
    public RequestReportVO getStep1VO() {
        return step1VO;
    }

    /**
     * Sets the value of the step1VO property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestReportVO }
     *     
     */
    public void setStep1VO(RequestReportVO value) {
        this.step1VO = value;
    }

}
