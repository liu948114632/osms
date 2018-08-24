/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Visitor.A3;

import java.util.ArrayList;
import java.util.Iterator;

class ElementArrayList extends ArrayList implements Element {
    public void accept(Visitor v) {
        Iterator it = iterator();
        while (it.hasNext()) {
            Element e = (Element)it.next();
            e.accept(v);
        }
    }
}
