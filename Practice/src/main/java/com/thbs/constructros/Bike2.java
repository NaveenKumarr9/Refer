package com.thbs.constructros;

public class Bike2 {
	String bike;
	
	Bike2(){
		this.bike="Duke";
	}

	Bike2(String bike) {
		this.bike = bike;
}
	void display() {
		System.out.println(bike + " has two wheels");
}
	public static void main(String[] args) {

		Bike2 bike1 = new Bike2();
		Bike2 bike2 = new Bike2("R15");

		bike1.display();
		bike2.display();
	}
}