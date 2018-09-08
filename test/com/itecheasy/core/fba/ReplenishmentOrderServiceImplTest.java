/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba;

import com.itecheasy.core.fba.dao.AmazonStockReportDao;
import com.itecheasy.core.order.NameOfProduct;
import com.itecheasy.core.order.OrderService;
import com.itecheasy.core.order.UpdateOrderProductForm;
import org.apache.bcel.generic.ACONST_NULL;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: liteng
 * @Date: 2018/8/1 18:49
 * @Description:
 */
public class ReplenishmentOrderServiceImplTest {
    ApplicationContext context;
    OrderService orderService;
    @Before
    public  void Before() {
         context = new ClassPathXmlApplicationContext("applicationContext.xml");
         orderService = (OrderService)context.getBean("orderService");
    }

    @Test
    public void addAndUpdateOrderProductList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ReplenishmentOrderService replenishmentOrderService = (ReplenishmentOrderService) context.getBean("replenishmentOrderService");


        List<UpdateOrderProductForm> forms = new ArrayList<UpdateOrderProductForm>();
        UpdateOrderProductForm updateOrderProductForm = new UpdateOrderProductForm();
//        updateOrderProductForm.setFbaShopProductId();
        updateOrderProductForm.setUpdateProductCode("KK-D331-M-NF");
        updateOrderProductForm.setQty(65.0);
        forms.add(updateOrderProductForm);


        replenishmentOrderService.addAndUpdateOrderProductList(2837,forms,"cocoa");

    }


    @Test
    public void getAllProductNameByShop() {

        OrderService orderService = (OrderService)context.getBean("orderService");
        List<NameOfProduct> allProductNameByShop = orderService.getAllProductNameByShop(1, 1, null);

    }

    @Test
    public void addProductName(){


        NameOfProduct nameOfProduct = new NameOfProduct();
        nameOfProduct.setCmsProductCode("DIY-X0160-S-RS");
        nameOfProduct.setProductNameChinese("spring");
        nameOfProduct.setProductNameEnglish("wing");

        orderService.addProductName(1,1,nameOfProduct,003);


    }
}