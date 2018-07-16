package com.itecheasy.core.task;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Auther: liteng
 * @Date: 2018/6/25 16:19
 * @Description:
 */
public class MessageTaskServiceImplTest {

    @Test
    public void processingDMSMessage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageTaskService messageTaskService = (MessageTaskService) context.getBean("messageTaskService");

        messageTaskService.processingDMSMessage();
    }
}