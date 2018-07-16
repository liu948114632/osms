package com.itecheasy.webservice.oa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for UserModel complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="UserModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MobilePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Msn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsValid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserModel", propOrder = { "address", "id", "name",
		"workNumber", "sex", "mobilePhone", "email", "msn", "phone", "isValid" })
public class UserModel {

	@XmlElement(name = "Address")
	protected String address;
	@XmlElement(name = "Id")
	protected int id;
	@XmlElement(name = "Name")
	protected String name;
	@XmlElement(name = "WorkNumber")
	protected String workNumber;
	@XmlElement(name = "Sex")
	protected String sex;
	@XmlElement(name = "MobilePhone")
	protected String mobilePhone;
	@XmlElement(name = "Email")
	protected String email;
	@XmlElement(name = "Msn")
	protected String msn;
	@XmlElement(name = "Phone")
	protected String phone;
	@XmlElement(name = "IsValid")
	protected int isValid;

	/**
	 * Gets the value of the address property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the value of the address property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddress(String value) {
		this.address = value;
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
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the workNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWorkNumber() {
		return workNumber;
	}

	/**
	 * Sets the value of the workNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWorkNumber(String value) {
		this.workNumber = value;
	}

	/**
	 * Gets the value of the sex property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the value of the sex property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSex(String value) {
		this.sex = value;
	}

	/**
	 * Gets the value of the mobilePhone property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * Sets the value of the mobilePhone property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMobilePhone(String value) {
		this.mobilePhone = value;
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
	 * Gets the value of the msn property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMsn() {
		return msn;
	}

	/**
	 * Sets the value of the msn property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMsn(String value) {
		this.msn = value;
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
	 * Gets the value of the isValid property.
	 * 
	 */
	public int getIsValid() {
		return isValid;
	}

	/**
	 * Sets the value of the isValid property.
	 * 
	 */
	public void setIsValid(int value) {
		this.isValid = value;
	}

}
