package com.itecheasy.core.product;

/**
 * @author wanghw
 * @date 2015-3-28
 * @description 日志分页查询条件
 * @version
 */
public class searchLogForm {
	private int type;
	private int operator;
	private int result;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
