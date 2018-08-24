package com.itecheasy.core.task.syncState;

import com.itecheasy.core.fba.AmazonReportService;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.dao.ShopDao;
import com.itecheasy.core.task.SyncAmozonStackReportTask;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/7/3 11:01
 * @Description: 定时任务，自动来跑亚马逊，获取报告，之后写入本地
 */
public class NewSyncAmozonStackReportTaskImpl extends SyncAmazon implements SyncAmozonStackReportTask {
    private static Logger LOGGER = Logger.getLogger(NewSyncAmozonStackReportTaskImpl.class.getName());

    private DoneSyncState doneSyncState;
    private DoingSyncState doingSyncState;
    private StartSyncState startSyncState;
    private SyncState currentState;

    private List<Shop> enableShops;
    private ShopDao shopDao;
    private AmazonReportService amazonReportService;

    NewSyncAmozonStackReportTaskImpl(){
    }

    public void springInitMethod(){
        doneSyncState.initMethod(this);
        doingSyncState.initMethod(this);
        startSyncState.initMethod(this);
        this.currentState= startSyncState;
    }


    public void setDoneSyncState(DoneSyncState doneSyncState) {
        this.doneSyncState = doneSyncState;
    }

    public void setDoingSyncState(DoingSyncState doingSyncState) {
        this.doingSyncState = doingSyncState;
    }

    public void setStartSyncState(StartSyncState startSyncState) {
        this.startSyncState = startSyncState;
    }

    public void setShopDao(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    public void setAmazonReportService(AmazonReportService amazonReportService) {
        this.amazonReportService = amazonReportService;
    }

    public AmazonReportService getAmazonReportService() {
        return amazonReportService;
    }

    public void getAllShopList() {
        this.enableShops = shopDao.getEnableShops();
    }

    /**
     * 获取所有的商店report，多线程quartz
     */
    @Override
    public void syncAmozonStackReportTask() {
        currentState.initShop();
        currentState.callAmazon();
    }

    /**
     * 第二次同步亚马逊库存
     */
    @Override
    public void resetEverydaySync() {
        setCurrentState(getStartSyncState());
    }

    public SyncState getStartSyncState() {
        return startSyncState;
    }

    public List<Shop> getEnableShops() {
        return enableShops;
    }

    public void setEnableShops(List<Shop> enableShops) {
        this.enableShops = enableShops;
    }

    public SyncState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(SyncState currentState) {
        this.currentState = currentState;
    }

    public SyncState getDoneSyncState() {
        return doneSyncState;
    }

    public SyncState getDoingSyncState() {
        return doingSyncState;
    }

}
