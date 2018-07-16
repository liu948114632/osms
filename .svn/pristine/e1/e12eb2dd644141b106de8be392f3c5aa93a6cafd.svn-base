package com.itecheasy.core.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-3-4
 * @description 头程运费
 * @version 1.1.7
 */
@Entity
@Table(name = "first_way_freight_setting")
public class FirstWayFreightSettingPO {
	private int id;
	private String version;
	private int country;
	private BigDecimal freightOfUnit;
	private Date updateTime;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="update_time")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name="version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name="country_id")
	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	@Column(name="first_way_freight_of_unit")
	public BigDecimal getFreightOfUnit() {
		return freightOfUnit;
	}

	public void setFreightOfUnit(BigDecimal freightOfUnit) {
		this.freightOfUnit = freightOfUnit;
	}

}
