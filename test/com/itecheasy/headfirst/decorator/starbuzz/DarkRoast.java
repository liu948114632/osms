package com.itecheasy.headfirst.decorator.starbuzz;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		super.description = "Dark Roast Coffee";
	}
 
	public double cost() {
		return .99;
	}
}

