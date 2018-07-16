package com.itecheasy.core.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-3-14
 * @description TODO
 * @version 1.1.7
 */
@Entity
@Table(name = "FBA_store_product_report")
public class FBAStoreProductReportPO {
	private int fbaStoreProductId;
	/**
	 * 7天销量
	 */
	private Integer salesFor7days;
	private Integer salesFor14days;
	private Integer salesFor28days;

	/**
	 * 未来7天销量
	 */
	private Integer salesForTheNext7days;
	private Integer salesForTheNext14days;
	private Integer salesForTheNext28days;

	/**
	 * 42天销量预期补货数
	 */
	private Integer expectReplenishmentForTheNext42days;
	private Integer expectReplenishmentForTheNext70days;
	/**
	 * 7天增长率
	 */
	private BigDecimal growthRateFor7days;

	/**
	 * 库存可用天数<em>	当前可用库存数 /7天销量
	 */
	private Integer inventoryOfAvailableDays;

	/**
	 * 无销量天数
	 */
	private Integer noSalesDays;
	
	private Date reportDate;
	
	
	@Column
	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	@Id
	@Column(name="fba_store_product_id")
	public int getFbaStoreProductId() {
		return fbaStoreProductId;
	}

	public void setFbaStoreProductId(int fbaStoreProductId) {
		this.fbaStoreProductId = fbaStoreProductId;
	}

	@Column
	public Integer getSalesFor7days() {
		return salesFor7days;
	}

	public void setSalesFor7days(Integer salesFor7days) {
		this.salesFor7days = salesFor7days;
	}

	@Column
	public Integer getSalesFor14days() {
		return salesFor14days;
	}

	public void setSalesFor14days(Integer salesFor14days) {
		this.salesFor14days = salesFor14days;
	}

	@Column
	public Integer getSalesFor28days() {
		return salesFor28days;
	}

	public void setSalesFor28days(Integer salesFor28days) {
		this.salesFor28days = salesFor28days;
	}

	@Column
	public Integer getSalesForTheNext7days() {
		return salesForTheNext7days;
	}

	public void setSalesForTheNext7days(Integer salesForTheNext7days) {
		this.salesForTheNext7days = salesForTheNext7days;
	}

	@Column
	public Integer getSalesForTheNext14days() {
		return salesForTheNext14days;
	}

	public void setSalesForTheNext14days(Integer salesForTheNext14days) {
		this.salesForTheNext14days = salesForTheNext14days;
	}

	@Column
	public Integer getSalesForTheNext28days() {
		return salesForTheNext28days;
	}

	public void setSalesForTheNext28days(Integer salesForTheNext28days) {
		this.salesForTheNext28days = salesForTheNext28days;
	}

	@Column
	public Integer getExpectReplenishmentForTheNext42days() {
		return expectReplenishmentForTheNext42days;
	}

	public void setExpectReplenishmentForTheNext42days(Integer expectReplenishmentForTheNext42days) {
		this.expectReplenishmentForTheNext42days = expectReplenishmentForTheNext42days;
	}

	@Column
	public Integer getExpectReplenishmentForTheNext70days() {
		return expectReplenishmentForTheNext70days;
	}

	public void setExpectReplenishmentForTheNext70days(Integer expectReplenishmentForTheNext70days) {
		this.expectReplenishmentForTheNext70days = expectReplenishmentForTheNext70days;
	}

	@Column
	public BigDecimal getGrowthRateFor7days() {
		return growthRateFor7days;
	}

	public void setGrowthRateFor7days(BigDecimal growthRateFor7days) {
		this.growthRateFor7days = growthRateFor7days;
	}

	@Column
	public Integer getInventoryOfAvailableDays() {
		return inventoryOfAvailableDays;
	}

	public void setInventoryOfAvailableDays(Integer inventoryOfAvailableDays) {
		this.inventoryOfAvailableDays = inventoryOfAvailableDays;
	}

	@Column
	public Integer getNoSalesDays() {
		return noSalesDays;
	}

	public void setNoSalesDays(Integer noSalesDays) {
		this.noSalesDays = noSalesDays;
	}

}
