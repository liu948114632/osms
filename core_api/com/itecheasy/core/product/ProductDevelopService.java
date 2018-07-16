package com.itecheasy.core.product;

import java.util.Date;
import java.util.List;

import com.itecheasy.common.PageList;

/** 
 * @author whw
 * @date 2017-8-16 
 * @description 产品开发
 * @version 
 */
public interface ProductDevelopService {
	/**
	 * 统计提醒显示
	 */
	static final String STATISTICS_SALES_LOG = "statisticsSales";
	/**
	 * 导入产品开发记录
	 * @param productDevelops
	 * @param operator
	 */
	void addProductDevelop(List<ProductDevelop> productDevelops,int operator);
	
	PageList<ProductDevelop> findProductDevelop(ProductDevelopSearch search);
	
	ProductDevelop getProductDevelopByProduct(String productCode);
	
	List<String> getDeveloper();

	/**
	 * 统计销售额
	 */
	void statisticsSales(Date begin,Date end);
}
