package com.itecheasy.core.product;

import java.util.List;

/**
 * @author wanghw
 * @date 2015-3-25
 * @description 店铺商品查询条件
 * @version 1.0.0
 */
public class SearchShopProductForm {
	private String productCode;
	private List<String> productCodes;
	private String productName;
	private int shopId;
	private String productType;
	private String BrowseNode;
	private int uploadStatus;
	private int shelveStatus;
	private int pictureStatus;
	private int contextStatus;
	private int batchId;
	private String sku;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getBrowseNode() {
		return BrowseNode;
	}

	public void setBrowseNode(String browseNode) {
		BrowseNode = browseNode;
	}

	public int getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(int uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	public int getShelveStatus() {
		return shelveStatus;
	}

	public void setShelveStatus(int shelveStatus) {
		this.shelveStatus = shelveStatus;
	}

	public int getPictureStatus() {
		return pictureStatus;
	}

	public void setPictureStatus(int pictureStatus) {
		this.pictureStatus = pictureStatus;
	}

	public int getContextStatus() {
		return contextStatus;
	}

	public void setContextStatus(int contextStatus) {
		this.contextStatus = contextStatus;
	}

}
