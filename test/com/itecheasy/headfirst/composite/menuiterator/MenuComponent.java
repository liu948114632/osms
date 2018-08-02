package com.itecheasy.headfirst.composite.menuiterator;

import java.util.*;

//把它变为抽象类的好处是不需要强行要之类重写这些方法
public abstract class MenuComponent {
   
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
  
	public String getName() {
		throw new UnsupportedOperationException();
	}
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
	public double getPrice() {
		throw new UnsupportedOperationException();
	}
	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}

	public abstract Iterator createIterator();
 
	public void print() {
		throw new UnsupportedOperationException();
	}
}
