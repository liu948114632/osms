package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author taozihao
 * @date 2018-6-6
 * @description 补货计划操作日志
 */

@Entity
@Table(name = "fba_replenishment_plan_operate_log")
public class FbaReplenishmentPlanOperateLogPO {

	/*
	 * operate_time datetime; --创建日期 
	 * replenishment _plan_id int; --补货计划单号
	 * comment varchar() --记录人员相关操作
	 *  operator varchar();--操作员
	 */

	private int id;
	private int replenishmentPlanId;
	private String comment;
	private int operatorId;
	private Date operateTime;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="replenishment_plan_id")
	public int getReplenishmentPlanId() {
		return replenishmentPlanId;
	}
	
	public void setReplenishmentPlanId(int replenishmentPlanId) {
		this.replenishmentPlanId = replenishmentPlanId;
	}
	
	@Column(name="comment")
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Column(name="operator_id")
	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	@Column(name="operate_time")
	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	
}
