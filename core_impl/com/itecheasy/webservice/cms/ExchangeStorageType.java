
package com.itecheasy.webservice.cms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>exchangeStorageType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="exchangeStorageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="fba库存"/>
 *     &lt;enumeration value="自卖单库存"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "exchangeStorageType")
@XmlEnum
public enum ExchangeStorageType {

    @XmlEnumValue("fba\u5e93\u5b58")
    FBA_库存("fba\u5e93\u5b58"),
    自卖单库存("\u81ea\u5356\u5355\u5e93\u5b58");
    private final String value;

    ExchangeStorageType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExchangeStorageType fromValue(String v) {
        for (ExchangeStorageType c: ExchangeStorageType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
