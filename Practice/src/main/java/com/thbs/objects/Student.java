package com.thbs.objects;

public class Student {
	int id;
	String name;

	public static void main(String args[]) {
		Student student = new Student();
		student.id = 1;
		student.name = "Naveen";
		System.out.println(student.id);
		System.out.println(student.name);
	}
}

class Student1 {
	int id;
	String name;

	void display() {
		System.out.println(id + " " + name);
	}

	public static void main(String args[]) {
		Student1 student = new Student1();

		student.display();
	}
}

class Student3 {
	int id;
	String name;

	public static void main(String args[]) {
		Student3 student = new Student3();
		student.id = 1;
		student.name = "Naveen";
		System.out.println(student.id);
		System.out.println(student.name);

		Student3 student3 = new Student3();
		student3.id = 2;
		student3.name = "Kumar";
		System.out.println(student3.id);
		System.out.println(student3.name);
	}
}
