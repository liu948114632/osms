package com.itecheasy.webservice.sw;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for packageItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="packageItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="collateDifferenceReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="collateQty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="complatedCollateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="complatedCollateUser" type="{http://osms.communication.itecheasy.com/}user" minOccurs="0"/>
 *         &lt;element name="costPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="orderProduct" type="{http://osms.communication.itecheasy.com/}orderProduct" minOccurs="0"/>
 *         &lt;element name="packageItemCollates" type="{http://osms.communication.itecheasy.com/}packageItemCollate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rushServicePrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="useRushService" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "packageItem", propOrder = { "collateDifferenceReason", "collateQty", "complatedCollateDate",
		"complatedCollateUser", "costPrice", "id", "orderProduct", "packageItemCollates", "qty", "rushServicePrice",
		"useRushService" })
public class PackageItem {

	protected String collateDifferenceReason;
	protected Integer collateQty;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar complatedCollateDate;
	protected User complatedCollateUser;
	protected BigDecimal costPrice;
	protected Integer id;
	protected OrderProduct orderProduct;
	@XmlElement(nillable = true)
	protected List<PackageItemCollate> packageItemCollates;
	protected int qty;
	protected BigDecimal rushServicePrice;
	protected Boolean useRushService;

	/**
	 * Gets the value of the collateDifferenceReason property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCollateDifferenceReason() {
		return collateDifferenceReason;
	}

	/**
	 * Sets the value of the collateDifferenceReason property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCollateDifferenceReason(String value) {
		this.collateDifferenceReason = value;
	}

	/**
	 * Gets the value of the collateQty property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCollateQty() {
		return collateQty;
	}

	/**
	 * Sets the value of the collateQty property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCollateQty(Integer value) {
		this.collateQty = value;
	}

	/**
	 * Gets the value of the complatedCollateDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getComplatedCollateDate() {
		return complatedCollateDate;
	}

	/**
	 * Sets the value of the complatedCollateDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setComplatedCollateDate(XMLGregorianCalendar value) {
		this.complatedCollateDate = value;
	}

	/**
	 * Gets the value of the complatedCollateUser property.
	 * 
	 * @return possible object is {@link User }
	 * 
	 */
	public User getComplatedCollateUser() {
		return complatedCollateUser;
	}

	/**
	 * Sets the value of the complatedCollateUser property.
	 * 
	 * @param value
	 *            allowed object is {@link User }
	 * 
	 */
	public void setComplatedCollateUser(User value) {
		this.complatedCollateUser = value;
	}

	/**
	 * Gets the value of the costPrice property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getCostPrice() {
		return costPrice;
	}

	/**
	 * Sets the value of the costPrice property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setCostPrice(BigDecimal value) {
		this.costPrice = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setId(Integer value) {
		this.id = value;
	}

	/**
	 * Gets the value of the orderProduct property.
	 * 
	 * @return possible object is {@link OrderProduct }
	 * 
	 */
	public OrderProduct getOrderProduct() {
		return orderProduct;
	}

	/**
	 * Sets the value of the orderProduct property.
	 * 
	 * @param value
	 *            allowed object is {@link OrderProduct }
	 * 
	 */
	public void setOrderProduct(OrderProduct value) {
		this.orderProduct = value;
	}

	/**
	 * Gets the value of the packageItemCollates property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the packageItemCollates property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPackageItemCollates().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PackageItemCollate }
	 * 
	 * 
	 */
	public List<PackageItemCollate> getPackageItemCollates() {
		if (packageItemCollates == null) {
			packageItemCollates = new ArrayList<PackageItemCollate>();
		}
		return this.packageItemCollates;
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
	 * Gets the value of the rushServicePrice property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getRushServicePrice() {
		return rushServicePrice;
	}

	/**
	 * Sets the value of the rushServicePrice property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setRushServicePrice(BigDecimal value) {
		this.rushServicePrice = value;
	}

	/**
	 * Gets the value of the useRushService property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isUseRushService() {
		return useRushService;
	}

	/**
	 * Sets the value of the useRushService property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setUseRushService(Boolean value) {
		this.useRushService = value;
	}

}
