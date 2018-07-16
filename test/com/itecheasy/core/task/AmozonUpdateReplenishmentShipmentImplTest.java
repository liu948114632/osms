package com.itecheasy.core.task;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Auther: liteng
 * @Date: 2018/6/29 09:36
 * @Description:
 */
public class AmozonUpdateReplenishmentShipmentImplTest {

    @Test
    public void autoUploadOrderCode() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AmozonUpdateReplenishmentShipment messageTaskService = (AmozonUpdateReplenishmentShipment) context.getBean("amozonUpdateReplenishmentShipment");

        messageTaskService.autoUploadOrderCode();

    }
}