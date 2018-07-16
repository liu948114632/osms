package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.itecheasy.core.fba.ReplenishmentTaskService.MonthlyPeakOrLow;

/** 
 * @author whw
 * @date 2017-8-17 
 * @description 
 * @version 
 */
@Entity
@Table(name="replenishment_task_month")
public class ReplenishmentTaskMonthPO {
	private int id;
	private int month;
	private MonthlyPeakOrLow monthlyPeakOrLow;
	private Date operateData;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="_month")
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	@Enumerated
	@Column(name="peak_low")
	public MonthlyPeakOrLow getMonthlyPeakOrLow() {
		return monthlyPeakOrLow;
	}
	public void setMonthlyPeakOrLow(MonthlyPeakOrLow monthlyPeakOrLow) {
		this.monthlyPeakOrLow = monthlyPeakOrLow;
	}
	
	@Column(name="operate_data")
	public Date getOperateData() {
		return operateData;
	}
	public void setOperateData(Date operateData) {
		this.operateData = operateData;
	}
	
	
	
}
