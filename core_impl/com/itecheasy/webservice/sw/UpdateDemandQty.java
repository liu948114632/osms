package com.itecheasy.webservice.sw;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for updateDemandQty complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="updateDemandQty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="businessId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="purchasePrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://osms.communication.itecheasy.com/}operator" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateDemandQty", propOrder = { "orderCode", "businessId", "qty", "purchasePrice", "operator" })
public class UpdateDemandQty {

	protected String orderCode;
	protected int businessId;
	protected int qty;
	protected BigDecimal purchasePrice;
	protected Operator operator;

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
	 * Gets the value of the businessId property.
	 * 
	 */
	public int getBusinessId() {
		return businessId;
	}

	/**
	 * Sets the value of the businessId property.
	 * 
	 */
	public void setBusinessId(int value) {
		this.businessId = value;
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
	 * Gets the value of the purchasePrice property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * Sets the value of the purchasePrice property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPurchasePrice(BigDecimal value) {
		this.purchasePrice = value;
	}

	/**
	 * Gets the value of the operator property.
	 * 
	 * @return possible object is {@link Operator }
	 * 
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * Sets the value of the operator property.
	 * 
	 * @param value
	 *            allowed object is {@link Operator }
	 * 
	 */
	public void setOperator(Operator value) {
		this.operator = value;
	}

}
