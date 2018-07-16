package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for purchaseProductStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="purchaseProductStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PROCESS"/>
 *     &lt;enumeration value="ENTERING_WAREHOUSE"/>
 *     &lt;enumeration value="CANCEL"/>
 *     &lt;enumeration value="STOP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "purchaseProductStatus")
@XmlEnum
public enum PurchaseProductStatus {

	PROCESS, ENTERING_WAREHOUSE, CANCEL, STOP;

	public String value() {
		return name();
	}

	public static PurchaseProductStatus fromValue(String v) {
		return valueOf(v);
	}

}
