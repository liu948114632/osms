package com.itecheasy.webservice.dms;

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
 *         &lt;element name="address1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vatType" type="{http://out.webservice.dms.itecheasy.com/}vatTypeInfo" minOccurs="0"/>
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
@XmlType(name = "address", propOrder = { "address1", "address2", "city", "companyName", "country", "email", "fax",
		"firstName", "id", "lastName", "phone", "state", "vat", "vatType", "zipCode", "destinationFulfillmentCenterId" })
public class Address {

	protected String address1;
	protected String address2;
	protected String city;
	protected String companyName;
	protected Integer country;
	protected String email;
	protected String fax;
	protected String firstName;
	protected Integer id;
	protected String lastName;
	protected String phone;
	protected String state;
	protected String vat;
	protected VatTypeInfo vatType;
	protected String zipCode;
	protected String destinationFulfillmentCenterId;

	/**
	 * Gets the value of the address1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * Sets the value of the address1 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddress1(String value) {
		this.address1 = value;
	}

	/**
	 * Gets the value of the address2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * Sets the value of the address2 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddress2(String value) {
		this.address2 = value;
	}

	/**
	 * Gets the value of the city property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the value of the city property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCity(String value) {
		this.city = value;
	}

	/**
	 * Gets the value of the companyName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Sets the value of the companyName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCompanyName(String value) {
		this.companyName = value;
	}

	/**
	 * Gets the value of the country property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCountry() {
		return country;
	}

	/**
	 * Sets the value of the country property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCountry(Integer value) {
		this.country = value;
	}

	/**
	 * Gets the value of the email property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the value of the email property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 * Gets the value of the fax property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Sets the value of the fax property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFax(String value) {
		this.fax = value;
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
	 * Gets the value of the phone property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the value of the phone property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPhone(String value) {
		this.phone = value;
	}

	/**
	 * Gets the value of the state property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the value of the state property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setState(String value) {
		this.state = value;
	}

	/**
	 * Gets the value of the vat property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVat() {
		return vat;
	}

	/**
	 * Sets the value of the vat property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVat(String value) {
		this.vat = value;
	}

	/**
	 * Gets the value of the vatType property.
	 * 
	 * @return possible object is {@link VatTypeInfo }
	 * 
	 */
	public VatTypeInfo getVatType() {
		return vatType;
	}

	/**
	 * Sets the value of the vatType property.
	 * 
	 * @param value
	 *            allowed object is {@link VatTypeInfo }
	 * 
	 */
	public void setVatType(VatTypeInfo value) {
		this.vatType = value;
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

	public String getDestinationFulfillmentCenterId() {
		return destinationFulfillmentCenterId;
	}

	public void setDestinationFulfillmentCenterId(String destinationFulfillmentCenterId) {
		this.destinationFulfillmentCenterId = destinationFulfillmentCenterId;
	}

}
