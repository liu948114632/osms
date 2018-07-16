package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "product_relation")
public class ProductRelationPo {
	private int id;
	private Integer mainProductId;
	private int productId;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="main_product_id")
	public Integer getMainProductId() {
		return mainProductId;
	}

	public void setMainProductId(Integer mainProductId) {
		this.mainProductId = mainProductId;
	}

	@Column(name="product_id")
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
