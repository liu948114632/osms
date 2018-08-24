/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.TemplateMethod.Sample;

public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');                  // 生成一个持有'H'的CharDisplay类的实例 
        AbstractDisplay d2 = new StringDisplay("Hello, world.");    // 生成一个持有"Hello, world."的StringDisplay类的实例 
        AbstractDisplay d3 = new StringDisplay("你好，世界。");     // 生成一个持有"你好，世界。"的StringDisplay类的实例 
        d1.display();                                               // 由于d1、d2和d3都是AbstractDisplay类的子类
        d2.display();                                               // 可以调用继承的display方法
        d3.display();                                               // 实际的程序行为取决于CharDisplay类和StringDisplay类的具体实现 
    }
}
