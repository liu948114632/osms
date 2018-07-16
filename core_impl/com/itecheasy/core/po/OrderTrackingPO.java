package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2015-12-10
 * @description TODO
 * @version
 */
@Entity
@Table(name="order_tracking")
public class OrderTrackingPO {
	private int id;
	private String code;
	private String orderCode;
	private int type;
	private int consultationUserId;
	private Date consultationTime;
	private String content;
	private int createUserId;
	private int status;			 //30 已修改
	private int replyUserId;
	private String replyContent;
	private Date replyDate;
	private String remark;
	private boolean formCMS;
	private boolean deleted;

	private Boolean isRead;   //message is read 	未读0(false)		已读1(true)


	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="order_code")
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Column(name="type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name="consultation_user_id")
	public int getConsultationUserId() {
		return consultationUserId;
	}

	public void setConsultationUserId(int consultationUserId) {
		this.consultationUserId = consultationUserId;
	}

	@Column(name="consultation_time")
	public Date getConsultationTime() {
		return consultationTime;
	}

	public void setConsultationTime(Date consultationTime) {
		this.consultationTime = consultationTime;
	}

	@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="create_user_id")
	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="reply_user_id")
	public int getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(int replyUserId) {
		this.replyUserId = replyUserId;
	}

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="deleted")
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name="IsFormCMS")
	public boolean isFormCMS() {
		return formCMS;
	}

	public void setFormCMS(boolean formCMS) {
		this.formCMS = formCMS;
	}

	@Column(name="reply_content")
	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Column(name="reply_time")
	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}


	@Column(name = "is_read")
	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}


}
