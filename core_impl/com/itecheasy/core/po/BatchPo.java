package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "batches")
public class BatchPo {
	private int id;
	private int operator;
	private String name;
	private int departmentId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "operator")
	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "department_id")
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

}
