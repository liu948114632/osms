package com.itecheasy.core.prepare;

import java.util.Date;

/**
 * @author taozihao
 * @date 2018年7月2日 上午8:40:31
 * @description 海运备货计划操作日志
 */
public class SeaTransportationPlanOperateLogVO {
	private Date date;
	private String operator;
	private String comment;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
