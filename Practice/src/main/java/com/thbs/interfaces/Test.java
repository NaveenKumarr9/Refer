package com.thbs.interfaces;

interface Calculator1 {
	void add(int a, int b);
}

interface multi {
	void mul(int a, int b);
}

interface sub {
	void subt(int a, int b);
}

class Calci1 implements Calculator1, multi, sub {

	public void add(int a, int b) {
		System.out.println("The addition of two numbers is " + (a + b));
	}

	public void mul(int a, int b) {
		System.out.println("The multliplication of two numbers is " + (a * b));
	}

	public void subt(int a, int b) {
		System.out.println("The Substraction of two numbers is " + (a - b));

	}
}

public class Test {
	public static void main(String[] args) {
		Calci1 cc = new Calci1();
		cc.add(5, 5);
		cc.mul(2, 2);
		cc.subt(2, 2);
	}
}