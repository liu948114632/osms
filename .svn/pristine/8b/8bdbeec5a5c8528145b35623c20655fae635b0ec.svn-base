package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_right")
public class RoleRightPO {
	private Integer id;
	private Integer roleID;
	private Integer rightID;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "role_id")
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	@Column(name = "right_id")
	public Integer getRightID() {
		return rightID;
	}
	public void setRightID(Integer rightID) {
		this.rightID = rightID;
	}
}
