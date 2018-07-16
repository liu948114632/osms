package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-6-16
 * @description TODO
 * @version
 */
@Entity
@Table(name = "shop_relation")
public class ShopRelationPO {
	private int id;
	private int shop1;
	private int shop2;
	private int type;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public int getShop1() {
		return shop1;
	}

	public void setShop1(int shop1) {
		this.shop1 = shop1;
	}

	@Column
	public int getShop2() {
		return shop2;
	}

	public void setShop2(int shop2) {
		this.shop2 = shop2;
	}

	@Column
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
