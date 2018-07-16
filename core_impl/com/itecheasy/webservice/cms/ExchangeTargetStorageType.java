
package com.itecheasy.webservice.cms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exchangeTargetStorageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="exchangeTargetStorageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="fba���"/>
 *     &lt;enumeration value="���������"/>
 *     &lt;enumeration value="������"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "exchangeTargetStorageType")
@XmlEnum
public enum ExchangeTargetStorageType {

    @XmlEnumValue("fba\u5e93\u5b58")
    FBA_库存("fba\u5e93\u5b58"),
    自卖单库存("\u81ea\u5356\u5355\u5e93\u5b58"),
    共享库存("\u5171\u4eab\u5e93\u5b58");
    private final String value;

    ExchangeTargetStorageType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExchangeTargetStorageType fromValue(String v) {
        for (ExchangeTargetStorageType c: ExchangeTargetStorageType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
