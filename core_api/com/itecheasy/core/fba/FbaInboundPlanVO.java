package com.itecheasy.core.fba;

import java.util.Date;

/**
 * @author taozihao
 * @date 2018年6月7日 下午4:30:40
 * @description
 */
public class FbaInboundPlanVO {
	private int id;
	private String planName;
	private Date createTime;
	private Date lastUpdateTime;
	private int mskus;
	private int amount;
	/**
	 * 0表示未提交,1表示已提交,2表示已建单,3表示取消"
	 */
	private int submitStatus;
	/**
	 * 不提交亚马逊("0"), 提交亚马逊("1");
	 */
	private Integer isSubmitToAm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public int getMskus() {
		return mskus;
	}

	public void setMskus(int mskus) {
		this.mskus = mskus;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSubmitStatus() {
		return submitStatus;
	}

	public void setSubmitStatus(int submitStatus) {
		this.submitStatus = submitStatus;
	}

	public Integer getIsSubmitToAm() {
		return isSubmitToAm;
	}

	/**
	 * 不提交亚马逊("0"), 提交亚马逊("1");
	 */
	public void setIsSubmitToAm(Integer isSubmitToAm) {
		this.isSubmitToAm = isSubmitToAm;
	}

}
