package com.itecheasy.core.product;

import java.math.BigDecimal;

/**
 * @author wanghw
 * @date 2015-3-25
 * @description TODO
 * @version
 */
public class Product {
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
	private boolean status;
	private boolean pictureStatus;
	private int addUserId;
	private int departmentId;
	private int series;
	private double volume;
	
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isPictureStatus() {
		return pictureStatus;
	}

	public void setPictureStatus(boolean pictureStatus) {
		this.pictureStatus = pictureStatus;
	}

	public int getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(int addUserId) {
		this.addUserId = addUserId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

}
