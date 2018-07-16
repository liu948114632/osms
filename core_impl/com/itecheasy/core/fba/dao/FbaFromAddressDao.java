package com.itecheasy.core.fba.dao;

import com.itecheasy.common.BaseDAO;
import com.itecheasy.core.fba.FbaFromAddress;
import com.itecheasy.core.po.FbaFromAddressPO;

/**
 * 
 * @author taozihao
 * @date 2018-6-5 
 */
public interface FbaFromAddressDao extends BaseDAO<FbaFromAddressPO, Integer>{
	public FbaFromAddress findFbaFromAddressByShopId(int shopId);
}
