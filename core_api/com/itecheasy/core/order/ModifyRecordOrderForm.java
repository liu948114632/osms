package com.itecheasy.core.order;

import java.util.Date;

/**
 * @author wanghw
 * @date 2017-1-11
 * @description TODO
 * @version 1.2.2
 */
public class ModifyRecordOrderForm {
	private int pageSize;
	private int currentPage;

	private String modifyRecordCode;
	private Date createTimeBegin;
	private Date createTimeEnd;
	private String createUserName;
	private int merchandiserId; //user id
	private String orderCode;
	private String productCode;

	private int status;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getModifyRecordCode() {
		return modifyRecordCode;
	}

	public void setModifyRecordCode(String modifyRecordCode) {
		this.modifyRecordCode = modifyRecordCode;
	}

	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(Date createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public int getMerchandiserId() {
		return merchandiserId;
	}

	public void setMerchandiserId(int merchandiserId) {
		this.merchandiserId = merchandiserId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
