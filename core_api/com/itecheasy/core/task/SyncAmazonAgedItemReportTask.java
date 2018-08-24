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
 * @Date: 2018/8/10 16:00
 * @Description:
 */
public interface SyncAmazonAgedItemReportTask {

    public void syncAmazonAgedItemReport();


    /**
     * 用于重置lastOneFlag,就是判断今天是否已经跑过了一次亚马逊
     */
    public void resetEverydaySync();

}
