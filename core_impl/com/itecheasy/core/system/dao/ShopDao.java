package com.itecheasy.core.system.dao;

import java.util.List;

import com.itecheasy.common.BaseDAO;
import com.itecheasy.core.po.ShopPo;
import com.itecheasy.core.system.Shop;

/** 
 * @author wanghw
 * @date 2015-3-26 
 * @description TODO
 * @version
 */
public interface ShopDao extends BaseDAO<ShopPo, Integer>{
	public List<Shop> getShops();

	public void setShops(List<Shop> shops);
	
	public List<Shop> getEnableShops();
	
	public void setFbaFromAddressForShop(int shopId, int fbaFromAddressId);
}
