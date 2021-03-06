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
 * @date 2018年7月4日 下午4:09:53
 * @description 连续三个月满足销量条件的商品sku
 */

@Entity
@Table(name="three_month_sales_sku_temp")
public class ThreeMonthSalesSkuTempPO {
	/*
	 * shop_id int, 
	 * sku varchar(100),
	 * update_time datetime
	 */

	private Integer id;
	private Integer shopId;
	private String sku;
	private Date updateTime;

	@Id
	//@GeneratedValue
	public Integer getId() {
		return id;
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

	@Column(name="sku")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Column(name="update_time")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
