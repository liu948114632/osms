package com.itecheasy.core.email;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.itecheasy.common.asynemail.Email;

public class MailHelper {
	private static final String EMPTY = "";
	/**
	 * 加载邮件模板
	 * 
	 * @param filename
	 *            邮件模板的文件名, 系统只从classpath中加载
	 * @return
	 * @throws Exception
	 */
	public static String getMailTemplate(String filename) {
		try {
			InputStream in = MailHelper.class.getClassLoader()
					.getResourceAsStream(filename);

			BufferedReader breader = new BufferedReader(new InputStreamReader(
					in, "UTF-8"));
			StringBuffer buff = new StringBuffer();
			String line = null;
			while ((line = breader.readLine()) != null) {
				buff.append(line);
			}
			breader.close();
			return buff.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String replaceMailTemplate(String text,
			Map<String, String> replaceList) {
		String ret = text;
		for (String key : replaceList.keySet()) {
			String value = replaceList.get(key);
			if (value != null) {
				value = "";
			}
			ret = ret.replace(key, value);
		}

		return ret;
	}
	
	public static String replaceMailTemplate(String text,
			List<ReplaceItem> replaceList) {
		String ret = text;
		String value;
		for (ReplaceItem item : replaceList) {
			value = item.getReplacement();
			if (value == null) {
				value = EMPTY;
			}
			ret = ret.replace(item.getTarget(), value);
		}
		return ret;
	}

	/**
	 * 
	 * @param smtpHost
	 * @param smtpUsername
	 * @param SmtpPassword
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 * @param myMail
	 * @return
	 */
	public static Email createEmail(String smtpHost, String smtpUsername,
			String SmtpPassword, String from, String to, String subject,
			String content, String myMail) {
		Email email = new Email();
		email.setBody(content);
		email.setMyMail(myMail);
		List<String> recipients = new LinkedList<String>();
		recipients.add(to);
		email.setRecipients(recipients);
		email.setSendFrom(from);
		email.setSmtpHost(smtpHost);
		email.setSmtpPassword(SmtpPassword);
		email.setSmtpUsername(smtpUsername);
		email.setSubject(subject);
		return email;
	}

	public static String generateRandomStr(int len) {
		Random r = new Random();
		char[] result = new char[len];
		for (int i = 0; i < len; i++) {
			result[i] = (char) (r.nextInt(26) + 97);
		}
		return new String(result);
	}
}
