package com.itecheasy.common.sysconfig;

import com.itecheasy.common.po.SysConfigPO;

public class SysConfigServiceImpl implements SysConfigService {
	private SysConfigDAO sysConfigDAO;

	public void setSysConfigDAO(SysConfigDAO sysConfigDAO) {
		this.sysConfigDAO = sysConfigDAO;
	}

	public String getValue(String key) {
		String hql = "from SysConfigPO o where o.key = ?";
		SysConfigPO sys = (SysConfigPO) this.sysConfigDAO.findByHql(hql, key);
		if (sys == null) {
			return null;
		}
		return sys.getValue();
	}

	public void setValue(String key, String value) {
		String hql = "from SysConfigPO o where o.key = ?";
		SysConfigPO sys = (SysConfigPO) this.sysConfigDAO.findByHql(hql, key);
		if (sys == null) {
			sys = new SysConfigPO();
			sys.setKey(key);
			sys.setValue(value);
			sysConfigDAO.addObject(sys);
		}else
		{
			sys.setValue(value);
			sysConfigDAO.updateObject(sys);
		}
	}
}