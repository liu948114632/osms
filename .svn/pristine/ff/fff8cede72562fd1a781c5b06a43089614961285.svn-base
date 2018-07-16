package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryPO {
	private Integer id;

	private String englishName;
	private String chineseName;
	private Integer sequence;
	private String countryCode;
	private Boolean isfirstWay;

	
	@Column(name="is_fisrt_way")
	public Boolean getIsfirstWay() {
		return isfirstWay;
	}

	public void setIsfirstWay(Boolean isfirstWay) {
		this.isfirstWay = isfirstWay;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "english_name")
	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public CountryPO(Integer id) {
		super();
		this.id = id;
	}

	public CountryPO() {
		super();
	}

	@Column(name = "chinese_name")
	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	@Column(name = "sequence")
	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	@Column(name = "countrycode")
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
