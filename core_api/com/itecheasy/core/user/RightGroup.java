package com.itecheasy.core.user;

import java.io.Serializable;

public class RightGroup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7073176875773344407L;
	private int id;
	private int parentID;
	private String name;
	private String code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
