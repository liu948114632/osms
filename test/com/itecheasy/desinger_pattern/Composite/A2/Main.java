/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Composite.A2;

public class Main {
    public static void main(String[] args) {
        try {
            Directory rootdir = new Directory("root");

            Directory usrdir = new Directory("usr");
            rootdir.add(usrdir);

            Directory yuki = new Directory("yuki");
            usrdir.add(yuki);

            File file = new File("Composite.java", 100);
            yuki.add(file);
            rootdir.printList();

            System.out.println("");
            System.out.println("file = " + file.getFullName());     
            System.out.println("yuki = " + yuki.getFullName());     
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
