package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2015-3-25
 * @description TODO
 * @version
 */
@Entity
@Table(name = "am_shop_product_detail")
public class AMShopProductDetailPo {
	private int id;
	private int amShopProductId;
	private String value;
	private int template;
	private int operator;
	private Date time;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="am_shop_product_id")
	public int getAmShopProductId() {
		return amShopProductId;
	}

	public void setAmShopProductId(int amShopProductId) {
		this.amShopProductId = amShopProductId;
	}

	@Column(name="value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name="template_id")
	public int getTemplate() {
		return template;
	}

	public void setTemplate(int template) {
		this.template = template;
	}

	@Column(name="operator")
	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	@Column(name="time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	
}
