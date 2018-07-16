package com.itecheasy.core.order;

import java.util.Date;

/**
 * @author wanghw
 * @date 2016-2-18
 * @description 问题件答复附件
 * @version 1.1.7
 */
public class PackageProblemAttachment {
	private int id;
	private int packageProblemHistoryId;
	private String fileName;
	private String fileCode;
	private Date joinDate;
	private byte[] file;

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPackageProblemHistoryId() {
		return packageProblemHistoryId;
	}

	public void setPackageProblemHistoryId(int packageProblemHistoryId) {
		this.packageProblemHistoryId = packageProblemHistoryId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
