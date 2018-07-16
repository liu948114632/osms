package com.itecheasy.core.task;
/**
 * @author taozihao
 * @date 2018年7月4日 上午11:14:14
 * @description
 */
public interface StatisticFbaShopProductService {
	/**
	 * 统计fba店铺商品月销量，往前挪两天
	 */
	public void autoStatisticFbaShopProductMonthSales();
	
	/**
	 * 统计连续3个月，每个月月销量大于50的商品
	 */
	public void autoStatisticThreeMonth();
	
	/**
	 * 统计商品是否走过海运
	 */
	public void autoUpdateHasSeaTransported();
}
