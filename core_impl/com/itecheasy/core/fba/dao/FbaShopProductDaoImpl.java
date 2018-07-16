package com.itecheasy.core.fba.dao;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.core.po.FbaShopProductPO;
import com.itecheasy.core.order.OrderService.OrderProductStatus;
import com.itecheasy.core.order.OrderService.OrderStatus;

import java.util.Date;
import java.util.List;

/** 
 * @author wanghw
 * @date 2016-12-2 
 * @description TODO
 * @version 1.2.2
 */
public class FbaShopProductDaoImpl extends BaseDAOImpl<FbaShopProductPO, Integer> implements FbaShopProductDao{

	@Override
	public List<String> getHotSaleProducts(Date startDate, Date endDate, int shopId, int amount) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT shop_seller_sku ");
		buffer.append("FROM dbo.[order] o ");
		buffer.append("INNER JOIN dbo.order_product p ");
		buffer.append("ON o.id=p.order_id ");
		buffer.append("INNER JOIN dbo.fba_shop_product f ");
		buffer.append("ON f.cms_product_id=p.cms_product_id ");
		buffer.append("AND p.shop_seller_sku=f.sku ");
		buffer.append("AND o.shop_id=f.shop_id ");
		buffer.append("AND p.shop_seller_sku=f.sku ");
		buffer.append("WHERE o.status<>132 AND o.shop_type=1 AND p.shop_seller_sku IS NOT NULL ");
		buffer.append("AND (f.has_sea_transported=0 OR f.has_sea_transported IS NULL) ");
		buffer.append("AND (f.is_sea_transportation_blacklist=0 OR f.is_sea_transportation_blacklist IS NULL) ");
		buffer.append("AND (o.fulfillmentChannel='afn' OR o.fulfillmentChannel='mfn') ");
		buffer.append("AND o.shop_order_status<>'CANCELED' ");
		buffer.append("AND o.shop_order_date<=? AND o.shop_order_date>=? ");
		buffer.append("AND p.is_cancel=0 ");
		buffer.append("AND o.shop_id=? ");
		buffer.append("GROUP BY p.shop_seller_sku,o.shop_id having SUM(p.shop_quantity_Ordered)>=? ");
		@SuppressWarnings("unchecked")
		List<String> list = this.executeListStoredProcedure(buffer.toString(), new Object[]{endDate,startDate,shopId,amount});
		return list;
	}

	@Override
	public void updateHasSeaTransportedForAllShop() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE fba_shop_product SET has_sea_transported=1 ");
		builder.append("WHERE id IN ( ");
		builder.append("SELECT DISTINCT op.fba_shop_product_id FROM dbo.replenishment_order_product op ");
		builder.append("LEFT OUTER JOIN dbo.replenishment_order o ON op.replenishment_order_id=o.id ");
		builder.append("WHERE o.fba_shipment_method='ST' ");
		builder.append(" AND o.status IN (");
		builder.append(OrderStatus.已发货.getVal());
		builder.append(",");
		builder.append(OrderStatus.已入仓.getVal());
		builder.append(",");
		builder.append(OrderStatus.完成.getVal());
		builder.append(")");
		builder.append(" AND op.status<>");
		builder.append(OrderProductStatus.取消.getVal());
		builder.append(")");
		//System.out.println(builder.toString());
		this.getSession().createSQLQuery(builder.toString()).executeUpdate();
	}

}
