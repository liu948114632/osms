/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Interpreter.A1.language;

// <repeat command> ::= repeat <number> <command list>
public class RepeatCommandNode extends Node {
    private int number;
    private Node commandListNode;
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    public void execute() throws ExecuteException {
        for (int i = 0; i < number; i++) {
            commandListNode.execute();
        }
    }
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }
}
