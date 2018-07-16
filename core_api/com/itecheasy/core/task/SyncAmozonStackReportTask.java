package com.itecheasy.core.task;

/**
 * @Auther: liteng
 * @Date: 2018/7/3 11:00
 * @Description:
 */
public interface SyncAmozonStackReportTask {

    /**
     * 同步亚马逊库存
     * 启用了quartz的并发模式
     */
    void syncAmozonStackReportTask();

    /**
     * 用于重置lastOneFlag,就是判断今天是否已经跑过了一次亚马逊
     */
    void resetEverydaySync();



}
