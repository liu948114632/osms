package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for language.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="language">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="en"/>
 *     &lt;enumeration value="fr"/>
 *     &lt;enumeration value="de"/>
 *     &lt;enumeration value="ru"/>
 *     &lt;enumeration value="es"/>
 *     &lt;enumeration value="ja"/>
 *     &lt;enumeration value="it"/>
 *     &lt;enumeration value="fr2"/>
 *     &lt;enumeration value="en2"/>
 *     &lt;enumeration value="wap"/>
 *     &lt;enumeration value="wap_fr"/>
 *     &lt;enumeration value="wap_es"/>
 *     &lt;enumeration value="wap_de"/>
 *     &lt;enumeration value="wap_ru"/>
 *     &lt;enumeration value="wap_ja"/>
 *     &lt;enumeration value="wap_it"/>
 *     &lt;enumeration value="ab_wap"/>
 *     &lt;enumeration value="ab_fr"/>
 *     &lt;enumeration value="ab_fr_wap"/>
 *     &lt;enumeration value="tb_en"/>
 *     &lt;enumeration value="tb_wap"/>
 *     &lt;enumeration value="tb_wap_fr"/>
 *     &lt;enumeration value="tb_wap_de"/>
 *     &lt;enumeration value="tb_wap_ru"/>
 *     &lt;enumeration value="tb_wap_it"/>
 *     &lt;enumeration value="tb_wap_ja"/>
 *     &lt;enumeration value="tb_wap_es"/>
 *     &lt;enumeration value="mb_en"/>
 *     &lt;enumeration value="mb_wap"/>
 *     &lt;enumeration value="mb_wap_fr"/>
 *     &lt;enumeration value="mb_wap_de"/>
 *     &lt;enumeration value="mb_wap_ru"/>
 *     &lt;enumeration value="mb_wap_it"/>
 *     &lt;enumeration value="mb_wap_ja"/>
 *     &lt;enumeration value="mb_wap_es"/>
 *     &lt;enumeration value="eb_en"/>
 *     &lt;enumeration value="eb_wap"/>
 *     &lt;enumeration value="eb_wap_fr"/>
 *     &lt;enumeration value="eb_wap_de"/>
 *     &lt;enumeration value="eb_wap_ru"/>
 *     &lt;enumeration value="eb_wap_it"/>
 *     &lt;enumeration value="eb_wap_ja"/>
 *     &lt;enumeration value="eb_wap_es"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "language")
@XmlEnum
public enum Language {

	@XmlEnumValue("en")
	EN("en"), @XmlEnumValue("fr")
	FR("fr"), @XmlEnumValue("de")
	DE("de"), @XmlEnumValue("ru")
	RU("ru"), @XmlEnumValue("es")
	ES("es"), @XmlEnumValue("ja")
	JA("ja"), @XmlEnumValue("it")
	IT("it"), @XmlEnumValue("fr2")
	FR_2("fr2"), @XmlEnumValue("en2")
	EN_2("en2"), @XmlEnumValue("wap")
	WAP("wap"), @XmlEnumValue("wap_fr")
	WAP_FR("wap_fr"), @XmlEnumValue("wap_es")
	WAP_ES("wap_es"), @XmlEnumValue("wap_de")
	WAP_DE("wap_de"), @XmlEnumValue("wap_ru")
	WAP_RU("wap_ru"), @XmlEnumValue("wap_ja")
	WAP_JA("wap_ja"), @XmlEnumValue("wap_it")
	WAP_IT("wap_it"), @XmlEnumValue("ab_wap")
	AB_WAP("ab_wap"), @XmlEnumValue("ab_fr")
	AB_FR("ab_fr"), @XmlEnumValue("ab_fr_wap")
	AB_FR_WAP("ab_fr_wap"), @XmlEnumValue("tb_en")
	TB_EN("tb_en"), @XmlEnumValue("tb_wap")
	TB_WAP("tb_wap"), @XmlEnumValue("tb_wap_fr")
	TB_WAP_FR("tb_wap_fr"), @XmlEnumValue("tb_wap_de")
	TB_WAP_DE("tb_wap_de"), @XmlEnumValue("tb_wap_ru")
	TB_WAP_RU("tb_wap_ru"), @XmlEnumValue("tb_wap_it")
	TB_WAP_IT("tb_wap_it"), @XmlEnumValue("tb_wap_ja")
	TB_WAP_JA("tb_wap_ja"), @XmlEnumValue("tb_wap_es")
	TB_WAP_ES("tb_wap_es"), @XmlEnumValue("mb_en")
	MB_EN("mb_en"), @XmlEnumValue("mb_wap")
	MB_WAP("mb_wap"), @XmlEnumValue("mb_wap_fr")
	MB_WAP_FR("mb_wap_fr"), @XmlEnumValue("mb_wap_de")
	MB_WAP_DE("mb_wap_de"), @XmlEnumValue("mb_wap_ru")
	MB_WAP_RU("mb_wap_ru"), @XmlEnumValue("mb_wap_it")
	MB_WAP_IT("mb_wap_it"), @XmlEnumValue("mb_wap_ja")
	MB_WAP_JA("mb_wap_ja"), @XmlEnumValue("mb_wap_es")
	MB_WAP_ES("mb_wap_es"), @XmlEnumValue("eb_en")
	EB_EN("eb_en"), @XmlEnumValue("eb_wap")
	EB_WAP("eb_wap"), @XmlEnumValue("eb_wap_fr")
	EB_WAP_FR("eb_wap_fr"), @XmlEnumValue("eb_wap_de")
	EB_WAP_DE("eb_wap_de"), @XmlEnumValue("eb_wap_ru")
	EB_WAP_RU("eb_wap_ru"), @XmlEnumValue("eb_wap_it")
	EB_WAP_IT("eb_wap_it"), @XmlEnumValue("eb_wap_ja")
	EB_WAP_JA("eb_wap_ja"), @XmlEnumValue("eb_wap_es")
	EB_WAP_ES("eb_wap_es");
	private final String value;

	Language(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static Language fromValue(String v) {
		for (Language c : Language.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
