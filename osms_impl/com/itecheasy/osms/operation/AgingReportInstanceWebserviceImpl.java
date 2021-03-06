/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.osms.operation;

import com.itecheasy.common.PageList;
import com.itecheasy.core.operation.AmazonAgedReportForm;
import com.itecheasy.core.operation.AmazonAgedReportVO;
import com.itecheasy.core.operation.ShowAmazonAgedReportService;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.SystemService;

import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/10 17:33
 * @Description:
 */
public class AgingReportInstanceWebserviceImpl implements AgingReportInstanceWebservice {


    private SystemService systemService;

    private ShowAmazonAgedReportService showAmazonAgedReportService;

    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }


    public void setShowAmazonAgedReportService(ShowAmazonAgedReportService showAmazonAgedReportService) {
        this.showAmazonAgedReportService = showAmazonAgedReportService;
    }

    @Override
    public List<Shop> getSyncAgedShop() {
       return showAmazonAgedReportService.getSyncAgedShop();
    }

    @Override
    public PageList<AmazonAgedReportVO> showAmazonAgedReport(AmazonAgedReportForm amazonAgedReportForm) {
        //表单验证 ...
        return showAmazonAgedReportService.getAmazonAgedReport(amazonAgedReportForm);

    }

    @Override
    public void addToClearTracking(List<String> skus, int shopId,int operatorId) {
         showAmazonAgedReportService.addToClearTracking(skus, shopId, operatorId);
    }
}
