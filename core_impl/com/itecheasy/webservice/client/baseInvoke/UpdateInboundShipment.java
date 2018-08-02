package com.itecheasy.webservice.client.baseInvoke;

import com.itecheasy.webservice.amazon.AmazonWebService;
import com.itecheasy.webservice.client.AmazonClient;

/**
 * @Auther: liteng
 * @Date: 2018/7/18 14:10
 * @Description:
 */
public class UpdateInboundShipment extends BaseInvokeOsmsAm {

    @Override
    public String invokeOsmsAm(InvokeVO invokeVO) {
        String shipmentId = invokeVO.getAmazonWebService().updateInboundShipment(configInfoByShop(invokeVO.getShopId()), invokeVO.getInboundShipmentVO());
            return shipmentId;
    }

    @Override
    public String mockOsmsAm(InvokeVO invokeVO) {
        return null;
    }

    @Override
    public boolean isRealOrMock() {
        return super.isRealOrMock();
    }
}
