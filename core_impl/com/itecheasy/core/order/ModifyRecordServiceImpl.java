package com.itecheasy.core.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.PageList;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.communication.order.Command2CMS;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.order.dao.ModifyRecordOrderDao;
import com.itecheasy.core.order.dao.ModifyRecordOrderItemDao;
import com.itecheasy.core.order.dao.ModifyRecordOrderViewDao;
import com.itecheasy.core.po.ModifyRecordOrderItemPO;
import com.itecheasy.core.po.ModifyRecordOrderPO;
import com.itecheasy.core.po.ModifyRecordOrderViewPO;
import com.itecheasy.core.task.BaseOrderView;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.core.util.DictUtils;
import com.itecheasy.webservice.client.CMSClient;
import com.itecheasy.webservice.client.CMSOrderClient;
import com.itecheasy.webservice.cms.User;
import com.itecheasy.webservice.cms.order.OrderModifyRecord;
import com.itecheasy.webservice.cms.order.OrderModifyRecordItem;

/**
 * @author wanghw
 * @date 2016-12-16
 * @description TODO
 * @version 1.2.2
 */
public class ModifyRecordServiceImpl implements ModifyRecordService {
	private ModifyRecordOrderItemDao modifyRecordOrderItemDao;
	private ModifyRecordOrderDao modifyRecordOrderDao;
	private IOrderSchedule orderSchedule;
	private ModifyRecordOrderViewDao modifyRecordOrderViewDao;
	private ProfileService profileService;

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setModifyRecordOrderViewDao(ModifyRecordOrderViewDao modifyRecordOrderViewDao) {
		this.modifyRecordOrderViewDao = modifyRecordOrderViewDao;
	}

	public void setOrderSchedule(IOrderSchedule orderSchedule) {
		this.orderSchedule = orderSchedule;
	}

	public void setModifyRecordOrderItemDao(ModifyRecordOrderItemDao modifyRecordOrderItemDao) {
		this.modifyRecordOrderItemDao = modifyRecordOrderItemDao;
	}

	public void setModifyRecordOrderDao(ModifyRecordOrderDao modifyRecordOrderDao) {
		this.modifyRecordOrderDao = modifyRecordOrderDao;
	}

	@Override
	public int addModifyRecordOrder(ModifyRecordOrder order, List<ModifyRecordOrderItem> modifyRecordOrderItems) {
		order.setBussinessId(order.getId());
		ModifyRecordOrderPO po = BeanUtils.copyProperties(order, ModifyRecordOrderPO.class, new String[] { "id" });
		int modifyId = modifyRecordOrderDao.addObject(po);
		
		for (ModifyRecordOrderItem modifyRecordOrderItem : modifyRecordOrderItems) {
			ModifyRecordOrderItemPO itemPO = BeanUtils.copyProperties(modifyRecordOrderItem,
					ModifyRecordOrderItemPO.class, new String[] { "id" });
			itemPO.setModifyRecordOrderId(modifyId);

			modifyRecordOrderItemDao.addObject(itemPO);
		}
		return modifyId;
	}

	@Override
	public void confirmModifyRecordOrder(int modifyRecordOrderId, int operator, String remark) {
		ModifyRecordOrderPO modifyRecordOrder = modifyRecordOrderDao.getObject(modifyRecordOrderId);
		List<ModifyRecordOrderItemPO> modifyRecordOrderItems = getModifyRecordOrderItemPOs(modifyRecordOrderId);
		BaseOrderView order= orderSchedule.getOrderByCode(modifyRecordOrder.getOrderCode());
		if (order == null)
			return;
		
		boolean canNotConfirm=false;
		//2017-07-28 cms变动-->统计新数量
		for (ModifyRecordOrderItemPO item : modifyRecordOrderItems) {
			item.setNewValue(calcNewValue(order, BeanUtils.copyProperties(item, ModifyRecordOrderItem.class)));
			if(Double.valueOf(item.getNewValue())<0){
				if(operator!=0){
					BaseOrderItem orderItem= orderSchedule.getInstance(order.getTableType()).getOrderItem(order.getId(), item.getProductId());
					throw new BussinessException((orderItem!=null?orderItem.getCmsProductCode():"")+"原订购量<无法处理数，不能确认变更单！");
				}
				//2017-07-28 cms变动-->如果新数量为负数，变跟单自动无法处理
				canNotConfirm=true;
			}
		}
		
		if (canNotConfirm) {//无法处理
			enableProcessModifyRecord(modifyRecordOrderId, operator, remark);
			return;
		}
		
		for (ModifyRecordOrderItemPO item : modifyRecordOrderItems) {
			if (item.getOperatorType() == 1||
					Double.valueOf(item.getNewValue()).intValue()==0) {
				// 取消订单项
				confirmModifyRecordCancelOrderProduct(modifyRecordOrder.getOrderCode(), item.getProductId(), operator);
			} else if (item.getOperatorType() == 2) {
				// 修改订购量 --cms自己修改不用通讯
				confirmModifyRecordCancelUpdateOrdered(Double.valueOf(item.getNewValue()).intValue(),modifyRecordOrder.getOrderCode(), item.getProductId(), operator);
			}
		}
		
		modifyRecordOrder.setStatus(DictUtils.ORDER_MODIFY_RECORD_STATUS_PROCESSED);
		modifyRecordOrder.setRemark(remark);
		// 确认变更单
		Command2CMS.UpdateOrderModifyRecordStatus(modifyRecordOrder.getBussinessId(), remark,
				DictUtils.ORDER_MODIFY_RECORD_STATUS_PROCESSED);
	}

	@Override
	public String calcNewValue(BaseOrderView order, ModifyRecordOrderItem item) {
		if(item.getOperatorType() == 2){
			BaseOrderItem orderItem= orderSchedule.getInstance(order.getTableType()).getOrderItem(order.getId(), item.getProductId());
			if (orderItem == null)
				return item.getNewValue();
			
			double qty=orderItem.getOrderQty()*orderItem.getUnitQty()-(item.getModifyQty()==null ?0:item.getModifyQty());
			
			if(qty==0||qty%(int)qty==0){
				return (int)qty+"";
			}
			return qty+"";
		}
		
		return "0";
	}

	@Override
	public void enableProcessModifyRecord(int modifyRecordOrderId, int operator, String remark) {
		ModifyRecordOrderPO order = modifyRecordOrderDao.getObject(modifyRecordOrderId);
		order.setStatus(DictUtils.ORDER_MODIFY_RECORD_STATUS_NOT_PROCESS);
		order.setRemark(remark);
		// 确认变更单
		Command2CMS.UpdateOrderModifyRecordStatus(order.getBussinessId(), remark,
				DictUtils.ORDER_MODIFY_RECORD_STATUS_NOT_PROCESS);
		
		 BaseOrderView view= orderSchedule.getOrderByCode(order.getOrderCode());
		 if(view!=null){
			 orderSchedule.getInstance(view.getTableType()).addOrderOperateLog("无法处理变更单:"+order.getCode(),
					 profileService.getUserNameById(operator), view.getId());
		 }
	}

	@Override
	public ModifyRecordOrderVO findModifyRecordOrderVO(ModifyRecordOrderForm form) {
		StringBuilder sql=new StringBuilder();
		StringBuilder where=new StringBuilder();
		List<Object> params=new ArrayList<Object>();
		sql.append(" SELECT * FROM v_modify_record_order v  ");
		if(form.getCreateTimeBegin()!=null){
			where.append(" and create_date>=? ");
			params.add(DateUtils.getRealDate(form.getCreateTimeBegin()));
		}
		if(form.getCreateTimeEnd()!=null){
			where.append(" and create_date<=? ");
			params.add(DateUtils.getFullDate(form.getCreateTimeEnd()));
		}
		if(form.getStatus()>-1){
			where.append(" AND  status=? ");
			params.add(form.getStatus());
		}
		if(form.getMerchandiserId()>-1){
			where.append(" AND  user_id=? ");
			params.add(form.getMerchandiserId());
		}
		
		if(StringUtils.isNotEmpty(form.getCreateUserName())){
			where.append(" AND  creator LIKE ? ");
			params.add("%"+form.getCreateUserName()+"%");
		}
		if(StringUtils.isNotEmpty(form.getModifyRecordCode())){
			where.append(" AND  code LIKE ? ");
			params.add("%"+form.getModifyRecordCode()+"%");
		}
		if(StringUtils.isNotEmpty(form.getOrderCode())){
			where.append(" AND  order_code LIKE ? ");
			params.add("%"+form.getOrderCode()+"%");
		}
		
		if(StringUtils.isNotEmpty(form.getProductCode())){
			where.append(" AND  EXISTS (SELECT top 1 1 FROM dbo.modify_record_order_item oi WHERE oi.modify_record_order_id=v.id AND oi.product_code=?) ");
			params.add(form.getProductCode());
		}
		PageList<ModifyRecordOrderViewPO> pl=modifyRecordOrderViewDao.findPageListBySql(form.getCurrentPage(), 
				form.getPageSize(), 
				sql.toString(), where.toString(), " create_date desc ", params);
		if(pl!=null){
			ModifyRecordOrderVO vo=new ModifyRecordOrderVO();
			vo.setModifyRecordOrders(BeanUtils.copyList(pl.getData(),ModifyRecordOrder.class));
			vo.setPage(pl.getPage());
			return vo;
		}
		return null;
	}

	@Override
	public ModifyRecordOrder getModifyRecordOrder(int modifyRecordOrderId) {
		return BeanUtils.copyProperties(modifyRecordOrderDao.getObject(modifyRecordOrderId),ModifyRecordOrder.class);
	}

	@Override
	public ModifyRecordOrder getModifyRecordOrderByCode(String code) {
		String hql="from ModifyRecordOrderPO where code=?";
		return BeanUtils.copyProperties(modifyRecordOrderDao.findByHql(hql,code),ModifyRecordOrder.class);
	}

	@Override
	public ModifyRecordOrder getModifyRecordOrderByBussiness(int BussinessId) {
		String hql="from ModifyRecordOrderPO where bussinessId=?";
		return BeanUtils.copyProperties(modifyRecordOrderDao.findByHql(hql,BussinessId),ModifyRecordOrder.class);
	}

	@Override
	public List<ModifyRecordOrderItem> getModifyRecordOrderItems(int modifyRecordOrderId) {
		List<ModifyRecordOrderItem> items=BeanUtils.copyList(getModifyRecordOrderItemPOs(modifyRecordOrderId), ModifyRecordOrderItem.class);
		return items;
	}
	
	private List<ModifyRecordOrderItemPO> getModifyRecordOrderItemPOs(int modifyRecordOrderId) {
		String hql="from ModifyRecordOrderItemPO where modifyRecordOrderId=?";
		return modifyRecordOrderItemDao.findListByHql(hql,modifyRecordOrderId);
	}


	private ModifyRecordOrder copyOrderModifyRecord(OrderModifyRecord cmsModify) {
		ModifyRecordOrder order = BeanUtils.copyProperties(cmsModify, ModifyRecordOrder.class,
				new String[] { "createTime" });
		order.setCreateTime(DateUtils.getDateByXMLGregorianCalendar(cmsModify.getCreateTime()));
		User u= CMSClient.getUserbyId(cmsModify.getCreateUserId());
		if(u!=null){
			order.setCreateUserName(u.getName());
		}else{
			order.setCreateUserName("系统");
		}
		return order;
	}

	@Override
	public void syncModifyRecordOrder(int ObjectId, Integer type) {
		OrderModifyRecord cmsModify = CMSOrderClient.getOrderModifyRecordById(ObjectId);
		if (type.equals(1)) {
			// 添加
			if (cmsModify != null) {
				ModifyRecordOrder exist = getModifyRecordOrderByBussiness(ObjectId);
				int modifyRecordOrderId;
				if (exist == null) {
					List<OrderModifyRecordItem> items = CMSOrderClient.getOrderModifyRecords(cmsModify.getId());
					ModifyRecordOrder order = copyOrderModifyRecord(cmsModify);

					List<ModifyRecordOrderItem> modifyRecordOrderItems = BeanUtils.copyList(items,
							ModifyRecordOrderItem.class);
					modifyRecordOrderId = addModifyRecordOrder(order, modifyRecordOrderItems);
				} else {
					modifyRecordOrderId = exist.getId();
				}

				// fba清点自动确认变更单
				if (cmsModify.getType() == 3&&cmsModify.getStatus()==DictUtils.ORDER_MODIFY_RECORD_STATUS_COMMITTED) {
					confirmModifyRecordOrder(modifyRecordOrderId, 0, "自动确认变更单");
				}
			}
		} else if (type.equals(2)) {
			// 删除
			ModifyRecordOrder exist = getModifyRecordOrderByBussiness(ObjectId);
			if (exist != null)
				modifyRecordOrderDao.deleteObjectById(exist.getId());
		} else if (type.equals(3)) {
			// 无法处理
			ModifyRecordOrder exist = getModifyRecordOrderByBussiness(ObjectId);
			if (exist != null) {
				ModifyRecordOrderPO order = modifyRecordOrderDao.getObject(exist.getId());
				order.setStatus(DictUtils.ORDER_MODIFY_RECORD_STATUS_NOT_PROCESS);
				if (cmsModify != null) {
					order.setRemark(cmsModify.getRemark());
				}

				modifyRecordOrderDao.mergeObject(order);
			}
		}

	}

	private void confirmModifyRecordCancelOrderProduct(String orderCode, int cmsProductId, int operator) {
		BaseOrderView order= orderSchedule.getOrderByCode(orderCode);
		if (order == null)
			return;

		BaseOrderItem item= orderSchedule.getInstance(order.getTableType()).getOrderItem(order.getId(), cmsProductId);
		if (item == null)
			return;
		
		orderSchedule.getInstanceMessage(order.getTableType()).autoCancelOrderProducts(order.getId(), operator == 0 ? "自动确认变更单" 
				: profileService.getUserNameById(operator),
				item.getId());
	}

	private void confirmModifyRecordCancelUpdateOrdered(int newValue,String orderCode, int cmsProductId,
			int operator) {
		BaseOrderView order= orderSchedule.getOrderByCode(orderCode);
		if (order == null)
			return;

		BaseOrderItem item= orderSchedule.getInstance(order.getTableType()).getOrderItem(order.getId(), cmsProductId);
		if (item == null)
			return;
		
		orderSchedule.getInstanceMessage(order.getTableType()).autoUpdateOrderProductsOrderedQuantity(item.getId(), operator == 0 ? "自动确认变更单"
				: profileService.getUserNameById(operator), 
				BigDecimal.valueOf(newValue).divide(BigDecimal.valueOf(item.getUnitQty()),2,4).doubleValue());
	}
	
	@Override
	public List<String> getModifyCreator() {
		return modifyRecordOrderDao.getSimpleColumnBySql("SELECT DISTINCT creator FROM dbo.modify_record_order WITH(NOLOCK)", null);
	}
	
}
