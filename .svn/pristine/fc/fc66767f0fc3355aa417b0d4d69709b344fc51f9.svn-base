package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for orderSourcePlatform.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="orderSourcePlatform">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PH"/>
 *     &lt;enumeration value="FBA"/>
 *     &lt;enumeration value="DM"/>
 *     &lt;enumeration value="Nbeads"/>
 *     &lt;enumeration value="Ebay"/>
 *     &lt;enumeration value="SMT"/>
 *     &lt;enumeration value="AM"/>
 *     &lt;enumeration value="WH_AM"/>
 *     &lt;enumeration value="WH_EBAY"/>
 *     &lt;enumeration value="WH_SMT"/>
 *     &lt;enumeration value="WH_FBA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "orderSourcePlatform")
@XmlEnum
public enum OrderSourcePlatform {

	PH("PH"), FBA("FBA"), DM("DM"), @XmlEnumValue("Nbeads")
	NBEADS("Nbeads"), @XmlEnumValue("Ebay")
	EBAY("Ebay"), SMT("SMT"), AM("AM"), WH_AM("WH_AM"), WH_EBAY("WH_EBAY"), WH_SMT("WH_SMT"), WH_FBA("WH_FBA");
	private final String value;

	OrderSourcePlatform(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static OrderSourcePlatform fromValue(String v) {
		for (OrderSourcePlatform c : OrderSourcePlatform.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
