package com.itecheasy.webservice.oa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="AuthorizationLoginResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "authorizationLoginResult" })
@XmlRootElement(name = "AuthorizationLoginResponse")
public class AuthorizationLoginResponse {

	@XmlElement(name = "AuthorizationLoginResult")
	protected int authorizationLoginResult;

	/**
	 * Gets the value of the authorizationLoginResult property.
	 * 
	 */
	public int getAuthorizationLoginResult() {
		return authorizationLoginResult;
	}

	/**
	 * Sets the value of the authorizationLoginResult property.
	 * 
	 */
	public void setAuthorizationLoginResult(int value) {
		this.authorizationLoginResult = value;
	}

}
