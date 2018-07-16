package com.itecheasy.core.product;

import java.util.ArrayList;
import java.util.List;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.CollectionUtils.Equaltor;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.po.BaseProductCostPriceConfigPO;
import com.itecheasy.core.po.BaseProductCostPriceCurrencyPO;
import com.itecheasy.core.product.dao.BaseProductCostPriceConfigDao;
import com.itecheasy.core.product.dao.BaseProductCostPriceCurrencyDao;

/**
 * @author wanghw
 * @date 2016-1-12
 * @description TODO
 * @version
 */
public class BaseProductCostPriceServiceImpl implements BaseProductCostPriceService {
	private BaseProductCostPriceConfigDao baseProductCostPriceConfigDao;
	private BaseProductCostPriceCurrencyDao baseProductCostPriceCurrencyDao;

	public void setBaseProductCostPriceConfigDao(BaseProductCostPriceConfigDao baseProductCostPriceConfigDao) {
		this.baseProductCostPriceConfigDao = baseProductCostPriceConfigDao;
	}

	public void setBaseProductCostPriceCurrencyDao(BaseProductCostPriceCurrencyDao baseProductCostPriceCurrencyDao) {
		this.baseProductCostPriceCurrencyDao = baseProductCostPriceCurrencyDao;
	}

	@Override
	public void setBaseProductCostPriceConfig(List<BaseProductCostPriceConfig> configs) throws BussinessException {
		if (CollectionUtils.isNotEmpty(configs)) {
			//币种
			List<Integer> _new_curr=new ArrayList<Integer>();
			List<BaseProductCostPriceConfig>  _new_config=BeanUtils.copyList(configs, BaseProductCostPriceConfig.class);
			for (BaseProductCostPriceConfig baseProductCostPriceConfig : configs) {
				if(!_new_curr.contains(baseProductCostPriceConfig.getCurrency())){
					_new_curr.add(baseProductCostPriceConfig.getCurrency());
				}
				if(baseProductCostPriceConfig.getCountry()<0||baseProductCostPriceConfig.getShippingMethod()<0){
					_new_config.remove(baseProductCostPriceConfig);
				}
			}
			setBaseProductCostPriceCurrency(_new_curr);
			
			setBaseProductCostPriceConfigs(_new_config);
		}
	}

	private void setBaseProductCostPriceConfigs(List<BaseProductCostPriceConfig> _new_config) {
		List<BaseProductCostPriceConfig>  _old_configs=getBaseProductCostPriceConfigs();
		
		List<BaseProductCostPriceConfig> add= CollectionUtils.sub(_new_config, _old_configs,new Equaltor<BaseProductCostPriceConfig,BaseProductCostPriceConfig>(){
			@Override
			public boolean equal(BaseProductCostPriceConfig o1, BaseProductCostPriceConfig o2) {
				return o1.equals(o2);
			}
			
		});
		
		List<BaseProductCostPriceConfig> del= CollectionUtils.sub( _old_configs,_new_config,new Equaltor<BaseProductCostPriceConfig,BaseProductCostPriceConfig>(){
			@Override
			public boolean equal(BaseProductCostPriceConfig o1, BaseProductCostPriceConfig o2) {
				return o1.equals(o2);
			}
			
		});
		
		for (BaseProductCostPriceConfig baseProductCostPriceConfig : del) {
			baseProductCostPriceConfigDao.deleteObjectById(baseProductCostPriceConfig.getId());
		}
		
		for (BaseProductCostPriceConfig baseProductCostPriceConfig : add) {
			BaseProductCostPriceConfigPO po=BeanUtils.copyProperties(baseProductCostPriceConfig, 
					BaseProductCostPriceConfigPO.class, new String[]{"id"});
			baseProductCostPriceConfigDao.addObject(po);
		}
	}

	private void setBaseProductCostPriceCurrency(List<Integer> _new_curr) {
		List<BaseProductCostPriceCurrency>  _old_curr= this.getBaseProductCostPriceCurrencys();
		List<Integer> add= CollectionUtils.sub(_new_curr, _old_curr,new Equaltor<Integer,BaseProductCostPriceCurrency>(){
			@Override
			public boolean equal(Integer o1, BaseProductCostPriceCurrency o2) {
				return o1.equals(o2.getCurrency());
			}
			
		});
		
		List<BaseProductCostPriceCurrency> del= CollectionUtils.sub( _old_curr,_new_curr,new Equaltor<BaseProductCostPriceCurrency,Integer>(){
			@Override
			public boolean equal(BaseProductCostPriceCurrency o1,Integer o2 ) {
				return o2.equals(o1.getCurrency());
			}
			
		});
		
		for (BaseProductCostPriceCurrency baseProductCostPriceCurrency : del) {
			baseProductCostPriceCurrencyDao.deleteObjectById(baseProductCostPriceCurrency.getId());
		}
		
		for (Integer curr : add) {
			BaseProductCostPriceCurrencyPO po=new BaseProductCostPriceCurrencyPO();
			po.setCurrency(curr);
			baseProductCostPriceCurrencyDao.addObject(po);
		}
	}

	@Override
	public void deleteBaseProductCostPriceCurrency(int id) {
		baseProductCostPriceCurrencyDao.deleteObjectById(id);
		deleteBaseProductCostPriceConfigByCurrency(id);
	}
	
	@Override
	public void deleteBaseProductCostPriceConfigById(int id) {
		baseProductCostPriceConfigDao.deleteObjectById(id);
	}

	@Override
	public void deleteBaseProductCostPriceConfigByCurrency(int currency) {
		List<BaseProductCostPriceConfigPO> pos = getBaseProductCostPriceConfigPOs(currency);
		if(CollectionUtils.isNotEmpty(pos))
			baseProductCostPriceConfigDao.deleteObjects(pos);
	}

	@Override
	public List<BaseProductCostPriceConfig> getBaseProductCostPriceConfigs(int currency) {
		List<BaseProductCostPriceConfigPO> pos = getBaseProductCostPriceConfigPOs(currency);
		if(CollectionUtils.isNotEmpty(pos)){
			return BeanUtils.copyList(pos, BaseProductCostPriceConfig.class);
		}
		return null;
	}

	private List<BaseProductCostPriceConfigPO> getBaseProductCostPriceConfigPOs(int currency) {
		String hql=" from BaseProductCostPriceConfigPO where currency=?"; 
		List<BaseProductCostPriceConfigPO> pos= baseProductCostPriceConfigDao.findListByHql(hql,currency);
		return pos;
	}
	
	@Override
	public List<BaseProductCostPriceConfig> getBaseProductCostPriceConfigs() {
		List<BaseProductCostPriceConfigPO> pos= baseProductCostPriceConfigDao.getAll();
		if(CollectionUtils.isNotEmpty(pos))
			return BeanUtils.copyList(pos, BaseProductCostPriceConfig.class);
		return null;
	}
	
	@Override
	public List<BaseProductCostPriceConfig> getAllBaseProductCostPriceConfigsAndCurrency() {
		String sql="SELECT " +
				"ISNULL(b.currency,c.currency) AS  currency, " +
				"ISNULL(shpping_method,-1) AS shippingMethod, " +
				"ISNULL(country ,-1) AS country " +
				"FROM dbo.base_product_cost_price_config b " +
				"RIGHT JOIN dbo.base_product_cost_price_currency c ON c.currency=b.currency ";
		
		return  baseProductCostPriceConfigDao.findListBySql(sql, null, BaseProductCostPriceConfig.class);
	}

	@Override
	public List<BaseProductCostPriceCurrency> getBaseProductCostPriceCurrencys() {
		List<BaseProductCostPriceCurrencyPO> pos=baseProductCostPriceCurrencyDao.getAll();
		if(CollectionUtils.isNotEmpty(pos))
			return BeanUtils.copyList(pos, BaseProductCostPriceCurrency.class);
		return null;
	}

}
