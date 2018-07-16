package com.itecheasy.common.asynemail;

import java.util.List;

public class Email
{
  private String smtpHost;
  private String smtpUsername;
  private String smtpPassword;
  private String sendFrom;
  private String myMail;
  private String subject;
  private List<String> recipients;
  private String body;

  public String getSmtpHost()
  {
    return this.smtpHost;
  }

  public void setSmtpHost(String smtpHost) {
    this.smtpHost = smtpHost;
  }

  public String getSmtpUsername() {
    return this.smtpUsername;
  }

  public void setSmtpUsername(String smtpUsername) {
    this.smtpUsername = smtpUsername;
  }

  public String getSmtpPassword() {
    return this.smtpPassword;
  }

  public void setSmtpPassword(String smtpPassword) {
    this.smtpPassword = smtpPassword;
  }

  public String getSendFrom() {
    return this.sendFrom;
  }

  public void setSendFrom(String sendFrom) {
    this.sendFrom = sendFrom;
  }

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

  public List<String> getRecipients() {
    return this.recipients;
  }

  public void setRecipients(List<String> recipients) {
    this.recipients = recipients;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}