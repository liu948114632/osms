package com.itecheasy.core.order;

import java.util.Date;

/**
 * @author wanghw
 * @date 2015-5-6
 * @description 订单列表查询条件
 * @version 1.1
 */
public class SearchOrderForm {
	private String orderCode; // 模糊查询 ，按订单号查询的时候忽略其他查询条件
	private int orderStatus;
	private String shopOrderStatus;
	private int sendTag;
	private int ticket;
	private String productCode;
	private String customerName;
	private String customerAccount;
	private int country;
	private int shippingMethod;
	private Date EarliestShipDate;
	private Date LatestShipDate;
	private Date purchaseDateFrom;
	private Date purchaseDateTo;
	private Date EarliestDeliveryDate;
	private Date LatestDeliveryDate;
	private int shopId;
	private String shopOrderCode;// 模糊查询，按网店交易号查询时忽略其他查询条件。网店交易号订单号一起查询时，查询2个条件都满足的订单
	private int estimateLatest;// 预计晚发货
	private int operator;
	private int isLater;

	private int problemStatus;
	private int problemType;
	private int cmsPrepare;
	private int shopType;

	/**
	 * AMAZON FBA订单类型:<br>
	 * <em>AFN、MFN<em>
	 */
	private String fulfillmentChannel;
	private String shopshippingMethod;

	private int shippingListStatus;
	private String shipmentID;

	public int getShopType() {
		return shopType;
	}

	public void setShopType(int shopType) {
		this.shopType = shopType;
	}

	public int getShippingListStatus() {
		return shippingListStatus;
	}

	public void setShippingListStatus(int shippingListStatus) {
		this.shippingListStatus = shippingListStatus;
	}

	public String getShopshippingMethod() {
		return shopshippingMethod;
	}

	public void setShopshippingMethod(String shopshippingMethod) {
		this.shopshippingMethod = shopshippingMethod;
	}

	public String getFulfillmentChannel() {
		return fulfillmentChannel;
	}

	public void setFulfillmentChannel(String fulfillmentChannel) {
		this.fulfillmentChannel = fulfillmentChannel;
	}

	public int getCmsPrepare() {
		return cmsPrepare;
	}

	public void setCmsPrepare(int cmsPrepare) {
		this.cmsPrepare = cmsPrepare;
	}

	public int getProblemStatus() {
		return problemStatus;
	}

	public void setProblemStatus(int problemStatus) {
		this.problemStatus = problemStatus;
	}

	public int getProblemType() {
		return problemType;
	}

	public void setProblemType(int problemType) {
		this.problemType = problemType;
	}

	public int getIsLater() {
		return isLater;
	}

	public void setIsLater(int isLater) {
		this.isLater = isLater;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getSendTag() {
		return sendTag;
	}

	public void setSendTag(int sendTag) {
		this.sendTag = sendTag;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public Date getPurchaseDateFrom() {
		return purchaseDateFrom;
	}

	public void setPurchaseDateFrom(Date purchaseDateFrom) {
		this.purchaseDateFrom = purchaseDateFrom;
	}

	public Date getPurchaseDateTo() {
		return purchaseDateTo;
	}

	public void setPurchaseDateTo(Date purchaseDateTo) {
		this.purchaseDateTo = purchaseDateTo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(int shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public Date getEarliestShipDate() {
		return EarliestShipDate;
	}

	public void setEarliestShipDate(Date earliestShipDate) {
		EarliestShipDate = earliestShipDate;
	}

	public Date getLatestShipDate() {
		return LatestShipDate;
	}

	public void setLatestShipDate(Date latestShipDate) {
		LatestShipDate = latestShipDate;
	}

	public Date getEarliestDeliveryDate() {
		return EarliestDeliveryDate;
	}

	public void setEarliestDeliveryDate(Date earliestDeliveryDate) {
		EarliestDeliveryDate = earliestDeliveryDate;
	}

	public Date getLatestDeliveryDate() {
		return LatestDeliveryDate;
	}

	public void setLatestDeliveryDate(Date latestDeliveryDate) {
		LatestDeliveryDate = latestDeliveryDate;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopOrderStatus() {
		return shopOrderStatus;
	}

	public void setShopOrderStatus(String shopOrderStatus) {
		this.shopOrderStatus = shopOrderStatus;
	}

	public String getShopOrderCode() {
		return shopOrderCode;
	}

	public void setShopOrderCode(String shopOrderCode) {
		this.shopOrderCode = shopOrderCode;
	}

	public int getEstimateLatest() {
		return estimateLatest;
	}

	public void setEstimateLatest(int estimateLatest) {
		this.estimateLatest = estimateLatest;
	}

	public String getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(String shipmentID) {
		this.shipmentID = shipmentID;
	}

	
}
