/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Bridge.A3;

public class CharDisplayImpl extends DisplayImpl {
    private char head;
    private char body;
    private char foot;
    public CharDisplayImpl(char head, char body, char foot) {
        this.head = head;
        this.body = body;
        this.foot = foot;
    }
    public void rawOpen() {
        System.out.print(head);
    }
    public void rawPrint() {
        System.out.print(body);
    }
    public void rawClose() {
        System.out.println(foot);
    }
}
