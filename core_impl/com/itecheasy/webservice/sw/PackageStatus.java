package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for packageStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="packageStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IN_PREPARATION"/>
 *     &lt;enumeration value="PREPARATION"/>
 *     &lt;enumeration value="WAIT_DELIVERY"/>
 *     &lt;enumeration value="IN_DELIVERY"/>
 *     &lt;enumeration value="DELIVERY"/>
 *     &lt;enumeration value="ARRIVED"/>
 *     &lt;enumeration value="CANCEL"/>
 *     &lt;enumeration value="TRANSFERED_TO_SHIPPER"/>
 *     &lt;enumeration value="CHECK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "packageStatus")
@XmlEnum
public enum PackageStatus {

	IN_PREPARATION, PREPARATION, WAIT_DELIVERY, IN_DELIVERY, DELIVERY, ARRIVED, CANCEL, TRANSFERED_TO_SHIPPER, CHECK;

	public String value() {
		return name();
	}

	public static PackageStatus fromValue(String v) {
		return valueOf(v);
	}

}
