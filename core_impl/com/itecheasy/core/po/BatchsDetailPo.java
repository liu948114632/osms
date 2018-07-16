package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "batchs_detail")
public class BatchsDetailPo {
	private int id;
	private int batchId;
	private int amShopProductId;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="batch_id")
	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	@Column(name="am_shop_product_id")
	public int getAmShopProductId() {
		return amShopProductId;
	}

	public void setAmShopProductId(int amShopProductId) {
		this.amShopProductId = amShopProductId;
	}

}
