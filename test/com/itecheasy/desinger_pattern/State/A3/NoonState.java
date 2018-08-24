/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.State.A3;

public class NoonState implements State {
    private static NoonState singleton = new NoonState();
    private NoonState() {                               // 构造函数的可见性是private
    }
    public static State getInstance() {                 // 获取唯一实例
        return singleton;
    }
    public void doClock(Context context, int hour) {    // 设置时间     
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        } else if (9 <= hour && hour < 12 || 13 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
    public void doUse(Context context) {                // 使用金库
        context.callSecurityCenter("紧急：午餐时间使用金库！");
    }
    public void doAlarm(Context context) {              // 按下警铃
        context.callSecurityCenter("按下警铃(午餐时间)");
    }
    public void doPhone(Context context) {              // 正常通话
        context.recordLog("午餐时间的通话录音");
    }
    public String toString() {                          // 显示字符串
        return "[午餐时间]";
    }
}
