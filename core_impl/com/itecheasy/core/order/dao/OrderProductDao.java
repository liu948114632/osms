package com.itecheasy.core.order.dao;

import com.itecheasy.common.BaseDAO;
import com.itecheasy.core.order.ProductNamePO;
import com.itecheasy.core.po.OrderProductPO;

import java.util.List;

/** 
 * @author wanghw
 * @date 2015-5-11 
 * @description TODO
 * @version
 */
public interface OrderProductDao extends BaseDAO<OrderProductPO, Integer>{

    /**
     *
     * 查找店铺下所有的品名
     *
     * @param shopId
     * @param cmsProductCode
     * @return
     */
    public List<ProductNamePO> getAllProductNameByShop(int shopId, String cmsProductCode) ;


    /**
     *
     * @param shopId
     * @param cmsProductCode
     * @return
     */
    public List<OrderProductPO> findByCmsCode(Integer shopId, String cmsProductCode,Integer orderId) ;



}
