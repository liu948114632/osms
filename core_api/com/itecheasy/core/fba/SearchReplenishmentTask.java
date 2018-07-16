package com.itecheasy.core.fba;

import java.util.Date;
import java.util.List;

/**
 * @author wanghw
 * @date 2016-12-1
 * @description C3补货任务查询条件
 * @version 1.2.2
 */
public class SearchReplenishmentTask {
	private int pageSiez;
	private int currentPage;
	private String cmsProductCode;
	private List<String> cmsProductCodes;
	private String replenishmentTaskCode;
	private int status;
	private int creater;
	private Date createDateBegin;
	private Date createDateEnd;
	private Date orderedDateBegin;
	private Date orderedDateEnd;
	private int type;
	private int auditor;
	private int isSample;
	private int waitMoreBatchAudit ;
	private int partProductWaitMoreBatchAudit;

	public int getPageSiez() {
		return pageSiez;
	}

	public void setPageSiez(int pageSiez) {
		this.pageSiez = pageSiez;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	public List<String> getCmsProductCodes() {
		return cmsProductCodes;
	}

	public void setCmsProductCodes(List<String> cmsProductCodes) {
		this.cmsProductCodes = cmsProductCodes;
	}

	public String getReplenishmentTaskCode() {
		return replenishmentTaskCode;
	}

	public void setReplenishmentTaskCode(String replenishmentTaskCode) {
		this.replenishmentTaskCode = replenishmentTaskCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCreater() {
		return creater;
	}

	public void setCreater(int creater) {
		this.creater = creater;
	}

	public Date getCreateDateBegin() {
		return createDateBegin;
	}

	public void setCreateDateBegin(Date createDateBegin) {
		this.createDateBegin = createDateBegin;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAuditor() {
		return auditor;
	}

	public void setAuditor(int auditor) {
		this.auditor = auditor;
	}

	public Date getOrderedDateBegin() {
		return orderedDateBegin;
	}

	public void setOrderedDateBegin(Date orderedDateBegin) {
		this.orderedDateBegin = orderedDateBegin;
	}

	public Date getOrderedDateEnd() {
		return orderedDateEnd;
	}

	public void setOrderedDateEnd(Date orderedDateEnd) {
		this.orderedDateEnd = orderedDateEnd;
	}

	public int getIsSample() {
		return isSample;
	}

	public void setIsSample(int isSample) {
		this.isSample = isSample;

	
	}

	public int getWaitMoreBatchAudit() {
		return waitMoreBatchAudit;
	}

	public void setWaitMoreBatchAudit(int waitMoreBatchAudit) {
		this.waitMoreBatchAudit = waitMoreBatchAudit;
	}

	public int getPartProductWaitMoreBatchAudit() {
		return partProductWaitMoreBatchAudit;
	}

	public void setPartProductWaitMoreBatchAudit(int partProductWaitMoreBatchAudit) {
		this.partProductWaitMoreBatchAudit = partProductWaitMoreBatchAudit;
	}
	
	
}
