package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "am_upc")
public class AMUPCPO {
	private int id;
	private String upc;
	private boolean status;
	private Integer amShopProductId;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="upc")
	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	@Column(name="status")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name="am_shop_product_id")
	public Integer getAmShopProductId() {
		return amShopProductId;
	}

	public void setAmShopProductId(Integer amShopProductId) {
		this.amShopProductId = amShopProductId;
	}

}
