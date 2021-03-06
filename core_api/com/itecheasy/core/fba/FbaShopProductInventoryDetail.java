package com.itecheasy.core.fba;

import java.math.BigDecimal;

/**
 * @author wanghw
 * @date 2016-11-30
 * @description TODO
 * @version 1.2.2
 */
public class FbaShopProductInventoryDetail {
	private String sku;
	
	private String cmsProductCode;

	private String fbaBarcodeName;
	private String fbaBarcodeSku;

	private int fbaSecurityLine;
	private int sumSecurityLine;

	private int cmsProductId;
	private String productName;
	private int unitQuantity;

	private int status;
	private String primaryPictureCode;	//图片地址
	private String unit;

	/**
	 * 是否修改FBA警戒库存
	 */
	private boolean updateFbaSecurityLine;

	/**
	 * 是否修改总警戒库存
	 */
	private boolean updateSumSecurityLine;

	/**
	 * 是否提醒fba补货
	 */
	private boolean remindFbaReplenishment;

	private int fbaAwaitReplenishment;
	private int fbaTheReplenishment;
	private int fbaAvailableStock;

	private int daysSales;
	private BigDecimal costPrice;
	private int availableStock;
	private int fbaShopProductId;

	private int seaTransportationBlacklistStatus; //非海运黑名单=0 ,黑名单=1

	public int getSeaTransportationBlacklistStatus() {
		return seaTransportationBlacklistStatus;
	}

	public void setSeaTransportationBlacklistStatus(int seaTransportationBlacklistStatus) {
		this.seaTransportationBlacklistStatus = seaTransportationBlacklistStatus;
	}

	public int getFbaShopProductId() {
		return fbaShopProductId;
	}

	public void setFbaShopProductId(int fbaShopProductId) {
		this.fbaShopProductId = fbaShopProductId;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public int getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
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

	public int getFbaSecurityLine() {
		return fbaSecurityLine;
	}

	public void setFbaSecurityLine(int fbaSecurityLine) {
		this.fbaSecurityLine = fbaSecurityLine;
	}

	public int getSumSecurityLine() {
		return sumSecurityLine;
	}

	public void setSumSecurityLine(int sumSecurityLine) {
		this.sumSecurityLine = sumSecurityLine;
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

	public boolean isUpdateFbaSecurityLine() {
		return updateFbaSecurityLine;
	}

	public void setUpdateFbaSecurityLine(boolean updateFbaSecurityLine) {
		this.updateFbaSecurityLine = updateFbaSecurityLine;
	}

	public boolean isUpdateSumSecurityLine() {
		return updateSumSecurityLine;
	}

	public void setUpdateSumSecurityLine(boolean updateSumSecurityLine) {
		this.updateSumSecurityLine = updateSumSecurityLine;
	}

	public boolean isRemindFbaReplenishment() {
		return remindFbaReplenishment;
	}

	public void setRemindFbaReplenishment(boolean remindFbaReplenishment) {
		this.remindFbaReplenishment = remindFbaReplenishment;
	}

	public int getFbaAwaitReplenishment() {
		return fbaAwaitReplenishment;
	}

	public void setFbaAwaitReplenishment(int fbaAwaitReplenishment) {
		this.fbaAwaitReplenishment = fbaAwaitReplenishment;
	}

	public int getFbaTheReplenishment() {
		return fbaTheReplenishment;
	}

	public void setFbaTheReplenishment(int fbaTheReplenishment) {
		this.fbaTheReplenishment = fbaTheReplenishment;
	}

	public int getFbaAvailableStock() {
		return fbaAvailableStock;
	}

	public void setFbaAvailableStock(int fbaAvailableStock) {
		this.fbaAvailableStock = fbaAvailableStock;
	}

	public int getDaysSales() {
		return daysSales;
	}

	public void setDaysSales(int daysSales) {
		this.daysSales = daysSales;
	}

}
