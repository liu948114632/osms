package com.itecheasy.core.fba;

/**
 * @author wanghw
 * @date 2016-12-3
 * @description TODO
 * @version 1.2.2
 */
public class FbaShopProductInventoryBo {
	private int id;
	private int fbaShopProductId;
	private int fbaSecurityLine;
	private int sumSecurityLine;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFbaShopProductId() {
		return fbaShopProductId;
	}

	public void setFbaShopProductId(int fbaShopProductId) {
		this.fbaShopProductId = fbaShopProductId;
	}

	public int getFbaSecurityLine() {
		return fbaSecurityLine;
	}

	public void setFbaSecurityLine(int fbaSecurityLine) {
		this.fbaSecurityLine = fbaSecurityLine;
	}

	public int getSumSecurityLine() {
		return sumSecurityLine;
	}

	public void setSumSecurityLine(int sumSecurityLine) {
		this.sumSecurityLine = sumSecurityLine;
	}

	public boolean isUpdateFbaSecurityLine() {
		return updateFbaSecurityLine;
	}

	public void setUpdateFbaSecurityLine(boolean updateFbaSecurityLine) {
		this.updateFbaSecurityLine = updateFbaSecurityLine;
	}

	public boolean isUpdateSumSecurityLine() {
		return updateSumSecurityLine;
	}

	public void setUpdateSumSecurityLine(boolean updateSumSecurityLine) {
		this.updateSumSecurityLine = updateSumSecurityLine;
	}

	public boolean isRemindFbaReplenishment() {
		return remindFbaReplenishment;
	}

	public void setRemindFbaReplenishment(boolean remindFbaReplenishment) {
		this.remindFbaReplenishment = remindFbaReplenishment;
	}

	public int getFbaAwaitReplenishment() {
		return fbaAwaitReplenishment;
	}

	public void setFbaAwaitReplenishment(int fbaAwaitReplenishment) {
		this.fbaAwaitReplenishment = fbaAwaitReplenishment;
	}

	public int getFbaTheReplenishment() {
		return fbaTheReplenishment;
	}

	public void setFbaTheReplenishment(int fbaTheReplenishment) {
		this.fbaTheReplenishment = fbaTheReplenishment;
	}

	public int getFbaAvailableStock() {
		return fbaAvailableStock;
	}

	public void setFbaAvailableStock(int fbaAvailableStock) {
		this.fbaAvailableStock = fbaAvailableStock;
	}

	public int getDaysSales() {
		return daysSales;
	}

	public void setDaysSales(int daysSales) {
		this.daysSales = daysSales;
	}

	public int getDaysSalesAll() {
		return daysSalesAll;
	}

	public void setDaysSalesAll(int daysSalesAll) {
		this.daysSalesAll = daysSalesAll;
	}

}
