package com.thbs.constructros;

public class Student {
	int id;
	String name;

	void display() {
		System.out.println(id + " " + name);
	}
	public static void main(String args[]) {
		Student student = new Student();

		student.display();
	}
}