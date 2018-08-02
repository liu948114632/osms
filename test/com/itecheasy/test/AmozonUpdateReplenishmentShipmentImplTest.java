package com.itecheasy.test;

import com.itecheasy.core.task.AmozonUpdateReplenishmentShipment;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Auther: liteng
 * @Date: 2018/6/29 10:02
 * @Description:
 */
public class AmozonUpdateReplenishmentShipmentImplTest {

    @Test
    public void autoSyncInboundShipments() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AmozonUpdateReplenishmentShipment messageTaskService =
                (AmozonUpdateReplenishmentShipment) context.getBean("amozonUpdateReplenishmentShipment");

        messageTaskService.autoSyncInboundShipments();

    }



}