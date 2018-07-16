package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "shop_info")
public class ShopInfoPo {
	private int id;
	private String currency;
	private int language;
	private String productType;
	private String browseNode;
	private int shopId;
	private String webserviceUrl;
	private Integer customerId;
	private Integer shopSource;
	private String merchandiserId;

	private Integer timeDiff;
	private String ebaySellerId;
	private String fbaBarcodeKey;
	
	/**
	 * 是否填充省
	 * 省为空时自动将城市填充到省中
	 */
	private boolean fillState;

	@Column(name="fba_barcode_key")
	public String getFbaBarcodeKey() {
		return fbaBarcodeKey;
	}

	public void setFbaBarcodeKey(String fbaBarcodeKey) {
		this.fbaBarcodeKey = fbaBarcodeKey;
	}

	@Column(name = "ebay_seller_id")
	public String getEbaySellerId() {
		return ebaySellerId;
	}

	public void setEbaySellerId(String ebaySellerId) {
		this.ebaySellerId = ebaySellerId;
	}

	@Column(name = "time_diff")
	public Integer getTimeDiff() {
		return timeDiff;
	}

	public void setTimeDiff(Integer timeDiff) {
		this.timeDiff = timeDiff;
	}

	public void setPurchase(boolean isPurchase) {
		this.isPurchase = isPurchase;
	}

	/**
	 * 是否走采购流程
	 */
	private boolean isPurchase;

	@Column(name = "is_purchase")
	public boolean getIsPurchase() {
		return isPurchase;
	}

	public void setIsPurchase(boolean isPurchase) {
		this.isPurchase = isPurchase;
	}

	@Column(name = "customer_id")
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "shop_source")
	public Integer getShopSource() {
		return shopSource;
	}

	public void setShopSource(Integer shopSource) {
		this.shopSource = shopSource;
	}

	@Column(name = "webservice_url")
	public String getWebserviceUrl() {
		return webserviceUrl;
	}

	public void setWebserviceUrl(String webserviceUrl) {
		this.webserviceUrl = webserviceUrl;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "currency")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "language")
	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	@Column(name = "product_type")
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Column(name = "browse_nodes")
	public String getBrowseNode() {
		return browseNode;
	}

	public void setBrowseNode(String browseNode) {
		this.browseNode = browseNode;
	}

	@Column(name = "shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Column(name = "merchandiser_id")
	public String getMerchandiserId() {
		return merchandiserId;
	}

	public void setMerchandiserId(String merchandiserId) {
		this.merchandiserId = merchandiserId;
	}

	@Column(name="fill_state")
	public boolean isFillState() {
		return fillState;
	}

	public void setFillState(boolean fillState) {
		this.fillState = fillState;
	}

	
}
