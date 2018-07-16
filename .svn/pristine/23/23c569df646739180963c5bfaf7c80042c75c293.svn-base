package com.itecheasy.core.fba;

import java.util.ArrayList;
import java.util.List;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.product.ShopProductCmsInfoService;

/**
 * @author wanghw
 * @date 2016-12-10
 * @description TODO
 * @version 1.2.2
 */
public class FbaShopProductUpdateControl implements IFbaShopProductUpdateControl {
	private ShopProductCmsInfoService shopProductCmsInfoService;
	private ShopProductInventoryService shopProductInventoryService;
	private FbaShopProductService fbaShopProductService;

	public void setShopProductInventoryService(ShopProductInventoryService shopProductInventoryService) {
		this.shopProductInventoryService = shopProductInventoryService;
	}

	public void setShopProductCmsInfoService(ShopProductCmsInfoService shopProductCmsInfoService) {
		this.shopProductCmsInfoService = shopProductCmsInfoService;
	}

	public void setFbaShopProductService(FbaShopProductService fbaShopProductService) {
		this.fbaShopProductService = fbaShopProductService;
	}

	@Override
	public void updateSumInventorySercurityLine(List<Integer> fbaShopProductIds) {
		List<Integer> cmsProductIds=new ArrayList<Integer>();
		for (Integer fbaShopProductId : fbaShopProductIds) {
			shopProductInventoryService.setIsUpdateSumSecurityLine(fbaShopProductId);
			cmsProductIds.add(fbaShopProductService.getFbaShopProduct(fbaShopProductId).getCmsProductId());
		}
//		shopProductCmsInfoService.setIsRemindCmsReplenishment(CollectionUtils.list2Array(cmsProductIds));
	}

	@Override
	public void updateFbaInventorySercurityLine(List<Integer> fbaShopProductIds) {
		for (Integer fbaShopProductId : fbaShopProductIds) {
			shopProductInventoryService.setIsUpdateFbaSecurityLine(fbaShopProductId);
			shopProductInventoryService.setIsRemindFbaReplenishment(fbaShopProductId);
		}
	}

	
	@Override
	public void statisticsOrderSalesInfo4All(int fbaShopProductId) {
		shopProductInventoryService.setIsUpdateSumSecurityLine(fbaShopProductId);
	}
	
	@Override
	public void statisticsOrderSalesInfo4Fba(int fbaShopProductId) {
		shopProductInventoryService.setIsUpdateFbaSecurityLine(fbaShopProductId);
	}

	@Override
	public void updateFbaAvailableStock(int... fbaShopProductIds) {
		List<Integer> cmsProductIds=new ArrayList<Integer>();
		for (Integer fbaShopProductId : fbaShopProductIds) {
			shopProductInventoryService.setIsRemindFbaReplenishment(fbaShopProductId);
			cmsProductIds.add(fbaShopProductService.getFbaShopProduct(fbaShopProductId).getCmsProductId());
		}
//		shopProductCmsInfoService.setIsRemindCmsReplenishment(CollectionUtils.list2Array(cmsProductIds));
	}

	@Override
	public void updateCmsAvailableStock(int cmsProductId) {
//		shopProductCmsInfoService.setIsRemindCmsReplenishment(cmsProductId);
	}

	@Override
	public void cmsReplenishment(int cmsProductId) {
		shopProductCmsInfoService.cmsReplenishment(cmsProductId);
	}

	@Override
	public void fbaReplenishment(int fbaShopProductId, int replenishmentNum) {
		shopProductInventoryService.fbaReplenishment(fbaShopProductId, replenishmentNum);
	}

}
