package com.itecheasy.headfirst.composite.menuN;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {
	List menuComponents = new ArrayList();
	String name;
	String description;
  
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
 
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
 
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
 
	public MenuComponent getChild(int i) {
		return (MenuComponent)menuComponents.get(i);
	}
 
	public String getName() {
		return name;
	}
 
	public String getDescription() {
		return description;
	}
 
	public void print() {

		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");	//输出所有的自己的

		//打印他的节点的下一级的所有子节点
		Iterator iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponent menuComponent = (MenuComponent)iterator.next();
			menuComponent.print(); //针对接口编程，而不是针对实现编程
		}
	}
}
