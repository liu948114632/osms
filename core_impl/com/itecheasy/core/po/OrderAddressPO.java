package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * 订单货运地址
 * 
 */
@Entity
@Table(name="order_address")
public class OrderAddressPO {
	private int id;
	private int orderId;
	/**
	 * 收件人
	 * 
	 */
	private String name;
	/**
	 * 地址1
	 * 
	 */
	private String addressLine1;
	/**
	 * 县
	 * 
	 */
	private String county;
	/**
	 * 国家简码
	 * 
	 */
	private String countryCode;
	/**
	 * 省、州或者区域
	 * 
	 */
	private String stateOrRegion;
	/**
	 * 城市
	 * 
	 */
	private String city;
	/**
	 * 街道
	 * 
	 */
	private String district;
	/**
	 * 邮编
	 * 
	 */
	private String postalCode;
	/**
	 * 电话
	 * 
	 */
	private String phone;
	/**
	 * 发货说明
	 * 
	 */
	private String remark;
	/**
	 * 地址2
	 * 
	 */
	private String addressLine2;
	private int countryId;
	
	
	@Column(name="country_id")
	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
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

	@Column
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name="country_code")
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	
	@Column(name="state_or_Region")
	public String getStateOrRegion() {
		return stateOrRegion;
	}

	public void setStateOrRegion(String stateOrRegion) {
		this.stateOrRegion = stateOrRegion;
	}

	@Column
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name="postal_code")
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="address_line2")
	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name="order_id")
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderAddressPO [name=" + name + ", addressLine1=" + addressLine1 + ", countryCode=" + countryCode
				+ ", stateOrRegion=" + stateOrRegion + ", city=" + city + ", district=" + district + ", postalCode="
				+ postalCode + ", phone=" + phone +", addressLine2="+addressLine2+ "]";
	}
	
}