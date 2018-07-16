package com.itecheasy.webservice.cms.order;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for addOrder complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="addOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg1" type="{http://osms.communication.itecheasy.com/}order" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://osms.communication.itecheasy.com/}orderItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="arg3" type="{http://osms.communication.itecheasy.com/}orderShippingAddress" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addOrder", propOrder = { "arg0", "arg1", "arg2", "arg3" })
public class AddOrder {

	protected int arg0;
	protected Order arg1;
	protected List<OrderItem> arg2;
	protected OrderShippingAddress arg3;

	/**
	 * Gets the value of the arg0 property.
	 * 
	 */
	public int getArg0() {
		return arg0;
	}

	/**
	 * Sets the value of the arg0 property.
	 * 
	 */
	public void setArg0(int value) {
		this.arg0 = value;
	}

	/**
	 * Gets the value of the arg1 property.
	 * 
	 * @return possible object is {@link Order }
	 * 
	 */
	public Order getArg1() {
		return arg1;
	}

	/**
	 * Sets the value of the arg1 property.
	 * 
	 * @param value
	 *            allowed object is {@link Order }
	 * 
	 */
	public void setArg1(Order value) {
		this.arg1 = value;
	}

	/**
	 * Gets the value of the arg2 property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the arg2 property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getArg2().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link OrderItem }
	 * 
	 * 
	 */
	public List<OrderItem> getArg2() {
		if (arg2 == null) {
			arg2 = new ArrayList<OrderItem>();
		}
		return this.arg2;
	}

	/**
	 * Gets the value of the arg3 property.
	 * 
	 * @return possible object is {@link OrderShippingAddress }
	 * 
	 */
	public OrderShippingAddress getArg3() {
		return arg3;
	}

	/**
	 * Sets the value of the arg3 property.
	 * 
	 * @param value
	 *            allowed object is {@link OrderShippingAddress }
	 * 
	 */
	public void setArg3(OrderShippingAddress value) {
		this.arg3 = value;
	}

}
