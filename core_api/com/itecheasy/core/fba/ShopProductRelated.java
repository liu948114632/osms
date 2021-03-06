package com.itecheasy.core.fba;

/**
 * @author wanghw
 * @date 2016-11-29
 * @description TODO
 * @version 1.2.2
 */
public class ShopProductRelated {
	private int id;
	private int shopId;
	private int cmsProductId;
	private String cmsProductCode;
	private String productName;
	private int unitQuantity;

	private String sku;
	private String fbaBarcodeName;
	private String fbaBarcodeSku;

	private int status;
	private String primaryPictureCode;
	private String unit;

	private double availableQuantity;

	/**
	 * 商品是否走过海运 没走过=0 ,走过=1
	 */
//	private int hasSeaTransported;
	/**
	 * 是否海运黑名单   非海运黑名单=0 ,黑名单=1
	 */
	private int isSeaTransportationBlacklist;



	public int getIsSeaTransportationBlacklist() {
		return isSeaTransportationBlacklist;
	}

	public void setIsSeaTransportationBlacklist(int isSeaTransportationBlacklist) {
		this.isSeaTransportationBlacklist = isSeaTransportationBlacklist;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPrimaryPictureCode() {
		return primaryPictureCode;
	}

	public void setPrimaryPictureCode(String primaryPictureCode) {
		this.primaryPictureCode = primaryPictureCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(int unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getFbaBarcodeName() {
		return fbaBarcodeName;
	}

	public void setFbaBarcodeName(String fbaBarcodeName) {
		this.fbaBarcodeName = fbaBarcodeName;
	}

	public String getFbaBarcodeSku() {
		return fbaBarcodeSku;
	}

	public void setFbaBarcodeSku(String fbaBarcodeSku) {
		this.fbaBarcodeSku = fbaBarcodeSku;
	}

	public double getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
}
