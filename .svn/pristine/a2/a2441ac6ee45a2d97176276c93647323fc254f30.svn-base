package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for promotionWay.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="promotionWay">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="amount"/>
 *     &lt;enumeration value="percent"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "promotionWay")
@XmlEnum
public enum PromotionWay {

	@XmlEnumValue("amount")
	AMOUNT("amount"), @XmlEnumValue("percent")
	PERCENT("percent");
	private final String value;

	PromotionWay(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static PromotionWay fromValue(String v) {
		for (PromotionWay c : PromotionWay.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
