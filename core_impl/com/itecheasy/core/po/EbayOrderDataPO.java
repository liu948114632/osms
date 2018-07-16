package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-7-26
 * @description TODO
 * @version 1.2.0
 */
@Entity
@Table(name="ebay_file_order_history")
public class EbayOrderDataPO {
	private int id;
	private int shopId;
	private String salesRecordNumber;
	private String userId;
	private String buyerFullname;
	private String buyerPhoneNumber;
	private String buyerEmail;
	private String buyerAddress1;
	private String buyerAddress2;
	private String buyerCity;
	private String buyerState;
	private String buyerCountry;
	private String buyerZip;
	private String itemNumber;
	private String itemTitle;
	private String customLabel;
	private String quantity;
	private String salePrice;
	private String shippingAndHandling;
	private String USTax;
	private String insurance;
	private String cashOnDeliveryFee;
	private String totalPrice;
	private String paymentMethod;
	private Date saleDate;
	private Date checkoutDate;
	private Date paidOnDate;
	private Date shippingOnDate;
	private String feedbackLeft;
	private String feedbackReceived;
	private String notesToYourself;
	private String payPalTransactionID;
	private String shippingService;
	private String cashOnDeliveryOption;
	private String transactionID;
	private String orderID;
	private String variationDetails;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Column
	public String getSalesRecordNumber() {
		return salesRecordNumber;
	}

	public void setSalesRecordNumber(String salesRecordNumber) {
		this.salesRecordNumber = salesRecordNumber;
	}

	@Column
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	@Column
	public String getBuyerFullname() {
		return buyerFullname;
	}

	public void setBuyerFullname(String buyerFullname) {
		this.buyerFullname = buyerFullname;
	}

	@Column
	public String getBuyerPhoneNumber() {
		return buyerPhoneNumber;
	}

	public void setBuyerPhoneNumber(String buyerPhoneNumber) {
		this.buyerPhoneNumber = buyerPhoneNumber;
	}

	@Column
	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	@Column
	public String getBuyerAddress1() {
		return buyerAddress1;
	}

	public void setBuyerAddress1(String buyerAddress1) {
		this.buyerAddress1 = buyerAddress1;
	}

	@Column
	public String getBuyerAddress2() {
		return buyerAddress2;
	}

	public void setBuyerAddress2(String buyerAddress2) {
		this.buyerAddress2 = buyerAddress2;
	}

	@Column
	public String getBuyerCity() {
		return buyerCity;
	}

	public void setBuyerCity(String buyerCity) {
		this.buyerCity = buyerCity;
	}

	@Column
	public String getBuyerState() {
		return buyerState;
	}

	public void setBuyerState(String buyerState) {
		this.buyerState = buyerState;
	}

	@Column
	public String getBuyerCountry() {
		return buyerCountry;
	}

	public void setBuyerCountry(String buyerCountry) {
		this.buyerCountry = buyerCountry;
	}

	@Column
	public String getBuyerZip() {
		return buyerZip;
	}

	public void setBuyerZip(String buyerZip) {
		this.buyerZip = buyerZip;
	}

	@Column
	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	@Column
	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	@Column
	public String getCustomLabel() {
		return customLabel;
	}

	public void setCustomLabel(String customLabel) {
		this.customLabel = customLabel;
	}

	@Column
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Column
	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	@Column
	public String getShippingAndHandling() {
		return shippingAndHandling;
	}

	public void setShippingAndHandling(String shippingAndHandling) {
		this.shippingAndHandling = shippingAndHandling;
	}

	@Column
	public String getUSTax() {
		return USTax;
	}

	public void setUSTax(String uSTax) {
		USTax = uSTax;
	}

	@Column
	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	@Column
	public String getCashOnDeliveryFee() {
		return cashOnDeliveryFee;
	}

	public void setCashOnDeliveryFee(String cashOnDeliveryFee) {
		this.cashOnDeliveryFee = cashOnDeliveryFee;
	}

	@Column
	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Column
	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	@Column
	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	@Column
	public Date getPaidOnDate() {
		return paidOnDate;
	}

	public void setPaidOnDate(Date paidOnDate) {
		this.paidOnDate = paidOnDate;
	}

	@Column
	public Date getShippingOnDate() {
		return shippingOnDate;
	}

	public void setShippingOnDate(Date shippingOnDate) {
		this.shippingOnDate = shippingOnDate;
	}

	@Column
	public String getFeedbackLeft() {
		return feedbackLeft;
	}

	public void setFeedbackLeft(String feedbackLeft) {
		this.feedbackLeft = feedbackLeft;
	}

	@Column
	public String getFeedbackReceived() {
		return feedbackReceived;
	}

	public void setFeedbackReceived(String feedbackReceived) {
		this.feedbackReceived = feedbackReceived;
	}

	@Column
	public String getNotesToYourself() {
		return notesToYourself;
	}

	public void setNotesToYourself(String notesToYourself) {
		this.notesToYourself = notesToYourself;
	}

	@Column
	public String getPayPalTransactionID() {
		return payPalTransactionID;
	}

	public void setPayPalTransactionID(String payPalTransactionID) {
		this.payPalTransactionID = payPalTransactionID;
	}

	@Column
	public String getShippingService() {
		return shippingService;
	}

	public void setShippingService(String shippingService) {
		this.shippingService = shippingService;
	}

	@Column
	public String getCashOnDeliveryOption() {
		return cashOnDeliveryOption;
	}

	public void setCashOnDeliveryOption(String cashOnDeliveryOption) {
		this.cashOnDeliveryOption = cashOnDeliveryOption;
	}

	@Column
	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	@Column
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	@Column
	public String getVariationDetails() {
		return variationDetails;
	}

	public void setVariationDetails(String variationDetails) {
		this.variationDetails = variationDetails;
	}
	
}
