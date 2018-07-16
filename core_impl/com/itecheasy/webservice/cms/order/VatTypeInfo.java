package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlEnum;
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
 *     &lt;enumeration value="FISCAL_CODE"/>
 *     &lt;enumeration value="ID_CARD_NUMBER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "vatTypeInfo")
@XmlEnum
public enum VatTypeInfo {

	TAX, CPF, VAT, EORI, FISCAL_CODE, ID_CARD_NUMBER;

	public String value() {
		return name();
	}

	public static VatTypeInfo fromValue(String v) {
		return valueOf(v);
	}

}
