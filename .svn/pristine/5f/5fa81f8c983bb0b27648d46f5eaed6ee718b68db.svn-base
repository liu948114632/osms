package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author whw
 * @date 2017-8-22
 * @description TODO
 * @version
 */
@Entity
@Table(name="order_tracking_product")
public class OrderTrackingProductPO {
	private int id;
	private int orderTrackingId;
	private int status;
	private boolean deleted;
	private int cmsProductId;
	private String cmsProductCode;
	private String branchRemark;
	private String consultationContent;
	private int operatorId;
	private Date replyDate;

	/**
	 * 根进人
	 */
	private int followUpUser;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	@Column(name="Status")
	public int getStatus() {
		return status;
	}

	@Column(name = "order_tracking_id")
	public int getOrderTrackingId() {
		return orderTrackingId;
	}

	public void setOrderTrackingId(int orderTrackingId) {
		this.orderTrackingId = orderTrackingId;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="deleted")
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name="cms_product_id")
	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	@Column(name="cms_product_code")
	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	@Column(name="branch_remark")
	public String getBranchRemark() {
		return branchRemark;
	}

	public void setBranchRemark(String branchRemark) {
		this.branchRemark = branchRemark;
	}

	@Column(name="consultation_content")
	public String getConsultationContent() {
		return consultationContent;
	}

	public void setConsultationContent(String consultationContent) {
		this.consultationContent = consultationContent;
	}

	@Column(name="operator_id")
	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	@Column(name="reply_time")
	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	@Column(name="follow_up_user")
	public int getFollowUpUser() {
		return followUpUser;
	}

	public void setFollowUpUser(int followUpUser) {
		this.followUpUser = followUpUser;
	}

}
