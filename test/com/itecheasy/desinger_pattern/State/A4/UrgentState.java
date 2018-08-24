/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.State.A4;

public class UrgentState implements State {
    private static UrgentState singleton = new UrgentState();
    private UrgentState() {                             // 构造函数的可见性是private
    }
    public static State getInstance() {                 // 获取唯一实例
        return singleton;
    }
    public void doClock(Context context, int hour) {    // 设置时间     
        // 在设置时间处理中什么都不做                                 
    }                                                                   
    public void doUse(Context context) {                // 使用金库
        context.callSecurityCenter("紧急:紧急时使用金库！");
    }
    public void doAlarm(Context context) {              // 按下警铃
        context.callSecurityCenter("按下警铃(紧急时)");
    }
    public void doPhone(Context context) {              // 正常通话
        context.callSecurityCenter("正常通话(紧急时)");
    }
    public String toString() {                          // 显示字符串
        return "[紧急时]";
    }
}
