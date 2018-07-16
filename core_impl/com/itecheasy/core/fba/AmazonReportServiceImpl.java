package com.itecheasy.core.fba;

import com.itecheasy.common.PageList;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.fba.dao.AmazonStockReportDao;
import com.itecheasy.core.fba.dao.AmazonStockReportHistoryDao;
import com.itecheasy.core.order.AmazonStockReportSearchForm;
import com.itecheasy.core.order.AmazonStockReport;
import com.itecheasy.core.po.AmazonStockReportHistoryPO;
import com.itecheasy.core.po.AmazonStockReportPO;
import com.itecheasy.core.product.ProductDevelop;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.user.Licence;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.printMethod.AccessPath;
import com.itecheasy.webservice.amazon.AmazonStockReportVO;
import com.itecheasy.webservice.amazon.RequestReportVO;
import com.itecheasy.webservice.client.AmazonClient;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: liteng
 * @Date: 2018/7/2 14:05
 * @Description:
 */
public class AmazonReportServiceImpl implements AmazonReportService  {

    private SystemService systemService;
    private AmazonStockReportDao amazonStockReportDao;
    private AmazonStockReportHistoryDao amazonStockReportHistoryDao;

    Logger logger = Logger.getLogger(AmazonReportServiceImpl.class);


    public void setAmazonStockReportHistoryDao(AmazonStockReportHistoryDao amazonStockReportHistoryDao) {
        this.amazonStockReportHistoryDao = amazonStockReportHistoryDao;
    }

    public void setAmazonStockReportDao(AmazonStockReportDao amazonStockReportDao) {
        this.amazonStockReportDao = amazonStockReportDao;
    }

    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }

    @Override
    public AmazonStockReport getAmazonStockBySku(AmazonStockReportSearchForm form) {
        return null;
    }

    @Override
    public PageList<AmazonStockReport> getAmazonStocks(AmazonStockReportSearchForm form) {

        //根据店铺id ， sku,productCode查询出该店铺的补货计划
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT distinct a FROM AmazonStockReportPO a,ShopPo b WHERE a.shopId=b.id ");
        List<Object> o = new ArrayList<Object>();
        if(form.getShopId()!=-1){
            buffer.append("AND a.shopId = ? ");
            o.add(form.getShopId());
        }else{
            buffer.append("AND a.shopId in ( ");
            List<Shop> shops = systemService.getShopsByUserId(form.getOperatorId());
            for (int i = 0; i < shops.size(); i++) {
                if(i==shops.size()-1){
                    buffer.append(shops.get(i).getId()+" )");
                }else{
                    buffer.append(shops.get(i).getId()+",");
                }
            }
        }

        if(form.getSku()!=null&&!form.getSku().trim().equals("")){
            String[] skus = form.getSku().split(";");
            if(skus.length==1){
                buffer.append("AND a.sku = ? ");
                o.add(form.getSku().trim());
            }else{
                buffer.append("AND a.sku in ( ");
                for (int i = 0; i < skus.length; i++) {
                    if(i==skus.length-1){
                        buffer.append("'"+skus[i].trim()+"' )");
                    }else{
                        buffer.append("'"+skus[i].trim()+"',");
                    }
                }
            }
        }
// TODO: 2018/7/4 分页查询库存管理
        buffer.append(" ORDER BY a.syncLast DESC");

        PageList<AmazonStockReportPO> pageList = amazonStockReportDao.findPageListByHql(form.getCurrentPage(), form.getPageSize(), buffer.toString(), o.toArray());

//        PageList<AmazonStockReport> resultPage = new PageList<AmazonStockReport>();
//        List<AmazonStockReport> copyList = new ArrayList<AmazonStockReport>();
//        List<AmazonStockReportPO> data = pageList.getData();
//        for (AmazonStockReportPO datum : data) {
//            AmazonStockReport vo = new AmazonStockReport();
//            vo.setShopId(datum.getShopId());
//            vo.setSku(datum.getSku());
//            vo.setSyncFirst(datum.getSyncFirst());
//            vo.setSyncLast(datum.getSyncLast());
//
//            //other value
//            copyList.add(vo);
//        }

//        resultPage.setData(copyList);
//        resultPage.setPage(pageList.getPage());

        PageList<AmazonStockReport> amazonStockReportPageList = BeanUtils.copyPageList(pageList, AmazonStockReport.class);

        return amazonStockReportPageList;
    }



    /**
     * auto task
     */
    @Override
    public void getAmazonStockReportFromAmazon(List<Shop> shopList) {
        for (Shop enableShop : shopList) {   //只有一个shopId
            RequestReportVO requestReportVO = new RequestReportVO();
            requestReportVO.setReportType("_GET_FBA_MYI_UNSUPPRESSED_INVENTORY_DATA_");
            requestReportVO.setShopId(enableShop.getId());
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                requestReportVO.setStartDate(DateUtils.getXMLGregorianCalendar(format.parse(DeployProperties.getInstance().getProperty("amazon.stock.report.start.date",null))));
                requestReportVO.setEndDate(DateUtils.getXMLGregorianCalendar(format.parse(DeployProperties.getInstance().getProperty("amazon.stock.report.end.date",null))));
            } catch (ParseException e) {
                logger.info("date conver error 时间转换错误,请在配置文件重新配置正确的时间格式 “yyyy-MM-dd HH:mm:ss” ");
                e.printStackTrace();
            }

            //同步回单个店铺的所有报告
            List<AmazonStockReportVO> amazonStockReport = AmazonClient.getAmazonStockReport(enableShop.getId(), requestReportVO);//调用amazon
            if (amazonStockReport != null) { //把商店信息设置回来
                for (AmazonStockReportVO amazonStockReportVO : amazonStockReport) {
                    amazonStockReportVO.setShopId(enableShop.getId());
                }
            }

            if(CollectionUtils.isNotEmpty(amazonStockReport)){
                //更新到历史记录的表中,并且确保时间唯一   可以考虑分批写
                amazonStockReportHistoryDao.addObject(BeanUtils.copyList(encapsulationToAmazonStockReportPo(amazonStockReport), AmazonStockReportHistoryPO.class));

                //把从亚马逊所有的记录都从dao中拿到,用于比较时间,根据shopIdid和sku来进行判断
                List<AmazonStockReportPO> daoStockReportList = findFromDao(amazonStockReport, enableShop.getId());

                //根据shopIdid和sku来进行判断，如果没有这个商品的报告记录，就设置首次同步时间，从中间服务同步回来时，首次和最后同步时间都有
                List<AmazonStockReportVO> amazonStockReportVOS = updateData(amazonStockReport, daoStockReportList);

                //写入数据库，但是要自己包装
                amazonStockReportDao.mergeObject(encapsulationToAmazonStockReportPo(amazonStockReportVOS));
                //同步成功，发送邮件
                StaticUtils.addEmail("OSMS系统:成功的从亚马逊同步了店铺的库存", "\r\n" + "shopId："+shopList.get(0));
            }else{
                //同步失败，发送邮件
                StaticUtils.addEmail("OSMS系统:Amazon中间服务调用异常", "\r\n" + "shopId："+shopList.get(0));
            }
        }
    }

    //读取数据库
    public List<AmazonStockReportPO> findFromDao(List<AmazonStockReportVO> amazonStockReport, Integer shopId){
        String hql = "FROM AmazonStockReportPO WHERE shopId=? ";
        StringBuilder builder = new StringBuilder();
        for (AmazonStockReportVO vo : amazonStockReport) {
            builder.append(",'").append(vo.getSku()).append("'");
        }
        hql+="  AND sku in ( "+builder.substring(1).toString()+" )";

        return amazonStockReportDao.findListByHql(hql, new Object[]{shopId});
    }

    //返回的多个报告对象里，如果是旧的报告，则不跟新创建时间
    public List<AmazonStockReportVO> updateData(List<AmazonStockReportVO> amazonStockReport,List<AmazonStockReportPO> daoStockReportList) {
        for (AmazonStockReportVO amazonStockReportVO : amazonStockReport) { //new
            for (AmazonStockReportPO daoStockReport : daoStockReportList) {     //old
                if (amazonStockReportVO.getShopId().equals(daoStockReport.getShopId()) &&
                        amazonStockReportVO.getSku().equalsIgnoreCase(daoStockReport.getSku())) {   //没有这个商品才设置第一次同步时间
                    amazonStockReportVO.setSyncFirst(DateUtils.getXMLGregorianCalendar(daoStockReport.getSyncFirst()));
                }
            }
        }
        return amazonStockReport;
    }

    public List<AmazonStockReportPO> encapsulationToAmazonStockReportPo(List<AmazonStockReportVO> amazonStockReport){
        List<AmazonStockReportPO> po = new ArrayList<AmazonStockReportPO>();
        for (AmazonStockReportVO reportVO : amazonStockReport) {
            AmazonStockReportPO _po = new AmazonStockReportPO();

            _po.setAfnFulfillableQuantity(reportVO.getAfnFulfillableQuantity());
            _po.setAfnInboundReceivingQuantity(reportVO.getAfnInboundReceivingQuantity());
            _po.setAfnInboundShippedQuantity(reportVO.getAfnInboundShippedQuantity());
            _po.setAfnInboundWorkingQuantity(reportVO.getAfnInboundWorkingQuantity());
            _po.setAfnReservedQuantity(reportVO.getAfnReservedQuantity());
            _po.setAfnUnsellableQuantity(reportVO.getAfnUnsellableQuantity());
            _po.setAfnWarehouseQuantity(reportVO.getAfnWarehouseQuantity());
            _po.setAfnTotalQuantity(reportVO.getAfnTotalQuantity());
            _po.setSku(reportVO.getSku());
            _po.setShopId(reportVO.getShopId());
            _po.setSyncFirst(DateUtils.getDateByXMLGregorianCalendar(reportVO.getSyncFirst()));
            _po.setSyncLast(DateUtils.getDateByXMLGregorianCalendar(reportVO.getSyncLast()));

            //other property
            _po.setFnsku(reportVO.getFnsku());
            _po.setAmazonStockReportAsin(reportVO.getAmazonStockReportAsin());
            _po.setProductName(reportVO.getProductName());
            _po.setCondition(reportVO.getCondition());
            _po.setYourPrice(reportVO.getYourPrice());
            _po.setMfnListingExists(reportVO.getMfnListingExists());
            _po.setMfnFulfillableQuantity(reportVO.getMfnFulfillableQuantity());
            _po.setAfnListingExists(reportVO.getAfnListingExists());
            _po.setPerUnitVolume(reportVO.getPerUnitVolume());

            po.add(_po);
        }
        return po;
    }

}
