package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getOrderModifyRecordOperatorLogsById complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getOrderModifyRecordOperatorLogsById">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maxId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOrderModifyRecordOperatorLogsById", propOrder = { "maxId" })
public class GetOrderModifyRecordOperatorLogsById {

	protected int maxId;

	/**
	 * Gets the value of the maxId property.
	 * 
	 */
	public int getMaxId() {
		return maxId;
	}

	/**
	 * Sets the value of the maxId property.
	 * 
	 */
	public void setMaxId(int value) {
		this.maxId = value;
	}

}
