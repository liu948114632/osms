package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author taozihao
 * @date 2018年9月3日 下午3:58:42
 * @description 店铺的自动任务下载报告配置
 */
@Entity
@Table(name="report_autotask_shop_config")
public class ReportAutotaskShopConfigPO {
	private Integer id;
	private Integer shopDevInfoId;
	private Integer shopId;
	/**
	 * 报告类型
	 */
	private String reportType;
	/**
	 * 频率按照cron表达式填写
	 */
	private String frequency;
	/**
	 * 上次触发时间
	 */
	private Date lastFireTime;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	
	@Column(name="shop_dev_info_id")
	public Integer getShopDevInfoId() {
		return shopDevInfoId;
	}

	public void setShopDevInfoId(Integer shopDevInfoId) {
		this.shopDevInfoId = shopDevInfoId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="shop_id")
	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Column(name="report_type")
	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	@Column(name="frequency")
	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	@Column(name="last_fire_time")
	public Date getLastFireTime() {
		return lastFireTime;
	}

	public void setLastFireTime(Date lastFireTime) {
		this.lastFireTime = lastFireTime;
	}
}
