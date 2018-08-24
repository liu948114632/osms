/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Interpreter.A1.language;

public class InterpreterFacade implements Executor {
    private ExecutorFactory factory;
    private Context context;
    private Node programNode;
    public InterpreterFacade(ExecutorFactory factory) {
        this.factory = factory;
    }
    public boolean parse(String text) {
        boolean ok = true;
        this.context = new Context(text);
        this.context.setExecutorFactory(factory);
        this.programNode = new ProgramNode();
        try {
            programNode.parse(context);
            System.out.println(programNode.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }
    public void execute() throws ExecuteException {
        try {
            programNode.execute();
        } catch (ExecuteException e) {
            e.printStackTrace();
        }
    }
}
