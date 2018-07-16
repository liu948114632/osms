package com.itecheasy.webservice.cms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getBetchStorageByType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getBetchStorageByType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productIds" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="storageType" type="{http://osms.communication.itecheasy.com/}storageType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBetchStorageByType", propOrder = { "productIds", "storageType" })
public class GetBetchStorageByType {

	@XmlElement(type = Integer.class)
	protected List<Integer> productIds;
	protected StorageType storageType;

	/**
	 * Gets the value of the productIds property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the productIds property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProductIds().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Integer }
	 * 
	 * 
	 */
	public List<Integer> getProductIds() {
		if (productIds == null) {
			productIds = new ArrayList<Integer>();
		}
		return this.productIds;
	}

	/**
	 * Gets the value of the storageType property.
	 * 
	 * @return possible object is {@link StorageType }
	 * 
	 */
	public StorageType getStorageType() {
		return storageType;
	}

	/**
	 * Sets the value of the storageType property.
	 * 
	 * @param value
	 *            allowed object is {@link StorageType }
	 * 
	 */
	public void setStorageType(StorageType value) {
		this.storageType = value;
	}

}
