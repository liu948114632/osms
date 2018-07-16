package com.itecheasy.core.fba.dao;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.core.fba.FbaFromAddress;
import com.itecheasy.core.po.FbaFromAddressPO;

/**
 * 
 * @author taozihao
 * @date 2018-6-5 
 */
public class FbaFromAddressDaoImpl extends BaseDAOImpl<FbaFromAddressPO, Integer> implements FbaFromAddressDao {

	@Override
	public FbaFromAddress findFbaFromAddressByShopId(int shopId) {
		String hql = "SELECT a FROM FbaFromAddressPO a ,ShopPo s WHERE a.id=s.fbaFromAddressId AND s.id = ?";
		return BeanUtils.copyProperties(findByHql(hql,shopId), FbaFromAddress.class);
	}

}
