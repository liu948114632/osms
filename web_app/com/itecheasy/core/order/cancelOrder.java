package com.itecheasy.core.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itecheasy.core.po.OrderProductPO;
import com.itecheasy.core.po.OrderTrackingPO;
import com.itecheasy.core.po.OrderTrackingProductPO;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itecheasy.core.BussinessException;

/** 
 * @author wanghw
 * @date 2016-2-25 
 * @description TODO
 * @version 1.1.7
 */
public class cancelOrder extends HttpServlet {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public cancelOrder() {
		super();
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
	 * @param request the request send by the client to the server+
	 * 
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
		request.setCharacterEncoding("utf-8");
		String amId=request.getParameter("amId");
		String code=request.getParameter("code");
		String status=request.getParameter("canceledStatus");
		String type=request.getParameter("type");
		String shopId=request.getParameter("shopId");
		
		String message="cancel success!";
		
		try {
			if(StringUtils.isNotEmpty(code)){
				convertCode(ctx, code, status,Integer.parseInt(shopId));   //code query
			}else{
				if(type.equals("1")){
					amazomCancel(ctx, amId,Integer.parseInt(shopId), status);
				}else if(type.equals("2")){
					ebayCancel(ctx, amId, status);
				}
			}
		} catch (BussinessException e) {
			message=e.getMessage();
		}
		response.sendRedirect("index.jsp?msg="+message);
	}
	
	private void convertCode(WebApplicationContext ctx, String code,String status,int shopId){
		OrderService orderService=	(OrderService)ctx.getBean("orderService");
		Order o=  orderService.getOrderByCode(code);
		if(o!=null)
		{

			AmazonOrderService amazonOrderService = (AmazonOrderService)ctx.getBean("amazonOrderService");
			amazonOrderService.cancelOrder(o.getId(), "通过OSMS网页取消");
		} 
	}

	private void ebayCancel(WebApplicationContext ctx, String amId, String status)throws BussinessException {
		EbayOrderService ebayOrderService=	(EbayOrderService)ctx.getBean("ebayOrderService");
		ebayOrderService.cancelOrderTest(amId);
		if(status!=null){
			ebayOrderService.updateOrderStatusTest(amId);
		}
	}

	private void amazomCancel(WebApplicationContext ctx, String amId,int shopId, String status) throws BussinessException {
		AmazonOrderService amazonOrderService = (AmazonOrderService)ctx.getBean("amazonOrderService");
		amazonOrderService.cancelOrderTest(amId,shopId);
		if(status!=null){
			amazonOrderService.updateOrderStatusTest(amId);
		}
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
