/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Builder.A3;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FrameBuilder framebuilder = new FrameBuilder();
        Director director = new Director(framebuilder);
        director.construct();
        JFrame frame = framebuilder.getResult();
        frame.setVisible(true);
    }
}
