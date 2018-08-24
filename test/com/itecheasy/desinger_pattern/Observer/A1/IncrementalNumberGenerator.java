/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Observer.A1;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int number;                     // 当前数值
    private int end;                        // 结束数值(不包含该值)
    private int inc;                        // 递增步长
    public IncrementalNumberGenerator(int start, int end, int inc) {
        this.number = start;
        this.end = end;
        this.inc = inc;
    }
    public int getNumber() {                // 获取当前数值
        return number;
    }
    public void execute() {
        while (number < end) {
            notifyObservers();
            number += inc;
        }
    }
}
