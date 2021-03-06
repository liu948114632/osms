package com.itecheasy.core.order.dao;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.common.util.StringUtils;
import com.itecheasy.core.order.ProductNamePO;
import com.itecheasy.core.po.OrderProductPO;
import org.apache.regexp.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanghw
 * @date 2015-5-11
 * @description TODO
 */
public class OrderProductDaoImpl extends BaseDAOImpl<OrderProductPO, Integer> implements OrderProductDao {



    @Override
    public List<ProductNamePO> getAllProductNameByShop(int shopId, String cmsProductCode) {

        List<Object> params = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder("SELECT  product_chinese_name AS productNameChinese,  ");
        sql.append(" product_english_name AS productNameEnglish, ");
        sql.append(" cms_product_code AS cmsProductCode ");
        sql.append(" from order_product ");
        sql.append(" WHERE order_id in(select id from [order] where shop_id = ?) ");
        sql.append(" AND ( ISNULL( product_chinese_name , '' ) != ''  or ISNULL( product_english_name , '') != '') ");
        params.add(shopId);

        if (StringUtils.isNotEmpty(cmsProductCode)) {
            sql.append(" AND  cms_product_code = ? ");
            params.add(cmsProductCode);
        }

        return findListBySql(sql.toString(), params, ProductNamePO.class);

    }

    @Override
    public List<OrderProductPO> findByCmsCode(Integer shopId, String cmsProductCode,Integer orderId) {
        StringBuilder sql = new StringBuilder(" SELECT * FROM order_product WHERE 1=1   ");
        List<Object> params = new ArrayList<Object>();
        if (shopId!=null ){
            sql.append(" AND order_id in(select id from [order] where shop_id = ? ) ");
            params.add(shopId);
        }

        if (cmsProductCode!=null){
            sql.append(" AND cms_product_code = ?  ");
            params.add(cmsProductCode);
        }

        if (orderId!=null){
            sql.append(" AND order_id = ?  ");
            params.add(orderId);
        }

        return findListBySql(sql.toString(), params);
    }

}
