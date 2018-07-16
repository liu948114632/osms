package com.itecheasy.core.product;

import java.util.Date;
import java.util.List;

import com.itecheasy.core.BaseSearchForm;

/**
 * @author whw
 * @date 2017-8-16
 * @description TODO
 * @version
 */
public class ProductDevelopSearch extends BaseSearchForm {
	private String productCode;
	private List<String> productCodes;
	private String developer;
	private Date putawayDateBegin;
	private Date putawayDateEnd;
	private Double salesBegin;
	private Double salesEnd;
	private ProductDevelopSearchOrderRule orderRule;
	private ProductDevelopSearchOrderSort orderSort;

	public enum ProductDevelopSearchOrderSort {
		ASC("ASC"), DESC("DESC");
		
		private String colmun;

		public String getColmun() {
			return colmun;
		}
		
		private ProductDevelopSearchOrderSort(String colmun) {
			this.colmun=colmun;
		}
	}

	public enum ProductDevelopSearchOrderRule {
		CMS_PRODUCT_CODE("cms_product_code"), 
		DEVELOPER("developer"), 
		PUTAWAY_DATE("putaway_date"), 
		SALES("sales"), 
		ADD_ONE("add_one"),
		ADD_DATE("add_date"),
		SALE_QTY("sale_qty");
		private String colmun;
		public String getColmun() {
			return colmun;
		}
		
		private ProductDevelopSearchOrderRule(String colmun) {
			this.colmun=colmun;
		}
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public List<String> getProductCodes() {
		return productCodes;
	}

	public void setProductCodes(List<String> productCodes) {
		this.productCodes = productCodes;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public Date getPutawayDateBegin() {
		return putawayDateBegin;
	}

	public void setPutawayDateBegin(Date putawayDateBegin) {
		this.putawayDateBegin = putawayDateBegin;
	}

	public Date getPutawayDateEnd() {
		return putawayDateEnd;
	}

	public void setPutawayDateEnd(Date putawayDateEnd) {
		this.putawayDateEnd = putawayDateEnd;
	}

	public Double getSalesBegin() {
		return salesBegin;
	}

	public void setSalesBegin(Double salesBegin) {
		this.salesBegin = salesBegin;
	}

	public Double getSalesEnd() {
		return salesEnd;
	}

	public void setSalesEnd(Double salesEnd) {
		this.salesEnd = salesEnd;
	}

	public ProductDevelopSearchOrderRule getOrderRule() {
		return orderRule;
	}

	public void setOrderRule(ProductDevelopSearchOrderRule orderRule) {
		this.orderRule = orderRule;
	}

	public ProductDevelopSearchOrderSort getOrderSort() {
		return orderSort;
	}

	public void setOrderSort(ProductDevelopSearchOrderSort orderSort) {
		this.orderSort = orderSort;
	}

}
