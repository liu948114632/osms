package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author whw
 * @date 2017-8-16
 * @description TODO
 * @version
 */
@Entity
@Table(name = "product_develop")
public class ProductDevelopPO {
	private int id;
	private String cmsProductCode;
	/**
	 * 开发人
	 */
	private String developer;
	/**
	 * 上架时间
	 */
	private Date putawayDate;

	/**
	 * 增加人
	 */
	private int addOne;

	/**
	 * 增加时间
	 */
	private Date addDate;

	/**
	 * 销售额
	 */
	private double sales;

	private String brand;

	/**
	 * 销售批量
	 */
	private int saleQty;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "cms_product_code")
	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	@Column(name = "developer")
	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	@Column(name = "putaway_date")
	public Date getPutawayDate() {
		return putawayDate;
	}

	public void setPutawayDate(Date putawayDate) {
		this.putawayDate = putawayDate;
	}

	@Column(name = "add_one")
	public int getAddOne() {
		return addOne;
	}

	public void setAddOne(int addOne) {
		this.addOne = addOne;
	}

	@Column(name = "add_date")
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	@Column
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name="sale_qty")
	public int getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(int saleQty) {
		this.saleQty = saleQty;
	}

}
