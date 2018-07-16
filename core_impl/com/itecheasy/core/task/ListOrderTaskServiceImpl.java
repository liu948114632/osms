package com.itecheasy.core.task;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.itecheasy.core.order.AmazonOrderService;
import com.itecheasy.core.order.EbayOrderService;
import com.itecheasy.core.order.SmtOrderService;
import com.itecheasy.core.system.ShopDevInfo;
import com.itecheasy.core.system.ShopService;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.util.SystemEnumDicts.ShopType;

/**
 * @author wanghw
 * @date 2015-5-14
 * @description TODO
 * @version
 */
public class ListOrderTaskServiceImpl implements ListOrderTaskService {
	private static final Logger LOGGER =Logger.getLogger(ListOrderTaskServiceImpl.class);
	private SystemService systemService;
	private AmazonOrderService amazonOrderService;
	private ShopService shopService;
	private EbayOrderService ebayOrderService;
	private SmtOrderService smtOrderService;
	

	public void setSmtOrderService(SmtOrderService smtOrderService) {
		this.smtOrderService = smtOrderService;
	}

	public void setEbayOrderService(EbayOrderService ebayOrderService) {
		this.ebayOrderService = ebayOrderService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setAmazonOrderService(AmazonOrderService amazonOrderService) {
		this.amazonOrderService = amazonOrderService;
	}

	@Override
	public void listOrder() {
		LOGGER.info("开始获取amazon订单");
		List<ShopDevInfo> devs=shopService.getJointAccount(ShopType.AMAZON.getVal());
		for (ShopDevInfo dev : devs) {
			Date lastUpdateTime= null;//org.apache.commons.lang.time.DateUtils.addHours(tmp, -8);
			try {
				Date updateDate = null;
				Date _select_time= null;
				lastUpdateTime= dev.getLastUpdatedAfter();
				//限制下载时间 两个小时
				if(org.apache.commons.lang.time.DateUtils.addHours(lastUpdateTime, 2).before(new Date())){
					updateDate=org.apache.commons.lang.time.DateUtils.addHours(lastUpdateTime, 2);
				}
				//转换成UTC时间
				_select_time=org.apache.commons.lang.time.DateUtils.addHours(lastUpdateTime, -8);
				LOGGER.info("开始获取"+dev.getName()+"订单");
			    updateDate = amazonOrderService.listOrders(dev.getId(),_select_time ,updateDate==null
					?updateDate:org.apache.commons.lang.time.DateUtils.addHours(updateDate, -8));
			
			    if(updateDate != null)  {
			       systemService.setLastUpdateTime(dev.getId(), updateDate);
			       LOGGER.info("获取"+dev.getName()+"完成");
			    }else{
			    	LOGGER.error("读取" + dev.getName() + "失败");
			    }
			}
			catch(Exception ex) 	{
				LOGGER.error("读取" + dev.getName() + "报错:",ex); 
//				systemService.setLastUpdateTime(dev.getId(), lastUpdateTime);
			}
			
		}
		
	}
	
	public void syncEbayOrders(){
		ebayOrderService.syncOrders();
	}
	
	@Override
	public void getOrders() {
		amazonOrderService.addOrderByLog();
	}
	
	@Override
	public void checkOrders() {
		LOGGER.info("checking order start" ); 
		amazonOrderService.autoCheckOrders();
		LOGGER.info("checking order end"); 
	}
	
	@Override
	public void downloadSmtOrder() {
		LOGGER.info("smt download order start" ); 
		smtOrderService.downloadOrder();
		LOGGER.info("smt download order end" ); 
	}
	
	@Override
	public void listSmtOrder() {
		LOGGER.info("smt listSmtOrder start" ); 
		smtOrderService.listOrder();
		LOGGER.info("smt listSmtOrder end" ); 
	}

}
