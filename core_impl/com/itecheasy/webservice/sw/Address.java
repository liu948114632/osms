package com.itecheasy.webservice.sw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for address complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="address">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cityTown" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://osms.communication.itecheasy.com/}country" minOccurs="0"/>
 *         &lt;element name="faxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", propOrder = { "addressLine1", "addressLine2", "cityTown", "country", "faxNumber",
		"firstName", "lastName", "phoneNumber", "province", "region", "zipCode" })
public abstract class Address {

	protected String addressLine1;
	protected String addressLine2;
	protected String cityTown;
	protected Country country;
	protected String faxNumber;
	protected String firstName;
	protected String lastName;
	protected String phoneNumber;
	protected String province;
	protected String region;
	protected String zipCode;

	/**
	 * Gets the value of the addressLine1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * Sets the value of the addressLine1 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddressLine1(String value) {
		this.addressLine1 = value;
	}

	/**
	 * Gets the value of the addressLine2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * Sets the value of the addressLine2 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddressLine2(String value) {
		this.addressLine2 = value;
	}

	/**
	 * Gets the value of the cityTown property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCityTown() {
		return cityTown;
	}

	/**
	 * Sets the value of the cityTown property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCityTown(String value) {
		this.cityTown = value;
	}

	/**
	 * Gets the value of the country property.
	 * 
	 * @return possible object is {@link Country }
	 * 
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Sets the value of the country property.
	 * 
	 * @param value
	 *            allowed object is {@link Country }
	 * 
	 */
	public void setCountry(Country value) {
		this.country = value;
	}

	/**
	 * Gets the value of the faxNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFaxNumber() {
		return faxNumber;
	}

	/**
	 * Sets the value of the faxNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFaxNumber(String value) {
		this.faxNumber = value;
	}

	/**
	 * Gets the value of the firstName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the value of the firstName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFirstName(String value) {
		this.firstName = value;
	}

	/**
	 * Gets the value of the lastName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the value of the lastName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLastName(String value) {
		this.lastName = value;
	}

	/**
	 * Gets the value of the phoneNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the value of the phoneNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}

	/**
	 * Gets the value of the province property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Sets the value of the province property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProvince(String value) {
		this.province = value;
	}

	/**
	 * Gets the value of the region property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Sets the value of the region property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRegion(String value) {
		this.region = value;
	}

	/**
	 * Gets the value of the zipCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the value of the zipCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setZipCode(String value) {
		this.zipCode = value;
	}

}
