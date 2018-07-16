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
@Table(name="order_tracking_product_attachment")
public class OrderTrackingProductAttachmentPO {
	private int id;
	private int orderTrackingId;
	private String fileCode;
	private String fileName;
	private Date joinDate;
	private String originalFileName;
	private int orderTrackingProductId;

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

	@Column(name="file_code")
	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	@Column(name="fileName")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name="join_date")
	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Column(name="originalFileName")
	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	@Column(name="order_tracking_product_id")
	public int getOrderTrackingProductId() {
		return orderTrackingProductId;
	}

	public void setOrderTrackingProductId(int orderTrackingProductId) {
		this.orderTrackingProductId = orderTrackingProductId;
	}
	
	

}
