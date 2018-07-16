package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for packageTypeInfo.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="packageTypeInfo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ORDINARY"/>
 *     &lt;enumeration value="QUESTION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "packageTypeInfo")
@XmlEnum
public enum PackageTypeInfo {

	ORDINARY, QUESTION;

	public String value() {
		return name();
	}

	public static PackageTypeInfo fromValue(String v) {
		return valueOf(v);
	}

}
