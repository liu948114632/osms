package com.itecheasy.core.task;

import java.util.List;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.po.ShopDevInfoPO;
import com.itecheasy.core.system.ShopDevInfo;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.system.dao.ShopDevInfoDao;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.webservice.aliexpress.AliexpressConfigInfo;
import com.itecheasy.webservice.client.AliExpressClient;

/**
 * @author whw
 * @date 2017-5-19
 * @description TODO
 * @version 3.9.42
 */
public class DeveloperManagerTaskImpl implements DeveloperManagerTask {
	private SystemService systemService;
	private ShopDevInfoDao shopDevInfoDao;

	public void setShopDevInfoDao(ShopDevInfoDao shopDevInfoDao) {
		this.shopDevInfoDao = shopDevInfoDao;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	@Override
	public void postponeToken() {
		List<ShopDevInfo> devs = systemService.getAllShopExpiredTokens();
		if (CollectionUtils.isNotEmpty(devs)) {
			for (ShopDevInfo info : devs) {
				AliexpressConfigInfo ali = StaticUtils.convertAliexpressConfigInfo(info);
				ali = AliExpressClient.againAuth(ali);

				if (ali != null) {
					ShopDevInfoPO po = shopDevInfoDao.getObject(info.getId());
					po.setTokenTimeOut(ali.getRefreshTokenTimeOut());
					po.setToken(ali.getRefreshToken());
				}
			}
		}
	}
}
