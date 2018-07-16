package com.itecheasy.webservice.sw;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for orderVO complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="orderVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="buyerOrderQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="order" type="{http://osms.communication.itecheasy.com/}order" minOccurs="0"/>
 *         &lt;element name="packages" type="{http://osms.communication.itecheasy.com/}package" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pps" type="{http://osms.communication.itecheasy.com/}purchaseProduct" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderVO", propOrder = { "buyerOrderQty", "order", "packages", "pps" })
public class OrderVO {

	protected Integer buyerOrderQty;
	protected Order order;
	@XmlElement(nillable = true)
	protected List<Package> packages;
	@XmlElement(nillable = true)
	protected List<PurchaseProduct> pps;

	/**
	 * Gets the value of the buyerOrderQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getBuyerOrderQty() {
		return buyerOrderQty;
	}

	/**
	 * Sets the value of the buyerOrderQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setBuyerOrderQty(Integer value) {
		this.buyerOrderQty = value;
	}

	/**
	 * Gets the value of the order property.
	 * 
	 * @return possible object is {@link Order }
	 * 
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets the value of the order property.
	 * 
	 * @param value
	 *            allowed object is {@link Order }
	 * 
	 */
	public void setOrder(Order value) {
		this.order = value;
	}

	/**
	 * Gets the value of the packages property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the packages property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPackages().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Package }
	 * 
	 * 
	 */
	public List<Package> getPackages() {
		if (packages == null) {
			packages = new ArrayList<Package>();
		}
		return this.packages;
	}

	/**
	 * Gets the value of the pps property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the pps property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPps().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PurchaseProduct }
	 * 
	 * 
	 */
	public List<PurchaseProduct> getPps() {
		if (pps == null) {
			pps = new ArrayList<PurchaseProduct>();
		}
		return this.pps;
	}

}
