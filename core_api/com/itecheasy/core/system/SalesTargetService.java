package com.itecheasy.core.system;

import java.util.List;

/** 
 * @author wanghw
 * @date 2016-2-18 
 * @description 业绩目标接口
 * @version 1.1.7
 */
public interface SalesTargetService {
	
	/**
	 * 设置业绩目标
	 * @param salesTargets
	 */
	void setSalesTargets(List<SalesTarget> salesTargets);
	
	/**
	 * 查询业绩目标
	 * @param version <i>yyyyMM</i>
	 * @return
	 */
	List<SalesTarget> getSalesTargets(String version);
	
	/**
	 * 查询店铺业绩目标
	 * @param verion
	 * @param shopId
	 * @return
	 */
	SalesTarget getSalesTargetByShopId(String verion, int shopId);
	
	/**
	 *  查询店铺业绩目标，无数据则返回店铺名字
	 * @param verion <i>yyyyMM</i>
	 * @param shopId
	 * @return
	 */
	List<SalesTarget> getSalesTargetByShopId(String verion, int[] shopId);
}
