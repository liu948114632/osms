package com.itecheasy.core.order;

import java.util.Date;

/**
 * @author wanghw
 * @date 2016-2-18
 * @description 问题件业务对象
 * @version 1.1.7
 */
public class PackageProblem {
	private int id;
	private int status;
	private String orderCode;
	private int orderId;
	private boolean read;
	private String createUser;
	private Date createDate;
	private String closeUser;
	private Date closeDate;
	private String remark;
	private String deliveryCustomerService;
	private int type;
	private String confirmType;
	private int typeTag;
	
	
	public int getTypeTag() {
		return typeTag;
	}

	public void setTypeTag(int typeTag) {
		this.typeTag = typeTag;
	}

	public String getConfirmType() {
		return confirmType;
	}

	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCloseUser() {
		return closeUser;
	}

	public void setCloseUser(String closeUser) {
		this.closeUser = closeUser;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDeliveryCustomerService() {
		return deliveryCustomerService;
	}

	public void setDeliveryCustomerService(String deliveryCustomerService) {
		this.deliveryCustomerService = deliveryCustomerService;
	}

}
