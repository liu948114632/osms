package com.itecheasy.core.system;

/**
 * @author wanghw
 * @date 2015-6-17
 * @description TODO
 * @version
 */
public class ShopSearchForm {
	private int type;
	private int language;
	private String shopName;
	private int department;

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

}
