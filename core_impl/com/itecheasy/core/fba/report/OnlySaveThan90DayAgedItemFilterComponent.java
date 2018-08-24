/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba.report;

import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportDao;
import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportHistoryDao;
import com.itecheasy.core.operation.AmazonAgedReportVO;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/7/2 14:05
 * @Description:
 */
public class OnlySaveThan90DayAgedItemFilterComponent implements CountAgedItemReportComponent {

    private AmazonInventoryAgedReportDao amazonInventoryAgedReportDao;

    private ThreadLocal<Integer> shopId;

    public void setCountAgedItemReportComponent(CountAgedItemReportComponent countAgedItemReportComponent) {
        this.countAgedItemReportComponent = countAgedItemReportComponent;
    }

    public void setShopId(ThreadLocal<Integer> shopId) {
        this.shopId = shopId;
    }

    public OnlySaveThan90DayAgedItemFilterComponent() {
    }

    public  List<AmazonInventoryAgedReportPO> isEntrust(List<AmazonInventoryAgedReportPO> items, CountAgedItemReportComponent component) throws ParseException {
        if (component!=null){
            component.cost(items);
        }
        return items;
    }

    //库龄历史表
    private AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao;
    private CountAgedItemReportComponent countAgedItemReportComponent;

    public OnlySaveThan90DayAgedItemFilterComponent(CountAgedItemReportComponent component, ThreadLocal<Integer> shopId) {
        this.shopId = shopId;
        this.countAgedItemReportComponent = component;
    }

    public OnlySaveThan90DayAgedItemFilterComponent(CountAgedItemReportComponent component) {
        this.countAgedItemReportComponent = component;
    }

    public void setAmazonInventoryAgedReportHistoryDao(AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao) {
        this.amazonInventoryAgedReportHistoryDao = amazonInventoryAgedReportHistoryDao;
    }

    public void setAmazonInventoryAgedReportDao(AmazonInventoryAgedReportDao amazonInventoryAgedReportDao) {
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
    }

    /**
     * 只存储大于90天有记录的插入到库龄结果表,起到过滤的效果
     * @param agedItemList
     * @return
     */
    @Override
    public List<AmazonInventoryAgedReportPO> cost(List<AmazonInventoryAgedReportPO> agedItemList) throws ParseException {
        //自己的逻辑   计算完成之后继续委托
        List<AmazonInventoryAgedReportPO> resultList = new ArrayList<AmazonInventoryAgedReportPO>();
        for (AmazonInventoryAgedReportPO agedItem : agedItemList) {
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

//            if (i1 < 0 && i2 < 0 && i3 < 0 && i4 < 0) {
//                resultList.add(agedItem);
//            }
            boolean b = i1 > 0 || i2 > 0 || i3 > 0 || i4 > 0;
            if (b) {
                resultList.add(agedItem);
            }
        }



        //返回的就是过滤掉之后的
        return isEntrust(resultList,this.countAgedItemReportComponent);
//        return this.countAgedItemReportComponent.cost(resultList);
    }


}
