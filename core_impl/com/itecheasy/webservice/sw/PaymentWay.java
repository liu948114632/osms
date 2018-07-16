package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for paymentWay.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="paymentWay">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PAYPAL"/>
 *     &lt;enumeration value="BANK_TRANSFER"/>
 *     &lt;enumeration value="WESTERN_UNION"/>
 *     &lt;enumeration value="PAY_IT_LATER"/>
 *     &lt;enumeration value="CASH_ACCOUNT"/>
 *     &lt;enumeration value="POINT_ACCOUNT"/>
 *     &lt;enumeration value="CREDIT_OR_DEBIT_CARD"/>
 *     &lt;enumeration value="GLOBE_BILL"/>
 *     &lt;enumeration value="POLI"/>
 *     &lt;enumeration value="SAFETYPAY"/>
 *     &lt;enumeration value="SOFORTBANKING"/>
 *     &lt;enumeration value="TELEINGRESO"/>
 *     &lt;enumeration value="FHTPAY_GLOBE_BILL"/>
 *     &lt;enumeration value="ASIA_GLOBE_BILL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "paymentWay")
@XmlEnum
public enum PaymentWay {

	PAYPAL, BANK_TRANSFER, WESTERN_UNION, PAY_IT_LATER, CASH_ACCOUNT, POINT_ACCOUNT, CREDIT_OR_DEBIT_CARD, GLOBE_BILL, POLI, SAFETYPAY, SOFORTBANKING, TELEINGRESO, FHTPAY_GLOBE_BILL, ASIA_GLOBE_BILL;

	public String value() {
		return name();
	}

	public static PaymentWay fromValue(String v) {
		return valueOf(v);
	}

}
