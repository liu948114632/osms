package com.itecheasy.test.test;
/**
 * @author taozihao
 * @date 2018年6月13日 下午5:17:27
 * @description
 */
public class Person{
	private int age;
	private String name;
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	protected Person getPerson(){
		return this;
	}
	public static void main(String[] args) {
		Double double1 = new Double(30+50);
		System.out.println(double1/3);
		long a = 63;
		System.out.println(a/30);
	}
}
