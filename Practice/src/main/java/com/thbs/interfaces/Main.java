package com.thbs.interfaces;

interface Calculator {
	void add(int a, int b);
}

class Calci implements Calculator {

	public void add(int a, int b) {
		System.out.println("The addition of two numbers is " + (a + b));
	}
}

public class Main {
	public static void main(String[] args) {
		Calculator cc = new Calci();
		cc.add(5, 6);
	}
}