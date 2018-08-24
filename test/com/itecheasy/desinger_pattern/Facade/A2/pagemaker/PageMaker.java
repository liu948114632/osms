/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Facade.A2.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Enumeration;

public class PageMaker {
    private PageMaker() {   // 不允许生成PageMaker类的实例，因此将构造函数设为private
    }
    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to " + username + "'s page!");
            writer.paragraph("欢迎来到" + username + "的主页。");
            writer.paragraph("等着你的邮件哦！");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void makeLinkPage(String filename) {          
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Link page");
            Properties mailprop = Database.getProperties("maildata");
            Enumeration en = mailprop.propertyNames();
            while (en.hasMoreElements()) {
                String mailaddr = (String)en.nextElement();
                String username = mailprop.getProperty(mailaddr, "(unknown)");
                writer.mailto(mailaddr, username);
            }
            writer.close();
            System.out.println(filename + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
