package com.itecheasy.osms.order;

import com.itecheasy.common.PageList;
import com.itecheasy.core.fba.AmazonReportService;
import com.itecheasy.core.order.AmazonStockReportSearchForm;
import com.itecheasy.core.order.AmazonStockReport;

/**
 * @Auther: liteng
 * @Date: 2018/7/4 08:56
 * @Description:
 */
public class AmazonReportWebServiceImpl implements AmazonReportWebService{

    private AmazonReportService amazonReportService;

    public void setAmazonReportService(AmazonReportService amazonReportService) {
        this.amazonReportService = amazonReportService;
    }

    @Override
    public PageList<AmazonStockReport> showAmazonStocks(AmazonStockReportSearchForm form) {
        return amazonReportService.getAmazonStocks(form);

    }
}
