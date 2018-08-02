package com.itecheasy.core.task;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.fba.AmazonReportService;
import com.itecheasy.core.fba.dao.AmazonStockReportDao;
import com.itecheasy.core.po.AmazonStockReportPO;
import com.itecheasy.core.po.OrderPO;
import com.itecheasy.webservice.amazon.AmazonStockReportVO;
import com.itecheasy.webservice.amazon.InboundShipmentInfoVO;
import com.itecheasy.webservice.amazon.ListInboundShipmentsResultVO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Auther: liteng
 * @Date: 2018/7/9 15:28
 * @Description:
 */
public class AmazonStockReport {

    Thread thread;


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        List<OrderPO> a = new ArrayList<OrderPO>();
        List b = new ArrayList();
        List c = new ArrayList();

        Number n = 2.0;

        Class<?> sss = Class.forName("sss");
        Object o = sss.getConstructor().newInstance();

        Constructor<OrderPO> constructor1 = OrderPO.class.getConstructor();
        constructor1.newInstance();
        OrderPO orderPO = new OrderPO();

        Class<?> aClass = orderPO.getClass();
        Constructor<?> constructor = aClass.getConstructor();
        constructor.newInstance();
        OrderPO orderPO1 = OrderPO.class.newInstance();


        a.add(orderPO);
        System.out.println("a = " + a.get(0).getStatus());
        orderPO.setStatus(33);

        System.out.println(orderPO.getStatus());
        System.out.println(a.get(0).getStatus());

    }

    @Test
    public void testCase007() throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AmozonUpdateReplenishmentShipment amozonUpdateReplenishmentShipment = (AmozonUpdateReplenishmentShipment) context.getBean("amozonUpdateReplenishmentShipment");
        ListInboundShipmentsResultVO listInboundShipmentsResultVO = new ListInboundShipmentsResultVO();

        ArrayList<InboundShipmentInfoVO> listasda = new ArrayList<InboundShipmentInfoVO>();
        InboundShipmentInfoVO vo = new InboundShipmentInfoVO();
        for (int i = 0; i < 10; i++) {
            vo.setShipmentStatus("RECEIVING");
            vo.setShipmentId("FBA4KV7RDQ");
            if (i<3){
                vo.setShipmentStatus(" RECEIVING ");
                vo.setShipmentId("FBA4KV7RDQ");
            }
            listasda.add(vo);
        }
        listInboundShipmentsResultVO.setInboundShipmentInfoVOList(listasda);
        Integer shopId = 1;
        

//        amozonUpdateReplenishmentShipment.updateAmazonOrderStatus3(listInboundShipmentsResultVO,shopId);

    }

    @Test
    public void testCase() throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final SyncAmozonStackReportTask syncAmozonStackReportTask = (SyncAmozonStackReportTask) context.getBean("syncAmozonStackReportTask");

//        for (int i = 0; i < 10; i++) {
//            this.thread = new Thread(new Runnable() {
//                public void run() {
                    syncAmozonStackReportTask.syncAmozonStackReportTask();
//                }
//            });
//            thread.start();
//            Thread.sleep(3000);
//        }


    }

    /**
     *
     * save amazon stock report
     *
     * @throws IOException
     */
    @Test
    public void testCase002() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AmazonStockReportDao amazonStockReportDao = (AmazonStockReportDao) context.getBean("amazonStockReportDao");


        List<AmazonStockReportPO> reportFormList = new ArrayList<AmazonStockReportPO>(); //所有的报告
//        File filename = new File("D\\:\\osms_am\\backup\\");
        String path = "C:\\Users\\Administrator\\Desktop\\mock.txt";
        File filename = new File(path);

        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = "";
        line = br.readLine();    //读取第一行
        Map<String, Integer> indexMap = getIndex(line);     //获取下标
        line = br.readLine();   //第二行开始才是数据
        while (line != null) {
            String[] splitSingle = line.split("\t"); //取得每一行的每一个
            List<String> single = Arrays.asList(splitSingle);
            AmazonStockReportPO amazonStockReportPO = new AmazonStockReportPO();   //把每一行数据封装为一个vo
            amazonStockReportPO.setSku(single.get(indexMap.get("sku")));
            Date date = new Date();
            amazonStockReportPO.setSyncLast(new Date());
            amazonStockReportPO.setSyncFirst(new Date());
            amazonStockReportPO.setAfnInboundWorkingQuantity(Integer.valueOf(single.get(indexMap.get("workingIndex"))));
            amazonStockReportPO.setAfnWarehouseQuantity(Integer.valueOf(single.get(indexMap.get("warehouseIndex"))));
            amazonStockReportPO.setAfnFulfillableQuantity(Integer.valueOf(single.get(indexMap.get("fulfillableIndex"))));
            amazonStockReportPO.setAfnUnsellableQuantity(Integer.valueOf(single.get(indexMap.get("unsellableIndex"))));
            amazonStockReportPO.setAfnInboundShippedQuantity(Integer.valueOf(single.get(indexMap.get("inboundShippedIndex"))));
            amazonStockReportPO.setAfnReservedQuantity(Integer.valueOf(single.get(indexMap.get("reservedIndex"))));
            amazonStockReportPO.setAfnInboundReceivingQuantity(Integer.valueOf(single.get(indexMap.get("receivingIndex"))));
            amazonStockReportPO.setAfnTotalQuantity(amazonStockReportPO.getAfnFulfillableQuantity() +
                    amazonStockReportPO.getAfnInboundReceivingQuantity() + amazonStockReportPO.getAfnInboundShippedQuantity()
                    + amazonStockReportPO.getAfnInboundWorkingQuantity() + amazonStockReportPO.getAfnReservedQuantity());

            //other property
            amazonStockReportPO.setFnsku(single.get(indexMap.get("fnsku")));
            amazonStockReportPO.setAmazonStockReportAsin(single.get(indexMap.get("asin")));
            amazonStockReportPO.setProductName(single.get(indexMap.get("productName")));
            amazonStockReportPO.setCondition(single.get(indexMap.get("condition")));

            if (single.get(indexMap.get("yourPrice"))!=null && !"".equalsIgnoreCase(single.get(indexMap.get("yourPrice")).trim())) {
                amazonStockReportPO.setYourPrice(new BigDecimal(single.get(indexMap.get("yourPrice"))));
            }
            if (single.get(indexMap.get("perUnitVolume"))!=null &&!"".equalsIgnoreCase(single.get(indexMap.get("perUnitVolume")).trim())) {
                amazonStockReportPO.setPerUnitVolume(new BigDecimal(single.get(indexMap.get("perUnitVolume"))));
            }

            amazonStockReportPO.setMfnListingExists("No".equalsIgnoreCase(single.get(indexMap.get("mfnListingExists"))) ? 0 : 1);

            if (single.get(indexMap.get("mfnFulfillableQuantity")) != null && !"".equalsIgnoreCase(single.get(indexMap.get("mfnFulfillableQuantity")))) {
                amazonStockReportPO.setMfnFulfillableQuantity(Integer.valueOf(single.get(indexMap.get("mfnFulfillableQuantity"))));
            }

            amazonStockReportPO.setAfnListingExists("No".equalsIgnoreCase(single.get(indexMap.get("afnListingExists"))) ? 0 : 1);



            line = br.readLine(); // 一次读入一行数据
            reportFormList.add(amazonStockReportPO);
        }
//        List<AmazonStockReportPO> amazonStockReportPOS = BeanUtils.copyList(reportFormList, AmazonStockReportPO.class);
        amazonStockReportDao.mergeObject(reportFormList);
    }


    public static Map<String,Integer> getIndex(String report){
        String[] splitRows = report.split("\r\n");  //根据换行符来分割，得到每行的数据
        String[] splitRowFirst = splitRows[0].split("\t"); //取得每一行的每一个
        List<String> singleFirst = Arrays.asList(splitRowFirst);
        int sku = singleFirst.indexOf("sku");
        int workingIndex = singleFirst.indexOf("afn-inbound-working-quantity");
        int warehouseIndex = singleFirst.indexOf("afn-warehouse-quantity");
        int fulfillableIndex = singleFirst.indexOf("afn-fulfillable-quantity");
        int unsellableIndex = singleFirst.indexOf("afn-unsellable-quantity");
        int inboundShippedIndex = singleFirst.indexOf("afn-inbound-shipped-quantity");
        int reservedIndex = singleFirst.indexOf("afn-reserved-quantity");
        int receivingIndex = singleFirst.indexOf("afn-inbound-receiving-quantity");

        int fnsku = singleFirst.indexOf("fnsku");
        int asin = singleFirst.indexOf("asin");
        int productName = singleFirst.indexOf("product-name");
        int condition = singleFirst.indexOf("condition");
        int yourPrice = singleFirst.indexOf("your-price");
        int mfnListingExists = singleFirst.indexOf("mfn-listing-exists");
        int mfnFulfillableQuantity = singleFirst.indexOf("mfn-fulfillable-quantity");
        int afnListingExists = singleFirst.indexOf("afn-listing-exists");
        int perUnitVolume = singleFirst.indexOf("per-unit-volume");

        Map<String,Integer> indexMap = new HashMap<String, Integer>();
        indexMap.put("sku",sku);
        indexMap.put("workingIndex",workingIndex);
        indexMap.put("warehouseIndex",warehouseIndex);
        indexMap.put("fulfillableIndex",fulfillableIndex);
        indexMap.put("unsellableIndex",unsellableIndex);
        indexMap.put("inboundShippedIndex",inboundShippedIndex);
        indexMap.put("reservedIndex",reservedIndex);
        indexMap.put("receivingIndex",receivingIndex);

//other property
        indexMap.put("fnsku",fnsku);
        indexMap.put("asin",asin);
        indexMap.put("productName",productName);
        indexMap.put("condition",condition);
        indexMap.put("yourPrice",yourPrice);
        indexMap.put("mfnListingExists",mfnListingExists);
        indexMap.put("mfnFulfillableQuantity",mfnFulfillableQuantity);
        indexMap.put("afnListingExists",afnListingExists);
        indexMap.put("perUnitVolume",perUnitVolume);

        return indexMap;
    }
}
