package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author taozihao
 * @date 2018-6-6
 * @description 补货计划商品项
 */
@Entity
@Table(name = "fba_replenishment_plan_item")
public class FbaReplenishmentPlanItemPO {
	
	/*
	 * id int primary key auto increment not null; --主键 
	 * fba_shop_product_id int;--关联之前商品对应信息表 
	 * quantity int not null; --商品数量 
	 * fba_ replenishment _plan_id --补货计划id int not null; --关联补货计划
	 */
	
	private int id;
	private int fbaShopProductId;
	private int quantity;
	private int fbaReplenishmentPlanId;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="fba_shop_product_id")
	public int getFbaShopProductId() {
		return fbaShopProductId;
	}

	public void setFbaShopProductId(int fbaShopProductId) {
		this.fbaShopProductId = fbaShopProductId;
	}

	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name="fba_replenishment_plan_id")
	public int getFbaReplenishmentPlanId() {
		return fbaReplenishmentPlanId;
	}

	public void setFbaReplenishmentPlanId(int fbaReplenishmentPlanId) {
		this.fbaReplenishmentPlanId = fbaReplenishmentPlanId;
	}

}
