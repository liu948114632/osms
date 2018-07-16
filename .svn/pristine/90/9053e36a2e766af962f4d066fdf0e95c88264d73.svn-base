package com.itecheasy.core.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itecheasy.common.util.ConstantUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.webservice.amazon.Address;
import com.itecheasy.webservice.amazon.Money;
import com.itecheasy.webservice.amazon.OrderAmazon;
import com.itecheasy.webservice.amazon.OrderItem;

/** 
 * @author wanghw
 * @date 2015-5-18 
 * @description TODO
 * @version
 */
public class addOrder extends HttpServlet {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public addOrder() {
		super();
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * Destruction of the servlet. <br>

	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginUtils.isLogin(request, response);
		WebApplicationContext  ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		AmazonOrderService amazonOrderService = (AmazonOrderService)ctx.getBean("amazonOrderService");
//		
		request.setCharacterEncoding("utf-8");
		String country= request.getParameter("country");
		String shopId= request.getParameter("accountId");
		String addressName= request.getParameter("addressName");
		String stateOrRegion= request.getParameter("stateOrRegion");
		String city= request.getParameter("city");
		String postalCode= request.getParameter("postalCode");
		String address1= request.getParameter("address1");
		String address2= request.getParameter("address2");
		String address3= request.getParameter("address3");
		String phone= request.getParameter("phone");
		String customerAccount= request.getParameter("customerAccount");
		String customerName= request.getParameter("customerName");
		String amazonId= request.getParameter("amazonId");
		String totalPrice= request.getParameter("totalPrice");
		String FulfillmentChannel= request.getParameter("FulfillmentChannel");
		
		
		String title= request.getParameter("title");
		String sku= request.getParameter("sku");
		String shopQuantityOrdered= request.getParameter("shopQuantityOrdered");
		String shopItemPrice= request.getParameter("shopItemPrice");
		String asin= request.getParameter("asin");
		String itemId= request.getParameter("itemId");
		String shippingprice= request.getParameter("shippingprice");
		shippingprice=shippingprice==null?"0":shippingprice;
		
		String title2= request.getParameter("title2");
		String sku2= request.getParameter("sku2");
		String shopQuantityOrdered2= request.getParameter("shopQuantityOrdered2");
		String shopItemPrice2= request.getParameter("shopItemPrice2");
		String asin2= request.getParameter("asin2");
		String itemId2= request.getParameter("itemId2");
		String shippingprice2= request.getParameter("shippingprice2");
		shippingprice2=shippingprice2==null?"0":shippingprice2;
		
		
		OrderAmazon orderAmazon=new OrderAmazon();
		orderAmazon.setAmazonOrderId(amazonId);
		orderAmazon.setBuyerEmail(customerAccount);
		orderAmazon.setBuyerName(customerName);
		Date date=new Date();
		orderAmazon.setPurchaseDate(DateUtils.getXMLGregorianCalendar(date));
		orderAmazon.setEarliestDeliveryDate(DateUtils.getXMLGregorianCalendar
				(org.apache.commons.lang.time.DateUtils.addDays(date, 28)));
		orderAmazon.setLatestDeliveryDate(DateUtils.getXMLGregorianCalendar
				(org.apache.commons.lang.time.DateUtils.addDays(date, 49)));
		orderAmazon.setEarliestShipDate(DateUtils.getXMLGregorianCalendar
				(org.apache.commons.lang.time.DateUtils.addDays(date, 2)));
		orderAmazon.setLatestShipDate(DateUtils.getXMLGregorianCalendar
				(org.apache.commons.lang.time.DateUtils.addDays(date, 7)));
		orderAmazon.setMarketplaceId("ATVPDKIKX0DER");
		orderAmazon.setShipmentServiceLevelCategory("Standard");
		if(ConstantUtils.FULFILLMENTCHANNELS_AFN.equals(FulfillmentChannel)){
			orderAmazon.setFulfillmentChannel(FulfillmentChannel);
		}else{
			orderAmazon.setFulfillmentChannel(ConstantUtils.FULFILLMENTCHANNELS_MFN);
		}
		Money total=new Money();
		Double.valueOf(totalPrice);
		total.setAmount(totalPrice);
		total.setCurrencyCode("USD");
		
		orderAmazon.setOrderTotal(total);
		
		Address address=new Address();
		address.setAddressLine1(address1);
		address.setAddressLine2(address2);
		address.setAddressLine3(address3);
		address.setCity(city);
		address.setPhone(phone);
		address.setCountryCode(StringUtils.isNotEmpty(country)?country:"US");
		address.setStateOrRegion(stateOrRegion);
		address.setPostalCode(postalCode);
		address.setName(addressName);
		
		
		List<OrderItem> orderItems=new ArrayList<OrderItem>();
		
		OrderItem item=new OrderItem();
		orderItems.add(item);
		item.setASIN(asin);
		item.setTitle(title);
		Money itemPrice=new Money();
		Double.valueOf(shopItemPrice);
		itemPrice.setAmount(shopItemPrice);
		itemPrice.setCurrencyCode("USD");
		item.setConditionId("NEW");
		item.setItemPrice(itemPrice);
		item.setSellerSKU(sku);
		Money shippingPrice=new Money();
		Double.valueOf(shippingprice);
		shippingPrice.setAmount(shippingprice);
		shippingPrice.setCurrencyCode("USD");
		item.setShippingPrice(shippingPrice);
		item.setQuantityOrdered(Integer.valueOf(shopQuantityOrdered));
		item.setOrderItemId(itemId);
		orderAmazon.setShippingAddress(address);
		
		if (StringUtils.isNotEmpty(sku2)) {
			OrderItem item2=new OrderItem();
			orderItems.add(item2);
			item2.setASIN(asin2);
			item2.setTitle(title2);
			Money itemPrice2=new Money();
			Double.valueOf(shopItemPrice2);
			itemPrice2.setAmount(shopItemPrice2);
			itemPrice2.setCurrencyCode("USD");
			item2.setConditionId("NEW");
			item2.setItemPrice(itemPrice2);
			item2.setSellerSKU(sku2);
			Money shippingPrice2=new Money();
			Double.valueOf(shippingprice2);
			shippingPrice2.setAmount(shippingprice2);
			shippingPrice2.setCurrencyCode("USD");
			item2.setShippingPrice(shippingPrice2);
			item2.setQuantityOrdered(Integer.valueOf(shopQuantityOrdered2));
			item2.setOrderItemId(itemId2);
		}
		
		orderAmazon.setOrderItems(orderItems);
		
		List<OrderAmazon> amazons=new ArrayList<OrderAmazon>();
		amazons.add(orderAmazon);
		orderAmazon.setOrderStatus("Unshipped");

		amazonOrderService.addOrderAmazon(amazons,shopId);



		response.sendRedirect("index.jsp?msg=add success!");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
