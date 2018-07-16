package com.itecheasy.core.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.itecheasy.common.PageList;
import com.itecheasy.core.fba.IFbaShopProductUpdateControl;
import com.itecheasy.core.fba.ShopProductInventoryService;
import com.itecheasy.core.fba.dao.FbaShopProductInventoryDao;
import com.itecheasy.core.order.FBAStoreOrderService;
import com.itecheasy.core.po.FbaShopProductInventoryPO;

/**
 * @author wanghw
 * @date 2016-3-15
 * @description TODO
 * @version 1.1.7
 */
public class ReportTaskServiceImpl implements ReportTaskService {
	private final static Logger LOGGER=Logger.getLogger(ReportTaskServiceImpl.class);
	private FBAStoreOrderService fbaStoreOrderService;
	private ShopProductInventoryService shopProductInventoryService;
	private FbaShopProductInventoryDao fbaShopProductInventoryDao;
	private IFbaShopProductUpdateControl fbaShopProductUpdateControl;

	public void setFbaShopProductUpdateControl(IFbaShopProductUpdateControl fbaShopProductUpdateControl) {
		this.fbaShopProductUpdateControl = fbaShopProductUpdateControl;
	}

	public void setFbaShopProductInventoryDao(FbaShopProductInventoryDao fbaShopProductInventoryDao) {
		this.fbaShopProductInventoryDao = fbaShopProductInventoryDao;
	}

	public void setShopProductInventoryService(ShopProductInventoryService shopProductInventoryService) {
		this.shopProductInventoryService = shopProductInventoryService;
	}

	public void setFbaStoreOrderService(FBAStoreOrderService fbaStoreOrderService) {
		this.fbaStoreOrderService = fbaStoreOrderService;
	}

	@Override
	public void autoCountFBASales() {
		LOGGER.info("autoCountFBASales-->>Starting =" +new Date());
		fbaStoreOrderService.autoCountFBASales();
		LOGGER.info("autoCountFBASales-->>end=" +new Date());
	}
	
	@Override
	public void autoStatisticOrder() {
		shopProductInventoryService.statisticDaysSales4Fba();
		shopProductInventoryService.statisticDaysSales4All();
		
		String hql="from FbaShopProductInventoryPO";
		int currentPage=1;
		int pageSize=1000;
		
		while (true) {
			PageList<FbaShopProductInventoryPO> pl=fbaShopProductInventoryDao.findPageListByHql(currentPage++, pageSize, hql);
		
			
			for (FbaShopProductInventoryPO po : pl.getData()) {
				fbaShopProductUpdateControl.statisticsOrderSalesInfo4All(po.getFbaShopProductId());
				fbaShopProductUpdateControl.statisticsOrderSalesInfo4Fba(po.getFbaShopProductId());
			}
			
			if(pl.getPage().getPageCount()<currentPage)
				return;
		}
		
	}
	@Override
	public void autoSetSumInventorySercurityLine() {
		LOGGER.info("autoSetSumInventorySercurityLine-->>Starting =" +new Date());
		shopProductInventoryService.autoSetSumInventorySercurityLine();
		
		String hql="from FbaShopProductInventoryPO";
		int currentPage=1;
		int pageSize=1000;
		
		while (true) {
			PageList<FbaShopProductInventoryPO> pl=fbaShopProductInventoryDao.findPageListByHql(currentPage++, pageSize, hql);
			List<Integer> fbaShopProductIds=new ArrayList<Integer>();
			for (FbaShopProductInventoryPO po : pl.getData()) {
				fbaShopProductIds.add(po.getFbaShopProductId());
			}
			
			fbaShopProductUpdateControl.updateSumInventorySercurityLine(fbaShopProductIds);
			if(pl.getPage().getPageCount()<currentPage){
				LOGGER.info("autoSetSumInventorySercurityLine-->>end =" +new Date());
				return;
			}
		}
	}

}
