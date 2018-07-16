package com.itecheasy.core.fba;

/**
 * @author wanghw
 * @date 2016-11-29
 * @description fba店铺商品
 * @version 1.2.2
 */
public class FbaShopProduct {

	private int id;
	private int shopId;
	private String sku;
	private String fbaBarcodeName;
	private String fbaBarcodeSku;

	private int cmsProductId;
	private String cmsProductCode;
	private int status;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
