/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.osms.prepare;

import com.itecheasy.common.PageList;
import com.itecheasy.core.prepare.LineOfBusinessSearchForm;
import com.itecheasy.core.prepare.LineOfBusinessVO;
import com.itecheasy.core.system.Shop;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: liteng
 * @Date: 2018/8/25 16:35
 * @Description:
 */
public class LineOfBusinessWebServiceTest {

    private  LineOfBusinessWebService lineOfBusinessWebService;

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        lineOfBusinessWebService = (LineOfBusinessWebService) context.getBean("lineOfBusinessWebService");

    }


    @Test
    public void getLineOfBusinessById() {

        Integer lineId = 1;

        LineOfBusinessVO lineOfBusinessById = lineOfBusinessWebService.getLineOfBusinessById(lineId, 1);
    }

    @Test
    public void findLineOfBusinessPage() {

        LineOfBusinessSearchForm form = new LineOfBusinessSearchForm();
        List<Integer> shopIds = new ArrayList<Integer>();
        shopIds.add(0);
        shopIds.add(3);
        shopIds.add(5);
        form.setShopIds(shopIds);

        form.setOperatorId(1);

        form.setPageSize(3);
        form.setCurrentPage(1);

        PageList<LineOfBusinessVO> lineOfBusinessPage = lineOfBusinessWebService.findLineOfBusinessPage(form);

    }

    @Test
    public void addLineOfBusiness() {
        LineOfBusinessVO vo = new LineOfBusinessVO();
        vo.setCreateTime(new Date());

        List<Integer> shopIds = new ArrayList<Integer>();
        shopIds.add(0);
        shopIds.add(3);
        shopIds.add(5);
       vo.setBusinessBindShopIdList(shopIds);
        vo.setLineOfBusinessExplain("chino cocoa");
        vo.setLineOfBusinessName("japan 003");
        vo.setNormalProductStockCycle(new BigDecimal(10));

        lineOfBusinessWebService.addLineOfBusiness(vo,1);
    }

    @Test
    public void updateLineOfBusiness() {

        List<LineOfBusinessVO> vos = new ArrayList<LineOfBusinessVO>();

        LineOfBusinessVO vo = new LineOfBusinessVO();
        vo.setCreateTime(new Date());
        vo.setLastUpdateTime(new Date());

        List<Integer> shopIds = new ArrayList<Integer>();
        shopIds.add(13);
        shopIds.add(12);
        shopIds.add(41);
        shopIds.add(69);
        vo.setBusinessBindShopIdList(shopIds);
        vo.setLineOfBusinessExplain("qqqqqqq explain");
        vo.setLineOfBusinessName("ewfgerg shiro update");
        vo.setNormalProductStockCycle(new BigDecimal(10));
//        vo.setLineOfBusinessId("d9758477842149ad8465e3c39173b936");
        vo.setLineOfBusinessId("dd0a77fcd18641cb952ba015f9e07c2d");


        vo.setId(1);
        vos.add(vo);

        lineOfBusinessWebService.updateLineOfBusiness(vos,1);
    }



    @Test
    public void getPowerByOperation() {

        List<Integer> powerByOperation = lineOfBusinessWebService.getPowerByOperation(1);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);


        Assert.assertEquals(expected,powerByOperation);
    }

    @Test
    public void notBindLineOfBusinessShops() {

        List<Shop> shopList = lineOfBusinessWebService.notBindLineOfBusinessShops();
    }

    @Test
    public void cancelLineOfBusiness() {

    }
}