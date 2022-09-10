package com.FunctionalInterface;

public class Main {
	public static void main(String[] args) {
		

		Animal animal = (int age) -> {
			System.out.println("Age is "+ age);

		};
		animal.bird(1);
		System.out.println(animal.cat("Cat"));

	}
}
