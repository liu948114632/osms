package com.itecheasy.picture;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itecheasy.common.picture.PictureService;

/**
 * @author wanghw
 * @date 2015-4-14
 * @description TODO
 * @version
 */
public class PictureServlet extends HttpServlet {
	private static final String MODULE_TYPE = "product";
	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public PictureServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		PictureService pictureService = (PictureService) ctx.getBean("pictureService");
		String pictureName = request.getPathInfo();
		if (StringUtils.isEmpty(pictureName)) {
			response.setStatus(404);
			return;
		}

		pictureName = pictureName.substring(1);
		System.out.println(pictureName);

		File file = pictureService.getPictureFile(MODULE_TYPE, pictureName);
		if (file == null) {
			response.setStatus(404);
			return;
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			colse(in);
			close(outp);
		}

	}

	public void colse(FileInputStream in) {
		if (in == null) {
			return;
		}
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		in = null;
	}

	public void close(OutputStream out) {
		if (out == null) {
			return;
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out = null;
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
