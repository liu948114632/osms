/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.osms.operation;

import com.itecheasy.osms.prepare.LineOfBusinessWebService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: liteng
 * @Date: 2018/8/28 09:04
 * @Description:
 */
public class AgingReportInstanceWebserviceTest {

    private AgingReportInstanceWebservice agingReportInstanceWebservice;

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        agingReportInstanceWebservice = (AgingReportInstanceWebservice) context.getBean("agingReportInstanceWebService");

    }

    @Test
    public void addToClearTracking() {

        List<String> skus = new ArrayList<String>();
        skus.add("JEWB-PH0001-02-FBA");

        agingReportInstanceWebservice.addToClearTracking(skus,1,1);
    }
}