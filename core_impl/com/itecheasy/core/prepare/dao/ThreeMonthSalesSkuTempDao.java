package com.itecheasy.core.prepare.dao;

import com.itecheasy.common.BaseDAO;
import com.itecheasy.core.po.ThreeMonthSalesSkuTempPO;

/**
 * @author taozihao
 * @date 2018年7月4日 下午4:15:45
 * @description
 */
public interface ThreeMonthSalesSkuTempDao extends BaseDAO<ThreeMonthSalesSkuTempPO, Integer> {

	public void deleteAllData();

}
