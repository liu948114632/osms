/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.operation;

import com.itecheasy.common.PageList;
import com.itecheasy.osms.operation.AgingReportInstanceWebservice;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @Auther: liteng
 * @Date: 2018/8/14 11:44
 * @Description:
 */

public class ShowAmazonAgedReportImplTest {

    @Test
    public void getAmazonAgedReport() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ShowAmazonAgedReport showAmazonAgedReport = (ShowAmazonAgedReport) context.getBean("showAmazonAgedReport");

        AmazonAgedReportForm form = new AmazonAgedReportForm();
        form.setShopId(1);
        form.setCurrentPage(1);
        form.setPageSize(10);
        form.setIsClearanceItem(1);
        form.setAgingQueryCondition(-1);

        form.setOriginationStartDate(DateUtils.addDays(new Date(),-1));
//        form.setOriginationEndDate(new Date());
//        form.setUpdateEndDate();
//        form.set

        PageList<AmazonAgedReportVO> amazonAgedReport = showAmazonAgedReport.getAmazonAgedReport(form);


    }

    private com.itecheasy.osms.operation.AgingReportInstanceWebservice agingReportInstanceWebservice;

    public void setAgingReportInstanceWebservice(com.itecheasy.osms.operation.AgingReportInstanceWebservice agingReportInstanceWebservice) {
        agingReportInstanceWebservice = agingReportInstanceWebservice;
    }

    @Test
    public void showAmazonAgedReportTest3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AgingReportInstanceWebservice agingReportInstanceWebservice = (AgingReportInstanceWebservice) context.getBean("agingReportInstanceWebService");
        AmazonAgedReportForm form = new AmazonAgedReportForm();
        form.setShopId(-1);
        form.setCurrentPage(1);
        form.setPageSize(10);
        form.setIsClearanceItem(1);
        form.setAgingQueryCondition(-1);
        form.setOperatorId(1);

        form.setOriginationStartDate(DateUtils.addDays(new Date(),-1));
        PageList<AmazonAgedReportVO> amazonAgedReport = agingReportInstanceWebservice.showAmazonAgedReport(form);

    }




    @Test
    public void showAmazonAgedReportTestWebservice(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ShowAmazonAgedReport showAmazonAgedReport = (ShowAmazonAgedReport) context.getBean("showAmazonAgedReport");
        AmazonAgedReportForm form = new AmazonAgedReportForm();
        form.setShopId(-1);
        form.setCurrentPage(1);
        form.setPageSize(10);
        form.setIsClearanceItem(1);
        form.setAgingQueryCondition(-1);
        form.setOperatorId(1);
        form.setOriginationStartDate(DateUtils.addDays(new Date(),-1));

        PageList<AmazonAgedReportVO> amazonAgedReport = showAmazonAgedReport.getAmazonAgedReport(form);

//        PageList<AmazonAgedReportVO> amazonAgedReport = agingReportInstanceWebservice.showAmazonAgedReport(form);
//        System.out.println(amazonAgedReport);
    }
}