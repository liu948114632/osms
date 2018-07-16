package com.itecheasy.core.fba;

import javax.persistence.Column;

/**
 * @author wanghw
 * @date 2016-11-30
 * @description fba补货单项
 * @version 1.2.2
 */
public class ReplenishmentOrderItem {
	private int id;
	/**
	 * 订购量
	 * 
	 */
	private double orderedQuantity;
	private double preparedQuantity;
	private int cmsProductId;
	private int unitQty;
	private String unit;
	private String cmsProductCode;
	private int fbaShopProductId;
	private String sku;
	private int replenishmentOrderId;
	private double costPrice;
	private String box;
	private String fbaBarcodeName;
	private String fbaBarcodeSku;
	private int status;

	private Double unitWeight;
	private Double unitVolume;

	private Double availableQty;
	private String primaryPictureCode;
	private String colorCardPictureCode;

	/**
	 * 商品备注
	 */
	private String customerRemark;
	/**
	 * 客服备注
	 */
	private String csRemark;

	/**
	 * 分部备注
	 */
	private String branchRemark;
	
	/**
	 * 采购跟单备注
	 */
	private String purchaseRemark;
	
	/**
	 * 是否cms备货 0、否  1、是 2、sw备货
	 */
	private int cmsPrepare;




	/**
	 * 1.	FBA补货订单详细，商品项增加字段“提交AM批量”，默认值等于“订购批量”，可以修改。这个值是修改时传给亚马逊的实际批量。
	 * 2.	老单，“提交AM批量” 初始化等于“订购批量
	 */
	private Double amQuantity;

	public Double getAmQuantity() {
		return amQuantity;
	}

	public void setAmQuantity(Double amQuantity) {
		this.amQuantity = amQuantity;
	}


	public String getPrimaryPictureCode() {
		return primaryPictureCode;
	}

	public void setPrimaryPictureCode(String primaryPictureCode) {
		this.primaryPictureCode = primaryPictureCode;
	}

	public String getColorCardPictureCode() {
		return colorCardPictureCode;
	}

	public void setColorCardPictureCode(String colorCardPictureCode) {
		this.colorCardPictureCode = colorCardPictureCode;
	}

	public Double getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(Double availableQty) {
		this.availableQty = availableQty;
	}

	public Double getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(Double unitWeight) {
		this.unitWeight = unitWeight;
	}

	public Double getUnitVolume() {
		return unitVolume;
	}

	public void setUnitVolume(Double unitVolume) {
		this.unitVolume = unitVolume;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(double orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public double getPreparedQuantity() {
		return preparedQuantity;
	}

	public void setPreparedQuantity(double preparedQuantity) {
		this.preparedQuantity = preparedQuantity;
	}

	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	public int getUnitQty() {
		return unitQty;
	}

	public void setUnitQty(int unitQty) {
		this.unitQty = unitQty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	public int getFbaShopProductId() {
		return fbaShopProductId;
	}

	public void setFbaShopProductId(int fbaShopProductId) {
		this.fbaShopProductId = fbaShopProductId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getReplenishmentOrderId() {
		return replenishmentOrderId;
	}

	public void setReplenishmentOrderId(int replenishmentOrderId) {
		this.replenishmentOrderId = replenishmentOrderId;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public String getBox() {
		return box;
	}

	public void setBox(String box) {
		this.box = box;
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

	public String getCustomerRemark() {
		return customerRemark;
	}

	public void setCustomerRemark(String customerRemark) {
		this.customerRemark = customerRemark;
	}

	public String getCsRemark() {
		return csRemark;
	}

	public void setCsRemark(String csRemark) {
		this.csRemark = csRemark;
	}

	public String getBranchRemark() {
		return branchRemark;
	}

	public void setBranchRemark(String branchRemark) {
		this.branchRemark = branchRemark;
	}

	public String getPurchaseRemark() {
		return purchaseRemark;
	}

	public void setPurchaseRemark(String purchaseRemark) {
		this.purchaseRemark = purchaseRemark;
	}

	public int getCmsPrepare() {
		return cmsPrepare;
	}

	public void setCmsPrepare(int cmsPrepare) {
		this.cmsPrepare = cmsPrepare;
	}
	
}
