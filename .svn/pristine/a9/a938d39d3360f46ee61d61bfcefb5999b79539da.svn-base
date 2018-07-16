package com.itecheasy.core.system;

import java.util.List;

import com.itecheasy.core.BussinessException;
import com.itecheasy.core.util.SystemEnumDicts.ShopType;

/**
 * @author wanghw
 * @date 2015-6-16
 * @description TODO
 * @version
 */
public interface ShopService extends SalesTargetService{

	public void addRelations(List<ShopRelation> relations);

	/**
	 * 绑定店铺和用户的关系
	 * 
	 * @param user
	 * @param shopIds
	 */
	public void setShop2user(int user, List<Integer> shopIds);
	
	/**
	 * 绑定用户和店铺的关系
	 * 
	 * @param user
	 * @param shopIds
	 */
	public void setUser2shop(int shopId, List<Integer> userIds);

	/**
	 * 获取与该店铺关系店铺的id
	 * @param shopId
	 * @param type 0、竞争关系 1、关联关系  
	 * @return
	 */
	public List<Shop> getRelationShop(int shopId,int type);
	
	/**
	 * 获取与该店铺有关联关系店铺的id
	 * 
	 * @param shopId
	 * @return
	 */
	public List<Integer> getCorrelationShop(int shopId);

	/**
	 * 新增店铺
	 * @param shop
	 * @return
	 */
	public int addShop(Shop shop)throws BussinessException ;

	/**
	 * 设置店铺是否可用
	 * @param shop
	 * @param enable
	 * @return
	 */
	public void setShopEnable(int shop,boolean enable)throws BussinessException;
	
	/**
	 * 获取店铺所有账户
	 * @return
	 */
	public List<ShopDevInfo> getAllAccount();
	
	/**
	 * 获取店铺所有账户
	 * @param shopType 平台 {@link ShopType}
	 * @return
	 */
	public List<ShopDevInfo> getAllAccount(int shopType);
	
	/**
	 * 获取能对接账户
	 * @param shopType 平台 {@link ShopType}
	 * @return
	 */
	public List<ShopDevInfo> getJointAccount(int shopType);
	
	public ShopDevInfo getAccount(int shopId);
	
	/**
	 * 列表查询店铺信息
	 * @param form
	 * @return
	 */
	public List<ShopVO> getShopList(ShopSearchForm form);

	/**
	 * 设置店铺跟单员
	 * @param shopId
	 * @param userCode
	 */
	public void setMerchandiserById(int shopId, String userCode)throws BussinessException;
	
	/**
	 * 可用店铺
	 * @return
	 */
	public List<Shop> getAvailableShops();
	
	public List<Shop> getAvailableShopsByDevAccount(int devId);
	
	
	
	/**
	 * 更新店铺
	 * @param shop
	 */
	public void updateShop(Shop shop)throws BussinessException;
	

}
