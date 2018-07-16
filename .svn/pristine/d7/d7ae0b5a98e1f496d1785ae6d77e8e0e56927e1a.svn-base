package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for reminderStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="reminderStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOT_REMINDER"/>
 *     &lt;enumeration value="FIRST"/>
 *     &lt;enumeration value="SECOND"/>
 *     &lt;enumeration value="THIRD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "reminderStatus")
@XmlEnum
public enum ReminderStatus {

	NOT_REMINDER, FIRST, SECOND, THIRD;

	public String value() {
		return name();
	}

	public static ReminderStatus fromValue(String v) {
		return valueOf(v);
	}

}
