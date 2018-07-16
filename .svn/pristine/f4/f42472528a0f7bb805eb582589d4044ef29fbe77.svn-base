package com.itecheasy.osms.system;

import java.util.List;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.core.fba.FbaFromAddress;
import com.itecheasy.core.fba.dao.FbaFromAddressDao;
import com.itecheasy.core.po.FbaFromAddressPO;
import com.itecheasy.core.system.dao.ShopDao;

/**
 * 
 * @author taozihao
 * @date 2018-6-5 
 * @description 
 */
public class FbaFromAddressWebServiceImpl implements FbaFromAddressWebService {
	private FbaFromAddressDao fbaFromAddressDao;
	private ShopDao shopDao;

	public void setFbaFromAddressDao(FbaFromAddressDao fbaFromAddressDao) {
		this.fbaFromAddressDao = fbaFromAddressDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}


	@Override
	public void addFbaFromAddress(FbaFromAddress fbaFromAddress) {
		FbaFromAddressPO fbaFromAddressPO = BeanUtils.copyProperties(fbaFromAddress, FbaFromAddressPO.class);
		fbaFromAddressDao.addObject(fbaFromAddressPO);
	}
	
	@Override
	public void updateFbaFromAddress(FbaFromAddress fbaFromAddress) {
		fbaFromAddressDao.updateObject(BeanUtils.copyProperties(fbaFromAddress, FbaFromAddressPO.class));
	}

	@Override
	public List<FbaFromAddress> getFbaFromAddressList() {
		return BeanUtils.copyList(fbaFromAddressDao.getAll(), FbaFromAddress.class);
	}

	@Override
	public void setFbaFromAddressForShop(int shopId, int fbaFromAddressId) {
		shopDao.setFbaFromAddressForShop(shopId, fbaFromAddressId);
	}

	@Override
	public FbaFromAddress getfbaFromAddressByShopId(int shopId) {
		return fbaFromAddressDao.findFbaFromAddressByShopId(shopId);
//		String hql = "SELECT a FROM FbaFromAddressPO a ,ShopPo s WHERE a.id=s.fbaFromAddressId AND s.id = ?";
//		return BeanUtils.copyProperties(fbaFromAddressDao.findByHql(hql,shopId), FbaFromAddress.class);
	}

}
