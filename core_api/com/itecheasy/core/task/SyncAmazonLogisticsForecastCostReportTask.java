/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.task;

/**
 * @Auther: liteng
 * @Date: 2018/8/23 13:54
 * @Description:
 */
public interface SyncAmazonLogisticsForecastCostReportTask {

    /**
     * 首次执行和每次的执行
     */
    public abstract void syncAmazonLogisticsForecastCostReportTask();

    /**
     * 下次执行的时间
     */
    public abstract void resetEverydaySync();

}