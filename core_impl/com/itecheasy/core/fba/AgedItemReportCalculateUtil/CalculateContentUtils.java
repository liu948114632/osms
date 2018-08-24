/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba.AgedItemReportCalculateUtil;

import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/13 10:28
 * @Description: 亚马逊库龄报告表的各类计算
 */
public class CalculateContentUtils {
    /**
     *  下一清算点
     * @param pos
     * @return
     */
    public static List<AmazonInventoryAgedReportPO> calculateNextClearPoint(List<AmazonInventoryAgedReportPO> pos) {
        for (AmazonInventoryAgedReportPO po : pos) {
            Date dayOfMonth = DateUtils.getDayOfMonth(po.getStartDate());
            int compare = po.getStartDate().compareTo(dayOfMonth);
            if (compare > 0) {   //起始日期大于15
                Date date = org.apache.commons.lang.time.DateUtils.addMonths(po.getStartDate(), 3);
                po.setNextClearingPoint(date);
            } else if (compare <= 0) {//起始日期小于等于15
                Date date = org.apache.commons.lang.time.DateUtils.addMonths(po.getStartDate(), 4);
                po.setNextClearingPoint(date);
            }
        }
        return pos;
    }

    /**
     * 终止日期计算
     * @param pos
     * @return
     */
    public static List<AmazonInventoryAgedReportPO> calculateTerminationDate(List<AmazonInventoryAgedReportPO> pos) {
        for (AmazonInventoryAgedReportPO po : pos) {
            Date terminationDate = org.apache.commons.lang.time.DateUtils.addDays(po.getNextClearingPoint(), -8);
            po.setTerminationDate(terminationDate);
        }
        return pos;
    }

    /**
     * SyncFirst 需要
     * 预计库存清零日期
     * 1.值=当前日期+可售库存/30天销量*30（进1法）
     * 2.如果30天销量为0，则set为2050-1-1（日期比较远，一看就卖不完）
     */
    public static List<AmazonInventoryAgedReportPO> calculatePlanStockToZeroDate(List<AmazonInventoryAgedReportPO> pos) {
        for (AmazonInventoryAgedReportPO po : pos) {
            int compareTo = po.getUnitsShippedLast30Days().compareTo(new BigDecimal(0));
            if (compareTo <= 0) {
                //月销量小于等于零
                Date parse = DateUtils.getRemoteFuture();
                po.setPlanStockToZeroDate(parse);
            } else {
                BigDecimal multiply = po.getAvaliableQuantitySellable().multiply(new BigDecimal(30)).
                        divide(po.getUnitsShippedLast30Days(), 0, BigDecimal.ROUND_CEILING);
                Date date = org.apache.commons.lang.time.DateUtils.addDays(po.getSyncFirst(), multiply.intValue());
                po.setPlanStockToZeroDate(date);
            }
        }
        return pos;
    }

    /**
     * 前提 无
     *  售完时间
     * @param pos
     * @return
     */
    public static List<AmazonInventoryAgedReportPO> calculateSellOutDate(List<AmazonInventoryAgedReportPO> pos) {
        for (AmazonInventoryAgedReportPO po : pos) {

            /**
             * 1.	意思是，还需要用多少天才能卖完
             * 2.	值=（可用库存/30天销量）*30（小数）
             * 3.	如果30天销量为0，则取值99999
             */
            int compareTo = po.getUnitsShippedLast30Days().compareTo(new BigDecimal(0));
            if (compareTo <= 0) {
                po.setSellOutDate(new BigDecimal(0));
            } else {
                BigDecimal howDaySellout = po.getAvaliableQuantitySellable().multiply(new BigDecimal(30).
                        divide(po.getUnitsShippedLast30Days(), 0, BigDecimal.ROUND_CEILING));
                po.setSellOutDate(howDaySellout);
            }
        }
        return pos;
    }

    /**
     * 售完状态
     * 1.	终止日期=<预计库存清0日期，则无法售完
     * 2.	终止日期>预计库存清0日期，则可以售完
     */
    public static List<AmazonInventoryAgedReportPO> calculateSellOutStatus(List<AmazonInventoryAgedReportPO> pos) {
        for (AmazonInventoryAgedReportPO po : pos) {

            int i = po.getTerminationDate().compareTo(po.getPlanStockToZeroDate());
            if (i > 0) {
                po.setSellOutStatus(1); //可以售完
            } else if (i <= 0) {
                po.setSellOutStatus(0); //无法售完
            }
        }
        return pos;
    }

}