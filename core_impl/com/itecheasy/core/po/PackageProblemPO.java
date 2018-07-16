package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-2-18
 * @description 问题件
 * @version 1.1.7
 */
@Entity
@Table(name="package_problem")
public class PackageProblemPO {
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
	
	@Column(name="type_tag")
	public int getTypeTag() {
		return typeTag;
	}

	public void setTypeTag(int typeTag) {
		this.typeTag = typeTag;
	}

	@Column(name="confirm_type")
	public String getConfirmType() {
		return confirmType;
	}

	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	
	@Column
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="order_code")
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Column(name="order_id")
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name="[read]")
	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	@Column(name="create_user_name")
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="close_user_name")
	public String getCloseUser() {
		return closeUser;
	}

	public void setCloseUser(String closeUser) {
		this.closeUser = closeUser;
	}

	@Column(name="close_date")
	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	@Column
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="delivery_customer_service")
	public String getDeliveryCustomerService() {
		return deliveryCustomerService;
	}

	public void setDeliveryCustomerService(String deliveryCustomerService) {
		this.deliveryCustomerService = deliveryCustomerService;
	}

}
