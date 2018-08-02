package com.itecheasy.webservice.client.baseInvoke;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.core.util.AmazonInfo;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.webservice.amazon.AmazonConfigInfo;
import com.itecheasy.webservice.amazon.AmazonWebService;
import com.itecheasy.webservice.client.AmazonClient;

/**
 * @Auther: liteng
 * @Date: 2018/7/18 13:44
 * @Description: 用来选择模拟调用还是真实调用osms_am
 */
public abstract class BaseInvokeOsmsAm {

    //party method  arithmetic
    public void invokeUnion(InvokeVO vo){
        try {
            AmazonWebService amazonWebService = init(vo.getShopId());
            vo.setAmazonWebService(amazonWebService);
            vo.setAmazonConfigInfo(configInfoByShop(vo.getShopId()));
            if(isRealOrMock()) {
                String s = invokeOsmsAm(vo);
            }else {
                String s = mockOsmsAm(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AmazonWebService init(int shopId) throws Exception {
        return AmazonClient.init(StaticUtils.getWebServiceURL(shopId));
    }


    public abstract String invokeOsmsAm(InvokeVO invokeVO);


    public abstract String mockOsmsAm(InvokeVO invokeVO);


    public AmazonConfigInfo configInfoByShop(int shopId){
        AmazonInfo info = StaticUtils.getAmazonInfoByShop(shopId);
        if (info!=null) {
            return BeanUtils.copyProperties(info, AmazonConfigInfo.class);
        }
        return null;
    }

    public boolean isRealOrMock(){
        return true;
    }

}
