package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for packageDMSQuestionStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="packageDMSQuestionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PROCESSING"/>
 *     &lt;enumeration value="CLOSED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "packageDMSQuestionStatus")
@XmlEnum
public enum PackageDMSQuestionStatus {

	PROCESSING, CLOSED;

	public String value() {
		return name();
	}

	public static PackageDMSQuestionStatus fromValue(String v) {
		return valueOf(v);
	}

}
