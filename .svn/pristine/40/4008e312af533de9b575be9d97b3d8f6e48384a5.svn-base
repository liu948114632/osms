/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba.dao;

import com.itecheasy.common.BaseDAO;
import com.itecheasy.common.PageList;
import com.itecheasy.core.operation.AmazonAgedReportForm;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;
import com.itecheasy.core.system.Shop;

import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/9 17:13
 * @Description:
 */
public interface AmazonInventoryAgedReportDao extends BaseDAO<AmazonInventoryAgedReportPO, Integer> {


     void updateBySku(List<AmazonInventoryAgedReportPO> agedReportPOS, Integer shopId) ;

     List<AmazonInventoryAgedReportPO> findListByShopId(Integer shopId);



    /**
     * 取到sku和shopId来查找对象List
     *
     * @param agedReportPOS
     * @param shopId
     * @return
     */

    List<AmazonInventoryAgedReportPO> findByShopIdAndSkuIn(List<AmazonInventoryAgedReportPO> agedReportPOS, Integer shopId);



    /**
     * 最后采用的值还是左边的，右边的只会选取id
     *  如果id能够赋值上去，说明原来就有这个商品，否者新增
     * @param newItemList 只需要这里面的数据，这个也是最后跟新进数据库的
     * @param daoStockReportList    需要这里面的Id
     */
    List<AmazonInventoryAgedReportPO> updateDataById(List<AmazonInventoryAgedReportPO> newItemList,List<AmazonInventoryAgedReportPO> daoStockReportList) ;



     PageList<AmazonInventoryAgedReportPO> findPageListTrendHql(AmazonAgedReportForm amazonAgedReportForm,List<Shop> shops);

}
