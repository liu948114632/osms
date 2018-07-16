package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for supplierStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="supplierStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DISABLE"/>
 *     &lt;enumeration value="ENABLE"/>
 *     &lt;enumeration value="DELETED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "supplierStatus")
@XmlEnum
public enum SupplierStatus {

	DISABLE, ENABLE, DELETED;

	public String value() {
		return name();
	}

	public static SupplierStatus fromValue(String v) {
		return valueOf(v);
	}

}
