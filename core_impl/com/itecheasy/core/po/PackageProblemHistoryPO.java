package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-2-18
 * @description 问题件答复历史
 * @version 1.1.7
 */
@Entity
@Table(name="package_problem_history")
public class PackageProblemHistoryPO {
	private int id;
	private String content;
	private String replyUser;
	private Date replyDate;
	private int packageProblemId;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="reply_user")
	public String getReplyUser() {
		return replyUser;
	}

	public void setReplyUser(String replyUser) {
		this.replyUser = replyUser;
	}

	@Column(name="reply_date")
	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	@Column(name="package_problem_id")
	public int getPackageProblemId() {
		return packageProblemId;
	}

	public void setPackageProblemId(int packageProblemId) {
		this.packageProblemId = packageProblemId;
	}

}
