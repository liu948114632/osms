package com.itecheasy.core.task;

import com.itecheasy.common.asynemail.AsynEmailServiceImpl;
import com.itecheasy.common.util.Mail;
import com.itecheasy.core.fba.AmazonReportService;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.dao.ShopDao;
import com.itecheasy.osms.order.AmazonReportWebService;
import com.itecheasy.webservice.amazon.RequestReportVO;
import com.itecheasy.webservice.client.AmazonClient;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/7/3 11:01
 * @Description: 定时任务，自动来跑亚马逊，获取报告，之后写入本地
 */
public class SyncAmozonStackReportTaskImpl implements SyncAmozonStackReportTask{

    private static Logger logger = Logger.getLogger(SyncAmozonStackReportTaskImpl.class.getName());

    private ShopDao shopDao;

    private AmazonReportService amazonReportService;

    public void setAmazonReportService(AmazonReportService amazonReportService) {
        this.amazonReportService = amazonReportService;
    }

    public void setShopDao(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    //用于多线程访问的shopList,当enableShops中没有了元素，今天就不会再跑了
    private List<Shop> enableShops;

    //0今天的还没有走，1今天的任务已经做完了
    private int lastOneFlag=0;

    //记录上一个商店
    private Shop shop;

    public void initShopList(){
        enableShops = shopDao.getEnableShops();
    }

    /**
     * 获取所有的商店report，多线程quartz
     */
    @Override
    public void syncAmozonStackReportTask() {
        //init shopList every day
        if(enableShops==null && lastOneFlag==0){
            initShopList();
            if (shop!=null) {
                logger.info("上一个已经发送的获取amazonStock请求的shopID"+shop.getId());
            }
        }else if(enableShops==null && lastOneFlag==1){ //今天的任务已经做完了
            logger.info("今天的亚马逊stock——report请求已经全部发送完毕");
        }

        if (enableShops!=null && enableShops.size()>0) {
            shop = enableShops.get(0);
            List<Shop> s = new ArrayList<Shop>();
            s.add(shop);
            enableShops.remove(0); //拿完之后删除掉刚刚拿到的那个
            //每次只访问一个shop
            amazonReportService.getAmazonStockReportFromAmazon(s);
        }
    }

    /**
     * 用于重置lastOneFlag,就是判断今天是否已经跑过了一次亚马逊
     */
    @Override
    public void resetEverydaySync() {
        if (enableShops==null && lastOneFlag == 1) {
            initShopList();
            logger.error("已经重置lastOneFlag，开始获取今天新的亚马逊stockReport");
        }else if(enableShops!=null && lastOneFlag != 1){
            logger.error("未知错误，今天不能初始化并且访问亚马逊来获取报告，可能是昨天或者更早的报告没有完成");
        }else{
            logger.error("未知错误,不能初始化亚马逊自动任务来获取报告");
        }

    }




}
