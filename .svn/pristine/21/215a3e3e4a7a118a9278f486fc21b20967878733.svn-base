package com.itecheasy.core.fba;

import java.util.Date;

/** 
 * fba标识值比较的各种元素
 * @author wanghw
 * @date 2016-12-10 
 * @description X天销量（X要求随时能调整）、FBA警戒库存、总警戒库存、FBA可用库存、c3可用库存、总库存=fba可用库存+c3可用库存
 * @version 1.2.2
 */
public interface IFbaShopProductComparableElement {
	
	/**
	 * 总警戒库存之和
	 * @param cmsProductId
	 * @return
	 */
	public int getTotalOfSumInventorySercurityLine(int cmsProductId);
	
	
	/**
	 * 总警戒库存
	 * @param fbaShopProductId
	 * @return
	 */
	public int getSumInventorySercurityLine(int fbaShopProductId);
	
	/**
	 * fba警戒库存
	 * @param fbaShopProductId
	 * @return
	 */
	public int getFbaInventorySercurityLine(int fbaShopProductId);
	
	/**
	 * fba可用库存之和
	 * @param cmsProductId
	 * @return
	 */
	int getTotalOfFbaAvailable(int cmsProductId);
	
	/**
	 * fba可用库存
	 * @param fbaShopProductId
	 * @return
	 */
	int getFbaAvailable(int fbaShopProductId);
	
	/**
	 * cms可用库存(可用库存/批量数量 )
	 * @param cmsProductId
	 * @return
	 */
	int getCmsAvailable(int cmsProductId);
	
	/**
	 * X天fba订单销量
	 * @param fbaShopProductId
	 * @param shopId
	 * @return
	 */
	int getFbaSalesInfo(int fbaShopProductId);
	
	/**
	 * X天订单销量
	 * @param fbaShopProductId
	 * @return
	 */
	int getOrderSalesInfo(int fbaShopProductId);
	
	/**
	 * cms补货中的量(统计的值，统计非已完成的c3补货订单中，任务状态为非已结束的商品的补货批数之和)
	 * @param cmsProductId
	 * @return
	 */
	int getCmsTheReplenishment(int cmsProductId);
	
	/**
	 * fba补货中的量(实时计算非已入仓状态的fba补货订单中商品的批数之和)
	 * @param fbaShopProductId
	 * @return
	 */
	int getFbaTheReplenishment(int fbaShopProductId);
	
	/**
	 * 最后补货日期
	 * @param cmsProductId
	 * @return
	 */
	Date getCmsLastReplenishmentDate(int cmsProductId);
}
