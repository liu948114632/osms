package com.itecheasy.core.task;

import org.apache.log4j.Logger;

import com.itecheasy.core.operation.ClearInventoryTrackingService;

/**
 * @author taozihao
 * @date 2018年8月27日 下午2:01:13
 * @description	自动任务，后续统一管理新增的自动任务
 */
public class AutoTaskServiceImpl implements AutoTaskService {
	
	private static Logger LOGGER = Logger.getLogger(AutoTaskServiceImpl.class);
	
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

}
