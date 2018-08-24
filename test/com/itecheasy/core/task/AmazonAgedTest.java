/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.task;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportDao;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;
import com.itecheasy.core.operation.AmazonAgedReportVO;
import com.itecheasy.webservice.amazon.RequestReportVO;
import com.itecheasy.webservice.client.AmazonClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/10 16:10
 * @Description:
 */
public class AmazonAgedTest {


    public static final ObjectMapper MAPPER =  new ObjectMapper();



    @Test
   public void testAmazonAged(){
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       SyncAmazonAgedItemReportTask syncAmazonAgedItemReportTask =
               (SyncAmazonAgedItemReportTask) context.getBean("syncAmazonAgedItemReportTask");

       syncAmazonAgedItemReportTask.syncAmazonAgedItemReport();
   }

    @Test
    public void testAmazonAgedWebservice(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SyncAmazonAgedItemReportTask syncAmazonAgedItemReportTask =
                (SyncAmazonAgedItemReportTask) context.getBean("syncAmazonAgedItemReportTask");

        syncAmazonAgedItemReportTask.syncAmazonAgedItemReport();
    }



    @Test
    public void addToDateBase() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AmazonReportService amazonReportService =
//                (AmazonReportService) context.getBean("amazonReportService");

        String reportType = "_GET_FBA_MYI_UNSUPPRESSED_INVENTORY_DATA_";
        RequestReportVO requestReportVO = new RequestReportVO();
        requestReportVO.setShopId(1);
        requestReportVO.setReportType(reportType);

        String jsonString = AmazonClient.getAmazonStockReport3(1, requestReportVO);    //call amazon

        List<AmazonAgedReportVO> amazonInventoryAgedReportVOS =
                MAPPER.readValue(jsonString, new TypeReference<List<AmazonAgedReportVO>>() {});

        List<AmazonInventoryAgedReportPO> amazonInventoryAgedReportPOS = BeanUtils.copyList(amazonInventoryAgedReportVOS, AmazonInventoryAgedReportPO.class);

        AmazonInventoryAgedReportDao amazonInventoryAgedReportDao = (AmazonInventoryAgedReportDao) context.getBean("amazonInventoryAgedReportDao");

        amazonInventoryAgedReportDao.addObject(amazonInventoryAgedReportPOS);
//        amazonReportService.syncAmazonAgedItemReport(enableShop, reportType);
//        amazonReportService.syncAmazonAgedItemReport();
    }

}
