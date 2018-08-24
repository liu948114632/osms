/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Composite.Sample;

public abstract class Entry {
    public abstract String getName();                               // 获取名字
    public abstract int getSize();                                  // 获取大小
    public Entry add(Entry entry) throws FileTreatmentException {   // 加入目录条目
        throw new FileTreatmentException();
    }
    public void printList() {                                       // 为一览加上前缀并显示目录条目一览
        printList("");
    }
    protected abstract void printList(String prefix);               // 为一览加上前缀
    public String toString() {                                      // 显示代表类的文字
        return getName() + " (" + getSize() + ")";
    }
}
