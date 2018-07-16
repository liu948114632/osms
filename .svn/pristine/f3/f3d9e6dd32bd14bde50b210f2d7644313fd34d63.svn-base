package com.itecheasy.core.fba;

import java.util.Date;

import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.fba.dao.FbaShopProductInventoryDao;
import com.itecheasy.core.product.ShopProductCmsInfo;
import com.itecheasy.core.product.ShopProductCmsInfoService;

/**
 * @author wanghw
 * @date 2016-12-10
 * @description TODO
 * @version 1.2.2
 */
public class FbaShopProductComparableElement implements IFbaShopProductComparableElement {
	private ShopProductInventoryService shopProductInventoryService;
	private FbaShopProductInventoryDao fbaShopProductInventoryDao;
	private ShopProductCmsInfoService shopProductCmsInfoService;

	public void setShopProductCmsInfoService(ShopProductCmsInfoService shopProductCmsInfoService) {
		this.shopProductCmsInfoService = shopProductCmsInfoService;
	}

	public void setShopProductInventoryService(ShopProductInventoryService shopProductInventoryService) {
		this.shopProductInventoryService = shopProductInventoryService;
	}

	public void setFbaShopProductInventoryDao(FbaShopProductInventoryDao fbaShopProductInventoryDao) {
		this.fbaShopProductInventoryDao = fbaShopProductInventoryDao;
	}

	@Override
	public int getTotalOfSumInventorySercurityLine(int cmsProductId) {
		String sql = "SELECT SUM(inv.sum_security_line) AS sum FROM dbo.fba_shop_product_inventory inv "
				+ " INNER JOIN dbo.fba_shop_product fba ON fba.id=inv.fba_shop_product_id "
				+ " WHERE fba.cms_product_id=? " 
				+ " GROUP BY fba.cms_product_id ";
		java.lang.Object o = fbaShopProductInventoryDao.getSingleObjectBySql(sql,
				new java.lang.Object[] { cmsProductId });
		return o != null ? Integer.valueOf(o.toString()) : 0;
	}

	@Override
	public int getSumInventorySercurityLine(int fbaShopProductId) {
		return shopProductInventoryService.getFbaShopProductInventory(fbaShopProductId).getSumSecurityLine();
	}

	@Override
	public int getFbaInventorySercurityLine(int fbaShopProductId) {
		return shopProductInventoryService.getFbaShopProductInventory(fbaShopProductId).getFbaSecurityLine();
	}

	@Override
	public int getTotalOfFbaAvailable(int cmsProductId) {
		String sql = "SELECT SUM(inv.fba_available_stock) AS sum FROM dbo.fba_shop_product_inventory inv "
				+ " INNER JOIN dbo.fba_shop_product fba ON fba.id=inv.fba_shop_product_id "
				+ " WHERE fba.cms_product_id=? " 
				+ " GROUP BY fba.cms_product_id ";
		java.lang.Object o = fbaShopProductInventoryDao.getSingleObjectBySql(sql,
				new java.lang.Object[] { cmsProductId });
		return o != null ? Integer.valueOf(o.toString()) : 0;
	}

	@Override
	public int getFbaAvailable(int fbaShopProductId) {
		return shopProductInventoryService.getFbaShopProductInventory(fbaShopProductId).getFbaAvailableStock();
	}

	@Override
	public int getCmsAvailable(int cmsProductId) {
		ShopProductCmsInfo info = shopProductCmsInfoService.getShopProductCmsInfoById(cmsProductId);
		return (int) info.getAvailableStock() / info.getUnitQuantity();
	}

	@Override
	public int getFbaSalesInfo(int fbaShopProductId) {
		return shopProductInventoryService.getFbaShopProductInventory(fbaShopProductId).getDaysSales();
	}

	@Override
	public int getOrderSalesInfo(int fbaShopProductId) {
		return shopProductInventoryService.getFbaShopProductInventory(fbaShopProductId).getDaysSalesAll();
	}

	@Override
	public int getCmsTheReplenishment(int cmsProductId) {
		String sql = 
				" select SUM(p.replenishmentNum) from ReplenishmentTaskProductPO p,ReplenishmentTaskPO o " +
				" where o.id=p.replenishmentTaskId and p.cmsProductId=? " +
				//2017-01-12 10:00:18 统计非已完成补货单的补货批数之和
				" and ( p.taskStatus=null or p.taskStatus not in (80,70) )  and p.status!=6 and p.type in (1,2)" + 
				" GROUP BY p.cmsProductId ";
		Object r = fbaShopProductInventoryDao.getSingleObject(sql, cmsProductId);
		if (r != null)
			return Double.valueOf(r.toString()).intValue();
		return 0;
	}

	@Override
	public int getFbaTheReplenishment(int fbaShopProductId) {
		String sql = " select SUM(p.orderedQuantity)  FROM ReplenishmentOrderPO o "
				+ "  , ReplenishmentOrderItemPO p "
				+ "  where o.id=p.replenishmentOrderId AND p.status<12 "
				+ " and  o.status<130  AND p.fbaShopProductId=? " 
				+ " GROUP BY p.fbaShopProductId ";
		Object r = fbaShopProductInventoryDao.getSingleObject(sql, fbaShopProductId);
		if (r != null)
			return Double.valueOf(r.toString()).intValue();
		return 0;
	}
	
	@Override
	public Date getCmsLastReplenishmentDate(int cmsProductId) {
		String sql = 
				" select max(o.createDate) from ReplenishmentTaskProductPO p,ReplenishmentTaskPO o " +
				" where o.id=p.replenishmentTaskId and p.cmsProductId=? " +
				" and ( p.taskStatus=null or p.taskStatus not in (80) ) and p.type in (1,2)" + 
				"  ";
		Object r = fbaShopProductInventoryDao.getSingleObject(sql, cmsProductId);
		if(r!=null){
			return DateUtils.convertDate(String.valueOf(r), "yyyy-MM-dd HH:mm:ss.SSS");
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtils.convertDate("2016-12-10 17:23:14.923", "yyyy-MM-dd HH:mm:ss.SSS"));
	}
}
