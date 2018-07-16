package com.itecheasy.core.prepare;

import java.util.Date;

/**
 * @author taozihao
 * @date 2018年6月30日 下午12:54:29
 * @description 海运备货计划
 */
public class SeaTransportationPlanVO {
	private int shopId;
	private Integer planId;
	private String planName;
	private Date createDate;
	private Date deliveryDate;
	private Date receiveDate;
	private double stockPeriod;
	private int status;
	private int planType;
	private String remark;
	private int totalProductAmount;
	private int mskus;
	private double totalWeight;

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public double getStockPeriod() {
		return stockPeriod;
	}

	public void setStockPeriod(double stockPeriod) {
		this.stockPeriod = stockPeriod;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPlanType() {
		return planType;
	}

	public void setPlanType(int planType) {
		this.planType = planType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getTotalProductAmount() {
		return totalProductAmount;
	}

	public void setTotalProductAmount(int totalProductAmount) {
		this.totalProductAmount = totalProductAmount;
	}

	public int getMskus() {
		return mskus;
	}

	public void setMskus(int mskus) {
		this.mskus = mskus;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

}
