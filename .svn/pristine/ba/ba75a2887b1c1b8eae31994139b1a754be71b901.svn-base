/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba.report;

import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/13 10:28
 * @Description: 亚马逊库龄报告表的各类计算
 */
public class CalculateContentUtils {

    public static void main(String[] args) throws ParseException {
        Calendar cal = Calendar.getInstance();
        //下面的就是把当前日期加一个月
        cal.add(Calendar.MONTH, 3);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("today is:" + format.format(Calendar.getInstance().getTime()));
        System.out.println("yesterday is:" + format.format(cal.getTime()));

        Date parse = format.parse("2018-08-17");
        Date dateAdd24 = org.apache.commons.lang.time.DateUtils.addMonths(parse, 1);
        System.out.println("dateAdd24 = " + dateAdd24);

    }


    /**
     * @param oldTime 较小的时间
     * @param newTime 较大的时间 (如果为空   默认当前时间 ,表示和当前时间相比)
     * @return -1 ：同一天.    0：昨天 .   1 ：至少是前天.
     * @throws ParseException 转换异常
     * @author LuoB.
     */
    public static int isYeaterday(Date oldTime, Date newTime) throws ParseException {
        if (newTime == null) {
            newTime = new Date();
        }
        //将下面的 理解成  yyyy-MM-dd 00：00：00 更好理解点
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = format.format(newTime);
        Date today = format.parse(todayStr);
        //昨天 86400000=24*60*60*1000 一天
        if ((today.getTime() - oldTime.getTime()) > 0 && (today.getTime() - oldTime.getTime()) <= 86400000) {
            return 0;
        } else if ((today.getTime() - oldTime.getTime()) <= 0) { //至少是今天
            return -1;
        } else { //至少是前天
            return 1;
        }

    }


    /**
     * 过滤掉不需要更新更新时间的商品  剩下的就是需要跟新的最后修改时间
     *
     * @param newAmazonInventoryAgedReportPOS      从亚马逊新传来的
     * @param dataBaseAmazonInventoryAgedReportPOS 数据库中已有的
     * @return 需要更新时间的商品
     */
    public static List<AmazonInventoryAgedReportPO> calculateUpdate(List<AmazonInventoryAgedReportPO> newAmazonInventoryAgedReportPOS,
                                                                    List<AmazonInventoryAgedReportPO> dataBaseAmazonInventoryAgedReportPOS) throws ParseException {

        Date date = new Date();
//        for (AmazonInventoryAgedReportPO newAgedReportPO : newAmazonInventoryAgedReportPOS) {
//            for (AmazonInventoryAgedReportPO dataBaseAmazonInventoryAgedReportPO : dataBaseAmazonInventoryAgedReportPOS) {
//                int isYesterday = isYeaterday(dataBaseAmazonInventoryAgedReportPO.getSyncLast(), newAgedReportPO.getSyncLast());
//                if (isYesterday != 0) {
//                    //更新日期不为昨天的情况
//                    newAgedReportPO.setSyncLast(date);
//                }
//            }
//        }

        for (AmazonInventoryAgedReportPO newAgedReportPO : newAmazonInventoryAgedReportPOS) {
            boolean flag = false;
            for (AmazonInventoryAgedReportPO dataBaseAmazonInventoryAgedReportPO : dataBaseAmazonInventoryAgedReportPOS) {
                int isYesterday = isYeaterday(dataBaseAmazonInventoryAgedReportPO.getSyncLast(), newAgedReportPO.getSyncLast());
                if (newAgedReportPO.getSku().equals(dataBaseAmazonInventoryAgedReportPO.getSku()) &&
                        newAgedReportPO.getShopId().equals(dataBaseAmazonInventoryAgedReportPO.getShopId())) {
                    if (isYesterday != 0) {
                        //不是昨天才更新
                        newAgedReportPO.setSyncLast(date);
                    }
                    flag = true;
                }
            }
            if (flag == false) {    //全部比完，发现还不存在,那就说明这个sku是存在于库龄报告表中的
                newAgedReportPO.setSyncLast(date);
            }
        }

        return newAmazonInventoryAgedReportPOS;

    }


    /**
     * 计算起始日期
     *
     * @param newAmazonInventoryAgedReportPOS
     * @param dataBaseAmazonInventoryAgedReportPOS
     * @return
     * @throws ParseException
     */
    public static List<AmazonInventoryAgedReportPO> calculateStartDate(List<AmazonInventoryAgedReportPO> newAmazonInventoryAgedReportPOS,
                                                                       List<AmazonInventoryAgedReportPO> dataBaseAmazonInventoryAgedReportPOS) throws ParseException {
        Date date = new Date();

        for (AmazonInventoryAgedReportPO newAgedReportPO : newAmazonInventoryAgedReportPOS) {
            boolean flag = false;   //false 假设存在
            for (AmazonInventoryAgedReportPO dataBaseAmazonInventoryAgedReportPO : dataBaseAmazonInventoryAgedReportPOS) {
                int isYesterday = isYeaterday(dataBaseAmazonInventoryAgedReportPO.getSyncLast(), newAgedReportPO.getSyncLast());
                if (newAgedReportPO.getSku().equals(dataBaseAmazonInventoryAgedReportPO.getSku()) &&
                        newAgedReportPO.getShopId().equals(dataBaseAmazonInventoryAgedReportPO.getShopId())) {

                    if (isYesterday != 0) {
                        flag = false;
                        //不是昨天才更新
//                        newAgedReportPO.setStartDate(date);
//                        newAgedReportPO.setSnapshotDate(date);
                    }else if (isYesterday == 0){
                        //更新日期为昨天的 保持不变
                        flag = true;
                        newAgedReportPO.setSnapshotDate(dataBaseAmazonInventoryAgedReportPO.getSnapshotDate());
                        newAgedReportPO.setStartDate(dataBaseAmazonInventoryAgedReportPO.getStartDate());
                        newAgedReportPO.setNextClearingPoint(dataBaseAmazonInventoryAgedReportPO.getNextClearingPoint());
                        newAgedReportPO.setTerminationDate(dataBaseAmazonInventoryAgedReportPO.getTerminationDate());

                        // TODO: 2018/8/20
                        //存在的情况
                        BigDecimal invAge0To90Days = newAgedReportPO.getInvAge0To90Days();
                        BigDecimal invAge91To180Days = newAgedReportPO.getInvAge91To180Days();
                        BigDecimal invAge181To270Days = newAgedReportPO.getInvAge181To270Days();
                        BigDecimal invAge271To365Days = newAgedReportPO.getInvAge271To365Days();
                        BigDecimal invAge365PlusDays = newAgedReportPO.getInvAge365PlusDays();

                        int i = invAge0To90Days.compareTo(BigDecimal.ZERO); //(r==1) 左边大于右边
                        int i1 = invAge91To180Days.compareTo(BigDecimal.ZERO);
                        int i2 = invAge181To270Days.compareTo(BigDecimal.ZERO);
                        int i3 = invAge271To365Days.compareTo(BigDecimal.ZERO);
                        int i4 = invAge365PlusDays.compareTo(BigDecimal.ZERO);

                        boolean b = i2 > 0 || i3 > 0 || i4 > 0;
                        boolean c = i <= 0 && i1 <= 0;

                        if (b && c) {
                            //仅库龄为180天
                        } else {
                            //非   仅库龄为180天
//                            flag=false;
                        }
                    }

                }
            }
            if (flag == false) {    //不存在于库龄报告表中 直接跟新
                newAgedReportPO.setSnapshotDate(date);
                newAgedReportPO.setStartDate(date);
            } else {
            }
        }

        return newAmazonInventoryAgedReportPOS;
    }

    /**
     * 下一清算点
     *
     * @param pos
     * @return
     */
    public static List<AmazonInventoryAgedReportPO> calculateNextClearPoint(List<AmazonInventoryAgedReportPO> pos) {
        for (AmazonInventoryAgedReportPO po : pos) {
            if (po.getStartDate() != null) {
                Date startDateAdd90 = org.apache.commons.lang.time.DateUtils.addDays(po.getStartDate(), 90);

                Date dayOfMonth = DateUtils.getDayOfMonth(startDateAdd90);   //获取这个月的第15天

                int compareToDate = startDateAdd90.compareTo(dayOfMonth);
                if (compareToDate > 0) {   //起始日期大于15
                    Date date = org.apache.commons.lang.time.DateUtils.addMonths(dayOfMonth, 1);
                    po.setNextClearingPoint(date);
                } else if (compareToDate <= 0) {//起始日期小于等于15
//                    Date date = org.apache.commons.lang.time.DateUtils.addMonths(startDateAdd90, 1);
                    po.setNextClearingPoint(dayOfMonth);
                }
            }
        }
        return pos;
    }

    /**
     * 终止日期计算
     *
     * @param pos
     * @return
     */
    public static List<AmazonInventoryAgedReportPO> calculateTerminationDate(List<AmazonInventoryAgedReportPO> pos) {
        for (AmazonInventoryAgedReportPO po : pos) {
            if (po.getNextClearingPoint() != null) {
                Date terminationDate = org.apache.commons.lang.time.DateUtils.addDays(po.getNextClearingPoint(), -8);
                po.setTerminationDate(terminationDate);
            }
        }
        return pos;
    }


    /**
     * +90days
     * 预计库存清零日期
     * 1.值=当前日期+可售库存/30天销量*30（进1法）
     * 2.如果30天销量为0，则set为2050-1-1（日期比较远，一看就卖不完）
     */
    public static List<AmazonInventoryAgedReportPO> calculatePlanStockToZeroDate(List<AmazonInventoryAgedReportPO> pos) {
        for (AmazonInventoryAgedReportPO po : pos) {
            if (po.getUnitsShippedLast30Days() != null) {
                int compareTo = po.getUnitsShippedLast30Days().compareTo(new BigDecimal(0));
                if (compareTo <= 0) {
                    //月销量小于等于零
                    Date parse = DateUtils.getRemoteFuture();
                    po.setPlanStockToZeroDate(parse);
                } else {
                    BigDecimal subtract90 = po.getAvaliableQuantitySellable().subtract(po.getInvAge0To90Days());
                    BigDecimal multiply = subtract90.multiply(new BigDecimal(30))
                            .divide(po.getUnitsShippedLast30Days(), 0, BigDecimal.ROUND_CEILING);

                    Date date = org.apache.commons.lang.time.DateUtils.addDays(po.getSyncFirst(), multiply.intValue());
                    po.setPlanStockToZeroDate(date);
                }
            }
        }
        return pos;
    }

    /**
     * 计算售完时间
     * -90days天的
     *
     * @param pos
     * @return
     */
    public static List<AmazonInventoryAgedReportPO> calculateSellOutDate(List<AmazonInventoryAgedReportPO> pos) {
        for (AmazonInventoryAgedReportPO po : pos) {
            if (po.getUnitsShippedLast30Days() != null) {
                /**
                 * 1.	意思是，还需要用多少天才能卖完
                 * 2.	值=（可用库存/30天销量）*30（小数）
                 * 3.	如果30天销量为0，则取值99999
                 */
                int compareTo = po.getUnitsShippedLast30Days().compareTo(new BigDecimal(0));
                if (compareTo <= 0) {
                    po.setSellOutDate(new BigDecimal(99999));
                } else {
                    BigDecimal subtract90 = po.getAvaliableQuantitySellable().subtract(po.getInvAge0To90Days());
                    BigDecimal howDaySellout = subtract90.multiply(new BigDecimal(30))
                            .divide(po.getUnitsShippedLast30Days(), 0, BigDecimal.ROUND_CEILING);
                    po.setSellOutDate(howDaySellout);
                }
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
            if (po.getTerminationDate() != null && po.getPlanStockToZeroDate() != null) {
                int i = po.getTerminationDate().compareTo(po.getPlanStockToZeroDate());
                if (i > 0) {
                    po.setSellOutStatus(1); //可以售完
                } else if (i <= 0) {
                    po.setSellOutStatus(0); //无法售完
                }
            }
        }
        return pos;
    }


    /**
     * 计算是否需要清仓
     *
     * @param pos
     * @return
     */
    public static List<AmazonInventoryAgedReportPO> calculateIsClearItem(List<AmazonInventoryAgedReportPO> pos) {
        for (AmazonInventoryAgedReportPO sellOutStatus : pos) {
            if (sellOutStatus.getTerminationDate() != null && sellOutStatus.getPlanStockToZeroDate() != null) {
                BigDecimal invAge0To90Days = sellOutStatus.getInvAge0To90Days();
                BigDecimal invAge91To180Days = sellOutStatus.getInvAge91To180Days();
                BigDecimal invAge181To270Days = sellOutStatus.getInvAge181To270Days();
                BigDecimal invAge271To365Days = sellOutStatus.getInvAge271To365Days();
                BigDecimal invAge365PlusDays = sellOutStatus.getInvAge365PlusDays();

                int i = invAge0To90Days.compareTo(BigDecimal.ZERO); //(r==1) //左边大于右边
                int i1 = invAge91To180Days.compareTo(BigDecimal.ZERO);
                int i2 = invAge181To270Days.compareTo(BigDecimal.ZERO);
                int i3 = invAge271To365Days.compareTo(BigDecimal.ZERO);
                int i4 = invAge365PlusDays.compareTo(BigDecimal.ZERO);


                if ("TOOL-MSMC002-19-FBA".equals(sellOutStatus.getSku())){
                    System.out.println("i4 = " + i4);
                }

                //if 条件1
                Date terminationDate = sellOutStatus.getTerminationDate();
                Date planStockToZeroDate = sellOutStatus.getPlanStockToZeroDate();
                int terminationComparePlanStockToZero = terminationDate.compareTo(planStockToZeroDate);

                int i5 = sellOutStatus.getSellOutDate().compareTo(new BigDecimal(9999));

                boolean upto180 = i2 > 0 || i3 > 0 || i4 > 0;

                boolean onlyExist180DayAgedItemFlag = i <= 0 && i1 <= 0 && upto180;

                //else if 条件2
//                boolean onlyExist180DayAgedItemFlag = i < 0 && i1 < 0 && i2 > 0 && i3 > 0 && i4 > 0;
                if (i1 >0 && terminationComparePlanStockToZero < 0) {
                    sellOutStatus.setClearanceItem(true);       //需要清仓的 90to180
                }else if (i5>0){
                    sellOutStatus.setClearanceItem(true);
                }else if (onlyExist180DayAgedItemFlag) {

                    sellOutStatus.setStartDate(null);
                    sellOutStatus.setTerminationDate(null);
                    sellOutStatus.setNextClearingPoint(null);

                    sellOutStatus.setNextClearingPoint(null);
                    sellOutStatus.setTerminationDate(null);
                    sellOutStatus.setSellOutDate(null);
                    sellOutStatus.setSellOutStatus(null);

                    sellOutStatus.setClearanceItem(true);  //需要清仓的 180up

                } else {
                    sellOutStatus.setClearanceItem(false);  //不要清仓的
                }
            }
        }
        return pos;
    }

}
