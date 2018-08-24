/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.State.A3;

public interface State {
    public abstract void doClock(Context context, int hour);    // 设置时间
    public abstract void doUse(Context context);                // 使用金库
    public abstract void doAlarm(Context context);              // 按下警铃
    public abstract void doPhone(Context context);              // 正常通话
}
