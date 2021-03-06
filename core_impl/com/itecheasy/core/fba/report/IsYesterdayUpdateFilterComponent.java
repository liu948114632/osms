/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba.report;

import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.BussinessException;
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
public class IsYesterdayUpdateFilterComponent implements CountAgedItemReportComponent {

    private CountAgedItemReportComponent countAgedItemReportComponent;

    private AmazonInventoryAgedReportDao amazonInventoryAgedReportDao;
    //历史表的Dao
    private AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao;

    private  ThreadLocal<Integer> shopIdThreadLocal;

    public void setAmazonInventoryAgedReportHistoryDao(AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao) {
        this.amazonInventoryAgedReportHistoryDao = amazonInventoryAgedReportHistoryDao;
    }

    public void setCountAgedItemReportComponent(CountAgedItemReportComponent countAgedItemReportComponent) {
        this.countAgedItemReportComponent = countAgedItemReportComponent;
    }

    public void setShopIdThreadLocal(ThreadLocal<Integer> shopIdThreadLocal) {
        this.shopIdThreadLocal = shopIdThreadLocal;
    }

    public IsYesterdayUpdateFilterComponent(CountAgedItemReportComponent component, ThreadLocal<Integer> shopIdThreadLocal,
                                            AmazonInventoryAgedReportDao amazonInventoryAgedReportDao,
                                            AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao) {
        this.shopIdThreadLocal = shopIdThreadLocal;
        this.countAgedItemReportComponent = component;
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
        this.amazonInventoryAgedReportHistoryDao = amazonInventoryAgedReportHistoryDao;
    }

    public IsYesterdayUpdateFilterComponent() {

    }

    public IsYesterdayUpdateFilterComponent(CountAgedItemReportComponent component) {
        this.countAgedItemReportComponent = component;
    }

    public IsYesterdayUpdateFilterComponent(CountAgedItemReportComponent component, ThreadLocal<Integer> shopIdThreadLocal) {
        this.shopIdThreadLocal = shopIdThreadLocal;
        this.countAgedItemReportComponent = component;
    }

    public void setAmazonInventoryAgedReportDao(AmazonInventoryAgedReportDao amazonInventoryAgedReportDao) {
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
    }

    /**
     * a.after(b)返回一个boolean，如果a的时间在b之后（不包括等于）返回true
     * b.before(a)返回一个boolean，如果b的时间在a之前（不包括等于）返回true
     * a.equals(b)返回一个boolean,如果a的时间和b相等返回true
     */

    /**
     * 更新日期不是昨天的直接修改
     * 是昨天的则返回
     *
     * @param newItems 传过来的一定是一个shop的商品
     * @return
     */
    @Override
    public List<AmazonInventoryAgedReportPO> cost(List<AmazonInventoryAgedReportPO> newItems) throws ParseException {

        //假如一定在库龄result表里面
        List<AmazonInventoryAgedReportPO> DateResultPos = amazonInventoryAgedReportDao.findListByShopId(this.shopIdThreadLocal.get());



        //把旧商品的首次同步时间设置到从亚马逊同步过来的商品上
        //根据shopIdid和sku来进行判断，如果没有这个商品的报告记录，就设置首次同步时间，
        // 从中间服务同步回来时，首次和最后同步时间都有
        Date date = new Date();
        for (AmazonInventoryAgedReportPO newItem : newItems) {
            for (AmazonInventoryAgedReportPO DateNotUpdateTimeYesterdayItem : DateResultPos) {
                if (newItem.getSku().equals(DateNotUpdateTimeYesterdayItem.getSku()) && newItem.getShopId().equals(DateNotUpdateTimeYesterdayItem.getShopId())){
                    newItem.setSyncFirst(DateNotUpdateTimeYesterdayItem.getSyncFirst());

//                    newItem.setSyncLast(date);
//                    newItem.setId(DateNotUpdateTimeYesterdayItem.getId());
                }
            }
        }

        //数据库中更新日期是昨天的集合
        List<AmazonInventoryAgedReportPO> DateUpdateTimeYesterday = new ArrayList<AmazonInventoryAgedReportPO>();
        //数据库中更新日期不是昨天的集合
        List<AmazonInventoryAgedReportPO> DateNotUpdateTimeYesterdayList = new ArrayList<AmazonInventoryAgedReportPO>();

        //查看更新日期是不是昨天
        for (AmazonInventoryAgedReportPO DateResultPo : DateResultPos) {
            //这里暂时这样
            Date toDayRealDate = DateUtils.getRealDate(new Date());
            Date DatebaseRealDate = DateUtils.getRealDate(DateResultPo.getSyncLast());

            int yeaterday = CalculateContentUtils.isYeaterday(DateResultPo.getSyncLast(), new Date());  //0为昨天
            boolean b = DateUtils.timeDiffer(toDayRealDate, DatebaseRealDate, 0);   //两天之间的间隔是否为0天,为零天就说明是同一天
            int is = toDayRealDate.compareTo(DatebaseRealDate);         //今天是否比昨天大
            if (yeaterday!=0) {
                DateNotUpdateTimeYesterdayList.add(DateResultPo);   //历史表中的更新日期不是昨天的
            } else {

                //这些值不变 起始日期,终止日期,下一清算点
                //other column data update and recalculate
                DateUpdateTimeYesterday.add(DateResultPo);  //历史表中的更新日期是昨天的
            }
        }


        //这个店铺下历史表中的数据，而且日期是最新的
//        List<AmazonInventoryAgedReportHistoryPO> historyDateBaseByShopId = amazonInventoryAgedReportHistoryDao.
//                            findByShopAndSkuAndSyncLastData(this.shopIdThreadLocal.get());

        //把今天的数据分出来
        List<String> DateNotUpdateTimeYesterdaySkus = new ArrayList<String>();
        for (AmazonInventoryAgedReportPO po : DateNotUpdateTimeYesterdayList) {
            DateNotUpdateTimeYesterdaySkus.add(po.getSku());
        }
        //分类今天的传来的根据是不是昨天更新的
        Map<String,AmazonInventoryAgedReportPO> newSkusMap= new HashMap<String, AmazonInventoryAgedReportPO>();
        for (AmazonInventoryAgedReportPO newItem : newItems) {
            newSkusMap.put(newItem.getSku(),newItem);
        }
        List<AmazonInventoryAgedReportPO> notSyncItemUpdateYesterday = new ArrayList<AmazonInventoryAgedReportPO>();
        List<AmazonInventoryAgedReportPO> syncItemUpdateYesterday = new ArrayList<AmazonInventoryAgedReportPO>();
        for (Map.Entry<String, AmazonInventoryAgedReportPO> stringAmazonInventoryAgedReportPOEntry : newSkusMap.entrySet()) {
            if (DateNotUpdateTimeYesterdaySkus.contains(stringAmazonInventoryAgedReportPOEntry.getKey())){
                //新商品中不是昨天更新的集合
                notSyncItemUpdateYesterday.add(stringAmazonInventoryAgedReportPOEntry.getValue());  //新传来的商品集合，不是昨天更新的
            }else {
                //新商品中是昨天更新的集合
                syncItemUpdateYesterday.add(stringAmazonInventoryAgedReportPOEntry.getValue());
            }
        }

        //计算起始日期
        List<AmazonInventoryAgedReportPO> amazonInventoryAgedReportPOS = CalculateContentUtils.calculateStartDate(notSyncItemUpdateYesterday,DateResultPos);

        //更新日期不为昨天的
        List<AmazonInventoryAgedReportPO> updateTimeYesterdayHasCalculate = calculateNotYesterdayUpdateContent(amazonInventoryAgedReportPOS);


        //不是昨天的，计算没有问题
        amazonInventoryAgedReportDao.updateDataById(updateTimeYesterdayHasCalculate,DateResultPos);

        //更新日期为昨天的
        // 应该把数据库中的结果表的起始日期，终止日期，下一清算点拿过来
//        for (AmazonInventoryAgedReportPO syncYester : syncItemUpdateYesterday) {
//            for (AmazonInventoryAgedReportPO dateResultPo : DateResultPos) {
//                if (syncYester.getSku().equals(dateResultPo.getSku())){
//                    syncYester.setSnapshotDate(dateResultPo.getSnapshotDate());
//                    syncYester.setStartDate(dateResultPo.getStartDate());
//                    syncYester.setNextClearingPoint(dateResultPo.getNextClearingPoint());
//                    syncYester.setTerminationDate(dateResultPo.getTerminationDate());
//                }
//            }
//        }

//        amazonInventoryAgedReportDao.updateDataById(syncItemUpdateYesterday,DateResultPos);

        amazonInventoryAgedReportDao.updateDataById(syncItemUpdateYesterday,DateResultPos);
        //余下的就是新传来的商品   并且更新日期为昨天
        return isEntrust(syncItemUpdateYesterday,countAgedItemReportComponent);
//        return this.countAgedItemReportComponent.cost(syncItemUpdateYesterday);
    }


    public  List<AmazonInventoryAgedReportPO> isEntrust(List<AmazonInventoryAgedReportPO> items, CountAgedItemReportComponent component) throws ParseException {
        if (component!=null){
            component.cost(items);
        }
        return items;
    }

    /**
     * 更新日期不是昨天的 起始日期直接设置为今天   ..........起始日期有专门的工具来计算
     * @param pos
     * @return
     */
    private List<AmazonInventoryAgedReportPO> calculateNotYesterdayUpdateContent(List<AmazonInventoryAgedReportPO> pos) {
        Date date = new Date();
//        for (AmazonInventoryAgedReportPO directnessToDataBaseItem : pos) {
//            directnessToDataBaseItem.setStartDate(date);    //设置起始时间
//            directnessToDataBaseItem.setSyncLast(date); //设置更新时间
//        }


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

        List<AmazonInventoryAgedReportPO> calculateIsClearItem
                = CalculateContentUtils.calculateIsClearItem(calculateSellOutStatus);
        return calculateIsClearItem;
    }


}
