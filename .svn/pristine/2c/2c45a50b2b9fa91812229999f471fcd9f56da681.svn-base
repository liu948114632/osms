package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2016-11-30
 * @description TODO
 * @version 1.2.2
 */
@Entity
@Table(name = "fba_shop_product_inventory")
public class FbaShopProductInventoryPO {
	private int id;
	private int fbaShopProductId;
	private int fbaSecurityLine;
	private int SumSecurityLine;

	/**
	 * 是否修改FBA警戒库存
	 */
	private boolean updateFbaSecurityLine;

	/**
	 * 是否修改总警戒库存
	 */
	private boolean updateSumSecurityLine;

	/**
	 * 是否提醒fba补货
	 */
	private boolean remindFbaReplenishment;

	private int fbaAwaitReplenishment;
	private int fbaTheReplenishment;
	private int fbaAvailableStock;

	/**
	 * x天fba销量
	 */
	private int daysSales;
	/**
	 * x天总销量
	 */
	private int daysSalesAll;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="fba_shop_product_id")
	public int getFbaShopProductId() {
		return fbaShopProductId;
	}

	public void setFbaShopProductId(int fbaShopProductId) {
		this.fbaShopProductId = fbaShopProductId;
	}

	@Column(name = "days_sales_all")
	public int getDaysSalesAll() {
		return daysSalesAll;
	}

	public void setDaysSalesAll(int daysSalesAll) {
		this.daysSalesAll = daysSalesAll;
	}

	@Column(name = "fba_security_line")
	public int getFbaSecurityLine() {
		return fbaSecurityLine;
	}

	public void setFbaSecurityLine(int fbaSecurityLine) {
		this.fbaSecurityLine = fbaSecurityLine;
	}

	@Column(name = "sum_security_line")
	public int getSumSecurityLine() {
		return SumSecurityLine;
	}

	public void setSumSecurityLine(int sumSecurityLine) {
		SumSecurityLine = sumSecurityLine;
	}

	@Column(name = "is_update_fba_security_line")
	public boolean isUpdateFbaSecurityLine() {
		return updateFbaSecurityLine;
	}

	public void setUpdateFbaSecurityLine(boolean updateFbaSecurityLine) {
		this.updateFbaSecurityLine = updateFbaSecurityLine;
	}

	@Column(name = "is_update_sum_security_line")
	public boolean isUpdateSumSecurityLine() {
		return updateSumSecurityLine;
	}

	public void setUpdateSumSecurityLine(boolean updateSumSecurityLine) {
		this.updateSumSecurityLine = updateSumSecurityLine;
	}

	@Column(name = "is_remind_fba_replenishment")
	public boolean isRemindFbaReplenishment() {
		return remindFbaReplenishment;
	}

	public void setRemindFbaReplenishment(boolean remindFbaReplenishment) {
		this.remindFbaReplenishment = remindFbaReplenishment;
	}

	@Column(name = "fba_await_replenishment")
	public int getFbaAwaitReplenishment() {
		return fbaAwaitReplenishment;
	}

	public void setFbaAwaitReplenishment(int fbaAwaitReplenishment) {
		this.fbaAwaitReplenishment = fbaAwaitReplenishment;
	}

	@Column(name = "fba_the_replenishment")
	public int getFbaTheReplenishment() {
		return fbaTheReplenishment;
	}

	public void setFbaTheReplenishment(int fbaTheReplenishment) {
		this.fbaTheReplenishment = fbaTheReplenishment;
	}

	@Column(name = "fba_available_stock")
	public int getFbaAvailableStock() {
		return fbaAvailableStock;
	}

	public void setFbaAvailableStock(int fbaAvailableStock) {
		this.fbaAvailableStock = fbaAvailableStock;
	}

	@Column(name = "days_sales_fba")
	public int getDaysSales() {
		return daysSales;
	}

	public void setDaysSales(int daysSales) {
		this.daysSales = daysSales;
	}

}
