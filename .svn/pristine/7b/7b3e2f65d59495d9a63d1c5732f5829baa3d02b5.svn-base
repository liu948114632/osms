package com.itecheasy.core.order;

import java.util.Date;
import java.util.List;

import com.itecheasy.common.PageList;

/** 
 * @author wanghw
 * @date 2016-2-19 
 * @description TODO
 * @version 1.1.7
 */
public interface FBAStoreOrderService {
	
	/**
	 * 设置头程运费
	 * @param firstWayFreightSettings
	 */
	void setFirstWayFreights(List<FirstWayFreightSetting> firstWayFreightSettings);
	
	
	/**
	 * 查询头程运费
	 * @return
	 */
	List<FirstWayFreightSetting> getFirstWayFreightSettings(String version);

	FirstWayFreightSetting getFirstWayFreightSetting(String version, int country);
	
	
	/**
	 * 导入FBA库存商品
	 * 	<pre>1、sku唯一性，存在更新
	 *2、库存为0忽略
	 *3、> 则更新补货时间，记录补货日志
	 * </pre>
	 * @param fbaStoreProducts
	 */
	void importFBAStoreProducts(List<FBAStoreProduct> fbaStoreProducts,int operator);
	
	/**
	 * 消耗fba库存商品，记录销售记录
	 * @param sku
	 * @param lotNumber
	 */
	void usedFBAStoreProducts(String sku,int lotNumber,int shopId);
	
	/**
	 * fba库存统计
	 * @param form
	 * @return
	 */
	PageList<FBAStoreProductVO> countFBAStoreProducts(SearchFBAStorageCountForm form, int currentPage,
			int pageSize);
	
	/**
	 * fba库存统计详情
	 * @param fbaStoreProductId
	 * @return
	 */
	FBAStoreProductVO getFBAStoreProductCountDetail(int fbaStoreProductId);
	
	/**
	 * fba库存商品销量统计
	 * @return
	 */
	List<OrderCountReport> FBAStoreProductSales(OrderReportSearchForm form);
	
	/**
	 * fba库存商品日志
	 * @param fbaStoreProductId
	 * @return
	 */
	List<FBAStoreProductLog> getFBAStoreProductLogs(int fbaStoreProductId);

	void autoCountFBASales();


	void updateFBAStoreProductStatus(int fbaStoreProductId, int status);
	
	/**
	 * 7天销量
	 * ……
	 * 未来7天销量
	 * 7天增长率
	 * 42天预期补货
	 * 70天预期补货
	 */
}
