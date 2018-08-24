/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Strategy.A1;

public class Player {
    private String name;
    private Strategy strategy;
    private int wincount;
    private int losecount;
    private int gamecount;
    public Player(String name, Strategy strategy) {         // 赋予姓名和策略
        this.name = name;
        this.strategy = strategy;
    }
    public Hand nextHand() {                                // 策略决定下一局要出的手势
        return strategy.nextHand();
    }
    public void win() {                 // 胜
        strategy.study(true);
        wincount++;
        gamecount++;
    }
    public void lose() {                // 负
        strategy.study(false);
        losecount++;
        gamecount++;
    }
    public void even() {                // 平
        gamecount++;
    }
    public String toString() {
        return "[" + name + ":" + gamecount + " games, " + wincount + " win, " + losecount + " lose" + "]";
    }
}
