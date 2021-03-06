package com.itecheasy.core;

/**
 * @author wanghw
 * @date 2016-1-14
 * @description 分页查询条件基类
 * @version
 */
public class BaseSearchForm {
	private int currentPage;
	private int pageSize;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
