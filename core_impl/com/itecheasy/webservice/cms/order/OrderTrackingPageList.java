package com.itecheasy.webservice.cms.order;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for orderTrackingPageList complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderTrackingPageList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://osms.communication.itecheasy.com/}orderTrackingItemVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="page" type="{http://osms.communication.itecheasy.com/}page" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderTrackingPageList", propOrder = { "data", "page" })
public class OrderTrackingPageList {

	@XmlElement(nillable = true)
	protected List<OrderTrackingItemVO> data;
	protected Page page;

	/**
	 * Gets the value of the data property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the data property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getData().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link OrderTrackingItemVO }
	 * 
	 * 
	 */
	public List<OrderTrackingItemVO> getData() {
		if (data == null) {
			data = new ArrayList<OrderTrackingItemVO>();
		}
		return this.data;
	}

	/**
	 * Gets the value of the page property.
	 * 
	 * @return possible object is {@link Page }
	 * 
	 */
	public Page getPage() {
		return page;
	}

	/**
	 * Sets the value of the page property.
	 * 
	 * @param value
	 *            allowed object is {@link Page }
	 * 
	 */
	public void setPage(Page value) {
		this.page = value;
	}

}
