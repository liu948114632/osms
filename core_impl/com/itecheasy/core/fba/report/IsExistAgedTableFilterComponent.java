/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba.report;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportDao;
import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportHistoryDao;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;

import java.text.ParseException;
import java.util.*;

/**
 * @Auther: liteng
 * @Date: 2018/7/2 14:05
 * @Description:
 */
public class IsExistAgedTableFilterComponent implements CountAgedItemReportComponent {

    private AmazonInventoryAgedReportDao amazonInventoryAgedReportDao;

    private AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao;

    private ThreadLocal<Integer> shopId;
    private CountAgedItemReportComponent countAgedItemReportComponent;

    public IsExistAgedTableFilterComponent() {
    }

    public IsExistAgedTableFilterComponent(CountAgedItemReportComponent component, ThreadLocal<Integer> shopIdThreadLocal, AmazonInventoryAgedReportDao amazonInventoryAgedReportDao) {
        this.shopId = shopIdThreadLocal;
        this.countAgedItemReportComponent = component;
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
    }

    public IsExistAgedTableFilterComponent(CountAgedItemReportComponent component, ThreadLocal<Integer> shopIdThreadLocal,
                                           AmazonInventoryAgedReportDao amazonInventoryAgedReportDao,
                                           AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao) {
        this(component, shopIdThreadLocal, amazonInventoryAgedReportDao);
        this.amazonInventoryAgedReportHistoryDao = amazonInventoryAgedReportHistoryDao;
    }


    public IsExistAgedTableFilterComponent(CountAgedItemReportComponent component) {
        this.countAgedItemReportComponent = component;
    }

    public void setCountAgedItemReportComponent(CountAgedItemReportComponent countAgedItemReportComponent) {
        this.countAgedItemReportComponent = countAgedItemReportComponent;
    }

    public List<AmazonInventoryAgedReportPO> isEntrust(List<AmazonInventoryAgedReportPO> items, CountAgedItemReportComponent component) throws ParseException {
        if (component != null) {
            component.cost(items);
        }
        return items;
    }

    public void setShopId(ThreadLocal<Integer> shopId) {
        this.shopId = shopId;
    }

    public void setAmazonInventoryAgedReportDao(AmazonInventoryAgedReportDao amazonInventoryAgedReportDao) {
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
    }

    public void setAmazonInventoryAgedReportHistoryDao(AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao) {
        this.amazonInventoryAgedReportHistoryDao = amazonInventoryAgedReportHistoryDao;
    }

    /**
     * isHasHistoryRecord
     * 把不存在resultTable的记录新增
     *
     * @param newAgedItemList 传入刚刚同步的报告
     *                        oldAgedItemList 数据库中的报告
     *                        不存在的直接新增
     * @return 存在的则返回, 用于下一步判断
     */
    @Override
    public List<AmazonInventoryAgedReportPO> cost(List<AmazonInventoryAgedReportPO> newAgedItemList) throws ParseException {
        Date date = new Date();
        //查询库龄报告表   result_table
        List<AmazonInventoryAgedReportPO> dataBasePos = amazonInventoryAgedReportDao.findListByShopId(shopId.get());

        //已经存在result结果表中的数据
        List<AmazonInventoryAgedReportPO> existItems = new ArrayList<AmazonInventoryAgedReportPO>();

        //不存在result结果表中的数据
        List<AmazonInventoryAgedReportPO> directnessToDataBaseItems = new ArrayList<AmazonInventoryAgedReportPO>();

        Map<String, AmazonInventoryAgedReportPO> newAgedItemListPOMap = new HashMap<String, AmazonInventoryAgedReportPO>();
        for (AmazonInventoryAgedReportPO newAgedItemAgedReportPO : newAgedItemList) {
            newAgedItemListPOMap.put(newAgedItemAgedReportPO.getSku(), newAgedItemAgedReportPO);
        }

        //考虑到第一次插入到数据库中时，没有记录就不会进行下面的比较
        //所以直接插入所有的到结果表，因为结果表根本就没有数据
        if (CollectionUtils.isEmpty(dataBasePos)) {
            directnessToDataBaseItems.addAll(newAgedItemList);
        } else {
            for (AmazonInventoryAgedReportPO dataBasePo : dataBasePos) {
                if (newAgedItemListPOMap.containsKey(dataBasePo.getSku())) {
                    existItems.add(newAgedItemListPOMap.get(dataBasePo.getSku()));
                    newAgedItemListPOMap.remove(dataBasePo.getSku());
                }
            }
            directnessToDataBaseItems.addAll(newAgedItemListPOMap.values());
        }

        //不存在的直接添加数据库
        for (AmazonInventoryAgedReportPO directnessToDataBaseItem : directnessToDataBaseItems) {
            directnessToDataBaseItem.setSyncFirst(date);    //设置更新时间
            directnessToDataBaseItem.setSyncLast(date); //设置更新时间
            directnessToDataBaseItem.setStartDate(date);    //设置起始时间
            directnessToDataBaseItem.setSnapshotDate(date);
        }
        List<AmazonInventoryAgedReportPO> calculateContentAfter = calculateContent(directnessToDataBaseItems,dataBasePos);
        amazonInventoryAgedReportDao.updateDataById(calculateContentAfter,dataBasePos);



        //已经存在于数据库中的
        List<AmazonInventoryAgedReportPO> amazonInventoryAgedReportPOS = CalculateContentUtils.calculateStartDate(existItems, dataBasePos);
        List<AmazonInventoryAgedReportPO> calculateContentAfterexistItems = calculateContent(amazonInventoryAgedReportPOS,dataBasePos);

        return isEntrust(calculateContentAfterexistItems, this.countAgedItemReportComponent);
    }


    /**
     * 计算商品的状态，无论走到了那一条分支，都会计算这些值
     *
     * @param pos
     * @return
     */
    private List<AmazonInventoryAgedReportPO> calculateContent(List<AmazonInventoryAgedReportPO> pos,List<AmazonInventoryAgedReportPO> dataBase) throws ParseException {
        //刚刚同步过来的且不在库存表中的话无论如何都将日期设置为起始日期
        Date date = new Date();

//        List<AmazonInventoryAgedReportPO> amazonInventoryAgedReportPOS =
//                CalculateContentUtils.calculateStartDate(pos, dataBase);

        List<AmazonInventoryAgedReportPO> calculateNextClearPoint =
                CalculateContentUtils.calculateNextClearPoint(pos);

        List<AmazonInventoryAgedReportPO> calculateTerminationDate =
                CalculateContentUtils.calculateTerminationDate(calculateNextClearPoint);

        List<AmazonInventoryAgedReportPO> calculatePlanStockToZeroDate =
                CalculateContentUtils.calculatePlanStockToZeroDate(calculateTerminationDate);

        List<AmazonInventoryAgedReportPO> calculateSellOutDate =
                CalculateContentUtils.calculateSellOutDate(calculatePlanStockToZeroDate);

        List<AmazonInventoryAgedReportPO> calculateSellOutStatus
                = CalculateContentUtils.calculateSellOutStatus(calculateSellOutDate);

        List<AmazonInventoryAgedReportPO> calculateIsClearItem =
                CalculateContentUtils.calculateIsClearItem(calculateSellOutStatus);

        return calculateIsClearItem;
    }

}
