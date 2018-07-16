package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * order的amazon信息
 * 
 */
@Entity
@Table(name = "order_amazon")
public class OrderAmazonPO {
	private int id;
	/**
	 * am订单编号
	 * 
	 */
	private String amOrderId;
	/**
	 * am卖家订单编号
	 * 
	 */
	private String sellerOrderId;
	/**
	 * am订单状态
	 * 
	 */
	private String amOrderStatus;
	/**
	 * 买家邮箱
	 * 
	 */
	private String buyerEmail;
	/**
	 * 名字
	 * 
	 */
	private String buyerName;
	/**
	 * 币种
	 * 
	 */
	private int orderTotalCurrency;
	/**
	 * 订单总费用
	 * 
	 */
	private double orderTotal;

	/**
	 * 订单创建日期
	 * 
	 */
	private Date purchaseDate;
	/**
	 * 预计发货日期第一天
	 * 
	 */
	private Date earliestShippingDate;
	/**
	 * 预计发货日期最后一天
	 * 
	 */
	private Date latestShipDate;
	/**
	 * 预计交货日期第一天
	 * 
	 */
	private Date earliestDeliveryDate;
	/**
	 * 预计交货日期最后一天
	 * 
	 */
	private Date latestDeliveryDate;
	/**
	 * 商场编码，指明订单出产地
	 * 
	 */
	private String marketplaceId;

	/**
	 * 卖家自定义的配送方式
	 */
	private String CbaDisplayableShippingLabel;

	/**
	 * 订单配送服务级别
	 */
	private String ShipmentServiceLevelCategory;
	
	private int shopId;
	private String fulfillmentChannel;

	@Column(name="fulfillmentChannel")
	public String getFulfillmentChannel() {
		return fulfillmentChannel;
	}

	public void setFulfillmentChannel(String fulfillmentChannel) {
		this.fulfillmentChannel = fulfillmentChannel;
	}
	
	@Column(name="shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Column(name="CbaDisplayableShippingLabel")
	public String getCbaDisplayableShippingLabel() {
		return CbaDisplayableShippingLabel;
	}

	public void setCbaDisplayableShippingLabel(String cbaDisplayableShippingLabel) {
		CbaDisplayableShippingLabel = cbaDisplayableShippingLabel;
	}

	@Column(name="ShipmentServiceLevelCategory")
	public String getShipmentServiceLevelCategory() {
		return ShipmentServiceLevelCategory;
	}

	public void setShipmentServiceLevelCategory(String shipmentServiceLevelCategory) {
		ShipmentServiceLevelCategory = shipmentServiceLevelCategory;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "am_order_id")
	public String getAmOrderId() {
		return amOrderId;
	}

	public void setAmOrderId(String amOrderId) {
		this.amOrderId = amOrderId;
	}

	@Column(name = "seller_order_id")
	public String getSellerOrderId() {
		return sellerOrderId;
	}

	public void setSellerOrderId(String sellerOrderId) {
		this.sellerOrderId = sellerOrderId;
	}

	@Column(name = "am_order_status")
	public String getAmOrderStatus() {
		return amOrderStatus;
	}

	public void setAmOrderStatus(String amOrderStatus) {
		this.amOrderStatus = amOrderStatus;
	}

	@Column(name = "buyer_email")
	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	@Column(name = "buyer_name")
	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	@Column(name = "order_total_currency")
	public int getOrderTotalCurrency() {
		return orderTotalCurrency;
	}

	public void setOrderTotalCurrency(int orderTotalCurrency) {
		this.orderTotalCurrency = orderTotalCurrency;
	}

	@Column(name = "order_total")
	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Column(name = "purchase_date")
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Column(name = "earliest_shipping_date")
	public Date getEarliestShippingDate() {
		return earliestShippingDate;
	}

	public void setEarliestShippingDate(Date earliestShippingDate) {
		this.earliestShippingDate = earliestShippingDate;
	}

	@Column(name = "latest_ship_date")
	public Date getLatestShipDate() {
		return latestShipDate;
	}

	public void setLatestShipDate(Date latestShipDate) {
		this.latestShipDate = latestShipDate;
	}

	@Column(name = "earliest_delivery_date")
	public Date getEarliestDeliveryDate() {
		return earliestDeliveryDate;
	}

	public void setEarliestDeliveryDate(Date earliestDeliveryDate) {
		this.earliestDeliveryDate = earliestDeliveryDate;
	}

	@Column(name = "latest_delivery_date")
	public Date getLatestDeliveryDate() {
		return latestDeliveryDate;
	}

	public void setLatestDeliveryDate(Date latestDeliveryDate) {
		this.latestDeliveryDate = latestDeliveryDate;
	}

	@Column(name = "MarketplaceId")
	public String getMarketplaceId() {
		return marketplaceId;
	}

	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}

}