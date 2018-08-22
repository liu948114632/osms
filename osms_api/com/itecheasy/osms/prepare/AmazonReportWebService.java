/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.osms.prepare;

import com.itecheasy.common.PageList;
import com.itecheasy.core.order.AmazonStockReport;
import com.itecheasy.core.order.AmazonStockReportSearchForm;

import javax.jws.WebParam;
import javax.jws.WebService;


/**
 * @Auther: liteng
 * @Date: 2018/7/4 08:55
 * @Description:
 */
@WebService
public interface AmazonReportWebService {


    /**
     * 分页查询
     * public PageList<FbaInboundPlanVO> getFbaInboundPlanList(int shopId, int page, int pageSize, String sku,String productCode,int operatorId) {
     *
     */
    PageList<AmazonStockReport> showAmazonStocks(@WebParam(name = "amazonStockReportSearchForm") AmazonStockReportSearchForm amazonStockReportSearchForm);

}
