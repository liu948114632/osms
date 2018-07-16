package com.itecheasy.core.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.itecheasy.common.PageList;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.order.dao.FBAStoreProductDao;
import com.itecheasy.core.order.dao.FBAStoreProductLogDao;
import com.itecheasy.core.order.dao.FBAStoreProductReportDao;
import com.itecheasy.core.order.dao.FirstWayFreightSettingDao;
import com.itecheasy.core.order.dao.VFBAStoreProductReportDao;
import com.itecheasy.core.po.FBAStoreProductLogPO;
import com.itecheasy.core.po.FBAStoreProductPO;
import com.itecheasy.core.po.FBAStoreProductReportPO;
import com.itecheasy.core.po.FirstWayFreightSettingPO;
import com.itecheasy.core.po.VFBAStoreProductReportPO;
import com.itecheasy.core.user.ProfileService;
/**
 * @author wanghw
 * @date 2016-2-25
 * @description TODO
 * @version 1.1.7
 */
public class FBAStoreOrderServiceImpl implements FBAStoreOrderService {
	private FBAStoreProductDao fbaStoreProductDao;
	private FirstWayFreightSettingDao firstWayFreightSettingDao;
	private FBAStoreProductLogDao fbaStoreProductLogDao;
	private OrderReportService orderReportService;
	private FBAStoreProductReportDao fbaStoreProductReportDao;
	private ProfileService profileService;
	private VFBAStoreProductReportDao vfbaStoreProductReportDao;
	
	
	public void setVfbaStoreProductReportDao(VFBAStoreProductReportDao vfbaStoreProductReportDao) {
		this.vfbaStoreProductReportDao = vfbaStoreProductReportDao;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setFbaStoreProductReportDao(FBAStoreProductReportDao fbaStoreProductReportDao) {
		this.fbaStoreProductReportDao = fbaStoreProductReportDao;
	}

	public void setOrderReportService(OrderReportService orderReportService) {
		this.orderReportService = orderReportService;
	}

	public void setFbaStoreProductLogDao(FBAStoreProductLogDao fbaStoreProductLogDao) {
		this.fbaStoreProductLogDao = fbaStoreProductLogDao;
	}

	public void setFbaStoreProductDao(FBAStoreProductDao fbaStoreProductDao) {
		this.fbaStoreProductDao = fbaStoreProductDao;
	}

	public void setFirstWayFreightSettingDao(FirstWayFreightSettingDao firstWayFreightSettingDao) {
		this.firstWayFreightSettingDao = firstWayFreightSettingDao;
	}
	
	@Override
	public List<FirstWayFreightSetting> getFirstWayFreightSettings(String version) {
		String sql="SELECT country.id AS country,version,first_way_freight_of_unit AS freightOfUnit" +
				" FROM dbo.country WITH(NOLOCK) " +
				" left JOIN dbo.first_way_freight_setting WITH(NOLOCK)" +
				" ON version=? AND country.id=country_id " +
				" WHERE  is_fisrt_way=1";
		
		List<Object> params=new ArrayList<Object>();
		params.add(version);
		return firstWayFreightSettingDao.findListBySql(sql, params,FirstWayFreightSetting.class);
	}
	@Override
	public void setFirstWayFreights(List<FirstWayFreightSetting> firstWayFreightSettings) {
		if(CollectionUtils.isNotEmpty(firstWayFreightSettings)){
			Date current=new Date();
			for (FirstWayFreightSetting setting : firstWayFreightSettings) {
				FirstWayFreightSettingPO po=getFirstWayFreightSettingPO(setting.getVersion(), setting.getCountry());
				if(po==null){
					po=new FirstWayFreightSettingPO();
					po.setCountry(setting.getCountry());
					po.setVersion(setting.getVersion());
				}
				po.setFreightOfUnit(setting.getFreightOfUnit());
				po.setUpdateTime(current);
				
				firstWayFreightSettingDao.mergeObject(po);
			}
		}
	}
	
	@Override
	public FirstWayFreightSetting getFirstWayFreightSetting(String version,int country){
		String sql="SELECT TOP 1 * FROM dbo.first_way_freight_setting WHERE [version] <=? " +
				" AND country_id=? " +
				" ORDER BY [version] DESC";
		List<Object> params=new ArrayList<Object>();
		params.add(version);
		params.add(country);
		List<FirstWayFreightSettingPO> pos=firstWayFreightSettingDao.findListBySql(sql, params);
		if(CollectionUtils.isNotEmpty(pos))
			return BeanUtils.copyProperties(pos.get(0), FirstWayFreightSetting.class);
		return null;
	}
	
	private FirstWayFreightSettingPO getFirstWayFreightSettingPO(String version,int country){
		String hql=" from FirstWayFreightSettingPO where version=? and country=?";
		return firstWayFreightSettingDao.findByHql(hql, new Object[]{version,country});
	}
	
	@Override
	public void autoCountFBASales() {
		fbaStoreProductReportDao.getAll();
		List<FBAStoreProductPO> pos=fbaStoreProductDao.getAll();
		
		if (CollectionUtils.isNotEmpty(pos)) {
			Date current=new Date();
			Date today=org.apache.commons.lang.time.DateUtils.addDays(current, -1);
			OrderReportSearchForm form=new OrderReportSearchForm();
			//前7天销量时间
			Date _7days=org.apache.commons.lang.time.DateUtils.addDays(today, -6);
			Date _14days=org.apache.commons.lang.time.DateUtils.addDays(today, -13);
			Date _28days=org.apache.commons.lang.time.DateUtils.addDays(today, -27);
			//前7天销量
			BigDecimal _7salesBg;
			List<OrderCountReport> _7reports;
			List<OrderCountReport> _14reports;
			List<OrderCountReport> _28reports;
			List<OrderCountReport> _35reports;
			//7天增长率
			BigDecimal _7growth;
			//7天增长率基数
			BigDecimal _7inc;
			//前5周
			Date _35days=org.apache.commons.lang.time.DateUtils.addDays(today, -34);
			//未来7天销量
			BigDecimal _next7;
			BigDecimal _next14;
			//42天预期补货量
			BigDecimal _next42;
			BigDecimal _next70;
			//查询时间
			form.setEnd(today);
			int _7sales;
			int _14sales;
			int _28sales;
			List<Integer> _weaks;
			FBAStoreProductReportPO reportPO;
			for (FBAStoreProductPO po : pos) {
//				FBAStoreProductPO po=fbaStoreProductDao.getObject(284);
				_7sales=0;
				_14sales=0;
				_28sales=0;
				_7growth=new BigDecimal(0);
				reportPO=new FBAStoreProductReportPO();
				//报表时间
				reportPO.setReportDate(current);
				reportPO.setFbaStoreProductId(po.getId());
				//7天销量
				form.setBegin(_7days);
				form.setProductCode(po.getProductCode());
				form.setShopId(CollectionUtils.array2List(new int[]{po.getShopId()}));
				_7reports=this.FBAStoreProductSales(form);
				
				for (OrderCountReport orderCountReport : _7reports) {
					_7sales+=orderCountReport.getTotalUnit();
				}
				reportPO.setSalesFor7days(_7sales);
				
				//14天销量
				form.setBegin(_14days);
				_14reports=this.FBAStoreProductSales(form);
				
				for (OrderCountReport orderCountReport : _14reports) {
					_14sales+=orderCountReport.getTotalUnit();
				}
				reportPO.setSalesFor14days(_14sales);
				//28天销量
				form.setBegin(_28days);
				_28reports=this.FBAStoreProductSales(form);
				
				for (OrderCountReport orderCountReport : _28reports) {
					_28sales+=orderCountReport.getTotalUnit();
				}
				reportPO.setSalesFor28days(_28sales);
				//7天增长率
				//以7天为一周（不是真正意义上的周）， 取前五周销量 x1、x2、x3、x4、x5，其中x1表示前第一周，x2表示前第二周。。。。
				//分别计算前四周增长率 y1= (x1-x2)/x2、y2=（x2-x3）/x3、y3=（x3-x4）/x4、y4=（x4-x5）/x5---------
				//（近的一周减去远的一周再除以远的一周）
				//7天增长率 = (y1+y2+y3+y4)/4
				//库时间不足1周的，增长率为0，分母为0的增长率为0，
				if(org.apache.commons.lang.time.DateUtils.addDays(
						DateUtils.getRealDate(po.getFirstInStorageDate())
						,7).after(today) ){
					reportPO.setGrowthRateFor7days(_7growth);
				}else{
					form.setBegin(_35days);
					_35reports=this.FBAStoreProductSales(form);
					
					_weaks=new ArrayList<Integer>();
					for (int i = _35reports.size()-1; i >=0; i=i-7) {
						int _w=0;
						for (int j = i; j > i-7; j--) {
							_w+=_35reports.get(j).getTotalUnit();
						}
						_weaks.add(_w);
					}
					int _avg=0;
					boolean _start=false;
					for (int i = 0; i < _weaks.size()-1; i++) {
						if(_weaks.get(i)==0&&!_start){
							_start=false;
							continue;
						}else{
							_start=true;
							_avg++;
							if(_weaks.get(i+1)==_weaks.get(i)){
								continue;
							}else if(_weaks.get(i)==0){
								_7growth=_7growth.add(new BigDecimal(1));
							}else{
								_7growth=_7growth.add(new BigDecimal(_weaks.get(i+1)-_weaks.get(i))
								.divide(new BigDecimal(_weaks.get(i)),6,4));
							}
						}
					}
					if(_avg>0){
						_7growth=_7growth.divide(new BigDecimal(_avg),6,4);
					}
					reportPO.setGrowthRateFor7days(_7growth);
				}
				
				_7salesBg=new BigDecimal(_7sales);
				_7inc=_7growth.add(new BigDecimal(1));
				//未来7天销量: 前7天销量 x （1+7天增长率）
				_next7=_7salesBg.multiply(_7inc);
				reportPO.setSalesForTheNext7days(
						_next7.setScale(0, 2).intValue()
						);
				//未来14天销量：前7天销量 x （1+7天增长率）+ 前7天销量 x （1+7天增长率）2
				_next14=_next7.add(_7salesBg.multiply(_7inc.pow(2)));
				reportPO.setSalesForTheNext14days(
						_next14.setScale(0, 2).intValue()
						);
				//未来28天销量：前7天销量 x （1+7天增长率）+ 前7天销量 x （1+7天增长率）2 +前7天销量 x （1+7天增长率）3 +前7天销量 x （1+7天增长率）4
				reportPO.setSalesForTheNext28days(
						_next14.add(_7salesBg.multiply(_7inc.pow(3))).
							add(_7salesBg.multiply(_7inc.pow(4)))
							.setScale(0, 2).intValue()
						);
				
				//42天预期补货
				_next42=new BigDecimal(0);
				for (int i = 1; i <=6; i++) {
					_next42=_next42.add(_7salesBg.multiply(_7inc.pow(i)));
				}
				reportPO.setExpectReplenishmentForTheNext42days(_next42.setScale(0, 2).intValue());
				
				//70天预期补货
				_next70=new BigDecimal(0);
				for (int i = 1; i <=10; i++) {
					_next70=_next70.add(_7salesBg.multiply(_7inc.pow(i)));
				}
				reportPO.setExpectReplenishmentForTheNext70days(_next70.setScale(0, 2).intValue());
				//无销量时间
				if(po.getNoSalesDate().after(today)){
					reportPO.setNoSalesDays(0);
				}else{
					reportPO.setNoSalesDays((int)DateUtils.dayDiffer(today, po.getNoSalesDate())+1);
				}
				
				//库存可用时间,null无限大
				if(_7sales>0){
					reportPO.setInventoryOfAvailableDays(new BigDecimal(po.getAvailibleStock()).divide(_7salesBg,0,2).intValue());
				}else{
					reportPO.setInventoryOfAvailableDays(0);
				}
				
				/**
				 * 7天销量
				 * ……
				 * 未来7天销量
				 * 7天增长率
				 * 42天预期补货
				 * 70天预期补货
				 */
				
				fbaStoreProductReportDao.mergeObject(reportPO);
			}
		}
	}

	@Override
	public void importFBAStoreProducts(List<FBAStoreProduct> fbaStoreProducts,int operator) {
		if (CollectionUtils.isNotEmpty(fbaStoreProducts)) {
			Date today=new Date();
			for (FBAStoreProduct fbaStoreProduct : fbaStoreProducts) {
				FBAStoreProductPO po=getFbaStoreProductPO(fbaStoreProduct.getProductCode(), fbaStoreProduct.getShopId());
				if(po==null){
					//第一次导入 ，可用库存为0忽略
					if(fbaStoreProduct.getAvailibleStock()==0){
						continue;
					}
					po=new FBAStoreProductPO();
					po.setShopId(fbaStoreProduct.getShopId());
					po.setFirstInStorageDate(today);
					po.setOperator(operator);
					po.setNoSalesDate(today);
					po.setProductCode(fbaStoreProduct.getProductCode());
				}else{
					if(fbaStoreProduct.getAvailibleStock()>po.getAvailibleStock()){
						po.setLastReplenishDate(today);
						
						//记录库存更新日志
						FBAStoreProductLogPO log=new FBAStoreProductLogPO();
						log.setType(0);
						log.setAvailibleStockOfBefore(po.getAvailibleStock());
						log.setAvailibleStockOfAfter(fbaStoreProduct.getAvailibleStock());
						log.setLogDate(today);
						log.setObjectId(po.getId());
						log.setOperator(profileService.getUserNameById(operator));
						fbaStoreProductLogDao.addObject(log);
						
					}
				}
				po.setAvailibleStock(fbaStoreProduct.getAvailibleStock());
				po.setUpdateDate(today);
				
				fbaStoreProductDao.mergeObject(po);
			}
		}
	}

	private FBAStoreProductPO getFbaStoreProductPO(String productCode,int shopId) {
		String hql="from FBAStoreProductPO where productCode=? and shopId=?";
		return fbaStoreProductDao.findByHql(hql, new Object[]{productCode,shopId});
	}

	@Override
	public void usedFBAStoreProducts(String sku, int lotNumber,int shopId) {
		FBAStoreProductPO po=getFbaStoreProductPO(sku, shopId);
		if(po!=null){
			Date today=new Date();
			//更新无销售时间
			po.setNoSalesDate(today);
		
			//记录库存销售日志
			FBAStoreProductLogPO log=new FBAStoreProductLogPO();
			log.setType(1);
			log.setAvailibleStockOfUsed(lotNumber);
			log.setLogDate(today);
			log.setObjectId(po.getId());
			log.setOperator("系统");
			fbaStoreProductLogDao.addObject(log);
		}
		
	}

	@Override
	public List<OrderCountReport> FBAStoreProductSales(OrderReportSearchForm form) {
		form.setType(ReportType.FBA库存商品销量统计.getVal());
		return orderReportService.findOrderCountReport2(form);
	}
	
	@Override
	public PageList<FBAStoreProductVO> countFBAStoreProducts(SearchFBAStorageCountForm form, int currentPage,
			int pageSize) {
		if(form==null)
			return null;
		
		StringBuilder sql=new StringBuilder();
		StringBuilder where=new StringBuilder();
		sql.append(" SELECT * FROM v_FBA_store_Product_report f ");
		List<Object> params=new ArrayList<Object>();
		if(form.getShopId()>-1){
			where.append(" AND f.shopId=?");
			params.add(form.getShopId());
		}else{
			//根据操作人获取店铺
			if(form.getOperator()>-1){
				sql.append(" INNER JOIN dbo.user_shop us ON f.shopId=us.shop_id  ");
				where.append(" AND us.user_id=? ");
				params.add(form.getOperator());
			}
		}
		
		if(form.getFirstInStorageDateBegin()!=null){
			where.append(" and f.firstInStorageDate>=? ");
			params.add(DateUtils.getRealDate(form.getFirstInStorageDateBegin()));
		}
		
		if(form.getFirstInStorageDateEnd()!=null){
			where.append(" and f.firstInStorageDate<=? ");
			params.add(DateUtils.getFullDate(form.getFirstInStorageDateEnd()));
		}
		
		if(form.getLastReplenishDateBegin()!=null){
			where.append(" and f.lastReplenishDate>=? ");
			params.add(DateUtils.getRealDate(form.getLastReplenishDateBegin()));
		}
		
		if(form.getLastReplenishDateEnd()!=null){
			where.append(" and f.lastReplenishDate<=? ");
			params.add(DateUtils.getFullDate(form.getLastReplenishDateEnd()));
		}
		
		if(form.getStatus()>-1){
			where.append(" and f.status=? ");
			params.add(form.getStatus());
		}
		
		if(CollectionUtils.isNotEmpty(form.getSkus())){
			where.append(" and productCode  in (");
			for (String productCode : form.getSkus()) {
				where.append("'").append(productCode).append("',");
			}
			where.append("'') ");
		}
		
		if(form.getInventoryOfAvailableDaysMin()==0){
			where.append(" AND f.salesFor7days=0 AND availibleStock=0");
		}else if(form.getInventoryOfAvailableDaysMin()>0){
			where.append(" AND f.inventoryOfAvailableDays>=? ");
			params.add(form.getInventoryOfAvailableDaysMin());
		}else if(form.getInventoryOfAvailableDaysMin()==-2){
			//无限大
			where.append(" AND f.salesFor7days=0 AND availibleStock>0 ");
		}
		
		if(form.getInventoryOfAvailableDaysMax()==0){
			where.append(" AND f.salesFor7days=0 AND availibleStock=0");
		}else if(form.getInventoryOfAvailableDaysMax()>0){
			where.append(" AND f.inventoryOfAvailableDays<=?  ");
			params.add(form.getInventoryOfAvailableDaysMax());
		}else if(form.getInventoryOfAvailableDaysMax()==-2){
			//无限大
			where.append(" AND f.salesFor7days=0 AND availibleStock>0");
		}
		
		if(form.getNoSalesDaysMin()>-1){
			where.append(" AND f.noSalesDays>=? ");
			params.add(form.getNoSalesDaysMin());
		}
		
		if(form.getNoSalesDaysMax()>-1){
			where.append(" AND f.noSalesDays<=? ");
			params.add(form.getNoSalesDaysMax());
		}
		
		if(form.getGrowthRateFor7daysMax()!=null){
			where.append(" AND f.growthRateFor7days<=? ");
			params.add(form.getGrowthRateFor7daysMax());
		}
		if(form.getGrowthRateFor7daysMin()!=null){
			where.append(" AND f.growthRateFor7days>=? ");
			params.add(form.getGrowthRateFor7daysMin());
		}
		
//		if(form.getSymbol()!=null&&form.getGrowthRateFor7days()>-1){
//			where.append("AND r.growthRateFor7days").append(form.getSymbol().getVal()).append("?");
//			params.add(form.getGrowthRateFor7days());
//		}
		PageList<VFBAStoreProductReportPO> pl= vfbaStoreProductReportDao.findPageListBySql(currentPage, pageSize, sql.toString(),
				where.toString(), " f.lastReplenishDate DESC ", params);
		return BeanUtils.copyPageList(pl, FBAStoreProductVO.class);
//		List<FBAStoreProductVO> vos= fbaStoreProductDao.findListBySql(sql.toString(), params, FBAStoreProductVO.class);
//		return vos;
		
	}

	@Override
	public FBAStoreProductVO getFBAStoreProductCountDetail(int fbaStoreProductId) {
		String sql="SELECT * FROM dbo.FBA_store_Product" +
				" LEFT JOIN dbo.FBA_store_product_report" +
				" ON id=fba_store_product_id where id="+fbaStoreProductId;
				
		List<FBAStoreProductVO> result=fbaStoreProductLogDao.findListBySql(sql, null, FBAStoreProductVO.class);
		if(CollectionUtils.isNotEmpty(result))
			return result.get(0);
		return null;
	}

	@Override
	public List<FBAStoreProductLog> getFBAStoreProductLogs(int fbaStoreProductId) {
		String hql="from FBAStoreProductLogPO where objectId=?";
		List<FBAStoreProductLogPO> pos= fbaStoreProductLogDao.findListByHql(hql, fbaStoreProductId);
		if(CollectionUtils.isNotEmpty(pos))
			return BeanUtils.copyList(pos, FBAStoreProductLog.class);
		return null;
	}
	
	@Override
	public void updateFBAStoreProductStatus(int fbaStoreProductId,int status){
		FBAStoreProductPO po= fbaStoreProductDao.getObject(fbaStoreProductId);
		if(po!=null){
			po.setStatus(status);
			fbaStoreProductDao.mergeObject(po);
		}
			
	}

	
	public static void main(String[] args) {
		List<Integer> _weaks=new ArrayList<Integer>();
		_weaks.add(0);
		_weaks.add(17);
		_weaks.add(21);
		_weaks.add(0);
		_weaks.add(0);
		
		BigDecimal _7growth=new BigDecimal(0);
		int _avg=0;
		boolean _start=false;
		for (int i = 0; i < _weaks.size()-1; i++) {
			if(_weaks.get(i)==0&&!_start){
				_start=false;
				continue;
			}else{
				_start=true;
				_avg++;
				if(_weaks.get(i+1)==_weaks.get(i)){
					continue;
				}else if(_weaks.get(i)==0){
					_7growth=_7growth.add(new BigDecimal(1));
				}else{
					_7growth=_7growth.add(new BigDecimal(_weaks.get(i+1)-_weaks.get(i))
					.divide(new BigDecimal(_weaks.get(i)),6,4));
				}
			}
		}
		System.out.println(_avg+">>>"+_7growth);
		System.out.println(new BigDecimal(10).divide(new BigDecimal(10),0,2));
	}
}
