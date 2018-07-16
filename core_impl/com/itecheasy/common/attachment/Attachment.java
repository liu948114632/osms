package com.itecheasy.common.attachment;

import java.util.Date;

/**
 * @author wanghw
 * @date 2016-12-5
 * @description TODO
 * @version 1.2.2
 */
public class Attachment {
	protected int id;
	protected String fileName;
	protected String fileCode;
	protected Date joinDate;
	protected byte[] file;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
