package com.itecheasy.core.prepare.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.core.po.SeaTransportationSkuStockPeriodPO;

/**
 * @author taozihao
 * @date 2018年7月23日 上午11:08:02
 * @description
 */
public class SeaTransportationSkuStockPeriodDaoImpl extends BaseDAOImpl<SeaTransportationSkuStockPeriodPO, Integer> implements SeaTransportationSkuStockPeriodDao {

	@Override
	public List<Date> getDates(int seaTransportationPreparePlanItemId) {
		List<SeaTransportationSkuStockPeriodPO> list = findListByHql("FROM SeaTransportationSkuStockPeriodPO WHERE seaTransportationPreparePlanItemId= ? ORDER BY date ASC", seaTransportationPreparePlanItemId);
		ArrayList<Date> dates = new ArrayList<Date>();
		for (SeaTransportationSkuStockPeriodPO po : list) {
			dates.add(po.getDate());
		}
		return dates;
	}

}
