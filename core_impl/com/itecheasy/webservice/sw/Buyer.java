package com.itecheasy.webservice.sw;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for buyer complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="buyer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cashAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="country" type="{http://osms.communication.itecheasy.com/}country" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://osms.communication.itecheasy.com/}gender" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lastLoginDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nickName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payErrorFirsttime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="payErrorNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="pointAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="registerDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="shoppingCartId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siteType" type="{http://osms.communication.itecheasy.com/}siteType" minOccurs="0"/>
 *         &lt;element name="status" type="{http://osms.communication.itecheasy.com/}buyerStatus" minOccurs="0"/>
 *         &lt;element name="webSite" type="{http://osms.communication.itecheasy.com/}webSite" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buyer", propOrder = { "accountStatus", "cashAmount", "country", "email", "firstName", "gender", "id",
		"lastLoginDate", "lastName", "nickName", "payErrorFirsttime", "payErrorNumber", "pointAmount", "registerDate",
		"shoppingCartId", "siteType", "status", "webSite" })
public class Buyer {

	protected String accountStatus;
	protected BigDecimal cashAmount;
	protected Country country;
	protected String email;
	protected String firstName;
	protected Gender gender;
	protected Integer id;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar lastLoginDate;
	protected String lastName;
	protected String nickName;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar payErrorFirsttime;
	protected Integer payErrorNumber;
	protected BigDecimal pointAmount;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar registerDate;
	protected String shoppingCartId;
	protected SiteType siteType;
	protected BuyerStatus status;
	protected WebSite webSite;

	/**
	 * Gets the value of the accountStatus property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAccountStatus() {
		return accountStatus;
	}

	/**
	 * Sets the value of the accountStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAccountStatus(String value) {
		this.accountStatus = value;
	}

	/**
	 * Gets the value of the cashAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	/**
	 * Sets the value of the cashAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setCashAmount(BigDecimal value) {
		this.cashAmount = value;
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
	 * Gets the value of the gender property.
	 * 
	 * @return possible object is {@link Gender }
	 * 
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the value of the gender property.
	 * 
	 * @param value
	 *            allowed object is {@link Gender }
	 * 
	 */
	public void setGender(Gender value) {
		this.gender = value;
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
	 * Gets the value of the lastLoginDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * Sets the value of the lastLoginDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setLastLoginDate(XMLGregorianCalendar value) {
		this.lastLoginDate = value;
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
	 * Gets the value of the nickName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Sets the value of the nickName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNickName(String value) {
		this.nickName = value;
	}

	/**
	 * Gets the value of the payErrorFirsttime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getPayErrorFirsttime() {
		return payErrorFirsttime;
	}

	/**
	 * Sets the value of the payErrorFirsttime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setPayErrorFirsttime(XMLGregorianCalendar value) {
		this.payErrorFirsttime = value;
	}

	/**
	 * Gets the value of the payErrorNumber property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getPayErrorNumber() {
		return payErrorNumber;
	}

	/**
	 * Sets the value of the payErrorNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setPayErrorNumber(Integer value) {
		this.payErrorNumber = value;
	}

	/**
	 * Gets the value of the pointAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPointAmount() {
		return pointAmount;
	}

	/**
	 * Sets the value of the pointAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPointAmount(BigDecimal value) {
		this.pointAmount = value;
	}

	/**
	 * Gets the value of the registerDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getRegisterDate() {
		return registerDate;
	}

	/**
	 * Sets the value of the registerDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setRegisterDate(XMLGregorianCalendar value) {
		this.registerDate = value;
	}

	/**
	 * Gets the value of the shoppingCartId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getShoppingCartId() {
		return shoppingCartId;
	}

	/**
	 * Sets the value of the shoppingCartId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setShoppingCartId(String value) {
		this.shoppingCartId = value;
	}

	/**
	 * Gets the value of the siteType property.
	 * 
	 * @return possible object is {@link SiteType }
	 * 
	 */
	public SiteType getSiteType() {
		return siteType;
	}

	/**
	 * Sets the value of the siteType property.
	 * 
	 * @param value
	 *            allowed object is {@link SiteType }
	 * 
	 */
	public void setSiteType(SiteType value) {
		this.siteType = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link BuyerStatus }
	 * 
	 */
	public BuyerStatus getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value
	 *            allowed object is {@link BuyerStatus }
	 * 
	 */
	public void setStatus(BuyerStatus value) {
		this.status = value;
	}

	/**
	 * Gets the value of the webSite property.
	 * 
	 * @return possible object is {@link WebSite }
	 * 
	 */
	public WebSite getWebSite() {
		return webSite;
	}

	/**
	 * Sets the value of the webSite property.
	 * 
	 * @param value
	 *            allowed object is {@link WebSite }
	 * 
	 */
	public void setWebSite(WebSite value) {
		this.webSite = value;
	}

}
