/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Builder.A3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FrameBuilder extends Builder implements ActionListener {
    private JFrame frame = new JFrame();
    private Box box = new Box(BoxLayout.Y_AXIS);
    public void makeTitle(String title) {
        frame.setTitle(title);
    }
    public void makeString(String str) {
        box.add(new JLabel(str));
    }
    public void makeItems(String[] items) {
        Box innerbox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < items.length; i++) {
            JButton button = new JButton(items[i]);
            button.addActionListener(this);
            innerbox.add(button);
        }
        box.add(innerbox);
    }
    public void close() {
        frame.getContentPane().add(box);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public JFrame getResult() {
        return frame;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
