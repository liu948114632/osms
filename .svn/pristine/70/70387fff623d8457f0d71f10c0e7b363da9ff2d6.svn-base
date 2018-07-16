package com.itecheasy.webservice.dms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for cancelMerge complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="cancelMerge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountSetting" type="{http://out.webservice.dms.itecheasy.com/}accountSetting" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelMerge", propOrder = { "codes", "operator", "accountSetting" })
public class CancelMerge {

	protected List<String> codes;
	protected String operator;
	protected AccountSetting accountSetting;

	/**
	 * Gets the value of the codes property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the codes property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCodes().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getCodes() {
		if (codes == null) {
			codes = new ArrayList<String>();
		}
		return this.codes;
	}

	/**
	 * Gets the value of the operator property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * Sets the value of the operator property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOperator(String value) {
		this.operator = value;
	}

	/**
	 * Gets the value of the accountSetting property.
	 * 
	 * @return possible object is {@link AccountSetting }
	 * 
	 */
	public AccountSetting getAccountSetting() {
		return accountSetting;
	}

	/**
	 * Sets the value of the accountSetting property.
	 * 
	 * @param value
	 *            allowed object is {@link AccountSetting }
	 * 
	 */
	public void setAccountSetting(AccountSetting value) {
		this.accountSetting = value;
	}

}
