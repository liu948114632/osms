/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Decorator.A1;

public class StringDisplay extends Display {
    private String string;                          // 要显示的字符串
    public StringDisplay(String string) {           // 通过参数传入要显示的字符串
        this.string = string;
    }
    public int getColumns() {                       // 字符数
        return string.getBytes().length;
    }
    public int getRows() {                          // 行数是1
        return 1;
    }
    public String getRowText(int row) {             // 仅当row为0时返回值
        if (row == 0) {
            return string;
        } else {
            return null;
        }
    }
}
