package com.itecheasy.core.order;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itecheasy.core.fba.Repository;
import com.itecheasy.core.order.dao.*;
import com.itecheasy.core.po.*;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.LockMode;

import com.itecheasy.common.PageList;
import com.itecheasy.common.Param;
import com.itecheasy.common.dao.Criteria;
import com.itecheasy.common.dao.Order.OrderType;
import com.itecheasy.common.dao.Restriction;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CalcUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.ConstantUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.common.util.NumberComparator;
import com.itecheasy.communication.order.Command2CMS;
import com.itecheasy.communication.order.CommandOrderUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.PackageStatus.PackageTraceStatus;
import com.itecheasy.core.fba.UpdateOrdertProductInfo;
import com.itecheasy.core.product.CMSProduct;
import com.itecheasy.core.system.Country;
import com.itecheasy.core.system.ShippingMethod;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.system.ShopService;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.core.user.User;
import com.itecheasy.core.util.SystemEnumDicts.ShopType;
import com.itecheasy.webservice.client.CMSClient;
import com.itecheasy.webservice.client.CMSOrderClient;
import com.itecheasy.webservice.client.DMSClient;
import com.itecheasy.webservice.client.DMSUtils;
import com.itecheasy.webservice.dms.AccountSetting;

import javax.annotation.Resource;

/**
 * @author wanghw
 * @date 2015-5-12
 * @description 订单核心业务
 * @version
 */
public class OrderServiceImpl extends BaseOrder implements OrderService {
//	private final static Logger LOGGER=Logger.getLogger(OrderServiceImpl.class);
	public static final String ORDER_SHOP_CANCELED = "Canceled";
	private static final String ERROR_ORDER_STATUS_ = "订单状态不对，无法操作！";
	private static final String ERROR_ADD_SEND_GROUP = "只有C3备货的订单，且货运方式和货运地址完全相同的待校对之前（包含待校对）的订单才能同票";
	private final static String COMMA_SPLIT = ",";
	private final static String AMAZON_DELIVERY_SIZE = DeployProperties.getInstance().getProperty(
			"amazon.delivery.size");

	protected OrderDao orderDao;
	protected OrderAddressDao orderAddressDao;
	protected OrderProductDao orderProductDao;
	protected OrderPrepareProductDao orderPrepareProductDao;
	protected OrderOperateLogDao orderOperateLogDao;
	protected OrderCustomerDao orderCustomerDao;
	protected VOrderDao vOrderDao;
	protected OrderDeliveryTaskDao orderDeliveryTaskDao;
	protected OrderCountReportUpdateTaskDao orderCountReportUpdateTaskDao;
	protected ProfileService profileService;
	protected PackageProblemService packageProblemService;
	protected OrderCancelResendService orderCancelResendService;
	protected ShopService shopService;


	protected OrderTrackingProductDao orderTrackingProductDao;   //只给本类使用
	protected OrderTrackingDao orderTrackingDao;

	public void setOrderTrackingDao(OrderTrackingDao orderTrackingDao) {
		this.orderTrackingDao = orderTrackingDao;
	}

	public void setOrderTrackingProductDao(OrderTrackingProductDao orderTrackingProductDao) {
		this.orderTrackingProductDao = orderTrackingProductDao;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}
	

	public void setOrderCancelResendService(OrderCancelResendService orderCancelResendService) {
		this.orderCancelResendService = orderCancelResendService;
	}

	public void setPackageProblemService(PackageProblemService packageProblemService) {
		this.packageProblemService = packageProblemService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setOrderCountReportUpdateTaskDao(OrderCountReportUpdateTaskDao orderCountReportUpdateTaskDao) {
		this.orderCountReportUpdateTaskDao = orderCountReportUpdateTaskDao;
	}

	public void setOrderDeliveryTaskDao(OrderDeliveryTaskDao orderDeliveryTaskDao) {
		this.orderDeliveryTaskDao = orderDeliveryTaskDao;
	}

	public void setvOrderDao(VOrderDao vOrderDao) {
		this.vOrderDao = vOrderDao;
	}

	public void setOrderCustomerDao(OrderCustomerDao orderCustomerDao) {
		this.orderCustomerDao = orderCustomerDao;
	}

	public void setOrderOperateLogDao(OrderOperateLogDao orderOperateLogDao) {
		this.orderOperateLogDao = orderOperateLogDao;
	}

	public void setOrderProductDao(OrderProductDao orderProductDao) {
		this.orderProductDao = orderProductDao;
	}

	public void setOrderPrepareProductDao(OrderPrepareProductDao orderPrepareProductDao) {
		this.orderPrepareProductDao = orderPrepareProductDao;
	}

	public void setOrderAddressDao(OrderAddressDao orderAddressDao) {
		this.orderAddressDao = orderAddressDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	//
	// private boolean hasOtherPrepareProduct(String cmsProductCode) {
	// String sql =
	// "SELECT cms_product_code as cmsProductCode FROM dbo.other_prepare_product"
	// + " WHERE cms_product_code=?";
	// List<Object> params = new ArrayList<Object>();
	// params.add(cmsProductCode);
	// List<OrderProduct> products = orderDao.findListBySql(sql, params,
	// OrderProduct.class);
	// if (CollectionUtils.isNotEmpty(products))
	// return true;
	// return false;
	// }
	
	/**
	 * 订单进入sw系统开关
	 * @return
	 */
	private boolean isOpeaSw(){
		if("0".equals(DeployProperties.getInstance().getProperty("sw.on"))){
			return false;
		}
		return true;
	}
	
	
	public void addOrderByManual(OrderDetail order, int type, String operator) throws BussinessException{
		order.setManual(BooleanUtils.isNotTrue(order.getIsOtherSystem()));//手动录单
		order.setFulfillmentChannel(ConstantUtils.FULFILLMENTCHANNELS_MFN);
		order.setCmsPrepare(OrderService.ORDER_PREPARE_TYPE_CMS);
		ConditionOfAddNewOrder condition = new ConditionOfAddNewOrder();
		for (OrderProduct op : order.getOrderItems()) {
			if (mateOtherProductOfOrder(order.getOrderAddress(), condition, op.getCmsProductCode(), op)) {
				//无法匹配
				condition.setOrder_status(0);
				condition.set_not_recognition(true);
			}
		}
		this.initOrderProblem(order, order.getOrderAddress(), condition);
		order.setCostPrice(condition.get_cost_price());
//		order.setShopShippingPrice(condition.getShipTotalPrice());
		addOrder(order, type, operator);
	}
	
	@Override
	public void addOrder(OrderDetail order, int type, String operator) throws BussinessException {
		// 生成code
		ShopInfo info = systemService.getCacheShopInfo(order.getShopId());
		if(order.getMerchandiserId()==null)
			order.setMerchandiserId(systemService.getMerchandiserByCode(info.getMerchandiserId()).getId());
		OrderPO po = BeanUtils.copyProperties(order, OrderPO.class, new String[] { "orderAddress", "orderItems" });
		if(BooleanUtils.isTrue(order.getIsOtherSystem())&&StringUtils.isNotEmpty(order.getCode())){
			
		}else{
			String code = createOrderCode(type);
			po.setCode(code);
			order.setCode(code);
		}
		po.setAddOrderDate(new Date());
		po.setOrderItemNum(order.getOrderItems().size());
		po.setOrderItemPrepareNum(0);
		// 是否第一次下单
		if(BooleanUtils.isNotTrue(order.getManual())
				&&BooleanUtils.isNotTrue(order.getIsOtherSystem())){
			order.setFirstWebOrder(isFirstWebOrder(po.getCustomerAccount(), po.getCustomerName(), type));
			po.setFirstWebOrder(order.isFirstWebOrder());
		}

		OrderAddressPO orderAddressPO = BeanUtils.copyProperties(order.getOrderAddress(), OrderAddressPO.class);
		ShopInfo shop = systemService.getShopInfo(order.getShopId());
		boolean isRemote = false;
		if (!ConstantUtils.FULFILLMENTCHANNELS_AFN.equals(order.getFulfillmentChannel())//fba不用算
				&&DMSClient.isRemote(orderAddressPO.getCountryId(), order.getShippingMethod(), orderAddressPO.getCity(),
				orderAddressPO.getPostalCode(), DMSUtils.getAccountSetting(shop.getShopSource().intValue())))
			isRemote = true;
		po.setRemote(isRemote);
		
		Integer id = orderDao.addObject(po);
		orderAddressPO.setOrderId(id);
		orderAddressDao.addObject(orderAddressPO);
		
		boolean _all_cms_prepare = true;
		//全部sw备货才走sw系统
		boolean _all_sw_prepare=true;
		// TS商品个数
		int _not_cms = 0;
		
		//2016-09-13 ebay 美国发货到美国，走am仓库发货， 设置非cms备货
		boolean _ebay_us_=false;
		if(type==ShopType.EBAY.getVal()&&"USPSFirstClass".equals(order.getShopShippingMethod())
				&&order.getCountry()!=null&&order.getCountry().equals(US)){
			_ebay_us_=true;
		}
		
		if (CollectionUtils.isNotEmpty(order.getOrderItems())) {
			//sw 2017-08-02 订单走sw系统
			//sw系统开关
			for (OrderProduct product : order.getOrderItems()) {
				if(isOpeaSw()&&type==ShopType.AMAZON.getVal()&&product.getCmsProductId()>0&&CMSClient.isSwProduct(product.getCmsProductId())){
					product.setProductSw(true);
				}else{
					_all_sw_prepare=false;
					break;
				}
			}
		
			if(_all_sw_prepare){
				po.setCmsPrepare(ORDER_PREPARE_TYPE_SW);
			}
			for (OrderProduct product : order.getOrderItems()) {
				OrderProductPO productPo = BeanUtils.copyProperties(product, OrderProductPO.class);
				productPo.setOrderId(id);
				Integer productId = orderProductDao.addObject(productPo);
				product.setId(productId);
				product.setOrderId(id);
				OrderPrepareProductPO orderPrepareProductPO = new OrderPrepareProductPO();
				orderPrepareProductPO.setOrderId(id);
				if(BooleanUtils.isTrue(order.getManual())&&product.getOrderPrepareProduct()!=null){
					orderPrepareProductPO.setOrderQty(product.getOrderPrepareProduct().getOrderQty());
				}else{
					orderPrepareProductPO.setOrderQty(product.getShopQuantityOrdered());
				}
				orderPrepareProductPO.setPrepareQty(0);
				orderPrepareProductPO.setUnit(product.getUnit());
				orderPrepareProductPO.setUnitQty(product.getUnitQty());
				orderPrepareProductPO.setCmsProductId(product.getCmsProductId());
				orderPrepareProductPO.setAbnormalMate(product.isAbnormalMate());
				if (po.getStatus() == 0) {
					orderPrepareProductPO.setStatus(0);
				} else {
					orderPrepareProductPO.setStatus(product.getStatus());
				}
				if(product.getOrderPrepareProduct()!=null){
					orderPrepareProductPO.setCsRemark(product.getOrderPrepareProduct().getCsRemark());
					orderPrepareProductPO.setCustomerRemark(product.getOrderPrepareProduct().getCustomerRemark());
				}
				orderPrepareProductPO.setIslimit(product.getIslimit());
				orderPrepareProductPO.setOrderProductId(productId);
				orderPrepareProductPO.setUnitVolume(product.getUnitVolume());
				orderPrepareProductPO.setUnitWeight(product.getUnitWeight());
				orderPrepareProductPO.setCmsProductCode(product.getCmsProductCode());
				orderPrepareProductPO.setCostPrice(product.getCostPrice());
				if(_all_sw_prepare){
					orderPrepareProductPO.setCmsPrepare(ORDER_PREPARE_TYPE_SW);
				}
				// amazon ts商品设置非cms备货
				//-->>2016-10-07去掉ts商品非cms备货设置
				else if (
//					(product.isProductTs()&&type==ShopType.AMAZON.getVal())||  
						_ebay_us_) {
					_all_cms_prepare = false;
					_not_cms++;
					orderPrepareProductPO.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
				}else{
					orderPrepareProductPO.setCmsPrepare(ORDER_PREPARE_TYPE_CMS);
				}
				orderPrepareProductPO.setElectronic(product.isElectronic());
				orderPrepareProductPO.setMagnetism(product.isMagnetism());
				orderPrepareProductPO.setTextile(product.isTextile());
				
				int orderPrepareProductId = orderPrepareProductDao.addObject(orderPrepareProductPO);
				product.setOrderPrepareProduct(BeanUtils.copyProperties(orderPrepareProductPO,
						OrderPrepareProduct.class));
				product.setObjectId(orderPrepareProductId);
			}

			// //FBA商品使用FBA库存
			// if(ConstantUtils.FULFILLMENTCHANNELS_AFN.equalsIgnoreCase(order.getFulfillmentChannel())){
			// for (OrderProduct product : order.getOrderItems()) {
			// fbaStoreOrderService.useFBAStoreProduct(product);
			// }
			// }
		}

		addOrderOperateLog(BooleanUtils.isTrue(order.getManual())?"手动录单":"系统添加订单", operator, id);
		
		/**
		 * fba订单通讯给cms
		 * 2016-12-15 10:04:31
		 */
		if(ConstantUtils.FULFILLMENTCHANNELS_AFN.equalsIgnoreCase(order.getFulfillmentChannel())){
			Command2CMS.addOrder(this.getOrderDeatil(po.getId()), info);
			return;
		}

		// 通讯cms,根据店铺判断是否走采购
		if (order.getStatus() > OrderStatus.PENDING.getVal() && _all_cms_prepare) {
			if(!CommandOrderUtils.addOrder(this.getOrderDeatil(po.getId()), info,
					BooleanUtils.isNotTrue(po.getManual())
					&&BooleanUtils.isNotTrue(po.getIsOtherSystem()))){
//				po.setStatus(OrderStatus.PENDING.getVal());
			}
		}

		/******************* TS紧急补丁改 *****************/
		if (!_all_cms_prepare) {
			if (_not_cms == order.getOrderItems().size()) {
				po.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
				po.setStatus(OrderStatus.准备货物.getVal());
			} else {
				// 通讯到cms
				if (order.getStatus() > OrderStatus.PENDING.getVal()) {
					if(!CommandOrderUtils.addOrder(this.getOrderDeatil(po.getId()), info,
							BooleanUtils.isNotTrue(po.getManual())
							&&BooleanUtils.isNotTrue(po.getIsOtherSystem()))){
//						po.setStatus(OrderStatus.PENDING.getVal());
					}
				}
			}
		}
		/******************* TS紧急补丁改 *****************/
	}
	
	public void confirmOrder(int orderId, String operator) throws BussinessException{
		OrderPO po=this.orderDao.getObject(orderId);
		if(po!=null&&isNeedAdd2Other(po)){
			int count = this.getOrderPrepareProduct4LIMIT(po.getId());
			if (count < 1) {
				// 通讯到cms
				po.setStatus(OrderStatus.准备货物.getVal());
				CommandOrderUtils.addOrder(this.getOrderDeatil(po.getId()), systemService.getShopInfo(po.getShopId()),false);
				addOrderOperateLog("确认订单", operator, po.getId());
				return ;
			}
		}
		throw new BussinessException(EX_CONFIRM_ORDER);
	}

	/**
	 * 
	 * @param customerAccount
	 *            邮箱
	 * @param customerName
	 *            全称
	 * @param type
	 *            店铺类型
	 * @return
	 */
	private boolean isFirstWebOrder(String customerAccount, String customerName, int type) {
		Criteria criteria = new Criteria(OrderCustomerPO.class);
		if (customerAccount != null) {
			criteria.and(Restriction.eq("account", customerAccount));
		} else {
			criteria.and(Restriction.isNull("account", ""));

		}
		criteria.and(Restriction.eq("name", customerName));
		criteria.and(Restriction.eq("type", type));

		int result = orderCustomerDao.getCount(criteria);
		if (result > 0) {
			return false;
		}
		OrderCustomerPO po = new OrderCustomerPO();
		po.setAccount(customerAccount);
		po.setName(customerName);
		po.setType(type);
		orderCustomerDao.addObject(po);
		return true;
	}

	private String createOrderCode(Integer type) {
		List<Param> parameters = new ArrayList<Param>();
		parameters.add(new Param("shopType", type == null ? 0 : type));
		parameters.add(new Param("Code", ""));
		String object = orderDao.execStoredProcedure4output("[dbo].[Order_OrderIdBuild]", parameters);
		if (object != null) {
			return object.toString();
		}
		return null;
	}
	
	@Override
	public Order getOrderByShopOrderCode(String ShopOrderCode, int shopType) {
		String hql = "SELECT * FROM dbo.[order] WHERE shop_order_code=? AND  shop_type=? order by id desc";
		List<Object> params = new ArrayList<Object>();
		params.add(ShopOrderCode);
		params.add(shopType);
		List<OrderPO> pos = orderDao.findListBySql(hql, params);
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyProperties(pos.get(0), Order.class);
		}
		return null;
	}
	
	@Override
	public Order getOrderByShopOrderCode(String ShopOrderCode, int shopType, int shopId) {
		String hql = "SELECT * FROM dbo.[order] WHERE shop_order_code=? AND  shop_type=? and shop_id=? order by id desc";
		List<Object> params = new ArrayList<Object>();
		params.add(ShopOrderCode);
		params.add(shopType);
		params.add(shopId);
		List<OrderPO> pos = orderDao.findListBySql(hql, params);
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyProperties(pos.get(0), Order.class);
		}
		return null;
	}
	
	

	@Override
	public Order getOrderByShopOrderUnique(String Unique, int shopType) {
		Criteria criteria = new Criteria(OrderPO.class);
		criteria.and(Restriction.eq("shopType", shopType));
		if (shopType == ShopType.AMAZON.getVal()) {
			criteria.and(Restriction.eq("shopOrderCode", Unique));
		} else if (shopType == ShopType.EBAY.getVal()) {
			criteria.and(Restriction.eq("shopOrderId", Unique));
		}
		criteria.order("id", OrderType.desc);
		return BeanUtils.copyProperties(orderDao.get(criteria), Order.class);
	}

	@Override
	public void orderOut(OrderDetail detail) throws BussinessException {
		// 通讯dms
		// ShopInfo info = systemService.getShopInfo(detail.getShopId());
		// if (info != null) {
		OrderPO po = orderDao.getObject(detail.getId());
		// if (DMSClient.addOrder(detail, info)) {
		po.setStatus(OrderStatus.已出库.getVal());
		// } else {
		// po.setStatus(OrderStatus.出库失败.getVal());
		// }
		// }
	}

	@Override
	public void orderOut(int orderId, String operator) throws BussinessException {
		/**
		 * 该功能已改为 cms打包后自己将订单信息传到dms，无需客服系统处理
		 */
		// OrderPO po = orderDao.getObject(orderId);
		// if (po.getStatus() != OrderStatus.出库失败.getVal()) {
		// throw new BussinessException("订单状态不对，无法出库！");
		// }

		// 判断货运信息
		// if (decideOrderAddress(orderId))
		// throw new BussinessException("请先完善货运信息再请求出库！");
		//
		// orderOut(this.getOrderDeatil(orderId));
		// this.addOrderOperateLog("请求出库", operator, orderId);
	}

	protected boolean decideOrderAddress(int orderId) {
		OrderAddressPO orderAddress = getOrderAddress(orderId);
		if (StringUtils.isEmpty(orderAddress.getAddressLine1()) || StringUtils.isEmpty(orderAddress.getName())
				|| StringUtils.isEmpty(orderAddress.getCity()) || StringUtils.isEmpty(orderAddress.getCountryCode())
				|| StringUtils.isEmpty(orderAddress.getPostalCode()) || StringUtils.isEmpty(orderAddress.getPhone())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delivering2WS3rdProxy(int orderId) {
		OrderPO po = orderDao.getObject(orderId);
//		if (po.getShopType() == ShopType.AMAZON.getVal()) {
//			// 添加自动发货任务
//			addAutoOrderDeliveryTask4Amazon(orderId, po.getShopId(),po.getShopType());
//		}else{
		if(BooleanUtils.isTrue(po.getIsOtherSystem())||BooleanUtils.isTrue(po.getManual())||BooleanUtils.isTrue(po.getCopy()))
			return false;
		addAutoOrderDelivery(orderId,po.getShopId(),po.getShopType());
//		}
		return true;
	}

	@Override
	public boolean delivering2WS3rdProxy(List<Integer> orderIds) {
		if (CollectionUtils.isEmpty(orderIds)) {
			return false;
		}

		Map<Integer, List<OrderPO>> maps = new HashMap<Integer, List<OrderPO>>();
		for (Integer orderId : orderIds) {
			OrderPO po = orderDao.getObject(orderId);
			if(BooleanUtils.isTrue(po.getIsOtherSystem())||BooleanUtils.isTrue(po.getManual())||BooleanUtils.isTrue(po.getCopy()))
				continue;
			if (po.getShopType() == ShopType.AMAZON.getVal()){
				if (maps.containsKey(po.getShopType())) {
					maps.get(po.getShopType()).add(po);
				} else {
					List<OrderPO> lists = new ArrayList<OrderPO>();
					lists.add(po);
					maps.put(po.getShopType(), lists);
				}
			}else{
				addAutoOrderDelivery(po.getId(), po.getShopId(), po.getShopType());
			}
		}

		for (Entry<Integer, List<OrderPO>> type : maps.entrySet()) {
			addAutoOrderDeliveryTaskBatch(type.getValue());
		}

		return true;
	}

	@Deprecated
	protected void addAutoOrderDeliveryTask4Amazon(int orderId, int shopId,int shopType) {
		Criteria criteria = new Criteria(OrderDeliveryTaskPO.class);
		criteria.and(Restriction.eq("status", 0));
		criteria.and(Restriction.eq("shopId", shopId));
		criteria.order("id", OrderType.desc);
		OrderDeliveryTaskPO po = orderDeliveryTaskDao.get(criteria);
		if (po != null) {
			String[] orderIds = po.getOrderId().split(",");
			if (orderIds.length < Integer.valueOf(AMAZON_DELIVERY_SIZE)) {
				po.setOrderId(po.getOrderId() + "," + orderId);
				orderDeliveryTaskDao.mergeObject(po);
				return;
			}
		}

		addAutoOrderDelivery(orderId, shopId,shopType);
	}

	private void addAutoOrderDelivery(int orderId, int shopId,int shopType) {
		OrderDeliveryTaskPO po;
		po = new OrderDeliveryTaskPO();
		po.setStatus(0);
		po.setOrderId(orderId + "");
		po.setCreateTime(new Date());
		po.setShopId(shopId);
		po.setShopType(shopType);
		orderDeliveryTaskDao.addObject(po);
	}

	protected OrderPO getOrderPOByCode(String orderCode) {
		String hql = "from OrderPO where code=?";
		return orderDao.findByHql(hql, orderCode);
	}
	
	protected OrderPO getOrderPOByCode4Update(String orderCode) {
		String hql = "select p from OrderPO p where p.code=?";
		return orderDao.findByHql(hql, "p",orderCode,LockMode.UPGRADE);
	}


	@Override
	public Order getOrderByCode(String code) {
		OrderPO po = getOrderPOByCode(code);
		if (po != null) {
			return BeanUtils.copyProperties(po, Order.class);
		}
		return null;
	}

	public OrderPrepareProduct getOrderPrepareProduct(int id) {
		OrderPrepareProductPO po = orderPrepareProductDao.getObject(id);
		if (po != null) {
			return BeanUtils.copyProperties(po, OrderPrepareProduct.class);
		}
		return null;
	}

	@Override
	public OrderProduct getOrderProductByOrderId(String cmsProductCode, int orderId) {
		Criteria criteria = new Criteria(OrderPrepareProductPO.class);
		criteria.and(Restriction.eq("orderId", orderId));
		criteria.and(Restriction.eq("cmsProductCode", cmsProductCode));
		OrderPrepareProductPO ppo = orderPrepareProductDao.get(criteria);
		if (ppo != null) {
			OrderProductPO po = orderProductDao.getObject(ppo.getOrderProductId());

			OrderProduct op = BeanUtils.copyProperties(po, OrderProduct.class);
			op.setOrderPrepareProduct(BeanUtils.copyProperties(ppo, OrderPrepareProduct.class));
			return op;
		}
		return null;
	}

	@Override
	public boolean orderCheck(int orderId, String operator) {
		OrderPO po = orderDao.getObject(orderId);
		if (po.getIsSend() && po.getStatus() == OrderStatus.已配货.getVal()) {
			com.itecheasy.webservice.cms.order.Order cmsOrder= CMSOrderClient.getOrderByCode(po.getCode());
			if(cmsOrder!=null&&!cmsOrder.isIsQualityInspection()){
				po.setStatus(OrderStatus.待校对.getVal());
				addOrderOperateLog("请求校对", operator, po.getId());
				// 通讯cms
				CommandOrderUtils.requestCheckOrder(po.getCode(),po.getCmsPrepare());
				
			}else{
				/**
				 * 2016-09-13
				 * 请求校对时判断订单在c3是否存在未完成的质检单，若有，则请求校对失败，弹出提示：订单正在质检，请质检完后再请求校对
				 */
				return false;
			}
		}
		return true;
	}

	@Override
	public void cancelOrder(int orderId, String operator) {
		OrderPO po = orderDao.getObject(orderId);
		po.setOldStatus(po.getStatus());   //判断是否合法
		if (po != null) {
			if (po.getStatus() == OrderStatus.取消.getVal()) {
				return;
			}
			po.setShopOrderStatus(ORDER_SHOP_CANCELED);
			if (po.getStatus() > OrderStatus.已出库.getVal()) {
				// //发货中、已发货的订单，列表邮件—订单重发、取消订单置灰不可用
				sendEmail2Administator("无法取消订单", "订单" + po.getCode() + "当前状态:" + OrderStatus.getName(po.getStatus()));
				return;
			}



			po.setAmCanceledTag(true);
			boolean flag = false;
			int _old_status = po.getStatus();
			// 非同票
			if (po.getSendGroupId() == null) {
				// 1、pendding 直接取消
				if (_old_status == OrderStatus.PENDING.getVal()) {
					flag = true;
				} else if (_old_status > OrderStatus.PENDING.getVal() && _old_status < OrderStatus.打包中.getVal()) {
					// 2、Pending、准备货物、已备货、待校对、校对中、已校对的订单，客户取消后，osms直接取消，并通知c3取消订单
					if (isCommuication2Other(po)) {
						// 2--包含非cms备货怎么发送邮件
						cancelNotCMSPrepareProduct2email(po);
						flag = true;
					} else {
						// 2--准备货物状态的非c3备货订单，记录订单日志，
						// 发邮件通知跟单员，邮件标题：客户取消订单YYY，正文：客户取消非c3备货的订单YYY，请通知相关业务人员停止备货
						cancelNotCMSPrepareOrder2email(po);
						flag = true;
					}

				} else if (_old_status == OrderStatus.打包中.getVal() || _old_status == OrderStatus.已打包.getVal()
						|| _old_status == OrderStatus.已出库.getVal()) {

					if (po.getCmsPrepare()==ORDER_PREPARE_TYPE_CMS) {
						// 3、打包中、已打包、已出库、已发货订单，客户取消后，osms打取消待确认标记，向cms和dms发起取消申请，等待后端反馈
						if(po.isAwaitConfirmCancel()){//2018-05-05 正在取消 ，防止重复操作
							addOrderOperateLog(OrderStatus.getName(po.getStatus()) + "订单" + po.getCode() + "，正在取消，不要重复取消",
									operator, orderId);
						}else{
							po.setAwaitConfirmCancel(true);
							orderCancelResendService.applyOrderOperating(po.getCode(), OrderApplyType.CANCEL.getVal());
							addOrderOperateLog(OrderStatus.getName(po.getStatus()) + "订单" + po.getCode() + "，申请取消",
									operator, orderId);
							Command2CMS.orderApplayCancle(po.getCode(), "OSMS系统", "");
						}
					} else if(po.getCmsPrepare()==ORDER_PREPARE_TYPE_SW){
						flag=true;
					}else {
						cancelNotCMSPrepareOrder2email(po);
					}
				} else if (_old_status > OrderStatus.已出库.getVal()) {
					return;
				}
			} else {
				// 同票订单
				if (_old_status < OrderStatus.打包中.getVal()) {
					flag = true;
					// 解除同票
					this.cancelTicketGroup(po.getId(), "OSMS取消订单");
					cancelNotCMSPrepareProduct2email(po);
				} else if (_old_status == OrderStatus.打包中.getVal() || _old_status == OrderStatus.已打包.getVal()
						|| _old_status == OrderStatus.已出库.getVal()
				// ||_old_status==OrderStatus.已发货.getVal()
				) {
					if (po.getIsbackTag()) {
						// 订单正在打回，则等待打回结束，取消订单
						po.setAwaitConfirmResend(true);
						this.addOrderOperateLog("订单正在打回，等待打回结束，取消订单", "OSMS取消订单", po.getId());
					} else {
						List<OrderPO> group = new ArrayList<OrderPO>();
						group = this.getOrderByTicketGroup(po.getSendGroupId());

						String content = OrderStatus.getName(po.getStatus()) + "订单，申请订单取消订单";
						StringBuilder orderCodes = new StringBuilder();
						for (OrderPO orderPO : group) {
							orderCancelResendService.applyOrderOperating(po.getCode(), OrderApplyType.RESEND.getVal());
							orderPO.setAwaitConfirmResend(true);
							orderPO.setOldStatus(orderPO.getStatus());
							orderCodes.append(",").append(orderPO.getCode());
							this.addOrderOperateLog(content, "OSMS取消订单", orderPO.getId());
						}
						Command2CMS.orderApplayResend(orderCodes.toString().substring(1), "OSMS系统", "");
					}
				}
			}

			if (_old_status != OrderStatus.取消.getVal() && flag) {   //没有取消时
				po.setStatus(OrderStatus.取消.getVal());
				po.setShopOrderStatus(ORDER_SHOP_CANCELED);
				orderDao.mergeObject(po);
				addOrderOperateLog("取消订单：" + po.getCode(), operator, orderId);



				
				//订单取消，订单跟踪商品项未删除, 把商品的
				// 取消订单,订单跟踪状态更新为 “已完成”，商品项状态为“已删除”并需要通知C3
				String sql = "SELECT * FROM order_tracking o " +
						"WHERE o.order_code=? ";
				List<Object> params = new ArrayList<Object>();
				//增加参数
				params.add(po.getCode());    //orderCode
				List<OrderTrackingPO> orderTrackingPOList = orderTrackingDao.findListBySql(sql, params);
				for (OrderTrackingPO orderTrackingPO : orderTrackingPOList) { //cancel之后把改订单下所有的订单跟踪改为已完成
					orderTrackingPO.setStatus(20);          //30 已完成
				}
				orderTrackingDao.updateObject(orderTrackingPOList);


				//通过order_id把补货订单下order_productList给查询出来
				String sql3 = "SELECT * FROM order_product o "
						+ "WHERE o.order_id=? ";
				List<Object> params3 = new ArrayList<Object>();
				params3.add(po.getId());
				List<OrderProductPO> itemList = orderProductDao.findListBySql(sql3,params3);

				//如果订单中只有一个商品，就直接把订单给改为已完成
//				if(itemList!=null && itemList.size()==1){
//					for (OrderTrackingPO orderTrackingPO : orderTrackingPOList) { //cancel之后把改订单下所有的订单跟踪改为已完成
//						orderTrackingPO.setStatus(30);          //30 已完成
//					}
//				}
//				orderTrackingDao.updateObject(orderTrackingPOList);


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
				if (_old_status > OrderStatus.PENDING.getVal() && po.getCmsPrepare()!=ORDER_PREPARE_TYPE_OTHER) {
					CommandOrderUtils.cancleOrder(po.getCode(),null,po.getCmsPrepare());
				}
			}
		}
	}
	

	/**
	 * 取消非cms备货订单
	 * 
	 * @param po
	 */
	private void cancelNotCMSPrepareOrder2email(OrderPO po) {
		StringBuilder content = new StringBuilder();
		content.append("客户取消非c3备货的订单").append(po.getCode()).append(",请联系相关业务人员停止备货");
		sendEmail2Administator("客户取消订单" + po.getCode() + "", content.toString());
	}

	@Override
	public void cancelOrderNotCommunication(int orderId, String operator) {
		OrderPO po = orderDao.getObject(orderId);
		if (po != null) {
			int _old_status = po.getStatus();
			if (_old_status != OrderStatus.取消.getVal()) {
				po.setStatus(OrderStatus.取消.getVal());
				po.setShopOrderStatus(ORDER_SHOP_CANCELED);
				orderDao.mergeObject(po);
				addOrderOperateLog("取消订单：" + po.getCode(), operator, orderId);
			}
		}
	}

	@Override
	public void cancelOrderCommunication(int orderId, String operator) {
		OrderPO po = orderDao.getObject(orderId);
		if (po != null) {
			int _old_status = po.getStatus();
			if (_old_status != OrderStatus.取消.getVal()) {
				po.setStatus(OrderStatus.取消.getVal());
				po.setShopOrderStatus(ORDER_SHOP_CANCELED);
				orderDao.mergeObject(po);
				addOrderOperateLog("取消订单：" + po.getCode(), operator, orderId);

				CommandOrderUtils.cancleOrder(po.getCode(),null,po.getCmsPrepare());
			}
		}
	}

	@Override
	public void updateOrder(int orderId, String remark, boolean sendTag, int isQualityInspection, String operator)
			throws BussinessException {
		OrderPO po = orderDao.getObject(orderId);
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
				if (isCommuication2Other(po)) {
					CommandOrderUtils.setQualityInspection(po.getCode(), isQualityInspection == 1 ? true : false,po.getCmsPrepare());
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
				sb.append("可发货标识更新为“").append(sendTag ? "是" : "否").append("”");
				// 通讯cms，更新订单是否可发货
				if (isCommuication2Other(po)) {
					CommandOrderUtils.updateOrderIsCanSend(po.getCode(), sendTag, operator,po.getCmsPrepare());
				}
				if (sendTag) {
					// 如果订单状态是已备货，则请求校对
					if (po.getStatus() == OrderStatus.已配货.getVal()) {
						orderCheck(po.getId(), operator);
					}
				} else {
					// 可发货为否时，C3订单拦截在已备货状态
					// po.setStatus(OrderStatus.已备货.getVal());
				}
			}

			if (isCommuication2Other(po)) {
				String hql = "from OrderAddressPO where orderId=?";
				OrderAddressPO oa = orderAddressDao.findByHql(hql, orderId);
				CommandOrderUtils.updateOrder(BeanUtils.copyProperties(po,Order.class), operator, oa.getRemark(),po.getCmsPrepare());
			}

			addOrderOperateLog(sb.toString(), operator, orderId);
		}
	}

	@Override
	public void addTicketGroup(int[] orderIds, String operator) throws BussinessException {
		if (orderIds == null || orderIds.length < 1) {
			return;
		}
		StringBuilder sql = new StringBuilder("SELECT DISTINCT name  ,"
				+ "ISNULL(address_line1,'')+ ISNULL(address_line2,'') as address_line1," + "  county , "
				+ "country_code , " + "state_or_Region ,  city , district ,  postal_code , phone "
				+ "  FROM dbo.order_address WHERE order_id IN (");
		String param = CollectionUtils.array2List(orderIds).toString();
		sql.append(param.substring(1, param.length() - 1)).append(")");
		List<OrderAddress> adds = orderAddressDao.findListBySql(sql.toString(), null, OrderAddress.class);

		StringBuilder sql2 = new StringBuilder("SELECT * FROM dbo.[order] WHERE status <60 AND "
				+ "cms_prepare=1 AND id in (");
		sql2.append(param.substring(1, param.length() - 1)).append(")");
		List<OrderPO> pos = orderDao.findListBySql(sql2.toString(), null);

		// 判断地址
		// StringBuilder sql3 = new
		// StringBuilder("SELECT DISTINCT address_line1,address_line2   "
		// + "  FROM dbo.order_address WHERE order_id IN (");
		// sql3.append(param.substring(1, param.length() - 1)).append(")");
		// List<OrderAddress> adds3 =
		// orderAddressDao.findListBySql(sql3.toString(), null,
		// OrderAddress.class);
		boolean different = false;
		// if (CollectionUtils.isNotEmpty(adds3)) {
		// OrderAddress adTag=adds3.get(0);
		// for (int i = 1; i < adds3.size(); i++) {
		// OrderAddress ad=adds3.get(i);
		// if(ad.getAddressLine1()==adTag.getAddressLine2()
		// ||ad.getAddressLine2()==adTag.getAddressLine1()){
		//
		// }else{
		// different=true;
		// break;
		// }
		// }
		// }

		if (pos.size() != orderIds.length || adds.size() > 1 || different) {
			throw new BussinessException(ERROR_ADD_SEND_GROUP);
		}

		// 货运方式
		int shippingMethod = pos.get(0).getShippingMethod();
		// 进行同票处理
		int ticketGroupId = -1;
		List<OrderPO> tmp = new ArrayList<OrderPO>();
		for (OrderPO orderPO : pos) {
			if (orderPO.getStatus() > OrderStatus.待校对.getVal()) {
				throw new BussinessException(MessageFormat.format("订单{0}状态不对无法操作同票", orderPO.getCode()));
			}
			if (orderPO.getShippingMethod() != shippingMethod) {
				throw new BussinessException(ERROR_ADD_SEND_GROUP);
			}
			if (orderPO.getSendGroupId() != null) {
				ticketGroupId = orderPO.getSendGroupId();
				tmp.addAll(getOrderByTicketGroup(ticketGroupId));
			}
		}
		// 如果都没有被同票过，则获得新的同票ID
		if (ticketGroupId < 0) {
			ticketGroupId = getMaxTicketGroupID() + 1;
			tmp = pos;
		} else {
			for (OrderPO orderPO : pos) {
				if (!tmp.contains(orderPO)) {
					tmp.add(orderPO);
				}
			}
		}
		StringBuilder orderCodes = new StringBuilder();
		List<Integer> ids = new ArrayList<Integer>();
		for (OrderPO orderPO : tmp) {
			orderPO.setSendGroupId(ticketGroupId);
			ids.add(orderPO.getId());
			orderCodes.append(",").append(orderPO.getCode());
		}

		// 记录操作日志
		for (Integer integer : ids) {
			addOrderOperateLog("增加同票：" + orderCodes.toString(), operator, integer);
		}
		// 发送邮件
		sendEmail2Administator("增加同票", "增加同票：" + orderCodes.toString());
		// 通讯cms
		Command2CMS.updateOrderGroup(ticketGroupId, orderCodes.toString().substring(1), operator);
	}

	/**
	 * 根据同票id获取订单
	 * 
	 * @param ticketGroupId
	 * @return
	 */
	private List<OrderPO> getOrderByTicketGroup(int ticketGroupId) {
		String hql = "from OrderPO where sendGroupId=?";
		return orderDao.findListByHql(hql, ticketGroupId);
	}

	@Override
	public void cancelTicketGroup(int orderId, String operator) {
		String hql = "SELECT a.* FROM dbo.[order] a JOIN dbo.[order] b "
				+ " ON a.send_group_id=b.send_group_id WHERE b.id=?";
		List<Object> param = new ArrayList<Object>();
		param.add(orderId);
		List<OrderPO> pos = orderDao.findListBySql(hql, param);
		StringBuilder orderCodes = new StringBuilder();
		if (CollectionUtils.isNotEmpty(pos)) {
			List<Integer> ids = new ArrayList<Integer>();
			if (pos.size() <= 2) {
				for (OrderPO orderPO : pos) {
					orderPO.setSendGroupId(null);
					orderCodes.append(",").append(orderPO.getCode());
					ids.add(orderPO.getId());
				}
			} else {
				OrderPO orderPO = orderDao.getObject(orderId);
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
	
	public static void main(String[] args) {
		Pattern pattern=Pattern.compile("[A-Z]{2,}[0-9]*$");   
		Matcher matcher=pattern.matcher("WA171205220956");  
		System.out.println(matcher.find());
	}

	@Override
	public int copyOrder(int orderId, String operator) throws BussinessException {
		OrderPO old = orderDao.getObject(orderId);
		if (old != null) {
			if (BooleanUtils.isTrue(old.getCopy())) {
				throw new BussinessException("复制的订单不能再复制！");
			}
			if (old.getStatus() == OrderStatus.PENDING.getVal()) {
				throw new BussinessException("订单状态为“准备货物” 及以上才可以重新备货!");
			}
			OrderPO po = new OrderPO();
			BeanUtils.copyProperties(old, po, new String[] { "id" });
			// 复制的订单状态为准备货物，
			po.setStatus(OrderStatus.准备货物.getVal());
			
			String tag=po.getCode();
//			Pattern pattern=Pattern.compile("^[A-Z]{2,}[0-9]{12,}");   
//			Matcher matcher=pattern.matcher(po.getCode());  
//			if(matcher.find()){
//				tag=tag.substring(0,14);
//			}else{
//				tag=tag.substring(0,13);
//			}
			//2017-12-05 新规则
			// 判断该订单的复制历史
//			int tag = getCopyTagNum(old);
			po.setCode(tag + getCopyTagNumNewRule(old,tag));
			po.setOrderItemPrepareNum(0);



			// 初始化订单原始状态
			po.setAwaitConfirmCancel(false);
			po.setAwaitConfirmResend(false);
			po.setAmCanceledTag(false);
			po.setIsbackTag(false);
			po.setCopy(true);

			po.setAddOrderDate(new Date());
//			po.setDeliveryDate(null);
			po.setDeliveryCustomerService(null);
			po.setPackageStatus(null);
			po.setIsSmallLotOrderOffShelveing(null);
			po.setSendGroupId(null);
			po.setOldStatus(null);
//			po.setTrackingCode(null);
			po.setWebWeight(null);
			po.setOutDate(null);
			po.setCostFreight(null);

			Integer orderId_new = orderDao.addObject(po);

			OrderAddressPO oapo_old = getOrderAddress(orderId);
			if (oapo_old != null) {
				OrderAddressPO oapo = new OrderAddressPO();
				BeanUtils.copyProperties(oapo_old, oapo, new String[] { "id", "orderId" });
				oapo.setOrderId(orderId_new);

				orderAddressDao.addObject(oapo);
			}
			List<OrderProductPO> opos_old = getOrderProduct(orderId);
			if (CollectionUtils.isNotEmpty(opos_old)) {
				for (OrderProductPO orderProductPO : opos_old) {
					OrderProductPO opo_new = new OrderProductPO();
					opo_new.setOrderId(orderId_new);
					BeanUtils.copyProperties(orderProductPO, opo_new, new String[] { "id", "orderId" });
					Integer opoId_new = orderProductDao.addObject(opo_new);

					OrderPrepareProductPO oppo_old = getOrderPrepareProductByOrderProduct(orderProductPO.getId());
					OrderPrepareProductPO oppo_new = new OrderPrepareProductPO();
					BeanUtils.copyProperties(oppo_old, oppo_new, new String[] { "id", "orderId", "orderProductId" });
					oppo_new.setOrderId(orderId_new);
					oppo_new.setPrepareQty(0);
					oppo_new.setOrderProductId(opoId_new);
					if (!orderProductPO.getCancel()) {
						oppo_new.setStatus(OrderProductStatus.备货中.getVal());
					}
					orderPrepareProductDao.addObject(oppo_new);
					// if(orderProductPO.getCancel()){
					// po.setCostPrice((po.getCostPrice()==null?0:po.getCostPrice())+oppo_old.getCostPrice());
					// po.setOrderAmount(po.getOrderAmount()+orderProductPO.getShopItemPrice());
					// }

				}
			}

			//复制fba单
			boolean isFBA = ConstantUtils.FULFILLMENTCHANNELS_AFN.equals(old.getFulfillmentChannel());
			if (isFBA) {
				addOrderOperateLog("复制FBA订单" + old.getCode(), operator, orderId_new);
			}else
				addOrderOperateLog("复制订单" + old.getCode(), operator, orderId_new);
			
			if(isFBA){
//				int count = this.getOrderPrepareProduct4LIMIT(po.getId());
				int count = po.getProblemVal() == OrderProblemType.货运信息有问题.getVal() ? 0 : po.getProblemVal();
				if (count < 1) {
					po.setShippingMethod(0);
					po.setCmsPrepare(ORDER_PREPARE_TYPE_CMS);
					po.setStatus(OrderStatus.准备货物.getVal());
					changePending2updateOrder(po);
					if (isNeedUpdateOrder2NotCMSPrepare(po.getId())) {
						po.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
					} else {
						pendding2swPrepare(po);
						CommandOrderUtils.addOrder(this.getOrderDeatil(po.getId()), systemService.getShopInfo(po.getShopId()),false);
					}
				}else{
					po.setStatus(OrderStatus.PENDING.getVal());
				}
			}else
			// 通讯cms，增加订单
			if (isCommuication2Other(po)) {
				CommandOrderUtils.addOrder(this.getOrderDeatil(orderId_new), systemService.getShopInfo(old.getShopId()),false);
			}
			return orderId_new;
		}
		return 0;
	}

	@SuppressWarnings("unused")
	@Deprecated
	private int getCopyTagNum(OrderPO old) {
		int tag = 1;
		Criteria criteria = new Criteria(OrderPO.class);
		criteria.and(Restriction.like("code", old.getCode() + "(%)"));
		criteria.order("id", OrderType.desc);
		// String
		// sql="SELECT * FROM dbo.[order] WHERE code LIKE ? ORDER BY id DESC ";
		// List<OrderPO> his=orderDao.findListByHql(sql, old.getCode()+"(*)");
		List<OrderPO> his = orderDao.list(criteria);
		if (CollectionUtils.isNotEmpty(his)) {
			String his_code = his.get(0).getCode();
			int index = his_code.indexOf("(");
			int index2 = his_code.indexOf(")");

			System.out.println(index);
			System.out.println(index2);
			tag = Integer.valueOf(his_code.substring(index + 1, index2)) + 1;
		}
		return tag;
	}
	
	private String getCopyTagNumNewRule(OrderPO old,String code){
		String tag = "A";
		Criteria criteria = new Criteria(OrderPO.class);
		criteria.and(Restriction.like("code", code + "[A-Z]%"));
//		criteria.and(Restriction.notLike("code", code + "(%)"));//排除旧规则
		criteria.and(Restriction.eq("copy", true));
		criteria.order("id", OrderType.desc);
		
		List<OrderPO> his = orderDao.list(criteria);
		if (CollectionUtils.isNotEmpty(his)) {
			String his_code = his.get(0).getCode();
			tag=his_code.substring(code.length());
			
			tag=com.itecheasy.common.util.StringUtils.getNum2Word(com.itecheasy.common.util.StringUtils.getWord2Num(tag)+1);
		}
		return tag;
	}

	@Override
	public void cancelOrderProducts(int orderId, int[] orderProductIds, String operator) throws BussinessException {
		OrderPO po = orderDao.getObject(orderId);	//根据订单id获取订单信息
		if (po.getStatus() > OrderStatus.已配货.getVal()) {			//判断订单状态
			throw new BussinessException("状态不对，无法取消商品！");
		}

		// 验证小批量订单下架			判断订单是否合法
		if (isCommuication2Other(po)) {
			// 通过getOrderById接口返回的Order.isSmallLotOrderOffshelfed
			// 。true就抛异常：订单已生成下架单不可以修改。false就可以修改备货
			com.itecheasy.webservice.cms.order.Order cmsOrder = CMSOrderClient.getOrderByCode(po.getCode());
			if (cmsOrder != null) {
//				if (cmsOrder.isIsSmallLotOrderOffShelveing() != null && cmsOrder.isIsSmallLotOrderOffShelveing()) {
//					throw new BussinessException("订单已生成下架单不可以修改!");
//				}
			}
		}

		StringBuilder cancleOrderItemIds = new StringBuilder();
		StringBuilder cancelReason = new StringBuilder();

		//cancelProduct
		cancelOrderProducts(orderProductIds, operator, po, cancleOrderItemIds, cancelReason);

		//查出该订单下的所有没有被取消状态的product，如果查出来的结果为空的话就直接抛出异常
		List<OrderProductPO> pos = getOrderProductNotCancel(orderId);
		if (CollectionUtils.isEmpty(pos)) {
			throw new BussinessException("无法取消所有商品！");
		}

		updateOrderStatusByOrderProduct(po);   //更新order的status

		// 通讯到cms
		cancelOrderProducts$changeOrder(po, cancleOrderItemIds, cancelReason);
	}

	protected void cancelOrderProducts$changeOrder(OrderPO po, StringBuilder cancleOrderItemIds,
			StringBuilder cancelReason) {
		// 判断订单限制状态
		int count = this.getOrderPrepareProduct4LIMIT(po.getId());
		if (OrderStatus.PENDING.getVal() == po.getStatus()) {
			if (count < 1) {
				po.setStatus(OrderStatus.准备货物.getVal());
				changePending2updateOrder(po);
				if (isNeedUpdateOrder2NotCMSPrepare(po.getId())) {
					po.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
				} else {
					pendding2swPrepare(po);
					// 通讯到cms
					CommandOrderUtils.addOrder(this.getOrderDeatil(po.getId()), systemService.getShopInfo(po.getShopId()),false);
				}
			}
		} else {
			// 通讯cms
			if (isCommuication2Other(po)) {
				if (isNeedUpdateOrder2NotCMSPrepare(po.getId())) {
					// 取消订单
					CommandOrderUtils.cancleOrder(po.getCode(),null,po.getCmsPrepare());   //通知cms取消订单
					po.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
					po.setStatus(OrderStatus.准备货物.getVal());
				} else {
					CommandOrderUtils.cancleOrderItem(po.getCode(), po.getStatus(), cancleOrderItemIds.toString()
							.substring(1), cancelReason.toString().substring(1),po.getCmsPrepare());
					CommandOrderUtils.updateOrderProductAmount(po.getCode(), po.getOrderCurrency(), po.getOrderAmount(),
							po.getShopShippingPrice(),po.getCmsPrepare());
					CommandOrderUtils.updateOrder(BeanUtils.copyProperties(po,Order.class), "", 
							this.getOrderAddress(po.getId()).getRemark(),po.getCmsPrepare());
				}
			}
		}
		po.setElectronic(isElectronic(po.getId()));
		orderDao.mergeObject(po);
	}

	protected void cancelOrderProducts(int[] orderProductIds, String operator, OrderPO po,
			StringBuilder cancleOrderItemIds, StringBuilder cancelReason) throws BussinessException {
		for (int i = 0; i < orderProductIds.length; i++) {
			OrderProductPO oppo = orderProductDao.getObject(orderProductIds[i]);
			OrderPrepareProductPO ppo = getOrderPrepareProductByOrderProduct(oppo.getId());		//根据订单商品id获取订单商品对应的最后一个备货商品
			//oppo OrderProductPO 传过来的要被取消掉的商品对象
			// 	ppo OrderPrepareProductPO

			cancelOrderProduct(ppo, po, oppo, operator, cancleOrderItemIds);

			//操作日志记录
			addOrderOperateLog("取消商品：" + ppo.getCmsProductCode(), operator, po.getId());

			cancelReason.append(",").append(0);
		}
	}

	//第二个和第三个参数
	protected void cancelOrderProduct(OrderPrepareProductPO ppo, OrderPO orderPo, OrderProductPO po, String operator,
			StringBuilder cancleOrderItemIds) throws BussinessException {

		if (po.getCancel()) {
			throw new BussinessException("商品" + ppo.getCmsProductCode() + "已经取消，无法重复取消！");
		}

		// 更新订单项总数，已备量
		orderPo.setOrderItemNum(orderPo.getOrderItemNum() - 1);
		if (ppo.getStatus() == OrderProductStatus.已备货.getVal()) {
			orderPo.setOrderItemPrepareNum(orderPo.getOrderItemPrepareNum() == 0 ? 0
					: orderPo.getOrderItemPrepareNum() - 1);
		}
		this.decideOrderStatus4UpdateOrderItemNum(orderPo);
		ppo.setStatus(OrderProductStatus.取消.getVal());

		po.setCancel(true);   //把OrderProductPO中的设置为了取消

//		String hql_test="select a from RepositoryPO a,RepositoryShopPO b where a.id=b.repositoryId" +
//				" and b.shopId=?";

//		String hql = "FROM OrderTrackingPO o " +
//					 "INNER JOIN " +
//					 "(SELECT * FROM OrderTrackingProductPO) op " +
//					 "ON op.orderTrackingId = o.id " +
//					 "WHERE o.orderCode=? and op.cmsProductCode=?";

		//op.cms_product_code



		//把ordertracking中的状态给变更为取消
		String sql = "SELECT * FROM order_tracking_product op " +
						"INNER JOIN " +
						"(SELECT  * FROM order_tracking ) o " +
						"ON op.order_tracking_id = o.id " +
						"WHERE o.order_code=? and op.cms_product_code=? ";

		List<Object> params=new ArrayList<Object>();
		//增加参数
		params.add(orderPo.getCode());
		params.add(po.getCmsProductCode());
		List<OrderTrackingProductPO> orderTrackingPOList = this.orderTrackingProductDao.findListBySql(sql,params);

		//update
		if(orderTrackingPOList != null && orderTrackingPOList.size()!=0) {
			for (OrderTrackingProductPO orderTrackingProductPO : orderTrackingPOList) {
				orderTrackingProductPO.setDeleted(true);
			}
            orderTrackingProductDao.updateObject(orderTrackingPOList);
		}



		String sql3 = "select * from order_tracking " +
						"where order_code=? ";
		List<Object> params3 = new ArrayList<Object>();
		params3.add(orderPo.getCode());
		List<OrderTrackingPO> orderTrackingPOList3 = orderTrackingDao.findListBySql(sql3,params3);



		//如果每个订单跟踪中只有一个商品，就直接把订单给改为:已完成
		String sql4 = "select * from order_tracking_product " +
				"where order_tracking_id=? ";
		if(orderTrackingPOList3!=null && orderTrackingPOList3.size()!=0){
			for (OrderTrackingPO orderTrackingPO3 : orderTrackingPOList3) { //cancel之后把改订单下所有的订单跟踪改为已完成
				//再根据这个订单跟踪查它下面出所有的订单跟踪商品
				List<Object> params4 = new ArrayList<Object>();
				params4.add(orderTrackingPO3.getId());
				List<OrderTrackingProductPO> orderTrackingProductPOList = orderTrackingProductDao.findListBySql(sql4,params4);
				Integer isDelete = 0;
				if(orderTrackingProductPOList!=null && orderTrackingProductPOList.size()!=0)
                    for (OrderTrackingProductPO orderTrackingProductPO : orderTrackingProductPOList) {
                        if (orderTrackingProductPO.isDeleted()){
                            isDelete++;
                        }
                    }
				if(isDelete==orderTrackingProductPOList.size()) {
					orderTrackingPO3.setStatus(20);          //30 已完成
					orderTrackingDao.updateObject(orderTrackingPO3);
				}
			}
		}




		// 更新订单金额
		orderPo.setOrderAmount(orderPo.getOrderAmount() - (po.getShopItemPrice()-po.getShopDiscount())-po.getShopItemShippingPrice());
		// 更新订单成本价
		orderPo.setCostPrice(orderPo.getCostPrice() == null ? 0 : orderPo.getCostPrice() - ppo.getCostPrice());
		orderPo.setShopShippingPrice(orderPo.getShopShippingPrice()-po.getShopItemShippingPrice());
		orderProductDao.mergeObject(po);
		orderPrepareProductDao.mergeObject(ppo);

		cancleOrderItemIds.append(",").append(ppo.getId());

	}

	private void updateOrderProduct$cancel(OrderPrepareProductPO ppo, OrderPO orderPo, OrderProductPO po,
			String operator, StringBuilder cancleOrderItemIds) throws BussinessException {

		if (po.getCancel()) {
			throw new BussinessException("商品" + ppo.getCmsProductCode() + "已经取消，无法重复取消！");
		}

		int _old_status = ppo.getStatus();
		if (ppo.getStatus() > OrderProductStatus.已备货.getVal()) {
			throw new BussinessException("无法以修改备货商品");
		}

		ppo.setStatus(OrderProductStatus.取消.getVal());

		// 更新订单成本价
		orderPo.setCostPrice(orderPo.getCostPrice() == null ? 0 : orderPo.getCostPrice() - ppo.getCostPrice());

		// 更新订单项总数，已备量
		orderPo.setOrderItemNum(orderPo.getOrderItemNum() - 1);
		if (_old_status == OrderProductStatus.已备货.getVal()) {
			orderPo.setOrderItemPrepareNum(orderPo.getOrderItemPrepareNum() == 0 ? 0
					: orderPo.getOrderItemPrepareNum() - 1);
		}
		orderProductDao.mergeObject(po);
		orderPrepareProductDao.mergeObject(ppo);

		cancleOrderItemIds.append(",").append(ppo.getId());

	}


	/**
	 * 检查重复添加商品项
	 * 
	 * @param orderId
	 * @param orderProducts
	 * @throws BussinessException
	 */
	private void checkRepeat4UpdateOrderProduct(int orderId, List<UpdateOrderProductForm> orderProducts)
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

		String sql = " SELECT * FROM order_prepare_product "
				+ " WHERE  is_deleted=0 AND status!=12 AND order_id=? AND order_product_id NOT IN ("
				+ ids.substring(0, ids.length() - 1) + " ) AND  cms_product_code in ("
				+ code.substring(0, code.length() - 1) + ")";
		List<Object> params = new ArrayList<Object>();
		params.add(orderId);
		List<OrderPrepareProductPO> _is_null = orderPrepareProductDao.findListBySql(sql, params);
		if (CollectionUtils.isNotEmpty(_is_null)) {
			throw new BussinessException("新增商品不能重复！");
		}
	}

	@Override
	public void addOrderProducts(int orderId, List<UpdateOrderProductForm> orderProducts, String operator)
			throws BussinessException {
		OrderPO po = orderDao.getObject(orderId);
		if (po == null)
			throw new BussinessException("参数错误");
		OrderAddressPO address = this.getOrderAddress(orderId);
		if (po.getStatus() > OrderStatus.已配货.getVal()) {
			throw new BussinessException("订单状态不允许操作！");
		}
		// 验证小批量订单下架
//		if (isCommuication2Other(po)) {
			// 通过getOrderById接口返回的Order.isSmallLotOrderOffshelfed
			// 。true就抛异常：订单已生成下架单不可以修改。false就可以修改备货
//			com.itecheasy.webservice.cms.order.Order cmsOrder = CMSOrderClient.getOrderByCode(po.getCode());
//			if (cmsOrder != null) {
//				if (cmsOrder.isIsSmallLotOrderOffShelveing() != null && cmsOrder.isIsSmallLotOrderOffShelveing()) {
//					throw new BussinessException("订单已生成下架单不可以修改!");
//				}
//			}
//		}

		// 判断是否会出现重复的备货商品
		checkRepeat4UpdateOrderProduct(orderId, orderProducts);
		List<OrderProductPO> orderProductPOs = new ArrayList<OrderProductPO>();
		List<OrderPrepareProductPO> items = new ArrayList<OrderPrepareProductPO>();
		boolean _order_has_limit_product = false;
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
			
			hasAvailableStockout(form, updateProductCode, product);
			OrderProductPO oppo = new OrderProductPO();
			oppo.setCmsProductCode(updateProductCode);
			oppo.setCmsProductId(product.getId());
			oppo.setProductId(null);
			oppo.setUnit(product.getUnit());
			oppo.setUnitQty(form.getUnitQty());
			oppo.setOrderId(orderId);
			orderProductDao.addObject(oppo);
			// 再添加
			OrderPrepareProductPO ppo = new OrderPrepareProductPO();

			_order_has_limit_product = processOrderProductLimit4UpdateOrder(po, address, _order_has_limit_product,
					product, ppo);

			ppo.setOrderId(orderId);
			ppo.setOrderProductId(oppo.getId());
			ppo.setOrderQty(qty);
			ppo.setPrepareQty(0);

			ppo.setUnit(product.getUnit());
			ppo.setUnitQty(form.getUnitQty());
			ppo.setUnitVolume(CalcUtils.unitVoluem(product.getVolume(), form.getUnitQty()).doubleValue());
			ppo.setUnitWeight(CalcUtils.unitweight(product.getWeight(), form.getUnitQty()).doubleValue());

			ppo.setStatus(OrderProductStatus.备货中.getVal());
			ppo.setCmsProductCode(updateProductCode);
			ppo.setCmsProductId(product.getId());
			ppo.setCostPrice(product.getCostPrice().multiply(new BigDecimal(form.getQty()))
					.multiply(new BigDecimal(product.getUnitQuantity())).setScale(3, 4).doubleValue());
			oppo.setGift(true);
			// 更新订单成本价
			po.setCostPrice((po.getCostPrice() == null ? 0 : po.getCostPrice()) + ppo.getCostPrice());
			ppo.setAbnormalMate(false);
			ppo.setCmsPrepare(setOrderItemPrepareTypeByOrder(po));

			orderPrepareProductDao.addObject(ppo);
			items.add(ppo);
			po.setOrderItemNum(po.getOrderItemNum() + 1);
			addOrderOperateLog("新增订单商品项" + updateProductCode, operator, po.getId());
			// po.setCmsPrepare(true);

			orderProductPOs.add(oppo);
		}
		po.setElectronic(isElectronic(orderId));
		updateOrderStatusByOrderProduct(po);
		
		int count = this.getOrderPrepareProduct4LIMIT(po.getId());
		if (OrderStatus.PENDING.getVal() == po.getStatus()) {
			if (count < 1) {
				po.setStatus(OrderStatus.准备货物.getVal());
				changePending2updateOrder(po);
				if (isNeedUpdateOrder2NotCMSPrepare(po.getId())) {
					po.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
				} else {
					pendding2swPrepare(po);
					// 通讯到cms
					CommandOrderUtils.addOrder(this.getOrderDeatil(po.getId()), systemService.getShopInfo(po.getShopId()),false);
				}
			}
		} else {
			// 通讯cms
			if (po.getCmsPrepare()!=ORDER_PREPARE_TYPE_OTHER) {
				// cms备货
				if (isCommuication2Other(po)) {
					if (po.getStatus() > OrderStatus.准备货物.getVal()) {
						// 已备货商品项<总有效项,订单为准备货物
						po.setStatus(OrderStatus.准备货物.getVal());
					}
					CommandOrderUtils.addOrderItems(po.getRemark(), po.getCode(), po.getStatus(), items, orderProductPOs,
							po.getShopType(),po.getCmsPrepare());
				}
			} else {
				// 非cms备货
				po.setCmsPrepare(ORDER_PREPARE_TYPE_CMS);//非全部是sw备货
				if (count < 1 && !_order_has_limit_product) {
					// 通讯到cms
					po.setStatus(OrderStatus.准备货物.getVal());
					changePending2updateOrder(po);
					CommandOrderUtils.addOrder(this.getOrderDeatil(po.getId()), systemService.getShopInfo(po.getShopId()),false);
				} else {
					po.setStatus(OrderStatus.PENDING.getVal());
				}
			}
		}

		orderDao.updateObject(po);
	}


	/**旧：设置为cms备货
	 * -->新：根据订单备货类型设置订单商品备货类型
	 * -->sw订单只允许添加sw商品
	 * 
	 * @param po
	 * @return
	 */
	private int setOrderItemPrepareTypeByOrder(OrderPO po) {
		return po.getCmsPrepare()==ORDER_PREPARE_TYPE_SW?ORDER_PREPARE_TYPE_SW:ORDER_PREPARE_TYPE_CMS;
	}

	/**
	 * 订单条件判断、带电，纺织品、带磁
	 * 
	 * @param po
	 * @param address
	 * @param _order_has_limit_product
	 * @param cmsProduct
	 * @param ppo
	 * @return
	 */
	private boolean processOrderProductLimit4UpdateOrder(OrderPO po, OrderAddressPO address,
			boolean _order_has_limit_product, CMSProduct cmsProduct, OrderPrepareProductPO ppo) {
		// 限制商品
		if (po.getStatus() == OrderStatus.PENDING.getVal()) {
			if (DMSUtils.islimit(cmsProduct.getCategory1Name(), cmsProduct.getCategory2Name(),
					cmsProduct.getCategory3Name(), cmsProduct.getProductPropertyValues(), address.getCountryId())) {
				ppo.setIslimit(true);
				_order_has_limit_product = true;
			}
		}
		// 带磁
		if (DMSUtils.isMagnetism(cmsProduct.getCategory1Name(), cmsProduct.getCategory2Name(),
				cmsProduct.getCategory3Name(), cmsProduct.getProductPropertyValues())) {
			ppo.setMagnetism(true);
		}
		// 纺织品
		if (DMSUtils.isTextile$new(cmsProduct.getProductPropertyValues(), cmsProduct.getName())) {
			ppo.setTextile(true);
		}
		// 带电
		if (DMSUtils.isElectronic(cmsProduct.getCategory1Name(), cmsProduct.getCategory2Name(),
				cmsProduct.getCategory3Name(), cmsProduct.getProductPropertyValues())) {
			ppo.setElectronic(true);
		}
		return _order_has_limit_product;
	}

	public void updateOrderProducts(int orderId, String operator, List<UpdateOrderProductForm> forms)
			throws BussinessException {
		if (CollectionUtils.isEmpty(forms)) {
			return;
		}
		OrderPO po = orderDao.getObject(orderId);
		int _old_prepare_type=po.getCmsPrepare();
		OrderAddressPO address = this.getOrderAddress(orderId);
		StringBuilder cancleOrderItemIds = new StringBuilder();
		StringBuilder cancelReason = new StringBuilder();

		// 验证小批量订单下架
//		if (isCommuication2Other(po)) {
			// 通过getOrderById接口返回的Order.isSmallLotOrderOffshelfed
			// 。true就抛异常：订单已生成下架单不可以修改。false就可以修改备货
//			com.itecheasy.webservice.cms.order.Order cmsOrder = CMSOrderClient.getOrderByCode(po.getCode());
//			if (cmsOrder != null) {
//				if (cmsOrder.isIsSmallLotOrderOffShelveing() != null && cmsOrder.isIsSmallLotOrderOffShelveing()) {
//					throw new BussinessException("订单已生成下架单不可以修改!");
//				}
//			}
//		}

		// 判断是否会出现重复的备货商品
		checkRepeat4UpdateOrderProduct(orderId, forms);

		StringBuilder remark = new StringBuilder("");
		// 判断订单是否有限制商品
		boolean _order_has_limit_product = false;
		List<OrderPrepareProductPO> items = new ArrayList<OrderPrepareProductPO>();
		List<OrderProductPO> orderProducts = new ArrayList<OrderProductPO>();
		for (UpdateOrderProductForm form : forms) {

			int orderProductId = form.getOrderProductId();
			String updateProductCode = form.getUpdateProductCode();
			double qty = form.getQty();
			OrderProductPO oppo = orderProductDao.getObject(orderProductId);
			OrderPrepareProductPO old_ppo = getOrderPrepareProductByOrderProduct(oppo.getId());

			CMSProduct product = CMSClient.getCMSProductByCode(updateProductCode);
			if (product == null) {
				throw new BussinessException("商品编码" + updateProductCode + "不存在");
			}

			if (form.getUpdateProductCode().equalsIgnoreCase(old_ppo.getCmsProductCode())) {
				updateOrderProducts4Unit(operator, po, form, old_ppo, remark, product,oppo);
			} else {
				double _result = form.getUnitQty() * form.getQty();
				if (Double.valueOf((int) _result) != _result) {
					throw new BussinessException("任务数必须为整数！");
				}

				swOrderAddItemLimit(po, form, product);
				// 永久下架判断可用库存
				hasAvailableStockout(form, updateProductCode, product);

				// 先取消//只有备货中和断货状态可以修改备货商品
				updateOrderProduct$cancel(old_ppo, po, oppo, operator, cancleOrderItemIds);
				cancelReason.append(",").append(1);

				// 再添加
				OrderPrepareProductPO ppo = updateOrderProduct4Update(orderId, po, orderProductId, updateProductCode,
						qty, oppo, product);
				// 订单限制条件判断
				_order_has_limit_product = processOrderProductLimit4UpdateOrder(po, address, _order_has_limit_product,
						product, ppo);

				// 更新订单成本价
				po.setCostPrice((po.getCostPrice() == null ? 0 : po.getCostPrice()) + ppo.getCostPrice());
				addOrderOperateLog("修改备货商品：" + old_ppo.getCmsProductCode() + "为" + ppo.getCmsProductCode(), operator,
						po.getId());

				// ts商品判断
				//-->>2016-10-07去掉ts商品非cms备货设置
//				if (product.isProductTs()&&po.getShopType()==ShopType.AMAZON.getVal()) {
//					ppo.setCmsPrepare(false);
//					addOrderOperateLog("订单备货商品" + ppo.getCmsProductCode() == null ? "" : ppo.getCmsProductCode()
//							+ "自动设置为非C3备货", "系统", po.getId());
//				} else {
					orderProducts.add(oppo);
					items.add(ppo);
//				}

			}

		}
		updateOrderStatusByOrderProduct(po);

		int count = this.getOrderPrepareProduct4LIMIT(po.getId());
		if (cancleOrderItemIds.length() > 0) {
			// 订单判断带电
			po.setElectronic(isElectronic(orderId));
			// 通讯cms
			if (po.getCmsPrepare()!=ORDER_PREPARE_TYPE_OTHER) {
				if (po.getStatus() > OrderStatus.PENDING.getVal()) {
					//先取消，后新增-->先新增，再取消  取消会导致订单变成待校对状态，之后添加商品会导致订单状态不对（实际上该状态是不予许添加商品 2016-10-27）
					if (orderProducts.size() > 0) {
						CommandOrderUtils.addOrderItems(po.getRemark(), po.getCode(), po.getStatus(), items, orderProducts,
								po.getShopType(),po.getCmsPrepare());
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					CommandOrderUtils.cancleOrderItem(po.getCode(), po.getStatus(), cancleOrderItemIds.toString()
							.substring(1), cancelReason.toString().substring(1),po.getCmsPrepare());
				}
				// 受ts影响
				if (isNeedUpdateOrder2NotCMSPrepare(po.getId())) {
					po.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
					if (po.getStatus() > OrderStatus.PENDING.getVal()) {
						CommandOrderUtils.cancleOrder(po.getCode(),null,_old_prepare_type);
					}
					po.setStatus(OrderStatus.准备货物.getVal());
				}
				// 判断订单限制状态
				else if (OrderStatus.PENDING.getVal() == po.getStatus()) {
					if (count < 1 && !_order_has_limit_product) {
						// 通讯到cms
						po.setStatus(OrderStatus.准备货物.getVal());
						changePending2updateOrder(po);
						pendding2swPrepare(po);
						CommandOrderUtils
								.addOrder(this.getOrderDeatil(po.getId()), systemService.getShopInfo(po.getShopId()),false);
					}
				}
			}
		}
	}


	/**
	 * sw订单增加商品项的限制
	 * @param po
	 * @param form
	 * @param product
	 */
	private void swOrderAddItemLimit(OrderPO po, UpdateOrderProductForm form, CMSProduct product) {
		if(po.getCmsPrepare()==ORDER_PREPARE_TYPE_SW){
			if(form.getQty()%(int)form.getQty()!=0){
				throw new BussinessException("sw订单订购量必须是整数！");
			}
			if(!CMSClient.isSwProduct(product.getId())){
				throw new BussinessException("sw订单只能包含sw商品！");
			}
		}
	}
	
	@Override
	public void updateOrderProductInfos(List<UpdateOrdertProductInfo> updateOrdertProductInfos, String operator) {
		List<UpdateOrdertProductInfo> communication=new ArrayList<UpdateOrdertProductInfo>();
		StringBuilder remark=new StringBuilder();
		int orderId=0;
		for (UpdateOrdertProductInfo info : updateOrdertProductInfos) {
			OrderPrepareProductPO item= this.orderPrepareProductDao.getObject(info.getOrderPrepareProductId());
			if(item==null)
				continue;
			
			orderId=item.getOrderId();
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
			OrderPO po =this.orderDao.getObject(orderId);
			if(isCommuication2Other(po))
				CommandOrderUtils.updateOrderItemRemarkToCMS(po.getCode(), communication,po.getCmsPrepare());
		}
	}

	/**
	 * 更新订单状态
	 * 
	 * @param po
	 */
	protected void updateOrderStatusByOrderProduct(OrderPO po) {
		if (po.getStatus() <= OrderStatus.PENDING.getVal()) {
			return;
		}
		// 去掉非cms备货商品
		List<OrderPrepareProductPO> pos = this.getNotCMSPrepareProduct(po.getId());
		int total = po.getOrderItemNum();
		if (CollectionUtils.isNotEmpty(pos))
			total = total - pos.size();

		if (total <= po.getOrderItemPrepareNum()) {
			if(po.getStatus()==OrderStatus.已配货.getVal()
					||po.getStatus()==OrderStatus.配货中.getVal()){
				
			}else{
				po.setStatus(OrderStatus.已备货.getVal());
			}
//			po.setStatus(OrderStatus.已备货.getVal());
//			if (po.getIsSend() != null && po.getIsSend()) {
//				po.setStatus(OrderStatus.待校对.getVal());
//			}
		} else {
			po.setStatus(OrderStatus.准备货物.getVal());
		}
	}

	private OrderPrepareProductPO updateOrderProduct4Update(int orderId, OrderPO po, int orderProductId,
			String updateProductCode, double qty, OrderProductPO oppo, CMSProduct product) {
		OrderPrepareProductPO ppo = new OrderPrepareProductPO();
		ppo.setOrderId(orderId);
		ppo.setOrderProductId(orderProductId);
		ppo.setOrderQty(qty);
		ppo.setPrepareQty(0);
		ppo.setUnit(product.getUnit());
		ppo.setUnitQty(product.getUnitQuantity());
		ppo.setStatus(1);
		ppo.setCmsProductCode(updateProductCode);
		ppo.setCmsProductId(product.getId());
		ppo.setCostPrice(product.getCostPrice().multiply(new BigDecimal(qty))
				.multiply(new BigDecimal(product.getUnitQuantity())).setScale(3, 4).doubleValue());
		ppo.setUnitVolume(CalcUtils.unitVoluem(product.getVolume(), product.getUnitQuantity()).doubleValue());
		ppo.setUnitWeight(CalcUtils.unitweight(product.getWeight(), product.getUnitQuantity()).doubleValue());
		ppo.setCmsPrepare(setOrderItemPrepareTypeByOrder(po));
		ppo.setAbnormalMate(false);

		oppo.setUnit(product.getUnit());
		oppo.setUnitQty(product.getUnitQuantity());
		oppo.setCmsProductCode(updateProductCode);
		oppo.setCmsProductId(product.getId());
		orderPrepareProductDao.addObject(ppo);
		po.setOrderItemNum(po.getOrderItemNum() + 1);
		po.setCmsPrepare(setOrderItemPrepareTypeByOrder(po));

		orderProductDao.mergeObject(oppo);
		return ppo;
	}

	private void updateOrderProducts4Unit(String operator, OrderPO po, UpdateOrderProductForm form,
			OrderPrepareProductPO old_ppo, StringBuilder remark, CMSProduct product,OrderProductPO oppo) throws BussinessException {
		if (old_ppo.getUnitQty() != form.getUnitQty()) {
			remark.append(MessageFormat.format("{2}:修改批量数量：“{0}”为“{1}”;", String.valueOf(old_ppo.getUnitQty()),
					form.getUnitQty(),form.getUpdateProductCode()));
		}

		if (old_ppo.getOrderQty() != form.getQty()) {
			remark.append(MessageFormat.format("{2}:修改订购量：“{0}”为“{1}”;", String.valueOf(old_ppo.getOrderQty()),
					form.getQty(),form.getUpdateProductCode()));
		}
		
		// 更新订单成本价
		po.setCostPrice(po.getCostPrice() == null ? 0 : (po.getCostPrice() - old_ppo.getCostPrice()));
		old_ppo.setCostPrice(product.getCostPrice().multiply(new BigDecimal(form.getQty()))
				.multiply(new BigDecimal(form.getUnitQty())).setScale(3, 4).doubleValue());
		po.setCostPrice(po.getCostPrice() + old_ppo.getCostPrice());
		
		old_ppo.setOrderQty(form.getQty());
		old_ppo.setUnitQty(form.getUnitQty());

		if (old_ppo.getPrepareQty() >= old_ppo.getOrderQty()) {
			if (old_ppo.getStatus() != OrderProductStatus.已备货.getVal()) {
				po.setOrderItemPrepareNum(po.getOrderItemPrepareNum() + 1);
			}
			old_ppo.setPrepareQty(old_ppo.getOrderQty());
			old_ppo.setStatus(OrderProductStatus.已备货.getVal());
		} else {
			if (old_ppo.getStatus() == OrderProductStatus.已备货.getVal()) {
				po.setOrderItemPrepareNum(po.getOrderItemPrepareNum() - 1);
			}
			old_ppo.setStatus(OrderProductStatus.备货中.getVal());
		}
		double _result = old_ppo.getUnitQty() * old_ppo.getOrderQty();
		if (Double.valueOf((int) _result) != _result) {
			throw new BussinessException("任务数必须为整数！");
		}
		decideOrderStatus4UpdateOrderItemNum(po);
		if (remark.length() > 0) {
			addOrderOperateLog(remark.toString(), operator, po.getId());

			if (isCommuication2Other(po)) {
				CommandOrderUtils.updateOrderItemQuantity(po.getCode(), po.getStatus(), old_ppo.getId(),
						old_ppo.getOrderQty() , old_ppo.getUnitQty(),po.getCmsPrepare(),oppo.getShopItemPrice()-oppo.getShopDiscount(),
						oppo.getShopItemCurtype()
						);
			}
		}
	}

	/**
	 * 修改订单下数量，影响订单状态
	 * 
	 * @param po
	 */
	private void decideOrderStatus4UpdateOrderItemNum(OrderPO po) {
		if (isCommuication2Other(po)) {
			if (po.getOrderItemPrepareNum() >= po.getOrderItemNum()) {
//				if (po.getIsSend() != null && po.getIsSend()) {
//					po.setStatus(OrderStatus.待校对.getVal());
//				} else {
//					po.setStatus(OrderStatus.已备货.getVal());
					if(po.getStatus()==OrderStatus.已配货.getVal()
							||po.getStatus()==OrderStatus.配货中.getVal()){
						
					}else{
						po.setStatus(OrderStatus.已备货.getVal());
					}
//				}
			} else {
				po.setStatus(OrderStatus.准备货物.getVal());
			}
		}
	}

	protected void calcOrderProblem(OrderPO po, int ProblemType, int status) {
		String hql2 = "from OrderPrepareProductPO where status=? and orderId=? ";
		List<OrderPrepareProductPO> pos = orderPrepareProductDao.findListByHql(hql2,
				new Object[] { status, po.getId() });
		if (CollectionUtils.isEmpty(pos)) {
			clearProblem(po, ProblemType);
		}
	}

	private boolean isElectronic(int orderId) {
		String sql = "from OrderPrepareProductPO where status!=12 and orderId=? and electronic=true order by status asc";
		List<OrderPrepareProductPO> pos = orderPrepareProductDao.findListByHql(sql, orderId);
		if (CollectionUtils.isNotEmpty(pos)) {
			return true;
		}
		return false;
	}

	/**
	 * 是否通讯给其他系统
	 * @param po
	 * @return
	 */
	private boolean isCommuication2Other(OrderPO po) {
		if (po.getStatus() > OrderStatus.PENDING.getVal() && po.getCmsPrepare()!=ORDER_PREPARE_TYPE_OTHER) {
			return true;
		}
		return false;
	}
	
	/**
	 * 是否都是sw备货
	 * @param pos
	 * @return
	 */
	private boolean isAllSwProduct(List<OrderPrepareProductPO> pos){
		for (OrderPrepareProductPO po : pos) {
			if(!CMSClient.isSwProduct(po.getCmsProductId()))
				return false;
		}
		
		return true;
	}
	
	/**
	 * 设置sw备货
	 * @param po
	 * @return
	 */
	private boolean pendding2swPrepare(OrderPO po){
//		if(po.getStatus()>OrderStatus.PENDING.getVal())
//			return false;
		List<OrderPrepareProductPO> pos=this.getPrepareProduct(po.getId());
		if(isOpeaSw()&&po.getShopType()==ShopType.AMAZON.getVal()
				&&isAllSwProduct(pos)){
			po.setCmsPrepare(ORDER_PREPARE_TYPE_SW);
			for (OrderPrepareProductPO orderPrepareProductPO : pos) {
				orderPrepareProductPO.setCmsPrepare(ORDER_PREPARE_TYPE_SW);
			}
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 是否需要增加订单到其他系统
	 * @param po
	 * @return
	 */
	private boolean isNeedAdd2Other(OrderPO po) {
		return OrderStatus.PENDING.getVal() == po.getStatus() && 
				po.getCmsPrepare()!=ORDER_PREPARE_TYPE_OTHER;
	}

	/**
	 * 将pending状态的订单改变状态时，初始化某些值
	 * 
	 * @param po
	 */
	private void changePending2updateOrder(OrderPO po) {
		// po.setProblemStatus(0);
		// po.setProblemType(0);
		// 忽略了 货运信息有问题 ，
		if (!isUpdateRemark(po.getId())) {
			po.setRemark(null);
		}
	}

	/**
	 * 判断是否手动修改过订单备注
	 * 
	 * @param orderId
	 * @return
	 */
	private boolean isUpdateRemark(int orderId) {
		Criteria criteria = new Criteria(OrderOperateLogPO.class);
		criteria.and(Restriction.eq("objectId", orderId));
		criteria.and(Restriction.like("comment", "%订单备注%"));
		OrderOperateLogPO po = orderOperateLogDao.get(criteria);
		if (po != null) {
			return true;
		}
		return false;
	}

	@Override
	public void updateOrderAddress(OrderAddress address, String operator, boolean tag) throws BussinessException {
		OrderAddressPO ad = orderAddressDao.getObject(address.getId());
		// 防止重复更新
		boolean _is_need_update = true;
		OrderPO po = orderDao.getObject(ad.getOrderId());
		if (po != null) {
			// 偏远
			ShopInfo shop = systemService.getShopInfo(po.getShopId());
			AccountSetting AccountSetting=DMSUtils.getAccountSetting(shop.getShopSource().intValue());
			boolean isRemote = false;
			if (DMSClient.isRemote(address.getCountryId(), po.getShippingMethod(), address.getCity(),
					address.getPostalCode(),AccountSetting ))
				isRemote = true;
			// 判断是否同票
			po.setRemote(isRemote);
			if (po.getSendGroupId() != null) {
				if (tag) {
					// 修改同票订单
					List<OrderPO> orders = this.getTicketGrouypPOByGroupId(po.getSendGroupId());
					_is_need_update = false;
					for (OrderPO order2 : orders) {
						OrderAddressPO ad2 = this.getOrderAddress(order2.getId());
						updateAddressSimple(address, operator, ad2, order2, AccountSetting, isRemote);
					}
				} else {
					// 取消同票
					this.cancelTicketGroup(po.getId(), operator);
				}
			}

			if (_is_need_update) {
				updateAddressSimple(address, operator, ad, po, AccountSetting, isRemote);
			}

		}
	}

	private void updateAddressSimple(OrderAddress address, String operator, OrderAddressPO adress, OrderPO po,
			AccountSetting AccountSetting, boolean isRemote) {
		String old = adress.toString();
		BeanUtils.copyProperties(address, adress, new String[] { "remark" ,"id","orderId"});
		orderAddressDao.updateObject(adress);
		po.setCountry(adress.getCountryId());
		addOrderOperateLog("修改货运地址:“" + old + "”" + "修改为" + adress.toString(), operator, adress.getOrderId());

		updateOrderAddress2other(address, po, isRemote,AccountSetting);
	}

	/**
	 * 通讯货运地址
	 * 
	 * @param address
	 * @param po
	 * @param isRemote
	 */
	private void updateOrderAddress2other(OrderAddress address, OrderPO po, boolean isRemote,AccountSetting AccountSetting) throws BussinessException {
		if (!hasProblemForAddressInfo(address)) {
			// 去掉“货运信息有问题”
			clearProblem(po, OrderProblemType.货运信息有问题.getVal());
		}
		if (isNeedAdd2Other(po)) {
			int count = this.getOrderPrepareProduct4LIMIT(po.getId());
			if (count < 1) {
				// 通讯到cms
				po.setStatus(OrderStatus.准备货物.getVal());
				changePending2updateOrder(po);
				if (isNeedUpdateOrder2NotCMSPrepare(po.getId())) {
					po.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
				} else {
					pendding2swPrepare(po);
					CommandOrderUtils.addOrder(this.getOrderDeatil(po.getId()), systemService.getShopInfo(po.getShopId()),false);
				}
			}
		} else if (isCommuication2Other(po)) {
			// 已出库时要通信给dms
			if (po.getStatus() >= OrderStatus.已出库.getVal()&&po.getCmsPrepare()==ORDER_PREPARE_TYPE_CMS) {
					DMSClient.updateOrderShippingAddress(address,
							po.getCode(),po.getWebWeight(),po.getShippingMethod(),
							po.getCPFType(),po.getCPFCode(),po.getCustomerAccount(),po.getRemote(),
							AccountSetting,po.getCmsPrepare());
			}
			// 通讯cms
			CommandOrderUtils.updateOrderaddress(po.getCode(), address, isRemote, po.getCPFType(),po.getCPFCode(),po.getCmsPrepare());
		}

	}



	/**
	 * 清除订单已修复的问题
	 * 
	 * @param po
	 * @param problemType
	 */
	protected void clearProblem(OrderPO po, int problemType) {
		if (po.getProblemStatus() > 0) {
			if ((po.getProblemVal() & problemType) == problemType) {
				po.setProblemVal(po.getProblemVal() - problemType);
				if (po.getProblemVal() == 0) {
					po.setProblemType(0);
					po.setProblemStatus(0);
					return;
				}

				if (po.getProblemType() == problemType) {
					po.setProblemType(NumberComparator.reverseMinBinary(po.getProblemVal()));
				}
			}
		}
	}

	private List<OrderPO> getTicketGrouypPOByGroupId(int groupId) {
		Criteria criteria = new Criteria(OrderPO.class);
		criteria.and(Restriction.eq("sendGroupId", groupId));
		return orderDao.list(criteria);
	}

	@Override
	public void updateShippingMethod(int orderId, int shippingMethod, String operator, boolean tag) {
		OrderPO po = orderDao.getObject(orderId);
		// 防止重复更新
		boolean _is_need_update = true;
		AccountSetting AccountSetting=DMSUtils.getAccountSetting(
				systemService.getShopInfo(po.getShopId()).getShopSource().intValue());
		if (po != null && po.getShippingMethod() != shippingMethod) {
			// 判断是否同票
			if (po.getSendGroupId() != null) {
				if (tag) {
					// 修改同票订单
					List<OrderPO> orders = this.getTicketGrouypPOByGroupId(po.getSendGroupId());
					_is_need_update = false;
					for (OrderPO order2 : orders) {
						addOrderOperateLog("修改货运方式"
								+ systemService.getShippingMethod(order2.getShippingMethod()).getName() + "为"
								+ systemService.getShippingMethod(shippingMethod).getName(), operator, order2.getId());
						order2.setShippingMethod(shippingMethod);
						updateShippingMethod2other(shippingMethod, order2,AccountSetting);
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

	/**
	 * 通讯货运方式
	 * 
	 * @param shippingMethod
	 * @param po
	 */
	private void updateShippingMethod2other(int shippingMethod, OrderPO po,AccountSetting AccountSetting) {
		// 去掉“无法识别货运方式”
		clearProblem(po, OrderProblemType.无法识别货运方式.getVal());
		if (isNeedAdd2Other(po)) {
			int count = this.getOrderPrepareProduct4LIMIT(po.getId());
			if (count < 1) {
				// 通讯到cms
				po.setStatus(OrderStatus.准备货物.getVal());
				changePending2updateOrder(po);
				if (isNeedUpdateOrder2NotCMSPrepare(po.getId())) {
					po.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
				} else {
					pendding2swPrepare(po);
					CommandOrderUtils.addOrder(this.getOrderDeatil(po.getId()), systemService.getShopInfo(po.getShopId()),false);
				}
			}
		} else if (isCommuication2Other(po)) {
			// 已出库时要通信给dms
			if (po.getStatus() >= OrderStatus.已出库.getVal()&&po.getCmsPrepare()==ORDER_PREPARE_TYPE_CMS
					) {
				try {
					DMSClient.updateOrderShippingAddress(BeanUtils.copyProperties(getOrderAddress(po.getId()), OrderAddress.class),
							po.getCode(),po.getWebWeight(),po.getShippingMethod(),
							po.getCPFType(),po.getCPFCode(),po.getCustomerAccount(),po.getRemote(),
							AccountSetting,po.getCmsPrepare());
				} catch (BussinessException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
			// 通讯cms
			CommandOrderUtils.updateOrderDelivery(po.getCode(), shippingMethod, po.getShopShippingPrice(),
					po.getOrderCurrency(),po.getCmsPrepare());

			// 修改报关百分比
			CommandOrderUtils.updateOrder(BeanUtils.copyProperties(po,Order.class), "",
					this.getOrderAddress(po.getId()).getRemark(),po.getCmsPrepare());
		}
	}

	@Override
	public void saveSendRemark(int orderId, String remark, String cpfCode, int cpfType, String operator) {
		String hql = "from OrderAddressPO where orderId=?";
		OrderAddressPO po = orderAddressDao.findByHql(hql, orderId);
		if (po != null) {
			po.setRemark(remark);
			addOrderOperateLog("修改订单的发货说明:" + remark, operator, orderId);
			// 通讯cms
			OrderPO o = orderDao.getObject(orderId);
			o.setCPFCode(cpfCode);
			o.setCPFType(cpfType);
			if (isCommuication2Other(o)) {
				CommandOrderUtils.updateOrder(BeanUtils.copyProperties(o,Order.class), operator, po.getRemark(),o.getCmsPrepare());
			}
		}

	}

	private OrderAddressPO getOrderAddress(int orderId) {
		Criteria criteria = new Criteria(OrderAddressPO.class);
		criteria.and(Restriction.eq("orderId", orderId));
		return orderAddressDao.get(criteria);
	}
	
	
	private List<OrderProductPO> getOrderProduct(int orderId) {
		Criteria criteria = new Criteria(OrderProductPO.class);
		criteria.and(Restriction.eq("orderId", orderId));
		return orderProductDao.list(criteria);
	}

	protected List<OrderProductPO> getOrderProductNotCancel(int orderId) {
		Criteria criteria = new Criteria(OrderProductPO.class);
		criteria.and(Restriction.eq("orderId", orderId));
		criteria.and(Restriction.eq("cancel", false));
		return orderProductDao.list(criteria);
	}

	/**
	 * 查看使订单无法添加到cms的商品项(非cms备货商品除外) <li>限制状态的商品项</li> <li>或者cms商品id为0</li> <li>
	 * 通过sku匹配cmsproductcode的商品，需要检查</li> <li>订单问题</li>
	 * 
	 * @param orderId
	 * @return
	 */
	private int getOrderPrepareProduct4LIMIT(int orderId) {
		OrderPO po = orderDao.getObject(orderId);
		// 断货
		calcOrderProblem(po, OrderProblemType.断货.getVal(), OrderProductStatus.断货.getVal());
		//2017-08-02 原(cmsPrepare=true)新(cmsPrepare!=0) 
		String hql = "from OrderPrepareProductPO where status!=12 and orderId=? and (islimit=true or cmsProductId=0 or abnormalMate=true) and cmsPrepare!=0 ";
		List<OrderPrepareProductPO> pos = orderPrepareProductDao.findListByHql(hql, orderId);
		if (CollectionUtils.isNotEmpty(pos)) {
			return pos.size();
		}
		// 清掉“无法匹配商品”
		clearProblem(po, OrderProblemType.无法匹配商品.getVal());
		if (po.getProblemVal() == 0) {
			changePending2updateOrder(po);
		}
		// 订单问题(排除“货运信息有问题”)
		return po.getProblemVal() == OrderProblemType.货运信息有问题.getVal() ? 0 : po.getProblemVal();
	}

	/**
	 * 获取订单商品对应的最后一个备货商品
	 * 
	 * @param orderProductId
	 * @return
	 */
	protected OrderPrepareProductPO getOrderPrepareProductByOrderProduct(int orderProductId) {
		String hql = "from OrderPrepareProductPO where orderProductId=? order by id desc";
		return orderPrepareProductDao.findByHql(hql, orderProductId);
	}


	@Override
	public void updateOrderShippingMethod(OrderDetail orderDetail) {
		orderDao.updateObject(BeanUtils.copyProperties(orderDetail,OrderPO.class));
	}


	@Override
	public OrderDetail getOrderDeatil$remote(int orderId) {
		OrderPO po = orderDao.getObject(orderId);
		if (po != null) {
			OrderDetail detail = BeanUtils.copyProperties(po, OrderDetail.class);
			OrderAddressPO orderAddressPO = getOrderAddress(orderId);   //根据传过来的orderId来获取到地址对象
			if (orderAddressPO != null) {
				detail.setOrderAddress(BeanUtils.copyProperties(orderAddressPO, OrderAddress.class)); //写入到订单vo中
			}
			List<Integer> productCodeList = new ArrayList<Integer>();
			List<OrderProductPO> pps = getOrderProduct(orderId);   //根据传过来的orderId来获取到productList
			if (CollectionUtils.isNotEmpty(pps)) {
				List<OrderProduct> ops = BeanUtils.copyList(pps, OrderProduct.class);
				for (OrderProduct op : ops) {
					OrderPrepareProductPO oppo = getOrderPrepareProductByOrderProduct(op.getId());
					if (oppo != null) {
						OrderPrepareProduct opp = BeanUtils.copyProperties(oppo, OrderPrepareProduct.class);
						CMSProduct cms = CMSClient.getCMSProduct(opp.getCmsProductId());  //通讯c3
						op.setObjectId(opp.getId());
						if (cms != null) {
							opp.setAvailableQty(new BigDecimal(cms.getAvailableStock()).divide(
									new BigDecimal(cms.getUnitQuantity()), 0, BigDecimal.ROUND_DOWN).intValue());
						}
						op.setOrderPrepareProduct(opp);
//                        productCodeList.add(op.getCmsProductId());
					}
				}
				detail.setOrderItems(ops);   //把productList放入订单的vo对象中
			}

//            //在查出订单所有的值之后判断
//            //判断默认的货运方式（实际货运方式）
//            int shoppingMethod =  super.checkShopShippingMethodReturnNum(detail,productCodeList);  //多传一个参数productCode
//			detail.setShippingMethod(shoppingMethod);
//
			return detail;   //返回订单信息
		}
		return null;
	}

	@Override
	public OrderDetail getOrderDeatil(int orderId) {
		OrderPO po = orderDao.getObject(orderId);
		if (po != null) {
			OrderDetail detail = BeanUtils.copyProperties(po, OrderDetail.class);
			OrderAddressPO orderAddressPO = getOrderAddress(orderId);
			if (orderAddressPO != null) {
				detail.setOrderAddress(BeanUtils.copyProperties(orderAddressPO, OrderAddress.class));
			}
			List<OrderProductPO> pps = getOrderProduct(orderId);
			if (CollectionUtils.isNotEmpty(pps)) {
				List<OrderProduct> ops = BeanUtils.copyList(pps, OrderProduct.class);
				for (OrderProduct op : ops) {
					OrderPrepareProductPO oppo = getOrderPrepareProductByOrderProduct(op.getId());
					if (oppo != null) {
						OrderPrepareProduct opp = BeanUtils.copyProperties(oppo, OrderPrepareProduct.class);
						op.setObjectId(opp.getId());
						op.setOrderPrepareProduct(opp);
					}
				}
				detail.setOrderItems(ops);
			}
			return detail;
		}
		return null;
	}

	@Override
	public List<Order> getTicketGroup(int orderId) {
		String hql = "SELECT a.* FROM dbo.[order] a JOIN dbo.[order] b "
				+ " ON a.send_group_id=b.send_group_id WHERE b.id=?";
		List<Object> param = new ArrayList<Object>();
		param.add(orderId);
		List<OrderPO> pos = orderDao.findListBySql(hql, param);
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyList(pos, Order.class);
		}
		return null;
	}

	public List<Order> getTicketGrouypByGroupId(int groupId) {
		Criteria criteria = new Criteria(OrderPO.class);
		criteria.and(Restriction.eq("sendGroupId", groupId));
		return BeanUtils.copyList(orderDao.list(criteria), Order.class);
	}

	@Override
	public PageList<Order> findOrders(SearchOrderForm form, int currentPage, int pageSize) {
		boolean isQuery = true;

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM dbo.v_order o ");

		StringBuilder where = new StringBuilder("");
		List<Object> params = new ArrayList<Object>();
		if (StringUtils.isNotEmpty(form.getFulfillmentChannel())) {
			if(form.getFulfillmentChannel().equalsIgnoreCase("MFN")){
				where.append(" AND (o.fulfillmentChannel=? or fulfillmentChannel is null or o.copy=1)");//fba复制订单
			}else{
				where.append(" AND o.fulfillmentChannel=? and copy is null ");
			}
			params.add(form.getFulfillmentChannel());
		}
		if (StringUtils.isNotEmpty(form.getOrderCode())) {
			where.append(" AND o.code LIKE ? ");
			params.add("%" + form.getOrderCode() + "%");
			isQuery = false;
		}
		if (StringUtils.isNotEmpty(form.getShopOrderCode())) {
			where.append(" AND o.shop_order_code LIKE ? ");
			params.add("%" + form.getShopOrderCode() + "%");
			isQuery = false;
		}
		if (form.getOperator() > 0 && form.getShopId() < 0) {
			sql.append(" INNER JOIN dbo.user_shop us ON us.shop_id=o.shop_id  ");
			where.append(" AND us.user_id=? ");
			params.add(form.getOperator());
		}
		if(form.getShopType()>0){
			where.append(" AND o.shop_type=? ");
			params.add(form.getShopType());
		}else{
			where.append(" AND o.shop_type<>3 ");
		}
		if (isQuery) {
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
				where.append(" AND o.shop_order_date>? ");
				params.add(DateUtils.getRealDate(form.getPurchaseDateFrom()));
			}
			if (form.getPurchaseDateTo() != null) {
				where.append(" AND o.shop_order_date<? ");
				params.add(DateUtils.getFullDate(form.getPurchaseDateTo()));
			}
			if (form.getEarliestDeliveryDate() != null) {
				where.append(" AND o.latest_delivery_date>? ");
				params.add(DateUtils.getRealDate(form.getEarliestDeliveryDate()));
			}
			if (form.getLatestDeliveryDate() != null) {
				where.append(" AND o.earliest_delivery_date<?  ");
				params.add(DateUtils.getFullDate(form.getLatestDeliveryDate()));
			}
			
			if (form.getEarliestShipDate() != null) {
				where.append(" AND o.latest_ship_date>? ");
				params.add(DateUtils.getRealDate(form.getEarliestShipDate()));
			}
			if (form.getLatestShipDate() != null) {
				if(form.getShopType()==ShopType.SMT.getVal()){
					where.append(" AND o.latest_ship_date<? ");
				}else{
					where.append(" AND o.earliest_shipping_date<?  ");
				}
				params.add(DateUtils.getFullDate(form.getLatestShipDate()));
			}
			if (StringUtils.isNotEmpty(form.getProductCode())) {
				where.append(" AND o.id IN (SELECT DISTINCT order_id  FROM dbo.order_prepare_product "
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
			if (form.getShopId() > -1) {
				where.append(" AND o.shop_id=? ");
				params.add(form.getShopId());
			}
			if (form.getEstimateLatest() > -1) {
				Date currentDate = org.apache.commons.lang.time.DateUtils.addDays(new Date(), 2);
				if (form.getEstimateLatest() == 1) {
					where.append(" AND o.latest_ship_date<?");
					params.add(currentDate);
				} else if (form.getEstimateLatest() == 0) {
					where.append(" AND o.latest_ship_date> ?");
					params.add(currentDate);
				}
				where.append(" and o.status < 64 ");
			}

			if (StringUtils.isNotEmpty(form.getCustomerAccount())) {
				where.append(" AND o.customer_account = ? ");
				params.add(form.getCustomerAccount());
			}
			if (StringUtils.isNotEmpty(form.getShopshippingMethod())) {
				where.append(" AND o.shop_shipping_method = ? ");
				params.add(form.getShopshippingMethod());
			}
			if (form.getProblemStatus() > -1) {
				where.append(" AND o.problem_status = ? ");
				params.add(form.getProblemStatus());
			}

			if (form.getProblemType() > -1) {
				where.append(" AND o.problem_type = ? ");
				params.add(form.getProblemType());
			}

			if (form.getCmsPrepare() > -1) {
				where.append(" AND o.cms_prepare = ? ");
				params.add(form.getCmsPrepare());
			}
		}
		PageList<VOrderPO> pages = vOrderDao.findPageListBySql(currentPage, pageSize, sql.toString(), where.toString(),
				" o.shop_order_date desc", params);
		if (pages != null) {
			return BeanUtils.copyPageList(pages, Order.class);
		}
		return null;
	}

	@Override
	public List<OrderOperateLog> getOrderOperateLogs(int orderId) {
		String hql = "from OrderOperateLogPO where objectId=? order BY id desc";
		List<OrderOperateLogPO> pos = orderOperateLogDao.findListByHql(hql, orderId);
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyList(pos, OrderOperateLog.class);
		}
		return null;
	}

	@Override
	public int getCustomerTotalOrderNum(String customerAccount, int shopId, String fulfillmentChannel) {
		Criteria criteria = new Criteria(OrderPO.class);
		criteria.and(Restriction.eq("customerAccount", customerAccount));
		Shop s=systemService.getShop(shopId);
		if(s.getType()==ShopType.SMT.getVal()){
			criteria.and(Restriction.eq("shopType", ShopType.SMT.getVal()));
		}else{
			criteria.and(Restriction.notEq("shopType", ShopType.SMT.getVal()));
		}
		if(fulfillmentChannel!=null)
			criteria.and(Restriction.eq("fulfillmentChannel", fulfillmentChannel));
		// criteria.and(Restriction.eq("shopId", shopId));
		return orderDao.getCount(criteria);
	}

	@Override
	public void addOrderOperateLog(String comment, String operator, int objectId) {
		OrderOperateLogPO po = new OrderOperateLogPO();
		po.setOperator(operator);
		po.setComment(comment);
		po.setObjectId(objectId);
		po.setOperateDate(new Date());
		orderOperateLogDao.addObject(po);
	}

	@Override
	public void addOrderOperateLog(String comment, String operator, int objectId, Date operatorTime) {
		OrderOperateLogPO po = new OrderOperateLogPO();
		po.setOperator(operator);
		po.setComment(comment);
		po.setObjectId(objectId);
		po.setOperateDate(operatorTime);
		orderOperateLogDao.addObject(po);
	}
	
	public void set2NotCMSPrepare(int orderId, String operator)throws BussinessException{
		OrderPO po=this.orderDao.getObject(orderId);
		if(po==null||po.getCmsPrepare()!=ORDER_PREPARE_TYPE_CMS||po.getStatus()>OrderStatus.已配货.getVal())
			throw new BussinessException("已配货或之前状态的订单才能操作！");
		int _old_prepare_type=po.getCmsPrepare();
		boolean comm=isCommuication2Other(po);
		po.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
		po.setStatus(OrderStatus.准备货物.getVal());
		List<OrderPrepareProductPO>  pps=getCMSPrepareProduct(orderId);
		if(CollectionUtils.isNotEmpty(pps)){
			for (OrderPrepareProductPO pp : pps) {
				pp.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
			}
		}
		
		addOrderOperateLog("设置订单其他备货", operator, po.getId());
		if(po.getSendGroupId()!=null)
			this.cancelTicketGroup(orderId, operator);
		
		if (comm) {//通讯cms
			CommandOrderUtils.cancleOrder(po.getCode(),null,_old_prepare_type);
		}
	}

	public void setOrderItem2NotCMSPrepare(int orderPrepareProductId, String operator) throws BussinessException {
		OrderPrepareProductPO ppo = orderPrepareProductDao.getObject(orderPrepareProductId);
		if (ppo != null) {
			OrderPO orderPO = orderDao.getObject(ppo.getOrderId());
			if (!(orderPO.getStatus() == OrderStatus.PENDING.getVal() && orderPO.getProblemStatus() == 1
					&& orderPO.getProblemType() == OrderProblemType.无法匹配商品.getVal() && ppo.getCmsPrepare()==ORDER_PREPARE_TYPE_CMS)) {
				throw new BussinessException("订单状态为pending + 订单问题状态为“有问题” + 问题类别为“无法匹配商品” + C3备货的商品才能" + "设置为非C3备货商品");
			}
			ppo.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
			orderPrepareProductDao.mergeObject(ppo);

			// 订单判断
			int count = this.getOrderPrepareProduct4LIMIT(orderPO.getId());
			
			if (orderPO.getCmsPrepare()==ORDER_PREPARE_TYPE_CMS) {
				if (count < 1) {
					orderPO.setStatus(OrderStatus.准备货物.getVal());
					changePending2updateOrder(orderPO);
					if (isNeedUpdateOrder2NotCMSPrepare(orderPO.getId())) {
						orderPO.setCmsPrepare(ORDER_PREPARE_TYPE_OTHER);
					} else {
						// 通讯到cms
						CommandOrderUtils.addOrder(this.getOrderDeatil(orderPO.getId()),
								systemService.getShopInfo(orderPO.getShopId()),false);
					}
				}
			}

			addOrderOperateLog("设置订单备货商品" + ppo.getCmsProductCode() == null ? "" : ppo.getCmsProductCode() + "为非C3备货",
					operator, orderPO.getId());
		}
	}

	/**
	 * 判断是否需要把订单变成 非cms备货订单
	 * 
	 * @param orderId
	 * @return
	 */
	public boolean isNeedUpdateOrder2NotCMSPrepare(int orderId) {
		return clacOrderPrepareType(orderId) ? false : true;
	}

	/**
	 * cms、sw备货
	 * @param orderId
	 * @return
	 */
	private boolean clacOrderPrepareType(int orderId) {
		// 判断订单是否要变成非cms备货
		List<OrderPrepareProductPO> pos = getCMSPrepareProduct(orderId);
		if (CollectionUtils.isNotEmpty(pos))
			return true;
		return false;
	}

	/**
	 * 获取cms、sw备货
	 * @param orderId
	 * @return
	 */
	private List<OrderPrepareProductPO> getCMSPrepareProduct(int orderId) {
		String sql = " SELECT * FROM dbo.order_prepare_product tmp  WHERE  "
				+ " is_deleted=0 AND tmp.order_id=? AND tmp.cms_prepare<>0 AND tmp.status<12";
		List<Object> params = new ArrayList<Object>();
		params.add(orderId);
		List<OrderPrepareProductPO> pos = orderPrepareProductDao.findListBySql(sql, params);
		return pos;
	}

	protected boolean hasNotCMSPrepareProduct(int orderId) {
		String sql = " SELECT * FROM dbo.order_prepare_product tmp  WHERE  "
				+ " is_deleted=0 AND tmp.order_id=? AND tmp.cms_prepare=0 AND tmp.status<12";
		List<Object> params = new ArrayList<Object>();
		params.add(orderId);
		List<OrderPrepareProductPO> pos = orderPrepareProductDao.findListBySql(sql, params);
		if (CollectionUtils.isNotEmpty(pos))
			return true;
		return false;
	}

	private List<OrderPrepareProductPO> getNotCMSPrepareProduct(int orderId) {
		String sql = " SELECT * FROM dbo.order_prepare_product tmp  WHERE  "
				+ " is_deleted=0 AND tmp.order_id=? AND tmp.cms_prepare=0 AND tmp.status<12";
		List<Object> params = new ArrayList<Object>();
		params.add(orderId);
		return orderPrepareProductDao.findListBySql(sql, params);
	}
	
	private List<OrderPrepareProductPO> getPrepareProduct(int orderId){
		String hql="from OrderPrepareProductPO where status<12 and orderId=? and deleted=false";
		return orderPrepareProductDao.findListByHql(hql, orderId);
	}

	@Override
	public void quickShip(int orderId, String traceCode, double deliveryCost, Date deliveryDate, Double costPrice,
			String operator) {
		OrderPO order = orderDao.getObject(orderId);
		if (order != null && order.getCmsPrepare()==ORDER_PREPARE_TYPE_OTHER) {
			order.setTrackingCode(traceCode);
			
			if (order.getDeliveryDate() == null) {
			
				deliveryDate = deliveryDateCondition(deliveryDate, order);
				
				order.setDeliveryDate(deliveryDate);
			}
			if (costPrice != null) {
				order.setCostPrice(costPrice);
			}
			order.setStatus(OrderStatus.已发货.getVal());
			order.setCostFreight(deliveryCost);
			orderDao.mergeObject(order);

			// 添加自动发货任务
			delivering2WS3rdProxy(orderId);
			// 操作记录
			addOrderOperateLog("非C3备货订单快速发货,物流跟踪号" + (traceCode == null ? "为空" : "：" + traceCode), operator, orderId);
		}
	}


	/**
	 * 发货时间判断
	 * @param deliveryDate
	 * @param order
	 * @return
	 */
	private Date deliveryDateCondition(Date deliveryDate, OrderPO order) {
		Date date = new Date();
		if(deliveryDate.equals(DateUtils.getRealDate(date))){
			deliveryDate=date; //当前时间发货
		}else{//其他时间发货
			if(deliveryDate.after(date))
				throw new BussinessException("发货时间大于当前时间");
			ShopInfo info= systemService.getCacheShopInfo(order.getShopId());
			
			Date add=org.apache.commons.lang.time.DateUtils.addHours(order.getShopOrderDate(), -info.getTimeDiff());
			if(!add.before(deliveryDate)){//下单时间之前
				if(deliveryDate.equals(DateUtils.getRealDate(add)))//与下单时间同一天
					deliveryDate=org.apache.commons.lang.time.DateUtils.addHours(add, 1);
				else	
					throw new BussinessException("发货时间早于客户下单时间");
			}
		}
		return deliveryDate;
	}

	private boolean addAutoOrderDeliveryTaskBatch(List<OrderPO> orderPOList) {
		// 将订单按店铺进行分组
		Map<Integer, List<Integer>> orderMap = new HashMap<Integer, List<Integer>>();
		List<Integer> orderIdList = null;
		for (int i = 0; i < orderPOList.size(); i++) {
			OrderPO orderPO = orderPOList.get(i);
			orderIdList = orderMap.get(orderPO.getShopId());
			if (null == orderIdList) {
				orderIdList = new ArrayList<Integer>();
				orderMap.put(orderPO.getShopId(), orderIdList);
			}
			orderIdList.add(orderPO.getId());
		}

		// 将每个店铺按最大发货条数分组
		Integer max_size = Integer.valueOf(AMAZON_DELIVERY_SIZE);
		List<OrderDeliveryTaskPO> orderTaskList = new ArrayList<OrderDeliveryTaskPO>();
		if (null != orderMap && orderMap.size() > 0) {
			Set<Integer> keySet = orderMap.keySet();
			if (null != keySet && keySet.size() > 0) {
				Iterator<Integer> orderIdIterator = (Iterator<Integer>) keySet.iterator();
				while (orderIdIterator.hasNext()) {
					Integer shopId = (Integer) orderIdIterator.next();// 遍历本次的店铺
					orderIdList = orderMap.get(shopId);
					if (null != orderIdList && orderIdList.size() > 0) {
						StringBuilder sb = new StringBuilder("");
						for (int i = 0; i < orderIdList.size(); i++) {
							if (i % max_size == 0) {
								sb = new StringBuilder("");
							} else {
								sb.append(COMMA_SPLIT);
							}
							sb.append(orderIdList.get(i).toString());

							if (i % max_size == max_size - 1 || i == orderIdList.size() - 1) {
								OrderDeliveryTaskPO po = new OrderDeliveryTaskPO();
								po.setStatus(0);
								po.setOrderId(sb.toString());
								po.setCreateTime(new Date());
								po.setShopId(shopId);
								po.setShopType(ShopType.AMAZON.getVal());
								orderTaskList.add(po);
							}
						}
					}
				}
			}
		}

		orderDeliveryTaskDao.addObject(orderTaskList);

		return true;
	}

	public void beforeShip(int orderId, String traceCode, Date deliveryDate, String operator) {
		OrderPO order = orderDao.getObject(orderId);
		if (order != null && isCommuication2Other(order)) {
			order.setTrackingCode(traceCode);
			if (order.getDeliveryDate() == null) {
				deliveryDate = deliveryDateCondition(deliveryDate, order);
				
				order.setDeliveryDate(deliveryDate);
			}
			orderDao.mergeObject(order);

			delivering2WS3rdProxy(orderId);

			// 操作记录
			ShippingMethod sp = systemService.getShippingMethod(order.getShippingMethod());
			addOrderOperateLog("C3备货订单假发货,货运方式为" + (sp == null ? "" : sp.getName()) + ",物流跟踪号"
					+ (traceCode == null ? "为空" : "：" + traceCode), operator, orderId);
		}
	}

	@Override
	public void resendOrder(int orderId, int operator) throws BussinessException {
		OrderPO po = orderDao.getObject(orderId);
		// "重发待确认"=false,status=C3备货的订单+已出库状态可+已发货订单
		if (po.getCmsPrepare()!=ORDER_PREPARE_TYPE_CMS) {
			throw new BussinessException("订单非cms备货，无法操作！");
		}
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
			List<OrderPO> group = new ArrayList<OrderPO>();
			if (po.getSendGroupId() != null) {
				group = this.getOrderByTicketGroup(po.getSendGroupId());
			} else {
				group.add(po);
			}

			StringBuilder orderCodes = new StringBuilder();
			for (OrderPO orderPO : group) {
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
	 * 取消订单，如果有非cms备货商品，则发送邮件给跟单员
	 * 
	 * @param po
	 */
	protected void cancelNotCMSPrepareProduct2email(OrderPO po) {
		List<OrderPrepareProductPO> pos = getNotCMSPrepareProduct(po.getId());
		if (CollectionUtils.isNotEmpty(pos)) {
			StringBuilder product = new StringBuilder();
			for (OrderPrepareProductPO orderPrepareProductPO : pos) {
				product.append(orderPrepareProductPO.getCmsProductCode() + "、");
			}
			StringBuilder content = new StringBuilder();
			content.append("订单").append(po.getCode()).append("已取消，其中包含了非c3备货商品").append(product)
					.append(",请联系相关业务人员停止备货");

			sendEmail2Customerservices(po.getMerchandiserId(), "订单" + po.getCode() + "已取消", content.toString());
		}
	}



	public void confirmPackage(int orderId, String operator) throws BussinessException {
		OrderPO po = orderDao.getObject(orderId);
		if (po != null && po.getPackageStatus() != null
				&& po.getPackageStatus().ordinal() < PackageTraceStatus.CONFIRM.ordinal()) {
			po.setPackageStatus(PackageTraceStatus.CONFIRM);
			addOrderOperateLog("确认包裹", operator, po.getId());
			// 通讯dms
			ShopInfo shop = systemService.getShopInfo(po.getShopId());
			DMSClient.confirmPackage(po.getCode(), DMSUtils.getAccountSetting(shop.getShopSource().intValue()));
			// 关闭问题
			PackageProblem pp = packageProblemService.getPackageProblemByOrder(orderId);
			if (pp != null) {
				if (pp.getType() != PackageProblemType.问题件.getVal())
					throw new BussinessException("只有普通问题件可操作!");
				packageProblemService.closePackageProblem(pp.getId(), operator);
			}
			return;
		}
		throw new BussinessException("无法操作！");
	}

	@Override
	public void putway(int orderId, String operator) {
		OrderPO po = orderDao.getObject(orderId);
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
		OrderPO po = orderDao.getObject(orderId);
		if (po != null) {
			po.setAwaitPutaway(true);
			addOrderOperateLog("DMS上架", operator, po.getId());
		}
	}




    @Override
	public OrderAddress processOrderAddressSpecial(OrderDetail detail, OrderAddress orderAddress,ShopInfo shopInfo) {
		//订单货运信息中，电话号码为空的，自动填充000-0000-0000   sp 1.2.2
		if(StringUtils.isEmpty(orderAddress.getPhone()))
			orderAddress.setPhone("000-0000-0000");
		
//			if (StringUtils.isEmpty(orderAddress.getAddressLine1())) {
//				orderAddress.setAddressLine1(StringUtils.isEmpty(orderAddress.getAddressLine2())
//						?order.getShippingAddress().getAddressLine3():orderAddress.getAddressLine2());
//			}
		
		//2017-12-04 领导要求
		if(StringUtils.isEmpty(orderAddress.getAddressLine1())){
			orderAddress.setAddressLine1(orderAddress.getAddressLine2());
			orderAddress.setAddressLine2(null);
		}
		
		//当城市为空时，自动截取地址中的前三个字符，地址1>地址2 sp 1.1.5.2
		if (StringUtils.isEmpty(orderAddress.getCity())) {
			String line=StringUtils.isEmpty(orderAddress.getAddressLine1())?
					orderAddress.getAddressLine2():orderAddress.getAddressLine1();
			if (StringUtils.isNotEmpty(line)) {
				orderAddress.setCity(line.substring(0,line.length()>3?3:line.length()));
			}
		}
		
		Country country = systemService.getCountryByCode(orderAddress.getCountryCode());
		if (country != null) {
			detail.setCountry(country.getId());
			orderAddress.setCountryId(country.getId());
			
			//法国邮编转省 v1.1.6
			if(country.getId()==FRANCE&&StringUtils.isEmpty(orderAddress.getStateOrRegion())){
				orderAddress.setStateOrRegion(systemService.getFranceRegionByPostcode(orderAddress.getPostalCode()));
			}
		}
		
		//2017-12-12 省为空时自动将城市填充到省中
		if(shopInfo.isFillState()){
			orderAddress.setStateOrRegion(orderAddress.getCity());
		}
		return orderAddress;
	}
	
	@Override
	public BaseOrderItem getOrderItem(int orderId, int cmsProductId) {
		String sql="SELECT TOP 1 * FROM dbo.order_prepare_product WHERE order_id=? AND cms_product_id=? ORDER BY id DESC";
		List<Object> params=new ArrayList<Object>();
		params.add(orderId);
		params.add(cmsProductId);
		List<OrderPrepareProductPO> pos=orderPrepareProductDao.findListBySql(sql, params);
		if(CollectionUtils.isNotEmpty(pos))
			return BeanUtils.copyProperties(pos.get(0), BaseOrderItem.class);
		return null;
	}
}