package com.itecheasy.core.po;

import java.math.BigDecimal;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "product")
public class ProductPo {
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
	private int batchId;
	private String description;
	private double volume;

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "cms_product_id")
	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	@Column(name = "cms_product_code")
	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	@Column(name = "category_id_1")
	public Integer getCategoryId1() {
		return categoryId1;
	}

	public void setCategoryId1(Integer categoryId1) {
		this.categoryId1 = categoryId1;
	}

	@Column(name = "category_id_2")
	public Integer getCategoryId2() {
		return categoryId2;
	}

	public void setCategoryId2(Integer categoryId2) {
		this.categoryId2 = categoryId2;
	}

	@Column(name = "category_id_3")
	public Integer getCategoryId3() {
		return categoryId3;
	}

	public void setCategoryId3(Integer categoryId3) {
		this.categoryId3 = categoryId3;
	}

	@Column(name = "is_small_quantities")
	public Boolean getIsSamllQuantities() {
		return isSamllQuantities;
	}

	public void setIsSamllQuantities(Boolean isSamllQuantities) {
		this.isSamllQuantities = isSamllQuantities;
	}

	@Column(name = "is_pool")
	public Boolean getIspool() {
		return ispool;
	}

	public void setIspool(Boolean ispool) {
		this.ispool = ispool;
	}

	@Column(name = "is_gift")
	public Boolean getIsGift() {
		return isGift;
	}

	public void setIsGift(Boolean isGift) {
		this.isGift = isGift;
	}

	@Column(name = "is_mix")
	public int getIsMix() {
		return isMix;
	}

	public void setIsMix(int isMix) {
		this.isMix = isMix;
	}

	@Column(name = "primary_picture_code")
	public String getPrimaryPictureCode() {
		return primaryPictureCode;
	}

	public void setPrimaryPictureCode(String primaryPictureCode) {
		this.primaryPictureCode = primaryPictureCode;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "unit")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "unit_quantity")
	public int getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(int unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	@Column(name = "weight")
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Column(name = "cost_price")
	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	@Column(name = "ph_price")
	public BigDecimal getPhPrice() {
		return phPrice;
	}

	public void setPhPrice(BigDecimal phPrice) {
		this.phPrice = phPrice;
	}

	@Column(name = "status")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "picture_status")
	public boolean isPictureStatus() {
		return pictureStatus;
	}

	public void setPictureStatus(boolean pictureStatus) {
		this.pictureStatus = pictureStatus;
	}

	@Column(name = "ph_product_id")
	public int getPhProductId() {
		return phProductId;
	}

	public void setPhProductId(int phProductId) {
		this.phProductId = phProductId;
	}

	@Column(name = "add_user_id")
	public int getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(int addUserId) {
		this.addUserId = addUserId;
	}

	@Column(name = "last_category_name")
	public String getLastCategoryName() {
		return lastCategoryName;
	}

	public void setLastCategoryName(String lastCategoryName) {
		this.lastCategoryName = lastCategoryName;
	}

	@Column(name = "department")
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Column(name = "series")
	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	@Column(name = "batch_id")
	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

}
