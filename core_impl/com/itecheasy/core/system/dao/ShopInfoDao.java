package com.itecheasy.core.system.dao;

import java.util.List;

import com.itecheasy.common.BaseDAO;
import com.itecheasy.core.po.ShopInfoPo;
import com.itecheasy.core.system.ShopInfo;

/** 
 * @author wanghw
 * @date 2015-3-28 
 * @description TODO
 * @version
 */
public interface ShopInfoDao extends BaseDAO<ShopInfoPo, Integer>{

	List<ShopInfo> getInfoPos();

	void setInfoPos(List<ShopInfo> infoPos);

}
