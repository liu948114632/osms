package com.itecheasy.core.fba.AgedItemReportCalculateUtil;

import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportDao;
import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportHistoryDao;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public  class OnlyThan180DayAgedItemFilterComponent extends CountAgedItemReportComponent {

    private AmazonInventoryAgedReportDao amazonInventoryAgedReportDao;

    //库龄历史表
    private AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao;

    private  CountAgedItemReportComponent countAgedItemReportComponent;


    private  ThreadLocal<Integer> shopIdThreadLocal;

    public OnlyThan180DayAgedItemFilterComponent(CountAgedItemReportComponent component, ThreadLocal<Integer> shopIdThreadLocal,
                                            AmazonInventoryAgedReportDao amazonInventoryAgedReportDao,
                                            AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao) {
        this.shopIdThreadLocal = shopIdThreadLocal;
        this.countAgedItemReportComponent = component;
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
        this.amazonInventoryAgedReportHistoryDao = amazonInventoryAgedReportHistoryDao;
    }

    public OnlyThan180DayAgedItemFilterComponent() {
    }

    public void setAmazonInventoryAgedReportDao(AmazonInventoryAgedReportDao amazonInventoryAgedReportDao,CountAgedItemReportComponent component

                                                            ) {
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
    }

    public void setAmazonInventoryAgedReportDao(AmazonInventoryAgedReportDao amazonInventoryAgedReportDao) {
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
    }

    public OnlyThan180DayAgedItemFilterComponent(CountAgedItemReportComponent component) {
        this.countAgedItemReportComponent = component;
    }



    public OnlyThan180DayAgedItemFilterComponent(CountAgedItemReportComponent component,ThreadLocal<Integer> longLocal) {
        this.shopIdThreadLocal = longLocal;
        this.countAgedItemReportComponent = component;

    }

    /**
     *  step4
     *  如果该商品的库龄仅仅大于180
     *  如果不是的话 就把起始时间改为服务器当前时间
     * @param
     * @return
     */
    @Override
    public List<AmazonInventoryAgedReportPO> cost(List<AmazonInventoryAgedReportPO> syncItemUpdateYesterday) {
        //更新日期是昨天的  单独抽为component
        //需要覆盖操作
        List<AmazonInventoryAgedReportPO> calculateYesterdayUpdateContent = calculateYesterdayUpdateContent(syncItemUpdateYesterday);

        //刷新记录
        amazonInventoryAgedReportDao.updateBySku(calculateYesterdayUpdateContent,shopIdThreadLocal.get());


        //仅库龄大于180天的商品这个条件的商品
        List<AmazonInventoryAgedReportPO> satisfiedConditionItems = new ArrayList<AmazonInventoryAgedReportPO>();
        //非仅库龄大于180天的商品这个条件的商品
        List<AmazonInventoryAgedReportPO> notSatisfiedConditionItems = new ArrayList<AmazonInventoryAgedReportPO>();
        for (AmazonInventoryAgedReportPO agedItem : calculateYesterdayUpdateContent) {
            BigDecimal invAge0To90Days = agedItem.getInvAge0To90Days();
            BigDecimal invAge91To180Days = agedItem.getInvAge91To180Days();
            BigDecimal invAge181To270Days = agedItem.getInvAge181To270Days();
            BigDecimal invAge271To365Days = agedItem.getInvAge271To365Days();
            BigDecimal invAge365PlusDays = agedItem.getInvAge365PlusDays();

            int i = invAge0To90Days.compareTo(BigDecimal.ZERO); //(r==1) 左边大于右边
            int i1 = invAge91To180Days.compareTo(BigDecimal.ZERO);
            int i2 = invAge181To270Days.compareTo(BigDecimal.ZERO);
            int i3 = invAge271To365Days.compareTo(BigDecimal.ZERO);
            int i4 = invAge365PlusDays.compareTo(BigDecimal.ZERO);

            if (i <= 0 && i1 <= 0 && i2 > 0 && i3 > 0 && i4 > 0) {
                satisfiedConditionItems.add(agedItem);
                //仅库龄大于180天的商品
            }else{
                //其他状态库龄的商品
                notSatisfiedConditionItems.add(agedItem);
            }
        }


        //encapsulation
        List<AmazonInventoryAgedReportPO> calculateOnlyThan180DayAgedItemContent
                = calculateOnlyThan180DayAgedItemContent(satisfiedConditionItems);

        amazonInventoryAgedReportDao.updateBySku(calculateOnlyThan180DayAgedItemContent,shopIdThreadLocal.get());

        //set id to zero
        List<AmazonInventoryAgedReportPO> calculateNotOnlyThan180DayAgedItemContent =
                calculateNotOnlyThan180DayAgedItemContent(notSatisfiedConditionItems);

//        返回的就是余下的
        return this.countAgedItemReportComponent.cost(calculateNotOnlyThan180DayAgedItemContent);
    }

    /**
     *  仅库龄大于180天的有amount的商品
     * @param pos
     * @return
     */
    private List<AmazonInventoryAgedReportPO> calculateOnlyThan180DayAgedItemContent(List<AmazonInventoryAgedReportPO> pos) {

        for (AmazonInventoryAgedReportPO po : pos) {
            po.setStartDate(null);
            po.setTerminationDate(null);
            po.setNextClearingPoint(null);

            po.setClearanceItem(true);
        }

//        List<AmazonInventoryAgedReportPO> calculateNextClearPoint =
//                CalculateContentUtils.calculateNextClearPoint(pos);

//        List<AmazonInventoryAgedReportPO> calculateTerminationDate =
//                CalculateContentUtils.calculateTerminationDate(calculateNextClearPoint);

        List<AmazonInventoryAgedReportPO> calculatePlanStockToZeroDate =
                CalculateContentUtils.calculatePlanStockToZeroDate(pos);

        List<AmazonInventoryAgedReportPO> calculateSellOutDate =
                CalculateContentUtils.calculateSellOutDate(calculatePlanStockToZeroDate);

        List<AmazonInventoryAgedReportPO> calculateSellOutStatus
                = CalculateContentUtils.calculateSellOutStatus(calculateSellOutDate);

        return calculateSellOutStatus;
    }

    /**
     * 单独抽为component
     *   非仅库龄大于180天的商品这个条件的商品
     * @param pos
     * @return
     */
    private List<AmazonInventoryAgedReportPO> calculateNotOnlyThan180DayAgedItemContent(List<AmazonInventoryAgedReportPO> pos) {
       //记录日期为服务器的起始日期
        Date date = new Date();
        for (AmazonInventoryAgedReportPO po : pos) {
            po.setStartDate(date);
        }

        return pos;
    }



        /**
         * 单独抽为component
         * 跟新日期是昨天的计算方式
         * @param pos
         * @return
         */
    private List<AmazonInventoryAgedReportPO> calculateYesterdayUpdateContent(List<AmazonInventoryAgedReportPO> pos) {
        Date date = new Date();
        for (AmazonInventoryAgedReportPO directnessToDataBaseItem : pos) {
//            directnessToDataBaseItem.setStartDate(date);    //设置起始时间
            directnessToDataBaseItem.setSyncLast(date); //设置更新时间
        }
//        List<AmazonInventoryAgedReportPO> calculateNextClearPoint =
//                CalculateContentUtils.calculateNextClearPoint(pos);

//        List<AmazonInventoryAgedReportPO> calculateTerminationDate =
//                CalculateContentUtils.calculateTerminationDate(calculateNextClearPoint);

        List<AmazonInventoryAgedReportPO> calculatePlanStockToZeroDate =
                CalculateContentUtils.calculatePlanStockToZeroDate(pos);

        List<AmazonInventoryAgedReportPO> calculateSellOutDate =
                CalculateContentUtils.calculateSellOutDate(calculatePlanStockToZeroDate);

        List<AmazonInventoryAgedReportPO> calculateSellOutStatus
                = CalculateContentUtils.calculateSellOutStatus(calculateSellOutDate);

        return calculateSellOutStatus;
    }


}
