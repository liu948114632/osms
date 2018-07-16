package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author taozihao
 * @date 2018年6月11日 上午11:39:19
 * @description fba补货计划的退货地址快照，以免店铺修改绑定地址后计划退货地址也跟着变
 */

@Entity
@Table(name="fba_from_address_snapshot")
public class FbaFromAddressSnapshotPO {
	private Integer id;
	private String name;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String districtOrCounty;
	private String stateOrProvinceCode;
	private String countryCode;
	private String postalCode;
	private Integer fbaReplenishmentPlanId;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="address_line1")
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	@Column(name="address_line2")
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="district_or_county")
	public String getDistrictOrCounty() {
		return districtOrCounty;
	}
	public void setDistrictOrCounty(String districtOrCounty) {
		this.districtOrCounty = districtOrCounty;
	}
	
	@Column(name="state_or_province_code")
	public String getStateOrProvinceCode() {
		return stateOrProvinceCode;
	}
	public void setStateOrProvinceCode(String stateOrProvinceCode) {
		this.stateOrProvinceCode = stateOrProvinceCode;
	}
	
	@Column(name="country_code")
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Column(name="postal_code")
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Column(name="fba_replenishment_plan_id")
	public Integer getFbaReplenishmentPlanId() {
		return fbaReplenishmentPlanId;
	}
	public void setFbaReplenishmentPlanId(Integer fbaReplenishmentPlanId) {
		this.fbaReplenishmentPlanId = fbaReplenishmentPlanId;
	}
	
	
}
