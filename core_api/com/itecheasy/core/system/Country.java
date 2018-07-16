package com.itecheasy.core.system;


/**
 * @author wanghw
 * @date 2015-5-8
 * @description
 * @version 1.1
 */
public class Country {
	private int id;
	private String englishName;
	private String chineseName;
	private String countryCode;

	private Boolean isfirstWay;

	public Boolean getIsfirstWay() {
		return isfirstWay;
	}

	public void setIsfirstWay(Boolean isfirstWay) {
		this.isfirstWay = isfirstWay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
