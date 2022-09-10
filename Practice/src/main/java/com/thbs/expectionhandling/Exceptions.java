package com.thbs.expectionhandling;

public class Exceptions {
	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		try {
			int c = a / b;
			System.out.println(c);

		} catch (ArithmeticException e) {
			System.out.println("Done" + e.getMessage());

		}
	}

}
