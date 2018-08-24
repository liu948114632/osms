/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Memento.Sample.game;
import java.util.*;

public class Memento {
    int money;                              // 所持金钱
    ArrayList fruits;                       // 当前获得的水果
    public int getMoney() {                 // 获取当前所持金钱（narrow interface）
        return money;
    }
    Memento(int money) {                    // 构造函数(wide interface)
        this.money = money;
        this.fruits = new ArrayList();
    }
    void addFruit(String fruit) {           // 添加水果(wide interface)
        fruits.add(fruit);
    }
    List getFruits() {                      // 获取当前所持所有水果（wide interface）
         return (List)fruits.clone();
    }
}
