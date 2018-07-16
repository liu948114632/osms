package com.itecheasy.common;

/**
 */
public class Page implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3993582362307102257L;
	
	public static final int PAGESIZE_ONEPAGE = -1;
	private int pageSize;
	private int currentPage;
	protected int totalRowCount;
	protected int startRowNumber;
	protected int endRowNumber;
	protected int pageCount;

	public Page() {
		
	}
	
	public Page(int totalRowCount, int currentPage, int pageSize) {
		this.totalRowCount = totalRowCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		init();
	}
	
	private void init() {
		if (pageSize == PAGESIZE_ONEPAGE) {
			currentPage = 1;
			pageCount = 1;
			startRowNumber = 1;
			endRowNumber = totalRowCount;
			return;
		}
		if (currentPage <= 0 || totalRowCount < 0 || pageSize <= 0) {
			throw new RuntimeException("illegal page argument: " + currentPage + ", " + pageSize + ", " + totalRowCount);
		}
		pageCount = ((totalRowCount % pageSize) == 0 ? (totalRowCount / pageSize) : (totalRowCount / pageSize) + 1);
		if (pageCount == 0) { // 如果没有数据，设为第1页
			pageCount = 1;
		}
		if (currentPage > pageCount) {
			currentPage = pageCount; //
		}
		startRowNumber = (currentPage - 1) * pageSize + 1;
		endRowNumber = currentPage * pageSize > totalRowCount ? totalRowCount : currentPage * pageSize;
	}

	/**
	 * @return Returns the currentPage.
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @return Returns the pageCount.
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @return Returns the pageSize.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @return Returns the startRowNumber.
	 */
	public int getStartRowNumber() {
		return startRowNumber;
	}

	/**
	 * @return Returns the endRowNumber.
	 */
	public int getEndRowNumber() {
		return endRowNumber;
	}

	/**
	 * @return Returns the totalRowCount.
	 */
	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public void setStartRowNumber(int startRowNumber) {
		this.startRowNumber = startRowNumber;
	}

	public void setEndRowNumber(int endRowNumber) {
		this.endRowNumber = endRowNumber;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
}
