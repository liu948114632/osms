package com.itecheasy.core.fba;

import java.math.BigDecimal;

/**
 * @author wanghw
 * @date 2016-11-30
 * @description TODO
 * @version 1.2.2
 */
public class FbaShopProductInventory {
	private String sku;
	private int cmsProductId;
	private String cmsProductCode;

	private String fbaBarcodeName;
	private String fbaBarcodeSku;

	private int fbaSecurityLine;
	private int sumSecurityLine;

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

	private BigDecimal costPrice;
	private int availableStock;
	private int daysSales;
	private int daysSalesAll;

	private int fbaShopProductId;

	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	public int getFbaShopProductId() {
		return fbaShopProductId;
	}

	public void setFbaShopProductId(int fbaShopProductId) {
		this.fbaShopProductId = fbaShopProductId;
	}

	public int getDaysSalesAll() {
		return daysSalesAll;
	}

	public void setDaysSalesAll(int daysSalesAll) {
		this.daysSalesAll = daysSalesAll;
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

	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	public FbaShopProductInventory() {
		super();
	}

	public FbaShopProductInventory(int fbaShopProductId) {
		super();
		this.fbaShopProductId = fbaShopProductId;
	}

	
}
