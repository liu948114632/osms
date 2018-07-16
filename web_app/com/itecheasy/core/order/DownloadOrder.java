package com.itecheasy.core.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/** 
 * @author whw
 * @date 2017-5-9 
 * @description TODO
 * @version 3.9.42
 */
public class DownloadOrder extends HttpServlet {
	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public DownloadOrder() {
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
		LoginUtils.isLogin(request, response);
		WebApplicationContext  ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		
		EbayOrderService ebayOrderService=	(EbayOrderService)ctx.getBean("ebayOrderService");
		String code=request.getParameter("shopOrderCode");
		String shopId= request.getParameter("accountId");
		
		
		String message="download ebay Order success!";
		try {
			ebayOrderService.downloadSimpleOrder(code, Integer.valueOf(shopId));
		} catch (Exception e) {
			message=e.getMessage();
		}
		response.sendRedirect("index.jsp?msg="+message);
	
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
