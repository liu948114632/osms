package com.itecheasy.webservice.cms.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for page complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="page">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currentPage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endRowNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pageCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startRowNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalRowCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "page", propOrder = { "currentPage", "endRowNumber", "pageCount", "pageSize", "startRowNumber",
		"totalRowCount" })
public class Page {

	protected int currentPage;
	protected int endRowNumber;
	protected int pageCount;
	protected int pageSize;
	protected int startRowNumber;
	protected int totalRowCount;

	/**
	 * Gets the value of the currentPage property.
	 * 
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * Sets the value of the currentPage property.
	 * 
	 */
	public void setCurrentPage(int value) {
		this.currentPage = value;
	}

	/**
	 * Gets the value of the endRowNumber property.
	 * 
	 */
	public int getEndRowNumber() {
		return endRowNumber;
	}

	/**
	 * Sets the value of the endRowNumber property.
	 * 
	 */
	public void setEndRowNumber(int value) {
		this.endRowNumber = value;
	}

	/**
	 * Gets the value of the pageCount property.
	 * 
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * Sets the value of the pageCount property.
	 * 
	 */
	public void setPageCount(int value) {
		this.pageCount = value;
	}

	/**
	 * Gets the value of the pageSize property.
	 * 
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * Sets the value of the pageSize property.
	 * 
	 */
	public void setPageSize(int value) {
		this.pageSize = value;
	}

	/**
	 * Gets the value of the startRowNumber property.
	 * 
	 */
	public int getStartRowNumber() {
		return startRowNumber;
	}

	/**
	 * Sets the value of the startRowNumber property.
	 * 
	 */
	public void setStartRowNumber(int value) {
		this.startRowNumber = value;
	}

	/**
	 * Gets the value of the totalRowCount property.
	 * 
	 */
	public int getTotalRowCount() {
		return totalRowCount;
	}

	/**
	 * Sets the value of the totalRowCount property.
	 * 
	 */
	public void setTotalRowCount(int value) {
		this.totalRowCount = value;
	}

}
