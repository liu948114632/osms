package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for userStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="userStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DISABLE"/>
 *     &lt;enumeration value="ENABLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "userStatus")
@XmlEnum
public enum UserStatus {

	DISABLE, ENABLE;

	public String value() {
		return name();
	}

	public static UserStatus fromValue(String v) {
		return valueOf(v);
	}

}
