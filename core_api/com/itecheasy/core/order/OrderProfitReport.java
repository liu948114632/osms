package com.itecheasy.core.order;

import java.math.BigDecimal;

/**
 * @author wanghw
 * @date 2016-1-11
 * @description 订单毛利
 * @version 1.1.6
 */
public class OrderProfitReport {
	private BigDecimal paymentAmount;
	private BigDecimal costPrice;
	private BigDecimal costFreight;
	private BigDecimal orderAmount;
	private BigDecimal profit;
	private double profitPercent;
	private int currency;
	private int shopId;
	private String reportDate;

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	/**
	 * 实收款
	 * 
	 * @return
	 */
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * 实成本 <em>￥</em>
	 * 
	 * @return
	 */
	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	/**
	 * 运费成本 <em>￥</em>
	 * 
	 * @return {@link #costFreight}
	 */
	public BigDecimal getCostFreight() {
		return costFreight;
	}

	public void setCostFreight(BigDecimal costFreight) {
		this.costFreight = costFreight;
	}

	/**
	 * 订单总金额
	 * 
	 * @return
	 */
	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	/**
	 * 毛利 <em>￥</em>
	 * 
	 * @return
	 */
	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	/**
	 * 毛利率 <em>%</em>
	 * 
	 * @return
	 */
	public double getProfitPercent() {
		return profitPercent;
	}

	public void setProfitPercent(double profitPercent) {
		this.profitPercent = profitPercent;
	}

}
