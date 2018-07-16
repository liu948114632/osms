package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-1-11
 * @description 订单实收款按类型
 * @version
 */
@Entity
@Table(name="order_payment_data_type")
public class OrderPaymentDataTypePO {
	protected int id;
	protected String transactionType;
	protected String paymentDetail;
	protected String paymentType;
	protected int action;
	
	
	@Column(name="ACTION")
	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="transaction_type")
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Column(name="payment_detail")
	public String getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(String paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	@Column(name="payment_type")
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
