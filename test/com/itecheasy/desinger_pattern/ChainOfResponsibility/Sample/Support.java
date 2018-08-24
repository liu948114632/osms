/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.ChainOfResponsibility.Sample;

public abstract class Support {
    private String name;                    // 解决问题的实例的名字
    private Support next;                   // 要推卸给的对象
    public Support(String name) {           // 生成解决问题的实例
        this.name = name;
    }
    public Support setNext(Support next) {  // 设置要推卸给的对象
        this.next = next;
        return next;
    }
    public void support(Trouble trouble) {  // 解决问题的步骤
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }
    public String toString() {              // 显示字符串
        return "[" + name + "]";
    }
    protected abstract boolean resolve(Trouble trouble); // 解决问题的方法
    protected void done(Trouble trouble) {  // 解决
        System.out.println(trouble + " is resolved by " + this + ".");
    }
    protected void fail(Trouble trouble) {  // 未解决
        System.out.println(trouble + " cannot be resolved.");
    }
}
