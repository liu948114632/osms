package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "product_freeze_stock")
public class ProductFreezeStockPo {
	private int id;
	private int productId;
	private String cmsProductCode;
	private int shouldQty;
	private int operator;
	private boolean currentFreeze;
	private int departmentId;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="product_id")
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name="cms_product_code")
	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	@Column(name="should_qty")
	public int getShouldQty() {
		return shouldQty;
	}

	public void setShouldQty(int shouldQty) {
		this.shouldQty = shouldQty;
	}

	@Column(name="operator")
	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	@Column(name="currentFreeze")
	public boolean isCurrentFreeze() {
		return currentFreeze;
	}

	public void setCurrentFreeze(boolean currentFreeze) {
		this.currentFreeze = currentFreeze;
	}

	@Column(name="department_id")
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

}
