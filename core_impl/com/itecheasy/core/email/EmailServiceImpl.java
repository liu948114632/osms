package com.itecheasy.core.email;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itecheasy.common.asynemail.AsynEmailService;
import com.itecheasy.common.asynemail.Email;
import com.itecheasy.common.sysconfig.SysConfigService;
import com.itecheasy.core.user.User;

public class EmailServiceImpl implements EmailService {

	private SysConfigService sysConfigService;
	private AsynEmailService asynEmailService;
	private static Map<String, String> emails = new HashMap<String, String>();

	public void setSysConfigService(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}

	public void setAsynEmailService(AsynEmailService asynEmailService) {
		this.asynEmailService = asynEmailService;
	}

	@Override
	public String getEmailSmtpHost() {
		return getEmailComfig("smtp_host");
	}

	private String getEmailComfig(String key) {
		String value="";
		if (EmailServiceImpl.emails.containsKey(key)) {
			return emails.get(key);
		}else{
			value=sysConfigService.getValue(key);
			EmailServiceImpl.emails.put(key, value);
		}
		return value;
	}

	@Override
	public String getEmailSmtpPassword() {
		return getEmailComfig("smtp_password");
	}

	@Override
	public int getEmailSmtpPort() {
		return 0;
	}

	@Override
	public String getEmailSmtpUsername() {
		return getEmailComfig("smtp_username");
	}

	@Override
	public String getServiceMail() {
		return getEmailComfig("service_mail");
	}

	@Override
	public String getServiceDisplayName() {
		return getEmailComfig("service_displayName");
	}

	private Email getEmail(String to, String subject, String content) {
		return MailHelper.createEmail(this.getEmailSmtpHost(), this.getEmailSmtpUsername(),
				this.getEmailSmtpPassword(), this.getServiceDisplayName(), to, subject, content, this.getServiceMail());
	}

	@Override
	public void addEmail(String to, String subject, String content) {

		asynEmailService.addEmail(getEmail(to, subject, content));
	}

	@Override
	public void addEmail(List<User> toUsers, String subject, String content) {
		StringBuilder emails = new StringBuilder();
		for (User user : toUsers) {
			emails.append(";" + user.getEmail());
		}
		asynEmailService.addEmail(getEmail(emails.substring(1).toString(), subject, content));
	}
}
