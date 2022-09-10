package com.Assignments;

public class StudentCalculator {

	 private double first;
	 private double second;

	public StudentCalculator(double first, double second) {
		this.first = first;
		this.second = second;
	}

	public double getFirst() {
		return first;
	}

	public void setFirstNumber(double first) {
		this.first = first;
	}

	public double getSecond() {
		return second;
	}

	public void setSecondNumber(double second) {
		this.second = second;
	}

	public static double addition(StudentCalculator c) {
		return c.getFirst() + c.getSecond();
	}

	public static double subtraction(StudentCalculator c) {
		return c.getFirst() - c.getSecond();
	}

	public static double multiplication(StudentCalculator c) {
		return c.getFirst() * c.getSecond();
	}

	public static double division(StudentCalculator c) {
		return c.getFirst() / c.getSecond();
	}

	public static void main(String[] args) {
		StudentCalculator c = new StudentCalculator(10, 5);
		System.out.println("Addition = " + addition(c));
		System.out.println("Subtraction = " + subtraction(c));
		System.out.println("Multiplication = " + multiplication(c));
		System.out.println("Division = " + division(c));

	}


}
