package com.itecheasy.core.product;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.PageList;
import com.itecheasy.common.Param;
import com.itecheasy.common.sysconfig.SysConfigService;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.po.ProductDevelopPO;
import com.itecheasy.core.po.ProductDevelopViewPO;
import com.itecheasy.core.product.ProductDevelopSearch.ProductDevelopSearchOrderRule;
import com.itecheasy.core.product.dao.ProductDevelopDao;
import com.itecheasy.core.product.dao.ProductDevelopViewDao;

/** 
 * @author whw
 * @date 2017-8-17 
 * @description TODO
 * @version 
 */
public class ProductDevelopServiceImpl implements ProductDevelopService{
	private static final String PRODUCT_EXIST = "产品已经存在！";
	private ProductDevelopDao productDevelopDao;
	private ProductDevelopViewDao productDevelopViewDao;
	private SysConfigService sysConfigService;
	
	
	

	public void setSysConfigService(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}

	public void setProductDevelopViewDao(ProductDevelopViewDao productDevelopViewDao) {
		this.productDevelopViewDao = productDevelopViewDao;
	}

	public void setProductDevelopDao(ProductDevelopDao productDevelopDao) {
		this.productDevelopDao = productDevelopDao;
	}

	@Override
	public void addProductDevelop(List<ProductDevelop> productDevelops, int operator)throws BussinessException {
		for (ProductDevelop productDevelop : productDevelops) {
			if(getProductDevelopByProduct(productDevelop.getCmsProductCode())!=null){
				throw new BussinessException(productDevelop.getCmsProductCode()+PRODUCT_EXIST);
			}
			
			productDevelop.setAddDate(new Date());
			productDevelop.setAddOne(operator);
		}
		
		productDevelopDao.addObject(BeanUtils.copyList(productDevelops, ProductDevelopPO.class));
	}

	@Override
	public PageList<ProductDevelop> findProductDevelop(ProductDevelopSearch search) {
		String sql=" SELECT a.* FROM v_product_develop a ";
		StringBuilder where =new StringBuilder();
		List<Object> params=new ArrayList<Object>();
		if(StringUtils.isNotEmpty(search.getProductCode())){
			where.append(" and a.cms_product_code like ? ");
			params.add("%"+search.getProductCode()+"%");
		}
		
		if(CollectionUtils.isNotEmpty(search.getProductCodes())){
			StringBuilder codes=new StringBuilder();
			for (String object : search.getProductCodes()) {
				codes.append(",'"+object+"'");
			}
			
			where.append("  and a.cms_product_code in ( ");
			where.append(codes.substring(1)).append(" ) ");
		}
		
		if(StringUtils.isNotEmpty(search.getDeveloper())){
			where.append(" and a.developer=? ");
			params.add(search.getDeveloper());
		}
		
		if(search.getPutawayDateBegin()!=null){
			where.append(" and putaway_date>=? ");
			params.add(DateUtils.getRealDate(search.getPutawayDateBegin()));
		}
		if(search.getPutawayDateEnd()!=null){
			where.append(" and putaway_date<=? ");
			params.add(DateUtils.getFullDate(search.getPutawayDateEnd()));
		}
		
		if(search.getSalesBegin()!=null){
			where.append(" and sales>= ? ");
			params.add(search.getSalesBegin());
		}
		if(search.getSalesEnd()!=null){
			where.append(" and sales<= ? ");
			params.add(search.getSalesEnd());
		}
		
		StringBuilder orderby=new StringBuilder();
		
		if(search.getOrderRule()!=ProductDevelopSearchOrderRule.ADD_ONE){
			orderby.append(search.getOrderRule().getColmun()).append(" ");
		}else{
			sql+=" left join [user] b on b.id=a.add_one  ";
			orderby.append(" b.name ");
		}
		orderby.append(search.getOrderSort().getColmun());
		
		PageList<ProductDevelopViewPO>  pos=productDevelopViewDao.findPageListBySql(search.getCurrentPage(), search.getPageSize(), 
				sql, where.toString(), orderby.toString(), params);
		return BeanUtils.copyPageList(pos, ProductDevelop.class);
	}

	@Override
	public ProductDevelop getProductDevelopByProduct(String productCode) {
		String hql="from ProductDevelopPO where cmsProductCode=? ";
		return BeanUtils.copyProperties(this.productDevelopDao.findByHql(hql, productCode), ProductDevelop.class);
	}

	@Override
	public List<String> getDeveloper() {
		String sql=" SELECT DISTINCT developer FROM product_develop ";
		List<String> rs=this.productDevelopDao.getSimpleColumnBySql(sql, null);
		return rs;
	}
	
	@Override
	public void statisticsSales(Date begin,Date end){
		ArrayList<Param> parameters = new ArrayList<Param>();
		StringBuilder log=new StringBuilder("最新统计销量时间：");
		if(end!=null){
			parameters.add(new Param("end", DateUtils.getFullDate(end)));
		}else{
			end=new Date();
		}
		if(begin!=null){
			log.append(MessageFormat.format("{0}--{1}", logDate(begin),logDate(end)));
			parameters.add(new Param("begin", DateUtils.getRealDate(begin)));
		}else{
			log.append("截止到"+logDate(end));
		}
		productDevelopDao.execStoredProcedure("calc_product_develop_sales", parameters);
		
		sysConfigService.setValue(STATISTICS_SALES_LOG, log.toString());
	}
	
	
	private String logDate(Date d){
		if(d!=null)
			return DateUtils.convertDate(d, "yyyy年MM月dd日");
		return "";
	}

}
