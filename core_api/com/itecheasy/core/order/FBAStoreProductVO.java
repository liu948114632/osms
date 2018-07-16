package com.itecheasy.core.order;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wanghw
 * @date 2016-3-11
 * @description fba库存商品基础统计
 * @version 1.1.7
 */
public class FBAStoreProductVO extends FBAStoreProduct {
	private int id;
	private int shopId;
	/**
	 * sku
	 */
	private String productCode;

	/**
	 * 导入更新时间
	 */
	private Date updateDate;;
	/**
	 * 可用库存
	 */
	private int availibleStock;

	/**
	 * 最后补货时间
	 */
	private Date lastReplenishDate;

	/**
	 * 状态：0，上架 1，下架
	 */
	private int status;

	/**
	 * 初次入库时间
	 */
	private Date firstInStorageDate;

	/**
	 * 无销量开始时间 
	 * <ul>
	 * 未出过FBA订单的产品为：FBA库存商品导入时间
	 * </ul>
	 * 
	 * <ul>
	 * 已出过FBA订单的产品为：最后一个FBA订单下单时间
	 * </ul>
	 */
	private Date noSalesDate;
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

	public Integer getSalesFor7days() {
		return salesFor7days;
	}

	public void setSalesFor7days(Integer salesFor7days) {
		this.salesFor7days = salesFor7days;
	}

	public BigDecimal getGrowthRateFor7days() {
		return growthRateFor7days;
	}

	public void setGrowthRateFor7days(BigDecimal growthRateFor7days) {
		this.growthRateFor7days = growthRateFor7days;
	}

	public Integer getInventoryOfAvailableDays() {
		return inventoryOfAvailableDays;
	}

	public void setInventoryOfAvailableDays(Integer inventoryOfAvailableDays) {
		this.inventoryOfAvailableDays = inventoryOfAvailableDays;
	}

	public Integer getNoSalesDays() {
		return noSalesDays;
	}

	public void setNoSalesDays(Integer noSalesDays) {
		this.noSalesDays = noSalesDays;
	}

	public Integer getSalesFor14days() {
		return salesFor14days;
	}

	public void setSalesFor14days(Integer salesFor14days) {
		this.salesFor14days = salesFor14days;
	}

	public Integer getSalesFor28days() {
		return salesFor28days;
	}

	public void setSalesFor28days(Integer salesFor28days) {
		this.salesFor28days = salesFor28days;
	}

	public Integer getSalesForTheNext7days() {
		return salesForTheNext7days;
	}

	public void setSalesForTheNext7days(Integer salesForTheNext7days) {
		this.salesForTheNext7days = salesForTheNext7days;
	}

	public Integer getSalesForTheNext14days() {
		return salesForTheNext14days;
	}

	public void setSalesForTheNext14days(Integer salesForTheNext14days) {
		this.salesForTheNext14days = salesForTheNext14days;
	}

	public Integer getSalesForTheNext28days() {
		return salesForTheNext28days;
	}

	public void setSalesForTheNext28days(Integer salesForTheNext28days) {
		this.salesForTheNext28days = salesForTheNext28days;
	}

	public Integer getExpectReplenishmentForTheNext42days() {
		return expectReplenishmentForTheNext42days;
	}

	public void setExpectReplenishmentForTheNext42days(Integer expectReplenishmentForTheNext42days) {
		this.expectReplenishmentForTheNext42days = expectReplenishmentForTheNext42days;
	}

	public Integer getExpectReplenishmentForTheNext70days() {
		return expectReplenishmentForTheNext70days;
	}

	public void setExpectReplenishmentForTheNext70days(Integer expectReplenishmentForTheNext70days) {
		this.expectReplenishmentForTheNext70days = expectReplenishmentForTheNext70days;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getAvailibleStock() {
		return availibleStock;
	}

	public void setAvailibleStock(int availibleStock) {
		this.availibleStock = availibleStock;
	}

	public Date getLastReplenishDate() {
		return lastReplenishDate;
	}

	public void setLastReplenishDate(Date lastReplenishDate) {
		this.lastReplenishDate = lastReplenishDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getFirstInStorageDate() {
		return firstInStorageDate;
	}

	public void setFirstInStorageDate(Date firstInStorageDate) {
		this.firstInStorageDate = firstInStorageDate;
	}

	public Date getNoSalesDate() {
		return noSalesDate;
	}

	public void setNoSalesDate(Date noSalesDate) {
		this.noSalesDate = noSalesDate;
	}

}
