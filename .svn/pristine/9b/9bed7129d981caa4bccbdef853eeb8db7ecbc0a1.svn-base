package com.itecheasy.core.order;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.itecheasy.common.PageList;
import com.itecheasy.common.Param;
import com.itecheasy.common.attachment.AttachmentService;
import com.itecheasy.common.sysconfig.SysConfigService;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.common.util.SqlUtil;
import com.itecheasy.common.util.StringUtils;
import com.itecheasy.communication.order.CommandOrderTracking2CMS;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.ReplenishmentOrderService;
import com.itecheasy.core.order.dao.OrderTrackingDao;
import com.itecheasy.core.order.dao.OrderTrackingItemDao;
import com.itecheasy.core.order.dao.OrderTrackingLogDao;
import com.itecheasy.core.order.dao.OrderTrackingProductAttachmentDao;
import com.itecheasy.core.order.dao.OrderTrackingProductDao;
import com.itecheasy.core.po.OrderTrackingItemPO;
import com.itecheasy.core.po.OrderTrackingLogPO;
import com.itecheasy.core.po.OrderTrackingPO;
import com.itecheasy.core.po.OrderTrackingProductAttachmentPO;
import com.itecheasy.core.po.OrderTrackingProductPO;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.webservice.client.CMSOrderClient;

/**
 * @author whw
 * @date 2017-8-17
 * @description TODO
 * @version
 */
public class OrderTrackingServiceImpl implements OrderTrackingService {
	protected static final String ORDER_TRACE_ATTACHMENT = "ORDER_TRACE_ATTACHMENT";
	protected static final String ORDER_TRACKING_ATTACHMENT = "ORDER_TRACKING_ATTACHMENT";
	protected OrderTrackingDao orderTrackingDao;
	protected OrderTrackingProductDao orderTrackingProductDao;
	protected OrderTrackingLogDao orderTrackingLogDao;
	protected OrderTrackingItemDao orderTrackingItemDao;
	protected OrderTrackingProductAttachmentDao orderTrackingProductAttachmentDao;
	protected CommandOrderTracking2CMS commandOrderTracking2CMS;
	protected AttachmentService attachmentService;
	protected OrderService orderService;
	protected SysConfigService sysConfigService;
	protected ReplenishmentOrderService replenishmentOrderService;
	protected SystemService systemService;
	protected IOrderSchedule orderSchedule;;
	private ProfileService profileService;

	
	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setOrderSchedule(IOrderSchedule orderSchedule) {
		this.orderSchedule = orderSchedule;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setSysConfigService(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}

	public void setReplenishmentOrderService(ReplenishmentOrderService replenishmentOrderService) {
		this.replenishmentOrderService = replenishmentOrderService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setAttachmentService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}

	public void setCommandOrderTracking2CMS(CommandOrderTracking2CMS commandOrderTracking2CMS) {
		this.commandOrderTracking2CMS = commandOrderTracking2CMS;
	}

	public void setOrderTrackingDao(OrderTrackingDao orderTrackingDao) {
		this.orderTrackingDao = orderTrackingDao;
	}

	public void setOrderTrackingProductDao(OrderTrackingProductDao orderTrackingProductDao) {
		this.orderTrackingProductDao = orderTrackingProductDao;
	}

	public void setOrderTrackingLogDao(OrderTrackingLogDao orderTrackingLogDao) {
		this.orderTrackingLogDao = orderTrackingLogDao;
	}

	public void setOrderTrackingItemDao(OrderTrackingItemDao orderTrackingItemDao) {
		this.orderTrackingItemDao = orderTrackingItemDao;
	}

	public void setOrderTrackingProductAttachmentDao(OrderTrackingProductAttachmentDao orderTrackingProductAttachmentDao) {
		this.orderTrackingProductAttachmentDao = orderTrackingProductAttachmentDao;
	}

	@Override
	public void setOrderTracking(OrderTracking orderTracking, int operator) throws BussinessException {
		if (orderTracking.getId() > 0) {
			updateOrderTracking(orderTracking, operator);

			if (orderTracking.isFormCMS()) {
				updateOrderTrackingReplyInfo(orderTracking.getId(), orderTracking.getReplyContent(),
						orderTracking.getReplyUserId(), new Date(), orderTracking.getRemark(),
						orderTracking.getStatus());

				for (OrderTrackingProduct product : orderTracking.getProducts()) {
					addOrderTrackingAttachments(product.getId(), orderTracking.getId(), product.getAttachments());
				}
				commandOrderTracking2CMS.replyOrderTrackingToCMS(getOrderTrackingDetail(orderTracking.getId()), operator);
			} else {
				commandOrderTracking2CMS.addOrderTrackingToCMS(getOrderTrackingDetail(orderTracking.getId()), operator, false);
			}

		} else {
			orderTracking.setRead(true);   //默认状态为已读 isRead
			addOrderTracking(orderTracking, operator);
		}

	}

	private void addOrderTrackingAttachments(int orderTrackingProductId, int orderTrackingId,
			List<OrderTrackingProductAttachment> attachments) {
		if(attachments==null)
			return;
		for (OrderTrackingProductAttachment atta : attachments) {
			if (atta.getId() == 0) {

				OrderTrackingProductAttachmentPO po = BeanUtils.copyProperties(atta,
						OrderTrackingProductAttachmentPO.class);
				File tempFile = new File(DeployProperties.getInstance().getProperty("temp_dir")
						+ ORDER_TRACKING_ATTACHMENT + "\\" + atta.getOriginalFileName());

				try {
					FileUtils.writeByteArrayToFile(tempFile, atta.getFiles());
					String UUID = attachmentService.addAttachment(ORDER_TRACKING_ATTACHMENT,
							String.valueOf(orderTrackingProductId), atta.getOriginalFileName(), null, tempFile);
					
					po.setOrderTrackingId(orderTrackingId);
					po.setOrderTrackingProductId(orderTrackingProductId);
					po.setJoinDate(new Date());
					po.setFileCode(UUID);
					
					orderTrackingProductAttachmentDao.addObject(po);
				} catch (IOException e) {
					
				}
			}

		}
	}

	protected String saveAttachment(int orderTrackingProductId,String fileName, String fileCode) {
		try {
			byte[] files=CMSOrderClient.getAttachmentByCode(fileCode);
			File tempFile = new File(DeployProperties.getInstance().getProperty("temp_dir") + ORDER_TRACKING_ATTACHMENT
					+ "\\" + fileName);
			FileUtils.writeByteArrayToFile(tempFile, files);
			String UUID = attachmentService.addAttachment(ORDER_TRACKING_ATTACHMENT, String.valueOf(orderTrackingProductId),
					fileName, null, tempFile);
			return UUID;
		} catch (IOException e) {

		}catch (Exception e) {
			
		}
		return null;
	}

	private void addOrderTracking(OrderTracking orderTracking, int operator) {
		String log = "";
		orderTracking.setCode(createOrderCode());
		orderTracking.setConsultationTime(new Date());
		orderTracking.setStatus(OrderTrackingStatus.未答复.getVal());
		OrderTrackingPO po = BeanUtils.copyProperties(orderTracking, OrderTrackingPO.class, new String[] { "products",
				"items" });

		int orderTrackingId = this.orderTrackingDao.addObject(po);
		log += "添加订单跟踪：" + orderTracking.getCode() + ";添加跟踪商品:";
		for (OrderTrackingProduct product : orderTracking.getProducts()) {
			addOrderTrackingProduct(orderTrackingId, product, operator);
			log += product.getCmsProductCode() + ";";
		}
		addOrderTrackingHistory(orderTrackingId, log, operator);
		commandOrderTracking2CMS.addOrderTrackingToCMS(orderTracking, operator, true);
	}

	public void addOrderTrackingProduct(int orderTrackingId, OrderTrackingProduct product, int operator) {
		product.setOrderTrackingId(orderTrackingId);
		product.setStatus(OrderTrackingStatus.未答复.getVal());
		OrderTrackingProductPO po = BeanUtils.copyProperties(product, OrderTrackingProductPO.class);
		Integer id = this.orderTrackingProductDao.addObject(po);
		addOrderTrackingAttachments(id, orderTrackingId, product.getAttachments());
	}

	private String createOrderCode() {
		List<Param> parameters = new ArrayList<Param>();
		parameters.add(new Param("Code", ""));
		String object = orderTrackingDao.execStoredProcedure4output("[dbo].[Order_OrderIdBuild_order_tracking]",
				parameters);
		if (object != null) {
			return object.toString();
		}
		return null;
	}

	private void updateOrderTrackingReplyInfo(OrderTracking tacking, int operatorId) {
		updateOrderTrackingReplyInfo(tacking.getId(), tacking.getReplyContent(), tacking.getReplyUserId(), new Date(),
				tacking.getRemark(), tacking.getStatus());
	}

	public void updateOrderTrackingReplyInfo(int orderTrackingId, String content, int replyUserId, Date replyTime,
			String remark, int status) {

		OrderTrackingPO po = this.orderTrackingDao.getObject(orderTrackingId);

		po.setStatus(status);
		po.setReplyUserId(replyUserId);
		po.setReplyContent(content);
		po.setReplyDate(replyTime);
		po.setRemark(remark);
		orderTrackingDao.updateObject(po);
	}

	public void updateOrderTracking(OrderTracking orderTracking, boolean isSave, int operatorId) {
		OrderTrackingPO po = this.orderTrackingDao.getObject(orderTracking.getId());
		if (isSave){// 保存只保存备注
			po.setRemark(orderTracking.getRemark());
			commandOrderTracking2CMS.setOrderTrackingRemark(orderTracking.getCode(), operatorId, po.getRemark());
		} else {
			updateOrderTrackingReplyInfo(orderTracking, operatorId);
			addOrderTrackingItem(orderTracking.getId(), orderTracking.getReplyContent(), operatorId, new Date());
			commandOrderTracking2CMS.replyOrderTrackingToCMS(getOrderTrackingDetail(orderTracking.getId()), operatorId);
		}

	}

	/**
	 * 订单跟踪回复详细
	 * 
	 * @param orderTrackingId
	 * @param replyContent
	 * @param operatorId
	 * @param replyDate
	 */
	protected void addOrderTrackingItem(int orderTrackingId, String replyContent, int operatorId, Date replyDate) {
		OrderTrackingItemPO po = new OrderTrackingItemPO();
		po.setContent(replyContent);
		po.setOrderTrackingId(orderTrackingId);
		po.setReplyUserId(operatorId);
		po.setReplyDate(replyDate);

		orderTrackingItemDao.addObject(po);
	}

	private void updateOrderTracking(OrderTracking tracking, int operatorId) {
		String addLog = "", updateLog = "", deleteLog = "";
		List<OrderTrackingProductPO> productList = getOrderTrackingProductByOrderTrackingId(tracking.getId());

		for (OrderTrackingProduct product : tracking.getProducts()) {
			if (product.getId() == 0) {
				addOrderTrackingProduct(tracking.getId(), product, operatorId);
				if (addLog.length() == 0)
					addLog += "添加跟踪商品:";
				addLog += product.getCmsProductCode() + ";";
			} else {
				for (OrderTrackingProductPO oldProduct : productList) {
					if (oldProduct.getId() == product.getId()) {
						if (!oldProduct.getConsultationContent().equals(product.getConsultationContent())) {
							updateLog += MessageFormat.format("修改跟踪商品{0}咨询内容{1}=>{2}", product.getCmsProductCode(),
									oldProduct.getConsultationContent(), product.getConsultationContent());
							updateLog += ";";
							oldProduct.setStatus(product.getStatus());
							oldProduct.setConsultationContent(product.getConsultationContent());
							oldProduct.setReplyDate(product.getReplyDate());
						}
						if (!StringUtils.convertEmptyStringOfNull(oldProduct.getBranchRemark()).equals(
								StringUtils.convertEmptyStringOfNull(product.getBranchRemark()))) {
							updateLog += MessageFormat.format("修改跟踪商品{0}采购跟单备注{1}=>{2}", product.getCmsProductCode(),
									oldProduct.getBranchRemark(), product.getBranchRemark());
							updateLog += ";";
							oldProduct.setStatus(product.getStatus());
							oldProduct.setBranchRemark(product.getBranchRemark());
							oldProduct.setReplyDate(product.getReplyDate());
						}
						if (oldProduct.isDeleted() != product.isDeleted()) {
							if (deleteLog.length() == 0)
								deleteLog += "删除跟踪商品:";
							deleteLog += product.getCmsProductCode() + ";";
							oldProduct.setDeleted(product.isDeleted());
						}
						break;
					}
				}
			}
		}
		this.orderTrackingProductDao.mergeObject(productList);
		if ((addLog.length() + updateLog.length() + deleteLog.length()) > 0)
			addOrderTrackingHistory(tracking.getId(), addLog + updateLog + deleteLog, operatorId);
		checkOrderTrackingAlreadyReply(tracking.getId(),operatorId);
	}

	/**
	 * 更新订单跟踪为已答复
	 * 
	 * @param orderTrackingId
	 */
	public void updateOrderTrackingReply(int orderTrackingId) {
		OrderTrackingPO po = this.orderTrackingDao.getObject(orderTrackingId);
		po.setStatus(OrderTrackingStatus.已答复.getVal());
		addOrderTrackingHistory(orderTrackingId, "跟踪商品全部已答复，更新订单跟踪状态为已答复", 0);

		orderTrackingDao.updateObject(po);
	}

	/**
	 * 检查订单跟踪商品是否全部已回复(排除删除状态的)，如果全部恢复，修改订单跟踪状态为已回复
	 * 
	 * @param orderTrackingId
	 */
	protected void checkOrderTrackingAlreadyReply(int orderTrackingId,int operator) {
		String hql="from OrderTrackingProductPO where deleted=false and status =10 and orderTrackingId=?";
		
		if(CollectionUtils.isEmpty(orderTrackingProductDao.findListByHql(hql, orderTrackingId))){
			OrderTrackingPO po=this.orderTrackingDao.getObject(orderTrackingId);
			po.setStatus(OrderTrackingStatus.已答复.getVal());
			addOrderTrackingHistory(orderTrackingId, "跟踪商品全部已答复，更新订单跟踪状态为已答复", operator);
			this.orderTrackingDao.updateObject(po);
		}
	}

	private List<OrderTrackingProductPO> getOrderTrackingProductByOrderTrackingId(int orderTrackingId) {
		String hql = "from OrderTrackingProductPO where orderTrackingId =? ";
		return BeanUtils.copyList(orderTrackingProductDao.findListByHql(hql, orderTrackingId),
				OrderTrackingProductPO.class);
	}

	public void addOrderTrackingHistory(int orderTrackId, String content, int operatorId) {
		addOrderTrackingHistory(orderTrackId, content, operatorId, new Date());
	}

	public void addOrderTrackingHistory(int orderTrackId, String content, int operatorId, Date createTime) {
		OrderTrackingLogPO po = new OrderTrackingLogPO();
		po.setOperator(operatorId);
		po.setOrderTrackingId(orderTrackId);
		po.setOperateDate(createTime);
		po.setRemark(content);

		orderTrackingLogDao.addObject(po);
	}

	public void addOrderTrackingHistory(String orderTrackCode, String content, int operatorId) {

	}

	@Override
	public void deleteOrderTracking(int[] orderTrackingIds, int operator) throws BussinessException {
		List<String> code=new ArrayList<String>();
		for (int orderTrackingId : orderTrackingIds) {
			OrderTrackingPO po = orderTrackingDao.getObject(orderTrackingId);
			if (po.getStatus() != OrderTrackingStatus.未答复.getVal())
				throw new BussinessException("只能删除未答复状态的订单跟踪！");
			po.setDeleted(true);
			code.add(po.getCode());
			addOrderTrackingHistory(orderTrackingId, "删除订单跟踪", operator);
			orderTrackingDao.updateObject(po);
		}
		
		commandOrderTracking2CMS.deleteOrderTrackingByIdToCMS(code);
	}

	@Override
	public void completeOrderTracking(int[] orderTrackingIds, int operator) throws BussinessException {
		List<String> code=new ArrayList<String>();
		for (int orderTrackingId : orderTrackingIds) {
			OrderTrackingPO po = orderTrackingDao.getObject(orderTrackingId);
			if (po.getStatus() != OrderTrackingStatus.已答复.getVal())
				throw new BussinessException("只完成已答复状态的订单跟踪！");
			code.add(po.getCode());
			po.setStatus(OrderTrackingStatus.完成.getVal());
			addOrderTrackingHistory(orderTrackingId, "完成订单跟踪", operator);
			orderTrackingDao.updateObject(po);
		}
		
		commandOrderTracking2CMS.completeOrderTrackingToCMS(code);
	}

	@Override
	public void updateOrderTrackingConsultationUser(int orderTrackingIds[], int orderTrackingConsultationUser, int operator)
			throws BussinessException {
		List<String> code=new ArrayList<String>();
		String _new=profileService.getUserNameById(orderTrackingConsultationUser);
		for (int orderTrackingId : orderTrackingIds) {
			OrderTrackingPO po = orderTrackingDao.getObject(orderTrackingId);
			String old=profileService.getUserNameById(po.getConsultationUserId());
			po.setConsultationUserId(orderTrackingConsultationUser);
			code.add(po.getCode());
			addOrderTrackingHistory(orderTrackingId, "修改咨询人："+StringUtils.convertEmptyStringOfNull(old)+"-->"+_new, operator);
			orderTrackingDao.updateObject(po);
		}
		
		commandOrderTracking2CMS.upateOrderTrackingConsultationUserIdToCMS(orderTrackingConsultationUser, code);
	}

	@Override
	public List<Integer> getOrderTrackingConsultationUsers() {
		String sql="SELECT b.id FROM dbo.order_tracking a "
				+" INNER JOIN dbo.[user] b ON a.consultation_user_id=b.id";	
		return orderTrackingDao.findListIntegerBySql(sql, null);
	}

	@Override
	public void updateOrderTrackingReaded(int orderTrackingId, int operatorId) throws BussinessException {
		OrderTrackingPO po =  orderTrackingDao.getObject(orderTrackingId);
		if(!po.isRead()) {
			po.setRead(true);	//更新用户已经阅读 true已读
			orderTrackingDao.updateObject(po);
		}

	}

	@Override
	public OrderTracking readOrderTracking(int orderTrackingId) {
		return null;
	}

	@Override
	public PageList<OrderTracking> findOrderTracking(SearchOrderTrackingForm form) {
		String sql = "SELECT * FROM dbo.order_tracking";
		StringBuilder where = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		where.append(" and deleted=0 ");
		if (form.getType() > -1) {
			where.append(" and type=?");
			params.add(form.getType());
		}
		if (form.getStatus() > -1) {
			where.append(" and status=?");
			params.add(form.getStatus());
		}
		if (StringUtils.isNotEmpty(form.getOrderCode())) {
			where.append(" and order_code like ? ");
			params.add("%"+form.getOrderCode()+"%");
		}
		if (CollectionUtils.isNotEmpty(form.getOrderCodes())) {
			where.append(" and order_code  in (");
			for (int i = 0; i < form.getOrderCodes().size(); i++) {
				String sku = form.getOrderCodes().get(i);
				if (i == 0) {
					where.append("'").append(sku).append("'");
				} else {
					where.append(",'").append(sku).append("'");
				}
			}
			where.append(") ");
		}

		if (StringUtils.isNotEmpty(form.getCode())) {
			where.append(" and code like ");
			where.append(SqlUtil.escapeLike(form.getCode()));
		}

		//根据cms商品的订单号获取

		if(form.getCmsProductCode() != null && !"".equals(form.getCmsProductCode().trim()) ){
			where.append(" AND (id IN (SELECT order_tracking_id  FROM dbo.order_tracking_product " +
							 		 "WHERE cms_product_code=? ))");
			params.add(form.getCmsProductCode());
		}

		if (form.getConsultationDateBegin() != null) {
			where.append(" AND  consultation_time>=?");
			params.add(DateUtils.getRealDate(form.getConsultationDateBegin()));
		}
		if (form.getConsultationDateEnd() != null) {
			where.append(" AND  consultation_time<=?");
			params.add(DateUtils.getFullDate(form.getConsultationDateEnd()));
		}
		if (form.getReplyDateBegin() != null) {
			where.append(" AND  last_reply_date>?");
			params.add(DateUtils.getRealDate(form.getReplyDateBegin()));
		}
		if (form.getReplyDateEnd() != null) {
			where.append(" AND  last_reply_date<?");
			params.add(DateUtils.getFullDate(form.getReplyDateEnd()));
		}
		if (form.getConsultationUserId()>-1) {
			where.append(" and consultation_user_id=?");
			params.add(form.getConsultationUserId());
		}

		PageList<OrderTrackingPO> pos = orderTrackingDao.findPageListBySql(form.getCurrentPage(), form.getPageSize(), sql, where.toString(), " consultation_time desc ", params);
		if (pos != null) {
			PageList<OrderTracking> orderTracking = BeanUtils.copyPageList(pos, OrderTracking.class);
			System.out.println(orderTracking);
			return orderTracking;
//			return BeanUtils.copyPageList(pos, OrderTracking.class);
		}
		return null;
	}

	@Override
	public OrderTracking getOrderTrackingByCode(String code) {
		String hql = "from OrderTrackingPO  where code=?";
		OrderTrackingPO po = this.orderTrackingDao.findByHql(hql, code);
		return BeanUtils.copyProperties(po, OrderTracking.class);
	}

	// to do test   不可用方法
	@Override
	public List<OrderTracking> getOrderTrackingByProductId(String ProductCode) {
		String hql = "FROM OrderTrackingPO " +
					 "WHERE id IN (SELECT orderTrackingId  FROM OrderTrackingProductPO " +
				 					"WHERE cmsProductCode=? )";

		List<OrderTrackingPO> poList =	this.orderTrackingDao.findListByHql(hql,ProductCode);
		return BeanUtils.copyList(poList,OrderTracking.class);
	}

	@Override
	public OrderTracking getOrderTracking(int orderTrackingId) {
		return BeanUtils.copyProperties(orderTrackingDao.getObject(orderTrackingId), OrderTracking.class);
	}

	@Override
	public OrderTracking getOrderTrackingDetail(int orderTrackingId) {
		OrderTracking o = getOrderTracking(orderTrackingId);
		if (o != null) {
			o.setProducts(getOrderTrackingProducts(orderTrackingId));
			o.setItems(getOrderTrackingItems(orderTrackingId));

			if (CollectionUtils.isNotEmpty(o.getProducts())) {
				for (OrderTrackingProduct product : o.getProducts()) {
					product.setAttachments(getOrderTrackingAttachments(product.getId()));
				}
			}
		}
		return o;
	}

	@Override
	public List<OrderTrackingItem> getOrderTrackingItems(int orderTrackingId) {
		String hql = "from OrderTrackingItemPO where orderTrackingId=? ";
		List<OrderTrackingItemPO> pos = orderTrackingItemDao.findListByHql(hql, orderTrackingId);
		return BeanUtils.copyList(pos, OrderTrackingItem.class);
	}

	@Override
	public List<OrderTrackingProduct> getOrderTrackingProducts(int orderTrackingId) {
		String hql = "from OrderTrackingProductPO where orderTrackingId=? ";
		List<OrderTrackingProductPO> pos = orderTrackingProductDao.findListByHql(hql, orderTrackingId);
		return BeanUtils.copyList(pos, OrderTrackingProduct.class);
	}

	@Override
	public List<OrderTrackingProductAttachment> getOrderTrackingAttachments(int orderTrackingProductId) {
		String hql = "from OrderTrackingProductAttachmentPO where orderTrackingProductId=? ";
		List<OrderTrackingProductAttachmentPO> pos = orderTrackingProductAttachmentDao.findListByHql(hql,
				orderTrackingProductId);
		return BeanUtils.copyList(pos, OrderTrackingProductAttachment.class);
	}

	@Override
	public List<OrderTrackingLog> getOrderTrackingLogs(int orderTrackingId) {
		String hql = "from OrderTrackingLogPO where orderTrackingId=? order by id desc";
		List<OrderTrackingLogPO> pos = orderTrackingLogDao.findListByHql(hql, orderTrackingId);
		return BeanUtils.copyList(pos, OrderTrackingLog.class);
	}
	
	protected OrderTrackingProductPO getOrderTrackingProduct(int orderTrackingId,int cmsProductId){
		String hql="from OrderTrackingProductPO where orderTrackingId=? and cmsProductId=?";
		return this.orderTrackingProductDao.findByHql(hql, new Object[]{orderTrackingId,cmsProductId});
	}
}
