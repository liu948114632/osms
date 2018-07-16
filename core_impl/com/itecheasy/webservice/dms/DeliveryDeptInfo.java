package com.itecheasy.webservice.dms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for deliveryDeptInfo.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="deliveryDeptInfo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DEPT1"/>
 *     &lt;enumeration value="DEPT2"/>
 *     &lt;enumeration value="SHENZHEN"/>
 *     &lt;enumeration value="YIWU"/>
 *     &lt;enumeration value="SHENZHENSW"/>
 *     &lt;enumeration value="DEPT3"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "deliveryDeptInfo")
@XmlEnum
public enum DeliveryDeptInfo {

	@XmlEnumValue("DEPT1")
	DEPT_1("DEPT1"), @XmlEnumValue("DEPT2")
	DEPT_2("DEPT2"), SHENZHEN("SHENZHEN"), YIWU("YIWU"), SHENZHENSW("SHENZHENSW"), @XmlEnumValue("DEPT3")
	DEPT_3("DEPT3");
	private final String value;

	DeliveryDeptInfo(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static DeliveryDeptInfo fromValue(String v) {
		for (DeliveryDeptInfo c : DeliveryDeptInfo.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
