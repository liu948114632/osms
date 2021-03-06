package com.itecheasy.core.fba;

import java.io.File;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

import com.itecheasy.common.util.*;
import com.itecheasy.common.util.CompareMap;
import com.itecheasy.core.fba.FbaInboundService.FbaInboundPlanSubmitStatus;
import com.itecheasy.core.fba.dao.*;
import com.itecheasy.core.order.dao.OrderTrackingDao;
import com.itecheasy.core.order.dao.OrderTrackingProductDao;
import com.itecheasy.core.po.*;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.itecheasy.common.PageList;
import com.itecheasy.common.Param;
import com.itecheasy.common.attachment.AttachmentHelper;
import com.itecheasy.common.attachment.AttachmentService;
import com.itecheasy.common.dao.Criteria;
import com.itecheasy.common.dao.Order.OrderType;
import com.itecheasy.common.dao.Restriction;
import com.itecheasy.communication.order.Command2CMS;
import com.itecheasy.communication.order.Command2SW;
import com.itecheasy.communication.order.CommandReplenishmentOrderUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.order.BaseOrder;
import com.itecheasy.core.order.BaseOrderItem;
import com.itecheasy.core.order.OrderApplyType;
import com.itecheasy.core.order.OrderCancelResendService;
import com.itecheasy.core.order.OrderOperateLog;
import com.itecheasy.core.order.OrderService.OrderAmazonStatus;
import com.itecheasy.core.order.OrderService.OrderProblemType;
import com.itecheasy.core.order.OrderService.OrderProductStatus;
import com.itecheasy.core.order.OrderService.OrderStatus;
import com.itecheasy.core.order.SearchOrderForm;
import com.itecheasy.core.order.UpdateOrderProductForm;
import com.itecheasy.core.product.CMSProduct;
import com.itecheasy.core.product.ShopProductCmsInfo;
import com.itecheasy.core.product.ShopProductCmsInfoService;
import com.itecheasy.core.system.Merchandiser;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.core.user.User;
import com.itecheasy.core.util.DictUtils;
import com.itecheasy.webservice.client.CMSClient;
import com.itecheasy.webservice.client.CMSOrderClient;
import com.itecheasy.webservice.client.DMSClient;
import com.itecheasy.webservice.client.DMSUtils;
import com.itecheasy.webservice.dms.AccountSetting;

/**
 * @author wanghw
 * @date 2016-12-3
 * @description TODO
 * @version 1.2.2
 */
public class ReplenishmentOrderServiceImpl extends BaseOrder implements ReplenishmentOrderService {
//	protected final static Logger LOGGER=Logger.getLogger(ReplenishmentOrderServiceImpl.class);
	protected final static String REPLENISHMENT_SHIPPING_ATTACHMENT = "REPLENISHMENT_SHIPPING_ATTACHMENT";
	protected static final String ERROR_ADD_SEND_GROUP = "只有C3备货的订单，且货运方式和货运地址完全相同的待校对之前（包含待校对）的订单才能同票";
	protected static final String ERROR_ORDER_STATUS_ = "订单状态不对，无法操作！";
	protected ReplenishmentOrderDao replenishmentOrderDao;
	protected ReplenishmentOrderItemDao replenishmentOrderItemDao;
	protected ReplenishmentOrderOperateLogDao replenishmentOrderOperateLogDao;
	protected ReplenishmentOrderShippingListDao replenishmentOrderShippingListDao;
	protected RepositoryService repositoryService;
	protected FbaShopProductService fbaShopProductService;
	protected ShopProductInventoryService shopProductInventoryService;
	protected ShopProductCmsInfoService shopProductCmsInfoService;
	protected OrderCancelResendService orderCancelResendService;
	protected AttachmentHelper attachmentHelper;
	protected AttachmentService attachmentService;
	protected ProfileService profileService;
	protected ReplenishmentOrderViewDao replenishmentOrderViewDao;
	protected IFbaShopProductUpdateControl fbaShopProductUpdateControl;
	protected ReplenishmentOrderRepositoryDao replenishmentOrderRepositoryDao;

    protected OrderTrackingDao orderTrackingDao;
	protected OrderTrackingProductDao orderTrackingProductDao;
	protected FbaReplenishmentPlanDao fbaReplenishmentPlanDao;
	protected FbaReplenishmentPlanOperateLogDao fbaReplenishmentPlanOperateLogDao;

	private FbaInboundService fbaInboundService;

	public void setFbaInboundService(FbaInboundService fbaInboundService) {
		this.fbaInboundService = fbaInboundService;
	}

	public void setFbaReplenishmentPlanOperateLogDao(FbaReplenishmentPlanOperateLogDao fbaReplenishmentPlanOperateLogDao) {
		this.fbaReplenishmentPlanOperateLogDao = fbaReplenishmentPlanOperateLogDao;
	}

	public void setFbaReplenishmentPlanDao(FbaReplenishmentPlanDao fbaReplenishmentPlanDao) {
		this.fbaReplenishmentPlanDao = fbaReplenishmentPlanDao;
	}

	public void setOrderTrackingDao(OrderTrackingDao orderTrackingDao) {
        this.orderTrackingDao = orderTrackingDao;
    }

    public void setOrderTrackingProductDao(OrderTrackingProductDao orderTrackingProductDao) {
		this.orderTrackingProductDao = orderTrackingProductDao;
	}

	public void setReplenishmentOrderRepositoryDao(ReplenishmentOrderRepositoryDao replenishmentOrderRepositoryDao) {
		this.replenishmentOrderRepositoryDao = replenishmentOrderRepositoryDao;
	}

	public void setFbaShopProductUpdateControl(IFbaShopProductUpdateControl fbaShopProductUpdateControl) {
		this.fbaShopProductUpdateControl = fbaShopProductUpdateControl;
	}

	public void setReplenishmentOrderViewDao(ReplenishmentOrderViewDao replenishmentOrderViewDao) {
		this.replenishmentOrderViewDao = replenishmentOrderViewDao;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setAttachmentService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}

	public void setAttachmentHelper(AttachmentHelper attachmentHelper) {
		this.attachmentHelper = attachmentHelper;
	}

	public void setOrderCancelResendService(OrderCancelResendService orderCancelResendService) {
		this.orderCancelResendService = orderCancelResendService;
	}

	public void setShopProductCmsInfoService(ShopProductCmsInfoService shopProductCmsInfoService) {
		this.shopProductCmsInfoService = shopProductCmsInfoService;
	}

	public void setShopProductInventoryService(ShopProductInventoryService shopProductInventoryService) {
		this.shopProductInventoryService = shopProductInventoryService;
	}

	public void setFbaShopProductService(FbaShopProductService fbaShopProductService) {
		this.fbaShopProductService = fbaShopProductService;
	}

	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	public void setReplenishmentOrderDao(ReplenishmentOrderDao replenishmentOrderDao) {
		this.replenishmentOrderDao = replenishmentOrderDao;
	}

	public void setReplenishmentOrderItemDao(ReplenishmentOrderItemDao replenishmentOrderItemDao) {
		this.replenishmentOrderItemDao = replenishmentOrderItemDao;
	}

	public void setReplenishmentOrderOperateLogDao(ReplenishmentOrderOperateLogDao replenishmentOrderOperateLogDao) {
		this.replenishmentOrderOperateLogDao = replenishmentOrderOperateLogDao;
	}

	public void setReplenishmentOrderShippingListDao(ReplenishmentOrderShippingListDao replenishmentOrderShippingListDao) {
		this.replenishmentOrderShippingListDao = replenishmentOrderShippingListDao;
	}

	@Override
	public int addReplenishmentOrder(ReplenishmentOrder order, List<ReplenishmentOrderItem> items, String operator) {
		order.setAddOrderDate(new Date());
		order.setStatus(OrderStatus.PENDING.getVal());
		// 预计发货时间：往后推7—10天
		// 预计妥投时间：发货时间往后推5-15天
		order.setEarliestShippingDate(DateUtils.addDays(order.getAddOrderDate(), 7));
		order.setLatestShipDate(DateUtils.addDays(order.getAddOrderDate(), 10));
		order.setEarliestDeliveryDate(DateUtils.addDays(order.getAddOrderDate(), 12));
		order.setLatestDeliveryDate(DateUtils.addDays(order.getAddOrderDate(), 25));

		order.setIsQualityInspection(1);
		order.setOrderItemNum(items.size());
		ShopInfo shopInfo = systemService.getShopInfo(order.getShopId());
		Merchandiser merchandiser = systemService.getMerchandiserByCode(shopInfo.getMerchandiserId());
		order.setMerchandiserId(merchandiser.getId());
		order.setCustomerName(order.getRecipients());
		order.setCode(createOrderCode());
		order.setShopSource(DictUtils.SHOP_SOURCE_WH_FBA);
		order.setShopType(DictUtils.SHOP_TYPE_AMAZON);
		order.setCmsPrepare(ORDER_PREPARE_TYPE_CMS);
		Repository repository=repositoryService.getRepositoryById(order.getRepositoryId());
		order.setCountry(repository.getCountryId());
		
		order.setOrderAmazonStatus(OrderAmazonStatus.WORKING.getStatusCode());
		ReplenishmentOrderPO po = BeanUtils.copyProperties(order, ReplenishmentOrderPO.class);
		int orderId = replenishmentOrderDao.addObject(po);
		List<String> cmsProductCodes = new ArrayList<String>();
		
		setRepository(orderId, order.getRepositoryId());
		double _cost_price = 0d;
		for (ReplenishmentOrderItem item : items) {
			if (cmsProductCodes.contains(item.getCmsProductCode()))
				throw new BussinessException("生成失败，c3产品编号重复！");

			String result=hasAvailableStorage4FinalOff(item.getOrderedQuantity(), item.getUnitQty(), item.getCmsProductCode(),
					CMSClient.getCMSProductByCode(item.getCmsProductCode()));
			if(result!=null)
				throw new BussinessException(result);
			cmsProductCodes.add(item.getCmsProductCode());
			item.setStatus(OrderProductStatus.备货中.getVal());
			item.setAmQuantity(item.getOrderedQuantity());
			item.setReplenishmentOrderId(orderId);
			item.setCmsPrepare(ORDER_PREPARE_TYPE_CMS);
			item.setCostPrice(new BigDecimal(item.getCostPrice()).multiply(new BigDecimal(item.getOrderedQuantity()))
				.multiply(new BigDecimal(item.getUnitQty())).setScale(3, 4).doubleValue());
			_cost_price+=item.getCostPrice();
			// 生成成功后，更新fba待补货批量、fba补货中批量
			setReplenishment(item.getFbaShopProductId(),0, (int)item.getOrderedQuantity());

			// fba条码
			FbaShopProduct fba = fbaShopProductService.getFbaShopProduct(item.getFbaShopProductId());
			item.setFbaBarcodeName(fba.getFbaBarcodeName());
			item.setFbaBarcodeSku(fba.getFbaBarcodeSku());

			ShopProductCmsInfo cms = shopProductCmsInfoService.getShopProductCmsInfoById(item.getCmsProductId());
			item.setUnitVolume(cms.getUnitVolume());
			item.setUnitWeight(cms.getUnitWeight());
			
		}
		po.setCostPrice(_cost_price);
		replenishmentOrderDao.mergeObject(po);
		replenishmentOrderItemDao.addObject(BeanUtils.copyList(items, ReplenishmentOrderItemPO.class));

		addOrderOperateLog("增加Pending订单", operator, orderId);
		
		//如果是带着计划id，那么就关联起来
		if(order.getFbaReplenishmentPlanId()!=null&&order.getFbaReplenishmentPlanId()>0){
			FbaReplenishmentPlanOperateLogPO log = new FbaReplenishmentPlanOperateLogPO();
			log.setComment("生成了补货订单："+po.getCode());
			log.setOperateTime(new Date());
			User user = profileService.getUserByName(operator);
			log.setOperatorId(user==null?0:user.getId());
			log.setReplenishmentPlanId(order.getFbaReplenishmentPlanId());
			fbaReplenishmentPlanOperateLogDao.addObject(log);
			FbaReplenishmentPlanPO planPO = fbaReplenishmentPlanDao.getObject(order.getFbaReplenishmentPlanId());
			planPO.setSubmitStatus(FbaInboundPlanSubmitStatus.已建单.getVal());
			fbaReplenishmentPlanDao.updateObject(planPO);
		}
		return orderId;
	}
	
	@Override
	public void resendOrder(int orderId, int operator) throws BussinessException {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		// "重发待确认"=false,status=C3备货的订单+已出库状态可+已发货订单
		if(po.getCmsPrepare()!=ORDER_PREPARE_TYPE_CMS)
			throw new BussinessException("订单非cms备货，无法操作！");
		if (po.getIsbackTag()) {
			throw new BussinessException("订单已被打回，无法操作！");
		}
		if (po.isAwaitConfirmResend()) {
			throw new BussinessException("订单已申请重发，无法再次操作！");
		}
		if (po.getStatus() == OrderStatus.已出库.getVal()
		// || po.getStatus() == OrderStatus.已发货.getVal()
				|| po.getStatus() == OrderStatus.已打包.getVal() || po.getStatus() == OrderStatus.打包中.getVal()) {

			String content = OrderStatus.getName(po.getStatus()) + "订单，申请订单重发";
			User user = profileService.getUserByID(operator);
			// 是否是同票订单
			List<ReplenishmentOrderPO> group = new ArrayList<ReplenishmentOrderPO>();
			if (po.getSendGroupId() != null) {
				group = this.getOrderByTicketGroup(po.getSendGroupId());
			} else {
				group.add(po);
			}

			StringBuilder orderCodes = new StringBuilder();
			for (ReplenishmentOrderPO orderPO : group) {
				orderPO.setAwaitConfirmResend(true);
				orderCancelResendService.applyOrderOperating(orderPO.getCode(), OrderApplyType.RESEND.getVal());
				orderCodes.append(",").append(orderPO.getCode());
				orderPO.setOldStatus(orderPO.getStatus());
				this.addOrderOperateLog(content, user.getName(), orderPO.getId());
			}
			// 通讯cms
			Command2CMS.orderApplayResend(orderCodes.toString().substring(1), user.getName(), user.getCode());
			return;
		}
		throw new BussinessException(ERROR_ORDER_STATUS_);
	}
	
	/**
	 * 根据同票id获取订单
	 * 
	 * @param ticketGroupId
	 * @return
	 */
	protected List<ReplenishmentOrderPO> getOrderByTicketGroup(int ticketGroupId) {
		String hql = "from ReplenishmentOrderPO where sendGroupId=?";
		return replenishmentOrderDao.findListByHql(hql, ticketGroupId);
	}
	
	protected int getCopyTagNum(ReplenishmentOrderPO old) {
		int tag = 1;
		Criteria criteria = new Criteria(ReplenishmentOrderPO.class);
		criteria.and(Restriction.like("code", old.getCode() + "(%)"));
		criteria.order("id", OrderType.desc);
		List<ReplenishmentOrderPO> his = replenishmentOrderDao.list(criteria);
		if (CollectionUtils.isNotEmpty(his)) {
			String his_code = his.get(0).getCode();
			int index = his_code.indexOf("(");
			int index2 = his_code.indexOf(")");

			tag = Integer.valueOf(his_code.substring(index + 1, index2)) + 1;
		}
		return tag;
	}
	
	private String getCopyTagNumNewRule(ReplenishmentOrderPO old,String code){
		String tag = "A";
		Criteria criteria = new Criteria(ReplenishmentOrderPO.class);
		criteria.and(Restriction.like("code", code + "[A-Z]%"));
//		criteria.and(Restriction.notLike("code", code + "(%)"));//排除旧规则
		criteria.and(Restriction.eq("copy", true));
		criteria.order("id", OrderType.desc);
		
		List<ReplenishmentOrderPO> his = replenishmentOrderDao.list(criteria);
		if (CollectionUtils.isNotEmpty(his)) {
			String his_code = his.get(0).getCode();
			tag=his_code.substring(code.length());
			
			tag=com.itecheasy.common.util.StringUtils.getNum2Word(com.itecheasy.common.util.StringUtils.getWord2Num(tag)+1);
		}
		return tag;
	}
	
	@Override
	public int copyOrder(int orderId, String operator) {
		ReplenishmentOrderPO old = replenishmentOrderDao.getObject(orderId);
		if (old != null) {
			if (BooleanUtils.isTrue(old.getCopy())) {
				throw new BussinessException("复制的订单不能再复制！");
			}
			if (old.getStatus() == OrderStatus.PENDING.getVal()) {
				throw new BussinessException("订单状态为“准备货物” 及以上才可以重新备货!");
			}
			ReplenishmentOrderPO po = new ReplenishmentOrderPO();
			BeanUtils.copyProperties(old, po, new String[] { "id" });
			// 复制的订单状态为准备货物，
			po.setStatus(OrderStatus.PENDING.getVal());
			
			String tag=po.getCode();
			//2017-12-05 新规则
			po.setCode(tag + getCopyTagNumNewRule(old,tag));
			// 判断该订单的复制历史
//			int tag = getCopyTagNum(old);
//			po.setCode(old.getCode() + "(" + tag + ")");

			po.setOrderItemPrepareNum(0);
			po.setCopy(true);
			// 初始化订单原始状态
			po.setAwaitConfirmCancel(false);
			po.setAwaitConfirmResend(false);
			po.setOrderCancelTag(false);
			po.setIsbackTag(false);
			po.setShippingListStatus(ReplenishmentShippingListStatus.未上传.getVal());

			po.setAddOrderDate(new Date());
			po.setDeliveryDate(null);
			po.setDeliveryCustomerService(null);
			po.setPackageStatus(null);
			po.setSendGroupId(null);
			po.setOldStatus(null);
			po.setTrackingCode(null);
			po.setOutDate(null);
			po.setCostFreight(null);

			po.setSwToCmsPrepare(false);   //copy order should be zero

			Integer orderId_new = replenishmentOrderDao.addObject(po);
			ReplenishmentOrderRepositoryPO oldRepo = replenishmentOrderRepositoryDao.getObject(orderId);
			if(oldRepo!=null){
				ReplenishmentOrderRepositoryPO newRepo = new ReplenishmentOrderRepositoryPO();
				BeanUtils.copyProperties(oldRepo, newRepo);
				newRepo.setId(orderId_new);
				replenishmentOrderRepositoryDao.addObject(newRepo);
			}
			List<ReplenishmentOrderItem> opos_old = getOrderProduct(orderId);
			if (CollectionUtils.isNotEmpty(opos_old)) {
				for (ReplenishmentOrderItem orderProductPO : opos_old) {
					ReplenishmentOrderItemPO _item = new ReplenishmentOrderItemPO();
					_item.setReplenishmentOrderId(orderId_new);
					BeanUtils.copyProperties(orderProductPO, _item, new String[] { "id", "replenishmentOrderId" });
					
					_item.setPreparedQuantity(0);
					_item.setStatus(OrderProductStatus.备货中.getVal());
					
					
					replenishmentOrderItemDao.addObject(_item);
					//设置补货数量
					setReplenishment(_item.getFbaShopProductId(), 0, (int)_item.getOrderedQuantity());
				}
			}

			addOrderOperateLog("复制订单" + old.getCode(), operator, orderId_new);
			// 通讯cms，增加订单
			return orderId_new;
		}
		return 0;
	}

	protected String createOrderCode() {
		List<Param> parameters = new ArrayList<Param>();
		parameters.add(new Param("Code", ""));
		String object = replenishmentOrderDao.execStoredProcedure4output("[dbo].[Order_OrderIdBuild_replenishment]",
				parameters);
		if (object != null) {
			return object.toString();
		}
		return null;
	}

	@Override
	public void confirmOrder(int orderId, String operator,boolean isSw) throws BussinessException {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		if (po.getStatus() > OrderStatus.PENDING.getVal())
			throw new BussinessException("订单无法确认");
		po.setStatus(OrderStatus.准备货物.getVal());
		
		boolean notCmsPrepare=true;//2017-11-27 全部非cms备货不需要质检
		List<ReplenishmentOrderItemPO> items = getOrderProductNotCancel(orderId);

		if(isSw){
			po.setCmsPrepare(ORDER_PREPARE_TYPE_SW);
			for (ReplenishmentOrderItemPO orderPrepareProductPO : items) {
				orderPrepareProductPO.setCmsPrepare(ORDER_PREPARE_TYPE_SW);
			}
		}else{   //点击否，c3备货
			for (ReplenishmentOrderItemPO item : items) {
				if(CMSClient.isSwProduct(item.getCmsProductId())){
					continue;
				}
				if(CMSClient.isProductTs(item.getCmsProductId())){
					continue;
				}
				notCmsPrepare=false;   //只要有一个cms商品
				break;
			}

			if (isAllSwProduct(orderId)) { //整单SW商品
				po.setSwToCmsPrepare(true);
				po.setIsQualityInspection(notCmsPrepare ? 0 : 1); // 整单SW商品 走C3备货 设置不需要质检
			}
			
			po.setCmsPrepare(ORDER_PREPARE_TYPE_CMS);
			for (ReplenishmentOrderItemPO orderPrepareProductPO : items) {
				orderPrepareProductPO.setCmsPrepare(ORDER_PREPARE_TYPE_CMS);
			}
		}
		
		this.replenishmentOrderDao.updateObject(po);
		CommandReplenishmentOrderUtils.addReplenishmentOrder(getReplenishmentOrderDetail(orderId),
				systemService.getCacheShopInfo(po.getShopId()),
				systemService.getCacheAccount(po.getShopId()));
		addOrderOperateLog("确认订单"+(po.getCmsPrepare()==ORDER_PREPARE_TYPE_CMS?" cms备货" :"  sw备货"), operator, orderId);
	}

	public boolean isAllSwProduct(int orderId){
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		//开关&&国家
		if(isOpeaSw()&&DeployProperties.getInstance().getFbaRpCountry().contains(po.getCountry())){
			List<ReplenishmentOrderItemPO> items = getOrderProductNotCancel(orderId);
			for (ReplenishmentOrderItemPO item : items) {
				if(CMSClient.isSwProduct(item.getCmsProductId())){
					continue;
				}
				return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public void addOrderOperateLog(String comment, String operator, int objectId) {
		ReplenishmentOrderOperateLogPO po = new ReplenishmentOrderOperateLogPO();
		po.setOperator(operator);
		po.setComment(comment);
		po.setObjectId(objectId);
		po.setOperateDate(new Date());
		replenishmentOrderOperateLogDao.addObject(po);
	}

	@Override
	public void addOrderOperateLog(String comment, String operator, int objectId, Date operatorTime) {
		ReplenishmentOrderOperateLogPO po = new ReplenishmentOrderOperateLogPO();
		po.setOperator(operator);
		po.setComment(comment);
		po.setObjectId(objectId);
		po.setOperateDate(operatorTime);
		replenishmentOrderOperateLogDao.addObject(po);
	}

	@Override
	public List<OrderOperateLog> getOrderOperateLogs(int orderId) {
		String hql = "from ReplenishmentOrderOperateLogPO where objectId=? order BY id desc";
		List<ReplenishmentOrderOperateLogPO> pos = replenishmentOrderOperateLogDao.findListByHql(hql, orderId);
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyList(pos, OrderOperateLog.class);
		}
		return null;
	}

	@Override
	public void cancelOrderProducts(int orderId, int[] orderProductIds, String operator) throws BussinessException {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		if (po.getStatus() > OrderStatus.已配货.getVal()) {
			throw new BussinessException("状态不对，无法取消商品！");
		}

		// 验证小批量订单下架
		StringBuilder cancleOrderItemIds = new StringBuilder();
		StringBuilder cancelReason = new StringBuilder();

		List<ReplenishmentOrderItemPO> orderProductList = new ArrayList<ReplenishmentOrderItemPO>();
		for (int i = 0; i < orderProductIds.length; i++) {
			ReplenishmentOrderItemPO item = replenishmentOrderItemDao.getObject(orderProductIds[i]);
			orderProductList.add(item);

			cancelOrderProduct(item, po, operator, cancleOrderItemIds);
			addOrderOperateLog("取消商品：" + item.getCmsProductCode(), operator, po.getId());

			cancelReason.append(",").append(0);
		}

		List<ReplenishmentOrderItemPO> pos = getOrderProductNotCancel(orderId);

		if (CollectionUtils.isEmpty(pos)) {
			throw new BussinessException("无法取消所有商品！");
		}


		updateOrderStatusByOrderProduct(po);	//update order status

		//update orderTracking product delete

		//把ordertracking中的product的状态给变更为取消
		String sql = "SELECT * FROM order_tracking_product op " +
				"INNER JOIN " +
				"(SELECT  * FROM order_tracking ) o " +
				"ON op.order_tracking_id = o.id " +
				"WHERE o.order_code=? and op.cms_product_code=? ";
		//这下面就是每一个补货订单的
		if (orderProductList!= null && orderProductList.size()!=0) {
			for (int i = 0; i < orderProductList.size(); i++) {
				List<Object> params = new ArrayList<Object>();
				//增加参数
				params.add(po.getCode());    //orderCode
				params.add(orderProductList.get(i).getCmsProductCode());   //productCode

				List<OrderTrackingProductPO> orderTrackingPOList = this.orderTrackingProductDao.findListBySql(sql, params);

				//update
				if (orderTrackingPOList != null && orderTrackingPOList.size() != 0) {
					for (OrderTrackingProductPO orderTrackingProductPO : orderTrackingPOList) {
						orderTrackingProductPO.setDeleted(true);
						orderTrackingProductDao.updateObject(orderTrackingPOList);
					}
				}

			}

			//如果订单跟踪中只有一个商品并且为取消，就直接把订单跟踪给改为已完成
			String sql3 = "select * from order_tracking" +
						" where order_code=? ";
			List<Object> params3 = new ArrayList<Object>();
			params3.add(po.getCode());

			//根据订单号查出该单号下的多个订单跟踪
			List<OrderTrackingPO> orderTrackingPOList3 =  orderTrackingDao.findListBySql(sql3,params3);
			//每个订单跟踪下的所有商品查出来	cms_product_code=? and
			String sql4 = "select * from order_tracking_product" +
							" where order_tracking_id=? ";
			if(orderTrackingPOList3!=null && orderTrackingPOList3.size()!=0){
				for (OrderTrackingPO orderTrackingPO : orderTrackingPOList3) { //cancel之后把改订单下所有的订单跟踪改为已完成
					List<Object> params4 = new ArrayList<Object>();
					params4.add(orderTrackingPO.getId());
					List<OrderTrackingProductPO> orderTrackingProductPOList = orderTrackingProductDao.findListBySql(sql4,params4);
					if(orderTrackingProductPOList!= null && orderTrackingProductPOList.size()!=0){
						int isDelete = 0;
						for (OrderTrackingProductPO orderTrackingProductPO : orderTrackingProductPOList) {
							if (orderTrackingProductPO.isDeleted()) {
								isDelete++;
							}
						}
						if (isDelete==orderTrackingProductPOList.size()){
							orderTrackingPO.setStatus(20);	  //30 已完成
							orderTrackingDao.updateObject(orderTrackingPOList3);
						}
					}
				}
			}
		}
		cancelOrderProducts$changeOrder(po, cancleOrderItemIds, cancelReason,operator);
	}
	
	protected void cancelOrderProducts$changeOrder(ReplenishmentOrderPO po, StringBuilder cancleOrderItemIds,
			StringBuilder cancelReason,String operator) {
		if(isCommuication(po)){
			CommandReplenishmentOrderUtils.cancleOrderItem(po.getCode(), po.getStatus(), cancleOrderItemIds.toString().substring(1),
					cancelReason.toString().substring(1),po.getCmsPrepare());
			
			CommandReplenishmentOrderUtils.updateOrder(BeanUtils.copyProperties(po,ReplenishmentOrder.class), 
					operator);
			CommandReplenishmentOrderUtils.updateOrderProductAmount(po.getCode(), po.getCostPrice(), po.getCostFreight(),po.getCmsPrepare());
		}
	}
	
	

	/**
	 * 更新订单状态
	 * 
	 * @param po
	 */
	protected void updateOrderStatusByOrderProduct(ReplenishmentOrderPO po) {
		if (po.getStatus() <= OrderStatus.PENDING.getVal()) {
			return;
		}
		int total = po.getOrderItemNum();

		if (total <= po.getOrderItemPrepareNum()) {
			setPreparedOrCheck(po);
		} else {
			po.setStatus(OrderStatus.准备货物.getVal());
		}
	}


	/**
	 * fba订单能变成待校对
	 * @param po
	 * @return
	 */
	protected boolean fbaCanBeChecking(ReplenishmentOrderPO po) {
		return po.getShopSource() != DictUtils.SHOP_SOURCE_WH_FBA || orderCancelResendService
				.existOrderCancelResendApply(po.getCode());
	}
	
	/**
	 * 是否能待校对
	 * @param po
	 * @return
	 */
	protected boolean isCouldChecking(ReplenishmentOrderPO po) {
		// wh-fba走fba清点流程，重发后走普通订单流程。
		return po.getIsSend()
				&& fbaCanBeChecking(po);
	}
	
	/**
	 * 设置备货和校对
	 * @param po
	 */
	protected void setPreparedOrCheck(ReplenishmentOrderPO po) {
		if(po.getStatus()==OrderStatus.已配货.getVal()
				||po.getStatus()==OrderStatus.配货中.getVal()){
			
		}else{
			po.setStatus(OrderStatus.已备货.getVal());
		}
//		po.setStatus(OrderStatus.已备货.getVal());
		// wh-fba走fba清点流程，重发后走普通订单流程。
//		if (isCouldChecking(po)) {
//			po.setStatus(OrderStatus.待校对.getVal());
//		}
	}


	protected List<ReplenishmentOrderItemPO> getOrderProductNotCancel(int orderId) {
		Criteria criteria = new Criteria(ReplenishmentOrderItemPO.class);
		criteria.and(Restriction.eq("replenishmentOrderId", orderId));
		criteria.and(Restriction.notEq("status", 12));
		return replenishmentOrderItemDao.list(criteria);
	}

	protected void cancelOrderProduct(ReplenishmentOrderItemPO ppo, ReplenishmentOrderPO orderPo, String operator,
			StringBuilder cancleOrderItemIds) throws BussinessException {

		if (ppo.getStatus() == OrderProductStatus.取消.getVal()) {
			throw new BussinessException("商品" + ppo.getCmsProductCode() + "已经取消，无法重复取消！");
		}

		// 更新订单项总数，已备量
		orderPo.setOrderItemNum(orderPo.getOrderItemNum() - 1);
		if (ppo.getStatus() == OrderProductStatus.已备货.getVal()) {
			orderPo.setOrderItemPrepareNum(orderPo.getOrderItemPrepareNum() == 0 ? 0
					: orderPo.getOrderItemPrepareNum() - 1);
		}

		ppo.setStatus(OrderProductStatus.取消.getVal());
        ppo.setAmQuantity(0.0); //after cancel product,either update item quantity zero

		// 更新订单成本价
		orderPo.setCostPrice(orderPo.getCostPrice() == null ? 0 : orderPo.getCostPrice()
				- ppo.getCostPrice());
		replenishmentOrderItemDao.mergeObject(ppo);



		//设置补货数量
		setReplenishment(ppo.getFbaShopProductId(),(int) ppo.getOrderedQuantity(), 0);
		cancleOrderItemIds.append(",").append(ppo.getId());
	}
	
	/**
	 * 检查重复添加商品项
	 * 
	 * @param orderId
	 * @param orderProducts
	 * @throws BussinessException
	 */
	protected void checkRepeat4UpdateOrderProduct(int orderId, List<UpdateOrderProductForm> orderProducts)
			throws BussinessException {
		StringBuilder code = new StringBuilder();
		StringBuilder ids = new StringBuilder();
		for (UpdateOrderProductForm form : orderProducts) {
			if (code.toString().contains("'" + form.getUpdateProductCode() + "'")
					&& StringUtils.isNotEmpty(form.getUpdateProductCode())) {
				throw new BussinessException("新增商品不能重复！");
			}
			code.append("'" + form.getUpdateProductCode() + "',");
			ids.append(form.getOrderProductId() + ",");
		}

		String sql = " SELECT * FROM replenishment_order_product "
				+ " WHERE  status!=12 AND replenishment_order_id=? AND id NOT IN ("
				+ ids.substring(0, ids.length() - 1) + " ) AND  cms_product_code in ("
				+ code.substring(0, code.length() - 1) + ")";
		List<Object> params = new ArrayList<Object>();
		params.add(orderId);
		List<ReplenishmentOrderItemPO> _is_null = replenishmentOrderItemDao.findListBySql(sql, params);
		if (CollectionUtils.isNotEmpty(_is_null)) {
			List<String> skuList = new ArrayList<String>();
			for (ReplenishmentOrderItemPO replenishmentOrderItemPO : _is_null) {
				skuList.add(replenishmentOrderItemPO.getSku());
			}
			throw new BussinessException("新增商品不能重复！" + skuList);
		}
	}

	@Override
	public void updateOrderProducts(int orderId, String operator, List<UpdateOrderProductForm> forms)
			throws BussinessException {
		if (CollectionUtils.isEmpty(forms)) {
			return;
		}
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		StringBuilder cancleOrderItemIds = new StringBuilder();
		StringBuilder cancelReason = new StringBuilder();

		// 验证小批量订单下架

		// 判断是否会出现重复的备货商品
		checkRepeat4UpdateOrderProduct(orderId, forms);

		StringBuilder remark = new StringBuilder("");
		// 判断订单是否有限制商品
//		boolean _order_has_limit_product = false;
		List<ReplenishmentOrderItemPO> items = new ArrayList<ReplenishmentOrderItemPO>();
		List<ReplenishmentOrderItemPO> update = new ArrayList<ReplenishmentOrderItemPO>();
		for (UpdateOrderProductForm form : forms) {

			int orderProductId = form.getOrderProductId();
			String updateProductCode = form.getUpdateProductCode();
			FbaShopProduct fba=fbaShopProductService.getFbaShopProduct(form.getFbaShopProductId());
			double qty = form.getQty();
			ReplenishmentOrderItemPO old_item = replenishmentOrderItemDao.getObject(orderProductId);

			CMSProduct product = CMSClient.getCMSProductByCode(updateProductCode);
			if (product == null) {
				throw new BussinessException("商品编码" + updateProductCode + "不存在");
			}

			if (form.getUpdateProductCode().equalsIgnoreCase(old_item.getCmsProductCode())) {
				updateOrderProducts4Unit(operator, po, form, old_item, remark, product,update);
			} else {
				double _result = form.getUnitQty() * form.getQty();
				if (Double.valueOf((int) _result) != _result) {
					throw new BussinessException("任务数必须为整数！");
				}

				// 永久下架判断可用库存
				hasAvailableStockout(form, updateProductCode, product);
				swOrderAddItemLimit(po, form, product);
				// 先取消
				//只有备货中和断货状态可以修改备货商品
				updateOrderProduct$cancel(old_item, po, operator, cancleOrderItemIds);
				cancelReason.append(",").append(1);

				// 再添加
				ReplenishmentOrderItemPO new_item = addItemPO(fba,orderId, updateProductCode,
						qty, product);
				new_item.setCmsPrepare(po.getCmsPrepare());
				po.setOrderItemNum(po.getOrderItemNum() + 1);
				replenishmentOrderItemDao.addObject(new_item);
				//设置补货数量
				setReplenishment(new_item.getFbaShopProductId(), 0, (int)new_item.getOrderedQuantity());
//				// 订单限制条件判断
//				_order_has_limit_product = processOrderProductLimit4UpdateOrder(po, address, _order_has_limit_product,
//						product, ppo);

				// 更新订单成本价
				po.setCostPrice((po.getCostPrice() == null ? 0 : po.getCostPrice()) + new_item.getCostPrice());
				addOrderOperateLog("修改备货商品：" + old_item.getCmsProductCode() + "为" + new_item.getCmsProductCode(), operator,
						po.getId());

				items.add(new_item);
			}

		}
		
		updateOrderStatusByOrderProduct(po);
		if (update.size() > 0) {
			addOrderOperateLog(remark.toString(), operator, po.getId());
			if(isCommuication(po)){
				for (ReplenishmentOrderItemPO replenishmentOrderItemPO : update) {
					CommandReplenishmentOrderUtils.updateOrderItemQuantity(po.getCode(), po.getStatus(), 
							replenishmentOrderItemPO.getId(),
							replenishmentOrderItemPO.getOrderedQuantity(),
							replenishmentOrderItemPO.getUnitQty(),
							replenishmentOrderItemPO.getCostPrice(),
							po.getCmsPrepare()
							);
				}
			}
		}

		if (cancleOrderItemIds.length() > 0) {
			// 通讯cms
			if (isCommuication(po)) {
				//先取消，后新增-->先新增，再取消：取消会导致订单变成待校对状态，之前添加商品会导致订单状态不对（实际上该状态是不予许添加商品 2016-10-27）
				if (items.size() > 0) {
					CommandReplenishmentOrderUtils.addOrderItems(po.getRemark(), po.getCode(), po.getStatus(), 
							BeanUtils.copyList(items, ReplenishmentOrderItem.class),
							systemService.getShopInfo(po.getShopId()).getFbaBarcodeKey(),
							po.getCmsPrepare()
							);
				}
				CommandReplenishmentOrderUtils.cancleOrderItem(po.getCode(), po.getStatus(), cancleOrderItemIds.toString()
						.substring(1), cancelReason.toString().substring(1),po.getCmsPrepare());
				
			}
		}
		
		if(cancleOrderItemIds.length() > 0||update.size() > 0){
			if(isCommuication(po)){
				CommandReplenishmentOrderUtils.updateOrderProductAmount(po.getCode(), po.getCostPrice(), po.getCostFreight(),po.getCmsPrepare());
			}
		}
	}
	
	@Override
	public void updateOrderProductInfos(List<UpdateOrdertProductInfo> updateOrdertProductInfos, String operator) {
		List<UpdateOrdertProductInfo> communication=new ArrayList<UpdateOrdertProductInfo>();
		StringBuilder remark=new StringBuilder();
		int orderId=0;
		for (UpdateOrdertProductInfo info : updateOrdertProductInfos) {
			ReplenishmentOrderItemPO item= this.replenishmentOrderItemDao.getObject(info.getOrderPrepareProductId());
			if(item==null)
				continue;
			
			orderId=item.getReplenishmentOrderId();
			StringBuilder subRemark=new StringBuilder();
			if(!(item.getCustomerRemark()==null?"":item.getCustomerRemark()).equals(info.getCustomerRemark())){
				subRemark.append(MessageFormat.format("商品备注：{0}-->{1}", item.getCustomerRemark(),info.getCustomerRemark()));
			}
			
			if(!(item.getCsRemark()==null?"":item.getCsRemark()).equals(info.getCsRemark())){
				subRemark.append(MessageFormat.format("客服备注：{0}-->{1}", item.getCsRemark(),info.getCsRemark()));
			}
			
			if(subRemark.length()>0){
				if(item.getStatus()<OrderProductStatus.取消.getVal())
					communication.add(info);
				remark.append(MessageFormat.format("更新订单项{0}信息：[{1}]", item.getCmsProductCode(),subRemark.toString()));
			}
				
			item.setCsRemark(info.getCsRemark());
			item.setCustomerRemark(info.getCustomerRemark());
		}
		
		if(remark.length()>0){
			addOrderOperateLog(remark.toString(), operator, orderId);
			ReplenishmentOrderPO po =this.replenishmentOrderDao.getObject(orderId);
			if(isCommuication(po))
				CommandReplenishmentOrderUtils.updateOrderItemRemarkToCMS(po.getCode(), communication,po.getCmsPrepare());
		}
	}
	
	protected ReplenishmentOrderItemPO addItemPO(FbaShopProduct fba,int orderId,
			 String updateProductCode, double qty, CMSProduct product) {
		ReplenishmentOrderItemPO ppo = new ReplenishmentOrderItemPO();
		ppo.setReplenishmentOrderId(orderId);
		ppo.setOrderedQuantity(qty);
		ppo.setPreparedQuantity(0);
		ppo.setUnit(product.getUnit());
		ppo.setUnitQty(product.getUnitQuantity());
		ppo.setStatus(OrderProductStatus.备货中.getVal());
		ppo.setCmsProductCode(updateProductCode);
		ppo.setCmsProductId(product.getId());
		ppo.setFbaBarcodeName(fba.getFbaBarcodeName());
		ppo.setFbaBarcodeSku(fba.getFbaBarcodeSku());
		ppo.setSku(fba.getSku());
		ppo.setCostPrice(product.getCostPrice().multiply(new BigDecimal(qty))
				.multiply(new BigDecimal(product.getUnitQuantity())).setScale(3, 4).doubleValue());
		ppo.setUnitVolume(CalcUtils.unitVoluem(product.getVolume(), product.getUnitQuantity()).doubleValue());
		ppo.setUnitWeight(CalcUtils.unitweight(product.getWeight(), product.getUnitQuantity()).doubleValue());
		ppo.setFbaShopProductId(fba.getId());
		return ppo;
	}
	
	protected void updateOrderProduct$cancel(ReplenishmentOrderItemPO ppo, ReplenishmentOrderPO orderPo,
			String operator, StringBuilder cancleOrderItemIds) throws BussinessException {

		int _old_status = ppo.getStatus();
		if (ppo.getStatus() > OrderProductStatus.已备货.getVal()) {
			throw new BussinessException("无法修改已备货商品");
		}

		ppo.setStatus(OrderProductStatus.取消.getVal());

		// 更新订单成本价
		orderPo.setCostPrice(orderPo.getCostPrice()- ppo.getCostPrice());

		// 更新订单项总数，已备量
		orderPo.setOrderItemNum(orderPo.getOrderItemNum() - 1);
		if (_old_status == OrderProductStatus.已备货.getVal()) {
			orderPo.setOrderItemPrepareNum(orderPo.getOrderItemPrepareNum() == 0 ? 0
					: orderPo.getOrderItemPrepareNum() - 1);
		}
		
		replenishmentOrderItemDao.mergeObject(ppo);
		cancleOrderItemIds.append(",").append(ppo.getId());
		//设置补货数量
		setReplenishment(ppo.getFbaShopProductId(), (int)ppo.getOrderedQuantity(),0);
	}
	
	
	
	protected void updateOrderProducts4Unit(String operator, ReplenishmentOrderPO po, UpdateOrderProductForm form,
			ReplenishmentOrderItemPO item, StringBuilder remark, CMSProduct product,List<ReplenishmentOrderItemPO> update) throws BussinessException {
		if (item.getOrderedQuantity() != form.getQty()) {
			remark.append(MessageFormat.format(item.getCmsProductCode()+"修改订购量：“{0}”为“{1}”;", String.valueOf(item.getOrderedQuantity()),
					form.getQty()));
			update.add(item);
		}
		
		//设置补货数量
		setReplenishment(item.getFbaShopProductId(), (int)item.getOrderedQuantity(),(int)form.getQty());
		
		// 更新订单成本价
		po.setCostPrice(po.getCostPrice()-item.getCostPrice());
		item.setCostPrice(product.getCostPrice().multiply(new BigDecimal(form.getQty()))
				.multiply(new BigDecimal(form.getUnitQty())).setScale(3, 4).doubleValue());
		po.setCostPrice(po.getCostPrice()+item.getCostPrice());
		
		item.setOrderedQuantity(form.getQty());
		item.setUnitQty(form.getUnitQty());
		if (item.getPreparedQuantity() >= item.getOrderedQuantity()) {
			if (item.getStatus() != OrderProductStatus.已备货.getVal()) {
				po.setOrderItemPrepareNum(po.getOrderItemPrepareNum() + 1);
			}
			item.setPreparedQuantity(item.getOrderedQuantity());
			item.setStatus(OrderProductStatus.已备货.getVal());
		} else {
			if (item.getStatus() == OrderProductStatus.已备货.getVal()) {
				po.setOrderItemPrepareNum(po.getOrderItemPrepareNum() - 1);
			}
			item.setStatus(OrderProductStatus.备货中.getVal());
		}
		
		
		double _result = item.getUnitQty() * item.getOrderedQuantity();
		replenishmentOrderItemDao.mergeObject(item);
		if (Double.valueOf((int) _result) != _result) {
			throw new BussinessException("任务数必须为整数！");
		}
		
	}
	
	/**
	 * sw订单增加商品项的限制
	 * @param po
	 * @param form
	 * @param product
	 */
	private void swOrderAddItemLimit(ReplenishmentOrderPO po, UpdateOrderProductForm form, CMSProduct product) {
		if(po.getCmsPrepare()==ORDER_PREPARE_TYPE_SW){
//			if(form.getQty()%(int)form.getQty()!=0){
//				throw new BussinessException("sw订单订购量必须是整数！");
//			}
			if(!CMSClient.isSwProduct(product.getId())){
				throw new BussinessException("sw订单只能包含sw商品！");
			}
		}
	}


	/**
	 * has not test
	 * 前端传给你的都是excel中的数据
	 * 只传cmsCode or sku  和修改之后的quantity
	 * @param orderId
	 * @param orderProducts
	 * @param operator
	 */
	public void addAndUpdateOrderProductList3(int orderId, List<UpdateOrderProductForm> orderProducts, String operator) {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);

		List<ReplenishmentOrderItemPO> oldOrderItemList = replenishmentOrderItemDao.findListByHql
				("from ReplenishmentOrderItemPO where replenishmentOrderId=? ", po.getId());

		//补全excel导入的商品信息，可能会查不到，抛出异常
		for(UpdateOrderProductForm form :orderProducts){
			ShopProductRelated relatedBySku = fbaShopProductService.getRelatedBySku(form.getSku(), po.getShopId());
			if (relatedBySku == null) {
				throw new BussinessException("有不合法的sku:" + form.getSku());
			}

			form.setUnitQty(relatedBySku.getUnitQuantity());
			form.setFbaShopProductId(relatedBySku.getId());
			form.setUpdateProductCode(relatedBySku.getCmsProductCode());
		}

		//判断商品是否已存在于原有的订单中
		//根据cmsCode来判断前台传入的所有的商品是否已经存在于原有的订单中，如果能匹配到就会认为这个商品已经存在
		//以后就算换为了sku也只需要改这个模块就好了
		Map<String, UpdateOrderProductForm> tempMap = new HashMap<String, UpdateOrderProductForm>();

//		Collections.sort();
		for (UpdateOrderProductForm orderProduct : orderProducts) {
			tempMap.put(orderProduct.getUpdateProductCode(), orderProduct);
		}
		List<String> str = new ArrayList<String>();
		for (ReplenishmentOrderItemPO oldReplenishmentOrderItemPO : oldOrderItemList) {
			str.add(oldReplenishmentOrderItemPO.getCmsProductCode());
		}

		MapUtils<UpdateOrderProductForm> updateOrderProductFormCompareMap = MapUtils.collectionCompareCollection(tempMap, str);

		//调用跟新和删除
		//更新的商品
		if (CollectionUtils.isNotEmpty(updateOrderProductFormCompareMap.getExistOrderItem())) {
			updateOrderProducts(orderId,operator,updateOrderProductFormCompareMap.getExistOrderItem());
		}

		//新增的商品
		if (CollectionUtils.isNotEmpty(updateOrderProductFormCompareMap.getNotExistOrderItem())) {
			addOrderProducts(orderId, updateOrderProductFormCompareMap.getNotExistOrderItem(), operator);
		}

	}



	@Override
	public void addAndUpdateOrderProductList(int orderId, List<UpdateOrderProductForm> orderProducts, String operator){
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);

//		List<String> checkSku = new ArrayList<String>();
//		for (UpdateOrderProductForm orderProduct : orderProducts) {
//			checkSku.add(orderProduct.getSku());
//		}
//
//		List<String> checkExcel = fbaInboundService.checkExcel(po.getShopId(), checkSku);
//		if (CollectionUtils.isNotEmpty(checkExcel)){
//			throw new BussinessException("有不合法的sku:"+checkExcel);
//		}

		for (UpdateOrderProductForm form : orderProducts) {
			if (form.getUpdateProductCode() != null) {
				ShopProductRelated relatedBySku = fbaShopProductService.getRelatedBySku(form.getSku(), po.getShopId());
//				ShopProductRelated relatedByOtherCode = fbaShopProductService.getRelatedByOtherCode(form.getUpdateProductCode(), po.getShopId());

				if (relatedBySku==null){
					throw new BussinessException("有不合法的sku:"+form.getSku());
				}

				if (form.getUpdateProductCode()!=null) {
					if (!form.getUpdateProductCode().trim().equalsIgnoreCase(relatedBySku.getCmsProductCode())) {
						throw new BussinessException("有不合法的cms_code:" + form.getUpdateProductCode());
					}
				}

				//set attributes
				if (form.getOrderProductId()==0) {
					form.setUnitQty(relatedBySku.getUnitQuantity());
					form.setUpdateProductCode(relatedBySku.getCmsProductCode());
//					form.setSku(relatedBySku.getSku());
					form.setFbaShopProductId(relatedBySku.getId());
				}
			}
		}

		List<UpdateOrderProductForm> oldItemList = new ArrayList<UpdateOrderProductForm>();
		List<UpdateOrderProductForm> newItemList = new ArrayList<UpdateOrderProductForm>();
		for (UpdateOrderProductForm orderProduct : orderProducts) {
			if (orderProduct.getOrderProductId() == 0){
				newItemList.add(orderProduct);
			}else {
				oldItemList.add(orderProduct);
			}
		}

		//更新的商品
		if (CollectionUtils.isNotEmpty(oldItemList)) {
			updateOrderProducts(orderId,operator,oldItemList);
		}

		//新增的商品
		if (CollectionUtils.isNotEmpty(newItemList)) {
			addOrderProducts(orderId, newItemList, operator);
		}
	}
	
	@Override
	public void addOrderProducts(int orderId, List<UpdateOrderProductForm> orderProducts, String operator)
			 {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		if (po == null)
			throw new BussinessException("参数错误");
		
		if (po.getStatus() > OrderStatus.已配货.getVal()) {
			throw new BussinessException("订单状态不允许操作！");
		}


		// 判断是否会出现重复的备货商品
		checkRepeat4UpdateOrderProduct(orderId, orderProducts);

		List<String> errSku = new ArrayList<String>();
		List<ReplenishmentOrderItemPO> items = new ArrayList<ReplenishmentOrderItemPO>();
//		boolean _order_has_limit_product = false;
		for (UpdateOrderProductForm form : orderProducts) {
			String updateProductCode = form.getUpdateProductCode();
			double _result = form.getUnitQty() * form.getQty();
			if (Double.valueOf((int) _result) != _result) {
				throw new BussinessException("任务数必须为整数！");
			}
			
			
			double qty = form.getQty();

			if (StringUtils.isEmpty(updateProductCode)) {
				continue;
			}
			CMSProduct product = CMSClient.getCMSProductByCode(updateProductCode);
			swOrderAddItemLimit(po, form, product);

			try {
				hasAvailableStockout(form, updateProductCode, product);
			} catch (Exception e) {
				errSku.add(updateProductCode);
				e.printStackTrace();
				continue;
			}

			FbaShopProduct fba=fbaShopProductService.getFbaShopProduct(form.getFbaShopProductId());
			// 再添加
			ReplenishmentOrderItemPO item = addItemPO(fba, orderId, updateProductCode, qty, product);
//			_order_has_limit_product = processOrderProductLimit4UpdateOrder(po, address, _order_has_limit_product,
//					product, ppo);
			item.setCmsPrepare(po.getCmsPrepare());


			if(po.getFbaReplenishmentPlanId()!=null){
				FbaReplenishmentPlanPO byHql = fbaReplenishmentPlanDao.getObject(po.getFbaReplenishmentPlanId());
				Integer isSubmitToAm = byHql.getIsSubmitToAm();
				if (isSubmitToAm != null && isSubmitToAm !=0) {
					item.setAmQuantity(qty);			//自动建单的有 补货计划id
				}
			}

			replenishmentOrderItemDao.addObject(item);
			items.add(item);
			po.setOrderItemNum(po.getOrderItemNum() + 1);
			//设置补货数量
			setReplenishment(item.getFbaShopProductId(), 0, (int)item.getOrderedQuantity());
			// 更新订单成本价
			po.setCostPrice((po.getCostPrice() == null ? 0 : po.getCostPrice()) + item.getCostPrice());
			addOrderOperateLog("新增订单商品项" + updateProductCode, operator, po.getId());
		}

		if (CollectionUtils.isNotEmpty(errSku)){
			throw new BussinessException("以下cmsCode不合法"+errSku);
		}

//		po.setElectronic(isElectronic(orderId));
		updateOrderStatusByOrderProduct(po);
		// cms备货
		if (isCommuication(po)) {
//			if (po.getStatus() > OrderStatus.准备货物.getVal()) {
//				// 已备货商品项<总有效项,订单为准备货物
//				po.setStatus(OrderStatus.准备货物.getVal());
//			}
			CommandReplenishmentOrderUtils.addOrderItems(po.getRemark(), po.getCode(), po.getStatus(), 
					BeanUtils.copyList(items, ReplenishmentOrderItem.class)
					,systemService.getShopInfo(po.getShopId()).getFbaBarcodeKey(),po.getCmsPrepare());
			CommandReplenishmentOrderUtils.updateOrderProductAmount(po.getCode(), po.getCostPrice(), po.getCostFreight(),po.getCmsPrepare());
		}
		replenishmentOrderDao.updateObject(po);
	}

	/**
	 * 是否通讯
	 * @param po
	 * @return
	 */
	protected boolean isCommuication(ReplenishmentOrderPO po) {
		if (po.getStatus() > OrderStatus.PENDING.getVal()) {
			return true;
		}
		return false;
	}
	
	@Override
	public void setShippingList(int orderId, List<ReplenishmentOrderShippingList> shippingList, String operator)throws BussinessException {
		if (CollectionUtils.isNotEmpty(shippingList)) {
			ReplenishmentOrderPO po= replenishmentOrderDao.getObject(orderId);
			if(po.getStatus()>=OrderStatus.已发货.getVal()){
				throw new BussinessException("订单已经发货，不能上传。");
			}
			po.setShippingListStatus(ReplenishmentShippingListStatus.已上传.getVal());
			replenishmentOrderDao.mergeObject(po);
			
			List<String> filaNames=new ArrayList<String>();
			for (ReplenishmentOrderShippingList atta : shippingList) {
				if(filaNames.contains(atta.getFileName())||
						getReplenishmentOrderShippingListPOByName(orderId, atta.getFileName())!=null){
					throw new BussinessException("文件“"+atta.getFileName()+"” 重复!");
				}
				filaNames.add(atta.getFileName());
			}
			
			// 写入附件
			for (ReplenishmentOrderShippingList atta : shippingList) {
				String UUID =attachmentHelper.saveAttachment(orderId, atta, REPLENISHMENT_SHIPPING_ATTACHMENT);
				atta.setFileCode(UUID);
				atta.setReplenishmentOrderId(orderId);
				ReplenishmentOrderShippingListPO attaPO = BeanUtils.copyProperties(atta,
						ReplenishmentOrderShippingListPO.class);
				replenishmentOrderShippingListDao.addObject(attaPO);
			}
			addOrderOperateLog("上传货运清单", operator, orderId);
		}
	}
	
	protected ReplenishmentOrderShippingListPO getReplenishmentOrderShippingListPOByName(int replenishmentOrderId,String fileName){
		String hql="from ReplenishmentOrderShippingListPO where replenishmentOrderId=? and fileName=?";
		return replenishmentOrderShippingListDao.findByHql(hql, new Object[]{replenishmentOrderId,fileName});
	}

	@Override
	public void auditShippingList(boolean isAuditThrough, int orderId, String operator) {
		ReplenishmentOrderPO po=replenishmentOrderDao.getObject(orderId);
		if(po.getShippingListStatus()!=ReplenishmentShippingListStatus.已上传.getVal())
			throw new BussinessException("未上传，无法审核！");
		
		addOrderOperateLog("货运清单审核"+(isAuditThrough?"通过":"不通过"), operator, orderId);
		if (isAuditThrough) {
			po.setShippingListStatus(ReplenishmentShippingListStatus.审核通过.getVal());
			//通知dms
			notifyShippingList2OthenSystem(orderId, operator);
		}else{
			po.setShippingListStatus(ReplenishmentShippingListStatus.审核不通过.getVal());
		}
		
	}

	@Override
	public void notifyShippingList2OthenSystem(int orderId, String operator) {
		// TODO dms主动来取附件
		ReplenishmentOrderPO po= replenishmentOrderDao.getObject(orderId);
		if (po.getShippingListStatus() == ReplenishmentShippingListStatus.审核通过.getVal()
				&& po.getStatus() >= OrderStatus.打包中.getVal()) {
			if(po.getCmsPrepare()==ORDER_PREPARE_TYPE_SW){
				Command2SW.setFBAFlag(po.getCode(), true);
			}else{
				DMSClient.setFBAFlag(po.getCode(), systemService.getCacheShopInfo(po.getShopId()));
			}
			addOrderOperateLog("货运单已经通知dms", operator, po.getId());
		}
	}
	
	@Override
	public void deleteShippingList(int orderId, int replenishmentOrderShippingListId, String operator) {
		ReplenishmentOrderShippingListPO listpo= replenishmentOrderShippingListDao.getObject(replenishmentOrderShippingListId);
		attachmentService.deleteAttachment(listpo.getFileCode());	
		replenishmentOrderShippingListDao.deleteObject(listpo);
		
		addOrderOperateLog("删除货运清单:"+listpo.getFileName(), operator, orderId);
	}
	
	@Override
	public void updateOrderAddress(int orderId, int repositoryId,boolean allUpdate, String operator) {
		// 防止重复更新
		boolean _is_need_update = true;
		Repository address=repositoryService.getRepositoryById(repositoryId);
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		ShopInfo shop = systemService.getShopInfo(po.getShopId());
		AccountSetting AccountSetting=DMSUtils.getAccountSetting(shop.getShopSource().intValue());
		if (po != null) {
			// 偏远
			boolean isRemote = false;
//			if (DMSClient.isRemote(adress.getCountryId(), po.getShippingMethod(), adress.getCity(),
//					adress.getPostalCode(), DMSUtils.getAccountSetting(shop.getDepartment(), shop.getType())))
//				isRemote = true;
			// 判断是否同票
//			po.setRemote(isRemote);
			if (po.getSendGroupId() != null) {
				if (allUpdate) {
					// 修改同票订单
					List<ReplenishmentOrderPO> orders = this.getTicketGrouypPOByGroupId(po.getSendGroupId());
					_is_need_update = false;
					for (ReplenishmentOrderPO ticket : orders) {
						updateAddressSimple(repositoryId, operator, address, ticket, AccountSetting, isRemote);
					}
				} else {
					// 取消同票
					this.cancelTicketGroup(po.getId(), operator);
				} 
			}

			if (_is_need_update) {
				updateAddressSimple(repositoryId, operator, address, po, AccountSetting, isRemote);
			}

		}
	}
	
	protected void setRepository(int orderId,int repositoryId) {
		ReplenishmentOrderRepositoryPO replenishmentOrderRepositoryPO=
				BeanUtils.copyProperties(repositoryService.getRepositoryById(repositoryId), ReplenishmentOrderRepositoryPO.class,new String[]{"id"});
		replenishmentOrderRepositoryPO.setId(orderId);
		
		replenishmentOrderRepositoryDao.mergeObject(replenishmentOrderRepositoryPO);
	}

	protected void updateAddressSimple(int repositoryId, String operator, Repository address, ReplenishmentOrderPO po,
			AccountSetting AccountSetting, boolean isRemote) {
		po.setCountry(address.getCountryId());
		po.setRepositoryId(repositoryId);
		setRepository(po.getId(), repositoryId);
		if(!po.isModifyDeliveryRemark()){
			po.setDeliveryRemark(address.getRemark());
		}
		addOrderOperateLog((po.getSendGroupId()==null?"修改货运地址":"同票订单修改货运地址"), operator, po.getId());
		updateOrderAddress2other(address, po, isRemote,AccountSetting);
	}
	
	
	@Override
	public void cancelTicketGroup(int orderId, String operator) {
		String hql = "SELECT a.* FROM dbo.[replenishment_order] a JOIN dbo.[replenishment_order] b "
				+ " ON a.send_group_id=b.send_group_id WHERE b.id=?";
		List<Object> param = new ArrayList<Object>();
		param.add(orderId);
		List<ReplenishmentOrderPO> pos = replenishmentOrderDao.findListBySql(hql, param);
		StringBuilder orderCodes = new StringBuilder();
		if (CollectionUtils.isNotEmpty(pos)) {
			List<Integer> ids = new ArrayList<Integer>();
			if (pos.size() <= 2) {
				for (ReplenishmentOrderPO orderPO : pos) {
					orderPO.setSendGroupId(null);
					orderCodes.append(",").append(orderPO.getCode());
					ids.add(orderPO.getId());
				}
			} else {
				ReplenishmentOrderPO orderPO = replenishmentOrderDao.getObject(orderId);
				orderPO.setSendGroupId(null);
				orderCodes.append(",").append(orderPO.getCode());
				ids.add(orderPO.getId());
			}

			for (Integer integer : ids) {
				addOrderOperateLog("取消同票：" + orderCodes.toString(), operator, integer);
			}

			// 通讯cms
			Command2CMS.removeOrderGroup(orderCodes.toString().substring(1), operator);
		}
	}
	
	
	/**
	 * 通讯货运地址
	 * 
	 * @param address
	 * @param po
	 * @param isRemote
	 */
	protected void updateOrderAddress2other(Repository address, ReplenishmentOrderPO po, boolean isRemote,AccountSetting AccountSetting) throws BussinessException {
//		if (!hasProblemForAddressInfo(address)) {
//			// 去掉“货运信息有问题”
//			clearProblem(po, OrderProblemType.货运信息有问题.getVal());
//		}
			if (isCommuication(po)) {
			// 已出库时要通信给dms
				if (po.getStatus() >= OrderStatus.已出库.getVal()&&po.getCmsPrepare()==ORDER_PREPARE_TYPE_CMS) {
					DMSClient.updateOrderShippingAddress2(address,
							po.getCode(),null,po.getShippingMethod(),
							po.getCPFType(),po.getCPFCode(),po.getCustomerName(),isRemote,
							AccountSetting);
				}
				// 通讯cms
				CommandReplenishmentOrderUtils.updateOrderaddress(po.getCode(), 
						address, 
						isRemote, po.getCPFType(),po.getCPFCode(),po.getCustomerName(),address.getRepositoryName()
						,po.getCmsPrepare());
		}

	}
	
	protected List<ReplenishmentOrderPO> getTicketGrouypPOByGroupId(int groupId) {
		Criteria criteria = new Criteria(ReplenishmentOrderPO.class);
		criteria.and(Restriction.eq("sendGroupId", groupId));
		return replenishmentOrderDao.list(criteria);
	}

	@Override
	public void updateShippingMethod( int orderId, int shippingMethod,boolean allUpdate, String operator) {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		// 防止重复更新
		boolean _is_need_update = true;
		AccountSetting AccountSetting=DMSUtils.getAccountSetting(
				systemService.getShopInfo(po.getShopId()).getShopSource().intValue());
		if (po != null && po.getShippingMethod() != shippingMethod) {
			// 判断是否同票
			if (po.getSendGroupId() != null) {
				if (allUpdate) {
					// 修改同票订单
					List<ReplenishmentOrderPO> orders = this.getTicketGrouypPOByGroupId(po.getSendGroupId());
					_is_need_update = false;
					for (ReplenishmentOrderPO ticket : orders) {
						addOrderOperateLog("修改货运方式"
								+ systemService.getShippingMethod(ticket.getShippingMethod()).getName() + "为"
								+ systemService.getShippingMethod(shippingMethod).getName(), operator, ticket.getId());
						ticket.setShippingMethod(shippingMethod);
						updateShippingMethod2other(shippingMethod, ticket,AccountSetting);
					}
				} else {
					// 取消同票
					this.cancelTicketGroup(po.getId(), operator);
				}
			}
			if (_is_need_update) {
				addOrderOperateLog("修改货运方式" + systemService.getShippingMethod(po.getShippingMethod()).getName() + "为"
						+ systemService.getShippingMethod(shippingMethod).getName(), operator, orderId);
				po.setShippingMethod(shippingMethod);
				updateShippingMethod2other(shippingMethod, po,AccountSetting);
			}
		}
	}
	
	public Repository getOrderRepository(int orderId){
		ReplenishmentOrderRepositoryPO po= this.replenishmentOrderRepositoryDao.getObject(orderId);
		return BeanUtils.copyProperties(po, Repository.class);
	}
	
	/**
	 * 通讯货运方式
	 * 
	 * @param shippingMethod
	 * @param po
	 */
	protected void updateShippingMethod2other(int shippingMethod, 
			ReplenishmentOrderPO po,AccountSetting AccountSetting) {
		// 去掉“无法识别货运方式”
//		clearProblem(po, OrderProblemType.无法识别货运方式.getVal());
		if (isCommuication(po)) {
			Repository repository=getOrderRepository(po.getId());
			// 已出库时要通信给dms
			if (po.getStatus() >= OrderStatus.已出库.getVal()) {
				try {
					DMSClient.updateOrderShippingAddress2(repository,
							po.getCode(),null,po.getShippingMethod(),
							po.getCPFType(),po.getCPFCode(),po.getCustomerName(),false,
							AccountSetting);
				} catch (BussinessException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
			// 通讯cms
			CommandReplenishmentOrderUtils.updateOrderDelivery(po.getCode(), shippingMethod, 0d,
					0,po.getCmsPrepare());
			// 修改报关百分比
//			CommandReplenishmentOrderUtils.updateOrder(BeanUtils.copyProperties(po,ReplenishmentOrder.class), "", 
//					po.getDeliveryRemark());
		}
	}

	@Override
	public void saveSendRemark(String fbaShipmentMethod, int orderId, String remark, String cpfCode, int cpfType, String operator) {
		ReplenishmentOrderPO po= replenishmentOrderDao.getObject(orderId);
		po.setFbaShipmentMethod(fbaShipmentMethod);
		replenishmentOrderDao.updateObject(po);

		if (po != null) {
			//save 货运方式
			po.setDeliveryRemark(remark);
			addOrderOperateLog("修改订单的发货说明:" + remark + ":FBA货运方式由原有的改为" + fbaShipmentMethod, operator, orderId);	//add log
			po.setModifyDeliveryRemark(true);
			// 通讯cms
			po.setCPFCode(cpfCode);
			po.setCPFType(cpfType);
			if (isCommuication(po)) {
//				if (po.getStatus() >= OrderStatus.已出库.getVal()) {
//					DMSClient.updateOrderShippingAddress2(address,
//							po.getCode(),null,po.getShippingMethod(),
//							po.getCPFType(),po.getCPFCode(),po.getCustomerName(),
//							isRemote,
//							AccountSetting);
//				}
				CommandReplenishmentOrderUtils.updateOrder(BeanUtils.copyProperties(po,ReplenishmentOrder.class), 
						operator);



			}
		}
	}

	@Override
	public ReplenishmentOrderDetail getReplenishmentOrderDetail(int orderId) {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		if (po != null) {
			ReplenishmentOrderDetail detail = new ReplenishmentOrderDetail();
//			po.setCmsReplenishment(true);
			detail.setReplenishmentOrder(BeanUtils.copyProperties(po, ReplenishmentOrder.class));
//			if(po.getStatus()>=OrderStatus.已出库.getVal()){
				ReplenishmentOrderRepositoryPO repositoryPO=replenishmentOrderRepositoryDao.getObject(po.getId());
				if(repositoryPO!=null){
					Repository repository = BeanUtils.copyProperties(repositoryPO, Repository.class);
					repository.setId(po.getRepositoryId());
					
					detail.setRepository(repository);
				}
					
//			}
			//仓库
			if(detail.getRepository()==null){
				Repository repository = repositoryService.getRepositoryById(po.getRepositoryId());


				if(repository != null && StringUtils.isEmpty(repository.getName())){
					repository.setName(po.getCustomerName());
				}
				detail.setRepository(repository);
			}
			
			//AutoGenerated
			if(po.getFbaReplenishmentPlanId()!=null){
				FbaReplenishmentPlanPO replenishmentPlanPO = fbaReplenishmentPlanDao.getObject(po.getFbaReplenishmentPlanId());
				detail.setAutoGenerated(replenishmentPlanPO.getIsSubmitToAm() != null && replenishmentPlanPO.getIsSubmitToAm() != 0);
				detail.setShippingMethodChangeable(false);
			}else{
				detail.setShippingMethodChangeable(true);
			}
			
			List<ReplenishmentOrderItem> items = getOrderProduct(orderId);
			if (CollectionUtils.isNotEmpty(items)) {
				for (ReplenishmentOrderItem item : items) {
					ShopProductCmsInfo cms = shopProductCmsInfoService.getShopProductCmsInfoByCode(item
							.getCmsProductCode());
					if (cms != null) {
						item.setAvailableQty(cms.getAvailableStock());
						item.setColorCardPictureCode(cms.getColorCardPictureCode());
						item.setPrimaryPictureCode(cms.getPrimaryPictureCode());
					}
				}
			}
			detail.setReplenishmentOrderItems(items);
			return detail;
		}
		return null;
	}

	@Override
	public List<ReplenishmentOrderItem> getOrderProduct(int orderId){
		Criteria criteria = new Criteria(ReplenishmentOrderItemPO.class);
		criteria.and(Restriction.eq("replenishmentOrderId", orderId));
		return BeanUtils.copyList(replenishmentOrderItemDao.list(criteria), ReplenishmentOrderItem.class);
	}
	
	@Override
	public BaseOrderItem getOrderItem(int orderId, int cmsProductId) {
		String hql="from ReplenishmentOrderItemPO where replenishmentOrderId=? and cmsProductId=?" +
				" order by id desc ";
		ReplenishmentOrderItemPO po=replenishmentOrderItemDao.findByHql(hql, new Object[]{orderId,cmsProductId});
		BaseOrderItem item=BeanUtils.copyProperties(po, BaseOrderItem.class);
		if(item!=null){
			item.setOrderId(po.getReplenishmentOrderId());
			item.setOrderQty(po.getOrderedQuantity());
			item.setPrepareQty(po.getPreparedQuantity());
		}
		return item;
	}
	
	@Override
	public List<ReplenishmentOrderShippingList> getShippingList(int orderId) {
		Criteria criteria=new Criteria(ReplenishmentOrderShippingListPO.class);
		criteria.and(Restriction.eq("replenishmentOrderId", orderId));
		return BeanUtils.copyList(replenishmentOrderShippingListDao.list(criteria), ReplenishmentOrderShippingList.class);
	}

	@Override
	public List<File> getShippingList2BussinessLine(String orderCode) {
		ReplenishmentOrderPO order= getOrderPOByCode(orderCode);
		if(order!=null&&order.getShippingListStatus()==ReplenishmentShippingListStatus.审核通过.getVal()){
			List<ReplenishmentOrderShippingList> ls=getShippingList(order.getId());
			List<File> files=new ArrayList<File>();
			for (ReplenishmentOrderShippingList l : ls) {
				files.add(attachmentService.getAttachmentFile(l.getFileCode()));
			}
			return files;
		}
		return null;
	}
	
	@Override
	public List<ReplenishmentOrder> getTicketGroup(int orderId) {
		String hql = "SELECT a.* FROM dbo.[replenishment_order] a JOIN dbo.[replenishment_order] b "
				+ " ON a.send_group_id=b.send_group_id WHERE b.id=?";
		List<Object> param = new ArrayList<Object>();
		param.add(orderId);
		List<ReplenishmentOrderPO> pos = replenishmentOrderDao.findListBySql(hql, param);
		return BeanUtils.copyList(pos, ReplenishmentOrder.class);
	}
	
	@Override
	public List<ReplenishmentOrder> getTicketGrouypByGroupId(int groupId) {
		Criteria criteria = new Criteria(ReplenishmentOrderPO.class);
		criteria.and(Restriction.eq("sendGroupId", groupId));
		return BeanUtils.copyList(replenishmentOrderDao.list(criteria), ReplenishmentOrder.class);
	}
	
	@Override
	public PageList<ReplenishmentOrder> findReplenishmentOrder(SearchOrderForm form, int currentPage, int pageSize) {
		boolean isQuery = true;

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM dbo.v_replenishment_order_ o ");

		StringBuilder where = new StringBuilder("");
		List<Object> params = new ArrayList<Object>();
		if (StringUtils.isNotEmpty(form.getOrderCode())) {
			where.append(" AND o.code LIKE ? ");
			params.add("%" + form.getOrderCode() + "%");
			isQuery = false;
		}
		if (form.getOperator() > 0 && form.getShopId() < 0) {
			sql.append(" INNER JOIN dbo.user_shop us ON us.shop_id=o.shop_id  ");
			where.append(" AND us.user_id=? ");
			params.add(form.getOperator());
		}
		if (isQuery) {
			if (form.getCmsPrepare() > -1) {
				where.append(" AND o.cms_prepare = ? ");
				params.add(form.getCmsPrepare());
			}
			if (form.getOrderStatus() > -1) {
				where.append(" AND o.status=? ");
				params.add(form.getOrderStatus());
			}
			if (StringUtils.isNotEmpty(form.getShopOrderStatus())) {
				where.append(" AND o.shop_order_status=? ");
				params.add(form.getShopOrderStatus());
			}
			if (form.getSendTag() > -1) {
				where.append(" AND o.is_send=? ");
				params.add(form.getSendTag());
			}
			if (form.getTicket() > -1) {
				where.append(" AND o.send_group_id=? ");
				params.add(form.getTicket());
			}
			if (form.getPurchaseDateFrom() != null) {
				where.append(" AND o.add_order_date>? ");
				params.add(com.itecheasy.common.util.DateUtils.getRealDate(form.getPurchaseDateFrom()));
			}
			if (form.getPurchaseDateTo() != null) {
				where.append(" AND o.add_order_date<? ");
				params.add(com.itecheasy.common.util.DateUtils.getFullDate(form.getPurchaseDateTo()));
			}
			if (form.getEarliestDeliveryDate() != null) {
				where.append(" AND o.latest_delivery_date>? ");
				params.add(com.itecheasy.common.util.DateUtils.getRealDate(form.getEarliestDeliveryDate()));
			}
			if (form.getLatestDeliveryDate() != null) {
				where.append(" AND o.earliest_delivery_date<?  ");
				params.add(com.itecheasy.common.util.DateUtils.getFullDate(form.getLatestDeliveryDate()));
			}
			if (form.getEarliestShipDate() != null) {
				where.append(" AND o.latest_shipping_date>? ");
				params.add(com.itecheasy.common.util.DateUtils.getRealDate(form.getEarliestShipDate()));
			}
			if (form.getLatestShipDate() != null) {
				where.append(" AND o.earliest_shipping_date<?  ");
				params.add(com.itecheasy.common.util.DateUtils.getFullDate(form.getLatestShipDate()));
			}
			if (StringUtils.isNotEmpty(form.getProductCode())) {
				where.append(" AND o.id IN (SELECT DISTINCT replenishment_order_id  FROM dbo.replenishment_order_product "
						+ "WHERE cms_product_code=? )");
				params.add(form.getProductCode());
			}

			if (StringUtils.isNotEmpty(form.getCustomerName())) {
				where.append(" AND o.customer_name LIKE ? ");
				params.add("%" + form.getCustomerName() + "%");
			}
			if (form.getCountry() > -1) {
				where.append(" AND o.country=? ");
				params.add(form.getCountry());
			}
			if (form.getShippingMethod() > -1) {
				where.append(" AND o.shipping_method=? ");
				params.add(form.getShippingMethod());
			}
			if (form.getShippingListStatus() > -1) {
				where.append(" AND o.shipping_list_status=? ");
				params.add(form.getShippingListStatus());
			}
			if (form.getShopId() > -1) {
				where.append(" AND o.shop_id=? ");
				params.add(form.getShopId());
			}
			if (form.getEstimateLatest() > -1) {
				Date currentDate = org.apache.commons.lang.time.DateUtils.addDays(new Date(), 2);
				if (form.getEstimateLatest() == 1) {
					where.append(" AND o.latest_shipping_date<?");
					params.add(currentDate);
				} else if (form.getEstimateLatest() == 0) {
					where.append(" AND o.latest_shipping_date> ?");
					params.add(currentDate);
				}
				where.append(" and o.status < 64 ");
			}

			if (form.getProblemStatus() > -1) {
				where.append(" AND o.problem_status = ? ");
				params.add(form.getProblemStatus());
			}

			if(StringUtils.isNotEmpty(form.getShipmentID())){
				where.append(" AND o.shipment_ID = ? ");
				params.add(form.getShipmentID());
			}	
			
			if (form.getProblemType() > -1) {
				where.append(" AND o.problem_type = ? ");
				params.add(form.getProblemType());
			}
		}
		PageList<ReplenishmentOrderViewPO> pages = replenishmentOrderViewDao.findPageListBySql(currentPage, pageSize, sql.toString(), where.toString(),
				" o.add_order_date desc", params);
		return BeanUtils.copyPageList(pages, ReplenishmentOrder.class);
	}


	protected ReplenishmentOrderPO getOrderPOByCode(String orderCode) {
		String hql = "from ReplenishmentOrderPO where code=?";
		return replenishmentOrderDao.findByHql(hql, orderCode);
	}
	
	

	@Override
	public void orderPutInStorage(int orderId, String operator) {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		if (po != null) {
			if(po.getStatus()!=OrderStatus.已发货.getVal()
					&&po.getStatus()!=OrderStatus.已入仓.getVal())
				throw new BussinessException("只有已发货、完成状态的订单可设置为已入仓");
			
			po.setStatus(OrderStatus.已入仓.getVal());
			// 通讯cms
			addOrderOperateLog("已入仓", operator, po.getId());
			
			List<ReplenishmentOrderItemPO> items=getOrderProductNotCancel(orderId);
			for (ReplenishmentOrderItemPO item : items) {
				shopProductInventoryService.setTheFbaReplenishment(item.getFbaShopProductId());
			}
		}
	}



	@Override
	public boolean orderCheck(int orderId, String operator) {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		if (isCouldChecking(po) && po.getStatus() == OrderStatus.已配货.getVal()) {
			com.itecheasy.webservice.cms.order.Order cmsOrder= CMSOrderClient.getOrderByCode(po.getCode());
			if(cmsOrder!=null&&!cmsOrder.isIsQualityInspection()){
				po.setStatus(OrderStatus.待校对.getVal());
				addOrderOperateLog("请求校对", operator, po.getId());
				Command2CMS.requestCheckOrder(po.getCode());
				// 通讯cms
				return true;
			}else{
				/**
				 * 2016-09-13
				 * 请求校对时判断订单在c3是否存在未完成的质检单，若有，则请求校对失败，弹出提示：订单正在质检，请质检完后再请求校对
				 */
				addOrderOperateLog("订单正在质检，请质检完后再请求校对。", operator, po.getId());
				return false;
			}
		}
		throw new BussinessException("无法请求校对");
	}
	
	@Override
	public void updateOrder(int orderId, String remark, boolean sendTag, int isQualityInspection,
			double subTotalPercent, boolean isUpdateSubTotalPercent, String operator) {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		if (po != null) {
			StringBuilder sb = new StringBuilder();
			sb.append("更新订单").append(po.getCode());
			if (StringUtils.isNotEmpty(remark) && !remark.equalsIgnoreCase(po.getRemark())) {
				sb.append("订单备注“").append(po.getRemark()).append("”更新为“").append(remark).append("”；");
				po.setRemark(remark);
			}
			if (po.getIsQualityInspection() != isQualityInspection && isQualityInspection > -1
					&& po.getStatus() < OrderStatus.已配货.getVal()) {
				po.setIsQualityInspection(isQualityInspection);
				sb.append("是否质检修改为“").append(isQualityInspection).append("”");
				if (isCommuication(po)) {
					Command2CMS.setQualityInspection(po.getCode(), isQualityInspection == 1 ? true : false);
				}
			}

			if (po.getIsSend() != sendTag) {
				if (po.getStatus() >= OrderStatus.已出库.getVal()) {
					throw new BussinessException("已出库状态之前的订单（不包含已出库）才可编辑发货标记！");
				}
				if ((po.getProblemVal() & OrderProblemType.货运信息有问题.getVal()) == OrderProblemType.货运信息有问题.getVal()) {
					throw new BussinessException("货运信息不全无法发货，请完善信息后再编辑发货标记！");
				}
				po.setIsSend(sendTag);
				sb.append("可发货标识更新为“").append(sendTag ? "是" : "否").append("”；");
				if (sendTag) {
					// 通讯cms，更新订单是否可发货
					if (isCommuication(po)) {
						CommandReplenishmentOrderUtils.updateOrderIsCanSend(po.getCode(), sendTag, operator,po.getCmsPrepare());
					}
					// 如果订单状态是已备货，则请求校对
					if (po.getStatus() == OrderStatus.已配货.getVal()
							&&isCouldChecking(po)) {
						orderCheck(po.getId(), operator);
					}
				} else {
					// 可发货为否时，C3订单拦截在已备货状态
					// po.setStatus(OrderStatus.已备货.getVal());
				}
			}
			
			if(po.getSubTotalPercent()!=subTotalPercent&&isUpdateSubTotalPercent){
				sb.append(MessageFormat.format("更新发票金额百分比：“{0}”为“{1}”", po.getSubTotalPercent(),subTotalPercent));
				po.setSubTotalPercent(subTotalPercent);
			}

			if (isCommuication(po)) {
				CommandReplenishmentOrderUtils.updateOrder(BeanUtils.copyProperties(po,ReplenishmentOrder.class), 
						operator);
			}

			addOrderOperateLog(sb.toString(), operator, orderId);
		}		
	}
	

	@Override
	public void cancelOrder(int orderId, int operator) {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		po.setOldStatus(po.getStatus());
		User user=profileService.getUserByID(operator);
		if (po != null) {
			if (po.getStatus() == OrderStatus.取消.getVal()) {
				return;
			}
			if (po.getStatus() > OrderStatus.已出库.getVal()) {
				// //发货中、已发货的订单，列表邮件—订单重发、取消订单置灰不可用
				sendEmail2Administator("无法取消订单", "订单" + po.getCode() + "当前状态:" + OrderStatus.getName(po.getStatus()));
				return;
			}
			po.setOrderCancelTag(true);
			boolean flag = false;
			int _old_status = po.getStatus();
			// 非同票
			if (po.getSendGroupId() == null) {
				// 1、pendding 直接取消
				if (_old_status == OrderStatus.PENDING.getVal()) {
					flag = true;
				} else if (_old_status > OrderStatus.PENDING.getVal() && _old_status < OrderStatus.打包中.getVal()) {
					// 2、Pending、准备货物、已备货、待校对、校对中、已校对的订单，客户取消后，osms直接取消，并通知c3取消订单
//					if (po.isCmsPrepare()) {
						// 2--包含非cms备货怎么发送邮件
//						cancelNotCMSPrepareProduct2email(po);
						flag = true;
//					} else {
//						// 2--准备货物状态的非c3备货订单，记录订单日志，
//						// 发邮件通知跟单员，邮件标题：客户取消订单YYY，正文：客户取消非c3备货的订单YYY，请通知相关业务人员停止备货
//						cancelNotCMSPrepareOrder2email(po);
//						flag = true;
//					}

				} else if (_old_status == OrderStatus.打包中.getVal() || _old_status == OrderStatus.已打包.getVal()
						|| _old_status == OrderStatus.已出库.getVal()) {
//					if (po.isCmsPrepare()) {
						// 3、打包中、已打包、已出库、已发货订单，客户取消后，osms打取消待确认标记，向cms和dms发起取消申请，等待后端反馈
						po.setAwaitConfirmCancel(true);
						orderCancelResendService.applyOrderOperating(po.getCode(), OrderApplyType.CANCEL.getVal());
						addOrderOperateLog(OrderStatus.getName(po.getStatus()) + "订单" + po.getCode() + "，申请取消",
								user.getName(), orderId);
						Command2CMS.orderApplayCancle(po.getCode(), user.getName(), user.getCode());
//					} else {
//						cancelNotCMSPrepareOrder2email(po);
//					}
				} else if (_old_status > OrderStatus.已出库.getVal()) {
					return;
				}
			} else {
				// 同票订单
				if (_old_status < OrderStatus.打包中.getVal()) {
					flag = true;
					// 解除同票
					this.cancelTicketGroup(po.getId(), user.getName());
//					cancelNotCMSPrepareProduct2email(po);
				} else if (_old_status == OrderStatus.打包中.getVal() || _old_status == OrderStatus.已打包.getVal()
						|| _old_status == OrderStatus.已出库.getVal()
				// ||_old_status==OrderStatus.已发货.getVal()
				) {
					if (po.getIsbackTag()) {
						po.setAwaitConfirmResend(true);
						// 订单正在打回，则等待打回结束，取消订单
						this.addOrderOperateLog("订单正在打回，等待打回结束，取消订单", "OSMS取消订单", po.getId());
					} else {
						List<ReplenishmentOrderPO> group = new ArrayList<ReplenishmentOrderPO>();
						group = this.getTicketGrouypPOByGroupId(po.getSendGroupId());
						String content = OrderStatus.getName(po.getStatus()) + "订单，申请订单取消订单";
						StringBuilder orderCodes = new StringBuilder();
						for (ReplenishmentOrderPO orderPO : group) {
							orderPO.setAwaitConfirmResend(true);
							orderCancelResendService.applyOrderOperating(po.getCode(), OrderApplyType.RESEND.getVal());
							orderPO.setOldStatus(orderPO.getStatus());
							orderCodes.append(",").append(orderPO.getCode());
							this.addOrderOperateLog(content, "OSMS取消订单", orderPO.getId());
						}
						Command2CMS.orderApplayResend(orderCodes.toString().substring(1), user.getName(), user.getCode());
					}
				}
			}
			if (_old_status != OrderStatus.取消.getVal() && flag) {
				setReplenishment4CancelOrder(po);
				replenishmentOrderDao.mergeObject(po);
				addOrderOperateLog("取消订单：" + po.getCode(), user.getName(), orderId);



				// 取消订单,订单跟踪状态更新为 “已完成”，商品项状态为“已删除”并需要通知C3
                String sql = "SELECT * FROM order_tracking o " +
                             "WHERE o.order_code=? ";
                List<Object> params = new ArrayList<Object>();
                //增加参数
                params.add(po.getCode());    //orderCode
                List<OrderTrackingPO> orderTrackingPOList = this.orderTrackingDao.findListBySql(sql, params);
                for (OrderTrackingPO orderTrackingPO : orderTrackingPOList) { //cancel之后把改订单下所有的订单跟踪改为已完成
                    orderTrackingPO.setStatus(20);          //30 已完成

                }
                this.orderTrackingDao.updateObject(orderTrackingPOList);


                //通过replenishment_order_id把补货订单下productList给查询出来
				String sql3 = "SELECT * FROM replenishment_order_product o "
						+ "WHERE o.replenishment_order_id=? ";
				List<Object> params3 = new ArrayList<Object>();
				params3.add(orderId);
				List<ReplenishmentOrderItemPO> itemList = replenishmentOrderItemDao.findListBySql(sql3,params3);

                //如果订单中只有一个商品，就直接把订单给改为已完成
//                if(itemList!=null && itemList.size()==1){
//					for (OrderTrackingPO orderTrackingPO : orderTrackingPOList) { //cancel之后把改订单下所有的订单跟踪改为已完成
//						orderTrackingPO.setStatus(30);          //30 已完成
//					}
//				}
//				this.orderTrackingDao.updateObject(orderTrackingPOList);

                //把ordertracking中的product的状态给变更为取消      相当于与ON op.cms_product_code=repItem.cms_product_code
                String sql2 = "SELECT * FROM order_tracking_product op " +
                        "INNER JOIN " +
                        "(SELECT  * FROM order_tracking ) o " +
                        "ON op.order_tracking_id = o.id " +
                        "WHERE o.order_code=? and op.cms_product_code=? ";
                if (itemList!= null && itemList.size()!=0) {
                    for (int i = 0; i < itemList.size(); i++) {

                        List<Object> params2 = new ArrayList<Object>();
                        params2.add(po.getCode());    //orderCode
                        params2.add(itemList.get(i).getCmsProductCode());   //productCode

                        List<OrderTrackingProductPO> orderTrackingProductPOList = this.orderTrackingProductDao.findListBySql(sql2, params2);

                        //update    //把查出来的订单跟踪下的每个item更新
                        if (orderTrackingProductPOList != null && orderTrackingProductPOList.size() != 0) {
                            for (OrderTrackingProductPO orderTrackingProductPO : orderTrackingProductPOList) {
                                orderTrackingProductPO.setDeleted(true);
                                orderTrackingProductDao.updateObject(orderTrackingProductPOList);
                            }
                        }
                    }
                }

				// 通讯cms
				if (_old_status > OrderStatus.PENDING.getVal()) {
					CommandReplenishmentOrderUtils.cancleOrder(po.getCode(),profileService.getUserByID(operator),po.getCmsPrepare());
				}
			}
		}
	}
	
	@Override
	public void addTicketGroup(int[] orderIds, String operator) {
		if (orderIds == null || orderIds.length < 1) {
			return;
		}
		StringBuilder sql = new StringBuilder("SELECT DISTINCT  customer_name, "
				+ "ISNULL(address_line1,'')+ ISNULL(address_line2,'') as address_line1," + "  country_id , "
				+ "state_or_Region ,  city  ,  postal_code , phone "
				+ "  FROM dbo.fba_repository r " +
				" INNER JOIN dbo.replenishment_order o ON o.repository_id= r.id " +
				"  WHERE o.id IN (");
		String param = CollectionUtils.array2List(orderIds).toString();
		sql.append(param.substring(1, param.length() - 1)).append(")");
		List<Repository> adds = replenishmentOrderDao.findListBySql(sql.toString(), null, Repository.class);

		StringBuilder sql2 = new StringBuilder("SELECT * FROM dbo.[replenishment_order] WHERE status <60 AND "
				+ " id in (");
		sql2.append(param.substring(1, param.length() - 1)).append(")");
		List<ReplenishmentOrderPO> pos = replenishmentOrderDao.findListBySql(sql2.toString(), null);
		
		if (pos.size() != orderIds.length || adds.size() > 1) {
			throw new BussinessException(ERROR_ADD_SEND_GROUP);
		}

		// 货运方式
		int shippingMethod = pos.get(0).getShippingMethod();
		// 进行同票处理
		int ticketGroupId = -1;
		List<ReplenishmentOrderPO> tmp = new ArrayList<ReplenishmentOrderPO>();
		for (ReplenishmentOrderPO orderPO : pos) {
			if (orderPO.getStatus() > OrderStatus.待校对.getVal()) {
				throw new BussinessException(MessageFormat.format("订单{0}状态不对无法操作同票", orderPO.getCode()));
			}
			if (orderPO.getShippingMethod() != shippingMethod) {
				throw new BussinessException(ERROR_ADD_SEND_GROUP);
			}
			if (orderPO.getSendGroupId() != null) {
				ticketGroupId = orderPO.getSendGroupId();
				tmp.addAll(getTicketGrouypPOByGroupId(ticketGroupId));
			}
		}
		// 如果都没有被同票过，则获得新的同票ID
		if (ticketGroupId < 0) {
			ticketGroupId = getMaxTicketGroupID() + 1;
			tmp = pos;
		} else {
			for (ReplenishmentOrderPO orderPO : pos) {
				if (!tmp.contains(orderPO)) {
					tmp.add(orderPO);
				}
			}
		}
		StringBuilder orderCodes = new StringBuilder();
		List<Integer> ids = new ArrayList<Integer>();
		for (ReplenishmentOrderPO orderPO : tmp) {
			orderPO.setSendGroupId(ticketGroupId);
			ids.add(orderPO.getId());
			orderCodes.append(",").append(orderPO.getCode());
		}

		// 记录操作日志
		for (Integer integer : ids) {
			addOrderOperateLog("增加同票：" + orderCodes.toString(), operator, integer);

			// 发送邮件
			sendEmail2Administator("增加同票", "增加同票:" + orderCodes.toString());
		}
		// 通讯cms
		Command2CMS.updateOrderGroup(ticketGroupId, orderCodes.toString().substring(1), operator);
	}
	
	

	@Override
	public void cancelOrderCommunication(int orderId, String operator) {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		if (po != null) {
			int _old_status = po.getStatus();
			if (_old_status != OrderStatus.取消.getVal()) {
				setReplenishment4CancelOrder(po);
				replenishmentOrderDao.mergeObject(po);
				addOrderOperateLog("取消订单：" + po.getCode(), operator, orderId);
				CommandReplenishmentOrderUtils.cancleOrder(po.getCode(),null,po.getCmsPrepare());
			}
		}
	}
	
	@Override
	public void putway(int orderId, String operator) {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		if (po != null) {
			po.setAwaitPutaway(true);
			// 上架申请
			// Command2CMS.orderApplyPutway(po.getCode());
			// dms确认
			// DMSClient.updateBackOrderInfo(systemService.getShop(po.getShopId()),
			// po.getCode());
			// 发送邮件
			String content = MessageFormat.format("订单{0}退件", po.getCode());
			sendEmail2Customerservices(po.getMerchandiserId(), content, content);
			addOrderOperateLog("DMS上架", operator, po.getId());
		}
	}
	
	@Override
	public void setPutawayFlag(int orderId, String operator) {
		ReplenishmentOrderPO po = replenishmentOrderDao.getObject(orderId);
		if (po != null) {
			po.setAwaitPutaway(true);
			addOrderOperateLog("DMS上架", operator, po.getId());
		}
	}
	
	/**
	 * 订单进入sw系统开关
	 * @return
	 */
	private boolean isOpeaSw(){
		if("0".equals(DeployProperties.getInstance().getProperty("rp.sw.on"))){
			return false;
		}
		return true;
	}
	
	/**
	 * 设置sw备货
	 * @param po
	 * @return
	 */
	private boolean pendding2swPrepare(ReplenishmentOrderPO po){
		List<ReplenishmentOrderItemPO> pos=this.getOrderProductNotCancel(po.getId());
		if(isOpeaSw()){
			po.setCmsPrepare(ORDER_PREPARE_TYPE_SW);
			for (ReplenishmentOrderItemPO orderPrepareProductPO : pos) {
				orderPrepareProductPO.setCmsPrepare(ORDER_PREPARE_TYPE_SW);
			}
			return true;
		}else{
			return false;
		}
		
	}
	
	
	/**
	 * 取消订单，设置订单的商品的补货量
	 * @param po
	 */
	protected void setReplenishment4CancelOrder(ReplenishmentOrderPO po) {
		po.setStatus(OrderStatus.取消.getVal());
		List<ReplenishmentOrderItem>  items=getOrderProduct(po.getId());
		for (ReplenishmentOrderItem item : items) {
			if(item.getStatus()!=OrderProductStatus.取消.getVal()){
				setReplenishment(item.getFbaShopProductId(), (int)item.getOrderedQuantity(), 0);
			}
		}
	}

	
	protected void setReplenishment(int fbaShopProductId,int oldVal,int newVal){
		fbaShopProductUpdateControl.fbaReplenishment(fbaShopProductId, newVal-oldVal);
	}
	
	@Override
	public ReplenishmentOrder getReplenishmentOrderByCode(String code) {
		return BeanUtils.copyProperties(getOrderPOByCode(code), ReplenishmentOrder.class);
	}
	
	@Override
	public ReplenishmentOrderItem getOrderProduct(int orderId, int cmsProductId) {
		Criteria criteria = new Criteria(ReplenishmentOrderItemPO.class);
		criteria.and(Restriction.eq("replenishmentOrderId", orderId));
		criteria.and(Restriction.eq("cmsProductId", cmsProductId));
		criteria.and(Restriction.notEq("status", OrderProductStatus.取消.getVal()));
		return BeanUtils.copyProperties(replenishmentOrderItemDao.get(criteria), ReplenishmentOrderItem.class);
	}

	@Override
		public FbaReplenishmentPlan getFbaReplenishmentPlanByOrderId(Integer orderId) {

		ReplenishmentOrderPO replenishmentOrderPO = replenishmentOrderDao.getObject(orderId);

		String sql = "SELECT * FROM fba_replenishment_plan " +
						"WHERE id=? ";
		List<Object> params = new ArrayList<Object>();
		params.add(replenishmentOrderPO.getFbaReplenishmentPlanId());

		List<FbaReplenishmentPlanPO> fbaReplenishmentPlanPO = this.fbaReplenishmentPlanDao.findListBySql(sql,params);
		if(fbaReplenishmentPlanPO!=null) {
			return BeanUtils.copyProperties(fbaReplenishmentPlanPO.get(0), FbaReplenishmentPlan.class);

		}
		return null;
	}
}
