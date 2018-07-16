package com.itecheasy.core.product;

import java.util.List;

import com.itecheasy.core.BussinessException;

/**
 * @author wanghw
 * @date 2016-12-2
 * @description 店铺商品的cms信息
 * @version 1.2.2
 */
public interface ShopProductCmsInfoService {
	final static String EX_PRODUCT_NOT_EXIST="商品不存在";
	
	/**
	 * 同步cms最新信息 并添加/更新
	 * @param cmsProductCode
	 * @return cmsProductId
	 * @throws BussinessException {@link #EX_PRODUCT_NOT_EXIST}
	 */
	public int mergeShopProductCmsInfo(String cmsProductCode);
	
	/**
	 * 添加
	 * @param cmsProductCode
	 * @return cmsProductId
	 * @throws BussinessException {@link #EX_PRODUCT_NOT_EXIST}
	 */
	public int addShopProductCmsInfo(String cmsProductCode);
	
	ShopProductCmsInfo getShopProductCmsInfoById(int cmsProductId);
	
	ShopProductCmsInfo getShopProductCmsInfoByCode(String cmsProductCode);
	
	/**
	 * 定时同步cms信息
	 */
	int syncCmsProductInfo(int pageSize, int currentPage);
	
	/**
	 * 更新C3待补货量、设置是否提醒cms补货标识,(C3待补货批量>0)(规则废除)
	 * <br>
	 * <code>c3待补货批量 = 总警戒库存和 - 总FBA可用库存 - c3可用库存（批量） - 补货中批量(规则废除)<code>
	 * <b>再设置待补货的量<b>
	 * @param cmsProductId
	 */
	@Deprecated
	void setIsRemindCmsReplenishment(int... cmsProductIds);
	
	/** 
	 * 设置cms补货中的值
	 * <br>
	 * <code>补货中批量：统计的值，统计非已完成的c3补货订单中，任务状态为非已结束的商品的补货批数之和，减出来为负的记作0<code>
	 * <b>先设置补货中的量<b>
	 * @param cmsProductId
	 */
	void setTheCmsReplenishment(int... cmsProductIds);
	
	/**
	 * cms补货,更新补货中的量
	 * <br>影响cms待补货数量
	 * <br><code>c3待补货批量 = 总警戒库存和 - 总FBA可用库存 - c3可用库存（批量） - 补货中批量(规则废除)<code>
	 * @param cmsProductId
	 * @param replenishmentNum +增加补货任务的批量/-取消补货任务的批量
	 */
	void cmsReplenishment(int cmsProductId);
	
	/**
	 * 根据sku查询店铺商品的cms信息
	 * @param sku
	 * @param shopId
	 * @return
	 */
	ShopProductCmsInfo getShopProductCmsInfo(String sku,int shopId );
	
	/**
	 * 按淡旺季规则统计cms待补货量
	 */
	public void statisticsCmsAwaitReplenishment();
	
	
	/**
	 * 更新待补货值(新规则)
	 * @param cmsProductId
	 */
	public void updateAwaitReplenishment(int cmsProductId);
}
