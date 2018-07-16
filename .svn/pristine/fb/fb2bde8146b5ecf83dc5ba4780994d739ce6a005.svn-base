package com.itecheasy.core.order;

import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;

/** 
 * @author wanghw
 * @date 2016-1-11 
 * @description 订单报表服务
 * @version
 */
public interface OrderReportService {
	
	/**
	 * 导入订单实收款数据
	 * @param report
	 * @throws BussinessException
	 */
 	String addOrderPayments(List<OrderPaymentReport> report,int shopId)throws BussinessException;
	
 	/**
 	 * 查询订单实收款数据
 	 * @param form
 	 * @return
 	 */
 	PageList<OrderPaymentReport> findOrderPayments(OrderReportSearchForm form);
	
	/**
	 * 订单统计报表查询
	 * @param form
	 * @return
	 */
	public List<OrderCountReport> findOrderCountReport(OrderReportSearchForm form);
	
	
	public List<OrderCountReport> findOrderCountReport2(OrderReportSearchForm form);
	/**
	 * 非FBA商品毛利月度统计
	 * @param from
	 * @return
	 */
	CountOrderProfitVO countOrderProfit(OrderReportSearchForm from)throws BussinessException;

	/**
	 * 订单实收款类型
	 * @return
	 */
	List<OrderPaymentDataType> getOrderPaymentDataTypes();
	
	/**
	 * 非FBA订单金额统计
	 * @param form
	 * @return
	 * @throws BussinessException
	 */
	public List<OrderCountReport> countOrderAmount(OrderReportSearchForm form) throws BussinessException;
	
	/**
	 * FBA订单金额统计
	 * @param form
	 * @return
	 */
	CountOrderProfitVO countFBAOrderAmount(OrderReportSearchForm form) throws BussinessException ;	
	
	/**
	 * 所有订单金额毛利统计(包含非FBA和FBA订单)
	 * @param form
	 * @return
	 */
	CountOrderProfitVO countAllOrderProfitByDay(OrderReportSearchForm form)throws BussinessException;
	
}
