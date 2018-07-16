package com.itecheasy.common.po;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="common_email_failed_2_send")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmailFailed2SendPO
{
  private Long id;
  private String smtpHost;
  private String smtpUsername;
  private String smtpPassword;
  private String sendFrom;
  private String myMail;
  private String subject;
  private String recipients;
  private String body;
  private Timestamp createTime;
  private Integer failedTimes;
  private Timestamp lastFailedTime;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  @Column(name="smtp_host")
  public String getSmtpHost() {
    return this.smtpHost;
  }

  public void setSmtpHost(String smtpHost) {
    this.smtpHost = smtpHost;
  }
  @Column(name="smtp_username")
  public String getSmtpUsername() {
    return this.smtpUsername;
  }

  public void setSmtpUsername(String smtpUsername) {
    this.smtpUsername = smtpUsername;
  }
  @Column(name="smtp_password")
  public String getSmtpPassword() {
    return this.smtpPassword;
  }

  public void setSmtpPassword(String smtpPassword) {
    this.smtpPassword = smtpPassword;
  }
  @Column(name="send_from")
  public String getSendFrom() {
    return this.sendFrom;
  }

  public void setSendFrom(String sendFrom) {
    this.sendFrom = sendFrom;
  }
  @Column(name="my_mail")
  public String getMyMail() {
    return this.myMail;
  }

  public void setMyMail(String myMail) {
    this.myMail = myMail;
  }

  public String getSubject() {
    return this.subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getRecipients() {
    return this.recipients;
  }

  public void setRecipients(String recipients) {
    this.recipients = recipients;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }
  @Column(name="create_time")
  public Timestamp getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }
  @Column(name="failed_times")
  public Integer getFailedTimes() {
    return this.failedTimes;
  }

  public void setFailedTimes(Integer failedTimes) {
    this.failedTimes = failedTimes;
  }
  @Column(name="last_failed_time")
  public Timestamp getLastFailedTime() {
    return this.lastFailedTime;
  }

  public void setLastFailedTime(Timestamp lastFailedTime) {
    this.lastFailedTime = lastFailedTime;
  }
}