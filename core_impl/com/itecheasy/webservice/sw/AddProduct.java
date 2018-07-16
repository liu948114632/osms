package com.itecheasy.webservice.sw;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for addProduct complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="addProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderProduct" type="{http://osms.communication.itecheasy.com/}orderProduct" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="packageId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operator" type="{http://osms.communication.itecheasy.com/}operator" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addProduct", propOrder = { "email", "orderProduct", "packageId", "operator" })
public class AddProduct {

	protected String email;
	protected List<OrderProduct> orderProduct;
	protected int packageId;
	protected Operator operator;

	/**
	 * Gets the value of the email property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the value of the email property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 * Gets the value of the orderProduct property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the orderProduct property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrderProduct().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link OrderProduct }
	 * 
	 * 
	 */
	public List<OrderProduct> getOrderProduct() {
		if (orderProduct == null) {
			orderProduct = new ArrayList<OrderProduct>();
		}
		return this.orderProduct;
	}

	/**
	 * Gets the value of the packageId property.
	 * 
	 */
	public int getPackageId() {
		return packageId;
	}

	/**
	 * Sets the value of the packageId property.
	 * 
	 */
	public void setPackageId(int value) {
		this.packageId = value;
	}

	/**
	 * Gets the value of the operator property.
	 * 
	 * @return possible object is {@link Operator }
	 * 
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * Sets the value of the operator property.
	 * 
	 * @param value
	 *            allowed object is {@link Operator }
	 * 
	 */
	public void setOperator(Operator value) {
		this.operator = value;
	}

}
