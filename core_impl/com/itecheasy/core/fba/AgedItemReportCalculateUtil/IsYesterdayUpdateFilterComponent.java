package com.itecheasy.core.fba.AgedItemReportCalculateUtil;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.HqlUtils;
import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportDao;
import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportHistoryDao;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;

import java.util.*;

public class IsYesterdayUpdateFilterComponent extends CountAgedItemReportComponent {

    private CountAgedItemReportComponent countAgedItemReportComponent;

    private AmazonInventoryAgedReportDao amazonInventoryAgedReportDao;
    //历史表的Dao
    private AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao;

    private  ThreadLocal<Integer> shopIdThreadLocal;

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
     * 更新日期不是昨天的直接修改,是昨天的则返回
     *
     * @param items 传过来的一定是一个shop的商品
     * @return
     */
    @Override
    public List<AmazonInventoryAgedReportPO> cost(List<AmazonInventoryAgedReportPO> items) {
        //假如一定在库龄result表里面
        List<String> skus = new ArrayList<String>();
        for (AmazonInventoryAgedReportPO item : items) {
            skus.add(item.getSku());
        }

        String whereIn ="";
        if (CollectionUtils.isNotEmpty(skus)){
         whereIn = HqlUtils.jointCriteriaString
                ("from AmazonInventoryAgedReportPO where shopId = ? and sku ", skus);
        }else{
            whereIn = " from AmazonInventoryAgedReportPO where shopId = ? ";
        }
            List<AmazonInventoryAgedReportPO> resultPos = amazonInventoryAgedReportDao.
                    findListByHql(whereIn, new Object[]{this.shopIdThreadLocal.get()});



        //更新日期是昨天的集合
        List<AmazonInventoryAgedReportPO> updateTimeYesterday = new ArrayList<AmazonInventoryAgedReportPO>();
        //更新日期不是昨天的集合
        List<AmazonInventoryAgedReportPO> notUpdateTimeYesterday = new ArrayList<AmazonInventoryAgedReportPO>();

        //查看更新日期是不是昨天
        for (AmazonInventoryAgedReportPO resultPo : resultPos) {
            //这里暂时这样
            Date toDayRealDate = DateUtils.getRealDate(new Date());
            Date DatebaseRealDate = DateUtils.getRealDate(resultPo.getSyncLast());
            Integer is = toDayRealDate.compareTo(DatebaseRealDate);
            if (DateUtils.timeDiffer(toDayRealDate,DatebaseRealDate,1)) {  //修改记录
                //这些值不变 起始日期,终止日期,下一清算点
                //other column data update and recalculate
                updateTimeYesterday.add(resultPo);  //历史表中的更新日期是昨天的
            } else {
                notUpdateTimeYesterday.add(resultPo);   //历史表中的更新日期不是昨天的
            }
        }

        //从history中拿到信息，之后把新传来的那些数据重新计算
        //把旧商品的首次同步时间设置到从亚马逊同步过来的商品上
        //oldItem是指数据库中的
        //newItem是同步过来的
        //根据shopIdid和sku来进行判断，如果没有这个商品的报告记录，就设置首次同步时间，
        // 从中间服务同步回来时，首次和最后同步时间都有
        for (AmazonInventoryAgedReportPO newItem : items) {
            for (AmazonInventoryAgedReportPO oldItem : notUpdateTimeYesterday) {
                if (newItem.getSku().equals(oldItem.getSku())){
                    newItem.setSyncFirst(oldItem.getSyncFirst());
                }
            }
        }

        //分类今天的传来的根据是不是昨天更新的
        List<String> notUpdateTimeYesterdaySkus = new ArrayList<String>();
        for (AmazonInventoryAgedReportPO po : notUpdateTimeYesterday) {
            notUpdateTimeYesterdaySkus.add(po.getSku());
        }
        Map<String,AmazonInventoryAgedReportPO> newSkusMap=
                new HashMap<String, AmazonInventoryAgedReportPO>();
        for (AmazonInventoryAgedReportPO item : items) {
            newSkusMap.put(item.getSku(),item);
        }
        List<AmazonInventoryAgedReportPO> notSyncItemUpdateYesterday = new ArrayList<AmazonInventoryAgedReportPO>();
        List<AmazonInventoryAgedReportPO> syncItemUpdateYesterday = new ArrayList<AmazonInventoryAgedReportPO>();
        for (Map.Entry<String, AmazonInventoryAgedReportPO> stringAmazonInventoryAgedReportPOEntry : newSkusMap.entrySet()) {
            if (notUpdateTimeYesterdaySkus.contains(stringAmazonInventoryAgedReportPOEntry.getKey())){
                notSyncItemUpdateYesterday.add(stringAmazonInventoryAgedReportPOEntry.getValue());  //新传来的商品集合，不是昨天更新的
            }else {
                //新商品中是昨天更新的
                syncItemUpdateYesterday.add(stringAmazonInventoryAgedReportPOEntry.getValue());
            }
        }

        //更新日期不为昨天的
        List<AmazonInventoryAgedReportPO> updateTimeYesterdayHasCalculate = calculateNotYesterdayUpdateContent(notSyncItemUpdateYesterday);

//        amazonInventoryAgedReportDao.addObject(updateTimeYesterdayHasCalculate);
//        amazonInventoryAgedReportDao.flush();
        amazonInventoryAgedReportDao.updateBySku(updateTimeYesterdayHasCalculate,shopIdThreadLocal.get());


        //余下的就是更新日期为昨天的
        return this.countAgedItemReportComponent.cost(syncItemUpdateYesterday);
    }

    /**
     * 更新日期不是昨天的
     * @param pos
     * @return
     */
    private List<AmazonInventoryAgedReportPO> calculateNotYesterdayUpdateContent(List<AmazonInventoryAgedReportPO> pos) {
        Date date = new Date();
        for (AmazonInventoryAgedReportPO directnessToDataBaseItem : pos) {
            directnessToDataBaseItem.setStartDate(date);    //设置起始时间
            directnessToDataBaseItem.setSyncLast(date); //设置更新时间
        }
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

        return calculateSellOutStatus;
    }


}