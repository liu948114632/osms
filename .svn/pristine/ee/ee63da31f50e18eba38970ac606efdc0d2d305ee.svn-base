package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-2-25
 * @description fba库存商品
 * @version 1.1.7
 */
@Entity
@Table(name = "FBA_store_Product")
public class FBAStoreProductPO {
	private int id;
	private String productCode;
	private int shopId;

	/**
	 * 导入更新时间
	 */
	private Date updateDate;;
	/**
	 * 可用库存
	 */
	private int availibleStock;

	/**
	 * 最后补货时间
	 */
	private Date lastReplenishDate;

	/**
	 * 状态：0，上架 1，下架
	 */
	private int status;

	/**
	 * 初次入库时间
	 */
	private Date firstInStorageDate;

	/**
	 * 无销量开始时间 
	 * <ul>
	 * 未出过FBA订单的产品为：FBA库存商品导入时间
	 * </ul>
	 * 
	 * <ul>
	 * 已出过FBA订单的产品为：最后一个FBA订单下单时间
	 * </ul>
	 */
	private Date noSalesDate;
	
	private int operator;
	
	
	@Column
	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column
	public int getAvailibleStock() {
		return availibleStock;
	}

	public void setAvailibleStock(int availibleStock) {
		this.availibleStock = availibleStock;
	}

	@Column
	public Date getLastReplenishDate() {
		return lastReplenishDate;
	}

	public void setLastReplenishDate(Date lastReplenishDate) {
		this.lastReplenishDate = lastReplenishDate;
	}

	@Column
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column
	public Date getFirstInStorageDate() {
		return firstInStorageDate;
	}

	public void setFirstInStorageDate(Date firstInStorageDate) {
		this.firstInStorageDate = firstInStorageDate;
	}

	@Column
	public Date getNoSalesDate() {
		return noSalesDate;
	}

	public void setNoSalesDate(Date noSalesDate) {
		this.noSalesDate = noSalesDate;
	}

	@Column
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

}
