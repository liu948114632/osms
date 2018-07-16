package com.itecheasy.core.order;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itecheasy.core.BussinessException;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.webservice.client.AmazonClient;

/** 
 * @author wanghw
 * @date 2015-6-3 
 * @description TODO
 * @version
 */
public class TestServlet extends HttpServlet {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public TestServlet() {
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
		WebApplicationContext  ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		OrderService orderService = (OrderService)ctx.getBean("orderService");
//		AmazonClient.configInfo(1);
//		StaticUtils.convert2AmazonShipping(23);
		String id= request.getParameter("id");
//		systemService.getAmazonShippingMethod(Integer.valueOf(id));
		try {
			OrderDetail detail=orderService.getOrderDeatil(Integer.valueOf(id));
			detail.setWebWeight(1);
			orderService.orderOut(detail);
			
		} catch (BussinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			OrderDetail detail=orderService.getOrderDeatil(Integer.valueOf(id));
//			detail.setWebWeight(456);
//			orderService.orderOut(detail);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (BussinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
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
