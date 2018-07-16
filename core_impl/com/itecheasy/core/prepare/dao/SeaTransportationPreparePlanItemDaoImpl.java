package com.itecheasy.core.prepare.dao;


import java.util.List;

import org.hibernate.SQLQuery;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.po.SeaTransportationPreparePlanItemPO;

/**
 * @author taozihao
 * @date 2018年7月4日 上午8:53:31
 * @description
 */
public class SeaTransportationPreparePlanItemDaoImpl extends BaseDAOImpl<SeaTransportationPreparePlanItemPO, Integer>
		implements SeaTransportationPreparePlanItemDao {

	@Override
	public void deleteItemsByPlanId(int planId) {
		this.getSession().createSQLQuery("DELETE FROM sea_transportation_prepare_plan_item WHERE sea_transportation_prepare_plan_id ="+planId).executeUpdate();
	}

	@Override
	public void updateItemsByPlanId(int oldPlanId,int newPlanId,int fbaShopProductId) {
		String sql = "UPDATE sea_transportation_prepare_plan_item SET sea_transportation_prepare_plan_id="+newPlanId+" WHERE fba_shop_product_id="+fbaShopProductId+" AND sea_transportation_prepare_plan_id="+oldPlanId;
		System.out.println(sql);
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public void changeItemsStatusByPlanId(int planId,int shopId, List<String> skus, int status) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("(");
		for (int i = 0; i < skus.size(); i++) {
			buffer.append("'");
			buffer.append(skus.get(i));
			if(i==skus.size()-1){
				buffer.append("' ) ");
			}else{
				buffer.append("',");
			}
		}
		List<SeaTransportationPreparePlanItemPO> list = findListByHql("SELECT i FROM SeaTransportationPreparePlanItemPO i,FbaShopProductPO p WHERE i.fbaShopProductId=p.id AND i.seaTransportationPreparePlanId= ? AND p.shopId = ? AND p.sku IN "+buffer.toString(), new Object[]{planId,shopId});
		if(CollectionUtils.isNotEmpty(list)){
			for (SeaTransportationPreparePlanItemPO po : list) {
				po.setIsCanceled(status);
			}
			updateObject(list);
		}
		//this.getSession().createSQLQuery("UPDATE sea_transportation_prepare_plan_item i ,fba_shop_product p SET i.status ="+status+" WHERE sea_transportation_prepare_plan_id ="+planId+" AND p.sku in "+buffer.toString());
	}

	@Override
	public int getItemCountByPlanId(int PlanId) {
		SQLQuery query = getSession().createSQLQuery("SELECT COUNT(*) FROM sea_transportation_prepare_plan_item WHERE sea_transportation_prepare_plan_id = ? AND is_canceled=0 ");
		query.setParameter(0, PlanId);
		Object object = query.uniqueResult();
		if(object!=null){
			return (Integer)object;
		}
		return 0;
	}

}
