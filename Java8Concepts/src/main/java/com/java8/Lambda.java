package com.java8;

public class Lambda {
	public static void main(String[] args) {

		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Running without lambda");

			}
		};
		Runnable r2 = () -> {
			System.out.println("Running with lambda");

		};

		r1.run();
		r2.run();

	}

}
