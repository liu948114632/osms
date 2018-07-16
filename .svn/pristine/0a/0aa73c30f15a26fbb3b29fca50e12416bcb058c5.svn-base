package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "am_shop_product_relation")
public class AMShopProductRelationPo {
	private int id;
	private Integer mainAMShopProductId;
	private int amShopProductId;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="main_am_shop_product_id")
	public Integer getMainAMShopProductId() {
		return mainAMShopProductId;
	}

	public void setMainAMShopProductId(Integer mainAMShopProductId) {
		this.mainAMShopProductId = mainAMShopProductId;
	}

	@Column(name="am_shop_product")
	public int getAmShopProductId() {
		return amShopProductId;
	}

	public void setAmShopProductId(int amShopProductId) {
		this.amShopProductId = amShopProductId;
	}

}
