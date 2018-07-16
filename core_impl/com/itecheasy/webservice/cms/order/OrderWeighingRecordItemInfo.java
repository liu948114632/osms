package com.itecheasy.webservice.cms.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for orderWeighingRecordItemInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderWeighingRecordItemInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actualWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="box" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="items" type="{http://osms.communication.itecheasy.com/}orderWeighingRecordProductInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orderCodes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderVolumeWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="volumeWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="websiteWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderWeighingRecordItemInfo", propOrder = { "actualWeight", "box", "height", "id", "items", "length",
		"orderCodes", "orderVolumeWeight", "volumeWeight", "websiteWeight", "width" })
public class OrderWeighingRecordItemInfo {

	protected BigDecimal actualWeight;
	protected int box;
	protected int height;
	protected int id;
	@XmlElement(nillable = true)
	protected List<OrderWeighingRecordProductInfo> items;
	protected int length;
	protected String orderCodes;
	protected BigDecimal orderVolumeWeight;
	protected BigDecimal volumeWeight;
	protected BigDecimal websiteWeight;
	protected int width;

	/**
	 * Gets the value of the actualWeight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getActualWeight() {
		return actualWeight;
	}

	/**
	 * Sets the value of the actualWeight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setActualWeight(BigDecimal value) {
		this.actualWeight = value;
	}

	/**
	 * Gets the value of the box property.
	 * 
	 */
	public int getBox() {
		return box;
	}

	/**
	 * Sets the value of the box property.
	 * 
	 */
	public void setBox(int value) {
		this.box = value;
	}

	/**
	 * Gets the value of the height property.
	 * 
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the value of the height property.
	 * 
	 */
	public void setHeight(int value) {
		this.height = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 */
	public void setId(int value) {
		this.id = value;
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
	 * {@link OrderWeighingRecordProductInfo }
	 * 
	 * 
	 */
	public List<OrderWeighingRecordProductInfo> getItems() {
		if (items == null) {
			items = new ArrayList<OrderWeighingRecordProductInfo>();
		}
		return this.items;
	}

	/**
	 * Gets the value of the length property.
	 * 
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Sets the value of the length property.
	 * 
	 */
	public void setLength(int value) {
		this.length = value;
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
	 * Gets the value of the orderVolumeWeight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getOrderVolumeWeight() {
		return orderVolumeWeight;
	}

	/**
	 * Sets the value of the orderVolumeWeight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setOrderVolumeWeight(BigDecimal value) {
		this.orderVolumeWeight = value;
	}

	/**
	 * Gets the value of the volumeWeight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getVolumeWeight() {
		return volumeWeight;
	}

	/**
	 * Sets the value of the volumeWeight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setVolumeWeight(BigDecimal value) {
		this.volumeWeight = value;
	}

	/**
	 * Gets the value of the websiteWeight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getWebsiteWeight() {
		return websiteWeight;
	}

	/**
	 * Sets the value of the websiteWeight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setWebsiteWeight(BigDecimal value) {
		this.websiteWeight = value;
	}

	/**
	 * Gets the value of the width property.
	 * 
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the value of the width property.
	 * 
	 */
	public void setWidth(int value) {
		this.width = value;
	}

}
