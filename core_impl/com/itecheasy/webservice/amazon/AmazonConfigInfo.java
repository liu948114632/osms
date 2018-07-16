
package com.itecheasy.webservice.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for amazonConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="amazonConfigInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="APISellerUserToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accessKeyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marketplaceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marketplaceIDSimple" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secretAccessKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sellerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "amazonConfigInfo", propOrder = {
    "apiSellerUserToken",
    "accessKeyId",
    "marketplaceID",
    "marketplaceIDSimple",
    "secretAccessKey",
    "sellerID",
    "serviceURL",
    "tag"
})
public class AmazonConfigInfo {

    @XmlElement(name = "APISellerUserToken")
    protected String apiSellerUserToken;
    protected String accessKeyId;
    protected String marketplaceID;
    protected String marketplaceIDSimple;
    protected String secretAccessKey;
    protected String sellerID;
    protected String serviceURL;
    protected int tag;

    /**
     * Gets the value of the apiSellerUserToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPISellerUserToken() {
        return apiSellerUserToken;
    }

    /**
     * Sets the value of the apiSellerUserToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPISellerUserToken(String value) {
        this.apiSellerUserToken = value;
    }

    /**
     * Gets the value of the accessKeyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessKeyId() {
        return accessKeyId;
    }

    /**
     * Sets the value of the accessKeyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessKeyId(String value) {
        this.accessKeyId = value;
    }

    /**
     * Gets the value of the marketplaceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketplaceID() {
        return marketplaceID;
    }

    /**
     * Sets the value of the marketplaceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketplaceID(String value) {
        this.marketplaceID = value;
    }

    /**
     * Gets the value of the marketplaceIDSimple property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketplaceIDSimple() {
        return marketplaceIDSimple;
    }

    /**
     * Sets the value of the marketplaceIDSimple property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketplaceIDSimple(String value) {
        this.marketplaceIDSimple = value;
    }

    /**
     * Gets the value of the secretAccessKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    /**
     * Sets the value of the secretAccessKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecretAccessKey(String value) {
        this.secretAccessKey = value;
    }

    /**
     * Gets the value of the sellerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerID() {
        return sellerID;
    }

    /**
     * Sets the value of the sellerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerID(String value) {
        this.sellerID = value;
    }

    /**
     * Gets the value of the serviceURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceURL() {
        return serviceURL;
    }

    /**
     * Sets the value of the serviceURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceURL(String value) {
        this.serviceURL = value;
    }

    /**
     * Gets the value of the tag property.
     * 
     */
    public int getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     */
    public void setTag(int value) {
        this.tag = value;
    }

}
