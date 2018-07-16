package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-6-22
 * @description TODO
 * @version
 */
@Entity
@Table(name="config_cms_busstype")
public class ConfigCMSPO {
	private int id;
	private int shopSource;
	private int cmsBussiType;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="shop_source")
	public int getShopSource() {
		return shopSource;
	}

	public void setShopSource(int shopSource) {
		this.shopSource = shopSource;
	}

	@Column(name="cms_bussiType")
	public int getCmsBussiType() {
		return cmsBussiType;
	}

	public void setCmsBussiType(int cmsBussiType) {
		this.cmsBussiType = cmsBussiType;
	}

}
