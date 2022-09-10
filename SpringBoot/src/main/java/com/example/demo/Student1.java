package com.example.demo;

public class Student1 {

	private String name;
	private int marks;

	public Student1() {
		super();
	}

	public Student1(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	String grades() {

		if (marks >= 90 && marks <= 100) {
			return name + " You Scored Grade-A";
		} else if (marks >= 80 && marks <= 90) {
			return name + " You Scored Grade-B";
		} else if (marks >= 70 && marks <= 80) {
			return name + " You Scored Grade-C";
		} else {
			return name + " You are Fail";
		}

	}

}
