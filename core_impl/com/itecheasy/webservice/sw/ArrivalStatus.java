package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for arrivalStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="arrivalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOT_ARRIVAL"/>
 *     &lt;enumeration value="PART_ARRIVAL"/>
 *     &lt;enumeration value="ALL_ARRIVAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "arrivalStatus")
@XmlEnum
public enum ArrivalStatus {

	NOT_ARRIVAL, PART_ARRIVAL, ALL_ARRIVAL;

	public String value() {
		return name();
	}

	public static ArrivalStatus fromValue(String v) {
		return valueOf(v);
	}

}
