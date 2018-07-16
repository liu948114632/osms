package com.itecheasy.webservice.crm;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ArrayOfFirstWayOrderInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFirstWayOrderInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FirstWayOrderInfo" type="{http://tempuri.org/}FirstWayOrderInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFirstWayOrderInfo", propOrder = { "firstWayOrderInfo" })
public class ArrayOfFirstWayOrderInfo {

	@XmlElement(name = "FirstWayOrderInfo", nillable = true)
	protected List<FirstWayOrderInfo> firstWayOrderInfo;

	/**
	 * Gets the value of the firstWayOrderInfo property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the firstWayOrderInfo property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getFirstWayOrderInfo().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link FirstWayOrderInfo }
	 * 
	 * 
	 */
	public List<FirstWayOrderInfo> getFirstWayOrderInfo() {
		if (firstWayOrderInfo == null) {
			firstWayOrderInfo = new ArrayList<FirstWayOrderInfo>();
		}
		return this.firstWayOrderInfo;
	}

}
