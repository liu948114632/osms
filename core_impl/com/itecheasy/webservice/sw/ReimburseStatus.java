package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for reimburseStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="reimburseStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOT_REIMBURSE"/>
 *     &lt;enumeration value="IN_REIMBURSING"/>
 *     &lt;enumeration value="REIMBURSE"/>
 *     &lt;enumeration value="NO_REIMBURSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "reimburseStatus")
@XmlEnum
public enum ReimburseStatus {

	NOT_REIMBURSE, IN_REIMBURSING, REIMBURSE, NO_REIMBURSE;

	public String value() {
		return name();
	}

	public static ReimburseStatus fromValue(String v) {
		return valueOf(v);
	}

}
