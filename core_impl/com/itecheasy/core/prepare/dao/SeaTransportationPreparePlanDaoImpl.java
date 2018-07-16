package com.itecheasy.core.prepare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.core.po.SeaTransportationPreparePlanPO;
import com.itecheasy.core.prepare.PreparePlanProductVO;

/**
 * @author taozihao
 * @date 2018年7月4日 上午8:51:32
 * @description
 */
public class SeaTransportationPreparePlanDaoImpl extends BaseDAOImpl<SeaTransportationPreparePlanPO, Integer> implements SeaTransportationPreparePlanDao {

	@Override
	public List<PreparePlanProductVO> getAllProductInfo(final int shopId,final double monthDiffer,final double stockPeriod) {
		final ArrayList<PreparePlanProductVO> list = new ArrayList<PreparePlanProductVO>();
		final StringBuffer buffer = new StringBuffer("SELECT f.id,s.primary_picture_code,s.unit_weight,f.sku,f.has_sea_transported,f.month_sales ,a.afn_total_quantity ");
		buffer.append("FROM dbo.fba_shop_product f  ");
		buffer.append("INNER JOIN shop_product_cms_info s  ");
		buffer.append("ON f.cms_product_id=s.cms_product_id ");
		buffer.append("LEFT JOIN dbo.amazon_stock_report a  ");
		buffer.append("ON f.shop_id = a.shopId ");
		buffer.append("AND f.sku = a.sku ");
		buffer.append("LEFT JOIN dbo.three_month_sales_sku_temp t ");
		buffer.append("ON f.shop_id=t.shop_id ");
		buffer.append("AND f.sku=t.sku ");
		buffer.append("WHERE (f.is_sea_transportation_blacklist=0 OR f.is_sea_transportation_blacklist IS NULL )");
		buffer.append("AND f.shop_id = ? ");
		buffer.append("AND f.month_sales >0 ");
		buffer.append("AND (t.sku IS NOT NULL OR f.has_sea_transported=1) ");
		buffer.append("GROUP BY f.id,s.primary_picture_code,s.unit_weight,f.sku,f.has_sea_transported,f.month_sales ,a.afn_total_quantity ");
		buffer.append("HAVING (a.afn_total_quantity*1.0/f.month_sales-?)<? ");
		buffer.append("ORDER BY f.has_sea_transported ASC ");
		System.out.println(buffer.toString());
		this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				@SuppressWarnings("deprecation")
				Connection connection = session.connection();
				PreparedStatement ps = connection.prepareStatement(buffer.toString());
				ps.setInt(1, shopId);
				ps.setDouble(2, monthDiffer);
				ps.setDouble(3, stockPeriod);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					PreparePlanProductVO vo = new PreparePlanProductVO();
					//s.primary_picture_code,s.unit_weight,f.sku,f.has_sea_transported,f.month_sales
					vo.setFbaShopProductId(rs.getInt("id"));
					vo.setPrimaryPictureCode(rs.getString("primary_picture_code"));
					vo.setUnitWeight(rs.getDouble("unit_weight"));
					vo.setMonthSales(rs.getInt("month_sales"));
					vo.setSku(rs.getString("sku"));
					vo.setHasSeaTransported(rs.getInt("has_sea_transported"));
					vo.setAfnTotalQuantity(rs.getInt("afn_total_quantity"));
					list.add(vo);
				}
				return list;
			}
		});
		return list;
	}

	@Override
	public List<PreparePlanProductVO> getProductInfoByPlanId(final int planId) {
		final ArrayList<PreparePlanProductVO> list = new ArrayList<PreparePlanProductVO>();
		final StringBuilder builder = new StringBuilder("SELECT a.fba_shop_product_id,a.prepareQuantity,a.actualQuantity,a.total_weight,a.product_type,a.is_canceled,b.sku,b.has_sea_transported,b.month_sales,c.primary_picture_code,c.unit_weight,d.afn_total_quantity ");
		builder.append("FROM sea_transportation_prepare_plan_item a ");
		builder.append("LEFT JOIN fba_shop_product b ");
		builder.append("ON a.fba_shop_product_id=b.id ");
		builder.append("LEFT JOIN shop_product_cms_info c ");
		builder.append("ON b.cms_product_id=c.cms_product_id ");
		builder.append("LEFT JOIN amazon_stock_report d ");
		builder.append("ON b.shop_id=d.shopId ");
		builder.append("AND b.sku=d.sku ");
		builder.append("WHERE a.sea_transportation_prepare_plan_id=? ");
		builder.append("ORDER BY b.has_sea_transported ASC ");
		this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				@SuppressWarnings("deprecation")
				Connection connection = session.connection();
				PreparedStatement ps = connection.prepareStatement(builder.toString());
				ps.setInt(1, planId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					PreparePlanProductVO vo = new PreparePlanProductVO();
					vo.setFbaShopProductId(rs.getInt("fba_shop_product_id"));
					vo.setPrimaryPictureCode(rs.getString("primary_picture_code"));
					vo.setMonthSales(rs.getInt("month_sales"));
					vo.setSku(rs.getString("sku"));
					vo.setHasSeaTransported(rs.getInt("has_sea_transported"));
					vo.setAfnTotalQuantity(rs.getInt("afn_total_quantity"));
					vo.setActualQuantity(rs.getInt("actualQuantity"));
					vo.setPrepareQuantity(rs.getInt("prepareQuantity"));
					vo.setIsCanceled(rs.getInt("is_canceled"));
					vo.setProductType(rs.getInt("product_type"));
					vo.setTotalWeight(rs.getDouble("total_weight"));
					vo.setUnitWeight(rs.getDouble("unit_weight"));
					list.add(vo);
				}
				return null;
			}
		});
		return list;
	}

}
