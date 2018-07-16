package com.itecheasy.webservice.dms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getDeliveryShippingMethod complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getDeliveryShippingMethod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://out.webservice.dms.itecheasy.com/}shippingWeight" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg4" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="arg5" type="{http://out.webservice.dms.itecheasy.com/}accountSetting" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDeliveryShippingMethod", propOrder = { "arg0", "arg1", "arg2", "arg3", "arg4", "arg5" })
public class GetDeliveryShippingMethod {

	protected Integer arg0;
	protected List<ShippingWeight> arg1;
	protected String arg2;
	protected String arg3;
	protected Boolean arg4;
	protected AccountSetting arg5;

	/**
	 * Gets the value of the arg0 property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getArg0() {
		return arg0;
	}

	/**
	 * Sets the value of the arg0 property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setArg0(Integer value) {
		this.arg0 = value;
	}

	/**
	 * Gets the value of the arg1 property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the arg1 property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getArg1().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ShippingWeight }
	 * 
	 * 
	 */
	public List<ShippingWeight> getArg1() {
		if (arg1 == null) {
			arg1 = new ArrayList<ShippingWeight>();
		}
		return this.arg1;
	}

	/**
	 * Gets the value of the arg2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArg2() {
		return arg2;
	}

	/**
	 * Sets the value of the arg2 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArg2(String value) {
		this.arg2 = value;
	}

	/**
	 * Gets the value of the arg3 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArg3() {
		return arg3;
	}

	/**
	 * Sets the value of the arg3 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArg3(String value) {
		this.arg3 = value;
	}

	/**
	 * Gets the value of the arg4 property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isArg4() {
		return arg4;
	}

	/**
	 * Sets the value of the arg4 property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setArg4(Boolean value) {
		this.arg4 = value;
	}

	/**
	 * Gets the value of the arg5 property.
	 * 
	 * @return possible object is {@link AccountSetting }
	 * 
	 */
	public AccountSetting getArg5() {
		return arg5;
	}

	/**
	 * Sets the value of the arg5 property.
	 * 
	 * @param value
	 *            allowed object is {@link AccountSetting }
	 * 
	 */
	public void setArg5(AccountSetting value) {
		this.arg5 = value;
	}

}
