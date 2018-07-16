package com.itecheasy.core.email;

import java.util.List;

import com.itecheasy.core.user.User;


public interface EmailService {
	/**
	 * 邮件服务器地址
	 * 
	 * @return
	 */
	public String getEmailSmtpHost();

	public int getEmailSmtpPort();

	public String getEmailSmtpPassword();

	public String getEmailSmtpUsername();
	
	/**
	 * 网站客服邮箱
	 */
	public String getServiceMail();

	/**
	 * 网站客服邮箱显示名称
	 */
	public String getServiceDisplayName();

	/**
	 *
	 * @param to 要发送给谁
	 * @param subject	标题
	 * @param content	内容
	 */
	public void addEmail(String to, String subject, String content);
	
	public void addEmail(List<User> toUsers, String subject, String content);
	
}
