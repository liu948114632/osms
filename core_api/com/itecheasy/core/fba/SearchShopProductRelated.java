package com.itecheasy.core.fba;

import java.util.List;

/**
 * @author wanghw
 * @date 2016-11-29
 * @description TODO
 * @version 1.2.2
 */
public class SearchShopProductRelated {
	private int currentPage;
	private int pageSize;
	private int shopId;
	private String sku;



	private List<String> skus;
	private String cmsProductCode;
	private List<String> cmsProductCodes;
	private int status;

	private int hasSeaTransportBlackList;


	public int getHasSeaTransportBlackList() {
		return hasSeaTransportBlackList;
	}

	public void setHasSeaTransportBlackList(int hasSeaTransportBlackList) {
		this.hasSeaTransportBlackList = hasSeaTransportBlackList;
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

	public List<String> getSkus() {
		return skus;
	}

	public void setSkus(List<String> skus) {
		this.skus = skus;
	}

	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	public List<String> getCmsProductCodes() {
		return cmsProductCodes;
	}

	public void setCmsProductCodes(List<String> cmsProductCodes) {
		this.cmsProductCodes = cmsProductCodes;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
