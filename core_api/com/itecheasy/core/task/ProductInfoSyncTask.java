package com.itecheasy.core.task;
/** 
 * @author wanghw
 * @date 2016-12-2 
 * @description 商品信息同步服务
 * @version 1.2.2
 */
public interface ProductInfoSyncTask {
	/**
	 * 同步cms基础信息
	 */
	void syncCmsProductInfo();
	
	/**
	 * 同步cms库存
	 */
	void syncCmsAvailableStock();

	/**
	 * 通讯fba仓库库存
	 */
	void syncFbaRepositoryStock();
	
	/**
	 * 同步主动备库存任务
	 */
	void syncReplenishmentTask(); 
	
	/**
	 * 取消冻结库存
	 */
	void cancelFreezeStock();
}
