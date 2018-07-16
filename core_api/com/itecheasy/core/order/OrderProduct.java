package com.itecheasy.core.order;

/**
 * @author wanghw
 * @date 2015-5-9
 * @description 订单商品项
 * @version
 */
public class OrderProduct {
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
	 */
	private int cmsProductId;
	/**
	 * 网店商品的购买价
	 * 
	 */
	private double shopItemPrice;
	
	/**
	 * 运费
	 */
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

	private String title;
	private int amShopProductId;

	/**
	 * 订单商品项的备货信息
	 */
	private OrderPrepareProduct orderPrepareProduct;

	private String cmsProductCode;

	private Integer productId;

	private Double unitWeight;
	private Double unitVolume;

	/**
	 * 是否受限制
	 */
	private Boolean islimit;

	private boolean electronic;

	/**
	 * 带磁
	 */
	private boolean magnetism;

	/**
	 * 纺织品
	 */
	private boolean textile;

	private int orderId;

	private String transactionId;

	private String shopItemTitle;

	private String shopOrderLineItemId;

	/**
	 * 店铺sku
	 */
	private String shopSellerSku;
	
	/**
	 * sw商品
	 */
	private boolean isProductSw;

	public String getShopSellerSku() {
		return shopSellerSku;
	}

	public void setShopSellerSku(String shopSellerSku) {
		this.shopSellerSku = shopSellerSku;
	}

	public String getShopOrderLineItemId() {
		return shopOrderLineItemId;
	}

	public void setShopOrderLineItemId(String shopOrderLineItemId) {
		this.shopOrderLineItemId = shopOrderLineItemId;
	}

	public String getShopItemTitle() {
		return shopItemTitle;
	}

	public void setShopItemTitle(String shopItemTitle) {
		this.shopItemTitle = shopItemTitle;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public boolean isMagnetism() {
		return magnetism;
	}

	public void setMagnetism(boolean magnetism) {
		this.magnetism = magnetism;
	}

	public boolean isTextile() {
		return textile;
	}

	public void setTextile(boolean textile) {
		this.textile = textile;
	}

	/**
	 * 赠品，（手动添加的商品项）
	 */
	private boolean gift;

	public boolean isGift() {
		return gift;
	}

	public void setGift(boolean gift) {
		this.gift = gift;
	}

	public boolean isElectronic() {
		return electronic;
	}

	public void setElectronic(boolean electronic) {
		this.electronic = electronic;
	}

	public Boolean getIslimit() {
		return islimit;
	}

	public void setIslimit(Boolean islimit) {
		this.islimit = islimit;
	}

	/**
	 * 是否cms备货
	 */
	private int cmsPrepare;

	/**
	 * 非正常匹配
	 */
	private boolean abnormalMate;

	private boolean isProductTs;

	private String shopSellRecordNumber;

	public String getShopSellRecordNumber() {
		return shopSellRecordNumber;
	}

	public void setShopSellRecordNumber(String shopSellRecordNumber) {
		this.shopSellRecordNumber = shopSellRecordNumber;
	}

	public boolean isProductTs() {
		return isProductTs;
	}

	public void setProductTs(boolean isProductTs) {
		this.isProductTs = isProductTs;
	}

	public boolean isAbnormalMate() {
		return abnormalMate;
	}

	public void setAbnormalMate(boolean abnormalMate) {
		this.abnormalMate = abnormalMate;
	}

	public int getCmsPrepare() {
		return cmsPrepare;
	}

	private String shopOrderItemId;

	public String getShopOrderItemId() {
		return shopOrderItemId;
	}

	public void setShopOrderItemId(String shopOrderItemId) {
		this.shopOrderItemId = shopOrderItemId;
	}

	public void setCmsPrepare(int cmsPrepare) {
		this.cmsPrepare = cmsPrepare;
	}

	/**
	 * 订单商品项的状态
	 * 
	 * @see OrderService.OrderProductStatus
	 */
	private Integer status;

	private double costPrice;

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(Double unitWeight) {
		this.unitWeight = unitWeight;
	}

	public Double getUnitVolume() {
		return unitVolume;
	}

	public void setUnitVolume(Double unitVolume) {
		this.unitVolume = unitVolume;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	private int objectId;

	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAmShopProductId() {
		return amShopProductId;
	}

	public void setAmShopProductId(int amShopProductId) {
		this.amShopProductId = amShopProductId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShippedQty() {
		return shippedQty;
	}

	public void setShippedQty(int shippedQty) {
		this.shippedQty = shippedQty;
	}

	public int getShopQuantityOrdered() {
		return shopQuantityOrdered;
	}

	public void setShopQuantityOrdered(int shopQuantityOrdered) {
		this.shopQuantityOrdered = shopQuantityOrdered;
	}

	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	public double getShopItemPrice() {
		return shopItemPrice;
	}

	public void setShopItemPrice(double shopItemPrice) {
		this.shopItemPrice = shopItemPrice;
	}

	public int getShopItemCurtype() {
		return shopItemCurtype;
	}

	public void setShopItemCurtype(int shopItemCurtype) {
		this.shopItemCurtype = shopItemCurtype;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public int getUnitQty() {
		return unitQty;
	}

	public void setUnitQty(int unitQty) {
		this.unitQty = unitQty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getShopDiscount() {
		return shopDiscount;
	}

	public void setShopDiscount(double shopDiscount) {
		this.shopDiscount = shopDiscount;
	}

	public OrderPrepareProduct getOrderPrepareProduct() {
		return orderPrepareProduct;
	}

	public void setOrderPrepareProduct(OrderPrepareProduct orderPrepareProduct) {
		this.orderPrepareProduct = orderPrepareProduct;
	}

	public boolean isProductSw() {
		return isProductSw;
	}

	public void setProductSw(boolean isProductSw) {
		this.isProductSw = isProductSw;
	}

	public double getShopItemShippingPrice() {
		return shopItemShippingPrice;
	}

	public void setShopItemShippingPrice(double shopItemShippingPrice) {
		this.shopItemShippingPrice = shopItemShippingPrice;
	}

	
}
