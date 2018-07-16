package com.itecheasy.core.product;

import java.util.List;

import com.itecheasy.core.BussinessException;

/** 
 * @author wanghw
 * @date 2016-1-11 
 * @description TODO
 * @version
 */
public interface BaseProductCostPriceService {
	/**
	 * 设置商品成本配置
	 * @param configs
	 * @throws BussinessException
	 */
	void setBaseProductCostPriceConfig(List<BaseProductCostPriceConfig> configs)throws BussinessException;
	
	/**
	 * 删除商品成本配置
	 * @param id
	 */
	void deleteBaseProductCostPriceConfigById(int id);
	
	/**
	 * 删除币种
	 * @param id
	 */
	void deleteBaseProductCostPriceCurrency(int id);
	
	/**
	 * 删除币种，且删除币种下的所有商品成本配置
	 * @param currency
	 */
	void deleteBaseProductCostPriceConfigByCurrency(int currency);
	
	/**
	 * 查询币种下的所有商品成本配置
	 * @param currency
	 * @return
	 */
	List<BaseProductCostPriceConfig> getBaseProductCostPriceConfigs(int currency);
	
	/**
	 * 查询所有的商品成本配置
	 * @param currency
	 * @return
	 */
	public List<BaseProductCostPriceConfig> getBaseProductCostPriceConfigs();
	
	/**
	 * 查询设置的商品成本的币种
	 * @return
	 */
	List<BaseProductCostPriceCurrency> getBaseProductCostPriceCurrencys();

	List<BaseProductCostPriceConfig> getAllBaseProductCostPriceConfigsAndCurrency(); 
}
