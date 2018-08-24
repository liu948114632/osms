/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Singleton.A1;

public class TicketMaker {
    private int ticket = 1000;
    private static TicketMaker singleton = new TicketMaker();       
    private TicketMaker() {                                         
    }                                                               
    public static TicketMaker getInstance() {                       
        return singleton;                                           
    }                                                               
    public synchronized int getNextTicketNumber() {                 
        return ticket++;
    }
}
