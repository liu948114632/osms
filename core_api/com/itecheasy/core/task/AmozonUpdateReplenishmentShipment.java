package com.itecheasy.core.task;


/**
 * @Auther: liteng
 * @Date: 2018/6/28 08:52
 * @Description:把本地的跟踪单号更新给亚马逊的货运单号，并且更新亚马逊货件状态为已发货
 */
public interface AmozonUpdateReplenishmentShipment {


    /**
     * 把本地的跟踪单号更新给亚马逊的货运单号，并且更新亚马逊货件状态为已发货
     */
    void autoUploadOrderCode();

    /**
     *
     * 有可能一次请求返回不完整，会多一个nextToken，这时要继续调用亚马逊的另一个接口返回余下的数据
     * 之后把数据写入到本地的数据库
     *
     */
    void autoSyncInboundShipments();


}
