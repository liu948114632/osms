package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2017-08-22
 * @description TODO
 * @version
 */
@Entity
@Table(name="order_tracking_item")
public class OrderTrackingItemPO {
	private int id;
	private int orderTrackingId;
	private String content;
	private Date replyDate;
	private int replyUserId;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="order_tracking_id")
	public int getOrderTrackingId() {
		return orderTrackingId;
	}
	public void setOrderTrackingId(int orderTrackingId) {
		this.orderTrackingId = orderTrackingId;
	}
	
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="replay_time")
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	@Column(name="replay_user_id")
	public int getReplyUserId() {
		return replyUserId;
	}
	public void setReplyUserId(int replyUserId) {
		this.replyUserId = replyUserId;
	}
	
	
}
