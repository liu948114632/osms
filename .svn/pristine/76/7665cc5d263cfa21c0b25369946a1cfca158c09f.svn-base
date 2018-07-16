package com.itecheasy.core.order;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itecheasy.common.util.DeployProperties;

/** 
 * @author wanghw
 * @date 2016-3-26 
 * @description TODO
 * @version 1.1.7
 */
public class LoginUtils {
	public static void isLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String pwd=(String)request.getSession().getAttribute("pwd");
		if(!DeployProperties.getInstance().getProperty("login.pwd","123456").equals(pwd)){
			response.sendRedirect("login.jsp?msg=login failed,please try again! ");
		}
		
	}
}
