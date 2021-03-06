package com.itecheasy.core.fba;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.PageList;
import com.itecheasy.common.Param;
import com.itecheasy.common.dao.Criteria;
import com.itecheasy.common.dao.Restriction;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.fba.FbaShopProductService.FbaShopProductStatus;
import com.itecheasy.core.fba.dao.FbaShopProductDao;
import com.itecheasy.core.fba.dao.FbaShopProductInventoryDao;
import com.itecheasy.core.po.FbaShopProductInventoryPO;
import com.itecheasy.core.po.FbaShopProductPO;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.util.DictUtils;
import com.itecheasy.webservice.amazon.FbaInventory;
import com.itecheasy.webservice.client.AmazonClient;

/**
 * @author wanghw
 * @date 2016-12-3
 * @description TODO
 * @version 1.2.2
 */
public class ShopProductInventoryServiceImpl implements ShopProductInventoryService {
	private FbaShopProductInventoryDao fbaShopProductInventoryDao;
	private FbaShopProductService fbaShopProductService;
	private IFbaShopProductUpdateControl fbaShopProductUpdateControl;
	private IFbaShopProductComparableElement fbaShopProductComparableElement;
	private SystemService systemService;
	private FbaShopProductDao fbaShopProductDao;

	public void setFbaShopProductDao(FbaShopProductDao fbaShopProductDao) {
		this.fbaShopProductDao = fbaShopProductDao;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public IFbaShopProductComparableElement getFbaShopProductComparableElement() {
		return fbaShopProductComparableElement;
	}

	public void setFbaShopProductComparableElement(IFbaShopProductComparableElement fbaShopProductComparableElement) {
		this.fbaShopProductComparableElement = fbaShopProductComparableElement;
	}

	public void setFbaShopProductUpdateControl(IFbaShopProductUpdateControl fbaShopProductUpdateControl) {
		this.fbaShopProductUpdateControl = fbaShopProductUpdateControl;
	}

	public void setFbaShopProductInventoryDao(FbaShopProductInventoryDao fbaShopProductInventoryDao) {
		this.fbaShopProductInventoryDao = fbaShopProductInventoryDao;
	}

	public void setFbaShopProductService(FbaShopProductService fbaShopProductService) {
		this.fbaShopProductService = fbaShopProductService;
	}

	@Override
	public void addShopProductInventorys(FbaShopProductInventory[] inventorys, int shopId) {
		List<Integer> fbaShopProductIds = new ArrayList<Integer>();
		for (FbaShopProductInventory inv : inventorys) {
			FbaShopProduct fba = fbaShopProductService.getFbaShopProduct(inv.getSku(), shopId);
			if (fba == null) {
				fba = new FbaShopProduct();
				fba.setShopId(shopId);
			}
			BeanUtils.copyProperties(inv, fba, new String[] { "id" });
			fba.setStatus(FbaShopProductStatus.已确认.ordinal());
			int fbaShopProductId = fbaShopProductService.mergeFbaShopProduct(fba);

			mergeFbaShopProductInventory(fbaShopProductId, inv.getFbaSecurityLine(), inv.getSumSecurityLine());
			fbaShopProductIds.add(fbaShopProductId);
		}
		fbaShopProductUpdateControl.updateSumInventorySercurityLine(fbaShopProductIds);
		fbaShopProductUpdateControl.updateFbaInventorySercurityLine(fbaShopProductIds);
	}

	@Override
	@Deprecated
	public int addShopProductInventory(FbaShopProductInventory inventory) {
		return fbaShopProductInventoryDao.addObject(BeanUtils
				.copyProperties(inventory, FbaShopProductInventoryPO.class));
	}

	@Override
	public void setIsRemindFbaReplenishment(int fbaShopProductId) {
		// BA待补货数量 = FBA警戒库存设置值 – FBA可用库存 – FBA补货中批数
		FbaShopProductInventoryPO po = getFbaShopProductInventoryPO(fbaShopProductId);
		if (po == null)
			return;
		po.setFbaAwaitReplenishment(po.getFbaSecurityLine() - po.getFbaAvailableStock() - po.getFbaTheReplenishment());
		// TODO 屏蔽配置方法
		// int line=
		// fbaShopProductComparableElement.getFbaInventorySercurityLine(fbaShopProductId);
		// int
		// available=fbaShopProductComparableElement.getFbaAvailable(fbaShopProductId);
		po.setRemindFbaReplenishment(po.getFbaSecurityLine() > po.getFbaAvailableStock()
				&& po.getFbaAwaitReplenishment() > 0);
		fbaShopProductInventoryDao.mergeObject(po);
	}

	public void setTheFbaReplenishment(int... fbaShopProductId) {
		// TODO 实时计算非已入仓状态的fba补货订单中商品的批数之和
		// List<Param> params=new ArrayList<Param>();
		// if(fbaShopProductId!=null){
		// String id=Arrays.toString(fbaShopProductId) ;
		// params.add(new Param("shopProductId",id.substring(1,
		// id.length()-1)));
		// }
		// fbaShopProductDao.execStoredProcedure("p_update_fba_the_replenishment_num",
		// params);

		for (int i : fbaShopProductId) {
			FbaShopProductInventoryPO po = getFbaShopProductInventoryPO(i);
			int the=fbaShopProductComparableElement.getFbaTheReplenishment(i);
			po.setFbaTheReplenishment(the);
			fbaShopProductInventoryDao.mergeObject(po);
			// TODO 影响fba待补货数
			setIsRemindFbaReplenishment(i);
		}

	}

	@Override
	public void setIsUpdateFbaSecurityLine(int fbaShopProductId) {
		FbaShopProductInventoryPO po = getFbaShopProductInventoryPO(fbaShopProductId);
		if (po == null)
			return;
		// TODO 屏蔽配置方法
		// po.setUpdateFbaSecurityLine(fbaShopProductComparableElement.getFbaSalesInfo(fbaShopProductId)
		// > fbaShopProductComparableElement
		// .getFbaInventorySercurityLine(fbaShopProductId));
		po.setUpdateFbaSecurityLine(po.getDaysSales() > po.getFbaSecurityLine());

		fbaShopProductInventoryDao.mergeObject(po);
	}

	@Override
	public void setIsUpdateSumSecurityLine(int fbaShopProductId) {
		FbaShopProductInventoryPO po = getFbaShopProductInventoryPO(fbaShopProductId);
		// TODO 屏蔽配置方法
		// po.setUpdateSumSecurityLine(fbaShopProductComparableElement.getOrderSalesInfo(fbaShopProductId)
		// > fbaShopProductComparableElement
		// .getSumInventorySercurityLine(fbaShopProductId));
		po.setUpdateSumSecurityLine(po.getDaysSalesAll() > po.getSumSecurityLine());
		fbaShopProductInventoryDao.mergeObject(po);
	}

	private FbaShopProductInventoryPO getFbaShopProductInventoryPO(int fbaShopProductId) {
		String hql = "from FbaShopProductInventoryPO where fbaShopProductId=?";
		return fbaShopProductInventoryDao.findByHql(hql, fbaShopProductId);
	}

	private int mergeFbaShopProductInventory(int fbaShopProductId, int fbaSecurityLine, int SumSecurityLine) {
		FbaShopProductInventoryPO po = getFbaShopProductInventoryPO(fbaShopProductId);
		if (po == null) {
			po = new FbaShopProductInventoryPO();
			po.setFbaShopProductId(fbaShopProductId);
			fbaShopProductInventoryDao.addObject(po);
			setTheFbaReplenishment(fbaShopProductId);
		}
		po.setFbaSecurityLine(fbaSecurityLine);
		po.setSumSecurityLine(SumSecurityLine);

		return po.getId();
	}

	@Override
	public FbaShopProductInventoryBo getFbaShopProductInventory(int fbaShopProductId) {
		FbaShopProductInventoryPO po = getFbaShopProductInventoryPO(fbaShopProductId);
		return BeanUtils.copyProperties(po, FbaShopProductInventoryBo.class);
	}

	@Override
	public void setFbaInventorySecurityLine(int[] fbaShopProductIds, int value) {
		for (int fbaShopProductId : fbaShopProductIds) {
			FbaShopProductInventoryPO po = getFbaShopProductInventoryPO(fbaShopProductId);
			po.setFbaSecurityLine(value);
			fbaShopProductInventoryDao.mergeObject(po);
		}
		fbaShopProductUpdateControl.updateFbaInventorySercurityLine(CollectionUtils.array2List(fbaShopProductIds));
	}

	@Override
	public void setSumInventorySercurityLine(int[] fbaShopProductIds, int value) {
		for (int fbaShopProductId : fbaShopProductIds) {
			FbaShopProductInventoryPO po = getFbaShopProductInventoryPO(fbaShopProductId);
			po.setSumSecurityLine(value);
			fbaShopProductInventoryDao.mergeObject(po);
		}
		fbaShopProductUpdateControl.updateSumInventorySercurityLine(CollectionUtils.array2List(fbaShopProductIds));
	}

	@Override
	public FbaShopProductInventory getFbaShopProductInventory(String sku, int shopId) {
		FbaShopProduct fba = fbaShopProductService.getFbaShopProduct(sku, shopId);
		return copyFba2Inventory(fba);
	}

	private FbaShopProductInventory copyFba2Inventory(FbaShopProduct fba) {
		if (fba != null) {
			FbaShopProductInventoryBo bo = getFbaShopProductInventory(fba.getId());
			if (bo != null) {
				FbaShopProductInventory inv = new FbaShopProductInventory();
				BeanUtils.copyProperties(bo, inv);
				BeanUtils.copyProperties(fba, inv, new String[] { "id" });
				return inv;
			}
		}
		return null;
	}

	@Override
	public FbaShopProductInventory getFbaShopProductInventoryByOtherCode(String code, int shopId) {
		FbaShopProduct fba = fbaShopProductService.getFbaShopProductByOtherCode(code, shopId);
		return copyFba2Inventory(fba);
	}

	@Override
	public PageList<FbaShopProductInventoryDetail> findInventory(SearchShopProductInventory search) {
		List<Param> params = new ArrayList<Param>();
		if (search.getShopId() > -1) {
			params.add(new Param("shopId", search.getShopId()));
		}
		if (search.getIsUpdateFbaSecurityLine() > -1) {
			params.add(new Param("isUpdateFbaSecurityLine", search.getIsUpdateFbaSecurityLine()));
		}
		if (search.getIsUpdateSumSecurityLine() > -1) {
			params.add(new Param("isUpdateSumSecurityLine", search.getIsUpdateSumSecurityLine()));
		}
		if (search.getIsRemindFbaReplenishment() > -1) {
			params.add(new Param("isRemindFbaReplenishment", search.getIsRemindFbaReplenishment()));
		}
		if (CollectionUtils.isNotEmpty(search.getSkus())) {
			StringBuilder productCodeList = new StringBuilder();
			for (String productCode : search.getSkus()) {
				productCodeList.append(productCode + ",");
			}
			params.add(new Param("skus", productCodeList.substring(0, productCodeList.length() - 1)));
		} else if (StringUtils.isNotEmpty(search.getSku())) {
			params.add(new Param("sku", search.getSku()));
		}

		if (CollectionUtils.isNotEmpty(search.getCmsProductCodes())) {
			StringBuilder productCodeList = new StringBuilder();
			for (String productCode : search.getCmsProductCodes()) {
				productCodeList.append(productCode + ",");
			}
			params.add(new Param("cmsProductCodes", productCodeList.substring(0, productCodeList.length() - 1)));
		} else if (StringUtils.isNotEmpty(search.getCmsProductCode())) {
			params.add(new Param("cmsProductCode", search.getCmsProductCode()));
		}

		params.add(new Param("PageSize", String.valueOf(search.getPageSize())));
		params.add(new Param("PageIndex", String.valueOf(search.getCurrentPage())));
		PageList<FbaShopProductInventoryDetail> pl = fbaShopProductInventoryDao.findPageListByStoredProcedure(
				search.getCurrentPage(), search.getPageSize(), "p_fba_shop_product_inventory", params,
				FbaShopProductInventoryDetail.class);
		return pl;
	}

	private void updateFbaAvailableStock(int fbaShopProductId, int stock) {
		Criteria criteria = new Criteria(FbaShopProductInventoryPO.class);
		criteria.and(Restriction.eq("fbaShopProductId", fbaShopProductId));
		FbaShopProductInventoryPO po = fbaShopProductInventoryDao.get(criteria);
		if (po != null && po.getFbaAvailableStock() != stock) {
			po.setFbaAvailableStock(stock);
			fbaShopProductUpdateControl.updateFbaAvailableStock(fbaShopProductId);
		}
	}

	@Override
	public void syncFbaInventory() {
		List<Shop> shops = systemService.getCacheShopsByType(DictUtils.SHOP_TYPE_AMAZON);
		String hql = "select f from FbaShopProductInventoryPO inv ,FbaShopProductPO f "
				+ " where inv.fbaShopProductId=f.id and f.shopId=? ";
		int currentPage = 1;
		int pageSize = 50;
		for (Shop shop : shops) {
			// if(shop.getId()!=1){
			// continue;
			// }
			currentPage = 1;
			while (true) {
				PageList<FbaShopProductPO> pl = fbaShopProductDao.findPageListByHql(currentPage++, pageSize, hql,
						shop.getId());
				
				if(CollectionUtils.isNotEmpty(pl.getData())){
					List<String> skus = new ArrayList<String>();
					for (FbaShopProductPO fba : pl.getData()) {
						skus.add(fba.getSku());
					}
					
					List<FbaInventory> ams = AmazonClient.listInventorys(skus, null, shop.getId());
					
					if(CollectionUtils.isNotEmpty(ams)){
						for (FbaInventory fbaInventory : ams) {
							for (FbaShopProductPO fba : pl.getData()) {
								if (fba.getSku().equalsIgnoreCase(fbaInventory.getSellerSKU())) {
									updateFbaAvailableStock(fba.getId(), fbaInventory.getInStockSupplyQuantity());
								}
							}
						}
					}
				}

				if (pl.getPage().getPageCount() < currentPage)
					break;

			}

		}
	}

	@Override
	public void statisticDaysSales4All() {
		Date today = new Date();
		List<Param> params = new ArrayList<Param>();
		params.add(new Param("startDate", org.apache.commons.lang.time.DateUtils.addDays(DateUtils.getRealDate(today),
				-DeployProperties.getInstance().getAllOrderSalesInfostatisticDays())));
		params.add(new Param("endDate", today));
		fbaShopProductInventoryDao.execStoredProcedure("p_statistic_all_order_sales_info", params);
	}

	@Override
	public void autoSetSumInventorySercurityLine() {
		Date monday = DateUtils.getDayOfWeek(new Date(),Calendar.MONDAY);
		List<Param> params = new ArrayList<Param>();
		params.add(new Param("startDate", org.apache.commons.lang.time.DateUtils.addDays(DateUtils.getRealDate(monday),
				-28)));//四周
		params.add(new Param("endDate", DateUtils.getRealDate(monday)));
//		params.add(new Param("updateModel", 1));
		fbaShopProductInventoryDao.execStoredProcedure("p_statistic_all_order_sales_info2", params);
	}
	
	public static void main(String[] args) {
		Date today = DateUtils.getDayOfWeek(new Date(),Calendar.MONDAY);
		System.out.println(today);
		System.out.println( org.apache.commons.lang.time.DateUtils.addDays(DateUtils.getRealDate(today),
				-28));
	}
	
	@Override
	public void statisticDaysSales4Fba() {
		Date today = new Date();
		List<Param> params = new ArrayList<Param>();
		params.add(new Param("startDate", org.apache.commons.lang.time.DateUtils.addDays(DateUtils.getRealDate(today),
				-DeployProperties.getInstance().getFBAOrderSalesInfostatisticDays())));
		params.add(new Param("endDate", today));
		fbaShopProductInventoryDao.execStoredProcedure("p_statistic_fba_order_sales_info", params);
	}

	@Override
	public void fbaReplenishment(int fbaShopProductId, int Num) {
		FbaShopProductInventoryPO po = getFbaShopProductInventoryPO(fbaShopProductId);
		if (po == null || Num == 0)
			return;
		po.setFbaTheReplenishment(po.getFbaTheReplenishment() + Num);
		po.setFbaAwaitReplenishment(po.getFbaAwaitReplenishment() - Num);
		// TODO 配置屏蔽
		// setTheFbaReplenishment(fbaShopProductId);
		fbaShopProductInventoryDao.updateObject(po);
		setIsRemindFbaReplenishment(fbaShopProductId);
	}


	@Override
	public void updateSeaTransportationBlacklist(UpdateBlacklistVO updateBlacklistVO) {
		List<FbaShopProductPO> results = new ArrayList<FbaShopProductPO>();
		//查出对应店铺下的sku
		for (String s : updateBlacklistVO.getSkuList()) {
			FbaShopProductPO fbaPO = fbaShopProductDao.
					findByHql("FROM FbaShopProductPO WHERE shopId=? AND sku=?",new Object[]{updateBlacklistVO.getShopId(),s});
			results.add(fbaPO);
		}

		//设置状态
		for (FbaShopProductPO fbaShopProductPO : results) {
			fbaShopProductPO.setIsSeaTransportationBlacklist(updateBlacklistVO.getSeaTransportationBlacklistStatus());
		}
		fbaShopProductDao.updateObject(results);
		// TODO: 2018/7/4 sea transportation

	}
}
