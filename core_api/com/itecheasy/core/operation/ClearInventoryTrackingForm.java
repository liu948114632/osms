package com.itecheasy.core.operation;

import java.util.Date;
import java.util.List;

import com.itecheasy.core.BaseSearchForm;

/**
 * @author taozihao
 * @date 2018年8月24日 下午6:21:45
 * @description
 */
public class ClearInventoryTrackingForm extends BaseSearchForm{
	private int shopId;
	private Date priceOffDateStart;
	private Date priceOffDateEnd;
	private int sellOutStatus;
	private List<String> skus;
	private int isThisWeekConcerned;
	private int priceOffTimes;

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public Date getPriceOffDateStart() {
		return priceOffDateStart;
	}

	public void setPriceOffDateStart(Date priceOffDateStart) {
		this.priceOffDateStart = priceOffDateStart;
	}

	public Date getPriceOffDateEnd() {
		return priceOffDateEnd;
	}

	public void setPriceOffDateEnd(Date priceOffDateEnd) {
		this.priceOffDateEnd = priceOffDateEnd;
	}

	public int getSellOutStatus() {
		return sellOutStatus;
	}

	public void setSellOutStatus(int sellOutStatus) {
		this.sellOutStatus = sellOutStatus;
	}

	public List<String> getSkus() {
		return skus;
	}

	public void setSkus(List<String> skus) {
		this.skus = skus;
	}

	public int getIsThisWeekConcerned() {
		return isThisWeekConcerned;
	}

	public void setIsThisWeekConcerned(int isThisWeekConcerned) {
		this.isThisWeekConcerned = isThisWeekConcerned;
	}

	public int getPriceOffTimes() {
		return priceOffTimes;
	}

	public void setPriceOffTimes(int priceOffTimes) {
		this.priceOffTimes = priceOffTimes;
	}

}
