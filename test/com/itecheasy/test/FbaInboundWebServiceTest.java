package com.itecheasy.test;

import com.itecheasy.core.fba.PutTransportContentVO;
import com.itecheasy.osms.order.FbaInboundWebService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Auther: liteng
 * @Date: 2018/6/27 13:36
 * @Description:
 */
public class FbaInboundWebServiceTest {

    @Test
    public void putTransportContent() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		FbaInboundWebService  fbaInboundWebService = (FbaInboundWebService) context.getBean("fbaInboundWebService");

        PutTransportContentVO vo = new PutTransportContentVO();
        vo.setShopId(5);
        vo.setReplenishmentOrderCode("FA180616579813A");
        vo.setOrderTrackCode("aaaaa");
        vo.setShipmentId("xxxx");
        fbaInboundWebService.putTransportContent(vo);
    }
}