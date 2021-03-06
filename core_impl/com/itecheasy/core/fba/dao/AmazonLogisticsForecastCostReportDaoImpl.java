/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba.dao;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;
import com.itecheasy.core.po.AmazonLogisticsForecastCostReportPO;

import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/22 15:25
 * @Description:
 */
public class AmazonLogisticsForecastCostReportDaoImpl extends BaseDAOImpl<AmazonLogisticsForecastCostReportPO,Integer> implements AmazonLogisticsForecastCostReportDao {


    /**
     *
     * @param shopId
     * @return
     */
    public List<AmazonLogisticsForecastCostReportPO> findListByShopId(Integer shopId){
        String hql = "from AmazonLogisticsForecastCostReportPO where shopId = ? ";
        return findListByHql(hql, new Object[]{shopId});
    }

    /**
     *  如果id能够赋值上去，说明原来就有这个商品，否者新增
     * @param newReportItemList 只需要这里面的数据，这个也是最后跟新进数据库的
     * @param daoReportItemList    需要这里面的Id
     * @return
     */
    @Override
    public List<AmazonLogisticsForecastCostReportPO> updateDataById(List<AmazonLogisticsForecastCostReportPO> newReportItemList,
                                                                    List<AmazonLogisticsForecastCostReportPO> daoReportItemList) {
        for (AmazonLogisticsForecastCostReportPO amazonStockReportVO : newReportItemList) { //new
            for (AmazonLogisticsForecastCostReportPO daoStockReport : daoReportItemList) {     //old
                if (amazonStockReportVO.getShopId().equals(daoStockReport.getShopId()) &&
                        amazonStockReportVO.getSku().equalsIgnoreCase(daoStockReport.getSku())) {
                    amazonStockReportVO.setSyncFirst(daoStockReport.getSyncFirst());
                    amazonStockReportVO.setId(daoStockReport.getId());

                    //当新的算出来的新的vo的basePrice是空的时候,才需要取旧的
                    if(amazonStockReportVO.getBasePrice()==null){
                        if (daoStockReport.getBasePrice()!=null){
                            amazonStockReportVO.setBasePrice(daoStockReport.getBasePrice());
                        }
                    }
                }
            }
        }

        for (AmazonLogisticsForecastCostReportPO newItem : newReportItemList) {
            if (newItem.getShopId() == null || newItem.getShopId()==0) {
                addObject(newItem);
            } else {
                mergeObject(newItem);
            }
        }
        flush();
        return newReportItemList;
    }
}
