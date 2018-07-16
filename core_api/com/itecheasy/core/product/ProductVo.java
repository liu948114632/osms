package com.itecheasy.core.product;

import java.math.BigDecimal;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
public class ProductVo {
	private int id;
	private int cmsProductId;
	private int phProductId;
	private String cmsProductCode;
	private Integer categoryId1;
	private Integer categoryId2;
	private Integer categoryId3;
	private String lastCategoryName;
	private Boolean isSamllQuantities;
	private Boolean ispool;
	private int isMix;
	private Boolean isGift;
	private String primaryPictureCode;
	private String name;
	private String unit;
	private int unitQuantity;
	private double weight;
	private BigDecimal costPrice;
	private BigDecimal phPrice;
	private Boolean status;
	private int pictureStatus;
	private int safetyStock;
	private Double availableStock;
	private Double freezeStock;
	private String addUser;
	private int isMian;
	private int batchId;
	
	private BigDecimal fbaStock; //fba备货库存
	private BigDecimal orderStock;//订单备货库存

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	public int getPhProductId() {
		return phProductId;
	}

	public void setPhProductId(int phProductId) {
		this.phProductId = phProductId;
	}

	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	public Integer getCategoryId1() {
		return categoryId1;
	}

	public void setCategoryId1(Integer categoryId1) {
		this.categoryId1 = categoryId1;
	}

	public Integer getCategoryId2() {
		return categoryId2;
	}

	public void setCategoryId2(Integer categoryId2) {
		this.categoryId2 = categoryId2;
	}

	public Integer getCategoryId3() {
		return categoryId3;
	}

	public void setCategoryId3(Integer categoryId3) {
		this.categoryId3 = categoryId3;
	}

	public String getLastCategoryName() {
		return lastCategoryName;
	}

	public void setLastCategoryName(String lastCategoryName) {
		this.lastCategoryName = lastCategoryName;
	}

	public Boolean getIsSamllQuantities() {
		return isSamllQuantities;
	}

	public void setIsSamllQuantities(Boolean isSamllQuantities) {
		this.isSamllQuantities = isSamllQuantities;
	}

	public Boolean getIspool() {
		return ispool;
	}

	public void setIspool(Boolean ispool) {
		this.ispool = ispool;
	}

	public int getIsMix() {
		return isMix;
	}

	public void setIsMix(int isMix) {
		this.isMix = isMix;
	}

	public Boolean getIsGift() {
		return isGift;
	}

	public void setIsGift(Boolean isGift) {
		this.isGift = isGift;
	}

	public String getPrimaryPictureCode() {
		return primaryPictureCode;
	}

	public void setPrimaryPictureCode(String primaryPictureCode) {
		this.primaryPictureCode = primaryPictureCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(int unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getPhPrice() {
		return phPrice;
	}

	public void setPhPrice(BigDecimal phPrice) {
		this.phPrice = phPrice;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public int getPictureStatus() {
		return pictureStatus;
	}

	public void setPictureStatus(int pictureStatus) {
		this.pictureStatus = pictureStatus;
	}

	public int getSafetyStock() {
		return safetyStock;
	}

	public void setSafetyStock(int safetyStock) {
		this.safetyStock = safetyStock;
	}

	public Double getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(Double availableStock) {
		this.availableStock = availableStock;
	}

	public Double getFreezeStock() {
		return freezeStock;
	}

	public void setFreezeStock(Double freezeStock) {
		this.freezeStock = freezeStock;
	}

	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}

	public int getIsMian() {
		return isMian;
	}

	public void setIsMian(int isMian) {
		this.isMian = isMian;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public BigDecimal getFbaStock() {
		return fbaStock;
	}

	public void setFbaStock(BigDecimal fbaStock) {
		this.fbaStock = fbaStock;
	}

	public BigDecimal getOrderStock() {
		return orderStock;
	}

	public void setOrderStock(BigDecimal orderStock) {
		this.orderStock = orderStock;
	}

	
}
