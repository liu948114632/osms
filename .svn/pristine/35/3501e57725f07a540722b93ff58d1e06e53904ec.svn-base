package com.itecheasy.core.order;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ebay.sdk.util.Base64;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.fba.ReplenishmentOrderService;

/** 
 * @author wanghw
 * @date 2016-12-12 
 * @description TODO
 * @version 1.2.2
 */
public class DownOrderShippingList extends HttpServlet {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public DownOrderShippingList() {
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
		
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		ReplenishmentOrderService replenishmentOrderService = (ReplenishmentOrderService) ctx.getBean("replenishmentOrderService");
		String orderCode = request.getParameter("orderCode");
		if (StringUtils.isEmpty(orderCode)) {
			response.setStatus(404);
			return;
		}
		if(orderCode.contains("-")){
			//sw 
			orderCode=orderCode.split("-")[0];
		}
		
		List<File>  files=replenishmentOrderService.getShippingList2BussinessLine(orderCode);
		if(CollectionUtils.isEmpty(files)){
			response.setStatus(404);
			return;
		}
		
		StringBuffer sb=new StringBuffer();
		for (File f : files) {
			if(f.exists()){
				sb.append(Base64.encode(FileUtils.readFileToByteArray(f)))
				.append(",");
			}
		}
		response.getWriter().write(sb.toString());
		
//		sb.append(Base64.encode(FileUtils.readFileToByteArray(
//				new File("E:\\public\\osms\\attachment\\REPLENISHMENT_SHIPPING_ATTACHMENT\\9\\1.pdf.pdf"))));
//		sb.append("\n");
//		sb.append(Base64.encode(FileUtils.readFileToByteArray(
//				new File("E:\\public\\osms\\attachment\\REPLENISHMENT_SHIPPING_ATTACHMENT\\10\\NPOI教程(已加书签).pdf.pdf"))));
		
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
