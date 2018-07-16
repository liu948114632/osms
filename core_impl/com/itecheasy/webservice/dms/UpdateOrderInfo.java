package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for updateOrderInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="updateOrderInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderInfoJson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountSetting" type="{http://out.webservice.dms.itecheasy.com/}accountSetting" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateOrderInfo", propOrder = { "orderInfoJson", "accountSetting" })
public class UpdateOrderInfo {

	protected String orderInfoJson;
	protected AccountSetting accountSetting;

	/**
	 * Gets the value of the orderInfoJson property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderInfoJson() {
		return orderInfoJson;
	}

	/**
	 * Sets the value of the orderInfoJson property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderInfoJson(String value) {
		this.orderInfoJson = value;
	}

	/**
	 * Gets the value of the accountSetting property.
	 * 
	 * @return possible object is {@link AccountSetting }
	 * 
	 */
	public AccountSetting getAccountSetting() {
		return accountSetting;
	}

	/**
	 * Sets the value of the accountSetting property.
	 * 
	 * @param value
	 *            allowed object is {@link AccountSetting }
	 * 
	 */
	public void setAccountSetting(AccountSetting value) {
		this.accountSetting = value;
	}

}
