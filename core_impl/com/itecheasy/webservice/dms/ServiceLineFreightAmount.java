package com.itecheasy.webservice.dms;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for serviceLineFreightAmount complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="serviceLineFreightAmount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currency" type="{http://out.webservice.dms.itecheasy.com/}currency" minOccurs="0"/>
 *         &lt;element name="electrified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="freightAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="freightForwardingCompanyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remoteAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="rmbAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="serviceLineId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="serviceLineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceLineFreightAmount", propOrder = { "currency", "electrified", "freightAmount",
		"freightForwardingCompanyName", "remark", "remoteAmount", "rmbAmount", "serviceLineId", "serviceLineName" })
public class ServiceLineFreightAmount {

	protected Currency currency;
	protected boolean electrified;
	protected BigDecimal freightAmount;
	protected String freightForwardingCompanyName;
	protected String remark;
	protected BigDecimal remoteAmount;
	protected BigDecimal rmbAmount;
	protected Integer serviceLineId;
	protected String serviceLineName;

	/**
	 * Gets the value of the currency property.
	 * 
	 * @return possible object is {@link Currency }
	 * 
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Sets the value of the currency property.
	 * 
	 * @param value
	 *            allowed object is {@link Currency }
	 * 
	 */
	public void setCurrency(Currency value) {
		this.currency = value;
	}

	/**
	 * Gets the value of the electrified property.
	 * 
	 */
	public boolean isElectrified() {
		return electrified;
	}

	/**
	 * Sets the value of the electrified property.
	 * 
	 */
	public void setElectrified(boolean value) {
		this.electrified = value;
	}

	/**
	 * Gets the value of the freightAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getFreightAmount() {
		return freightAmount;
	}

	/**
	 * Sets the value of the freightAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setFreightAmount(BigDecimal value) {
		this.freightAmount = value;
	}

	/**
	 * Gets the value of the freightForwardingCompanyName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFreightForwardingCompanyName() {
		return freightForwardingCompanyName;
	}

	/**
	 * Sets the value of the freightForwardingCompanyName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFreightForwardingCompanyName(String value) {
		this.freightForwardingCompanyName = value;
	}

	/**
	 * Gets the value of the remark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the value of the remark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRemark(String value) {
		this.remark = value;
	}

	/**
	 * Gets the value of the remoteAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getRemoteAmount() {
		return remoteAmount;
	}

	/**
	 * Sets the value of the remoteAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setRemoteAmount(BigDecimal value) {
		this.remoteAmount = value;
	}

	/**
	 * Gets the value of the rmbAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getRmbAmount() {
		return rmbAmount;
	}

	/**
	 * Sets the value of the rmbAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setRmbAmount(BigDecimal value) {
		this.rmbAmount = value;
	}

	/**
	 * Gets the value of the serviceLineId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getServiceLineId() {
		return serviceLineId;
	}

	/**
	 * Sets the value of the serviceLineId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setServiceLineId(Integer value) {
		this.serviceLineId = value;
	}

	/**
	 * Gets the value of the serviceLineName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getServiceLineName() {
		return serviceLineName;
	}

	/**
	 * Sets the value of the serviceLineName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setServiceLineName(String value) {
		this.serviceLineName = value;
	}

}
