package com.Assignments;

public class PrimeOrNot {

	private int number;

	public PrimeOrNot(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	static String checkPrime(int n) {
		int i = 2;
		while (true) {
			if ((n % i == 0 || n == 1) && n != 2) {
				return "Not Prime";
			}
			i++;
			if (i > Math.sqrt(n)) {
				return "Prime";
			}
		}
	}

	public static void main(String[] args) {

		PrimeOrNot po = new PrimeOrNot(-9);
		System.out.println(checkPrime(po.getNumber()));

	}

}
