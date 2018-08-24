package com.itecheasy.core.fba.AgedItemReportCalculateUtil;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.HqlUtils;
import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportDao;
import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportHistoryDao;
import com.itecheasy.core.po.AmazonInventoryAgedReportHistoryPO;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;

import java.util.*;

/**
 *
 */
public class IsExistAgedTableFilterComponent extends CountAgedItemReportComponent {

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
        this.shopId = shopIdThreadLocal;
        this.countAgedItemReportComponent = component;
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
        this.amazonInventoryAgedReportHistoryDao = amazonInventoryAgedReportHistoryDao;
    }

    public IsExistAgedTableFilterComponent(CountAgedItemReportComponent component) {
        this.countAgedItemReportComponent = component;
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
    public List<AmazonInventoryAgedReportPO> cost(List<AmazonInventoryAgedReportPO> newAgedItemList) {
        //查询库龄报告表   result_table
        List<AmazonInventoryAgedReportPO> dataBaseResultAgedItems = this.amazonInventoryAgedReportDao.
                findListByHql("FROM AmazonInventoryAgedReportPO where shopId = ? ",
                        new Object[]{shopId.get()});

        List<AmazonInventoryAgedReportPO> existItems = new ArrayList<AmazonInventoryAgedReportPO>();
        List<AmazonInventoryAgedReportPO> directnessToDataBaseItems = new ArrayList<AmazonInventoryAgedReportPO>();


        if (CollectionUtils.isNotEmpty(dataBaseResultAgedItems)) {
            for (Iterator<AmazonInventoryAgedReportPO> it = newAgedItemList.iterator(); it.hasNext(); ) {
                AmazonInventoryAgedReportPO ageItem = it.next();
                for (AmazonInventoryAgedReportPO resultTablePO : dataBaseResultAgedItems) {
                    if (ageItem.getSku().equals(resultTablePO.getSku())) {
                        //存在返回
                        existItems.add(ageItem);
                    } else {
                        //save以前不存在的记录
                        //不存在 情况
                        directnessToDataBaseItems.add(ageItem);
                    }
                }
            }
        } else {
            directnessToDataBaseItems.addAll(newAgedItemList);
        }

        //条件拼接  hql
        List<String> skus = new ArrayList<String>();
        for (AmazonInventoryAgedReportPO directnessToDataBaseItem : directnessToDataBaseItems) {
            skus.add(directnessToDataBaseItem.getSku());
        }

        //查询并且按照sku当做key来分
        String from_amazonInventoryAgedReportHistoryPO = null;
        if (CollectionUtils.isNotEmpty(skus)) {
            from_amazonInventoryAgedReportHistoryPO = HqlUtils.jointCriteriaString("from AmazonInventoryAgedReportHistoryPO where sku ", skus);
        } else {
            from_amazonInventoryAgedReportHistoryPO = "from AmazonInventoryAgedReportHistoryPO";
        }
        List<AmazonInventoryAgedReportHistoryPO> historyPOListByNewSku = amazonInventoryAgedReportHistoryDao.findListByHql(from_amazonInventoryAgedReportHistoryPO);

        if (CollectionUtils.isNotEmpty(historyPOListByNewSku)) {
            Map<String, AmazonInventoryAgedReportHistoryPO> historyPOMap = new HashMap<String, AmazonInventoryAgedReportHistoryPO>();
            for (AmazonInventoryAgedReportHistoryPO amazonInventoryAgedReportHistoryPO : historyPOListByNewSku) {
                historyPOMap.put(amazonInventoryAgedReportHistoryPO.getSku(), amazonInventoryAgedReportHistoryPO);
            }

            //set 属性        directnessToDataBaseItems新传来的
            Date date = new Date();
            for (AmazonInventoryAgedReportPO directnessToDataBaseItem : directnessToDataBaseItems) {
                //历史表中的
                AmazonInventoryAgedReportHistoryPO amazonInventoryAgedReportHistoryPO = historyPOMap.get(directnessToDataBaseItem.getSku());
                //不存在报告中
                directnessToDataBaseItem.setStartDate(date);    //设置起始时间
                //首次同步时间和最后同步时间为一个
                directnessToDataBaseItem.setSyncFirst(date);    //设置首次同步时间
                directnessToDataBaseItem.setSyncLast(date); //设置更新时间

                // TODO: 2018/8/13 other ignore set 属性
                //set other 属性
                if (amazonInventoryAgedReportHistoryPO != null) {
                    BeanUtils.copyProperties(amazonInventoryAgedReportHistoryPO, directnessToDataBaseItem,
                            new String[]{"id", "startDate", "syncFirst", "syncLast"});
                }
            }
        }


        //各种计算之后的结果
        List<AmazonInventoryAgedReportPO> calculateContentAfter = calculateContent(directnessToDataBaseItems);

        //直接新增之后删除id小一些的
        this.amazonInventoryAgedReportDao.updateBySku(calculateContentAfter, shopId.get());
        //直接新增就好了，因为不可能存在于数据库中


        //返回的就是不在库龄报表中的
        if (this.countAgedItemReportComponent != null) {
            return this.countAgedItemReportComponent.cost(existItems);
        } else {
            return existItems;
        }
    }


    /**
     * @param pos
     * @return
     */
    private List<AmazonInventoryAgedReportPO> calculateContent(List<AmazonInventoryAgedReportPO> pos) {

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
