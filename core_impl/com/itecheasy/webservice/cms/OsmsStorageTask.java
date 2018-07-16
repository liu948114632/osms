
package com.itecheasy.webservice.cms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for osmsStorageTask.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="osmsStorageTask">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WHFBA����ֲ���"/>
 *     &lt;enumeration value="WH������������"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "osmsStorageTask")
@XmlEnum
public enum OsmsStorageTask {

    @XmlEnumValue("WHFBA\u6d77\u5916\u4ed3\u8865\u8d27")
    WHFBA_海外仓补货("WHFBA\u6d77\u5916\u4ed3\u8865\u8d27"),
    @XmlEnumValue("WH\u81ea\u5356\u8ba2\u5355\u8865\u8d27")
    WH_自卖订单补货("WH\u81ea\u5356\u8ba2\u5355\u8865\u8d27");
    private final String value;

    OsmsStorageTask(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OsmsStorageTask fromValue(String v) {
        for (OsmsStorageTask c: OsmsStorageTask.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}