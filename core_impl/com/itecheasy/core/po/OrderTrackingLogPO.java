package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @author whw
 * @date 2017-8-22 
 * @description TODO
 * @version 
 */
@Entity
@Table(name="order_tracking_log")
public class OrderTrackingLogPO {
	private int id;
	private int orderTrackingId;
	private String remark;
	private int operator;
	private Date operateDate;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="order_tracking_id")
	public int getOrderTrackingId() {
		return orderTrackingId;
	}
	public void setOrderTrackingId(int orderTrackingId) {
		this.orderTrackingId = orderTrackingId;
	}
	
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name="operator_id")
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}
	
	@Column(name="create_time")
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	
	
}
