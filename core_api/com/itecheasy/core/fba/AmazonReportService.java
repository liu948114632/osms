package com.itecheasy.core.fba;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BaseSearchForm;

import com.itecheasy.core.order.AmazonStockReport;
import com.itecheasy.core.order.AmazonStockReportSearchForm;
import com.itecheasy.core.system.Shop;

import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/7/2 14:03
 * @Description:
 */
public interface AmazonReportService {

    //手动查询

    /**
     * @return
     */

    AmazonStockReport getAmazonStockBySku(AmazonStockReportSearchForm form);

// TODO: 2018/7/2
    /**
     * 4	更新OSMS的FBA补货订单状态
     * 分页查询
     * public PageList<FbaInboundPlanVO> getFbaInboundPlanList(int shopId, int page, int pageSize, String sku,String productCode,int operatorId) {
     *
     */
    PageList<AmazonStockReport> getAmazonStocks(AmazonStockReportSearchForm from);


    /**
     * auto task
     */
    void getAmazonStockReportFromAmazon(List<Shop> shopList);



}
