package com.itecheasy.core.report.dao;

import java.util.Date;

import com.itecheasy.common.BaseDAO;
import com.itecheasy.core.po.ReportAutotaskShopConfigPO;

/**
 * @author taozihao
 * @date 2018年9月3日 下午4:30:16
 * @description
 */
public interface ReportAutotaskShopConfigDao extends BaseDAO<ReportAutotaskShopConfigPO, Integer> {
	
	public int updateLastFireTime(Date lastFireTime,int shopId,String reportType);

}
