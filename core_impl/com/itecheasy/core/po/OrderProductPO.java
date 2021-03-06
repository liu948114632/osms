package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * 订单商品表
 * 
 */
@Entity
@Table(name = "order_product")
public class OrderProductPO {
	private int id;
	/**
	 * 商品的已配送数量
	 * 
	 */
	private int shippedQty;
	/**
	 * 网店订购量
	 * 
	 */
	private int shopQuantityOrdered;
	/**
	 * cms商品id
	 * 
	 */
	private int cmsProductId;
	/**
	 * 网店商品的购买价
	 * 
	 */
	private double shopItemPrice;
	
	private double shopItemShippingPrice;
	/**
	 * 商品币种
	 * 
	 */
	private int shopItemCurtype;
	/**
	 * 网店商品描述
	 * 
	 */
	private String productDetail;
	/**
	 * 批量数
	 * 
	 */
	private int unitQty;
	/**
	 * 批量单位
	 * 
	 */
	private String unit;
	/**
	 * 网站商品折扣
	 * 
	 */
	private double shopDiscount;

	private int orderId;

	private Integer amShopProductId;

	private String cmsProductCode;

	private boolean cancel;

	private Integer productId;

	private String shopOrderItemId;

	/**
	 * 赠品，（手动添加的商品项）
	 */
	private boolean gift;

	private String transactionId;

	private String shopItemTitle;

	private String shopOrderLineItemId;
	
	private String shopSellRecordNumber;
	
	private String shopSellerSku;


	private String productChineseName;	//品名中文

	private String	productEnglishName;	//品名英文


//	private Integer	hadSpareCapacity;	//已备量

//	@Column(name="had_spare_capacity")
//	public Integer getHadSpareCapacity() {
//		return hadSpareCapacity;
//	}
//
//	public void setHadSpareCapacity(Integer hadSpareCapacity) {
//		this.hadSpareCapacity = hadSpareCapacity;
//	}

	@Column(name="product_chinese_name")
	public String getProductChineseName() {
		return productChineseName;
	}

	public void setProductChineseName(String productChineseName) {
		this.productChineseName = productChineseName;
	}

	@Column(name="product_english_name")
	public String getProductEnglishName() {
		return productEnglishName;
	}

	public void setProductEnglishName(String productEnglishName) {
		this.productEnglishName = productEnglishName;
	}

	@Column(name="shop_seller_sku")
	public String getShopSellerSku() {
		return shopSellerSku;
	}

	public void setShopSellerSku(String shopSellerSku) {
		this.shopSellerSku = shopSellerSku;
	}

	@Column(name="shop_sell_record_number")
	public String getShopSellRecordNumber() {
		return shopSellRecordNumber;
	}

	public void setShopSellRecordNumber(String shopSellRecordNumber) {
		this.shopSellRecordNumber = shopSellRecordNumber;
	}

	@Column(name="shop_order_line_item_id")
	public String getShopOrderLineItemId() {
		return shopOrderLineItemId;
	}

	public void setShopOrderLineItemId(String shopOrderLineItemId) {
		this.shopOrderLineItemId = shopOrderLineItemId;
	}

	@Column(name = "shop_item_title")
	public String getShopItemTitle() {
		return shopItemTitle;
	}

	public void setShopItemTitle(String shopItemTitle) {
		this.shopItemTitle = shopItemTitle;
	}

	@Column(name = "is_gift")
	public boolean isGift() {
		return gift;
	}

	@Column(name = "transaction_id")
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setGift(boolean gift) {
		this.gift = gift;
	}

	@Column(name = "shop_order_item_id")
	public String getShopOrderItemId() {
		return shopOrderItemId;
	}

	public void setShopOrderItemId(String shopOrderItemId) {
		this.shopOrderItemId = shopOrderItemId;
	}

	@Column(name = "product_id")
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name = "cms_product_code")
	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	@Column(name = "order_id")
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "am_shop_product_id")
	public Integer getAmShopProductId() {
		return amShopProductId;
	}

	public void setAmShopProductId(Integer amShopProductId) {
		this.amShopProductId = amShopProductId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "shop_shipped_qty")
	public int getShippedQty() {
		return shippedQty;
	}

	public void setShippedQty(int shippedQty) {
		this.shippedQty = shippedQty;
	}

	@Column(name = "shop_quantity_Ordered")
	public int getShopQuantityOrdered() {
		return shopQuantityOrdered;
	}

	public void setShopQuantityOrdered(int shopQuantityOrdered) {
		this.shopQuantityOrdered = shopQuantityOrdered;
	}

	@Column(name = "cms_product_id")
	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	@Column(name = "shop_item_price")
	public double getShopItemPrice() {
		return shopItemPrice;
	}

	public void setShopItemPrice(double shopItemPrice) {
		this.shopItemPrice = shopItemPrice;
	}

	@Column(name = "shop_item_curtype")
	public int getShopItemCurtype() {
		return shopItemCurtype;
	}

	public void setShopItemCurtype(int shopItemCurtype) {
		this.shopItemCurtype = shopItemCurtype;
	}

	@Column(name = "product_detail")
	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	@Column(name = "unit_qty")
	public int getUnitQty() {
		return unitQty;
	}

	public void setUnitQty(int unitQty) {
		this.unitQty = unitQty;
	}

	@Column(name = "unit")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "shop_discount")
	public double getShopDiscount() {
		return shopDiscount;
	}

	public void setShopDiscount(double shopDiscount) {
		this.shopDiscount = shopDiscount;
	}

	@Column(name = "is_cancel")
	public boolean getCancel() {
		return cancel;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	@Column(name="shop_item_shipping_price")
	public double getShopItemShippingPrice() {
		return shopItemShippingPrice;
	}

	public void setShopItemShippingPrice(double shopItemShippingPrice) {
		this.shopItemShippingPrice = shopItemShippingPrice;
	}

	
}