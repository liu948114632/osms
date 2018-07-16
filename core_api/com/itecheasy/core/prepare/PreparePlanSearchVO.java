package com.itecheasy.core.prepare;

/**
 * @author taozihao
 * @date 2018年6月30日 下午1:04:54
 * @description 海运计划查询
 */
public class PreparePlanSearchVO {
	private int shopId;
	private int status;
	private int prepareType;
	private String sku;
	private int currentPage;
	private int pageSize;

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

	public int getPrepareType() {
		return prepareType;
	}

	public void setPrepareType(int prepareType) {
		this.prepareType = prepareType;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
