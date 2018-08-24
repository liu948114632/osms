/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Visitor.A1;

import java.util.Iterator;
import java.util.ArrayList;

public class FileFindVisitor extends Visitor {
    private String filetype;
    private ArrayList found = new ArrayList();
    public FileFindVisitor(String filetype) {           // 指定.后面的文件后缀名，如".txt"
        this.filetype = filetype;
    }
    public Iterator getFoundFiles() {                   // 获取已经找到的文件
        return found.iterator();
    }
    public void visit(File file) {                  // 在访问文件时被调用
        if (file.getName().endsWith(filetype)) {
            found.add(file);
        }
    }
    public void visit(Directory directory) {   // 在访问文件夹时被调用
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
    }
}
