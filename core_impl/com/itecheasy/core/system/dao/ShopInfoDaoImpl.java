package com.itecheasy.core.system.dao;

import java.util.List;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.core.po.ShopInfoPo;
import com.itecheasy.core.system.ShopInfo;

/** 
 * @author wanghw
 * @date 2015-3-28 
 * @description TODO
 * @version
 */
public class ShopInfoDaoImpl extends BaseDAOImpl<ShopInfoPo, Integer> implements ShopInfoDao{
	private List<ShopInfo> infoPos;
	
	@Override
	public List<ShopInfo> getInfoPos() {
		return infoPos;
	}
	
	@Override
	public void setInfoPos(List<ShopInfo> infoPos) {
		this.infoPos = infoPos;
	}


	@Override
	public void mergeObject(ShopInfoPo entity) {
		super.mergeObject(entity);
		infoPos=BeanUtils.copyList(this.getAll(),ShopInfo.class);
	}
	
	@Override
	public Integer addObject(ShopInfoPo entity) {
		Integer id= super.addObject(entity);
		infoPos=BeanUtils.copyList(this.getAll(),ShopInfo.class);
		return id;
	}
	
	
}
