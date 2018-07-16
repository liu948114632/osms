package com.itecheasy.webservice.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for reAssignaddTask complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="reAssignaddTask">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operater" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reAssignaddTask", propOrder = { "taskId", "qty", "remark", "operater" })
public class ReAssignaddTask {

	protected int taskId;
	protected int qty;
	protected String remark;
	protected String operater;

	/**
	 * Gets the value of the taskId property.
	 * 
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * Sets the value of the taskId property.
	 * 
	 */
	public void setTaskId(int value) {
		this.taskId = value;
	}

	/**
	 * Gets the value of the qty property.
	 * 
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * Sets the value of the qty property.
	 * 
	 */
	public void setQty(int value) {
		this.qty = value;
	}

	/**
	 * Gets the value of the remark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the value of the remark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRemark(String value) {
		this.remark = value;
	}

	/**
	 * Gets the value of the operater property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOperater() {
		return operater;
	}

	/**
	 * Sets the value of the operater property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOperater(String value) {
		this.operater = value;
	}

}
