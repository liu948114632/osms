package com.itecheasy.core.system;

import java.math.BigDecimal;
import java.util.List;

import com.itecheasy.core.BussinessException;

/** 
 * @author wanghw
 * @date 2016-1-11 
 * @description 币种汇率
 * @version 1.1.6
 */
public interface CurrencyExchangeRateService {
	final static String ERROR_RATE_NEED_SETTING="当月汇率没有设置";
	static final String RATE_VERSION_FORMAT = "yyyyMM";
	
	/**
	 * 设置汇率
	 * @param rate
	 */
	void setExchangeRate(CurrencyExchangeRate rate);
	
	/**
	 * 查询指定版本的所有币种汇率
	 * @param version
	 * @return
	 */
	List<CurrencyExchangeRate> getCurrentExchangeRate(String version)throws BussinessException;
	
	/**
	 * 查询指定版本的某个币种汇率
	 * @param version
	 * @param currencyId
	 * @return
	 */
	CurrencyExchangeRate getExchangeRate(String version,int currencyId)throws BussinessException;
	
	/**
	 * 币种转换，指定版本
	 * @param sourceCurrencyId
	 * @param amount
	 * @param tagCurrencyId
	 * @param version 默认取当月，没有则取上个月
	 * @return
	 */
	BigDecimal exchangeCurrency2Other(int sourceCurrencyId,BigDecimal amount,
			int tagCurrencyId,String version)throws BussinessException; 
	
	/**
	 * 币种转换
	 * @param sourceCurrencyId
	 * @param amount
	 * @param tagCurrencyId
	 * @return
	 */
	BigDecimal exchangeCurrency2Other(int sourceCurrencyId,BigDecimal amount,
			int tagCurrencyId)throws BussinessException;
}
