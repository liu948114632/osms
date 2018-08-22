/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.osms.prepare;

import com.itecheasy.common.PageList;
import com.itecheasy.core.fba.AmazonReportService;
import com.itecheasy.core.order.AmazonStockReportSearchForm;
import com.itecheasy.core.order.AmazonStockReport;

/**
 * @Auther: liteng
 * @Date: 2018/7/4 08:56
 * @Description:
 */
public class AmazonReportWebServiceImpl implements AmazonReportWebService {

    private AmazonReportService amazonReportService;

    public void setAmazonReportService(AmazonReportService amazonReportService) {
        this.amazonReportService = amazonReportService;
    }




    @Override
    public PageList<AmazonStockReport> showAmazonStocks(AmazonStockReportSearchForm form) {
        return amazonReportService.getAmazonStocks(form);

    }
}
