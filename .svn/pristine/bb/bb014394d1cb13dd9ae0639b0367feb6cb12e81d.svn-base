package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for buyerStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="buyerStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Normal"/>
 *     &lt;enumeration value="Validation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "buyerStatus")
@XmlEnum
public enum BuyerStatus {

	@XmlEnumValue("Normal")
	NORMAL("Normal"), @XmlEnumValue("Validation")
	VALIDATION("Validation");
	private final String value;

	BuyerStatus(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static BuyerStatus fromValue(String v) {
		for (BuyerStatus c : BuyerStatus.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
