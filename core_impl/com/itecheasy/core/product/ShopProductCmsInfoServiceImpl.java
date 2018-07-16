package com.itecheasy.core.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.itecheasy.common.PageList;
import com.itecheasy.common.Param;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CalcUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.StringUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.IFbaShopProductComparableElement;
import com.itecheasy.core.fba.IFbaShopProductUpdateControl;
import com.itecheasy.core.fba.MonthlyPeakOrLowRule;
import com.itecheasy.core.fba.MonthlyPeakOrLowRule.PeakOrLowRuleKey;
import com.itecheasy.core.fba.ReplenishmentTaskService;
import com.itecheasy.core.fba.ReplenishmentTaskService.MonthlyPeakOrLow;
import com.itecheasy.core.fba.dao.ShopProductCmsInfoDao;
import com.itecheasy.core.po.ShopProductCmsInfoPO;
import com.itecheasy.webservice.client.CMSClient;

/**
 * @author wanghw
 * @date 2016-12-2
 * @description
 * @version 1.2.2
 */
public class ShopProductCmsInfoServiceImpl implements ShopProductCmsInfoService {
	private static final Logger LOGGER=Logger.getLogger(ShopProductCmsInfoServiceImpl.class); 
	private ReplenishmentTaskService replenishmentTaskService;
	private ShopProductCmsInfoDao shopProductCmsInfoDao;
	private IFbaShopProductComparableElement fbaShopProductComparableElement;
	private IFbaShopProductUpdateControl fbaShopProductUpdateControl;
	

	public void setReplenishmentTaskService(ReplenishmentTaskService replenishmentTaskService) {
		this.replenishmentTaskService = replenishmentTaskService;
	}

	public void setFbaShopProductUpdateControl(IFbaShopProductUpdateControl fbaShopProductUpdateControl) {
		this.fbaShopProductUpdateControl = fbaShopProductUpdateControl;
	}

	public void setFbaShopProductComparableElement(IFbaShopProductComparableElement fbaShopProductComparableElement) {
		this.fbaShopProductComparableElement = fbaShopProductComparableElement;
	}

	public void setShopProductCmsInfoDao(ShopProductCmsInfoDao shopProductCmsInfoDao) {
		this.shopProductCmsInfoDao = shopProductCmsInfoDao;
	}

	@Override
	public int mergeShopProductCmsInfo(String cmsProductCode) {
		if (StringUtils.isEmpty(cmsProductCode))
			return 0;
		CMSProduct cmsProduct = CMSClient.getCMSProductByCode(cmsProductCode);
		if (cmsProduct == null) {
			throw new BussinessException(EX_PRODUCT_NOT_EXIST);
		}

		ShopProductCmsInfoPO info=copyCMSProductInfo(cmsProduct,getShopProductCmsInfoPO(cmsProductCode));
		shopProductCmsInfoDao.mergeObject(info);
		return info.getCmsProductId();
	}

	private ShopProductCmsInfoPO copyCMSProductInfo(CMSProduct cmsProduct,ShopProductCmsInfoPO info) {
		if(info==null)
			info=new ShopProductCmsInfoPO();
		info.setCmsProductId(cmsProduct.getId());
		info.setCmsProductCode(cmsProduct.getCode());
		info.setProductName(cmsProduct.getName());
		info.setCostPrice(cmsProduct.getCostPrice());
		info.setPrimaryPictureCode(cmsProduct.getPrimaryPictureCode());
		info.setColorCardPictureCode(cmsProduct.getColorCardPictureCode());
		info.setUnit(cmsProduct.getUnit());
		info.setUnitQuantity(cmsProduct.getUnitQuantity());
		info.setAvailableStock(cmsProduct.getAvailableStock());
		info.setUnitVolume(CalcUtils.unitVoluem(cmsProduct.getVolume(), cmsProduct.getUnitQuantity()).doubleValue());
		info.setUnitWeight(CalcUtils.unitweight(cmsProduct.getWeight(), cmsProduct.getUnitQuantity()).doubleValue());
		info.setTs(cmsProduct.isProductTs());
		return info;
	}

	private ShopProductCmsInfoPO getShopProductCmsInfoPO(String cmsProductCode) {
		String hql = "from ShopProductCmsInfoPO where cmsProductCode=?";
		return shopProductCmsInfoDao.findByHql(hql, cmsProductCode);
	}

	@Override
	public void setIsRemindCmsReplenishment(int... cmsProductIds) {
//		if (cmsProductIds != null) {
//			for (int cmsProductId : cmsProductIds) {
//				ShopProductCmsInfoPO po = shopProductCmsInfoDao.getObject(cmsProductId);
//				// c3待补货批量 = 总警戒库存和 - 总FBA可用库存 - c3可用库存（批量） - 补货中批量 (规则废除)
//				int totalOfSumInventorySercurityLine = fbaShopProductComparableElement
//						.getTotalOfSumInventorySercurityLine(cmsProductId);
//				int totalOfFbaAvailable = fbaShopProductComparableElement.getTotalOfFbaAvailable(cmsProductId);
//				int cmsAvailable = fbaShopProductComparableElement.getCmsAvailable(cmsProductId);
//				int theReplenishment = fbaShopProductComparableElement.getCmsTheReplenishment(cmsProductId);
//				po.setCmsAwaitReplenishment(totalOfSumInventorySercurityLine - totalOfFbaAvailable - cmsAvailable
//						- theReplenishment);
//
//				shopProductCmsInfoDao.mergeObject(po);
//			}
//		}
		
	}

	@Override
	public void setTheCmsReplenishment(int... cmsProductIds) {
		// List<Param> params=new ArrayList<Param>();
		// if(cmsProductIds!=null){
		// String id=Arrays.toString(cmsProductIds);
		// params.add(new Param("cmsProductId",id.substring(1, id.length()-1)));
		// }
		// shopProductCmsInfoDao.execStoredProcedure("p_update_the_replenishment_num",
		// params);

		for (int cmsProductId : cmsProductIds) {
			int theReplenishment = fbaShopProductComparableElement.getCmsTheReplenishment(cmsProductId);
			ShopProductCmsInfoPO po = shopProductCmsInfoDao.getObject(cmsProductId);
			if(po!=null){
				// TODO 影响待补货数量 
//				po.setCmsAwaitReplenishment(po.getCmsAwaitReplenishment()-(theReplenishment-po.getCmsTheReplenishment()));
				po.setCmsTheReplenishment(theReplenishment);
				shopProductCmsInfoDao.mergeObject(po);
			}
		}
	}

	@Override
	public void cmsReplenishment(int cmsProductId) {
		ShopProductCmsInfoPO po = shopProductCmsInfoDao.getObject(cmsProductId);
		if(po==null)
			return;
		po.setCmsTheReplenishment(fbaShopProductComparableElement.getCmsTheReplenishment(cmsProductId));
		shopProductCmsInfoDao.mergeObject(po);
		updateAwaitReplenishment(po.getCmsProductId());
	}

	@Override
	public int addShopProductCmsInfo(String cmsProductCode) {
		ShopProductCmsInfoPO po = getShopProductCmsInfoPO(cmsProductCode);
		if (po == null) {
			return mergeShopProductCmsInfo(cmsProductCode);
		}
		return po.getCmsProductId();
	}

	@Override
	public ShopProductCmsInfo getShopProductCmsInfoById(int cmsProductId) {
		return BeanUtils.copyProperties(shopProductCmsInfoDao.getObject(cmsProductId), ShopProductCmsInfo.class);
	}

	@Override
	public ShopProductCmsInfo getShopProductCmsInfoByCode(String cmsProductCode) {
		return BeanUtils.copyProperties(getShopProductCmsInfoPO(cmsProductCode), ShopProductCmsInfo.class);
	}

	@Override
	public int syncCmsProductInfo(int pageSize, int currentPage) {
		String hql = "from ShopProductCmsInfoPO ";
		PageList<ShopProductCmsInfoPO> pl = shopProductCmsInfoDao.findPageListByHql(currentPage++, pageSize, hql);

		List<String> codes = new ArrayList<String>();
		for (ShopProductCmsInfoPO po : pl.getData()) {
			codes.add(po.getCmsProductCode());
		}
		List<CMSProduct> ls = CMSClient.getCMSProductByCodes(codes);
		for (CMSProduct cmsProduct2 : ls) {
			ShopProductCmsInfoPO p=getShopProductCmsInfoPO(cmsProduct2.getCode());
			double avi=p==null?0d:p.getAvailableStock();
			p=copyCMSProductInfo(cmsProduct2,p);
			shopProductCmsInfoDao.mergeObject(p);
			if(p.getAvailableStock()!=avi){
				fbaShopProductUpdateControl.updateCmsAvailableStock(p.getCmsProductId());
			}
		}

		if (pl.getPage().getPageCount() < currentPage) {
			return -1;
		}
		return currentPage;
	}

	@Override
	public ShopProductCmsInfo getShopProductCmsInfo(String sku, int shopId) {
		List<Object> params = new ArrayList<Object>();
		params.add(shopId);
		params.add(sku);
		String sql = "SELECT cms.* FROM dbo.shop_product_cms_info cms "
				+ "INNER JOIN dbo.fba_shop_product fba ON fba.cms_product_id=cms.cms_product_id "
				+ "WHERE fba.shop_id=? AND fba.sku=? ";
		List<ShopProductCmsInfoPO> pos = shopProductCmsInfoDao.findListBySql(sql, params);
		if (CollectionUtils.isNotEmpty(pos))
			return BeanUtils.copyProperties(pos.get(0), ShopProductCmsInfo.class);
		return null;
	}
	
	public void statisticsCmsAwaitReplenishment(){
		List<Param> parameters=new ArrayList<Param>();
		Date date=new Date();
		Date first= DateUtils.getFirstWeekDate(date);
		parameters.add(new Param("month", DateUtils.getMonth(date)+1));
		parameters.add(new Param("beginDate", DateUtils.getRealDate(org.apache.commons.lang.time.DateUtils.addDays(first, -28))));
		parameters.add(new Param("endDate", DateUtils.getRealDate(first)));
		LOGGER.info("statisticsCmsAwaitReplenishment begin......");
		shopProductCmsInfoDao.execStoredProcedure("update_cms_await_replenishment", parameters);
		LOGGER.info("statisticsCmsAwaitReplenishment sales end......");
		updateAwaitReplenishment();
		LOGGER.info("statisticsCmsAwaitReplenishment end......");
		
	}
	
	private void updateAwaitReplenishment(){
		List<MonthlyPeakOrLow>  monthlys=replenishmentTaskService.getMonthlyPeakOrLow();
		List<MonthlyPeakOrLowRule>  rules=replenishmentTaskService.getMonthlyPeakOrLowRules();
		if(CollectionUtils.isEmpty(monthlys)||CollectionUtils.isEmpty(rules))
			return ;
		Date date=new Date();
		Date first= DateUtils.getFirstWeekDate(date);
		Date lastWeek=DateUtils.getRealDate(org.apache.commons.lang.time.DateUtils.addDays(first, -7));
		MonthlyPeakOrLow monthly=monthlys.get(DateUtils.getMonth(date));
		Map<Integer, MonthlyPeakOrLowRuleSalesRound>  rounds=getLowRuleSalesRounds(rules, monthly);
		if(monthly==MonthlyPeakOrLow.LOW)
			updateAwaitReplenishmentByLow(monthly, rules,lastWeek,rounds);
		else
			updateAwaitReplenishmentByPeak(monthly, rules,lastWeek,rounds);
			
	}
	
	/**
	 * 淡季
	 * @param monthly
	 * @param rules
	 */
	private void updateAwaitReplenishmentByLow(MonthlyPeakOrLow monthly,List<MonthlyPeakOrLowRule>  rules,Date lastWeek,Map<Integer, MonthlyPeakOrLowRuleSalesRound>  rounds){
		List<ShopProductCmsInfoPO> pos=this.shopProductCmsInfoDao.getAll();
		LOGGER.info("statisticsCmsAwaitReplenishment-->淡旺季："+monthly.toString());
		for (ShopProductCmsInfoPO po : pos) {
			LOGGER.info("statisticsCmsAwaitReplenishment begin-->商品："+po.getCmsProductCode()+"-->待补货数量："+po.getCmsAwaitReplenishment());
			setTheCmsReplenishment(po.getCmsProductId());
			updateAwaitReplenishmentByLow(monthly, rules,po,lastWeek,rounds);
			LOGGER.info("statisticsCmsAwaitReplenishment end-->商品："+po.getCmsProductCode()+"-->待补货数量："+po.getCmsAwaitReplenishment());
		}
	}
	
	public void updateAwaitReplenishment(int cmsProductId){
		System.out.println(Thread.currentThread().getId());
		List<MonthlyPeakOrLow>  monthlys=replenishmentTaskService.getMonthlyPeakOrLow();
		List<MonthlyPeakOrLowRule>  rules=replenishmentTaskService.getMonthlyPeakOrLowRules();
		if(CollectionUtils.isEmpty(monthlys)||CollectionUtils.isEmpty(rules))
			return ;
		Date date=new Date();
		Date first= DateUtils.getFirstWeekDate(date);
		Date lastWeek=DateUtils.getRealDate(org.apache.commons.lang.time.DateUtils.addDays(first, -7));
		MonthlyPeakOrLow monthly=monthlys.get(DateUtils.getMonth(date));
		ShopProductCmsInfoPO po=shopProductCmsInfoDao.getObject(cmsProductId);
		Map<Integer, MonthlyPeakOrLowRuleSalesRound>  rounds=getLowRuleSalesRounds(rules, monthly);
		if(monthly==MonthlyPeakOrLow.LOW)
			updateAwaitReplenishmentByLow(monthly, rules,po,lastWeek,rounds);
		else
			updateAwaitReplenishmentByPeak(monthly, rules,po,lastWeek,rounds);
	}
	
	
	private void updateAwaitReplenishmentByLow(MonthlyPeakOrLow monthly,List<MonthlyPeakOrLowRule>  rules,ShopProductCmsInfoPO po,
			Date lastWeek,Map<Integer, MonthlyPeakOrLowRuleSalesRound>  rounds){
		//确定值段
		int sort=0;
		int model=1; //比较模式
		String specific; //比较符合
		double specificValue=0d;//比较的值
		boolean success=false; //匹配成功
		double awaitReplenishmentQty=0d;
		double calculateValue=0d;//计算值
		
//		for (int i = 0; i < rules.size(); i++) {
//			if(PeakOrLowRuleKey.low_Sales==rules.get(i).getRuleKey()
//					&&po.getSales()>=Integer.valueOf(rules.get(i).getValue()).intValue()){
//				sort=rules.get(i).getSort();
//				break;
//			}
//		}
		
		for (Entry<Integer, MonthlyPeakOrLowRuleSalesRound> en : rounds.entrySet()) {
			if(po.getSales()>=en.getValue().getMin()
					&&(en.getValue().getSort()==1||
							po.getSales()<en.getValue().getMax())){
								sort=en.getKey();
								break;
				}
		}
		
		//不满足值段
		if(sort>0){
			if(sort==4||sort==5){
				String m=getValueByKey(PeakOrLowRuleKey.low_inventory_or_sales_select, rules, sort);
				if("0".equals(m))
					model=0;
			}
			
			specific=getValueByKey(PeakOrLowRuleKey.low_inventory_sales_specific_comparative, rules, sort);
			String specificValueStr=getValueByKey(PeakOrLowRuleKey.low_inventory_sales_specific, rules, sort);
			if(!StringUtils.isEmpty(specificValueStr)){
				specificValue=Double.valueOf(specificValueStr);
			}
			
			String valueStr=getValueByKey(PeakOrLowRuleKey.low_sales_coefficient, rules, sort);
			if(!StringUtils.isEmpty(valueStr)){
				calculateValue=Double.valueOf(valueStr);
			}
			
			success=compareValue(po, model, specific, specificValue);
			
			if(success){
				if(sort<4){
					awaitReplenishmentQty=po.getSales()*calculateValue-po.getCmsTheReplenishment();
				}else{
					awaitReplenishmentQty=calculateValue-po.getCmsTheReplenishment()-po.getAvailableStock()/po.getUnitQuantity();
				}
			}
			//	该商品上周是否有c3补货订单产生，且当本周需补货数 < 补货中批量的1/2时，则待补货批量为0
			awaitReplenishmentQty = hasCreatedReplenishmentByLastWeek(po, awaitReplenishmentQty,lastWeek);
		}
		po.setCmsAwaitReplenishment(BigDecimal.valueOf(awaitReplenishmentQty).
				setScale(0, BigDecimal.ROUND_CEILING).intValue());
		shopProductCmsInfoDao.updateObject(po);
	}

	
	
	/**
	 * 旺季
	 * @param monthly
	 * @param rules
	 */
	private void updateAwaitReplenishmentByPeak(MonthlyPeakOrLow monthly,List<MonthlyPeakOrLowRule>  rules,Date lastWeek,Map<Integer, MonthlyPeakOrLowRuleSalesRound>  rounds){
		List<ShopProductCmsInfoPO> pos=this.shopProductCmsInfoDao.getAll();
		LOGGER.info("statisticsCmsAwaitReplenishment-->淡旺季："+monthly.toString());
		for (ShopProductCmsInfoPO po : pos) {
			LOGGER.info("statisticsCmsAwaitReplenishment begin-->商品："+po.getCmsProductCode()+"-->待补货数量："+po.getCmsAwaitReplenishment());
			setTheCmsReplenishment(po.getCmsProductId());
			updateAwaitReplenishmentByPeak(monthly, rules,po,lastWeek,rounds);
			LOGGER.info("statisticsCmsAwaitReplenishment end-->商品："+po.getCmsProductCode()+"-->待补货数量："+po.getCmsAwaitReplenishment());
		}
	}
	
	private Map<Integer, MonthlyPeakOrLowRuleSalesRound> getLowRuleSalesRounds(List<MonthlyPeakOrLowRule>  rules,MonthlyPeakOrLow type){
		Map<Integer, MonthlyPeakOrLowRuleSalesRound> map=new HashMap<Integer, MonthlyPeakOrLowRuleSalesRound>();
		int sort;
		
		if(type==MonthlyPeakOrLow.PEAK){
			for (int i = 0; i < rules.size(); i++) {
				sort=rules.get(i).getSort();
				if(map.containsKey(sort)){
					
				}else{
					map.put(sort, new MonthlyPeakOrLowRuleSalesRound(sort));
				}
				MonthlyPeakOrLowRuleSalesRound round=map.get(sort);
				if(PeakOrLowRuleKey.Peak_Sales==rules.get(i).getRuleKey()){
					round.setMin(Integer.valueOf(rules.get(i).getValue()));
				}
				
				if(PeakOrLowRuleKey.Peak_Sales_end==rules.get(i).getRuleKey()){
					round.setMax(Integer.valueOf(rules.get(i).getValue()));
				}
			}
		}else{
			for (int i = 0; i < rules.size(); i++) {
				sort=rules.get(i).getSort();
				if(map.containsKey(sort)){
					
				}else{
					map.put(sort, new MonthlyPeakOrLowRuleSalesRound(sort));
				}
				MonthlyPeakOrLowRuleSalesRound round=map.get(sort);
				if(PeakOrLowRuleKey.low_Sales==rules.get(i).getRuleKey()){
					round.setMin(Integer.valueOf(rules.get(i).getValue()));
				}
				
				if(PeakOrLowRuleKey.low_Sales_end==rules.get(i).getRuleKey()){
					round.setMax(Integer.valueOf(rules.get(i).getValue()));
				}
			}
		}
		
		return map;
	}
	
	private void updateAwaitReplenishmentByPeak(MonthlyPeakOrLow monthly,List<MonthlyPeakOrLowRule>  rules,
			ShopProductCmsInfoPO po,Date lastWeek,Map<Integer, MonthlyPeakOrLowRuleSalesRound>  rounds){
		//确定值段
		int sort=0;
		int model=1; //比较模式
		String specific; //比较符合
		double specificValue=0d;//比较的值
		boolean success=false; //匹配成功
		double awaitReplenishmentQty=0;
		double calculateValue=0d;//计算值
		
//		for (int i = 0; i < rules.size(); i++) {
//			if(PeakOrLowRuleKey.Peak_Sales==rules.get(i).getRuleKey()
//					&&po.getSales()>=Integer.valueOf(rules.get(i).getValue()).intValue()){
//				sort=rules.get(i).getSort();
//				break;
//			}
//		}
		
		for (Entry<Integer, MonthlyPeakOrLowRuleSalesRound> en : rounds.entrySet()) {
			if(po.getSales()>=en.getValue().getMin()
					&&(en.getValue().getSort()==1||
							po.getSales()<en.getValue().getMax())){
								sort=en.getKey();
								break;
				}
		}
		
		//不满足值段
		if(sort>0){
			if(sort==3||sort==4){
				String m=getValueByKey(PeakOrLowRuleKey.Peak_inventory_or_sales_select, rules, sort);
				if("0".equals(m))
					model=0;
			}
			
			specific=getValueByKey(PeakOrLowRuleKey.Peak_inventory_sales_specific_comparative, rules, sort);
			String specificValueStr=getValueByKey(PeakOrLowRuleKey.Peak_inventory_sales_specific, rules, sort);
			if(!StringUtils.isEmpty(specificValueStr)){
				specificValue=Double.valueOf(specificValueStr);
			}
			
			String valueStr=getValueByKey(PeakOrLowRuleKey.Peak_sales_coefficient, rules, sort);
			if(!StringUtils.isEmpty(valueStr)){
				calculateValue=Double.valueOf(valueStr);
			}
			
			success=compareValue(po, model, specific, specificValue);
			
			if(success){
				if(sort<3){
					//1.2.6 add 待补货批量=总的最近四周销量*（）- 补货中批量 - 国内库存批量（注意初始化数据）
					awaitReplenishmentQty=po.getSales()*calculateValue-po.getCmsTheReplenishment()-(po.getAvailableStock()/po.getUnitQuantity());
				}else{
					awaitReplenishmentQty=calculateValue-po.getCmsTheReplenishment();
				}
			}
			
			awaitReplenishmentQty=hasCreatedReplenishmentByLastWeek(po, awaitReplenishmentQty,lastWeek);
		}
		
		po.setCmsAwaitReplenishment(BigDecimal.valueOf(awaitReplenishmentQty).
				setScale(0, BigDecimal.ROUND_CEILING).intValue());
		shopProductCmsInfoDao.updateObject(po);
	}

	private boolean compareValue(ShopProductCmsInfoPO po, int model, String specific, double specificValue) {
		if("<".equals(specific)){
			if(model==1){
				if(po.getAvailableStock()/po.getUnitQuantity()/po.getSales()<(double)specificValue){
					return true;
				}else{
					return false;
				}
			}else{
				if(po.getAvailableStock()/po.getUnitQuantity()<(double)specificValue){
					return true;
				}else{
					return false;
				}
			}
		}
		
		if("<=".equals(specific)){
			if(model==1){
				if(po.getAvailableStock()/po.getUnitQuantity()/po.getSales()<=(double)specificValue){
					return true;
				}else{
					return false;
				}
			}else{
				if(po.getAvailableStock()/po.getUnitQuantity()<=(double)specificValue){
					return true;
				}else{
					return false;
				}
			}
		}
		
		if("=".equals(specific)){
			if(model==1){
				if(po.getAvailableStock()/po.getUnitQuantity()/po.getSales()==(double)specificValue){
					return true;
				}else{
					return false;
				}
			}else{
				if(po.getAvailableStock()/po.getUnitQuantity()==(double)specificValue){
					return true;
				}else{
					return false;
				}
			}
		}
		
		if(">".equals(specific)){
			if(model==1){
				if(po.getAvailableStock()/po.getUnitQuantity()/po.getSales()>(double)specificValue){
					return true;
				}else{
					return false;
				}
			}else{
				if(po.getAvailableStock()/po.getUnitQuantity()>(double)specificValue){
					return true;
				}else{
					return false;
				}
			}
		}
		
		if(">=".equals(specific)){
			if(model==1){
				if(po.getAvailableStock()/po.getUnitQuantity()/po.getSales()>=(double)specificValue){
					return true;
				}else{
					return false;
				}
			}else{
				if(po.getAvailableStock()/po.getUnitQuantity()>=(double)specificValue){
					return true;
				}else{
					return false;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 该商品上周是否有c3补货订单产生，且当本周需补货数 < 补货中批量的1/2时，则待补货批量为0
	 * @param po
	 * @param awaitReplenishmentQty
	 * @return
	 */
	private double hasCreatedReplenishmentByLastWeek(ShopProductCmsInfoPO po, double awaitReplenishmentQty,Date lastWeek) {
		Date last=fbaShopProductComparableElement.getCmsLastReplenishmentDate(po.getCmsProductId());
		if(last!=null){
			LOGGER.info("statisticsCmsAwaitReplenishment end-->商品："+po.getCmsProductCode()+"-->最后补货时间："+DateUtils.convertDate(last));
			if(last.after(lastWeek)
					&&awaitReplenishmentQty<po.getCmsTheReplenishment()/2.0){
				awaitReplenishmentQty=0;
			}
		}
		return awaitReplenishmentQty;
	}
	
	private String getValueByKey(PeakOrLowRuleKey key,List<MonthlyPeakOrLowRule>  rules,int sort){
		for (MonthlyPeakOrLowRule monthlyPeakOrLowRule : rules) {
			if(sort==monthlyPeakOrLowRule.getSort()&&monthlyPeakOrLowRule.getRuleKey()==key)
				return  monthlyPeakOrLowRule.getValue();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtils.getFirstWeekDate(new Date()));
	}
}
