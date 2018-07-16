package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-6-22
 * @description TODO
 * @version
 */
@Entity
@Table(name = "config_dms_dept")
public class ConfigDMSPO {
	private int id;
	private int orderSource;
	private String accountNumber;
	private String signature;
	private String dept;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public int getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(int orderSource) {
		this.orderSource = orderSource;
	}

	@Column(name = "dms_dept_accountNumber")
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name = "dms_dept_signature")
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Column(name = "dms_dept")
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
