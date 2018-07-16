package com.itecheasy.core.order;

import java.util.Date;

/**
 * @author wanghw
 * @date 2016-3-11
 * @description
 * @version 1.1.7
 */
public class FBAStoreProductLog {
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

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public Integer getAvailibleStockOfBefore() {
		return availibleStockOfBefore;
	}

	public void setAvailibleStockOfBefore(Integer availibleStockOfBefore) {
		this.availibleStockOfBefore = availibleStockOfBefore;
	}

	public Integer getAvailibleStockOfAfter() {
		return availibleStockOfAfter;
	}

	public void setAvailibleStockOfAfter(Integer availibleStockOfAfter) {
		this.availibleStockOfAfter = availibleStockOfAfter;
	}

	public Integer getAvailibleStockOfUsed() {
		return availibleStockOfUsed;
	}

	public void setAvailibleStockOfUsed(Integer availibleStockOfUsed) {
		this.availibleStockOfUsed = availibleStockOfUsed;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

}
