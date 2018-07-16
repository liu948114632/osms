package com.itecheasy.webservice.crm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cmsProductIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newCountryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="newDeliveryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="outputMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "cmsProductIds", "newCountryId", "newDeliveryId", "outputMsg" })
@XmlRootElement(name = "IsOrderLimitModifyByProductId")
public class IsOrderLimitModifyByProductId {

	protected String cmsProductIds;
	protected int newCountryId;
	protected int newDeliveryId;
	protected String outputMsg;

	/**
	 * Gets the value of the cmsProductIds property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCmsProductIds() {
		return cmsProductIds;
	}

	/**
	 * Sets the value of the cmsProductIds property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCmsProductIds(String value) {
		this.cmsProductIds = value;
	}

	/**
	 * Gets the value of the newCountryId property.
	 * 
	 */
	public int getNewCountryId() {
		return newCountryId;
	}

	/**
	 * Sets the value of the newCountryId property.
	 * 
	 */
	public void setNewCountryId(int value) {
		this.newCountryId = value;
	}

	/**
	 * Gets the value of the newDeliveryId property.
	 * 
	 */
	public int getNewDeliveryId() {
		return newDeliveryId;
	}

	/**
	 * Sets the value of the newDeliveryId property.
	 * 
	 */
	public void setNewDeliveryId(int value) {
		this.newDeliveryId = value;
	}

	/**
	 * Gets the value of the outputMsg property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOutputMsg() {
		return outputMsg;
	}

	/**
	 * Sets the value of the outputMsg property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOutputMsg(String value) {
		this.outputMsg = value;
	}

}
