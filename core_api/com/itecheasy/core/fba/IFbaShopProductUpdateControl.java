package com.itecheasy.core.fba;

import java.util.List;

/**
 * fba各项值更新应用场景：<br>
 * 1、修改总库存警戒值 <br>
 * 2、修改fba安全库存警戒值 <br>
 * 3、更新销量(店铺fba订单销量、店铺订单销量) <br>
 * 4、更新fba可用库存 <br>
 * 5、更新cms可用库存 <br>
 * 6、fba补货 <br>
 * 7、cms补货 <br>
 * 
 * @author wanghw
 * @date 2016-12-10
 * @description 
 * <code>FBA补货中数量=实时计算非已入仓状态的fba补货订单中商品的批数之和<code> <br>
 * <code>FBA待补货数量 = FBA警戒库存设置值 – FBA可用库存 – FBA补货中批数<code> <br>
 * <code>补货中批量：统计的值，统计非已完成的c3补货订单中，任务状态为非已结束的商品的补货批数之和<code> <br>
 * <code>c3待补货批量 = 总警戒库存和 - 总FBA可用库存 - c3可用库存（批量） - 补货中批量<code> <br>
 * @version 1.2.2
 */
public interface IFbaShopProductUpdateControl {

	/**
	 * 修改总警戒库存值<br>
	 * 影响<b>总库存警戒值报警标识 / cms待补货数<b>
	 * @param fbaShopProductId
	 */
	void updateSumInventorySercurityLine(List<Integer> fbaShopProductIds);
	
	/**
	 * 修改fba警戒库存值<br>
	 * 影响<b>fba警戒库存值报警标识 / fba待补货数(提醒fba补货标识)<b>
	 * @param fbaShopProductId
	 */
	void updateFbaInventorySercurityLine(List<Integer> fbaShopProductIds);
	
	/**
	 * 统计订单销量(店铺fba订单销量、店铺订单销量)<br>
	 * 影响<b>fba警戒库存值报警标识<b>
	 */
	void statisticsOrderSalesInfo4Fba(int fbaShopProductId);
	
	/**
	 * 统计订单销量(店铺订单销量)<br>
	 * 影响<b>总库存警戒值报警标识<b>
	 */
	void statisticsOrderSalesInfo4All(int fbaShopProductId);
	
	/**
	 * 更新fba可用库存 <br>
	 * 影响<b> fba待补货数(提醒fba补货标识)/ cms待补货数<b>
	 * @param fbaShopProductId
	 */
	void updateFbaAvailableStock(int... fbaShopProductIds);
	
	/**
	 * 更新cms可用库存 <br>
	 * 影响<b> cms待补货数<b>
	 * @param cmsProductId
	 */
	void updateCmsAvailableStock(int cmsProductId);
	
	/**
	 * cms补货,更新补货中的量
	 * <br>影响cms待补货数量
	 * <br><code>c3待补货批量 = 总警戒库存和 - 总FBA可用库存 - c3可用库存（批量） - 补货中批量(废除)<code>
	 * @param cmsProductId
	 * @param replenishmentNum +增加补货任务的批量/-取消补货任务的批量
	 */
	void cmsReplenishment(int cmsProductId);
	
	/**
	 * fba补货，更新fba补货中的量 <br>
	 * 影响<b> fba待补货数(提醒fba补货标识)<b>
	 * @param fbaShopProductId
	 * @param replenishmentNum
	 */
	void fbaReplenishment(int fbaShopProductId,int replenishmentNum);
}
