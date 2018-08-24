/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Iterator.A1;

import java.util.ArrayList;

public class BookShelf implements Aggregate {
    private ArrayList books;   
    public BookShelf(int initialsize) {         
        this.books = new ArrayList(initialsize);   
    }                                           
    public Book getBookAt(int index) {
        return (Book)books.get(index);          
    }
    public void appendBook(Book book) {
        books.add(book);                        
    }
    public int getLength() {
        return books.size();                    
    }
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
