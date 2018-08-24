/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Proxy.Sample;

public class Printer implements Printable {
    private String name;
    public Printer() {
        heavyJob("正在生成Printer的实例");
    }
    public Printer(String name) {                   // 构造函数
        this.name = name;
        heavyJob("正在生成Printer的实例(" + name + ")");
    }
    public void setPrinterName(String name) {       // 设置名字
        this.name = name;
    }
    public String getPrinterName() {                // 获取名字
        return name;
    }
    public void print(String string) {              // 显示带打印机名字的文字
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }
    private void heavyJob(String msg) {             // 重活
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("结束。");
    }
}
