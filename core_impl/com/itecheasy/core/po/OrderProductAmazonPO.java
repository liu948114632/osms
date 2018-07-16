package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * 订单商品，亚马逊的信息
 * 
 */
@Entity
@Table(name="order_product_amazon")
public class OrderProductAmazonPO {
	private int id;

	/**
	 * 商品的卖家sku
	 * 
	 */
	private String sellerSku;
	/**
	 * 商品的amazon商品编码
	 * 
	 */
	private String asin;
	/**
	 * amazon订单商品编号
	 * 
	 */
	private String orderItemId;
	/**
	 * 商品的售价的币种
	 * 
	 */
	private int itemPriceCurrency;
	/**
	 * 商品的售价
	 * 
	 */
	private double itemPrice;
	/**
	 * 商品名称
	 * 
	 */
	private String title;
	/**
	 * 商品的已配送数量
	 * 
	 */
	private int quantityShipped;
	/**
	 * 订购量
	 * 
	 */
	private int quantityOrdered;
	
	/**
	 * 报价中的总促销折扣
	 * 
	 */
	private double promotionDiscount;
	/**
	 * 商品的状况
	 * 
	 */
	private String conditionId;
	/**
	 * 商品的子状况
	 * 
	 */
	private String conditionSubtypeId;
	/**
	 * 商品的配送费用
	 * 
	 */
	private double shippingPrice;
	/**
	 * 商品配送费用所享受的折扣
	 * 
	 */
	private double shippingDiscount;
	
	/**
	 * amaozn标识的订单唯一id
	 */
	private String amazonOrderId;
	
	private int orderAmazonId;
	
	
	@Column(name="order_amazon_id")
	public int getOrderAmazonId() {
		return orderAmazonId;
	}

	public void setOrderAmazonId(int orderAmazonId) {
		this.orderAmazonId = orderAmazonId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	@Column(name="seller_sku")
	public String getSellerSku() {
		return sellerSku;
	}

	@Column(name="amazon_order_Id")
	public String getAmazonOrderId() {
		return amazonOrderId;
	}

	public void setAmazonOrderId(String amazonOrderId) {
		this.amazonOrderId = amazonOrderId;
	}

	public void setSellerSku(String sellerSku) {
		this.sellerSku = sellerSku;
	}

	@Column(name="asin")
	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	@Column(name="order_item_id")
	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	@Column(name="item_price_currency")
	public int getItemPriceCurrency() {
		return itemPriceCurrency;
	}

	public void setItemPriceCurrency(int itemPriceCurrency) {
		this.itemPriceCurrency = itemPriceCurrency;
	}

	@Column(name="item_price")
	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="quantity_Shipped")
	public int getQuantityShipped() {
		return quantityShipped;
	}

	public void setQuantityShipped(int quantityShipped) {
		this.quantityShipped = quantityShipped;
	}

	@Column(name="quantity_Ordered")
	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	@Column(name="PromotionDiscount")
	public double getPromotionDiscount() {
		return promotionDiscount;
	}

	public void setPromotionDiscount(double promotionDiscount) {
		this.promotionDiscount = promotionDiscount;
	}

	@Column(name="ConditionId")
	public String getConditionId() {
		return conditionId;
	}

	
	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
	}

	@Column(name="ConditionSubtypeId")
	public String getConditionSubtypeId() {
		return conditionSubtypeId;
	}

	public void setConditionSubtypeId(String conditionSubtypeId) {
		this.conditionSubtypeId = conditionSubtypeId;
	}

	@Column(name="ShippingPrice")
	public double getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	@Column(name="ShippingDiscount")
	public double getShippingDiscount() {
		return shippingDiscount;
	}

	public void setShippingDiscount(double shippingDiscount) {
		this.shippingDiscount = shippingDiscount;
	}


}