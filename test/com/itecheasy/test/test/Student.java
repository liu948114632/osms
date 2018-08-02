package com.itecheasy.test.test;
/**
 * @author taozihao
 * @date 2018年7月16日 下午5:00:13
 * @description
 */
public class Student extends Person {
	private int age;
	private String name;
	
	public Student() {
		super.setAge(this.age+20);
		super.setName(this.name+"的爸爸");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		super.setAge(this.age+20);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		super.setName(this.name+"的爸爸");
	}
	public void getSuperInfo(){
		System.out.println("我是"+super.getName());
		System.out.println("我年龄"+super.getAge());
	}
	public Person getSuper(){
		String name = super.getName();
		
		Person person = super.getPerson();
		return person;
	}
}
