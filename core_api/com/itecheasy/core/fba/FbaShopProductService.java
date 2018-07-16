package com.itecheasy.core.fba;

import java.util.Date;
import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.core.po.FbaShopProductPO;

/** 
 * @author wanghw
 * @date 2016-11-29 
 * @description fba店铺商品--cms商品关系
 * @version 1.2.2
 */
public interface FbaShopProductService {
	
	/**
	 * 增加/修改 fba店铺商品
	 * <br>cmsProductCode！=null 同步相关cms信息
	 * @param shopProduct
	 */
	int mergeFbaShopProduct(FbaShopProduct shopProduct);
	
	/**
	 * 添加
	 * @param shopProduct
	 */
	public void addFbaShopProduct(FbaShopProduct shopProduct) ;
	/**
	 * 设置fba店铺商品和cms商品的关系
	 * @param shopProduct
	 */
	void setFbaShopProductRelated(String cmsProductCode,int fbaShopProductId);

	/**
	 * 确认fba店铺商品
	 * @param fbaShopProductIds
	 */
	void confirmFbaShopProduct(int[] fbaShopProductIds);
	
	FbaShopProduct getFbaShopProduct(String sku,int shopId);
	
	FbaShopProduct getFbaShopProduct(int id);
	
	FbaShopProduct getFbaShopProductByOtherCode(String cmsProductCode,int shopId);
	
	ShopProductRelated getRelatedBySku(String sku,int shopId);
	
	ShopProductRelated getRelatedByOtherCode(String cmsProductCode,int shopId);
	
	PageList<ShopProductRelated> findShopProductRelated(SearchShopProductRelated search);
	
	public enum FbaShopProductStatus{
		待确认,已确认
	}

	void replaceSku(int shopId, String oldSku, String newSku);
	
	/**
	 * 统计自卖订单和fba订单销量
	 * @param startDate
	 * @param endDate
	 */
	public void statisticFbaShopProductMonthSales(Date startDate ,Date endDate);

	/**
	 * 获取满足销量的热销商品
	 * @param startDate
	 * @param endDate
	 * @param amount
	 */
	public List<String> getHotSaleProducts(Date startDate, Date endDate,int shopId, int amount);
	
	/**
	 * 查出店铺没有走过海运的商品
	 * @param shopId
	 * @return
	 */
	public List<FbaShopProductPO> getProductsNotSeaTransported(int shopId);
	
}
