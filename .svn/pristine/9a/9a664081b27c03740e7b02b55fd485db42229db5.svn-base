package com.itecheasy.core.task;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.openapi.client.exception.OceanException;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.itecheasy.common.dao.Criteria;
import com.itecheasy.common.dao.Restriction;
import com.itecheasy.common.po.AMShopUploadFileDataPO;
import com.itecheasy.common.po.AMShopUploadFileTaskPO;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.ThreadUtils;
import com.itecheasy.core.order.IBaseOrder;
import com.itecheasy.core.order.OrderDetail;
import com.itecheasy.core.order.OrderService;
import com.itecheasy.core.order.dao.OrderDeliveryTaskDao;
import com.itecheasy.core.po.AMShopUploadLogPo;
import com.itecheasy.core.po.OrderDeliveryTaskPO;
import com.itecheasy.core.product.ShopProductService;
import com.itecheasy.core.product.dao.AMShopUploadFileDataDao;
import com.itecheasy.core.product.dao.AMShopUploadFileTaskDao;
import com.itecheasy.core.product.dao.ShopUploadLogDao;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.ShopDevInfo;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.system.SystemService.UploadType;
import com.itecheasy.core.util.DictUtils;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.core.util.SystemEnumDicts.ShopType;
import com.itecheasy.webservice.client.AliExpressClient;
import com.itecheasy.webservice.client.AmazonClient;
import com.itecheasy.webservice.client.EbayClient;
/**
 * @author wanghw
 * @date 2015-6-25
 * @description amazon上传文件任务
 * @version
 */
public class AmazonUploadFileTaskServiceImpl implements AmazonUploadFileTaskService {
	private static final Logger LOGGER = Logger.getLogger(AmazonUploadFileTaskServiceImpl.class);
	private AMShopUploadFileTaskDao amShopUploadFileTaskDao;
	private AMShopUploadFileDataDao amShopUploadFileDataDao;
	private ShopProductService shopProductService;
	private OrderDeliveryTaskDao orderDeliveryTaskDao;
	private ShopUploadLogDao shopUploadLogDao;
	private SystemService systemService;
	private OrderService orderService;
	private static int INDEX=0;
	

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setShopUploadLogDao(ShopUploadLogDao shopUploadLogDao) {
		this.shopUploadLogDao = shopUploadLogDao;
	}

	public void setOrderDeliveryTaskDao(OrderDeliveryTaskDao orderDeliveryTaskDao) {
		this.orderDeliveryTaskDao = orderDeliveryTaskDao;
	}

	public void setShopProductService(ShopProductService shopProductService) {
		this.shopProductService = shopProductService;
	}

	public void setAmShopUploadFileTaskDao(AMShopUploadFileTaskDao amShopUploadFileTaskDao) {
		this.amShopUploadFileTaskDao = amShopUploadFileTaskDao;
	}

	public void setAmShopUploadFileDataDao(AMShopUploadFileDataDao amShopUploadFileDataDao) {
		this.amShopUploadFileDataDao = amShopUploadFileDataDao;
	}

	@Override
	public void autoUploadProductFileTask() {
		List<AMShopUploadFileTaskPO> tasks = getNotCompleted();
		if (CollectionUtils.isNotEmpty(tasks)) {
			for (AMShopUploadFileTaskPO task : tasks) {
				// --
				// 是否完成ftp上传
				boolean _completed = true;
				List<AMShopUploadFileDataPO> datas = getNotCompletedData(task.getId());
				if (CollectionUtils.isNotEmpty(datas)) {
					// --1、检查图片已上传
					for (AMShopUploadFileDataPO data : datas) {
						if (shopProductService.checkPictureFTP(data.getProductId())) {
							_completed = false;
						} else {
							data.setImageUploadStatus(true);
						}
					}
				}

				// --2、完成ftp图片上传，开始商品上传
				if (_completed) {
					try {
						AMShopUploadLogPo po = shopUploadLogDao.getObject(task.getAmShopUploadLogId());
						int shopId = task.getShopId();
						// 店铺
						File txt = new File(task.getFileLocal());
						if (!txt.exists()) {
							po.setRemark("商品文件找不到，请重试!");
							po.setResult(0);
							continue;
						}

						final ShopInfo info = systemService.getShopInfo(shopId);
						final String submitSession = AmazonClient.submitFeed(shopId,
								FileUtils.readFileToByteArray(txt), "txt");
						po.setSubmitSession(submitSession);

						if (StringUtils.isEmpty(submitSession)) {
							po.setResult(0);
							po.setRemark("文件未上传到amazon，请重试!");
						} else {
							po.setResult(1);
						}
						shopUploadLogDao.mergeObject(po);

						final int id = po.getId();
						if (StringUtils.isNotEmpty(submitSession)) {
							ThreadUtils.pool.execute(new Runnable() {
								@Override
								public void run() {
									try {
										Thread.currentThread().setName("pool-1-thread-" + submitSession);
										LOGGER.info(Thread.currentThread().getName() + "------start waiting！");
										String tmp = new String(submitSession);
										TimeUnit.MINUTES.sleep(15);
										shopProductService.addAmazonLog(tmp, id, info.getShopId());
										LOGGER.info(Thread.currentThread().getName() + "-------end waiting！");
									} catch (InterruptedException e) {
										LOGGER.error(e.getMessage());
									}
								}
							});
						}

						// --3、完成一次上传任务，结束掉自动任务
						task.setStatus(1);
						amShopUploadFileTaskDao.mergeObject(task);

						return;
					} catch (Exception e) {
						continue;
					}

				}
				// --
			}
		}
	}

	private List<AMShopUploadFileTaskPO> getNotCompleted() {
		Criteria criteria = new Criteria(AMShopUploadFileTaskPO.class);
		criteria.and(Restriction.eq("type", 0));
		criteria.and(Restriction.eq("status", 0));
		return amShopUploadFileTaskDao.list(criteria);
	}

	private List<AMShopUploadFileDataPO> getNotCompletedData(int taskID) {
		Criteria criteria = new Criteria(AMShopUploadFileDataPO.class);
		criteria.and(Restriction.eq("imageUploadStatus", false));
		criteria.and(Restriction.eq("AMShopUploadFileTaskID", taskID));
		return amShopUploadFileDataDao.list(criteria);
	}

	public void autoOrderDeliveryTask() {//3:不满足条件，取消
		List<ShopDevInfo> devs=systemService.getCacheShopDevInfos();
		int _devId=devs.get(AmazonUploadFileTaskServiceImpl.INDEX++).getId();
		
		if(AmazonUploadFileTaskServiceImpl.INDEX>=devs.size())
			AmazonUploadFileTaskServiceImpl.INDEX=0;
		
		List<Integer>  shopIds=systemService.getCacheShopIdsByDevAccount(_devId);
		
		if(CollectionUtils.isEmpty(shopIds))
			return;
		
		String shopStrs=shopIds.toString();
		shopStrs=shopStrs.substring(1, shopStrs.length()-1);
		
		
		String hql = "SELECT top 1 * FROM dbo.order_delivery_task  WHERE status NOT IN (1,3) AND upload_count<4" +
				" AND shop_id IN ("+shopStrs+") ORDER BY id ASC";
		
		List<OrderDeliveryTaskPO> pos = orderDeliveryTaskDao.findListBySql(hql, null);
		if(CollectionUtils.isEmpty(pos))
			return;
		
		OrderDeliveryTaskPO po=pos.get(0);
		if (po != null) {
			// 更新amazon物流号
			LOGGER.info("自动发货任务,ID:"+po.getId());
			po.setUploadCount(po.getUploadCount() + 1);
			po.setStatus(1);
			Shop shop= systemService.getShop(po.getShopId());
			if(shop.getType()==ShopType.AMAZON.getVal())
				updateTraceCode2Amazon(po);
			else if(shop.getType()==ShopType.EBAY.getVal())
				updateTraceCode2Ebay(po);
			else if(shop.getType()==ShopType.SMT.getVal())
				updateTraceCode2Smt(po);
		}
		
	}
	
	private void updateTraceCode2Smt(OrderDeliveryTaskPO task){
		Shop shop = systemService.getShop(task.getShopId());
		String[] orderIds=task.getOrderId().split(",");
		StringBuilder sb=new StringBuilder();
		AMShopUploadLogPo logpo = null;
		try {
			for (int i = 0; i < orderIds.length; i++) {
				OrderDetail detail = orderService.getOrderDeatil(Integer.valueOf(orderIds[i]));
				if(BooleanUtils.isTrue(detail.getManual())||BooleanUtils.isTrue(detail.getCopy())||detail.getCode().contains("(")){
					sb.append("smt复制订单、手动录单").append(detail.getCode()).append("，不更新SMT对应订单的跟踪号及信息,由客服自己线下联系 ！");
					task.setStatus(3);
					continue;
				}
				sb.append("smt订单").append(detail.getCode()).append("跟踪号").append(detail.getTrackingCode()).append("；");
				AliExpressClient.delivery(systemService.getAliexpressConfigInfo(task.getShopId()),
						Long.valueOf(detail.getShopOrderCode()), 
						systemService.getSmtShippingMethod(detail.getShippingMethod()), detail.getTrackingCode(),
						"", detail.getTrackingUrl());
			}
			
			// 保存上传记录
			logpo = new AMShopUploadLogPo();
			logpo.setOperator(0);
			logpo.setType(UploadType.ORDER.ordinal());
			logpo.setShopId(shop.getId());
			logpo.setUploadTime(new Date());
			logpo.setTitle("更新订单物流跟踪号到Smt："+sb.toString());
			shopUploadLogDao.mergeObject(logpo);
		} catch (Exception e) {
			OceanException o=(OceanException) e.getCause();
//			if(o.getErrorCode().equals("15-1002")){
				StaticUtils.addEmail("SMT发货失败："+sb.toString(), o.getErrorMessage());
//			}
			if (logpo == null) {
				task.setStatus(2);
				logpo = new AMShopUploadLogPo();
				logpo.setOperator(0);
				logpo.setType(UploadType.ORDER.ordinal());
				logpo.setUploadTime(new Date());
				logpo.setShopId(task.getShopId());
				logpo.setTitle("更新订单物流跟踪号到Smt："+sb.toString());
			}
			logpo.setResult(0);
			logpo.setRemark("Exception"+e.getMessage());
			shopUploadLogDao.mergeObject(logpo);
			LOGGER.info("自动发货任务异常:"+e.getMessage());
		}
	}

	
	private void updateTraceCode2Ebay(OrderDeliveryTaskPO task){
		Shop shop = systemService.getShop(task.getShopId());
		String[] orderIds=task.getOrderId().split(",");
		StringBuilder sb=new StringBuilder();
		AMShopUploadLogPo logpo = null;
		try {
			for (int i = 0; i < orderIds.length; i++) {
				OrderDetail detail = orderService.getOrderDeatil(Integer.valueOf(orderIds[i]));
				if(BooleanUtils.isTrue(detail.getManual())||BooleanUtils.isTrue(detail.getCopy())||detail.getCode().contains("(")){
					sb.append("复制订单、手动录单").append(detail.getCode()).append("，不更新ebay对应订单的跟踪号及信息,由客服自己线下联系 ！");
					task.setStatus(3);
					continue;
				}
				//非cms备货 走自动发货 2017-05-09 bug
				//-->限制sw、cms备货的SYS_USPS，SYS_BE_MailPost
				if(detail.getCmsPrepare()!=IBaseOrder.ORDER_PREPARE_TYPE_OTHER 
						&&(detail.getShippingMethod()==DictUtils.SYS_USPS
						||detail.getShippingMethod()==DictUtils.SYS_BE_MailPost)){
					sb.append("ebay订单").append(detail.getCode()).append("的货运方式是对接APAC！");
					task.setStatus(3);
					continue;
				}
				sb.append("ebay订单").append(detail.getCode()).append("跟踪号").append(detail.getTrackingCode()).append("；");
				EbayClient.delivery(systemService.getEbayApiAccount(task.getShopId()),
						detail.getShopOrderId(), 
						detail.getShopOrderLineItemId(), 
						detail.getDeliveryDate(), 
						detail.getTrackingCode(),
						systemService.getEbayShippingMethod(detail.getShippingMethod()));
			}
			
			// 保存上传记录
			logpo = new AMShopUploadLogPo();
			logpo.setOperator(0);
			logpo.setType(UploadType.ORDER.ordinal());
			logpo.setShopId(shop.getId());
			logpo.setUploadTime(new Date());
			logpo.setTitle("更新订单物流跟踪号到Ebay："+sb.toString());
			shopUploadLogDao.mergeObject(logpo);
		} catch (Exception e) {
			if (logpo == null) {
				task.setStatus(2);
				logpo = new AMShopUploadLogPo();
				logpo.setOperator(0);
				logpo.setType(UploadType.ORDER.ordinal());
				logpo.setUploadTime(new Date());
				logpo.setShopId(task.getShopId());
				logpo.setTitle("更新订单物流跟踪号到Ebay："+sb.toString());
			}
			logpo.setResult(0);
			if(e instanceof ApiException){
				logpo.setRemark("ApiException"+e.getMessage());
			}else if(e instanceof SdkException){
				logpo.setRemark("SdkException"+e.getMessage());
			}else{
				logpo.setRemark("Exception"+e.getMessage());
			}
			shopUploadLogDao.mergeObject(logpo);
			LOGGER.info("自动发货任务异常:"+e.getMessage());
		}
	}

	private void updateTraceCode2Amazon(OrderDeliveryTaskPO task) {
		Shop shop = systemService.getShop(task.getShopId());
		String[] orderIds=task.getOrderId().split(",");
		List<OrderDetail> details=new ArrayList<OrderDetail>();
		StringBuilder sb=new StringBuilder();
		
		for (int i = 0; i < orderIds.length; i++) {
			if (StringUtils.isEmpty(orderIds[i]) ){
				continue;
			}
			OrderDetail detail = orderService.getOrderDeatil(Integer.valueOf(orderIds[i]));
			if(BooleanUtils.isTrue(detail.getManual())||BooleanUtils.isTrue(detail.getCopy())
					||detail.getCode().contains("(")){
				sb.append("复制订单、手动录单").append(detail.getCode()).append("，不更新amazon对应订单的跟踪号及信息,由客服自己线下联系 ！");
				task.setStatus(3);
				continue;
			}
			sb.append("订单").append(detail.getCode()).append("跟踪号").append(detail.getTrackingCode()).append("；");
			if (!details.contains(detail)) {
				details.add(detail);
			}
		}
		
		final ShopInfo info = systemService.getShopInfo(task.getShopId());
		AMShopUploadLogPo logpo = null;
		if(details.size()>0){
			final String submitSession = AmazonClient.updateTraceCode(task.getShopId(), details,
					info.getTimeDiff() == null ? 0 : info.getTimeDiff());
			final String title=sb.toString();
//			final int shopId=task.getShopId();
			try {
				// 保存上传记录
				logpo = new AMShopUploadLogPo();
				logpo.setSubmitSession(submitSession);
				logpo.setOperator(0);
				logpo.setType(UploadType.ORDER.ordinal());
				logpo.setShopId(shop.getId());
				logpo.setUploadTime(new Date());
				logpo.setTitle("更新订单物流跟踪号到AMAZON："+title);
				if (StringUtils.isEmpty(submitSession)) {
					logpo.setResult(1);
					logpo.setRemark("文件未上传到amazon，请重试!");
					LOGGER.info("自动发货任务失败:submitSession为空");
					task.setStatus(2);
					if (task.getUploadCount()>3) {
						StaticUtils.addEmail("amazon订单发货失败,超过3次", title);
					}
					orderDeliveryTaskDao.mergeObject(task);
				} else {
					logpo.setResult(1);
				}
				shopUploadLogDao.mergeObject(logpo);
				/*final Integer id = logpo.getId();
			if (StringUtils.isNotEmpty(submitSession)) {
				final int taskId = task.getId();
				ThreadUtils.pool.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.currentThread().setName("pool-1-thread-" + submitSession);
							LOGGER.debug(Thread.currentThread().getName() + "------start waiting！");
							String tmp = new String(submitSession);
							TimeUnit.MINUTES.sleep(50);
							addAmazonLog(tmp, id, shopId, taskId,title);
							LOGGER.debug(Thread.currentThread().getName() + "-------end waiting！");
						} catch (InterruptedException e) {
							LOGGER.error(e.getMessage());
						}
					}
				});
			}*/
				
			} catch (Exception e) {
				if (logpo == null) {
					logpo = new AMShopUploadLogPo();
					logpo.setOperator(0);
					logpo.setType(UploadType.ORDER.ordinal());
					logpo.setTitle("更新订单物流跟踪号到AMAZON："+title);
					logpo.setUploadTime(new Date());
					logpo.setShopId(task.getShopId());
				}
				logpo.setResult(0);
				logpo.setRemark(e.getMessage());
				shopUploadLogDao.mergeObject(logpo);
				LOGGER.info("自动发货任务异常:"+e.getMessage());
			}
		}
	}

//	private void addAmazonLog(String sessionId, int id, int shopId, int taskId,String title) {
//		LOGGER.info(Thread.currentThread().getName() + "getResultBySessionId-------->>start working! delivery");
//		String hql = "from AMShopUploadLogPo where submitSession=? and id=?";
//		AMShopUploadLogPo po = shopUploadLogDao.findByHql(hql, new Object[] { sessionId, id });
//		if (po == null) {
//			return;
//		}
//		//对象等待？无法更新结果？2016年3月11日17:31:30
////		OrderDeliveryTaskPO task = orderDeliveryTaskDao.getObject(taskId);
//		
//		String result = AmazonClient.getResultBySessionId(shopId, sessionId);
//		LOGGER.info(Thread.currentThread().getName() + "getResultBySessionId-------->>result： "+result);
//		if (StringUtils.isNotEmpty(result) && result.length() > 100) {
//			po.setResult(0);
////			task.setStatus(2);
////			if (task.getUploadCount()>100) {
////				StaticUtils.addEmail("amazon订单发货失败,超过100次", title);
////			}
////			orderDeliveryTaskDao.mergeObject(task);
//		}
//		po.setRemark(result);
//		shopUploadLogDao.mergeObject(po);
//		LOGGER.info(Thread.currentThread().getName() + "getResultBySessionId-------->>end working! delivery");
//	}

}
