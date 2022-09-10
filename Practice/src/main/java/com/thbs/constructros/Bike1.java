package com.thbs.constructros;

class Bike1 {
	String bike;

	Bike1(String bike) {
		System.out.println(bike + " has two wheels");
}
	public static void main(String[] args) {

		Bike1 bike1 = new Bike1("Duke");
		Bike1 bike2 = new Bike1("R15");
	}
}