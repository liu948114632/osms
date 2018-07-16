package com.itecheasy.core.fba;
/**
 * @author taozihao
 * @date 2018年6月8日 下午5:50:20
 * @description
 */
public class FbaToAddress {

		private Integer id;
		private String name;
		private String addressLine1;
		private String addressLine2;
		private String city;
		private String districtOrCounty;
		private String stateOrProvinceCode;
		private String countryCode;
		private String postalCode;
		//private String shopId;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getAddressLine1() {
			return addressLine1;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		
		public String getAddressLine2() {
			return addressLine2;
		}
		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}
		
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
		public String getDistrictOrCounty() {
			return districtOrCounty;
		}
		public void setDistrictOrCounty(String districtOrCounty) {
			this.districtOrCounty = districtOrCounty;
		}
		
		public String getStateOrProvinceCode() {
			return stateOrProvinceCode;
		}
		public void setStateOrProvinceCode(String stateOrProvinceCode) {
			this.stateOrProvinceCode = stateOrProvinceCode;
		}
		
		public String getCountryCode() {
			return countryCode;
		}
		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}
		
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		
	/*	public String getShopId() {
			return shopId;
		}
		public void setShopId(String shopId) {
			this.shopId = shopId;
		}*/

}
