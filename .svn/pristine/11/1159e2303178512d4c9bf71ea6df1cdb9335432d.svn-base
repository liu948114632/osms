package com.itecheasy.core.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.fba.FbaShopProductService;
import com.itecheasy.core.fba.dao.FbaShopProductDao;
import com.itecheasy.core.fba.dao.ReplenishmentOrderItemDao;
import com.itecheasy.core.order.OrderService.OrderProductStatus;
import com.itecheasy.core.order.OrderService.OrderStatus;
import com.itecheasy.core.po.FbaShopProductPO;
import com.itecheasy.core.po.ReplenishmentOrderItemPO;
import com.itecheasy.core.po.ThreeMonthSalesSkuTempPO;
import com.itecheasy.core.prepare.dao.ThreeMonthSalesSkuTempDao;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.ShopService;

/**
 * @author taozihao
 * @date 2018年7月4日 上午11:21:53
 * @description
 */
public class StatisticFbaShopProductServiceImpl implements StatisticFbaShopProductService {

	private static final Logger LOGGER = Logger.getLogger(StatisticFbaShopProductServiceImpl.class);
	private FbaShopProductService fbaShopProductService;
	private ShopService shopService;
	private ThreeMonthSalesSkuTempDao threeMonthSalesSkuTempDao;
	private ReplenishmentOrderItemDao replenishmentOrderItemDao;
	private FbaShopProductDao fbaShopProductDao;

	public void setFbaShopProductService(FbaShopProductService fbaShopProductService) {
		this.fbaShopProductService = fbaShopProductService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public void setThreeMonthSalesSkuTempDao(ThreeMonthSalesSkuTempDao threeMonthSalesSkuTempDao) {
		this.threeMonthSalesSkuTempDao = threeMonthSalesSkuTempDao;
	}

	public void setReplenishmentOrderItemDao(ReplenishmentOrderItemDao replenishmentOrderItemDao) {
		this.replenishmentOrderItemDao = replenishmentOrderItemDao;
	}

	public void setFbaShopProductDao(FbaShopProductDao fbaShopProductDao) {
		this.fbaShopProductDao = fbaShopProductDao;
	}

	@Override
	public void autoStatisticFbaShopProductMonthSales() {
		LOGGER.info("statisticFbaShopProductMonthSales-->> start at " + new Date());
		Date today = DateUtils.getRealDate(new Date());
		Date endDate = org.apache.commons.lang.time.DateUtils.addDays(today, -2);
		Date startDate = org.apache.commons.lang.time.DateUtils.addDays(endDate, -30);
		System.out.println(startDate);
		System.out.println(endDate);
		Date date = new Date();
		System.out.println();
		fbaShopProductService.statisticFbaShopProductMonthSales(startDate, endDate);
		System.out.println("takes："+(new Date().getTime()-date.getTime())/1000+"second");
		LOGGER.info("statisticFbaShopProductMonthSales-->> end at " + new Date());
	}

	@Override
	public void autoStatisticThreeMonth() {
		LOGGER.info("autoStatisticThreeMonth-->> start at " + new Date());
		// 删除原来所有
		threeMonthSalesSkuTempDao.deleteAllData();
		List<Shop> shops = shopService.getAvailableShops();
		int id = 1;
		for (Shop shop : shops) {
			LOGGER.info(shop.getName()+"-->> start at " + new Date());
			List<ThreeMonthSalesSkuTempPO> tempList = new ArrayList<ThreeMonthSalesSkuTempPO>();
			Date today = DateUtils.getRealDate(new Date());
			Date endDate = org.apache.commons.lang.time.DateUtils.addDays(today, -2);
			Date startDate = org.apache.commons.lang.time.DateUtils.addDays(endDate, -30);
			List<String> skus = fbaShopProductService.getHotSaleProducts(startDate, endDate, shop.getId(), 50);
			if (CollectionUtils.isEmpty(skus)) {
				continue;
			}
			for (int i = 0; i < 2; i++) {
				endDate = startDate;
				startDate = org.apache.commons.lang.time.DateUtils.addDays(endDate, -30);
				List<String> list = fbaShopProductService.getHotSaleProducts(startDate, endDate, shop.getId(), 50);
				if (CollectionUtils.isEmpty(list)) {
					break;
				}

//				for (int j = 0; j < list.size(); j++) {
//					if (!skus.contains(list.get(j))) {
//						skus.remove(list.get(j));
//						j--;
//						continue;
//					}
//				}
				skus.retainAll(list);
			}
			Date updateTime = new Date();
			for (String sku : skus) {
				ThreeMonthSalesSkuTempPO po = new ThreeMonthSalesSkuTempPO();
				po.setId(id++);
				//id++;
				po.setShopId(shop.getId());
				po.setSku(sku);
				po.setUpdateTime(updateTime);
				tempList.add(po);
				System.out.println(po.getId());
			}
			threeMonthSalesSkuTempDao.mergeObject(tempList);
			LOGGER.info(shop.getName()+"-->> end at " + new Date());
		}
		LOGGER.info("autoStatisticThreeMonth-->> end at " + new Date());
	}

	@Override
	public void autoUpdateHasSeaTransported() {
		LOGGER.info("autoUpdateHasSeaTransported-->> start at " + new Date());
		fbaShopProductDao.updateHasSeaTransportedForAllShop();
		LOGGER.info("autoUpdateHasSeaTransported-->> end at " + new Date());
	}

}
