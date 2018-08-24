/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Builder.Sample;

public class TextBuilder extends Builder {
    private StringBuffer buffer = new StringBuffer();           // 文档内容保存在该字段中
    public void makeTitle(String title) {                       // 纯文本的标题
        buffer.append("==============================\n");      // 装饰线
        buffer.append("『" + title + "』\n");                   // 为标题添加『』
        buffer.append("\n");                                    // 换行
    }
    public void makeString(String str) {                        // 纯文本的字符串
        buffer.append('■' + str + "\n");                       // 为字符串添加■
        buffer.append("\n");                                    // 换行
    }
    public void makeItems(String[] items) {                     // 纯文本的条目
        for (int i = 0; i < items.length; i++) {
            buffer.append("　・" + items[i] + "\n");            // 为条目添加・
        }
        buffer.append("\n");                                    // 换行
    }
    public void close() {                                       // 完成文档
        buffer.append("==============================\n");      // 装饰线
    }
    public String getResult() {                                 // 完成的文档
        return buffer.toString();                               // 将StringBuffer变换为String
    }
}
