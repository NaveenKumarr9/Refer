package com.thbs.polymorphism;

class Bird {
	public void fly() {
		System.out.println("All birds can fly");
	}
}

class Crow extends Bird {
	public void fly() {
		System.out.println("Crow is flying");
	}
}

class Parrot extends Bird {
	public void fly(String bird) {
		System.out.println("Parrot is flying");
	}
}

public class Main {
	public static void main(String[] args) {
		Bird bird = new Bird();
		bird.fly();

		Crow crow = new Crow();
		crow.fly();

		Parrot parrot = new Parrot();
		parrot.fly();
	}

}
