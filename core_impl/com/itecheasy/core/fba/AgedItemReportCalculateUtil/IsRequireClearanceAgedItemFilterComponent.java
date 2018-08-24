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
public class IsRequireClearanceAgedItemFilterComponent extends CountAgedItemReportComponent {

    private AmazonInventoryAgedReportDao amazonInventoryAgedReportDao;

    //库龄历史表


    //库龄历史表
    private AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao;

    private  CountAgedItemReportComponent countAgedItemReportComponent;


    private  ThreadLocal<Integer> shopIdThreadLocal;

    public IsRequireClearanceAgedItemFilterComponent(CountAgedItemReportComponent component, ThreadLocal<Integer> shopIdThreadLocal,
                                                 AmazonInventoryAgedReportDao amazonInventoryAgedReportDao,
                                                 AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao) {
        this.shopIdThreadLocal = shopIdThreadLocal;
        this.countAgedItemReportComponent = component;
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
        this.amazonInventoryAgedReportHistoryDao = amazonInventoryAgedReportHistoryDao;
    }

    public IsRequireClearanceAgedItemFilterComponent( ThreadLocal<Integer> shopIdThreadLocal,
                                                     AmazonInventoryAgedReportDao amazonInventoryAgedReportDao,
                                                     AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao) {
        this.shopIdThreadLocal = shopIdThreadLocal;
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
        this.amazonInventoryAgedReportHistoryDao = amazonInventoryAgedReportHistoryDao;
    }

    public IsRequireClearanceAgedItemFilterComponent() {
    }


    public void setAmazonInventoryAgedReportDao(AmazonInventoryAgedReportDao amazonInventoryAgedReportDao) {
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
    }

    public IsRequireClearanceAgedItemFilterComponent(CountAgedItemReportComponent component) {
        this.countAgedItemReportComponent = component;
    }

    public IsRequireClearanceAgedItemFilterComponent(CountAgedItemReportComponent component,String shopId,AmazonInventoryAgedReportDao amazonInventoryAgedReportDao) {
        this.countAgedItemReportComponent = component;
        this.amazonInventoryAgedReportDao =  amazonInventoryAgedReportDao;
    }

    /**
     * 判断是否需要清仓   不同的条件不同的方法
     *  step5
     * @param items
     * @return
     */
    @Override
    public List<AmazonInventoryAgedReportPO> cost(List<AmazonInventoryAgedReportPO> items) {
        //自己的逻辑   计算完成之后继续委托

        List<AmazonInventoryAgedReportPO> requireClearance180up = new ArrayList<AmazonInventoryAgedReportPO>();
        List<AmazonInventoryAgedReportPO> requireClearance90to180 = new ArrayList<AmazonInventoryAgedReportPO>();
        List<AmazonInventoryAgedReportPO> notRequireClearance = new ArrayList<AmazonInventoryAgedReportPO>();

        for (AmazonInventoryAgedReportPO agedItem : items) {
            BigDecimal invAge0To90Days = agedItem.getInvAge0To90Days();
            BigDecimal invAge91To180Days = agedItem.getInvAge91To180Days();
            BigDecimal invAge181To270Days = agedItem.getInvAge181To270Days();
            BigDecimal invAge271To365Days = agedItem.getInvAge271To365Days();
            BigDecimal invAge365PlusDays = agedItem.getInvAge365PlusDays();

            int i = invAge0To90Days.compareTo(BigDecimal.ZERO); //(r==1) //左边大于右边
            int i1 = invAge91To180Days.compareTo(BigDecimal.ZERO);
            int i2 = invAge181To270Days.compareTo(BigDecimal.ZERO);
            int i3 = invAge271To365Days.compareTo(BigDecimal.ZERO);
            int i4 = invAge365PlusDays.compareTo(BigDecimal.ZERO);

            //if 0
            Date terminationDate = agedItem.getTerminationDate();
            Date planStockToZeroDate = agedItem.getPlanStockToZeroDate();
            int terminationComparePlanStockToZero = terminationDate.compareTo(planStockToZeroDate);

            //else if 1
            boolean onlyExist180DayAgedItemFlag = i < 0 && i1 < 0 && i2 > 0 && i3 > 0 && i4 > 0;

            if (i1 > 0 && terminationComparePlanStockToZero<0) {
                requireClearance90to180.add(agedItem);  //需要清仓的 90to180
            }else if (onlyExist180DayAgedItemFlag){
                requireClearance180up.add(agedItem);     //需要清仓的 180up
            }else{
                notRequireClearance.add(agedItem);  //不要清仓的
            }
        }

        //calculate upto 180 item and save
        List<AmazonInventoryAgedReportPO> upto180 = calculateUpto180IsRequireClearanceAgedItemContent(requireClearance180up);
        amazonInventoryAgedReportDao.addObject(upto180);

        //calculate between 90 to 180 item and save
        List<AmazonInventoryAgedReportPO> _90to180 = calculate90to180IsRequireClearanceAgedItemContent(requireClearance90to180);
        amazonInventoryAgedReportDao.addObject(_90to180);
//        返回的是
//        return this.countAgedItemReportComponent.cost(notRequireClearance);

        List<AmazonInventoryAgedReportPO> amazonInventoryAgedReportPOS = calculateNotRequireClearanceAgedItemContent(notRequireClearance);
        //不需要清仓的
        amazonInventoryAgedReportDao.updateBySku(amazonInventoryAgedReportPOS,shopIdThreadLocal.get());
        return  amazonInventoryAgedReportPOS;
    }







    private List<AmazonInventoryAgedReportPO> calculateNotRequireClearanceAgedItemContent(List<AmazonInventoryAgedReportPO> pos) {
        Date date = new Date();
        for (AmazonInventoryAgedReportPO directnessToDataBaseItem : pos) {
//            directnessToDataBaseItem.setStartDate(date);    //设置起始时间
//            directnessToDataBaseItem.setSyncLast(date); //设置更新时
            directnessToDataBaseItem.setClearanceItem(false);
        }
//        List<AmazonInventoryAgedReportPO> calculateNextClearPoint =
//                CalculateContentUtils.calculateNextClearPoint(pos);
//
//        List<AmazonInventoryAgedReportPO> calculateTerminationDate =
//                CalculateContentUtils.calculateTerminationDate(calculateNextClearPoint);
//
//        List<AmazonInventoryAgedReportPO> calculatePlanStockToZeroDate =
//                CalculateContentUtils.calculatePlanStockToZeroDate(calculateTerminationDate);
//
//        List<AmazonInventoryAgedReportPO> calculateSellOutDate =
//                CalculateContentUtils.calculateSellOutDate(calculatePlanStockToZeroDate);
//
//        List<AmazonInventoryAgedReportPO> calculateSellOutStatus
//                = CalculateContentUtils.calculateSellOutStatus(calculateSellOutDate);

        return pos;
    }


        /**
         * 有两种情况：需要清仓
         * 一：同时满足下面两个条件的商品，需清仓
         * 1. 存在库龄 90-->180 之间的商品
         * 2. 终止日期 小于 预计库存清0日期
         */
    private List<AmazonInventoryAgedReportPO> calculate90to180IsRequireClearanceAgedItemContent(List<AmazonInventoryAgedReportPO> pos) {
        Date date = new Date();
        for (AmazonInventoryAgedReportPO directnessToDataBaseItem : pos) {
//            directnessToDataBaseItem.setStartDate(date);    //设置起始时间
//            directnessToDataBaseItem.setSyncLast(date); //设置更新时

            directnessToDataBaseItem.setClearanceItem(true);
        }
//        List<AmazonInventoryAgedReportPO> calculateNextClearPoint =
//                CalculateContentUtils.calculateNextClearPoint(pos);
//
//        List<AmazonInventoryAgedReportPO> calculateTerminationDate =
//                CalculateContentUtils.calculateTerminationDate(calculateNextClearPoint);
//
//        List<AmazonInventoryAgedReportPO> calculatePlanStockToZeroDate =
//                CalculateContentUtils.calculatePlanStockToZeroDate(calculateTerminationDate);

//        List<AmazonInventoryAgedReportPO> calculateSellOutDate =
//                CalculateContentUtils.calculateSellOutDate(calculatePlanStockToZeroDate);

//        List<AmazonInventoryAgedReportPO> calculateSellOutStatus
//                = CalculateContentUtils.calculateSellOutStatus(calculateSellOutDate);

//        return calculateSellOutStatus;
        return null;
    }

        /**
         * upto180  计算需要清仓的
         *
         * 二：仅存在库龄大于180天
         * 1 .给SKU打上清仓标签。
         *  这个操作只有大于180天的才做
         * 1.	起始日期，终止日期，下一清算点空着。
         * （为了知道新加入大于90天库龄的商品，起始日期是多少。才这么考虑）
         * 2.	预计库存清0日期 正常计算。参照下讲解
         *  （日期比较远，一看就卖不完）
         * @param pos
         * @return
         */
    private List<AmazonInventoryAgedReportPO> calculateUpto180IsRequireClearanceAgedItemContent(List<AmazonInventoryAgedReportPO> pos) {
        Date date = new Date();
        for (AmazonInventoryAgedReportPO directnessToDataBaseItem : pos) {
//            directnessToDataBaseItem.setStartDate(date);    //设置起始时间
            directnessToDataBaseItem.setSyncLast(date); //设置更新时间

            directnessToDataBaseItem.setStartDate(null);
            directnessToDataBaseItem.setTerminationDate(null);
            directnessToDataBaseItem.setNextClearingPoint(null);

            directnessToDataBaseItem.setClearanceItem(true);
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