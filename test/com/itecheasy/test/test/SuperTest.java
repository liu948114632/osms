package com.itecheasy.test.test;
/**
 * @author taozihao
 * @date 2018年7月16日 下午5:03:37
 * @description
 */
public class SuperTest {
	public static void main(String[] args) {
		Student student = new Student();
		student.setAge(15);
		student.setName("小明");
		//student.getSuperInfo();
		Person person = student.getSuper();
		System.out.println(person.getName());
		System.out.println(person.getAge());
	}
}
