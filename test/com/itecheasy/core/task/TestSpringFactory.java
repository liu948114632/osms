package com.itecheasy.core.task;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

/**
 * @Auther: liteng
 * @Date: 2018/7/30 15:58
 * @Description: test SpringFactory
 */
public class TestSpringFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return Calendar.getInstance();
    }

    @Override
    public Class getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
