package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for paymentStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="paymentStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOT_PAYMENT"/>
 *     &lt;enumeration value="PART_PAYMENT"/>
 *     &lt;enumeration value="ALL_PAYMENT"/>
 *     &lt;enumeration value="NEED_NOT_PAYMENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "paymentStatus")
@XmlEnum
public enum PaymentStatus {

	NOT_PAYMENT, PART_PAYMENT, ALL_PAYMENT, NEED_NOT_PAYMENT;

	public String value() {
		return name();
	}

	public static PaymentStatus fromValue(String v) {
		return valueOf(v);
	}

}
