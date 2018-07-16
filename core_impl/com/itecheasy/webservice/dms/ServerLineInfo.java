package com.itecheasy.webservice.dms;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for serverLineInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="serverLineInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bigFreight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="bigFreightForwardingCompanyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bigServerLineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bigWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="freight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="freightForwardingCompanyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serverLineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serverLineInfo", propOrder = { "bigFreight", "bigFreightForwardingCompanyName", "bigServerLineName",
		"bigWeight", "freight", "freightForwardingCompanyName", "serverLineName" })
public class ServerLineInfo {

	protected BigDecimal bigFreight;
	protected String bigFreightForwardingCompanyName;
	protected String bigServerLineName;
	protected BigDecimal bigWeight;
	protected BigDecimal freight;
	protected String freightForwardingCompanyName;
	protected String serverLineName;

	/**
	 * Gets the value of the bigFreight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getBigFreight() {
		return bigFreight;
	}

	/**
	 * Sets the value of the bigFreight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setBigFreight(BigDecimal value) {
		this.bigFreight = value;
	}

	/**
	 * Gets the value of the bigFreightForwardingCompanyName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBigFreightForwardingCompanyName() {
		return bigFreightForwardingCompanyName;
	}

	/**
	 * Sets the value of the bigFreightForwardingCompanyName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBigFreightForwardingCompanyName(String value) {
		this.bigFreightForwardingCompanyName = value;
	}

	/**
	 * Gets the value of the bigServerLineName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBigServerLineName() {
		return bigServerLineName;
	}

	/**
	 * Sets the value of the bigServerLineName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBigServerLineName(String value) {
		this.bigServerLineName = value;
	}

	/**
	 * Gets the value of the bigWeight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getBigWeight() {
		return bigWeight;
	}

	/**
	 * Sets the value of the bigWeight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setBigWeight(BigDecimal value) {
		this.bigWeight = value;
	}

	/**
	 * Gets the value of the freight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getFreight() {
		return freight;
	}

	/**
	 * Sets the value of the freight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setFreight(BigDecimal value) {
		this.freight = value;
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
	 * Gets the value of the serverLineName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getServerLineName() {
		return serverLineName;
	}

	/**
	 * Sets the value of the serverLineName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setServerLineName(String value) {
		this.serverLineName = value;
	}

}
