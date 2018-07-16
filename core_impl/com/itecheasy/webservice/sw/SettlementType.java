package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for settlementType.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="settlementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PAY_AND_DELIVERY"/>
 *     &lt;enumeration value="GOOD_AND_PAY"/>
 *     &lt;enumeration value="PREPAYMENT"/>
 *     &lt;enumeration value="GUARANTEE"/>
 *     &lt;enumeration value="CYCLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "settlementType")
@XmlEnum
public enum SettlementType {

	PAY_AND_DELIVERY, GOOD_AND_PAY, PREPAYMENT, GUARANTEE, CYCLE;

	public String value() {
		return name();
	}

	public static SettlementType fromValue(String v) {
		return valueOf(v);
	}

}
