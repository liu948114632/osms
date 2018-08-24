/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.ChainOfResponsibility.A4;

public class Trouble {
    private int number;             // 问题编号
    public Trouble(int number) {    // 生成问题
        this.number = number;
    }
    public int getNumber() {        // 获取问题编号
        return number;
    }
    public String toString() {      // 代表问题的字符串
        return "[Trouble " + number + "]";
    }
}
