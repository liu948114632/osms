package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for packageType.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="packageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ORDINARY"/>
 *     &lt;enumeration value="QUESTION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "packageType")
@XmlEnum
public enum PackageType {

	ORDINARY, QUESTION;

	public String value() {
		return name();
	}

	public static PackageType fromValue(String v) {
		return valueOf(v);
	}

}
