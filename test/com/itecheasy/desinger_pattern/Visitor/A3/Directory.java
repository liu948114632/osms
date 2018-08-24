/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Visitor.A3;

import java.util.Iterator;
import java.util.ArrayList;

public class Directory extends Entry {
    private String name;                    // 文件夹名字
    private ArrayList dir = new ArrayList();      // 目录条目集合
    public Directory(String name) {         // 构造函数
        this.name = name;
    }
    public String getName() {               // 获取名字
        return name;
    }
    public int getSize() {                  // 获取大小
        int size = 0;
        Iterator it = dir.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }
    public Entry add(Entry entry) {         // 增加目录条目
        dir.add(entry);
        return this;
    }
    public Iterator iterator() {      // 生成Iterator
        return dir.iterator();
    }
    public void accept(Visitor v) {         // 接受访问者的访问
        v.visit(this);
    }
}
