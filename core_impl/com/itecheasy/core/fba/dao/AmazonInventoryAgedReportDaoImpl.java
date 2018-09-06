/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba.dao;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.common.PageList;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.operation.AmazonAgedReportForm;
import com.itecheasy.core.po.AmazonInventoryAgedReportHistoryPO;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;
import com.itecheasy.core.system.Shop;
import org.apache.commons.lang.time.DateUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/9 17:14
 * @Description:
 */
public class AmazonInventoryAgedReportDaoImpl extends BaseDAOImpl<AmazonInventoryAgedReportPO, Integer> implements AmazonInventoryAgedReportDao {


    /**
     * where sku in and shopId
     *
     * @param agedReportPOS
     * @param shopId
     * @return
     */
    public List<AmazonInventoryAgedReportPO> findByShopIdAndSkuIn(List<AmazonInventoryAgedReportPO> agedReportPOS, Integer shopId) {
        String hql = "FROM AmazonInventoryAgedReportPO WHERE shopId=? ";
        StringBuilder builder = new StringBuilder();
        for (AmazonInventoryAgedReportPO po : agedReportPOS) {
            builder.append(",'").append(po.getSku()).append("'");
        }
        hql += "  AND sku in ( " + builder.substring(1).toString() + " )";

        return findListByHql(hql, new Object[]{shopId});
    }


    public void updateBySku(List<AmazonInventoryAgedReportPO> agedReportPOS, Integer shopId) {
        addObject(agedReportPOS);
        flush();
        updateBySql
                (" delete from amazon_inventory_aged_report where id in (  select min(id) from amazon_inventory_aged_report where shopId = "
                        + shopId + "  group by sku having(count(1)>1)  ) ");
    }


    public List<AmazonInventoryAgedReportPO> findListByShopId(Integer shopId){
        String hql = "from AmazonInventoryAgedReportPO where shopId = ? ";
        List<AmazonInventoryAgedReportPO> DateResultPos = findListByHql(hql, new Object[]{shopId});
        return  DateResultPos;
    }

    /**
     *  如果id能够赋值上去，说明原来就有这个商品，否者新增
     * @param newItemList 只需要这里面的数据，这个也是最后跟新进数据库的
     * @param daoStockReportList    需要这里面的Id
     */
    public List<AmazonInventoryAgedReportPO> updateDataById(List<AmazonInventoryAgedReportPO> newItemList,List<AmazonInventoryAgedReportPO> daoStockReportList) {
        for (AmazonInventoryAgedReportPO amazonStockReportVO : newItemList) { //new
            for (AmazonInventoryAgedReportPO daoStockReport : daoStockReportList) {     //old
                if (amazonStockReportVO.getShopId().equals(daoStockReport.getShopId()) &&
                        amazonStockReportVO.getSku().equalsIgnoreCase(daoStockReport.getSku())) {
                    amazonStockReportVO.setSyncFirst(daoStockReport.getSyncFirst());
                    amazonStockReportVO.setId(daoStockReport.getId());
                }
            }
        }

        for (AmazonInventoryAgedReportPO newItem : newItemList) {
            if (newItem.getShopId() == null || newItem.getShopId()==0) {
                addObject(newItem);
            } else {
                mergeObject(newItem);
            }
        }
        flush();
        return newItemList;
    }






    @Override
    public PageList<AmazonInventoryAgedReportPO> findPageListTrendHql(AmazonAgedReportForm amazonAgedReportForm, List<Shop> shops) {
        StringBuilder sql = new StringBuilder();
        List<Object> params = new ArrayList<Object>();

        sql.append("FROM AmazonInventoryAgedReportPO ");
        if (amazonAgedReportForm.getShopId() < 0) {
            sql.append(" WHERE shopId IN ( ");
//            List<Shop> shops = systemService.getShopsByUserId(amazonAgedReportForm.getOperatorId());
            for (int i = 0; i < shops.size(); i++) {
                if (i == shops.size() - 1) {
                    sql.append(shops.get(i).getId() + " ) ");
                } else {
                    sql.append(shops.get(i).getId() + ",");
                }
            }
        } else {
            sql.append(" WHERE shopId = ? ");
            params.add(amazonAgedReportForm.getShopId());
        }



        List<String> skuList = amazonAgedReportForm.getSkuList();
        if (CollectionUtils.isNotEmpty(skuList)) {
            if (skuList.size() == 1) {
                sql.append("AND sku = ? ");
                params.add(skuList.get(0).trim());
            } else if (skuList.size() > 1) {
                sql.append("AND sku in ( ");
                for (int i = 0; i < skuList.size(); i++) {
                    if (i == skuList.size() - 1) {
                        sql.append("'").append(skuList.get(i).trim()).append("' )");
                    } else {
                        sql.append("'").append(skuList.get(i).trim()).append("',");
                    }
                }
            }
        }
        //是否清仓商品    0不需要   1需要
        if (amazonAgedReportForm.getIsClearanceItem() > -1) {
            if (amazonAgedReportForm.getIsClearanceItem() == 0){
                sql.append(" AND clearanceItem = ? ");
                params.add(false);
            }else if(amazonAgedReportForm.getIsClearanceItem() == 1){
                sql.append(" AND clearanceItem = ? ");
                params.add(true);
            }
        }


        //是否正在清仓商品
        if (amazonAgedReportForm.getHasDoingClearance()!=null) {
            if (amazonAgedReportForm.getHasDoingClearance()){
                sql.append(" AND doingClearance = ? ");
                params.add(true);
            }else if(!amazonAgedReportForm.getHasDoingClearance()){
                sql.append(" AND ( doingClearance = ? OR doingClearance is null ) ");
                params.add(false);
            }
        }

        //库龄              91-180天  = 1; 大于180天 = 2 ;other -1
        int agingQueryCondition = amazonAgedReportForm.getAgingQueryCondition();
        if (agingQueryCondition == 1) {
//            sql.append("  AND invAge0To90Days <= 0 ");
            sql.append(" AND invAge91To180Days > 0 ");
//            sql.append("  AND invAge181To270Days <= 0 ");
//            sql.append(" AND invAge271To365Days <= 0 ");
//            sql.append(" AND invAge365PlusDays <= 0  ");
        } else if (agingQueryCondition == 2) {
            sql.append("  AND invAge0To90Days <= 0 ");
            sql.append(" AND ( invAge91To180Days <= 0 ");
            sql.append("  OR  invAge181To270Days > 0 ");
            sql.append(" OR  invAge271To365Days > 0 ");
            sql.append(" OR  invAge365PlusDays > 0 ) ");
        }


        if (amazonAgedReportForm.getUpdateStartDate() != null) {
            sql.append("AND syncLast>=? ");
            params.add(new Timestamp(com.itecheasy.common.util.DateUtils.getRealDate(amazonAgedReportForm.getUpdateStartDate()).getTime()));
        }

        if (amazonAgedReportForm.getUpdateEndDate() != null) {
            sql.append("AND syncLast<=? ");
            params.add(new Timestamp(com.itecheasy.common.util.DateUtils.getFullDate(amazonAgedReportForm.getUpdateEndDate()).getTime()));
        }

        if (amazonAgedReportForm.getOriginationStartDate() != null) {
            sql.append("AND startDate>=? ");
            params.add(new Timestamp(com.itecheasy.common.util.DateUtils.getRealDate(amazonAgedReportForm.getOriginationStartDate()).getTime()));
        }

        if (amazonAgedReportForm.getOriginationEndDate() != null) {
            sql.append("AND startDate<=? ");
            params.add(new Timestamp(com.itecheasy.common.util.DateUtils.getFullDate(amazonAgedReportForm.getOriginationEndDate()).getTime()));
        }


        //连接表，获取商品的cms信息

        return findPageListByHql(amazonAgedReportForm.getCurrentPage(), amazonAgedReportForm.getPageSize(), sql.toString(), params.toArray());
    }

}
