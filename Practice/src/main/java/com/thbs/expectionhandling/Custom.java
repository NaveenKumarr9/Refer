package com.thbs.expectionhandling;

public class Custom {

	public static void main(String[] args) {
		int i, j;
		i = 10;
		j = 0;
		try {
			int k = j / i;
			if (k == 0) {
				throw new NotValidException("This is not possible");
			}
		} catch (NotValidException e) {
			System.out.println("Error " + e.getMessage());
		}
	}

}
