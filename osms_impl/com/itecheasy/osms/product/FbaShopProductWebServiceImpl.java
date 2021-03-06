package com.itecheasy.osms.product;

import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.fba.*;
import com.itecheasy.core.product.ShopProductCmsInfo;
import com.itecheasy.core.product.ShopProductCmsInfoService;

/** 
 * @author wanghw
 * @date 2016-12-2 
 * @description TODO
 * @version 1.2.2
 */
public class FbaShopProductWebServiceImpl implements FbaShopProductWebService {
	private FbaShopProductService fbaShopProductService;
	private ShopProductInventoryService shopProductInventoryService;
	private ShopProductCmsInfoService shopProductCmsInfoService;
	
	

	public void setShopProductCmsInfoService(ShopProductCmsInfoService shopProductCmsInfoService) {
		this.shopProductCmsInfoService = shopProductCmsInfoService;
	}

	public void setShopProductInventoryService(ShopProductInventoryService shopProductInventoryService) {
		this.shopProductInventoryService = shopProductInventoryService;
	}

	public void setFbaShopProductService(FbaShopProductService fbaShopProductService) {
		this.fbaShopProductService = fbaShopProductService;
	}

	@Override
	public void addFbaShopProduct(List<FbaShopProduct> shopProducts) {
		if(CollectionUtils.isNotEmpty(shopProducts)){
			for (FbaShopProduct fbaShopProduct : shopProducts) {
				fbaShopProductService.mergeFbaShopProduct(fbaShopProduct);
			}
		}
	}

	@Override
	public void confirmFbaShopProduct(int[] fbaShopProductIds) {
		fbaShopProductService.confirmFbaShopProduct(fbaShopProductIds);
	}

	@Override
	public ShopProductRelated getRelatedBySku(String sku, int shopId) {
		return fbaShopProductService.getRelatedBySku(sku, shopId);
	}

	@Override
	public ShopProductRelated getRelatedByOtherCode(String cmsProductCode, int shopId) {
		return fbaShopProductService.getRelatedByOtherCode(cmsProductCode, shopId);
	}

	@Override
	public PageList<ShopProductRelated> findShopProductRelated(SearchShopProductRelated search) {
		return fbaShopProductService.findShopProductRelated(search);
	}

	@Override
	public void addShopProductInventory(FbaShopProductInventory[] inventorys, int shopId) {
		if(inventorys==null)
			return;
		shopProductInventoryService.addShopProductInventorys(inventorys, shopId);
	}

	@Override
	public void setFbaInventorySecurityLine(int[] fbaShopProductIds, int value) {
		if(fbaShopProductIds==null)
			return;
		shopProductInventoryService.setFbaInventorySecurityLine(fbaShopProductIds, value);
	}

	@Override
	public void setSumInventorySercurityLine(int[] fbaShopProductIds, int value) {
		shopProductInventoryService.setSumInventorySercurityLine(fbaShopProductIds, value);
	}

	@Override
	public FbaShopProductInventory getFbaShopProductInventory(String sku, int shopId) {
		return shopProductInventoryService.getFbaShopProductInventory(sku, shopId);
	}

	@Override
	public FbaShopProductInventory getFbaShopProductInventoryByOtherCode(String cmsProductCode, int shopId) {
		return shopProductInventoryService.getFbaShopProductInventoryByOtherCode(cmsProductCode, shopId);
	}
	
	@Override
	public PageList<FbaShopProductInventoryDetail> findInventory(SearchShopProductInventory search) {
		return shopProductInventoryService.findInventory(search);
	}

	public ShopProductCmsInfo getProductCmsInfo(String cmsProductCode){
		return shopProductCmsInfoService.getShopProductCmsInfoByCode(cmsProductCode);
	}


	@Override
	public void updateSeaTransportationBlacklist(UpdateBlacklistVO updateBlacklistVO) {
		shopProductInventoryService.updateSeaTransportationBlacklist(updateBlacklistVO);
	}
}
