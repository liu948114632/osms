package com.itecheasy.communication.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.StringUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.CurrencyUtils;
import com.itecheasy.core.fba.ReplenishmentOrderDetail;
import com.itecheasy.core.fba.ReplenishmentOrderItem;
import com.itecheasy.core.fba.Repository;
import com.itecheasy.core.fba.UpdateOrdertProductInfo;
import com.itecheasy.core.order.OrderAddress;
import com.itecheasy.core.order.OrderDetail;
import com.itecheasy.core.order.OrderPrepareProduct;
import com.itecheasy.core.po.OrderPrepareProductPO;
import com.itecheasy.core.po.OrderProductPO;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.user.User;
import com.itecheasy.core.util.DictUtils;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.webservice.client.DMSUtils;
import com.itecheasy.webservice.client.SwOrderClient;
import com.itecheasy.webservice.sw.BussinessException_Exception;
import com.itecheasy.webservice.sw.Country;
import com.itecheasy.webservice.sw.Delivery;
import com.itecheasy.webservice.sw.Operator;
import com.itecheasy.webservice.sw.Order;
import com.itecheasy.webservice.sw.OrderBillingAddress;
import com.itecheasy.webservice.sw.OrderProduct;
import com.itecheasy.webservice.sw.OrderShippingAddress;
import com.itecheasy.webservice.sw.OrderSourcePlatform;
import com.itecheasy.webservice.sw.PaymentStatus;

/** 
 * @author whw
 * @date 2017-8-2 
 * @description sw订单通讯
 * @version 
 */
public class Command2SW {
	private final static Logger LOGGER=Logger.getLogger(Command2SW.class);
	private static final String OSMS = "OSMS";

	public static void updateOrderAmont(String orderCode,int currency,double orderAmout,Double shippingPrice){
		SwOrderClient.updateOrderAmont(orderCode,
				DMSUtils.convert2USD(BigDecimal.valueOf(orderAmout)
				,currency ),
				DMSUtils.convert2USD(shippingPrice==null?BigDecimal.ZERO:BigDecimal.valueOf(shippingPrice)
						,currency));
	}
	
	public static boolean addOrder(OrderDetail detail, ShopInfo info ,boolean isAuto){
		OrderAddress orderAddress = detail.getOrderAddress();
		Order order=new Order();
		
		order.setCpfCode(detail.getCPFCode());
		order.setIsRemote(detail.getRemote());
		order.setPaymentStatus(PaymentStatus.NEED_NOT_PAYMENT);
		order.setPlatformOrderCode(detail.getCode());
		order.setOrderCode(detail.getCode());
		order.setOrderAmount(
				DMSUtils.convert2USD(
				BigDecimal.valueOf(detail.getOrderAmount())
				,detail.getOrderCurrency())
				);
		order.setPlaceOrderDate(DateUtils.getXMLGregorianCalendar(detail.getShopOrderDate()));
		order.setFreightAmount(
				DMSUtils.convert2USD(
				detail.getShopShippingPrice()==null?BigDecimal.ZERO:BigDecimal.valueOf(detail.getShopShippingPrice())
						,detail.getOrderCurrency())
						);
		order.setReimburseAmountRate(DMSUtils.getThreshold(detail.getOrderCurrency(), detail.getOrderAmount(),detail.getShippingMethod()));
		order.setFreightDiscount(BigDecimal.ZERO);
		order.setShippingMark(detail.getIsSend());
		order.setDeliveryExplanation(orderAddress.getRemark());//发货说明
		order.setOrderSourcePlatform(getSwOrderPlatformByShopType(detail.getShopType()));
		order.setSystemSourceCode(OSMS);
		order.setCustomerServiceRemark(detail.getRemark());
		order.setSignDate(DateUtils.getXMLGregorianCalendar(detail.getEarliestShippingDate()));//需求日期
		order.setExpectDate(DateUtils.getXMLGregorianCalendar(detail.getEarliestDeliveryDate()));//期望到货的日期
		Delivery delivery=new Delivery();
		delivery.setId(detail.getShippingMethod());
		order.setDelivery(delivery);
		
		OrderShippingAddress orderShippingAddress=new OrderShippingAddress();
		copyOrderAddress(orderShippingAddress, orderAddress);
//		if(detail.getCPFType()!=null&&detail.getCPFType().equals(1))
		orderShippingAddress.setVat(detail.getCPFCode());
		order.setShippingAddress(orderShippingAddress);
		
		OrderBillingAddress orderBillingAddress=new OrderBillingAddress();
		copyOrderBillingAddress(orderBillingAddress, orderAddress);
		order.setBillingAddress(orderBillingAddress);
		List<OrderProduct> orderProducts=new ArrayList<OrderProduct>();
		order.setOrderProducts(orderProducts);
		for (com.itecheasy.core.order.OrderProduct op : detail.getOrderItems()) {
			if(op.getOrderPrepareProduct().getStatus()!=com.itecheasy.core.order.OrderService.OrderProductStatus.取消.getVal()){
				OrderProduct swOp = copyOrderProduct(op,op.getOrderPrepareProduct());
				orderProducts.add(swOp);
			}
		}
		try {
			SwOrderClient.addOrder(order, detail.getCustomerAccount());
		} catch (Exception e) {
			if(isAuto){
				StaticUtils.addEmail("增加sw订单失败", detail.getCode()+ "sw系统对接失败,订单变成pending状态！\n"+e.getMessage());
				return false;
			}else{
				throw new BussinessException("sw系统对接失败:"+e.getMessage());
			}
		}
		return true;
	}
	
	public static void addROrder(ReplenishmentOrderDetail detail, ShopInfo info ,boolean isAuto){
		Repository orderAddress = detail.getRepository();
		Order order=new Order();
		
		order.setCpfCode(detail.getReplenishmentOrder().getCPFCode());
		order.setIsRemote(false);
		order.setPaymentStatus(PaymentStatus.NEED_NOT_PAYMENT);
		order.setPaymentStatus(PaymentStatus.NEED_NOT_PAYMENT);
		order.setPlatformOrderCode(detail.getReplenishmentOrder().getCode());
		order.setOrderCode(detail.getReplenishmentOrder().getCode());
		order.setOrderAmount(
				DMSUtils.convert2USD(
				BigDecimal.valueOf(detail.getReplenishmentOrder().getCostPrice()),CurrencyUtils.RMB)
				);
		order.setPlaceOrderDate(DateUtils.getXMLGregorianCalendar(detail.getReplenishmentOrder().getAddOrderDate()));
		order.setFreightAmount(BigDecimal.ZERO);
		order.setReimburseAmountRate(BigDecimal.valueOf(detail.getReplenishmentOrder().getSubTotalPercent()));
		order.setFreightDiscount(BigDecimal.ZERO);
		order.setShippingMark(detail.getReplenishmentOrder().getIsSend());
		order.setDeliveryExplanation(detail.getReplenishmentOrder().getDeliveryRemark());//发货说明
		order.setOrderSourcePlatform(OrderSourcePlatform.WH_FBA);
		order.setSystemSourceCode(OSMS);
		order.setCustomerServiceRemark(detail.getReplenishmentOrder().getRemark());
		order.setSignDate(DateUtils.getXMLGregorianCalendar(detail.getReplenishmentOrder().getEarliestShippingDate()));//需求日期
		order.setExpectDate(DateUtils.getXMLGregorianCalendar(detail.getReplenishmentOrder().getEarliestDeliveryDate()));//期望到货的日期
		Delivery delivery=new Delivery();
		delivery.setId(detail.getReplenishmentOrder().getShippingMethod());
		order.setDelivery(delivery);
		order.setShipmentID(detail.getReplenishmentOrder().getShipmentID());
		OrderShippingAddress orderShippingAddress=new OrderShippingAddress();
		copyROrderAddress(orderShippingAddress, orderAddress);
		orderShippingAddress.setVat(detail.getReplenishmentOrder().getCPFCode());
		order.setShippingAddress(orderShippingAddress);
		
		OrderBillingAddress orderBillingAddress=new OrderBillingAddress();
		copyROrderBillingAddress(orderBillingAddress, orderAddress);
		order.setBillingAddress(orderBillingAddress);
		List<OrderProduct> orderProducts=new ArrayList<OrderProduct>();
		order.setOrderProducts(orderProducts);
		for (ReplenishmentOrderItem op : detail.getReplenishmentOrderItems()) {
			if(op.getStatus()!=com.itecheasy.core.order.OrderService.OrderProductStatus.取消.getVal()){
				OrderProduct swOp = copyROrderProduct(op,info.getFbaBarcodeKey());
				orderProducts.add(swOp);
			}
		}
		try {
			SwOrderClient.addOrder(order, detail.getReplenishmentOrder().getCustomerName());
		} catch (Exception e) {
//			if(isAuto){
//				StaticUtils.addEmail("增加sw订单失败", detail.getCode()+ "sw系统对接失败,订单变成pending状态！\n"+e.getMessage());
//			}else{
				throw new BussinessException("sw系统对接失败:"+e.getMessage());
//			}
		}
//		return true;
	}
	
	public static void cancelOrder(String orderCode,User operatorUser){
		Operator operator = copyOperator(operatorUser);
		try {
			SwOrderClient.cancelOrder(orderCode, operator);
		} catch (BussinessException_Exception e) {
			LOGGER.error(e.toString());
		}
	}
	
	public static void updateShippingMethod(String orderCode,int shippintMethodId){
		Order order= SwOrderClient.getSwOrderByCode(orderCode);
		Delivery delivery=new Delivery();
		delivery.setId(shippintMethodId);
		order.setDelivery(delivery);
		try {
			SwOrderClient.updateDeliveryInfo(order);
		} catch (BussinessException_Exception e) {
			LOGGER.error(e.toString());
			throw new BussinessException(e.getMessage());
		}
	}
	
	public static void updateOrderAddress(String orderCode,OrderAddress oa,Integer CPFType,String CPFCode,Boolean isRemote) {
		Order order= SwOrderClient.getSwOrderByCode(orderCode);
		OrderShippingAddress orderShippingAddress=new OrderShippingAddress();
		copyOrderAddress(orderShippingAddress, oa);
//		if(CPFType!=null&&CPFType.equals(1))
		orderShippingAddress.setVat(CPFCode);
		order.setShippingAddress(orderShippingAddress);
		order.setCpfCode(CPFCode);
		order.setIsRemote(isRemote);
		try {
			SwOrderClient.updateDeliveryInfo(order);
		} catch (BussinessException_Exception e) {
			LOGGER.error(e.toString());
		}
	}
	
	public static void updateROrderAddress(String orderCode,Repository oa,Integer CPFType,String CPFCode,Boolean isRemote) {
		Order order= SwOrderClient.getSwOrderByCode(orderCode);
		OrderShippingAddress orderShippingAddress=new OrderShippingAddress();
		copyROrderAddress(orderShippingAddress, oa);
		order.setShippingAddress(orderShippingAddress);
//		if(CPFType!=null&&CPFType.equals(1))
		orderShippingAddress.setVat(CPFCode);
		order.setCpfCode(CPFCode);
		order.setIsRemote(isRemote);
		try {
			SwOrderClient.updateDeliveryInfo(order);
		} catch (BussinessException_Exception e) {
			LOGGER.error(e.toString());
		}
	}
	
	public static void updateSendMark(String orderCode,boolean sendMark){
		SwOrderClient.updateSendMark(orderCode, sendMark);
	}
	
	public static void cancelOrderItem(String orderCode,List<Integer> orderPrepareProductIds){
		try {
			SwOrderClient.cancelOrderItem(orderCode, orderPrepareProductIds);
		} catch (BussinessException_Exception e) {
			LOGGER.error(e.toString());
			throw new BussinessException(e.getMessage());
		}
	}
	
	public static void updateDemandQty(String orderCode, int orderPrepareProductId,double shopItemPrice,int shopItemCurType,
			int orderedQty){
		BigDecimal purchasePrice=
				DMSUtils.convert2USD(
						BigDecimal.valueOf(shopItemPrice).divide(BigDecimal.valueOf(orderedQty),3,4)
						,shopItemCurType);
		try {
			
			SwOrderClient.updateDemandQty(orderCode, orderPrepareProductId,purchasePrice, orderedQty);
		} catch (BussinessException_Exception e) {
			LOGGER.error(e.toString());
			throw new BussinessException(e.getMessage());
		}
	}
	
	public static void addOrderProduct(String orderCode,List<OrderPrepareProductPO> items,
			List<OrderProductPO> orderProducts){
		List<OrderProduct> ops=new ArrayList<OrderProduct>();
		for (int i = 0; i < items.size(); i++) {
			OrderPrepareProductPO opp=items.get(i);
			OrderProductPO op=orderProducts.get(i);
			ops.add(copyOrderProduct(BeanUtils.copyProperties(op, com.itecheasy.core.order.OrderProduct.class),
					BeanUtils.copyProperties(opp, OrderPrepareProduct.class)));
			
		}
		try {
			SwOrderClient.addOrderProduct(orderCode, ops);
		} catch (BussinessException_Exception e) {
			LOGGER.error(e.toString());
			throw new BussinessException(e.getMessage());
		}
	}
	
	
	public static void addROrderProduct(String orderCode,List<ReplenishmentOrderItem> items,String fbaBarKey){
		List<OrderProduct> ops=new ArrayList<OrderProduct>();
		for (int i = 0; i < items.size(); i++) {
			ReplenishmentOrderItem op=items.get(i);
			ops.add(copyROrderProduct(op,fbaBarKey));
		}
		try {
			SwOrderClient.addOrderProduct(orderCode, ops);
		} catch (BussinessException_Exception e) {
			LOGGER.error(e.toString());
			throw new BussinessException(e.getMessage());
		}
	}

	private static Operator copyOperator(User operatorUser) {
		if(operatorUser==null) return null;
		Operator operator=new Operator();
		operator.setCode(operatorUser.getCode());
		operator.setName(operatorUser.getName());
		return operator;
	}
	
	private static OrderProduct copyROrderProduct(ReplenishmentOrderItem op,String fbaBarcodeKey ) {
		OrderProduct swOp=new OrderProduct();
		swOp.setBusinessId(op.getId());
		swOp.setCode(op.getCmsProductCode());
		swOp.setWeight(op.getUnitWeight()==null?
				null:BigDecimal.valueOf(op.getUnitWeight()));
		swOp.setFreeShipping(false);
		swOp.setUnit(op.getUnit());
		swOp.setPurchasePrice(
				DMSUtils.convert2USD(BigDecimal.valueOf(op.getCostPrice()/op.getOrderedQuantity()) ,CurrencyUtils.RMB));
		swOp.setProductQty((int)op.getOrderedQuantity());
		swOp.setUnitPrice(swOp.getPurchasePrice());
		swOp.setFbaBarCode(op.getFbaBarcodeSku());
		swOp.setFbaBarTitle(op.getFbaBarcodeName());
		swOp.setFbaBarNew(fbaBarcodeKey);
		swOp.setCustomerServiceRemark(op.getCsRemark());
//		swOp.setDescription(op.get);
		return swOp;
	}

	private static OrderProduct copyOrderProduct(com.itecheasy.core.order.OrderProduct op,
			OrderPrepareProduct opp) {
		OrderProduct swOp=new OrderProduct();
		swOp.setBusinessId(opp.getId());
		swOp.setCode(op.getCmsProductCode());
		swOp.setWeight(opp.getUnitWeight()==null?
				null:BigDecimal.valueOf(opp.getUnitWeight()));
		swOp.setFreeShipping(false);
		swOp.setUnit(op.getUnit());
		swOp.setPurchasePrice(
				DMSUtils.convert2USD(
				BigDecimal.valueOf(op.getShopItemPrice()-op.getShopDiscount()).divide(BigDecimal.valueOf(opp.getOrderQty()),3,4)
				,op.getShopItemCurtype()));
		swOp.setProductQty((int)opp.getOrderQty());
		swOp.setUnitPrice(swOp.getPurchasePrice());
		swOp.setDescription(op.getShopItemTitle());
		swOp.setCustomerServiceRemark(opp.getCsRemark());
		return swOp;
	}

	public static OrderSourcePlatform getSwOrderPlatformByShopType(int shopType){
		switch (shopType) {
		case DictUtils.SHOP_TYPE_AMAZON:
			return OrderSourcePlatform.WH_AM;
		case DictUtils.SHOP_TYPE_EBAY:
			return OrderSourcePlatform.WH_EBAY;
		case DictUtils.SHOP_TYPE_SMT:
			return OrderSourcePlatform.WH_SMT;
		case DictUtils.SHOP_SOURCE_WH_FBA:
			return OrderSourcePlatform.FBA;
		}
		return OrderSourcePlatform.WH_AM;
	} 
	
	private static void copyROrderAddress(OrderShippingAddress orderShippingAddress, Repository orderAddress) {
		orderShippingAddress.setAddressLine1(StringUtils.convertEmptyStringOfNull(orderAddress.getAddressLine1()));
		orderShippingAddress.setAddressLine2(StringUtils.convertEmptyStringOfNull(orderAddress.getAddressLine2()));
		Country country=new Country();
		orderShippingAddress.setCountry(country);
		
//		country.setCode(orderAddress.getCountryCode());
		country.setId(orderAddress.getCountryId());
		orderShippingAddress.setCityTown(StringUtils.convertEmptyStringOfNull(orderAddress.getCity()));
		orderShippingAddress.setFirstName(orderAddress.getName());
		orderShippingAddress.setProvince(StringUtils.convertEmptyStringOfNull(orderAddress.getStateOrRegion()));
		orderShippingAddress.setRegion(StringUtils.convertEmptyStringOfNull(orderAddress.getStateOrRegion()));
		orderShippingAddress.setZipCode(StringUtils.convertEmptyStringOfNull(orderAddress.getPostalCode()));
		orderShippingAddress.setPhoneNumber(StringUtils.convertEmptyStringOfNull(orderAddress.getPhone()));
		orderShippingAddress.setLastName("");
		orderShippingAddress.setFaxNumber("");
	}
	
	private static void copyOrderAddress(OrderShippingAddress orderShippingAddress, OrderAddress orderAddress) {
		orderShippingAddress.setAddressLine1(StringUtils.convertEmptyStringOfNull(orderAddress.getAddressLine1()));
		orderShippingAddress.setAddressLine2(StringUtils.convertEmptyStringOfNull(orderAddress.getAddressLine2()));
		Country country=new Country();
		orderShippingAddress.setCountry(country);
		
		country.setCode(orderAddress.getCountryCode());
		country.setId(orderAddress.getCountryId());
		orderShippingAddress.setCityTown(StringUtils.convertEmptyStringOfNull(orderAddress.getCity()));
		orderShippingAddress.setFirstName(orderAddress.getName());
		orderShippingAddress.setProvince(StringUtils.convertEmptyStringOfNull(orderAddress.getStateOrRegion()));
		orderShippingAddress.setRegion(StringUtils.convertEmptyStringOfNull(orderAddress.getStateOrRegion()));
		orderShippingAddress.setZipCode(StringUtils.convertEmptyStringOfNull(orderAddress.getPostalCode()));
		orderShippingAddress.setPhoneNumber(StringUtils.convertEmptyStringOfNull(orderAddress.getPhone()));
		orderShippingAddress.setLastName("");
		orderShippingAddress.setFaxNumber("");
	}
	
	private static void copyROrderBillingAddress(OrderBillingAddress orderShippingAddress, Repository orderAddress) {
		orderShippingAddress.setAddressLine1(StringUtils.convertEmptyStringOfNull(orderAddress.getAddressLine1()));
		orderShippingAddress.setAddressLine2(StringUtils.convertEmptyStringOfNull(orderAddress.getAddressLine2()));
		Country country=new Country();
		orderShippingAddress.setCountry(country);
		
//		country.setCode(orderAddress.getCountryCode());
		country.setId(orderAddress.getCountryId());
		orderShippingAddress.setCityTown(StringUtils.convertEmptyStringOfNull(orderAddress.getCity()));
		orderShippingAddress.setFirstName(orderAddress.getName());
		orderShippingAddress.setProvince(StringUtils.convertEmptyStringOfNull(orderAddress.getStateOrRegion()));
		orderShippingAddress.setRegion(StringUtils.convertEmptyStringOfNull(orderAddress.getStateOrRegion()));
		orderShippingAddress.setZipCode(StringUtils.convertEmptyStringOfNull(orderAddress.getPostalCode()));
		orderShippingAddress.setPhoneNumber(StringUtils.convertEmptyStringOfNull(orderAddress.getPhone()));
		orderShippingAddress.setLastName("");
		orderShippingAddress.setFaxNumber("");
	}
	
	private static void copyOrderBillingAddress(OrderBillingAddress orderShippingAddress, OrderAddress orderAddress) {
		orderShippingAddress.setAddressLine1(StringUtils.convertEmptyStringOfNull(orderAddress.getAddressLine1()));
		orderShippingAddress.setAddressLine2(StringUtils.convertEmptyStringOfNull(orderAddress.getAddressLine2()));
		Country country=new Country();
		orderShippingAddress.setCountry(country);
		
		country.setCode(orderAddress.getCountryCode());
		country.setId(orderAddress.getCountryId());
		orderShippingAddress.setCityTown(StringUtils.convertEmptyStringOfNull(orderAddress.getCity()));
		orderShippingAddress.setFirstName(orderAddress.getName());
		orderShippingAddress.setProvince(StringUtils.convertEmptyStringOfNull(orderAddress.getStateOrRegion()));
		orderShippingAddress.setRegion(StringUtils.convertEmptyStringOfNull(orderAddress.getStateOrRegion()));
		orderShippingAddress.setZipCode(StringUtils.convertEmptyStringOfNull(orderAddress.getPostalCode()));
		orderShippingAddress.setPhoneNumber(StringUtils.convertEmptyStringOfNull(orderAddress.getPhone()));
		orderShippingAddress.setLastName("");
		orderShippingAddress.setFaxNumber("");
	}
	
	public static void updateRemark(String orderCode,String deliveryExplanation,String cpfCode,
			String customerServiceRemark,BigDecimal reimburseAmountRate){
		SwOrderClient.updateRemark(orderCode, deliveryExplanation, cpfCode, customerServiceRemark,reimburseAmountRate);
	}
	
	public static void setFBAFlag(String orderCode,Boolean flag){
		SwOrderClient.setFBAFlag(orderCode, flag);
	}
	
	public static void updateOrderProductRemark(String orderCode,
			List<UpdateOrdertProductInfo> items
			){
		List<Integer> orderItemIds=new ArrayList<Integer>();
		List<String> remarks=new ArrayList<String>();
		for (UpdateOrdertProductInfo updateOrdertProductInfo : items) {
			orderItemIds.add(updateOrdertProductInfo.getOrderPrepareProductId());
			remarks.add(updateOrdertProductInfo.getCsRemark());
		}
		SwOrderClient.updateOrderProductRemark(orderCode, orderItemIds, remarks);
	}
}
