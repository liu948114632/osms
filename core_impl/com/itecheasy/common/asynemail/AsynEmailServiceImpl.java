package com.itecheasy.common.asynemail;

import com.itecheasy.common.PageList;
import com.itecheasy.common.po.Email2SendPO;
import com.itecheasy.common.po.EmailFailed2SendPO;
import com.itecheasy.common.po.EmailSentPO;
import com.itecheasy.common.util.Mail;
import com.itecheasy.common.util.PropertyFileLoader;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class AsynEmailServiceImpl implements AsynEmailService {
	private static Logger logger = Logger.getLogger(AsynEmailServiceImpl.class);
	private Email2SendDAO email2SendDAO;
	private EmailSentDAO emailSentDAO;
	private EmailFailed2SendDAO emailFailed2SendDAO;
	private int sleep_time = 3;
	private int batch_get_email_size = 3;
	private long email_send_interval = 60000L;
	private int max_retry_times = 3;
	private boolean save_sent_email = false;
	private boolean save_failed_email = true;

	private Thread thread = null;
	private boolean keepRunning = false;

	public void setEmail2SendDAO(Email2SendDAO email2SendDAO) {
		this.email2SendDAO = email2SendDAO;
	}

	public void setEmailSentDAO(EmailSentDAO emailSentDAO) {
		this.emailSentDAO = emailSentDAO;
	}

	public void setEmailFailed2SendDAO(EmailFailed2SendDAO emailFailed2SendDAO) {
		this.emailFailed2SendDAO = emailFailed2SendDAO;
	}

	public AsynEmailServiceImpl() {			//初始化加载所有的邮件相关配置
		PropertyFileLoader pfl = new PropertyFileLoader("asynemail.properties");

		this.sleep_time = Integer.parseInt(pfl.get("sleep_time"));
		this.batch_get_email_size = Integer.parseInt(pfl
				.get("batch_get_email_size"));
		this.email_send_interval = Long.parseLong(pfl
				.get("email_send_interval"));
		this.max_retry_times = Integer.parseInt(pfl.get("max_retry_times"));
		this.save_sent_email = Boolean.parseBoolean(pfl.get("save_sent_email"));
		this.save_failed_email = Boolean.parseBoolean(pfl
				.get("save_failed_email"));
	}

	public void addEmail(Email email) {
		Email2SendPO po = convertVO2PO(email);

		po.setCreateTime(new Timestamp(System.currentTimeMillis()));
		po.setFailedTimes(Integer.valueOf(0));
		po.setLastFailedTime(null);
		po.setId(null);

		this.email2SendDAO.addObject(po);
	}

	//转换属性
	private Email2SendPO convertVO2PO(Email email) {
		Email2SendPO po = new Email2SendPO();

		po.setSendFrom(email.getSendFrom());
		po.setMyMail(email.getMyMail());

		po.setSmtpHost(email.getSmtpHost());
		po.setSmtpPassword(email.getSmtpPassword());
		po.setSmtpUsername(email.getSmtpUsername());

		po.setBody(email.getBody());
		StringBuffer sb = new StringBuffer();
		for (String recipient : email.getRecipients()) {
			sb.append(recipient);
			sb.append(";");
		}
		if (sb.length() > 0) {
			sb = sb.delete(sb.length() - 1, sb.length());
		}
		po.setRecipients(sb.toString());
		po.setSubject(email.getSubject());

		return po;
	}

	public void sendEmail() {
		logger.info("start sending email.");

		String hql = "from Email2SendPO o where o.failedTimes = 0 or o.lastFailedTime <= ? order by o.createTime desc";
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Timestamp last = new Timestamp(now.getTime() - this.email_send_interval);

		PageList<Email2SendPO> list = this.email2SendDAO.findPageListByHql(1,
				this.batch_get_email_size, hql, new Object[] { last });

		for (Email2SendPO po : list.getData()) {
			try {
				send(po);	//发送邮件

				if (this.save_sent_email) {
					EmailSentPO sentPO = new EmailSentPO();
					sentPO.setId(po.getId());
					sentPO.setSendFrom(po.getSendFrom());
					sentPO.setMyMail(po.getMyMail());
					sentPO.setSmtpHost(po.getSmtpHost());
					sentPO.setSmtpPassword(po.getSmtpPassword());
					sentPO.setSmtpUsername(po.getSmtpUsername());
					sentPO.setBody(po.getBody());
					sentPO.setRecipients(po.getRecipients());
					sentPO.setSubject(po.getSubject());
					sentPO.setCreateTime(po.getCreateTime());
					sentPO.setFailedTimes(po.getFailedTimes());
					sentPO.setLastFailedTime(po.getLastFailedTime());
					sentPO.setSentTime(now);
					this.emailSentDAO.addObject(sentPO);		//保存发送过的邮件，用来备份
				}

				this.email2SendDAO.deleteObject(po);		//删除邮件
			} catch (Exception e) {
				logger.error(po.getId() + ", " + po.getRecipients() + ", "
						+ po.getSubject() + ", send error, " + e);

				int failedTimes = po.getFailedTimes().intValue() + 1;
				if (failedTimes >= this.max_retry_times) {
					if (this.save_failed_email) {
						EmailFailed2SendPO failedPO = new EmailFailed2SendPO();
						failedPO.setId(po.getId());
						failedPO.setSendFrom(po.getSendFrom());
						failedPO.setMyMail(po.getMyMail());
						failedPO.setSmtpHost(po.getSmtpHost());
						failedPO.setSmtpPassword(po.getSmtpPassword());
						failedPO.setSmtpUsername(po.getSmtpUsername());
						failedPO.setBody(po.getBody());
						failedPO.setRecipients(po.getRecipients());
						failedPO.setSubject(po.getSubject());
						failedPO.setCreateTime(po.getCreateTime());
						failedPO.setFailedTimes(po.getFailedTimes());
						failedPO.setLastFailedTime(po.getLastFailedTime());
						this.emailFailed2SendDAO.addObject(failedPO);
					}

					this.email2SendDAO.deleteObject(po);
				} else {
					po.setFailedTimes(Integer.valueOf(failedTimes));
					po.setLastFailedTime(now);
					this.email2SendDAO.updateObject(po);
				}
			}
		}

		logger.info("tried " + list.getData().size() + " emails.");
	}

	private void send(Email2SendPO po) throws Exception {
		Mail mail = new Mail();
		mail.setSendFrom(po.getSendFrom());
		mail.setMyMail(po.getMyMail());

		mail.setSmtpHost(po.getSmtpHost());
		mail.setSmtpUsername(po.getSmtpUsername());
		mail.setSmtpPassword(po.getSmtpPassword());

		List<String> recipients = new LinkedList<String>();
		String[] ss = po.getRecipients().split(";");
		for (String s : ss) {
			recipients.add(s);
		}
		mail.setRecipients(recipients);

		mail.setSubject(po.getSubject());
		mail.setText(po.getBody());
		mail.sendMail();
		logger.info(po.getId() + ", " + po.getRecipients() + ", "
				+ po.getSubject() + ", sent.");
	}

	public void start() {
		this.keepRunning = true;
		if (this.thread == null)
			this.thread = new Thread(new Runnable() {
				public void run() {
					while (keepRunning) {
							sendEmail();
						try {
							Thread.sleep(AsynEmailServiceImpl.this.sleep_time * 1000);
						} catch (InterruptedException localInterruptedException) {
						}
					}
				}
			});
		this.thread.start();
	}

	public void stop() {
		this.keepRunning = false;
	}
}