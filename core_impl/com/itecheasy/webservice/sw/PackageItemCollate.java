package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for packageItemCollate complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="packageItemCollate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="box" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="collateQty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "packageItemCollate", propOrder = { "box", "collateQty", "id" })
public class PackageItemCollate {

	protected String box;
	protected int collateQty;
	protected int id;

	/**
	 * Gets the value of the box property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBox() {
		return box;
	}

	/**
	 * Sets the value of the box property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBox(String value) {
		this.box = value;
	}

	/**
	 * Gets the value of the collateQty property.
	 * 
	 */
	public int getCollateQty() {
		return collateQty;
	}

	/**
	 * Sets the value of the collateQty property.
	 * 
	 */
	public void setCollateQty(int value) {
		this.collateQty = value;
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

}
