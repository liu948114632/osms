package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-2-18
 * @description 店铺业绩和利润率
 * @version 1.1.7
 */
@Entity
@Table(name = "shop_sales_target")
public class ShopSalesTargetPO {
	private int id;
	private String version;
	private int shopId;
	/**
	 * 利润率
	 */
	private double profitRate;

	/**
	 * A级目标业绩（￥）
	 */
	private double salesTargetOfALevel;

	/**
	 * B级目标业绩（￥）
	 */
	private double salesTargetOfBLevel;

	private Date updateDate;

	@Column(name="update_date")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name="shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Column(name="profit_rate")
	public double getProfitRate() {
		return profitRate;
	}

	public void setProfitRate(double profitRate) {
		this.profitRate = profitRate;
	}

	@Column(name="sales_target_A_level")
	public double getSalesTargetOfALevel() {
		return salesTargetOfALevel;
	}

	public void setSalesTargetOfALevel(double salesTargetOfALevel) {
		this.salesTargetOfALevel = salesTargetOfALevel;
	}

	@Column(name="sales_target_B_level")
	public double getSalesTargetOfBLevel() {
		return salesTargetOfBLevel;
	}

	public void setSalesTargetOfBLevel(double salesTargetOfBLevel) {
		this.salesTargetOfBLevel = salesTargetOfBLevel;
	}
}
