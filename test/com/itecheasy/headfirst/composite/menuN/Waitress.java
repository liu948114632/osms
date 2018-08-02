package com.itecheasy.headfirst.composite.menuN;

import java.util.Iterator;
  
public class Waitress {
	MenuComponent allMenus;
 
	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
 
	public void printMenu() {
		allMenus.print();
		//女仆眼里看来只需要调用这个统一的方法方法来点单，
		// 而不需要关心具体的类型而给出不同的遍历方式
		// 把女仆和菜单的具体类型给解耦出去

		//所有的菜单都有一个统一的抽象超类或者接口

	}
}
