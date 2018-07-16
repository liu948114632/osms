package com.itecheasy.webservice.cms.order;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for orderWeighingRecordInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderWeighingRecordInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deliverWeight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="items" type="{http://osms.communication.itecheasy.com/}orderWeighingRecordItemInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderCodes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="websiteWeight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="weightRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderWeighingRecordInfo", propOrder = { "deliverWeight", "items", "orderCodes", "orderId",
		"websiteWeight", "weightRemark" })
public class OrderWeighingRecordInfo {

	protected int deliverWeight;
	@XmlElement(nillable = true)
	protected List<OrderWeighingRecordItemInfo> items;
	protected String orderCodes;
	protected int orderId;
	protected int websiteWeight;
	protected String weightRemark;

	/**
	 * Gets the value of the deliverWeight property.
	 * 
	 */
	public int getDeliverWeight() {
		return deliverWeight;
	}

	/**
	 * Sets the value of the deliverWeight property.
	 * 
	 */
	public void setDeliverWeight(int value) {
		this.deliverWeight = value;
	}

	/**
	 * Gets the value of the items property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the items property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link OrderWeighingRecordItemInfo }
	 * 
	 * 
	 */
	public List<OrderWeighingRecordItemInfo> getItems() {
		if (items == null) {
			items = new ArrayList<OrderWeighingRecordItemInfo>();
		}
		return this.items;
	}

	/**
	 * Gets the value of the orderCodes property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderCodes() {
		return orderCodes;
	}

	/**
	 * Sets the value of the orderCodes property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderCodes(String value) {
		this.orderCodes = value;
	}

	/**
	 * Gets the value of the orderId property.
	 * 
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Sets the value of the orderId property.
	 * 
	 */
	public void setOrderId(int value) {
		this.orderId = value;
	}

	/**
	 * Gets the value of the websiteWeight property.
	 * 
	 */
	public int getWebsiteWeight() {
		return websiteWeight;
	}

	/**
	 * Sets the value of the websiteWeight property.
	 * 
	 */
	public void setWebsiteWeight(int value) {
		this.websiteWeight = value;
	}

	/**
	 * Gets the value of the weightRemark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWeightRemark() {
		return weightRemark;
	}

	/**
	 * Sets the value of the weightRemark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWeightRemark(String value) {
		this.weightRemark = value;
	}

}
