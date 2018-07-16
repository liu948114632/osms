package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2017-1-11
 * @description TODO
 * @version 1.2.2
 */
@Entity
@Table(name = "modify_record_order_item")
public class ModifyRecordOrderItemPO {
	private String cause;
	private int id;
	private String newValue;
	private String oldValue;
	private int operatorType;
	private String productCode;
	private int productId;
	private String remark;
	private int modifyRecordOrderId;
	private Integer modifyQty;
	

	@Column
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="new_value")
	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	@Column(name="old_value")
	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	@Column(name="operator_type")
	public int getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(int operatorType) {
		this.operatorType = operatorType;
	}

	@Column(name="product_code")
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name="product_id")
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="modify_record_order_id")
	public int getModifyRecordOrderId() {
		return modifyRecordOrderId;
	}

	public void setModifyRecordOrderId(int modifyRecordOrderId) {
		this.modifyRecordOrderId = modifyRecordOrderId;
	}

	@Column(name="modify_qty")
	public Integer getModifyQty() {
		return modifyQty;
	}

	public void setModifyQty(Integer modifyQty) {
		this.modifyQty = modifyQty;
	}

	
}
