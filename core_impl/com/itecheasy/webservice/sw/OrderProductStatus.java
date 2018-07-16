package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for orderProductStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="orderProductStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IN_PREPARATION"/>
 *     &lt;enumeration value="PREPARATION"/>
 *     &lt;enumeration value="IN_DELIVERY"/>
 *     &lt;enumeration value="DELIVERY"/>
 *     &lt;enumeration value="ARRIVED"/>
 *     &lt;enumeration value="CANCEL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "orderProductStatus")
@XmlEnum
public enum OrderProductStatus {

	IN_PREPARATION, PREPARATION, IN_DELIVERY, DELIVERY, ARRIVED, CANCEL;

	public String value() {
		return name();
	}

	public static OrderProductStatus fromValue(String v) {
		return valueOf(v);
	}

}
