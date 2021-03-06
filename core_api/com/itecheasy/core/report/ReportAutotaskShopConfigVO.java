package com.itecheasy.core.report;

import java.util.Date;

/**
 * @author taozihao
 * @date 2018年9月3日 下午5:02:20
 * @description
 */
public class ReportAutotaskShopConfigVO {
	private Integer id;
	private Integer shopId;
	private Integer shopDevInfoId;
	/**
	 * 报告类型
	 */
	private String reportType;
	/**
	 * 频率按照cron表达式填写
	 */
	private String frequency;
	/**
	 * 报告限制下载日期
	 */
	private Integer limitDays;
	/**
	 * 上次触发时间
	 */
	private Date lastFireTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShopDevInfoId() {
		return shopDevInfoId;
	}

	public void setShopDevInfoId(Integer shopDevInfoId) {
		this.shopDevInfoId = shopDevInfoId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Integer getLimitDays() {
		return limitDays;
	}

	public void setLimitDays(Integer limitDays) {
		this.limitDays = limitDays;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Date getLastFireTime() {
		return lastFireTime;
	}

	public void setLastFireTime(Date lastFireTime) {
		this.lastFireTime = lastFireTime;
	}
}
