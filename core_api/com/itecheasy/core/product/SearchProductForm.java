package com.itecheasy.core.product;

import java.util.List;

/**
 * @author wanghw
 * @date 2015-3-25
 * @description 网店销售产品列表查询条件
 * @version
 */
public class SearchProductForm {
	private int department;
	private int category1;
	private int category2;
	private int category3;
	private String productCode;
	private List<String> productCodes;
	private int seriesId;
	private int isSmallQuantities;
	private int isPool;
	private int isMix;
	private int isGift;
	private int shopId;
	private int status;
	private int freezeStatus;
	private String name;
	private int batchId;

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getCategory1() {
		return category1;
	}

	public void setCategory1(int category1) {
		this.category1 = category1;
	}

	public int getCategory2() {
		return category2;
	}

	public void setCategory2(int category2) {
		this.category2 = category2;
	}

	public int getCategory3() {
		return category3;
	}

	public void setCategory3(int category3) {
		this.category3 = category3;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public List<String> getProductCodes() {
		return productCodes;
	}

	public void setProductCodes(List<String> productCodes) {
		this.productCodes = productCodes;
	}

	public int getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}

	public int getIsSmallQuantities() {
		return isSmallQuantities;
	}

	public void setIsSmallQuantities(int isSmallQuantities) {
		this.isSmallQuantities = isSmallQuantities;
	}

	public int getIsPool() {
		return isPool;
	}

	public void setIsPool(int isPool) {
		this.isPool = isPool;
	}

	public int getIsMix() {
		return isMix;
	}

	public void setIsMix(int isMix) {
		this.isMix = isMix;
	}

	public int getIsGift() {
		return isGift;
	}

	public void setIsGift(int isGift) {
		this.isGift = isGift;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFreezeStatus() {
		return freezeStatus;
	}

	public void setFreezeStatus(int freezeStatus) {
		this.freezeStatus = freezeStatus;
	}

}
