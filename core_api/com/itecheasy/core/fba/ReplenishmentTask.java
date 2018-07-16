package com.itecheasy.core.fba;

import java.util.Date;

/**
 * @author wanghw
 * @date 2016-11-30
 * @description TODO
 * @version 1.2.2
 */
public class ReplenishmentTask {
	private int id;
	private String code;
	private int sumNum;
	private int complatedNum;
	private int sumProductUnitNum;
	private Date createDate;
	
	/**
	 * 下单时间
	 * @version 1.2.8 审核通过时间
	 */
	private Date orderedDate;
	private Date complatedDate;
	
	private int status;
	private int creater;
	
	/**
	 * 任务类型 ：
	 * <dd>1、FBA/海外仓补货</dd>
	 * <dd>2、自卖备货补货</dd>
	 * <dd>3、自卖订单采购</dd>
	 * <br>
	 * @version 1.2.8
	 */
	private int type;
	
	/**
	 * 审核时间
	 * @version 1.2.8
	 */
	private Date auditDate;
	
	/**
	 * 审核人
	 * @version 1.2.8
	 */
	private Integer auditor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getSumNum() {
		return sumNum;
	}

	public void setSumNum(int sumNum) {
		this.sumNum = sumNum;
	}

	public int getComplatedNum() {
		return complatedNum;
	}

	public void setComplatedNum(int complatedNum) {
		this.complatedNum = complatedNum;
	}

	public int getSumProductUnitNum() {
		return sumProductUnitNum;
	}

	public void setSumProductUnitNum(int sumProductUnitNum) {
		this.sumProductUnitNum = sumProductUnitNum;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Date getComplatedDate() {
		return complatedDate;
	}

	public void setComplatedDate(Date complatedDate) {
		this.complatedDate = complatedDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCreater() {
		return creater;
	}

	public void setCreater(int creater) {
		this.creater = creater;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public Integer getAuditor() {
		return auditor;
	}

	public void setAuditor(Integer auditor) {
		this.auditor = auditor;
	}
	
}
