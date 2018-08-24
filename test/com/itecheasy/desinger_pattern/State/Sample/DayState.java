/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.State.Sample;

public class DayState implements State {
    private static DayState singleton = new DayState();
    private DayState() {                                // 构造函数的可见性是private
    }
    public static State getInstance() {                 // 获取唯一实例
        return singleton;
    }
    public void doClock(Context context, int hour) {    // 设置时间
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }
    public void doUse(Context context) {                // 使用金库
        context.recordLog("使用金库(白天)");
    }
    public void doAlarm(Context context) {              // 按下警铃
        context.callSecurityCenter("按下警铃(白天)");
    }
    public void doPhone(Context context) {              // 正常通话
        context.callSecurityCenter("正常通话(白天)");
    }
    public String toString() {                          // 显示表示类的文字
        return "[白天]";
    }
}
