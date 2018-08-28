/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.task;

import com.itecheasy.core.fba.AmazonReportService;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.util.StaticUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/23 13:55
 * @Description: 同步亚马逊物流预计费用报告
 */
public class SyncAmazonLogisticsForecastCostReportTaskImpl implements SyncAmazonLogisticsForecastCostReportTask {

    private static final Logger LOGGER = Logger.getLogger(SyncAmazonLogisticsForecastCostReportTaskImpl.class);

    private SystemService systemService;

    private AmazonReportService amazonReportService;

    //用于多线程访问的shopList,当enableShops中没有了元素，今天就不会再跑了
    private List<Shop> enableShops;

    //0今天的还没有走，1今天的任务已经做完了
    private int lastOneFlag = 0;

    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }

    public void setAmazonReportService(AmazonReportService amazonReportService) {
        this.amazonReportService = amazonReportService;
    }

    public void setEnableShops(List<Shop> enableShops) {
        this.enableShops = enableShops;
    }

    public void setLastOneFlag(int lastOneFlag) {
        this.lastOneFlag = lastOneFlag;
    }

    private void initShopList() {
        LOGGER.info("初始化要获取亚马逊物流预计费用报告的店铺");
        enableShops = systemService.getSyncAmazonStockShopList();

    }

    // TODO: 2018/8/23 注意配置事务

    /**
     * 这里重复了
     * ...
     * 首次执行和每次的执行
     */
    @Override
    public void syncAmazonLogisticsForecastCostReportTask() {
        String enumType = AmazonReportService.GetReportType.亚马逊物流预计费用报告.getEnumType();

        LOGGER.info("开始调用中间服务来获取亚马逊物流预计费用报告");

        if (enableShops == null && lastOneFlag == 0) {    //第一次时执行,今天的跑完了之后就把flag改为1，就不会再初始化了店铺了
            initShopList();
        }

        if (enableShops != null && enableShops.size() > 0) {
            Shop shop = enableShops.get(0);

            try {
                LOGGER.error("以下店铺将开始请求AmazonLogisticsForecastCostReport" + shop.getId());
                boolean isSuccessSyncAmazon = amazonReportService.syncAmazonLogisticsForecastCostReport(shop, enumType);
                LOGGER.error("以下店铺请求亚马逊获取报告AmazonLogisticsForecastCostReport完成" + shop.getId());

                if (isSuccessSyncAmazon) {
                    StaticUtils.addEmail("OSMS系统:同步亚马逊物流预计费用报告AmazonLogisticsForecastCostReport报告成功", "\r\n" + "shopId：" + shop.getId());
                } else {
                    StaticUtils.addEmail("OSMS系统:同步亚马逊物流预计费用报告AmazonLogisticsForecastCostReport报告出错", "\r\n" + "shopId：" + shop.getId());
                }
            } catch (ParseException e) {
                LOGGER.error("date convert error 时间转换错误,请在配置文件deploy_config.properties中重新配置正确的时间格式 “yyyy-MM-dd HH:mm:ss” ");
                LOGGER.error(e.getMessage(), e);
            } catch (IOException e) {
                LOGGER.error("json 格式转换错误");
                LOGGER.error(e.getMessage(), e);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }

            if (enableShops.size() == 0) {
                lastOneFlag = 1;
            }
        }

        LOGGER.info("" + enumType);

    }

    /**
     * 下次执行的时间
     */
    @Override
    public void resetEverydaySync() {
        if (enableShops != null && enableShops.size() == 0 && lastOneFlag == 1) {  //第二次和以后的重置，单独的自动任务来初始化店铺
            initShopList();
            LOGGER.error("已经重置lastOneFlag，开始获取今天新的亚马逊物流预计费用报告LogisticsForecastCostReport");

        }

    }


}
