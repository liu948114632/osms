/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba;

import com.itecheasy.core.fba.dao.AmazonStockReportDao;
import com.itecheasy.core.order.UpdateOrderProductForm;
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
}