package com.itecheasy.core.task.syncState;

public class StartSyncState implements SyncState {

    private NewSyncAmozonStackReportTaskImpl syncMachine;

    public StartSyncState() {
    }

    public void initMethod(NewSyncAmozonStackReportTaskImpl syncMachine){
        this.syncMachine = syncMachine;
    }

    @Override
    public void initShop() {

        syncMachine.getAllShopList();
        syncMachine.setCurrentState(syncMachine.getDoingSyncState());
    }



    @Override
    public void callAmazon() {
        //no
    }


}
