package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2016-12-3
 * @description TODO
 * @version 1.2.2
 */
@Entity
@Table(name = "order_resend_cancel_apply")
public class OrderResendCancelApplyPO {
	private int id;
	private String orderCode;
	private Date createDate;
	private Date processDate;
	private int processStatus;
	private int type;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="order_code")
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="process_date")
	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}


	public int getType() {
		return type;
	}

	@Column(name="process_status")
	public int getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(int processStatus) {
		this.processStatus = processStatus;
	}

	public void setType(int type) {
		this.type = type;
	}

}
