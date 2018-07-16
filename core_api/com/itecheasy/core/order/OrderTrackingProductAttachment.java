package com.itecheasy.core.order;

import java.util.Date;

/**
 * @author wanghw
 * @date 2015-12-10
 * @description TODO
 * @version
 */
public class OrderTrackingProductAttachment {
	private int id;
	private int orderTrackingId;
	private String fileCode;
	private String fileName;
	private String localURL;
	private Date joinDate;
	private String originalFileName;
	private int orderTrackingProductId;
	
	private byte[] files;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderTrackingId() {
		return orderTrackingId;
	}

	public void setOrderTrackingId(int orderTrackingId) {
		this.orderTrackingId = orderTrackingId;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLocalURL() {
		return localURL;
	}

	public void setLocalURL(String localURL) {
		this.localURL = localURL;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public int getOrderTrackingProductId() {
		return orderTrackingProductId;
	}

	public void setOrderTrackingProductId(int orderTrackingProductId) {
		this.orderTrackingProductId = orderTrackingProductId;
	}

	public byte[] getFiles() {
		return files;
	}

	public void setFiles(byte[] files) {
		this.files = files;
	}
	
	

}
