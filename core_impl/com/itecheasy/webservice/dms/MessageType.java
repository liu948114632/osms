package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for messageType.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="messageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DELIVERY"/>
 *     &lt;enumeration value="TRACE_CODE"/>
 *     &lt;enumeration value="FREIGHT"/>
 *     &lt;enumeration value="TRACE_STATUS"/>
 *     &lt;enumeration value="SHIPPING_METHOD"/>
 *     &lt;enumeration value="SERVICE_CUSTOMER"/>
 *     &lt;enumeration value="CREATE_QUESTION"/>
 *     &lt;enumeration value="SEND_QUESTION"/>
 *     &lt;enumeration value="CLOSE_QUESTION"/>
 *     &lt;enumeration value="REOPEN"/>
 *     &lt;enumeration value="BACKORDETAIN"/>
 *     &lt;enumeration value="FREESHIPPING"/>
 *     &lt;enumeration value="ISNOTDELIVERED"/>
 *     &lt;enumeration value="BACKDELIVERYPROCESS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "messageType")
@XmlEnum
public enum MessageType {

	DELIVERY, TRACE_CODE, FREIGHT, TRACE_STATUS, SHIPPING_METHOD, SERVICE_CUSTOMER, CREATE_QUESTION, SEND_QUESTION, CLOSE_QUESTION, REOPEN, BACKORDETAIN, FREESHIPPING, ISNOTDELIVERED, BACKDELIVERYPROCESS;

	public String value() {
		return name();
	}

	public static MessageType fromValue(String v) {
		return valueOf(v);
	}

}
