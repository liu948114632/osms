package com.itecheasy.webservice.client.baseInvoke;

import com.itecheasy.webservice.amazon.AmazonConfigInfo;
import com.itecheasy.webservice.amazon.AmazonWebService;
import com.itecheasy.webservice.amazon.InboundShipmentVO;

/**
 * @Auther: liteng
 * @Date: 2018/7/18 13:51
 * @Description:
 */
public class InvokeVO {

    private int shopId;
    private InboundShipmentVO inboundShipmentVO;
    private AmazonWebService amazonWebService;

    private AmazonConfigInfo amazonConfigInfo;

    public AmazonConfigInfo getAmazonConfigInfo() {
        return amazonConfigInfo;
    }

    public void setAmazonConfigInfo(AmazonConfigInfo amazonConfigInfo) {
        this.amazonConfigInfo = amazonConfigInfo;
    }

    public AmazonWebService getAmazonWebService() {
        return amazonWebService;
    }

    public void setAmazonWebService(AmazonWebService amazonWebService) {
        this.amazonWebService = amazonWebService;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public InboundShipmentVO getInboundShipmentVO() {
        return inboundShipmentVO;
    }

    public void setInboundShipmentVO(InboundShipmentVO inboundShipmentVO) {
        this.inboundShipmentVO = inboundShipmentVO;
    }
}
