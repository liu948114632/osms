package com.itecheasy.core.order;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wanghw
 * @date 2016-1-11
 * @description 订单金额
 * @version
 */
public class OrderCountReport {
	private int id;
	private int shopId;
	private String reportDate;
	private int orderTotalNum;
	private BigDecimal orderTotalAmount;
	private int orderRefundNum;
	private BigDecimal orderRefundAmount;
	private int FBAPaymentTotalNum;
	private BigDecimal FBAPaymentTotalAmount;
	private Date countDate;
	private int currency;

	private BigDecimal paymentAmount;
	private BigDecimal costPrice;
	private BigDecimal costFreight;
	private BigDecimal firstWayFreight;
	private BigDecimal orderAmount;

	private BigDecimal profit;
	private int totalUnit;

	public int getTotalUnit() {
		return totalUnit;
	}

	public void setTotalUnit(int totalUnit) {
		this.totalUnit = totalUnit;
	}

	public BigDecimal getFirstWayFreight() {
		return firstWayFreight;
	}

	public void setFirstWayFreight(BigDecimal firstWayFreight) {
		this.firstWayFreight = firstWayFreight;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getCostFreight() {
		return costFreight;
	}

	public void setCostFreight(BigDecimal costFreight) {
		this.costFreight = costFreight;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public OrderCountReport() {
		super();
		this.shopId = 0;
		this.reportDate = "";
		BigDecimal zore = new BigDecimal(0);
		this.orderTotalAmount = zore;
		this.orderRefundAmount = zore;
		this.FBAPaymentTotalAmount = zore;

		this.costFreight = zore;
		this.costPrice = zore;
		this.firstWayFreight = zore;
		this.paymentAmount = zore;
		this.orderAmount = zore;
	}

	public OrderCountReport(int shopId, String reportDate, Date countDate) {
		super();
		this.shopId = shopId;
		this.reportDate = reportDate;
		this.countDate = countDate;
		BigDecimal zore = new BigDecimal(0);
		this.orderTotalAmount = zore;
		this.orderRefundAmount = zore;
		this.FBAPaymentTotalAmount = zore;

		this.costFreight = zore;
		this.costPrice = zore;
		this.firstWayFreight = zore;
		this.paymentAmount = zore;
		this.orderAmount = zore;
	}

	public OrderCountReport(int shopId, String reportDate) {
		super();
		this.shopId = shopId;
		this.reportDate = reportDate;
		BigDecimal zore = new BigDecimal(0);
		this.orderTotalAmount = zore;
		this.orderRefundAmount = zore;
		this.FBAPaymentTotalAmount = zore;

		this.costFreight = zore;
		this.costPrice = zore;
		this.firstWayFreight = zore;
		this.paymentAmount = zore;
		this.orderAmount = zore;

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

	/**
	 * 报表日期 <em>yyyyMMdd</em>
	 * 
	 * @return
	 */
	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	/**
	 * 订单总数
	 * 
	 * @return
	 */
	public int getOrderTotalNum() {
		return orderTotalNum;
	}

	public void setOrderTotalNum(int orderTotalNum) {
		this.orderTotalNum = orderTotalNum;
	}

	/**
	 * 订单总金额
	 * 
	 * @return
	 */
	public BigDecimal getOrderTotalAmount() {
		return orderTotalAmount;
	}

	public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}

	/**
	 * 订单退款总数
	 * 
	 * @return
	 */
	public int getOrderRefundNum() {
		return orderRefundNum;
	}

	public void setOrderRefundNum(int orderRefundNum) {
		this.orderRefundNum = orderRefundNum;
	}

	/**
	 * 订单退款总金额
	 * 
	 * @return
	 */
	public BigDecimal getOrderRefundAmount() {
		return orderRefundAmount;
	}

	public void setOrderRefundAmount(BigDecimal orderRefundAmount) {
		this.orderRefundAmount = orderRefundAmount;
	}

	/**
	 * FBA实收款订单总数
	 * 
	 * @return
	 */
	public int getFBAPaymentTotalNum() {
		return FBAPaymentTotalNum;
	}

	public void setFBAPaymentTotalNum(int fBAPaymentTotalNum) {
		FBAPaymentTotalNum = fBAPaymentTotalNum;
	}

	/**
	 * FBA实收款订单总金额
	 * 
	 * @return
	 */
	public BigDecimal getFBAPaymentTotalAmount() {
		return FBAPaymentTotalAmount;
	}

	public void setFBAPaymentTotalAmount(BigDecimal fBAPaymentTotalAmount) {
		FBAPaymentTotalAmount = fBAPaymentTotalAmount;
	}

	/**
	 * 生成日期
	 * 
	 * @return
	 */
	public Date getCountDate() {
		return countDate;
	}

	public void setCountDate(Date countDate) {
		this.countDate = countDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reportDate == null) ? 0 : reportDate.hashCode());
		result = prime * result + shopId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderCountReport other = (OrderCountReport) obj;
		if (reportDate == null) {
			if (other.reportDate != null)
				return false;
		} else if (!reportDate.equals(other.reportDate))
			return false;
		if (shopId != other.shopId)
			return false;
		return true;
	}

}
