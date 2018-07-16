package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for updateOrderDeliveryInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="updateOrderDeliveryInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "updateOrderDeliveryInfo", propOrder = { "orderCode", "deliveryFlag", "operator", "accountSetting" })
public class UpdateOrderDeliveryInfo {

	protected String orderCode;
	protected boolean deliveryFlag;
	protected String operator;
	protected AccountSetting accountSetting;

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
	 * Gets the value of the deliveryFlag property.
	 * 
	 */
	public boolean isDeliveryFlag() {
		return deliveryFlag;
	}

	/**
	 * Sets the value of the deliveryFlag property.
	 * 
	 */
	public void setDeliveryFlag(boolean value) {
		this.deliveryFlag = value;
	}

	/**
	 * Gets the value of the operator property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * Sets the value of the operator property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOperator(String value) {
		this.operator = value;
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
