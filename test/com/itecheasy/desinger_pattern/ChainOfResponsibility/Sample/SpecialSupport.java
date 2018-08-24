/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.ChainOfResponsibility.Sample;

public class SpecialSupport extends Support {
    private int number;                                 // 只能解决指定编号的问题
    public SpecialSupport(String name, int number) {    // 构造函数
        super(name);
        this.number = number;
    }
    protected boolean resolve(Trouble trouble) {        // 解决问题的方法
        if (trouble.getNumber() == number) {
            return true;
        } else {
            return false;
        }
    }
}
