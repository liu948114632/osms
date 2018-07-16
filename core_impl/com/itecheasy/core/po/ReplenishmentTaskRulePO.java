package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.itecheasy.core.fba.MonthlyPeakOrLowRule.PeakOrLowRuleKey;

/** 
 * @author whw
 * @date 2017-8-17 
 * @description 
 * @version 
 */
@Entity
@Table(name="replenishment_task_rule")
public class ReplenishmentTaskRulePO {
	private int id;
	private PeakOrLowRuleKey ruleKey;
	private String value;
	private int sort;
	private boolean deleted;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="_key")
	public PeakOrLowRuleKey getRuleKey() {
		return ruleKey;
	}
	public void setRuleKey(PeakOrLowRuleKey ruleKey) {
		this.ruleKey = ruleKey;
	}
	
	@Column(name="value")
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Column(name="sort")
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	@Column(name="deleted")
	@Where(clause="deleted=0 ")
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
}
