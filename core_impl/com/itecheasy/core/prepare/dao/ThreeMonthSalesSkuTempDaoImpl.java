package com.itecheasy.core.prepare.dao;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.core.po.ThreeMonthSalesSkuTempPO;

/**
 * @author taozihao
 * @date 2018年7月4日 下午4:25:24
 * @description
 */
public class ThreeMonthSalesSkuTempDaoImpl extends BaseDAOImpl<ThreeMonthSalesSkuTempPO, Integer> implements ThreeMonthSalesSkuTempDao {

	@Override
	public void deleteAllData() {
		this.getSession().createSQLQuery("TRUNCATE TABLE dbo.three_month_sales_sku_temp ").executeUpdate();
	}

}
