package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for vatTypeInfo.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="vatTypeInfo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TAX"/>
 *     &lt;enumeration value="CPF"/>
 *     &lt;enumeration value="VAT"/>
 *     &lt;enumeration value="EORI"/>
 *     &lt;enumeration value="FiscalCode"/>
 *     &lt;enumeration value="IDCardNumber"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "vatTypeInfo")
@XmlEnum
public enum VatTypeInfo {

	TAX("TAX"), CPF("CPF"), VAT("VAT"), EORI("EORI"), @XmlEnumValue("FiscalCode")
	FISCAL_CODE("FiscalCode"), @XmlEnumValue("IDCardNumber")
	ID_CARD_NUMBER("IDCardNumber");
	private final String value;

	VatTypeInfo(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static VatTypeInfo fromValue(String v) {
		for (VatTypeInfo c : VatTypeInfo.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
