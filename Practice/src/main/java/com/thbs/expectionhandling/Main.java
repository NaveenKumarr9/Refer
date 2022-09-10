package com.thbs.expectionhandling;

class Main {
	public static void main(String[] args) {
		int a = 5;
		int b = 0;
		try {
			int c = a / b;
		}

		finally {
			System.out.println("executed");
		}
	}
}