package com.itecheasy.webservice.client.baseInvoke;

import com.itecheasy.webservice.client.AmazonClient;

/**
 * @Auther: liteng
 * @Date: 2018/7/18 13:58
 * @Description:
 */
public class CreateInboundShipment extends BaseInvokeOsmsAm {


    @Override
    public String invokeOsmsAm(InvokeVO invokeVO) {
        String shipmentId =invokeVO.getAmazonWebService().createInboundShipment(invokeVO.getAmazonConfigInfo(), invokeVO.getInboundShipmentVO());
        return shipmentId;
    }

    @Override
    public String mockOsmsAm(InvokeVO invokeVO) {
        return null;
    }

    @Override
    public boolean isRealOrMock() {

        return true;
    }
}
