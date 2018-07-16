package com.itecheasy.osms.product;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itecheasy.common.PageList;
import com.itecheasy.core.fba.*;
import com.itecheasy.core.product.ShopProductCmsInfo;

/** 
 * @author wanghw
 * @date 2016-12-2 
 * @description TODO
 * @version 1.2.2
 */
@WebService
public interface FbaShopProductWebService {
	/**
	 * 导入fba店铺商品
	 * --状态已确认
	 * @param shopProduct
	 */
	void addFbaShopProduct(@WebParam(name="shopProducts")List<FbaShopProduct> shopProducts);

	/**
	 * 确认fba店铺商品
	 * @param fbaShopProductIds
	 */
	void confirmFbaShopProduct(@WebParam(name="fbaShopProductIds")int[] fbaShopProductIds);
	
	ShopProductRelated getRelatedBySku(@WebParam(name="sku")String sku,@WebParam(name="shopId")int shopId);
	
	ShopProductRelated getRelatedByOtherCode(@WebParam(name="cmsProductCode")String cmsProductCode,@WebParam(name="shopId")int shopId);
	
	PageList<ShopProductRelated> findShopProductRelated(@WebParam(name="search")SearchShopProductRelated search);
	
	
	
	
	/**
	 * 新增fba店铺商品库存信息
	 * @param inventory
	 */
	void addShopProductInventory(@WebParam(name="inventorys")FbaShopProductInventory[] inventorys,@WebParam(name="shopId")int shopId);
	
	/**
	 * 修改FBA库存警戒值
	 * @param fbaShopProductIds
	 * @param value
	 */
	void setFbaInventorySecurityLine(@WebParam(name="fbaShopProductIds")int[] fbaShopProductIds,@WebParam(name="value")int value);
	
	/**
	 * 修改总库存警戒值
	 * @param fbaShopProductIds
	 * @param value
	 */
	void setSumInventorySercurityLine(@WebParam(name="fbaShopProductIds")int[] fbaShopProductIds,@WebParam(name="value")int value);
	
	FbaShopProductInventory getFbaShopProductInventory(@WebParam(name="sku")String sku,@WebParam(name="shopId")int shopId);
	FbaShopProductInventory getFbaShopProductInventoryByOtherCode(@WebParam(name="cmsProductCode")String cmsProductCode,@WebParam(name="shopId")int shopId);
	
	PageList<FbaShopProductInventoryDetail> findInventory(@WebParam(name="search")SearchShopProductInventory search);
	
	ShopProductCmsInfo getProductCmsInfo(@WebParam(name="cmsProductCode")String cmsProductCode);


	/**
	 * 更新海运黑名单
	 *
	 * @param updateBlacklistVO
	 */
	void updateSeaTransportationBlacklist(@WebParam(name="updateBlacklistVO")UpdateBlacklistVO updateBlacklistVO);


}
