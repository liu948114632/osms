package com.itecheasy.headfirst.strategy;

public class MallardDuck extends Duck {
//	QuackBehavior quackBehavior ;
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
 
	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}
