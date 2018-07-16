package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for packageQuestionStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="packageQuestionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOT_PROCESS"/>
 *     &lt;enumeration value="PROCESS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "packageQuestionStatus")
@XmlEnum
public enum PackageQuestionStatus {

	NOT_PROCESS, PROCESS;

	public String value() {
		return name();
	}

	public static PackageQuestionStatus fromValue(String v) {
		return valueOf(v);
	}

}
