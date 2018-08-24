/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.State.Sample;

public interface Context {

    public abstract void setClock(int hour);                // 设置时间
    public abstract void changeState(State state);          // 改变状态
    public abstract void callSecurityCenter(String msg);    // 联系警报中心
    public abstract void recordLog(String msg);             // 在警报中心留下记录
}
