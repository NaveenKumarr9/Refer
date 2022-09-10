package com.Assignments;

public class ArrayEvenFilter {

	static void filterEven(int array[]) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				System.out.print(array[i] + " ");
			}
		}
	}

	public static void main(String[] args) {

		int arr[] = { 3, 45, 23, 78, 44, 34, 88 };
		filterEven(arr);

	}

}
