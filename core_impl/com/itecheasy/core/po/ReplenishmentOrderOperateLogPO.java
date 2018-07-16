package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

/**
 * 订单操作日志
 * 
 * 
 */
@Entity
@Table(name="replenishment_order_operate_log")
public class ReplenishmentOrderOperateLogPO {
	private int id;
	/**
	 * 信息
	 * 
	 */
	private java.lang.String comment;
	/**
	 * 订单id
	 * 
	 */
	private int objectId;
	/**
	 * 操作时间
	 * 
	 */
	private Date operateDate;
	/**
	 * 操作人
	 * 
	 */
	private String operator;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.lang.String getComment() {
		return comment;
	}

	public void setComment(java.lang.String comment) {
		this.comment = comment;
	}

	@Column(name="object_id")
	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	@Column(name="operate_date")
	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}