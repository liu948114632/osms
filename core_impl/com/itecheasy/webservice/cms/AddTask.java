package com.itecheasy.webservice.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for addTask complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="addTask">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="taskType" type="{http://osms.communication.itecheasy.com/}osmsStorageTask" minOccurs="0"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "addTask", propOrder = { "taskType", "productId", "qty", "remark", "operater" })
public class AddTask {

	protected OsmsStorageTask taskType;
	protected int productId;
	protected int qty;
	protected String remark;
	protected String operater;

	/**
	 * Gets the value of the taskType property.
	 * 
	 * @return possible object is {@link OsmsStorageTask }
	 * 
	 */
	public OsmsStorageTask getTaskType() {
		return taskType;
	}

	/**
	 * Sets the value of the taskType property.
	 * 
	 * @param value
	 *            allowed object is {@link OsmsStorageTask }
	 * 
	 */
	public void setTaskType(OsmsStorageTask value) {
		this.taskType = value;
	}

	/**
	 * Gets the value of the productId property.
	 * 
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Sets the value of the productId property.
	 * 
	 */
	public void setProductId(int value) {
		this.productId = value;
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
