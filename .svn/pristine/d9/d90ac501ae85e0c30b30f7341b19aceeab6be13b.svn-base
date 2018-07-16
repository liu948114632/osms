package com.itecheasy.core.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2015-12-10
 * @description TODO
 * @version
 */
@Entity
@Table(name="v_order_trace")
public class VOrderTracePO  implements Serializable{
	private int id;
	private String code;
	private String orderCode;
	private int consultationUser;
	private String content;
	private int createUserId;
	private Date createDate;
	private int status;
	private String lastReplyContent;
	private Date lastReplyDate;
	private String lastReplyUser;
	private int type;
	private boolean deleted;
	private String consultationUserName;
	private boolean isRead;
	private boolean isFromCms;
	private String productCode;
	private String readed;
	
	
	@Column
	public String getConsultationUserName() {
		return consultationUserName;
	}

	public void setConsultationUserName(String consultationUserName) {
		this.consultationUserName = consultationUserName;
	}

	@Id
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

	@Column(name="order_code")
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Column(name="consultation_user")
	public int getConsultationUser() {
		return consultationUser;
	}

	public void setConsultationUser(int consultationUser) {
		this.consultationUser = consultationUser;
	}

	@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="create_user")
	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="last_reply_content")
	public String getLastReplyContent() {
		return lastReplyContent;
	}

	public void setLastReplyContent(String lastReplyContent) {
		this.lastReplyContent = lastReplyContent;
	}

	@Column(name="last_reply_date")
	public Date getLastReplyDate() {
		return lastReplyDate;
	}

	public void setLastReplyDate(Date lastReplyDate) {
		this.lastReplyDate = lastReplyDate;
	}

	@Column(name="last_reply_user")
	public String getLastReplyUser() {
		return lastReplyUser;
	}

	public void setLastReplyUser(String lastReplyUser) {
		this.lastReplyUser = lastReplyUser;
	}

	@Column
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name="deleted")
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Column(name="is_from_cms")
	public boolean isFromCms() {
		return isFromCms;
	}

	public void setFromCms(boolean isFromCms) {
		this.isFromCms = isFromCms;
	}

	@Column(name="product_code")
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name="readed")
	public String getReaded() {
		return readed;
	}

	public void setReaded(String readed) {
		this.readed = readed;
	}

	@Column(name="is_read")
	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
}
