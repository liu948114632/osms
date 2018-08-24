package com.itecheasy.core.task;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.common.util.HqlUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.FbaInboundService;
import com.itecheasy.core.fba.PutTransportContentVO;
import com.itecheasy.core.fba.PutTransportContentVO3;
import com.itecheasy.core.fba.dao.ReplenishmentOrderDao;
import com.itecheasy.core.fba.dao.ReplenishmentOrderItemDao;
import com.itecheasy.core.order.OrderService;
import com.itecheasy.core.order.dao.OrderDao;
import com.itecheasy.core.order.dao.OrderProductDao;
import com.itecheasy.core.order.dao.OrderTrackingDao;
import com.itecheasy.core.po.OrderTrackingPO;
import com.itecheasy.core.po.ReplenishmentOrderPO;
import com.itecheasy.core.prepare.dao.SeaTransportationPreparePlanDao;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.printMethod.annotations.LoggerNameDescription;
import com.itecheasy.webservice.amazon.AmazonShipmentStatusListVO;
import com.itecheasy.webservice.amazon.InboundShipmentInfoVO;
import com.itecheasy.webservice.amazon.ListInboundShipmentsResultVO;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: liteng
 * @Date: 2018/6/28 08:57
 * @Description:
 */
public class AmozonUpdateReplenishmentShipmentImpl implements AmozonUpdateReplenishmentShipment {


    public static final int  automaton = -3;

    public static final ObjectMapper MAPPER = new ObjectMapper();

    private static final Logger LOGGER = Logger.getLogger(AmozonUpdateReplenishmentShipmentImpl.class);

    private ReplenishmentOrderDao replenishmentOrderDao;

    private SeaTransportationPreparePlanDao seaTransportationPreparePlanDao;

    private OrderTrackingDao orderTrackingDao;

    private SystemService systemService;

    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }

    public void setOrderTrackingDao(OrderTrackingDao orderTrackingDao) {
        this.orderTrackingDao = orderTrackingDao;
    }

    private FbaInboundService fbaInboundService;


    public void setReplenishmentOrderDao(ReplenishmentOrderDao replenishmentOrderDao) {
        this.replenishmentOrderDao = replenishmentOrderDao;
    }

    public void setFbaInboundService(FbaInboundService fbaInboundService) {
        this.fbaInboundService = fbaInboundService;
    }

    public void setSeaTransportationPreparePlanDao(SeaTransportationPreparePlanDao seaTransportationPreparePlanDao) {
        this.seaTransportationPreparePlanDao = seaTransportationPreparePlanDao;
    }

    @Override
    public void autoUploadOrderCode() {
        LOGGER.info("start同步订单跟踪号到亚马逊");
//        Date beginDate = java.sql.Date.valueOf("2018-05-01");
        Date beginDate = DateUtils.convertDate("2018-05-01");
        //查出所有的订单，并且状态是已发货的
        List<ReplenishmentOrderPO> replenishmentOrderPOS = replenishmentOrderDao.findListByHql
                ("FROM ReplenishmentOrderPO WHERE status=? AND deliveryDate>=? AND ltrim(rtrim(fba_replenishment_plan_id)) != '' ",
                        new Object[]{OrderService.OrderStatus.已发货.getVal(),beginDate});

        //跟踪单号如果为空就不执行提交亚马逊，如果不为空就提交给亚马逊   ,选择一个时间，这个时间以后的执行
        for (ReplenishmentOrderPO replenishmentOrderPO : replenishmentOrderPOS) {
            //每个补货订单下可能有多个跟踪订单
            List<OrderTrackingPO> orderTrackingPOS = orderTrackingDao.
                    findListByHql("FROM OrderTrackingPO WHERE orderCode=? ",new Object[]{replenishmentOrderPO.getCode()});
            if (orderTrackingPOS!=null && orderTrackingPOS.size()>0) {
                PutTransportContentVO putTransportContentVO = new PutTransportContentVO();
                putTransportContentVO.setShipmentId(replenishmentOrderPO.getShipmentID());
                putTransportContentVO.setOperatorId(automaton); //自动任务小于零,用于不记录日志
                putTransportContentVO.setOrderTrackCode(orderTrackingPOS.get(0).getCode());
                putTransportContentVO.setShopId(replenishmentOrderPO.getShopId());
                putTransportContentVO.setReplenishmentOrderCode(replenishmentOrderPO.getCode());

                String transportStatus = fbaInboundService.putTransportContent(putTransportContentVO);

//                if (transportStatus==null){
//                    throw new BussinessException("更新货运单号至亚马逊失败,补货订单编号:"+replenishmentOrderPO.getCode());
//                }
                //更新亚马逊货件状态为已发货
            }
        }
        //判断条件之后再来更新


        LOGGER.info("end同步订单跟踪号到亚马逊");
    }

    public void autoUploadOrderCode3() {
        //查出所有的订单，满足条件的,要在一定的商店下的
        LOGGER.info("start同步订单跟踪号到亚马逊");
//        Date beginDate = java.sql.Date.valueOf("2018-05-01");
        Date beginDate = DateUtils.convertDate("2018-05-01");


        //增加店铺限制

        //查出所有的补货订单，并且状态是已发货的
        List<ReplenishmentOrderPO> replenishmentOrderPOS = replenishmentOrderDao.findListByHql
                ("FROM ReplenishmentOrderPO WHERE status=? AND deliveryDate>=? AND ltrim(rtrim(fba_replenishment_plan_id)) != '' ",
                        new Object[]{OrderService.OrderStatus.已发货.getVal(),beginDate});

        //查出每个补货订单下所有的订单跟踪号
        List<String> orderCode = new ArrayList<String>();
        for (ReplenishmentOrderPO replenishmentOrderPO : replenishmentOrderPOS) {
            orderCode.add(replenishmentOrderPO.getCode());
        }
        String jointCriteriaString = HqlUtils.jointCriteriaString("FROM OrderTrackingPO WHERE orderCode ", orderCode);
        List<OrderTrackingPO> orderTrackingPOS = orderTrackingDao.findListByHql(jointCriteriaString); //,new Object[]{replenishmentOrderPOS.getCode()}

        //把orderTracking根据补货订单号来进行分类，补货订单号为key，订单跟踪号为valueList
        Map<String,List<String>> orderTrackingPoMap = new HashMap<String,List<String>>();
        for (OrderTrackingPO orderTrackingPO : orderTrackingPOS) {
            if (!orderTrackingPoMap.containsKey(orderTrackingPO.getOrderCode())){
                orderTrackingPoMap.put(orderTrackingPO.getOrderCode(),new ArrayList<String>());
            }
            orderTrackingPoMap.get(orderTrackingPO.getOrderCode()).add(orderTrackingPO.getCode());
        }

        List<PutTransportContentVO3> putTransportContentVOList = new ArrayList<PutTransportContentVO3>();
        for (ReplenishmentOrderPO replenishmentOrderPO : replenishmentOrderPOS) {
            //一个补货单
            //other information
            PutTransportContentVO3 putTransportContentVO3 = new PutTransportContentVO3();
            putTransportContentVO3.setCarrierName("other");
            putTransportContentVO3.setShipmentType("SP");
            putTransportContentVO3.setPartnered(false);
            putTransportContentVO3.setOperatorId(automaton);

            putTransportContentVO3.setShipmentId(replenishmentOrderPO.getShipmentID());
            putTransportContentVO3.setShopId(replenishmentOrderPO.getShopId());
            //每个补货订单下可能有多个跟踪订单,这个补货单下的订单跟踪号CodeList
            putTransportContentVO3.setOrderTrackCodeList(orderTrackingPoMap.get(replenishmentOrderPO.getCode()));

//            List<String> orderTrackCodeList = new ArrayList<String>();
//            for (OrderTrackingPO orderTrackingPO : orderTrackingPOS) {
//                orderTrackCodeList.add(orderTrackingPO.getCode());
//            }
//            putTransportContentVO3.setOrderTrackCodeList(orderTrackCodeList);

//            putTransportContentVO3.setShipmentIdList(replenishmentOrderPO.getShipmentID());
//            putTransportContentVO.setOrderTrackCode(orderTrackingPOS.get(0).getCode());
//            putTransportContentVO3.setShopId(replenishmentOrderPO.getShopId());
//            putTransportContentVO3.setReplenishmentOrderCodeList(replenishmentOrderPO.getCode());
//            putTransportContentVO3.setOperatorId(-3); //自动任务小于零,用于不记录日志
            putTransportContentVOList.add(putTransportContentVO3);
        }

//        String transportStatus = fbaInboundService.putTransportContent(putTransportContentVOList);

        //分类，根据shopID
        //根据不同的店铺来分类补货订单
        //分类店铺 key为店铺id，value为这个店铺下的所有的补货订单
        Map<Integer,List<PutTransportContentVO3>> putTransportContentVOMap = new HashMap<Integer,List<PutTransportContentVO3>>();
        for (PutTransportContentVO3 putTransportContentVO : putTransportContentVOList) {
            if(!putTransportContentVOMap.containsKey(putTransportContentVO.getShopId())){
                putTransportContentVOMap.put(putTransportContentVO.getShopId(),new ArrayList<PutTransportContentVO3>());
            }
            putTransportContentVOMap.get(putTransportContentVO.getShopId()).add(putTransportContentVO);
        }

        //调用putTransport  api1
        //都应该来接收集合类型参数，处理方式也是按照集合来处理

        //只负责访问一个店铺的，所以分店铺在最上层就要完成，换句话来说controller基本不需要考虑复用性，因为变化最多
        //所以在这里根据每一个不同的店铺来进行循环调用service，that不负责遍历和分类店铺
        for (Map.Entry<Integer, List<PutTransportContentVO3>> putTransportContentVO3Entry : putTransportContentVOMap.entrySet()) {
            String transportStatus = fbaInboundService.putTransportContent(putTransportContentVO3Entry.getValue());
        }

        //调用updateInbound  api2  传入集合类型对象
        Map<Integer,List<PutTransportContentVO3>> replenishmentOrderPOMap = new HashMap<Integer,List<PutTransportContentVO3>>();
        for (ReplenishmentOrderPO replenishmentOrderPO : replenishmentOrderPOS) {
        }
//        fbaInboundService.updateFbaInboundOrder(replenishmentOrderPO,"SHIPPED",false);


//        ReplenishmentOrderPO replenishmentOrderPO = replenishmentOrderDao.findByHql
//                ("from ReplenishmentOrderPO where code=? ",new Object[]{putTransportContentVO.getReplenishmentOrderCode()});
//        putTransportContentVO.setReplenishmentOrderId(replenishmentOrderPO.getId());

    }

    @Override
    public void autoSyncInboundShipments() {
        LOGGER.info("start同步FBA补货订单状态到osms");
        //查出所有的订单，并且状态是已发货的
        String date =  DeployProperties.getInstance().getProperty("test.amazon.sync.orderStatus.date","2018-05-01");
        Date beginDate =null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            beginDate = format.parse(date.trim());
        } catch (ParseException e) {
            e.printStackTrace();
            beginDate = new Date();
        }

        //获取合法的这些店铺
        List<Shop> notPauseAndEnableShops = systemService.getNotPauseAndEnableShops();
        StringBuilder builder = new StringBuilder();
        for (Shop notPauseAndEnableShop : notPauseAndEnableShops) {
            builder.append(notPauseAndEnableShop.getId()).append(",");
        }
        String substring = builder.substring(0, builder.length() - 1);

//        LOGGER.info("以下这些合法店铺的ID同步FBA补货订单状态到osms{" + substring +"}");

        //增加一个条件 某个时间开始的订单          latest_shipping_date>='2018-5-1'
        List<ReplenishmentOrderPO> replenishmentOrderPOS = replenishmentOrderDao.findListByHql
                ("FROM ReplenishmentOrderPO WHERE status=? AND deliveryDate>=? AND shopId in("+ substring +")",
                        new Object[]{OrderService.OrderStatus.已发货.getVal(),beginDate});
        //遍历把所有的已发货状态的商品的shipmentId传给亚马逊 返回的状态写入到数据库

        //分类ids //根据shopId进行分类
//        Map<Integer,Map<Integer, List<String>>> mapIndex = new HashMap<Integer, Map<Integer, List<String>>>();
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for (ReplenishmentOrderPO replenishmentOrderPO : replenishmentOrderPOS) {
            if(!map.containsKey(replenishmentOrderPO.getShopId())){
                map.put(replenishmentOrderPO.getShopId(),new ArrayList<String>());
            }
            List<String> integerList = map.get(replenishmentOrderPO.getShopId());
            integerList.add(replenishmentOrderPO.getShipmentID());
        }

        //不同商店的的订单调用不同的api,这是第一个shopId的

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            AmazonShipmentStatusListVO vo = new AmazonShipmentStatusListVO();
            List<String> shipmentIdList = entry.getValue();
            vo.setShipmentIdList(shipmentIdList);
            Integer shopId = entry.getKey();

            //只需要同步OSMS中FBA补货订单状态是已发货，发货日期是2018-5-1之后的订单。
            vo.setStartDate(DateUtils.getXMLGregorianCalendar(new Date()));
            ListInboundShipmentsResultVO listInboundShipmentsResultVO = null;
            try {
                listInboundShipmentsResultVO = fbaInboundService.listInboundShipments(vo, shopId); //ListInboundShipments调用

                String token = null;
                if (listInboundShipmentsResultVO != null) {
                    updateAmazonOrderStatus9(listInboundShipmentsResultVO, shopId);  //持久化第一次返回的一部分需要save
                    token = listInboundShipmentsResultVO.getNextToken();
                }

                while (token != null && !"".equalsIgnoreCase(token.trim())) {          //如果是否有nextToken,有的话需要继续调用，直到nextToken为null为止
                    ListInboundShipmentsResultVO resultVO = fbaInboundService.listInboundShipmentsByNextToken(token, shopId);
                    if (resultVO != null && resultVO.getInboundShipmentInfoVOList() != null && resultVO.getInboundShipmentInfoVOList().size() > 0) {
                        updateAmazonOrderStatus9(resultVO, shopId);  //持久化返回剩下的的一部分
                        token = resultVO.getNextToken();
                    } else {
                        token = null;   //clear token
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        LOGGER.info("end同步FBA补货订单状态到osms");
    }

    /**
     * 根据调用的亚马逊接口的返回状态，更新本地亚马逊补货订单的时间和亚马逊发货状态
     * @param listInboundShipmentsResultVO
     */
    @Deprecated
    public void updateAmazonOrderStatus(ListInboundShipmentsResultVO listInboundShipmentsResultVO,Integer shopId){
        for (InboundShipmentInfoVO inboundShipmentInfoVO : listInboundShipmentsResultVO.getInboundShipmentInfoVOList()) {

            ReplenishmentOrderPO replenishmentOrderPO = replenishmentOrderDao.
                    findByHql("FROM ReplenishmentOrderPO WHERE shipmentID=? AND shopId=? ",
                            new Object[]{inboundShipmentInfoVO.getShipmentId(),shopId});
            if ("RECEIVING".equalsIgnoreCase(inboundShipmentInfoVO.getShipmentStatus().trim()) ||
                    "CLOSED".equalsIgnoreCase(inboundShipmentInfoVO.getShipmentStatus().trim())) {
                // 检测到订单为“RECEIVING，CLOSED”状态时，都称为已到货，把时间记下来。这个字段，是为海运备货计划做准备用。

                replenishmentOrderPO.setOrderAmazonStatus(OrderService.OrderAmazonStatus.RECEIVING.getStatusCode());
                Date date = new Date();
                replenishmentOrderPO.setAmazonPracticalityArriveDate(date);   //当前时间就是 实际到货时间
                replenishmentOrderDao.updateObject(replenishmentOrderPO);

                //更改的同时也更改SeaTransportationPreparePlanPO中的arriveDate
                seaTransportationPreparePlanDao.updateArriveDate(replenishmentOrderPO.getId(),date);
            }
            //其他状态时暂时不处理
        }
    }

    @Deprecated
    public void updateAmazonOrderStatus3(ListInboundShipmentsResultVO listInboundShipmentsResultVO,Integer shopId){
        List<String> shipmentIdList = new ArrayList<String>();
        List<String> otherStatusList = new ArrayList<String>();
        for (InboundShipmentInfoVO inboundShipmentInfoVO : listInboundShipmentsResultVO.getInboundShipmentInfoVOList()) {
            if ("RECEIVING".equalsIgnoreCase(inboundShipmentInfoVO.getShipmentStatus().trim()) ||
                    "CLOSED".equalsIgnoreCase(inboundShipmentInfoVO.getShipmentStatus().trim())) {
                shipmentIdList.add(inboundShipmentInfoVO.getShipmentId().trim());
            }
        }

        String resultHql = HqlUtils.jointCriteriaString("FROM ReplenishmentOrderPO WHERE shopId=? AND shipmentID ",shipmentIdList);
        List<ReplenishmentOrderPO> replenishmentOrderPOList = replenishmentOrderDao.findListByHql(resultHql, new Object[]{shopId});

        Date date = DateUtils.getRealDate(new Date());
        List<Integer> replenishmentOrderIds = new ArrayList<Integer>();
        for (ReplenishmentOrderPO replenishmentOrderPO : replenishmentOrderPOList) {
            replenishmentOrderPO.setOrderAmazonStatus(OrderService.OrderAmazonStatus.RECEIVING.getStatusCode());
            replenishmentOrderPO.setAmazonPracticalityArriveDate(date);   //当前时间就是 实际到货时间
            replenishmentOrderIds.add(replenishmentOrderPO.getId());
        }
        replenishmentOrderDao.updateObject(replenishmentOrderPOList);

        if (CollectionUtils.isNotEmpty(replenishmentOrderIds)) {
            seaTransportationPreparePlanDao.updateArriveDate(replenishmentOrderIds,date);
        }

    }

    //the end of the war
    //class 负责更新操作
    public void updateAmazonOrderStatus9(ListInboundShipmentsResultVO listInboundShipmentsResultVO,Integer shopId) {
        if (listInboundShipmentsResultVO !=null &&
                CollectionUtils.isNotEmpty(listInboundShipmentsResultVO.getInboundShipmentInfoVOList())) {
            Map<String, List<String>> StatusMappingShipmentIds = new HashMap<String, List<String>>();
            for (InboundShipmentInfoVO inboundShipmentInfoVO : listInboundShipmentsResultVO.getInboundShipmentInfoVOList()) {
                if (!StatusMappingShipmentIds.containsKey(inboundShipmentInfoVO.getShipmentStatus())) {
                    StatusMappingShipmentIds.put(inboundShipmentInfoVO.getShipmentStatus(), new ArrayList<String>());
                }
                List<String> integerList = StatusMappingShipmentIds.get(inboundShipmentInfoVO.getShipmentStatus());
                integerList.add(inboundShipmentInfoVO.getShipmentId());
            }

            Date amazonPracticalityArriveDate = DateUtils.getRealDate(new Date());
            List<Integer> replenishmentOrderIds = new ArrayList<Integer>();
            for (Map.Entry<String, List<String>> stringListEntry : StatusMappingShipmentIds.entrySet()) {
                String resultHql = HqlUtils.jointCriteriaString("FROM ReplenishmentOrderPO WHERE shopId=? AND shipmentID ", stringListEntry.getValue());
                List<ReplenishmentOrderPO> replenishmentOrderPOList = replenishmentOrderDao.findListByHql(resultHql, new Object[]{shopId});
                for (ReplenishmentOrderPO replenishmentOrderPO : replenishmentOrderPOList) {
                    OrderService.OrderAmazonStatus orderAmazonStatus = OrderService.OrderAmazonStatus.get(stringListEntry.getKey());
                    if (orderAmazonStatus != null && stringListEntry.getKey().equalsIgnoreCase(orderAmazonStatus.getStatus())) {
                        replenishmentOrderPO.setOrderAmazonStatus(orderAmazonStatus.getStatusCode());
                        if (stringListEntry.getKey().equalsIgnoreCase(OrderService.OrderAmazonStatus.RECEIVING.getStatus()) ||
                                stringListEntry.getKey().equalsIgnoreCase(OrderService.OrderAmazonStatus.CLOSED.getStatus())) {
                            replenishmentOrderPO.setAmazonPracticalityArriveDate(amazonPracticalityArriveDate);
                            replenishmentOrderIds.add(replenishmentOrderPO.getId());
                        }
                    }
                }
                replenishmentOrderDao.updateObject(replenishmentOrderPOList);
            }
            if (CollectionUtils.isNotEmpty(replenishmentOrderIds)) {
                seaTransportationPreparePlanDao.updateArriveDate(replenishmentOrderIds, amazonPracticalityArriveDate);
            }
        }
    }




    public static void main(String[] args) {

        Date x = DateUtils.convertDate("2018-05-01");

        System.out.println(x);
        Date beginDate = java.sql.Date.valueOf("2018-05-01");
        System.out.println(beginDate);

        System.out.println( OrderService.OrderAmazonStatus.RECEIVING.toString());

        Date amazonPracticalityArriveDate = DateUtils.getRealDate(new Date());
        System.out.println("amazonPracticalityArriveDate = " + amazonPracticalityArriveDate);

        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = DateUtils.convertDate(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("s = " + s);

        Date date1 = DateUtils.convertDate(s, "yyyy-MM-dd HH:mm:ss");
        System.out.println("date1 = " + date1);

    }
}
