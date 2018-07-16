package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for receviceOrderQuestionProcessType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="receviceOrderQuestionProcessType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opernatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="account" type="{http://out.webservice.dms.itecheasy.com/}accountSetting" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receviceOrderQuestionProcessType", propOrder = { "orderCode", "opernatorName", "type", "account" })
public class ReceviceOrderQuestionProcessType {

	protected String orderCode;
	protected String opernatorName;
	protected Integer type;
	protected AccountSetting account;

	/**
	 * Gets the value of the orderCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * Sets the value of the orderCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderCode(String value) {
		this.orderCode = value;
	}

	/**
	 * Gets the value of the opernatorName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOpernatorName() {
		return opernatorName;
	}

	/**
	 * Sets the value of the opernatorName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOpernatorName(String value) {
		this.opernatorName = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setType(Integer value) {
		this.type = value;
	}

	/**
	 * Gets the value of the account property.
	 * 
	 * @return possible object is {@link AccountSetting }
	 * 
	 */
	public AccountSetting getAccount() {
		return account;
	}

	/**
	 * Sets the value of the account property.
	 * 
	 * @param value
	 *            allowed object is {@link AccountSetting }
	 * 
	 */
	public void setAccount(AccountSetting value) {
		this.account = value;
	}

}
