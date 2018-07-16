package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2016-2-18
 * @description 问题件答复附件
 * @version 1.1.7
 */
@Entity
@Table(name="package_problem_attachment")
public class PackageProblemAttachmentPO {
	private int id;
	private int packageProblemHistoryId;
	private String fileName;
	private String fileCode;
	private Date joinDate;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="package_problem_history")
	public int getPackageProblemHistoryId() {
		return packageProblemHistoryId;
	}

	public void setPackageProblemHistoryId(int packageProblemHistoryId) {
		this.packageProblemHistoryId = packageProblemHistoryId;
	}

	@Column(name="file_name")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name="file_code")
	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	@Column(name="join_date")
	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
