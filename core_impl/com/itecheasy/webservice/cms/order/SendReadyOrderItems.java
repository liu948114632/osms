package com.itecheasy.webservice.cms.order;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for sendReadyOrderItems complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="sendReadyOrderItems">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg3" type="{http://osms.communication.itecheasy.com/}orderItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="arg4" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="arg5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendReadyOrderItems", propOrder = { "arg0", "arg1", "arg2", "arg3", "arg4", "arg5" })
public class SendReadyOrderItems {

	protected String arg0;
	protected int arg1;
	protected int arg2;
	protected List<OrderItem> arg3;
	@XmlElement(type = Integer.class)
	protected List<Integer> arg4;
	protected String arg5;

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
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the arg3 property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getArg3().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link OrderItem }
	 * 
	 * 
	 */
	public List<OrderItem> getArg3() {
		if (arg3 == null) {
			arg3 = new ArrayList<OrderItem>();
		}
		return this.arg3;
	}

	/**
	 * Gets the value of the arg4 property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the arg4 property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getArg4().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Integer }
	 * 
	 * 
	 */
	public List<Integer> getArg4() {
		if (arg4 == null) {
			arg4 = new ArrayList<Integer>();
		}
		return this.arg4;
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

}
