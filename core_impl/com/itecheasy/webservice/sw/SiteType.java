package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for siteType.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="siteType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="brand"/>
 *     &lt;enumeration value="copy"/>
 *     &lt;enumeration value="copy1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "siteType")
@XmlEnum
public enum SiteType {

	@XmlEnumValue("brand")
	BRAND("brand"), @XmlEnumValue("copy")
	COPY("copy"), @XmlEnumValue("copy1")
	COPY_1("copy1");
	private final String value;

	SiteType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static SiteType fromValue(String v) {
		for (SiteType c : SiteType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
