package com.itecheasy.picture;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itecheasy.common.picture.PictureService;

public class PictureDownServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public PictureDownServlet() {
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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String  w = request.getParameter("width");
		String  h = request.getParameter("height");
		String pictureCode = request.getParameter("pic_code");
		int width = 0;
		int height = 0;
		WebApplicationContext  ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		PictureService pictureService = (PictureService)ctx.getBean("pictureService");
		File file =null;
		if(StringUtils.isNotEmpty(w) && Integer.parseInt(w)>0 && StringUtils.isNotEmpty(h) && Integer.parseInt(h)>0){
			width =  Integer.parseInt(w);
			height =  Integer.parseInt(h);
			
			file = pictureService.getPictureFile(pictureCode, width, height);
			if(file == null){
				response.setStatus(404);
				return;
			}
		}else{
			file = pictureService.getPictureFile(pictureCode);
			if(file == null){
				response.setStatus(404);
				return;
			}
		}
		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		
		OutputStream outp = null;
		FileInputStream in = null;
		try {
			outp = response.getOutputStream();
			in = new FileInputStream(file);
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = in.read(b)) > 0) {
				outp.write(b, 0, i);
			}
			outp.flush();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			colse(in);
			close(outp);
		}
		
	}

	public void colse(FileInputStream in){
		if (in == null) {
			return;
		}
		try {
			in.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		in = null;
	}
	
	public void close(OutputStream out){
		if (out == null) {
			return;
		}
		try {
			out.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		out = null;
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
