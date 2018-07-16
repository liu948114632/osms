package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author taozihao
 * @date 2018-6-5 
 * @description 店铺的发货（退货）地址
 */

@Entity
@Table(name="fba_from_address")
public class FbaFromAddressPO {
	/*id int primary key auto increment not null; --主键
	name varchar(50) not null;	--名称
	address_line1 varchar(180) not null; --地址1
	address_line2 varchar(60); --地址2
	city varchar(30) not null; --城市
	distinct_or_county varchar(25); --区或县
	state_or_province_code varchar(2); --省/自治区/直辖市代码
	country_code varchar(2) not null; --国家/地区代码
	postal_code varchar(30); --邮政编码
	*/
	
	private Integer id;
	private String name;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String districtOrCounty;
	private String stateOrProvinceCode;
	private String countryCode;
	private String postalCode;
	
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
	
}
