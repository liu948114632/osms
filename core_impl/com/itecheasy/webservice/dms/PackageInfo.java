package com.itecheasy.webservice.dms;

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
 * Java class for packageInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="packageInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logs" type="{http://out.webservice.dms.itecheasy.com/}packageLogInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packageInfos" type="{http://out.webservice.dms.itecheasy.com/}packageInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="processer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="questions" type="{http://out.webservice.dms.itecheasy.com/}packageQuestionInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shippingMethod" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="traceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="traceStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="traceTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "packageInfo", propOrder = { "country", "customName", "deliveryCode", "deliveryTime", "email", "logs",
		"orderCode", "packageInfos", "processer", "questions", "remark", "shippingMethod", "traceCode", "traceStatus",
		"traceTime", "type" })
public class PackageInfo {

	protected String country;
	protected String customName;
	protected String deliveryCode;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar deliveryTime;
	protected String email;
	@XmlElement(nillable = true)
	protected List<PackageLogInfo> logs;
	protected String orderCode;
	@XmlElement(nillable = true)
	protected List<PackageInfo> packageInfos;
	protected String processer;
	@XmlElement(nillable = true)
	protected List<PackageQuestionInfo> questions;
	protected String remark;
	protected Integer shippingMethod;
	protected String traceCode;
	protected String traceStatus;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar traceTime;
	protected String type;

	/**
	 * Gets the value of the country property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the value of the country property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCountry(String value) {
		this.country = value;
	}

	/**
	 * Gets the value of the customName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCustomName() {
		return customName;
	}

	/**
	 * Sets the value of the customName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCustomName(String value) {
		this.customName = value;
	}

	/**
	 * Gets the value of the deliveryCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDeliveryCode() {
		return deliveryCode;
	}

	/**
	 * Sets the value of the deliveryCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeliveryCode(String value) {
		this.deliveryCode = value;
	}

	/**
	 * Gets the value of the deliveryTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * Sets the value of the deliveryTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDeliveryTime(XMLGregorianCalendar value) {
		this.deliveryTime = value;
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
	 * Gets the value of the logs property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the logs property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getLogs().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PackageLogInfo }
	 * 
	 * 
	 */
	public List<PackageLogInfo> getLogs() {
		if (logs == null) {
			logs = new ArrayList<PackageLogInfo>();
		}
		return this.logs;
	}

	/**
	 * Gets the value of the orderCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * Sets the value of the orderCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderCode(String value) {
		this.orderCode = value;
	}

	/**
	 * Gets the value of the packageInfos property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the packageInfos property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPackageInfos().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PackageInfo }
	 * 
	 * 
	 */
	public List<PackageInfo> getPackageInfos() {
		if (packageInfos == null) {
			packageInfos = new ArrayList<PackageInfo>();
		}
		return this.packageInfos;
	}

	/**
	 * Gets the value of the processer property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProcesser() {
		return processer;
	}

	/**
	 * Sets the value of the processer property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProcesser(String value) {
		this.processer = value;
	}

	/**
	 * Gets the value of the questions property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the questions property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getQuestions().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PackageQuestionInfo }
	 * 
	 * 
	 */
	public List<PackageQuestionInfo> getQuestions() {
		if (questions == null) {
			questions = new ArrayList<PackageQuestionInfo>();
		}
		return this.questions;
	}

	/**
	 * Gets the value of the remark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the value of the remark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRemark(String value) {
		this.remark = value;
	}

	/**
	 * Gets the value of the shippingMethod property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getShippingMethod() {
		return shippingMethod;
	}

	/**
	 * Sets the value of the shippingMethod property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setShippingMethod(Integer value) {
		this.shippingMethod = value;
	}

	/**
	 * Gets the value of the traceCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTraceCode() {
		return traceCode;
	}

	/**
	 * Sets the value of the traceCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTraceCode(String value) {
		this.traceCode = value;
	}

	/**
	 * Gets the value of the traceStatus property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTraceStatus() {
		return traceStatus;
	}

	/**
	 * Sets the value of the traceStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTraceStatus(String value) {
		this.traceStatus = value;
	}

	/**
	 * Gets the value of the traceTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getTraceTime() {
		return traceTime;
	}

	/**
	 * Sets the value of the traceTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setTraceTime(XMLGregorianCalendar value) {
		this.traceTime = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setType(String value) {
		this.type = value;
	}

}
