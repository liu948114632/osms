/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Decorator.Q1;

public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world.");
        Display b2 = new UpDownBorder(b1, '-');
        Display b3 = new SideBorder(b2, '*');
        b1.show();
        b2.show();
        b3.show();
        Display b4 = 
                    new FullBorder(
                        new UpDownBorder(
                            new SideBorder(
                                new UpDownBorder(
                                    new SideBorder(
                                        new StringDisplay("你好，世界。"),
                                        '*'
                                    ),
                                    '='
                                ),
                                '|'
                            ),
                            '/'
                        )
                    );
        b4.show();
    }
}
