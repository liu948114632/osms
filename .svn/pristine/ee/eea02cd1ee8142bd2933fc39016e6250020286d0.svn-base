package com.itecheasy.core.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-1-11
 * @description TODO
 * @version
 */
@Entity
@Table(name = "order_count_report")
public class OrderCountReportPO {
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

	public OrderCountReportPO() {
		super();
	}

	public OrderCountReportPO(int shopId, String reportDate, Date countDate) {
		super();
		this.shopId = shopId;
		this.reportDate = reportDate;
		this.countDate = countDate;
		BigDecimal zore = new BigDecimal(0);
		this.orderTotalAmount = zore;
		this.orderRefundAmount = zore;
		this.FBAPaymentTotalAmount = zore;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "shop_id")
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
	@Column(name = "report_date")
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
	@Column(name = "order_total_num")
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
	@Column(name = "order_total_amount")
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
	@Column(name = "order_refund_num")
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
	@Column(name = "order_refund_amount")
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
	@Column(name = "FBA_payment_total_num")
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
	@Column(name = "FBA_payment_total_amount")
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
	@Column(name = "count_date")
	public Date getCountDate() {
		return countDate;
	}

	public void setCountDate(Date countDate) {
		this.countDate = countDate;
	}

}
