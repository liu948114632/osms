package com.itecheasy.core.order;

import java.util.List;

import com.itecheasy.core.BussinessException;
import com.itecheasy.core.task.BaseOrderView;

/** 
 * @author wanghw
 * @date 2016-12-1 
 * @description 变跟单
 * @version 1.2.2 大概处理
 */
public interface ModifyRecordService {
	/**
	 * 同步变更单
	 * @param order
	 * @param modifyRecordOrderItems
	 */
	void syncModifyRecordOrder(int ObjectId,Integer type);
	
	/**
	 * 新增变更单
	 * @param order
	 * @param modifyRecordOrderItems
	 */
	int addModifyRecordOrder(ModifyRecordOrder order,List<ModifyRecordOrderItem> modifyRecordOrderItems);
	
	/**
	 * 查询变更单
	 * @param code
	 * @return
	 */
	ModifyRecordOrder getModifyRecordOrderByCode(String code);
	
	ModifyRecordOrder getModifyRecordOrderByBussiness(int BussinessId);
	
	/**
	 * 确认变更单
	 * @param modifyRecordOrderId
	 * @param operator
	 */
	void confirmModifyRecordOrder(int modifyRecordOrderId,int operator,String remark);
	
	String calcNewValue(BaseOrderView order, ModifyRecordOrderItem item);
	
	/**
	 * 无法处理
	 * @param modifyRecordOrderId
	 * @param operator
	 */
	void enableProcessModifyRecord(int modifyRecordOrderId,int operator,String remark);
	
	/**
	 * 查询变更单
	 * @param modifyRecordOrderId
	 * @return
	 */
	ModifyRecordOrder getModifyRecordOrder(int modifyRecordOrderId);

	List<ModifyRecordOrderItem> getModifyRecordOrderItems(int modifyRecordOrderId);
	
	ModifyRecordOrderVO findModifyRecordOrderVO(ModifyRecordOrderForm form);
	
	List<String> getModifyCreator();
}
