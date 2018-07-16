package com.itecheasy.core.fba;

/**
 * @author wanghw
 * @date 2016-11-30
 * @description 与fba有关的cms商品
 * @version 1.2.2
 */
public class FbaRelatedCMSProduct {
	private Integer shopId;
	private String shopName;
	private String sku;
	private String fbaBarcodeName;
	private String fbaBarcodeSku;
	private Integer fbaShopProductId;

	private int cmsProductId;
	private String cmsProductCode;

	private String productName;
	private Integer unitQuantity;

	private String primaryPictureCode;
	private String unit;

	private Integer fbaSecurityLine;
	private Integer sumSecurityLine;

	private Integer fbaAvailableStock;

	private int cmsAwaitReplenishment;
	private int cmsTheReplenishment;
	private double availableStock;

	private boolean parent;
	
	/**
	 * 商品销量
	 */
	private int sales;

	public boolean isParent() {
		return parent;
	}

	public void setParent(boolean parent) {
		this.parent = parent;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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

	public Integer getFbaShopProductId() {
		return fbaShopProductId;
	}

	public void setFbaShopProductId(Integer fbaShopProductId) {
		this.fbaShopProductId = fbaShopProductId;
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

	public Integer getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(Integer unitQuantity) {
		this.unitQuantity = unitQuantity;
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

	public Integer getFbaSecurityLine() {
		return fbaSecurityLine;
	}

	public void setFbaSecurityLine(Integer fbaSecurityLine) {
		this.fbaSecurityLine = fbaSecurityLine;
	}

	public Integer getSumSecurityLine() {
		return sumSecurityLine;
	}

	public void setSumSecurityLine(Integer sumSecurityLine) {
		this.sumSecurityLine = sumSecurityLine;
	}

	public Integer getFbaAvailableStock() {
		return fbaAvailableStock;
	}

	public void setFbaAvailableStock(Integer fbaAvailableStock) {
		this.fbaAvailableStock = fbaAvailableStock;
	}

	public int getCmsAwaitReplenishment() {
		return cmsAwaitReplenishment;
	}

	public void setCmsAwaitReplenishment(int cmsAwaitReplenishment) {
		this.cmsAwaitReplenishment = cmsAwaitReplenishment;
	}

	public int getCmsTheReplenishment() {
		return cmsTheReplenishment;
	}

	public void setCmsTheReplenishment(int cmsTheReplenishment) {
		this.cmsTheReplenishment = cmsTheReplenishment;
	}

	public double getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(double availableStock) {
		this.availableStock = availableStock;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	
}
