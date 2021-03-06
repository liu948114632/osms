package com.itecheasy.core.fba;


/**
 * @Auther: liteng
 * @Date: 2018/6/21 14:30
 * @Description: 用于放置关于:跟踪单号提交AM 的参数
 *
 *
 */
public class PutTransportContentVO {

    private String shipmentId;   //这个是update用到的

    private String orderTrackCode;
    private int replenishmentOrderId;
    private String replenishmentOrderCode;



    private int shopId;
    private int operatorId;

    public int getReplenishmentOrderId() {
        return replenishmentOrderId;
    }

    public void setReplenishmentOrderId(int replenishmentOrderId) {
        this.replenishmentOrderId = replenishmentOrderId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getReplenishmentOrderCode() {
        return replenishmentOrderCode;
    }

    public void setReplenishmentOrderCode(String replenishmentOrderCode) {
        this.replenishmentOrderCode = replenishmentOrderCode;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getOrderTrackCode() {
        return orderTrackCode;
    }

    public void setOrderTrackCode(String orderTrackCode) {
        this.orderTrackCode = orderTrackCode;
    }


}
