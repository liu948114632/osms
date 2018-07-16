package com.itecheasy.core.task;

import org.apache.log4j.Logger;

import com.itecheasy.core.fba.ReplenishmentTaskService;
import com.itecheasy.core.fba.ShopProductInventoryService;
import com.itecheasy.core.product.ProductService;
import com.itecheasy.core.product.ShopProductCmsInfoService;

/** 
 * @author wanghw
 * @date 2016-12-7 
 * @description TODO
 * @version 1.2.2
 */
public class ProductInfoSyncTaskImpl implements ProductInfoSyncTask {
	private final static Logger LOGGER=Logger.getLogger(ProductInfoSyncTaskImpl.class);
	private ReplenishmentTaskService replenishmentTaskService;
	private ShopProductCmsInfoService shopProductCmsInfoService;
	private ShopProductInventoryService shopProductInventoryService;
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setShopProductInventoryService(ShopProductInventoryService shopProductInventoryService) {
		this.shopProductInventoryService = shopProductInventoryService;
	}

	public void setShopProductCmsInfoService(ShopProductCmsInfoService shopProductCmsInfoService) {
		this.shopProductCmsInfoService = shopProductCmsInfoService;
	}

	public void setReplenishmentTaskService(ReplenishmentTaskService replenishmentTaskService) {
		this.replenishmentTaskService = replenishmentTaskService;
	}

	@Override
	public void syncCmsProductInfo() {
		LOGGER.info("sync Cms Product Info begin....... ");
		int pageSize = 10;
		int currentPage = 1;
		while (currentPage>0) {
			currentPage = shopProductCmsInfoService.syncCmsProductInfo(pageSize, currentPage);
		}
		LOGGER.info("sync Cms Product Info end....... ");
	}

	@Override
	public void syncCmsAvailableStock() {

	}

	@Override
	public void syncFbaRepositoryStock() {
		shopProductInventoryService.syncFbaInventory();
	}

	@Override
	public void syncReplenishmentTask() {
		LOGGER.info("syncReplenishmentTask begin....... ");
		int pageSize = 1;
		int currentPage = 1;
		while (currentPage>0) {
			currentPage = replenishmentTaskService.syncReplenishmentTask(pageSize, currentPage);
		}
		LOGGER.info("syncReplenishmentTask end....... ");
	}

	@Override
	public void cancelFreezeStock() {
		LOGGER.info("cancelFreezeStock begin....... ");
		productService.autoCancelFreezeStock();
		LOGGER.info("cancelFreezeStock end....... ");
	}
}
