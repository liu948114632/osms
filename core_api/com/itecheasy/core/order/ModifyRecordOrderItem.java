package com.itecheasy.core.order;

/**
 * @author wanghw
 * @date 2017-1-11
 * @description TODO
 * @version 1.2.2
 */
public class ModifyRecordOrderItem {
	protected String cause;
	protected int id;
	protected String newValue;
	protected String oldValue;
	protected int operatorType;
	protected String productCode;
	protected int productId;
	protected String remark;
	protected int ModifyRecordOrderId;
	protected int orderItemStatus;
	protected Integer modifyQty; 

	public int getOrderItemStatus() {
		return orderItemStatus;
	}

	public void setOrderItemStatus(int orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}

	public int getModifyRecordOrderId() {
		return ModifyRecordOrderId;
	}

	public void setModifyRecordOrderId(int modifyRecordOrderId) {
		ModifyRecordOrderId = modifyRecordOrderId;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public int getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(int operatorType) {
		this.operatorType = operatorType;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getModifyQty() {
		return modifyQty;
	}

	public void setModifyQty(Integer modifyQty) {
		this.modifyQty = modifyQty;
	}

	
}
