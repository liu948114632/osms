package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @description TODO
 * @version
 */
@Entity
@Table(name = "dbo.smt_order_communication_log")
public class SmtOrderCommunicationLogPo {
	private int id;
	private String shopOrderId;
	private int status;
	private int shopId;
	private Date lastOperatorTime;
	private String remark;
	private int dowmCount;
	private String orderStatus;
	private Date timeoutLeftTime;
	
	
	@Column(name="timeout_left_time")
	public Date getTimeoutLeftTime() {
		return timeoutLeftTime;
	}

	public void setTimeoutLeftTime(Date timeoutLeftTime) {
		this.timeoutLeftTime = timeoutLeftTime;
	}

	@Column(name = "dowm_count")
	public int getDowmCount() {
		return dowmCount;
	}

	public void setDowmCount(int dowmCount) {
		this.dowmCount = dowmCount;
	}

	@Column(name = "last_operator_time")
	public Date getLastOperatorTime() {
		return lastOperatorTime;
	}

	public void setLastOperatorTime(Date lastOperatorTime) {
		this.lastOperatorTime = lastOperatorTime;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "order_id")
	public String getShopOrderId() {
		return shopOrderId;
	}

	public void setShopOrderId(String shopOrderId) {
		this.shopOrderId = shopOrderId;
	}

	@Column(name = "order_status")
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
