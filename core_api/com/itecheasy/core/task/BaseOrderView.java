package com.itecheasy.core.task;

import java.util.Date;

/**
 * @author wanghw
 * @date 2016-12-6
 * @description TODO
 * @version 1.2.2
 */
public class BaseOrderView {
	private String code;
	private int id;
	private Integer sendGroupId;
	private int tableType;
	private int status;

	/** 无值 字段 */
	private Date deliveryDate;
	private Double costFreight;
	private String trackingCode;
	/** 无值 字段 */

	
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Double getCostFreight() {
		return costFreight;
	}

	public void setCostFreight(Double costFreight) {
		this.costFreight = costFreight;
	}

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getSendGroupId() {
		return sendGroupId;
	}

	public void setSendGroupId(Integer sendGroupId) {
		this.sendGroupId = sendGroupId;
	}

	public int getTableType() {
		return tableType;
	}

	public void setTableType(int tableType) {
		this.tableType = tableType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
