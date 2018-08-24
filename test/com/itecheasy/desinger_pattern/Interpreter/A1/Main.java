/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Interpreter.A1;

import language.InterpreterFacade;
import turtle.TurtleCanvas;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements ActionListener {
    private TurtleCanvas canvas = new TurtleCanvas(400, 400);
    private InterpreterFacade facade = new InterpreterFacade(canvas);
    private TextField programTextField = new TextField("program repeat 3 go right go left end end");

    // 构造函数
    public Main(String title) {
        super(title);

        canvas.setExecutor(facade);

        setLayout(new BorderLayout());

        programTextField.addActionListener(this);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(programTextField, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        pack();
        parseAndExecute();
        show();
    }

    // 供ActionListener用
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == programTextField) {
            parseAndExecute();
        }
    }

    private void parseAndExecute() {
        String programText = programTextField.getText();
        System.out.println("programText = " + programText);
        facade.parse(programText);
        canvas.repaint();
    }

    public static void main(String[] args) {
        new Main("Interpreter Pattern Sample");
    }
}
