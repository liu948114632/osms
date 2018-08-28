/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.osms.prepare;

import com.itecheasy.core.fba.AmazonReportService;
import com.itecheasy.core.po.SuperLongPrepareProductPO;
import com.itecheasy.core.prepare.IsExistSuperLongPrepareProductDataBase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: liteng
 * @Date: 2018/8/25 16:13
 * @Description:
 */
public class SuperLongPrepareProductWebServiceImplTest {

  private   SuperLongPrepareProductWebService superLongPrepareProductWebService;

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        superLongPrepareProductWebService = (SuperLongPrepareProductWebService) context.getBean("superLongPrepareProductWebService");

    }

    @Test
    public void showSuperLongPrepareProduct() {
        List<String> cmsCode = new ArrayList<String>();
        cmsCode.add("KK08");
        cmsCode.add("KK16");
        cmsCode.add("OPP02");
        cmsCode.add("OPP07");
        cmsCode.add("HPB4.0cm");
        cmsCode.add("E029");
        cmsCode.add("JRDS5mm");

        superLongPrepareProductWebService.addSuperLongPrepareProducts(cmsCode,1);
    }

    @Test
    public void checkRepeatCmsCode() {
        List<String> cmsCode = new ArrayList<String>();
        cmsCode.add("OPP02");
        cmsCode.add("OPP07");
        IsExistSuperLongPrepareProductDataBase isExistSuperLongPrepareProductDataBase = superLongPrepareProductWebService.checkRepeatCmsCode(cmsCode, 1);

    }

    @Test
    public void addSuperLongPrepareProducts() {
        List<String> cmsCode = new ArrayList<String>();
        cmsCode.add("OPP02");
        cmsCode.add("OPP07");
        cmsCode.add("HPB4.0cm");
        cmsCode.add("E029");
        List<Integer> integers = superLongPrepareProductWebService.addSuperLongPrepareProducts(cmsCode, 1);

    }

    @Test
    public void deleteSuperLongPrepareProducts() {
        List<String> cmsCode = new ArrayList<String>();
        cmsCode.add("OPP02");
        cmsCode.add("OPP07");
        List<Integer> integers = superLongPrepareProductWebService.deleteSuperLongPrepareProducts(cmsCode, 1);


    }

    @Test
    public void getSuperLongPrepareProductById() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<SuperLongPrepareProductPO> superLongPrepareProductById = superLongPrepareProductWebService.getSuperLongPrepareProductById(ids, 1);


    }
}