package com.Assignments;

public class EvenOrOdd {

	private int number;

	public EvenOrOdd(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public static void evenOrOdd(EvenOrOdd evo) {

		if (evo.getNumber() % 2 == 0) {
			System.out.println(evo.getNumber() + " is a Even Number");
		} else {
			System.out.println(evo.getNumber() + " is a Odd Number");
		}

	}

	public static void main(String[] args) {

		EvenOrOdd ev = new EvenOrOdd(9);
		evenOrOdd(ev);

	}

}
