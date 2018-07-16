package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2017-1-11
 * @description TODO
 * @version 1.2.2
 */
@Table(name = "modify_record_order")
@Entity
public class ModifyRecordOrderPO {
	private int id;
	private String code;
	private Date createTime;
	private String createUserName;
	private String orderCode;
	private String remark;
	private int status;
	private int type;
	private int bussinessId;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="create_date")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="creator")
	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	@Column(name="order_code")
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name="bussiness_id")
	public int getBussinessId() {
		return bussinessId;
	}

	public void setBussinessId(int bussinessId) {
		this.bussinessId = bussinessId;
	}

}
