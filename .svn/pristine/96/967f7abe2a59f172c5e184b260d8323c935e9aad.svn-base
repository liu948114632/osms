package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for purchaseOrderStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="purchaseOrderStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WAIT_SUBMIT"/>
 *     &lt;enumeration value="SUBMIT"/>
 *     &lt;enumeration value="NOT_PASS"/>
 *     &lt;enumeration value="CONFIRM"/>
 *     &lt;enumeration value="REPEAL"/>
 *     &lt;enumeration value="REPEAL_SUBMIT"/>
 *     &lt;enumeration value="REPEAL_NOT_PASS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "purchaseOrderStatus")
@XmlEnum
public enum PurchaseOrderStatus {

	WAIT_SUBMIT, SUBMIT, NOT_PASS, CONFIRM, REPEAL, REPEAL_SUBMIT, REPEAL_NOT_PASS;

	public String value() {
		return name();
	}

	public static PurchaseOrderStatus fromValue(String v) {
		return valueOf(v);
	}

}
