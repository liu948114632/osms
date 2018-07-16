package com.itecheasy.core.system;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.po.CurrencyExchangeRatePO;
import com.itecheasy.core.system.dao.CurrencyExchangeRateDao;

/** 
 * @author wanghw
 * @date 2016-1-12 
 * @description TODO
 * @version 1.1.6
 */
public class CurrencyExchangeRateServiceImpl implements CurrencyExchangeRateService{
	protected CurrencyExchangeRateDao currencyExchangeRateDao;
	
	public void setCurrencyExchangeRateDao(CurrencyExchangeRateDao currencyExchangeRateDao) {
		this.currencyExchangeRateDao = currencyExchangeRateDao;
	}

	@Override
	public void setExchangeRate(CurrencyExchangeRate rate) {
		if(rate!=null){
			CurrencyExchangeRatePO po=getExchangeRatePO(rate.getVersion(), rate.getCurrency());
			if(po==null){
				po=new CurrencyExchangeRatePO();
			}
			
			BeanUtils.copyProperties(rate, po, new String[]{"id"});
			
			currencyExchangeRateDao.mergeObject(po);
		}
	}

	/**
	 * 计算汇率版本
	 * @param version {@link #RATE_VERSION_FORMAT}
	 * @param month
	 * @return
	 */
	protected String calcVersion(String version ,int month) {
		Date dt=DateUtils.convertDate(version, RATE_VERSION_FORMAT);
		dt=org.apache.commons.lang.time.DateUtils.addMonths(dt, month);
		return DateUtils.convertDate(dt, RATE_VERSION_FORMAT);
	}
	
	@Override
	public List<CurrencyExchangeRate> getCurrentExchangeRate(String version)throws BussinessException {
		List<CurrencyExchangeRatePO> pos = getCurrentExchangeRatePO(version);
		if(CollectionUtils.isEmpty(pos)){
			pos=getCurrentExchangeRatePO(calcVersion(version, -1));
		}
		if(CollectionUtils.isEmpty(pos)){
			throw new BussinessException(ERROR_RATE_NEED_SETTING);
		}
		return BeanUtils.copyList(pos, CurrencyExchangeRate.class);
	}

	private List<CurrencyExchangeRatePO> getCurrentExchangeRatePO(String version) {
		String hql="from CurrencyExchangeRatePO where version=? " ;
		List<CurrencyExchangeRatePO> pos=currencyExchangeRateDao.findListByHql(hql, version);
		return pos;
	}
	
	protected CurrencyExchangeRatePO getExchangeRatePO(String version, int currencyId){
		String hql="from CurrencyExchangeRatePO where version=? and currency=?";
		return currencyExchangeRateDao.findByHql(hql, new Object[]{version,currencyId});
	}
	
	protected CurrencyExchangeRatePO getExchangeRatePO(int currencyId){
		String hql="from CurrencyExchangeRatePO where currency=? " +
				" order by version desc " ;
		return currencyExchangeRateDao.findByHql(hql, new Object[]{currencyId});
	}

	@Override
	public CurrencyExchangeRate getExchangeRate(String version, int currencyId)throws BussinessException {
		CurrencyExchangeRatePO po=getExchangeRatePO(version, currencyId);
		if(po==null){
			po=getExchangeRatePO(calcVersion(version, -1), currencyId);
		}
		
		if(po==null)
			throw new BussinessException(ERROR_RATE_NEED_SETTING);
		return BeanUtils.copyProperties(po, CurrencyExchangeRate.class);
	}

	@Override
	public BigDecimal exchangeCurrency2Other(int sourceCurrencyId, BigDecimal amount, int tagCurrencyId, String version)throws BussinessException {
		if(sourceCurrencyId==0||tagCurrencyId==0){
			return new BigDecimal(0);
		}
		if(sourceCurrencyId==tagCurrencyId){
			return amount.setScale(3, 4);
		}
		
		CurrencyExchangeRate source=getExchangeRate(version, sourceCurrencyId);
		CurrencyExchangeRate tag=getExchangeRate(version, tagCurrencyId);
		
//		return tag.getRate().divide(source.getRate(),6,4).multiply(amount).setScale(3, 4);
		return amount.multiply(source.getRate()).divide(tag.getRate(),3,4);
	}
	

	@Override
	public BigDecimal exchangeCurrency2Other(int sourceCurrencyId, BigDecimal amount, int tagCurrencyId) {
		if(sourceCurrencyId==0||tagCurrencyId==0){
			return new BigDecimal(0);
		}
		if(sourceCurrencyId==tagCurrencyId){
			return amount.setScale(3, 4);
		}
		CurrencyExchangeRatePO source=getExchangeRatePO(sourceCurrencyId);
		CurrencyExchangeRatePO tag=getExchangeRatePO(tagCurrencyId);
		
//		return tag.getRate().divide(source.getRate(),6,4).multiply(amount).setScale(3, 4);
		return amount.multiply(source.getRate()).divide(tag.getRate(),3,4);
	}

}
