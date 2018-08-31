/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.osms.prepare;

import com.itecheasy.core.prepare.IsExistSuperLongPrepareProductDataBase;
import com.itecheasy.core.prepare.SuperLongPrepareProductSearchForm;
import com.itecheasy.core.prepare.SuperLongPrepareProductVO;
import com.itecheasy.core.product.ShopProductCmsInfo;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/25 16:13
 * @Description:
 */
public class SuperLongPrepareProductWebServiceImplTest {

    private SuperLongPrepareProductWebService superLongPrepareProductWebService;

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        superLongPrepareProductWebService = (SuperLongPrepareProductWebService) context.getBean("superLongPrepareProductWebService");

    }


    @Test
    public void showSuperLongPrepareProduct() {
        SuperLongPrepareProductSearchForm form = new SuperLongPrepareProductSearchForm();
        List<String> cmsCode = new ArrayList<String>();
        cmsCode.add("OPP02");
        cmsCode.add("OPP07");
        form.setCmsCodes(cmsCode);
//        form.setJoinSuperLongPrepareProductDate();
        Date date = new Date();
        Date before = DateUtils.addDays(date, -3);
//        Date after = DateUtils.addDays(date, 3);

//        form.setJoinSuperLongPrepareProductDateEnd(after);
        form.setJoinSuperLongPrepareProductDateStart(before);

        //
        form.setCmsCodeName("Zip Lock Bags, Rectangle, Clear, 7x5cm; Unilateral thickness: 0.023mm");


        form.setOperatorId(1);
        form.setCurrentPage(1);
        form.setPageSize(3);

        superLongPrepareProductWebService.showSuperLongPrepareProduct(form);
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
//        cmsCode.add("cocoa");
//        cmsCode.add("chino");
//        cmsCode.add("shiro");

        List<ShopProductCmsInfo> cmsInfos = superLongPrepareProductWebService.addSuperLongPrepareProducts(cmsCode, 1);

    }

    @Test
    public void deleteSuperLongPrepareProducts() {
        List<String> cmsCode = new ArrayList<String>();
        cmsCode.add("OPP02");
        cmsCode.add("OPP07");
        List<ShopProductCmsInfo> cmsInfos = superLongPrepareProductWebService.deleteSuperLongPrepareProducts(cmsCode, 1);


    }

    @Test
    public void getSuperLongPrepareProductById() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<SuperLongPrepareProductVO> superLongPrepareProductById = superLongPrepareProductWebService.getSuperLongPrepareProductById(ids, 1);


    }


    @Test
    public void getCmsCodeBySuperLongPrepareProductIds() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(2);
        ids.add(3);
        List<ShopProductCmsInfo> cmsCodeBySuperLongPrepareProductIds = superLongPrepareProductWebService.getCmsCodeBySuperLongPrepareProductIds(ids);


    }

    @Test
    public void showSuperLongPrepareProduct333() {
        SuperLongPrepareProductSearchForm form = new SuperLongPrepareProductSearchForm();
        List<String> cmsCode = new ArrayList<String>();
        cmsCode.add("OPP02");
        cmsCode.add("OPP07");
//        form.setCmsCodes(cmsCode);
//        form.setJoinSuperLongPrepareProductDate();
//        Date date = new Date();
//        Date before = DateUtils.addDays(date, -5);
//        Date after = DateUtils.addDays(date, 3);

//        form.setJoinSuperLongPrepareProductDateEnd(after);
//        form.setJoinSuperLongPrepareProductDateStart(before);

        //
//        form.setCmsCodeName("Zip Lock Bags, Rectangle, Clear, 7x5cm; Unilateral thickness: 0.023mm");


        form.setOperatorId(1);

        form.setCurrentPage(1);
        form.setPageSize(50);

        superLongPrepareProductWebService.showSuperLongPrepareProduct3(form);
    }


}