package com.itecheasy.webservice.client;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.order.FBAStoreProduct;
import com.itecheasy.webservice.crm.AccountSetting;
import com.itecheasy.webservice.crm.ArrayOfFirstWayOrderInfo;
import com.itecheasy.webservice.crm.FirstWayOrderInfo;
import com.itecheasy.webservice.crm.ForOtherWebService;
import com.itecheasy.webservice.crm.ForOtherWebServiceSoap;
import com.itecheasy.webservice.crm.OrderItem;

/** 
 * @author wanghw
 * @date 2016-2-24 
 * @description TODO
 * @version 1.1.7
 */
public class CRMClient {
	private static  ForOtherWebServiceSoap soap;
	private static AccountSetting webServiceSetting;
	private final static String CRM_WS=DeployProperties.getInstance().getProperty("crm.url");
//	private final static String PIN=DeployProperties.getInstance().getProperty("");
	private final static Logger LOGGER=Logger.getLogger(CRMClient.class);
	
	private static void init() {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = com.itecheasy.webservice.crm.ForOtherWebService.class.getResource(".");
			url = new URL(baseUrl, CRM_WS);
			ForOtherWebService service = new ForOtherWebService(
					url, new QName("http://tempuri.org/", "ForOtherWebService"));
			soap = service.getForOtherWebServiceSoap();
//			ObjectFactory objectFactory = new ObjectFactory();
//			webServiceSetting = objectFactory.createAccountSetting();
//			webServiceSetting.setPinCode(DeployProperties.getInstance().getOAPinCode());
		} catch (MalformedURLException e) {
			
		}
	}
	
	public static List<FBAStoreProduct> getFirstWayOrder(String startDate,String endDate){
		LOGGER.info("getFirstWayOrder--->>please startDate="+startDate);
		LOGGER.info("getFirstWayOrder--->>please endDate="+endDate);
		if(soap==null){
			init();
		}
		ArrayOfFirstWayOrderInfo  array=soap.getFirstWayOrder(startDate, endDate);
		Date syncTime=new Date();
		List<FBAStoreProduct> all=null;
		FBAStoreProduct product=null;
		BigDecimal unitFreight=null;
		int _total_unit=0;
		if(array!=null){
			LOGGER.info("getFirstWayOrder--->>array "+array.getFirstWayOrderInfo().size());
			all=new ArrayList<FBAStoreProduct>();
			for (FirstWayOrderInfo info : array.getFirstWayOrderInfo()) {
				if(info.getOrderItemList()!=null){
					//统计总批量
					_total_unit=0;
					for (OrderItem item : info.getOrderItemList().getOrderItem()) {
						if(!item.getOrderId().equals(info.getOrderId())){
							continue;
						}
						_total_unit+=item.getQuantity()/item.getUnitQuantity();
					}
					//计算每个批量运费
					if(_total_unit>0){
						unitFreight=info.getFreight().divide(new BigDecimal(_total_unit),6,4);
						
						for (OrderItem item : info.getOrderItemList().getOrderItem()) {
							if(!item.getOrderId().equals(info.getOrderId())){
								continue;
							}
//							product=new FBAStoreProduct(item.getProductCode(), 
//									item.getQuantity()/item.getUnitQuantity(), 
//									unitFreight, 
//									info.getOrderId(), 
//									DateUtils.getDateByXMLGregorianCalendar(info.getDeliveryDate()),
//									syncTime);
							all.add(product);
						}
					}
				}
			}
		}
		return all;
	}
}
