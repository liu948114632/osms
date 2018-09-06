/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba.dao;

import com.itecheasy.common.BaseDAO;
import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.core.operation.AmazonAgedReportForm;
import com.itecheasy.core.po.AmazonInventoryAgedReportHistoryPO;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;
import com.itecheasy.core.system.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/9 17:13
 * @Description:
 */
public class AmazonInventoryAgedReportHistoryDaoImpl  extends BaseDAOImpl<AmazonInventoryAgedReportHistoryPO, Integer>
        implements AmazonInventoryAgedReportHistoryDao{

    /**
     * 在历史表中查到这个商店的所有最新的历史记录
     * @param shopId
     * @return
     */
    public List<AmazonInventoryAgedReportHistoryPO> findByShopAndSkuAndSyncLastData(int shopId) {
        //在历史表中查到这个商店的所有最新的历史记录
        String sql = " select a.* from amazon_inventory_aged_report_history a " +
                " where not exists(select 1 from amazon_inventory_aged_report_history b " +
                " where b.sku=a.sku and b.sync_last>a.sync_last and shopId=? )";
        List<Object> params = new ArrayList<Object>();
        params.add(shopId);
        return findListBySql(sql, params);
    }

    public List<AmazonInventoryAgedReportHistoryPO> findAllByShopId(int shopId) {
        //通过shopId查找历史表中所有sku信息
        StringBuilder hisSql = new StringBuilder("select * from amazon_inventory_aged_report_history where id in");
        hisSql.append(" ( select  max(id)   from   amazon_inventory_aged_report_history where shopId=? group by sku ) ");

        List<Object> params = new ArrayList<Object>();
        params.add(shopId);
        //根据shopId取到历史表中记录最新的po
        List<AmazonInventoryAgedReportHistoryPO> lastPOS = findListBySql(hisSql.toString(), params);
        return lastPOS;
    }


}
