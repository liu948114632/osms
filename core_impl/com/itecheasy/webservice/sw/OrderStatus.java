package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for orderStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="orderStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNPAID"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="PROCESSING"/>
 *     &lt;enumeration value="ALL_SHIPPING"/>
 *     &lt;enumeration value="PART_SHIPPING"/>
 *     &lt;enumeration value="TRYING_ON"/>
 *     &lt;enumeration value="CANCELLED"/>
 *     &lt;enumeration value="CLOSED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "orderStatus")
@XmlEnum
public enum OrderStatus {

	UNPAID, PENDING, PROCESSING, ALL_SHIPPING, PART_SHIPPING, TRYING_ON, CANCELLED, CLOSED;

	public String value() {
		return name();
	}

	public static OrderStatus fromValue(String v) {
		return valueOf(v);
	}

}
