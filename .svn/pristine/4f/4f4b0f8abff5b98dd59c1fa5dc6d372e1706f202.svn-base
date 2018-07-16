package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for packageTraceStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="packageTraceStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IN_TRANSIT"/>
 *     &lt;enumeration value="UPPER_WIRE"/>
 *     &lt;enumeration value="DEPARTURE_FROM_PORT"/>
 *     &lt;enumeration value="ARRIVE_AT_THE_DESTINATION_COUNTRIES"/>
 *     &lt;enumeration value="CLEARANCE"/>
 *     &lt;enumeration value="SEND"/>
 *     &lt;enumeration value="NOT_DELIVERY"/>
 *     &lt;enumeration value="SIGN_FOR"/>
 *     &lt;enumeration value="CONFIRM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "packageTraceStatus")
@XmlEnum
public enum PackageTraceStatus {

	IN_TRANSIT, UPPER_WIRE, DEPARTURE_FROM_PORT, ARRIVE_AT_THE_DESTINATION_COUNTRIES, CLEARANCE, SEND, NOT_DELIVERY, SIGN_FOR, CONFIRM;

	public String value() {
		return name();
	}

	public static PackageTraceStatus fromValue(String v) {
		return valueOf(v);
	}

}
