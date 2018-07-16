package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for notificationType.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="notificationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ORDER_STATUS_CHANGE"/>
 *     &lt;enumeration value="ORDER_ITEM_STATUS_CHANGE"/>
 *     &lt;enumeration value="ORDER_PACKAGE_OUT"/>
 *     &lt;enumeration value="ORDER_ITEM_PREPARED"/>
 *     &lt;enumeration value="ORDER_DELIVERY"/>
 *     &lt;enumeration value="ORDER_PACKAGE_DELIVERY"/>
 *     &lt;enumeration value="UPDATE_TRACE_CODE"/>
 *     &lt;enumeration value="DELIVERY_PACKAGE_TRACE_STATUS"/>
 *     &lt;enumeration value="SERVICE_CUSTOMER"/>
 *     &lt;enumeration value="FREIGHT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "notificationType")
@XmlEnum
public enum NotificationType {

	ORDER_STATUS_CHANGE, ORDER_ITEM_STATUS_CHANGE, ORDER_PACKAGE_OUT, ORDER_ITEM_PREPARED, ORDER_DELIVERY, ORDER_PACKAGE_DELIVERY, UPDATE_TRACE_CODE, DELIVERY_PACKAGE_TRACE_STATUS, SERVICE_CUSTOMER, FREIGHT;

	public String value() {
		return name();
	}

	public static NotificationType fromValue(String v) {
		return valueOf(v);
	}

}
