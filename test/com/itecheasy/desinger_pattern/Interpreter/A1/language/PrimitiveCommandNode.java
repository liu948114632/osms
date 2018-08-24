/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Interpreter.A1.language;

// <primitive command> ::= go | right | left
public class PrimitiveCommandNode extends Node {
    private String name;
    private Executor executor;
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        executor = context.createExecutor(name);
    }
    public void execute() throws ExecuteException {
        if (executor == null) {
            throw new ExecuteException(name + ": is not defined");
        } else {
            executor.execute();
        }
    }
    public String toString() {
        return name;
    }
}
