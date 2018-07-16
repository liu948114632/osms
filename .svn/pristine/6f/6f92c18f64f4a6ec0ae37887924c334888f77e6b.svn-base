package com.itecheasy.core.po;

import javax.persistence.*;

/***********************************************************************
 * Module:  OrderAddressAmazon.java
 * Author:  senxin-kf
 * Purpose: Defines the Class OrderAddressAmazon
 ***********************************************************************/

/**
 * 订单amazon货运地址
 * 
 */
@Entity
@Table(name="order_address_amazon")
public class OrderAddressAmazonPO {
	private int id;
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
	 * 县区
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
	 * 地址2
	 * 
	 */
	private String addressLine2;
	/**
	 * 地址3
	 * 
	 */
	private String addressLine3;

	private int orderAmazomId;

	@Column(name = "order_amazom_id")
	public int getOrderAmazomId() {
		return orderAmazomId;
	}

	public void setOrderAmazomId(int orderAmazomId) {
		this.orderAmazomId = orderAmazomId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name="address_line2")
	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name="address_line3")
	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

}