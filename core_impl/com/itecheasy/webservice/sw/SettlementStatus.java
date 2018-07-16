package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for settlementStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="settlementStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOT_SETTLEMENT"/>
 *     &lt;enumeration value="APPLY_SETTLEMENT"/>
 *     &lt;enumeration value="SETTLEMENT"/>
 *     &lt;enumeration value="WAIT_AGAIN_SETTLEMENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "settlementStatus")
@XmlEnum
public enum SettlementStatus {

	NOT_SETTLEMENT, APPLY_SETTLEMENT, SETTLEMENT, WAIT_AGAIN_SETTLEMENT;

	public String value() {
		return name();
	}

	public static SettlementStatus fromValue(String v) {
		return valueOf(v);
	}

}
