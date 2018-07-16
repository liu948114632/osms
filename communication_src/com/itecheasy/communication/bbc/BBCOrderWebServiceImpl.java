package com.itecheasy.communication.bbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.order.AmazonOrderService;
import com.itecheasy.core.order.OrderDetail;
import com.itecheasy.core.order.OrderService;
import com.itecheasy.core.product.CMSProduct;
import com.itecheasy.core.product.OsmsStock;
import com.itecheasy.core.util.SystemEnumDicts.ShopType;
import com.itecheasy.webservice.client.CMSClient;

/** 
 * @author whw
 * @date 2018-4-12 
 * @description TODO
 * @version 
 */
public class BBCOrderWebServiceImpl implements BBCOrderWebService{
	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public String placeOrder(BBCOrderDetail order) {
		if(orderService.getOrderByCode(order.getCode())!=null)
			throw new BussinessException("Orders already exist");
		OrderDetail detail=BeanUtils.copyProperties(order, OrderDetail.class);
		detail.setShopId(Integer.valueOf(DeployProperties.getInstance().getProperty("bbc.shop.id")));
		detail.setShopType(ShopType.BBC.getVal());
		detail.setIsOtherSystem(true);
		detail.setEarliestDeliveryDate(DateUtils.addDays(detail.getShopOrderDate(), 18));
		detail.setLatestDeliveryDate(DateUtils.addDays(detail.getShopOrderDate(), 25));
//		detail.setEarliestShippingDate(DateUtils.addDays(detail.getShopOrderDate(), 3));
		detail.setLatestShipDate(DateUtils.addDays(detail.getShopOrderDate(), 5));
		detail.setShopOrderStatus(AmazonOrderService.AMAZON_STATUS_UNSHIPPED);
		orderService.addOrderByManual(detail, ShopType.BBC.getVal(), "BBC");
		return detail.getCode();
	}
	
	@Override
	public List<OsmsStock> getStock(List<String> productCodes) {
		List<CMSProduct>  ps=CMSClient.getCMSProductByCodes(productCodes);
		List<Integer> cmsProductIds=new ArrayList<Integer>();
		Map<Integer, String> mapId=new HashMap<Integer, String>();
		for (CMSProduct p : ps) {
			cmsProductIds.add(p.getId());
			mapId.put(p.getId(), p.getCode());
		}
		Map<Integer, OsmsStock> map=CMSClient.getOsmsStocks(cmsProductIds);
		List<OsmsStock> os=new ArrayList<OsmsStock>();
		for (Integer productId : cmsProductIds) {
			map.get(productId).setCmsProductCode(mapId.get(productId));
			os.add(map.get(productId));
		}
		return os;
	}
}
