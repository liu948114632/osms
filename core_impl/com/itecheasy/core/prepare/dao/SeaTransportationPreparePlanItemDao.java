package com.itecheasy.core.prepare.dao;

import java.util.List;

import com.itecheasy.common.BaseDAO;
import com.itecheasy.core.po.SeaTransportationPreparePlanItemPO;

/**
 * @author taozihao
 * @date 2018年7月4日 上午8:48:20
 * @description
 */
public interface SeaTransportationPreparePlanItemDao extends BaseDAO<SeaTransportationPreparePlanItemPO, Integer> {

	public void deleteItemsByPlanId(int planId);
	
	public void updateItemsByPlanId(int oldPlanId,int newPlanId,int fbaShopProductId);
	
	public void changeItemsStatusByPlanId(int planId,int shopId,List<String> skus,int status);
	
	public int getItemCountByPlanId(int PlanId);

}
