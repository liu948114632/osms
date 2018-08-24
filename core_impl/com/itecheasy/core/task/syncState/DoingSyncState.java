package com.itecheasy.core.task.syncState;

import com.itecheasy.core.fba.AmazonReportService;
import com.itecheasy.core.system.Shop;

import java.util.List;

public class DoingSyncState implements SyncState {

    private NewSyncAmozonStackReportTaskImpl syncMachine;



    public void initMethod(NewSyncAmozonStackReportTaskImpl syncMachine){
        this.syncMachine = syncMachine;
    }

    @Override
    public void initShop() {
        //no
    }

    @Override
    public void callAmazon() {
        List<Shop> enableShops = syncMachine.getEnableShops();

        for (Shop shop : enableShops) {
            AmazonReportService amazonReportService = syncMachine.getAmazonReportService();
            amazonReportService.syncAmazonStockReportFromAmazon(enableShops);
        }

        syncMachine.setCurrentState(syncMachine.getDoneSyncState());

    }


}
