package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author taozihao
 * @date 2018-6-6
 * @description 补货计划
 *
 */
@Entity
@Table(name = "fba_replenishment_plan")
public class FbaReplenishmentPlanPO {

	/*
	 * id int primary key auto increment not null; --主键 plan_name varchar();
	 * --计划名称 fba_ship_from_address int not null; --发货地址,由于关联了店铺，可以直接从店铺里面去找
	 * ship_to_country_code varchar();--发往国家,一般为欧洲国家时才会有 shipping_method
	 * varchar();--货运方式，主要是为了生成货件编号的,我们自己定义的，不需要提交亚马逊 create_time datetime;
	 * --创建日期 last_update_time datetime; --上次更新日期 mskus int; --商品种类数 amount int;
	 * --商品总数submit_status char --计划是否已提交 shop_id int; --店铺id
	 */

	private int id;
	private String planName;
	private String shipToCountryCode;
	private String shippingMethod;
	private Date createTime;
	private Date lastUpdateTime;
	private int mskus;
	private int amount;
	/**
	 * "0"表示未提交,"1"表示已提交,"2"表示已建单,"3表示取消"
	 */
	private String submitStatus;
	private int shopId;
	
	private Integer seaTransportationPreparePlanId;
	/**
	 * 不提交亚马逊("0"), 提交亚马逊("1");
	 */
	private Integer isSubmitToAm;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="plan_name")
	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	@Column(name="ship_to_country_code")
	public String getShipToCountryCode() {
		return shipToCountryCode;
	}

	public void setShipToCountryCode(String shipToCountryCode) {
		this.shipToCountryCode = shipToCountryCode;
	}

	@Column(name="shipping_method")
	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="last_update_time")
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Column(name="mskus")
	public int getMskus() {
		return mskus;
	}

	public void setMskus(int mskus) {
		this.mskus = mskus;
	}

	@Column(name="amount")
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(name="submit_status")
	public String getSubmitStatus() {
		return submitStatus;
	}

	/**
	 * "0"表示未提交,"1"表示已提交,"2"表示已建单,"3表示取消"
	 */
	public void setSubmitStatus(String submitStatus) {
		this.submitStatus = submitStatus;
	}

	@Column(name="shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Column(name = "sea_transportation_prepare_plan_id")
	public Integer getSeaTransportationPreparePlanId() {
		return seaTransportationPreparePlanId;
	}

	public void setSeaTransportationPreparePlanId(Integer seaTransportationPreparePlanId) {
		this.seaTransportationPreparePlanId = seaTransportationPreparePlanId;
	}

	@Column(name="is_submit_to_am")
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
