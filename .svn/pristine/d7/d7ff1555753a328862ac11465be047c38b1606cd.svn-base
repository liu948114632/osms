package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-3-11
 * @description
 * @version 1.1.7
 */
@Entity
@Table(name = "fba_store_product_log")
public class FBAStoreProductLogPO {
	private int id;

	/**
	 * 类型 <em>0、库存补给  1、订单销售</em>
	 */
	private int type;
	private int objectId;
	private Integer availibleStockOfBefore;
	private Integer availibleStockOfAfter;
	private Integer availibleStockOfUsed;
	private Date logDate;
	private String operator;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "object_id")
	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	@Column(name = "availible_stock_of_before")
	public Integer getAvailibleStockOfBefore() {
		return availibleStockOfBefore;
	}

	public void setAvailibleStockOfBefore(Integer availibleStockOfBefore) {
		this.availibleStockOfBefore = availibleStockOfBefore;
	}

	@Column(name = "availible_stock_of_after")
	public Integer getAvailibleStockOfAfter() {
		return availibleStockOfAfter;
	}

	public void setAvailibleStockOfAfter(Integer availibleStockOfAfter) {
		this.availibleStockOfAfter = availibleStockOfAfter;
	}

	@Column(name = "availible_stock_of_used")
	public Integer getAvailibleStockOfUsed() {
		return availibleStockOfUsed;
	}

	public void setAvailibleStockOfUsed(Integer availibleStockOfUsed) {
		this.availibleStockOfUsed = availibleStockOfUsed;
	}

	@Column(name = "log_date")
	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	@Column
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
