package com.itecheasy.core.task;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.quartz.CronExpression;

import com.itecheasy.core.operation.ClearInventoryTrackingService;
import com.itecheasy.core.report.AmazonReportTaskService;
import com.itecheasy.core.report.AmazonReportTaskService.ReportTaskStatus;
import com.itecheasy.core.report.ReportAutotaskRecordVO;
import com.itecheasy.core.report.ReportAutotaskShopConfigVO;

/**
 * @author taozihao
 * @date 2018年8月27日 下午2:01:13
 * @description	自动任务，后续统一管理新增的自动任务
 */
public class AutoTaskServiceImpl implements AutoTaskService {
	
	private static final Logger LOGGER = Logger.getLogger(AutoTaskServiceImpl.class);
	
	private ClearInventoryTrackingService clearInventoryTrackingService;

	public void setClearInventoryTrackingService(ClearInventoryTrackingService clearInventoryTrackingService) {
		this.clearInventoryTrackingService = clearInventoryTrackingService;
	}

	@Override
	public void updateClearInventoryTrackingIsThisWeekConcerned() {
		LOGGER.info("updateClearInventoryTrackingIsThisWeekConcerned ->> started");
		clearInventoryTrackingService.updateIsThisWeekConcerned();
		LOGGER.info("updateClearInventoryTrackingIsThisWeekConcerned ->> end");
	}

	
	private AmazonReportTaskService amazonReportTaskService;
	
	public void setAmazonReportTaskService(AmazonReportTaskService amazonReportTaskService) {
		this.amazonReportTaskService = amazonReportTaskService;
	}

	/**
	 * 增加报告自动任务的起始时间
	 */
	private static Date date = new Date();
	
	@Override
	public void autoAddReportTaskRecord() {
		Date before = DateUtils.addSeconds(date, -10);
		//Date before = DateUtils.addMinutes(date, -1);
		LOGGER.info("autoAddReportTaskRecord -----start");
		
		Date now = new Date();
		List<ReportAutotaskShopConfigVO> configList = amazonReportTaskService.getReportAutotaskShopConfigList();
		for (ReportAutotaskShopConfigVO config : configList) {
			try {
				CronExpression cronExpression = new CronExpression(config.getFrequency().trim());
				Date nextValidTimeAfter = cronExpression.getNextValidTimeAfter(before);
				if(nextValidTimeAfter.getTime()>before.getTime() && nextValidTimeAfter.getTime()<=date.getTime()){
					ReportAutotaskRecordVO recordVO = new ReportAutotaskRecordVO();
					recordVO.setFailedTimes(0);
					recordVO.setLastFireTime(null);
					recordVO.setReportType(config.getReportType());
					recordVO.setShopDevInfoId(config.getShopDevInfoId());
					recordVO.setShopId(config.getShopId());
					recordVO.setLimitDays(config.getLimitDays());
					recordVO.setStatus(ReportTaskStatus.TODO.getVal());
					recordVO.setCreateTime(now);
					amazonReportTaskService.addReportAutotaskRecord(recordVO);
				}
			} catch (ParseException e) {
				LOGGER.error("WRONG_CRON_EXPRESSION:"+config.getFrequency()+",shopId:"+config.getShopId()+"");
				e.printStackTrace();
			}
		}
		date = DateUtils.addSeconds(date, 10);
		//date = DateUtils.addMinutes(date, 1);
		LOGGER.info("autoAddReportTaskRecord ----- end");
	}

	@Override
	public void autoProcessReportTaskRecord() {
		List<ReportAutotaskRecordVO> recordList = amazonReportTaskService.getReportAutotaskRecordList();
		final HashMap<Integer, List<ReportAutotaskRecordVO>> map = new HashMap<Integer, List<ReportAutotaskRecordVO>>();
		//先按照账号分组
		for (ReportAutotaskRecordVO record : recordList) {
			if(map.get(record.getShopDevInfoId())==null){
				ArrayList<ReportAutotaskRecordVO> list = new ArrayList<ReportAutotaskRecordVO>();
				list.add(record);
				map.put(record.getShopDevInfoId(), list);
			}else{
				map.get(record.getShopDevInfoId()).add(record);
			}
		}
		final CountDownLatch countDownLatch = new CountDownLatch(map.size());
		//然后按照账号创建线程获取报告
		for (final Integer shopDevInfoId : map.keySet()) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (ReportAutotaskRecordVO reportAutotaskRecordVO : map.get(shopDevInfoId)) {
						long before = System.currentTimeMillis();
						try{
							amazonReportTaskService.downloadReportFromAmazon(reportAutotaskRecordVO.getId());
						}catch(Exception e){
							e.printStackTrace();
							LOGGER.error("REPORT DOWNLOAD ERROR SHOPID:"+reportAutotaskRecordVO.getShopId()+",REPORT_TYPE:"+reportAutotaskRecordVO.getReportType());
							LOGGER.error(e.getMessage());
						}
						//防止请求被限制
						if((System.currentTimeMillis()-before)<60*1000){
							try {
								Thread.sleep(60*1000 - (System.currentTimeMillis()-before));
							} catch (InterruptedException e) {
								LOGGER.error(e.getMessage());
								e.printStackTrace();
							}
						}
					}
					countDownLatch.countDown();
				}
			}).start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
