package com.itecheasy.core.fba.dao;

import com.itecheasy.common.BaseDAO;
import com.itecheasy.core.po.FbaShopProductPO;

import java.util.Date;
import java.util.List;

/** 
 * @author wanghw
 * @date 2016-12-2 
 * @description TODO
 * @version 1.2.2
 */
public interface FbaShopProductDao extends BaseDAO<FbaShopProductPO, Integer>{

	/**
	 * 查询没走过海运且热销商品的sku
	 * @param startDate
	 * @param endDate
	 * @param shopId
	 * @param amount
	 * @return
	 */
	public List<String> getHotSaleProducts(Date startDate, Date endDate,int shopId, int amount);
	
	/**
	 * 统计商品是否走过海运
	 */
	public void updateHasSeaTransportedForAllShop();
}
