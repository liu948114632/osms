package com.itecheasy.core.task.syncState;

import com.itecheasy.core.system.Shop;

import java.util.List;

public class SyncMachine {

    private SyncState startSyncState;
    private SyncState doingSyncState;
    private SyncState doneSyncState ;
    private SyncState currentState;
    private List<Shop> enableShops;

    SyncMachine(){
//        this.doneSyncState = new DoneSyncState(this);
//        this.doingSyncState = new DoingSyncState(this);
//        this.startSyncState = new StartSyncState(this);
        this.currentState= startSyncState;    //初始化的状态为开始同步状态
    }


    public void getAllShopList() {
        //this.enableShops = dao.findShopList();
    }

    public Shop releaseShop() {
        System.out.println("A shop rolling out the slot...");
        if (enableShops != null && enableShops.size()>0) {
            Shop shop = enableShops.get(0);
            enableShops.remove(0);
            return shop;
        }
        return null;
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
