package com.itecheasy.core.product;

import java.util.Date;

/**
 * @author whw
 * @date 2017-8-16
 * @description TODO
 * @version
 */
public class ProductDevelop {
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
	 * 销售额
	 */
	private double sales;

	/**
	 * 增加人
	 */
	private int addOne;

	/**
	 * 增加时间
	 */
	private Date addDate;

	private String primaryPictureCode;
	private int cmsProductId;
	
	private String brand;
	/**
	 * 销售批量
	 */
	private int saleQty;

	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	public String getPrimaryPictureCode() {
		return primaryPictureCode;
	}

	public void setPrimaryPictureCode(String primaryPictureCode) {
		this.primaryPictureCode = primaryPictureCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public Date getPutawayDate() {
		return putawayDate;
	}

	public void setPutawayDate(Date putawayDate) {
		this.putawayDate = putawayDate;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public int getAddOne() {
		return addOne;
	}

	public void setAddOne(int addOne) {
		this.addOne = addOne;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(int saleQty) {
		this.saleQty = saleQty;
	}

	
	
}
