package com.itecheasy.core.order;

/**
 * @author wanghw
 * @date 2016-1-11
 * @description 订单实收款按类型
 * @version
 */
public class OrderPaymentDataType {
	protected int id;
	protected String transactionType;
	protected String paymentDetail;
	protected String paymentType;
	protected int action;

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(String paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
