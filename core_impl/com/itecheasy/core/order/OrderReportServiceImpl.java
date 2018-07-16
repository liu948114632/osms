package com.itecheasy.core.order;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.LockMode;

import com.itecheasy.common.PageList;
import com.itecheasy.common.Param;
import com.itecheasy.common.dao.Criteria;
import com.itecheasy.common.dao.Restriction;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.CurrencyUtils;
import com.itecheasy.core.order.dao.OrderCountReportDao;
import com.itecheasy.core.order.dao.OrderPaymentDataTypeDao;
import com.itecheasy.core.order.dao.OrderPaymentReportDao;
import com.itecheasy.core.po.OrderPaymentDataTypePO;
import com.itecheasy.core.po.OrderPaymentReportPO;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.util.SystemEnumDicts.ShopType;
/**
 * @author wanghw
 * @date 2016-1-14
 * @description 订单报表服务
 * @version
 */
public class OrderReportServiceImpl implements OrderReportService {
	protected static final String VERSION_DATE_FORMAT = "yyyy-MM-dd";
	private OrderPaymentDataTypeDao orderPaymentDataTypeDao;
	private OrderPaymentReportDao orderPaymentReportDao;
	private OrderCountReportDao orderCountReportDao;
	private SystemService systemService;
	private OrderService orderService;
	private FBAStoreOrderService fbaStoreOrderService;
	

	public void setFbaStoreOrderService(FBAStoreOrderService fbaStoreOrderService) {
		this.fbaStoreOrderService = fbaStoreOrderService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setOrderCountReportDao(OrderCountReportDao orderCountReportDao) {
		this.orderCountReportDao = orderCountReportDao;
	}

	public void setOrderPaymentDataTypeDao(OrderPaymentDataTypeDao orderPaymentDataTypeDao) {
		this.orderPaymentDataTypeDao = orderPaymentDataTypeDao;
	}

	public void setOrderPaymentReportDao(OrderPaymentReportDao orderPaymentReportDao) {
		this.orderPaymentReportDao = orderPaymentReportDao;
	}

	@Override
	public String addOrderPayments(List<OrderPaymentReport> reports, int shopId) throws BussinessException {
		List<Date> reportDates = new ArrayList<Date>();
		if (CollectionUtils.isEmpty(reports))
			return null;
		// 忽略本次重复添加
		List<Integer> ids = new ArrayList<Integer>();
		List<String> orderCodes = new ArrayList<String>();
		List<String> repeat = new ArrayList<String>();
		Shop shop = systemService.getShop(shopId);
		if (shop.getCurrency() == 0) {
			throw new BussinessException("数据库没有币种,请联系管理员" + shopId);
		}
		int currency = shop.getCurrency();
		for (OrderPaymentReport report : reports) {
			// 判断重复
			OrderPaymentReportPO exist = getOrderPaymentReportPO(report, shopId);
			if (exist != null && !ids.contains(exist.getId())) {
				if (StringUtils.isNotEmpty(report.getShopOrderCode())) {
					repeat.add(report.getShopOrderCode());
				}
				continue;
			}

			// 类型判断
			if (!existOrderPaymentDataType(report.getTransactionType(), report.getPaymentDetail(),
					report.getPaymentType())) {
				if (StringUtils.isNotEmpty(report.getShopOrderCode())) {
					orderCodes.add(report.getShopOrderCode());
				}
				continue;
			}

			Order order = orderService.getOrderByShopOrderCode(report.getShopOrderCode(), ShopType.AMAZON.getVal(),shopId);
			if (order != null) {
				report.setOrderId(order.getId());
				reportDates.add(order.getShopOrderDate());

			}

			OrderPaymentReportPO po = BeanUtils.copyProperties(report, OrderPaymentReportPO.class,
					new String[] { "id" });
			po.setShopId(shopId);
			po.setCurrency(currency);
			ids.add(orderPaymentReportDao.addObject(po));

		}

		StringBuilder result = new StringBuilder();
		if (orderCodes.size() > 0) {
			result.append(MessageFormat.format("订单{0}的费用组合不存在，请核实后再导入！\r\n", orderCodes.toString()));
		}

		if (repeat.size() > 0) {
			result.append(MessageFormat.format("订单{0}的数据存在，已忽略！", repeat.toString()));
		}

		return result.length() > 0 ? result.toString() : null;
	}

	private OrderPaymentReportPO getOrderPaymentReportPO(OrderPaymentReport report, int shopId) {
		Criteria criteria = new Criteria(OrderPaymentReportPO.class);
		criteria.and(Restriction.eq("reportDate", report.getReportDate()));
		criteria.and(Restriction.eq("shopOrderCode", report.getShopOrderCode()));
		criteria.and(Restriction.eq("reportDate", report.getReportDate()));
		criteria.and(Restriction.eq("transactionType", report.getTransactionType()));
		criteria.and(Restriction.eq("sku", report.getSku()));
		criteria.and(Restriction.eq("paymentDetail", report.getPaymentDetail()));
		criteria.and(Restriction.eq("amount", report.getAmount()));
		criteria.and(Restriction.eq("paymentType", report.getPaymentType()));
		criteria.and(Restriction.eq("quantity", report.getQuantity()));
		criteria.and(Restriction.eq("productTitle", report.getProductTitle()));
		criteria.and(Restriction.eq("shopId", shopId));

		return orderPaymentReportDao.get(criteria);
	}

	private boolean existOrderPaymentDataType(String transactionType, String paymentDetail, String paymentType) {
		String hql = " from OrderPaymentDataTypePO s where transactionType=? and paymentDetail=? "
				+ " and paymentType=?";
		OrderPaymentDataTypePO po = orderPaymentDataTypeDao.findByHql(hql, "s", new Object[] {
				transactionType == null ? "" : transactionType, paymentDetail == null ? "" : paymentDetail,
				paymentType == null ? "" : paymentType,

		}, LockMode.NONE);
		if (po != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<OrderPaymentDataType> getOrderPaymentDataTypes() {
		List<OrderPaymentDataTypePO> pos = orderPaymentDataTypeDao.getAll();
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyList(pos, OrderPaymentDataType.class);
		}
		return null;
	}

	@Override
	public PageList<OrderPaymentReport> findOrderPayments(OrderReportSearchForm form) {
		String sql = " SELECT * FROM dbo.order_payment_report ";
		StringBuilder where = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		if (form.getBegin() != null) {
			where.append("   AND report_date>=? ");
			params.add(DateUtils.getRealDate(form.getBegin()));
		}
		if (form.getEnd() != null) {
			where.append("   AND report_date<=? ");
			params.add(DateUtils.getFullDate(form.getEnd()));
		}
		if (CollectionUtils.isNotEmpty(form.getShopId())) {
			where.append("   AND shop_id IN ( ");
			String ids = form.getShopId().toString();
			where.append(ids.substring(1, ids.length() - 1)).append(") ");
		}
		PageList<OrderPaymentReportPO> pos = orderPaymentReportDao.findPageListBySql(form.getCurrentPage(),
				form.getPageSize(), sql.toString(), where.toString(), " report_date desc,shop_order_code asc ", params);

		if (pos != null) {
			return BeanUtils.copyPageList(pos, OrderPaymentReport.class);
		}
		return null;
	}
	
	@Override
	public List<OrderCountReport> findOrderCountReport2(OrderReportSearchForm form) {
		List<Param> params = new ArrayList<Param>();
		if (form.getBegin() != null) {
			params.add(new Param("begin", DateUtils.getRealDate(form.getBegin())));
		}
		if (form.getEnd() != null) {
			params.add(new Param("end", DateUtils.getFullDate(form.getEnd())));
		}
		params.add(new Param("type", form.getType()));
		if (CollectionUtils.isNotEmpty(form.getShopId())) {
			String ids = form.getShopId().toString();
			params.add(new Param("shopId", ids.substring(1, ids.length() - 1)));
		}
		if(StringUtils.isNotEmpty(form.getProductCode())){
			params.add(new Param("productCode", form.getProductCode()));
		}
		
		return findOrderCountReport$processResult(orderCountReportDao.findListByStoredProcedure(
				"proc_order_count_report2", params, OrderCountReport.class), form.getBegin(), form.getEnd(),
				form.getShopId());
	}

	public List<OrderCountReport> findOrderCountReport(OrderReportSearchForm form) {

		List<Param> params = new ArrayList<Param>();
		if (form.getBegin() != null) {
			params.add(new Param("begin", DateUtils.getRealDate(form.getBegin())));
		}
		if (form.getEnd() != null) {
			params.add(new Param("end", DateUtils.getFullDate(form.getEnd())));
		}
		params.add(new Param("type", form.getType()));
		if (CollectionUtils.isNotEmpty(form.getShopId())) {
			String ids = form.getShopId().toString();
			params.add(new Param("shopId", ids.substring(1, ids.length() - 1)));
		}
		return findOrderCountReport$processResult(orderCountReportDao.findListByStoredProcedure(
				"proc_order_count_report", params, OrderCountReport.class), form.getBegin(), form.getEnd(),
				form.getShopId());
	}

	public static void main(String[] args) {
		Date end = DateUtils.getRealDate(new Date());
		Date begin = DateUtils.convertDate("2015-12-12", VERSION_DATE_FORMAT);
		for (Date i = begin; i.before(end) || i.equals(end); i = org.apache.commons.lang.time.DateUtils.addDays(i, 1)) {
			System.out.println(DateUtils.convertDate(i));
		}
	}

	private List<OrderCountReport> findOrderCountReport$processResult(List<OrderCountReport> olds, Date begin,
			Date end, List<Integer> shops) {
		List<OrderCountReport> result = new ArrayList<OrderCountReport>();
		if (CollectionUtils.isEmpty(olds)) {
			if (begin == null) {
				begin = DateUtils.getRealDate(new Date());
			}
			if (end == null) {
				end = begin;
			}

		} else {
			if (begin == null) {
				begin = DateUtils.getRealDate(DateUtils.convertDate(olds.get(olds.size() - 1).getReportDate(),
						VERSION_DATE_FORMAT));
			}
			if (end == null) {
				end = DateUtils.getRealDate(new Date());
			}
		}
		OrderCountReport report = null;

		for (Date i = end; i.after(begin) || i.equals(begin); i = org.apache.commons.lang.time.DateUtils.addDays(i, -1)) {
			String reportDate = DateUtils.convertDate(i);
			for (Integer shop : shops) {
				report = new OrderCountReport(shop, reportDate);
				for (OrderCountReport _old : olds) {
					if (_old.getShopId() == shop && _old.getReportDate().equals(reportDate)) {
						report = _old;
						break;
					}
				}
				result.add(report);
			}
		}

		return result;

	}

	@Override
	public CountOrderProfitVO countOrderProfit(OrderReportSearchForm form) throws BussinessException {
		CountOrderProfitVO vo = new CountOrderProfitVO();
		StringBuilder sql = new StringBuilder();
		StringBuilder where = new StringBuilder();
		String version = null;
		String group = " GROUP BY o.shop_id ";
		String select = " SELECT o.shop_id AS shopId,SUM(p.amount) AS paymentAmount, "
				+ " SUM(o.cost_price) AS costPrice,SUM(o.cost_freight) AS costFreight, "
				+ " SUM(o.order_amount) AS orderAmount, MIN(currency) AS currency "
				+ " FROM dbo.v_order_payment_report_total p	"
				+ " INNER JOIN dbo.[order] o ON o.shop_order_code=p.shop_order_code AND p.shop_id=o.shop_id "
				+ " WHERE o.shop_type=1 and fulfillmentChannel='MFN' AND cost_freight>0 AND cost_price>0 AND o.status<132 " + "";
		sql.append(select);
		List<Object> params = new ArrayList<Object>();
		if (form.getBegin() != null) {
			where.append("   AND shop_order_date>=? ");
			params.add(DateUtils.convertDate(DateUtils.getFullDate(form.getBegin()), "yyyy-MM-dd HH:mm:ss"));
			version = DateUtils.convertDate(form.getBegin(), "yyyyMM");
		} else {
			throw new BussinessException("时间为空");
		}
		if (form.getEnd() != null) {
			where.append("   AND shop_order_date<=? ");
			params.add(DateUtils.convertDate(DateUtils.getRealDate(form.getEnd()), "yyyy-MM-dd HH:mm:ss"));
		}
		if (CollectionUtils.isNotEmpty(form.getShopId())) {
			where.append("   AND o.shop_id IN ( ");
			String ids = form.getShopId().toString();
			where.append(ids.substring(1, ids.length() - 1)).append(") ");
		}
		sql.append(where).append(group);
		List<OrderProfitReport> orderProfitReports = orderCountReportDao.findListBySql(sql.toString(), params,
				OrderProfitReport.class);
		// 计算毛利
		if (CollectionUtils.isNotEmpty(orderProfitReports)) {
			for (OrderProfitReport orderProfitReport : orderProfitReports) {
				BigDecimal PaymentAmount = systemService.exchangeCurrency2Other(orderProfitReport.getCurrency(),
						orderProfitReport.getPaymentAmount(), CurrencyUtils.RMB, version);
				// 毛利=实收款-商品成本-运费成本
				orderProfitReport.setProfit(PaymentAmount.subtract(orderProfitReport.getCostFreight()).subtract(
						orderProfitReport.getCostPrice()));

				// 毛利率=毛利/订单总金额
				BigDecimal orderAmount = systemService.exchangeCurrency2Other(orderProfitReport.getCurrency(),
						orderProfitReport.getOrderAmount(), CurrencyUtils.RMB, version);
				orderProfitReport.setProfitPercent(orderProfitReport.getProfit()
				// .multiply(BigDecimal.valueOf(100))
						.divide(orderAmount, 6, 4).doubleValue());
			}
		}

		vo.setOrderProfitReports(orderProfitReports);

		// 消息统计
		List<OrderProfitReportMessage> orderProfitReportMessages = countOrderProfitMessage(where, params);

		vo.setMessages(orderProfitReportMessages);
		return vo;
	}

	private List<OrderProfitReportMessage> countOrderProfitMessage(StringBuilder where,
			List<Object> params) {
		StringBuilder msg = new StringBuilder();
		msg.append(" SELECT o.shop_id AS shopId,s.name AS shopName,o.shop_order_code AS shopOrderCode "
				+ " FROM dbo.[order] o" + " INNER JOIN dbo.order_payment_report p "
				+ " ON o.shop_order_code=p.shop_order_code AND p.shop_id=o.shop_id"
				+ " INNER JOIN dbo.shop s ON s.id=o.shop_id" + " WHERE o.shop_type=1 and fulfillmentChannel='MFN' "
				+ " AND (cost_freight=0 OR cost_freight IS NULL "
				+ " or cost_price=0 OR cost_price IS NULL) AND o.status<132");
		msg.append(where);
		List<OrderProfitReportMessage> orderProfitReportMessages = orderCountReportDao.findListBySql(msg.toString(),
				params, OrderProfitReportMessage.class);
		return orderProfitReportMessages;
	}

	@Override
	public List<OrderCountReport> countOrderAmount(OrderReportSearchForm form) throws BussinessException {
		form.setType(ReportType.非FBA订单总金额统计.getVal());
		List<OrderCountReport> orderAmouts = findOrderCountReport(form);
		String version = DateUtils.convertDate(form.getBegin(), "yyyyMM");
		for (int i = 0; i < orderAmouts.size(); i++) {
			BigDecimal fbaAmount = systemService.exchangeCurrency2Other(
					orderAmouts.get(i).getCurrency()
					, orderAmouts
					.get(i).getOrderTotalAmount(), CurrencyUtils.RMB, version);

			orderAmouts.get(i).setOrderTotalAmount(fbaAmount);
		}

		return orderAmouts;
	}
	
	@Override
	public CountOrderProfitVO countFBAOrderAmount(OrderReportSearchForm form) throws BussinessException {
		String version = DateUtils.convertDate(form.getBegin(), "yyyyMM");
		
		//3-1、fba订单金额统计
		form.setType(ReportType.FBA订单总金额统计.getVal());
		List<OrderCountReport> fbaOrderAmouts= findOrderCountReport(form);
		//3-2 fba实际收款
		form.setType(ReportType.FBA商品实际收款统计.getVal());
		List<OrderCountReport> fbapaymentAmount= findOrderCountReport(form);
		
		//3-2、fba订单头程统计
//		form.setType(ReportType.FBA头程运费统计.getVal());
//		List<OrderCountReport> firstWays= findOrderCountReport(form);
		BigDecimal firstWayOfUnit=new BigDecimal(0);
		
		FirstWayFreightSetting firstWayFreightSetting=fbaStoreOrderService.getFirstWayFreightSetting(version, 
				systemService.getShop(form.getShopId().get(0)).getFirstWayCountry());
		if(firstWayFreightSetting!=null){
			firstWayOfUnit=firstWayFreightSetting.getFreightOfUnit();
		}
		
		CountOrderProfitVO vo=new CountOrderProfitVO();
		BigDecimal _total_pay=new BigDecimal(0);
		BigDecimal _total_profit=new BigDecimal(0);
		for (int i = 0; i < fbaOrderAmouts.size(); i++) {
			
			//fba订单金额
			OrderCountReport fbaAmout=fbaOrderAmouts.get(i);
			BigDecimal fbaAmount = systemService.exchangeCurrency2Other(
					fbaOrderAmouts.get(i).getCurrency(),
					fbaAmout.getOrderTotalAmount(), CurrencyUtils.RMB, version);
			
			//fba实际收款
			OrderCountReport fbaPay=fbapaymentAmount.get(i);
			BigDecimal fbaPayAmount = systemService.exchangeCurrency2Other(
					fbaPay.getCurrency(),
					fbaPay.getFBAPaymentTotalAmount(), CurrencyUtils.RMB, version);
			
			//fba头程运费
//			OrderCountReport firstWay=firstWays.get(i);
			 
			//fba订单毛利=fba订单实收款 - 商品成本 – fba商品头程运费
//			fbaPay.setProfit(fbaPayAmount.subtract(fbaPay.getCostPrice()).subtract(
//					firstWay.getFirstWayFreight()));
			fbaPay.setProfit(fbaPayAmount.subtract(fbaPay.getCostPrice()).subtract(
					new BigDecimal(fbaPay.getTotalUnit()).multiply(firstWayOfUnit)));
			
			//总实际收款
			_total_pay=fbaPayAmount.add(_total_pay);
			
			fbaOrderAmouts.get(i).setOrderTotalAmount(fbaAmount);
			_total_profit=fbaPay.getProfit().add(_total_profit);
		}
		
		vo.setCountReports(fbaOrderAmouts);
		if(_total_pay.compareTo(new BigDecimal(0))>0){
			vo.setProfitPercent(_total_profit.divide(_total_pay,2,4));
		}
		return vo;
	}

	@Override
	public CountOrderProfitVO countAllOrderProfitByDay(OrderReportSearchForm form) throws BussinessException {
		//1、所有订单金额统计
		form.setType(ReportType.所有订单总金额统计.getVal());
		List<OrderCountReport> orderAmountReports=findOrderCountReport(form);
		
		//2、非FBA实际收款统计
		form.setType(ReportType.非FBA实际收款统计.getVal());
		List<OrderCountReport> orderPays=findOrderCountReport(form);
		String version = DateUtils.convertDate(form.getBegin(), "yyyyMM");
		
		
		//3、fba订单毛利
		//3-2 fba实际收款
		form.setType(ReportType.FBA商品实际收款统计.getVal());
		List<OrderCountReport> fbapaymentAmount= findOrderCountReport(form);
		
		//3-3、fba订单头程统计
		BigDecimal firstWayOfUnit=new BigDecimal(0);
//		form.setType(ReportType.FBA头程运费统计.getVal());
//		List<OrderCountReport> firstWays= findOrderCountReport(form);
		
		FirstWayFreightSetting firstWayFreightSetting=fbaStoreOrderService.getFirstWayFreightSetting(version, 
				systemService.getShop(form.getShopId().get(0)).getFirstWayCountry());
		if(firstWayFreightSetting!=null){
			firstWayOfUnit=firstWayFreightSetting.getFreightOfUnit();
		}
		
		CountOrderProfitVO vo=new CountOrderProfitVO();
		BigDecimal _total_pay=new BigDecimal(0);
		BigDecimal _total_profit=new BigDecimal(0);
		List<OrderProfitReport> result=new ArrayList<OrderProfitReport>();
		for (int i = 0; i < orderAmountReports.size(); i++) {
			OrderProfitReport report=new OrderProfitReport();
			
			//非fba订单毛利
			OrderCountReport orderPay=orderPays.get(i);
			BigDecimal orderPayAmount = systemService.exchangeCurrency2Other(orderPay.getCurrency(),
					orderPay.getPaymentAmount(), CurrencyUtils.RMB, version);
			
			// 非fba订单毛利=实收款-商品成本-运费成本
			orderPay.setProfit(orderPayAmount.subtract(orderPay.getCostFreight()).subtract(
					orderPay.getCostPrice()));
			
			//fba实际收款
			OrderCountReport fbaPay=fbapaymentAmount.get(i);
			BigDecimal fbaPayAmount = systemService.exchangeCurrency2Other(
					fbaPay.getCurrency(),
					fbaPay.getFBAPaymentTotalAmount(), CurrencyUtils.RMB, version);
			
			//fba头程运费
//			OrderCountReport firstWay=firstWays.get(i);
			
			
			//fba订单毛利=fba订单实收款 - 商品成本 – fba商品头程运费
//			fbaPay.setProfit(fbaPayAmount.subtract(fbaPay.getCostPrice()).subtract(
//					firstWay.getFirstWayFreight()));
			fbaPay.setProfit(fbaPayAmount.subtract(fbaPay.getCostPrice()).subtract(
					new BigDecimal(fbaPay.getTotalUnit()).multiply(firstWayOfUnit)));
			
			
			//所有订单总金额
			report.setOrderAmount(systemService.exchangeCurrency2Other(
							orderAmountReports.get(i).getCurrency(),
							orderAmountReports.get(i).getOrderTotalAmount(), CurrencyUtils.RMB, version));
			
			//每天的总毛利=每天的普通订单毛利+每天的FBA订单毛利
			report.setProfit(fbaPay.getProfit().add(orderPay.getProfit()));
			report.setReportDate(fbaPay.getReportDate());
			result.add(report);
			
			//总收款
			_total_pay=orderPayAmount.add(_total_pay).add(fbaPayAmount);
			//总毛利
			_total_profit=fbaPay.getProfit().add(orderPay.getProfit()).add(_total_profit);
		}
		
		vo.setOrderProfitReports(result);
		if(_total_pay.compareTo(new BigDecimal(0))>0){
			vo.setProfitPercent(_total_profit.divide(_total_pay,2,4));
		}
		return vo;
	}
	

}
