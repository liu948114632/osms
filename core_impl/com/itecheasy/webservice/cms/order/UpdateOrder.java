package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for updateOrder complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="updateOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg3" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="arg4" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg6" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="arg7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg10" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="arg11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateOrder", propOrder = { "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "arg6", "arg7", "arg8",
		"arg9", "arg10", "arg11" })
public class UpdateOrder {

	protected String arg0;
	protected int arg1;
	protected int arg2;
	protected boolean arg3;
	protected int arg4;
	protected String arg5;
	protected boolean arg6;
	protected String arg7;
	protected String arg8;
	protected String arg9;
	protected Boolean arg10;
	protected String arg11;

	/**
	 * Gets the value of the arg0 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArg0() {
		return arg0;
	}

	/**
	 * Sets the value of the arg0 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArg0(String value) {
		this.arg0 = value;
	}

	/**
	 * Gets the value of the arg1 property.
	 * 
	 */
	public int getArg1() {
		return arg1;
	}

	/**
	 * Sets the value of the arg1 property.
	 * 
	 */
	public void setArg1(int value) {
		this.arg1 = value;
	}

	/**
	 * Gets the value of the arg2 property.
	 * 
	 */
	public int getArg2() {
		return arg2;
	}

	/**
	 * Sets the value of the arg2 property.
	 * 
	 */
	public void setArg2(int value) {
		this.arg2 = value;
	}

	/**
	 * Gets the value of the arg3 property.
	 * 
	 */
	public boolean isArg3() {
		return arg3;
	}

	/**
	 * Sets the value of the arg3 property.
	 * 
	 */
	public void setArg3(boolean value) {
		this.arg3 = value;
	}

	/**
	 * Gets the value of the arg4 property.
	 * 
	 */
	public int getArg4() {
		return arg4;
	}

	/**
	 * Sets the value of the arg4 property.
	 * 
	 */
	public void setArg4(int value) {
		this.arg4 = value;
	}

	/**
	 * Gets the value of the arg5 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArg5() {
		return arg5;
	}

	/**
	 * Sets the value of the arg5 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArg5(String value) {
		this.arg5 = value;
	}

	/**
	 * Gets the value of the arg6 property.
	 * 
	 */
	public boolean isArg6() {
		return arg6;
	}

	/**
	 * Sets the value of the arg6 property.
	 * 
	 */
	public void setArg6(boolean value) {
		this.arg6 = value;
	}

	/**
	 * Gets the value of the arg7 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArg7() {
		return arg7;
	}

	/**
	 * Sets the value of the arg7 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArg7(String value) {
		this.arg7 = value;
	}

	/**
	 * Gets the value of the arg8 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArg8() {
		return arg8;
	}

	/**
	 * Sets the value of the arg8 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArg8(String value) {
		this.arg8 = value;
	}

	/**
	 * Gets the value of the arg9 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArg9() {
		return arg9;
	}

	/**
	 * Sets the value of the arg9 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArg9(String value) {
		this.arg9 = value;
	}

	/**
	 * Gets the value of the arg10 property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isArg10() {
		return arg10;
	}

	/**
	 * Sets the value of the arg10 property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setArg10(Boolean value) {
		this.arg10 = value;
	}

	/**
	 * Gets the value of the arg11 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArg11() {
		return arg11;
	}

	/**
	 * Sets the value of the arg11 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArg11(String value) {
		this.arg11 = value;
	}

}
