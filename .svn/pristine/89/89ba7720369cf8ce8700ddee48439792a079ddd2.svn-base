package com.itecheasy.webservice.dms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for boxInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="boxInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="barCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="phyWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="products" type="{http://out.webservice.dms.itecheasy.com/}orderProductInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="wide" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "boxInfo", propOrder = { "barCode", "code", "hight", "length", "phyWeight", "products", "qty", "wide" })
public class BoxInfo {

	protected String barCode;
	protected String code;
	protected Integer hight;
	protected Integer length;
	protected BigDecimal phyWeight;
	@XmlElement(nillable = true)
	protected List<OrderProductInfo> products;
	protected BigDecimal qty;
	protected Integer wide;

	/**
	 * Gets the value of the barCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBarCode() {
		return barCode;
	}

	/**
	 * Sets the value of the barCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBarCode(String value) {
		this.barCode = value;
	}

	/**
	 * Gets the value of the code property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the value of the code property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 * Gets the value of the hight property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getHight() {
		return hight;
	}

	/**
	 * Sets the value of the hight property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setHight(Integer value) {
		this.hight = value;
	}

	/**
	 * Gets the value of the length property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * Sets the value of the length property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setLength(Integer value) {
		this.length = value;
	}

	/**
	 * Gets the value of the phyWeight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPhyWeight() {
		return phyWeight;
	}

	/**
	 * Sets the value of the phyWeight property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPhyWeight(BigDecimal value) {
		this.phyWeight = value;
	}

	/**
	 * Gets the value of the products property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the products property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProducts().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link OrderProductInfo }
	 * 
	 * 
	 */
	public List<OrderProductInfo> getProducts() {
		if (products == null) {
			products = new ArrayList<OrderProductInfo>();
		}
		return this.products;
	}

	/**
	 * Gets the value of the qty property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQty() {
		return qty;
	}

	/**
	 * Sets the value of the qty property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQty(BigDecimal value) {
		this.qty = value;
	}

	/**
	 * Gets the value of the wide property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getWide() {
		return wide;
	}

	/**
	 * Sets the value of the wide property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setWide(Integer value) {
		this.wide = value;
	}

	public void setProducts(List<OrderProductInfo> products) {
		this.products = products;
	}

}
