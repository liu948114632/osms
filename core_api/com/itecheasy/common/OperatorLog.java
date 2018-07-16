package com.itecheasy.common;

import java.util.Date;

public class OperatorLog {

	private int id;
	private int status;
	private int objectId;
	private Date operatorTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 操作状态：1 INSERT,2 UPDATE,3 DELETE
	 * @return
	 */
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	public Date getOperatorTime() {
		return operatorTime;
	}
	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}
	
	
	/*@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		if(obj instanceof OperatorLog){
			return ((OperatorLog)obj).getId() == id;
		}
		return false;
	}*/
	
	
}
