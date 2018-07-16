package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

/**
 * @author wanghw
 * @date 2016-12-6
 * @description type:1、[order] + 2、replenishment_order
 * @version 1.2.2
 */
@Entity
@Table(name = "v_order_all")
public class BaseOrderViewPO {
	private String code;
	private int id;
	private Integer sendGroupId;
	private int tableType;
	private int status;

	@Id
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="send_group_id")
	public Integer getSendGroupId() {
		return sendGroupId;
	}

	public void setSendGroupId(Integer sendGroupId) {
		this.sendGroupId = sendGroupId;
	}

	@Column(name="type")
	public int getTableType() {
		return tableType;
	}

	public void setTableType(int tableType) {
		this.tableType = tableType;
	}

	@Column
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
