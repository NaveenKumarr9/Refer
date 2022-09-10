package com.collection;

import java.util.ArrayList;
import java.util.List;

public class FIlterEven {

	static List<Integer> filterEven(List<Integer> list) {
		List<Integer> res = new ArrayList<>();

		for (Integer number : list) {
			if (number % 2 == 0)
				res.add(number);
		}
		return res;
	}

	public static void main(String[] args) {

		List<Integer> lis = new ArrayList<Integer>();

		lis.add(3);
		lis.add(6);
		lis.add(45);
		lis.add(23);
		lis.add(78);
		lis.add(44);
		lis.add(34);
		lis.add(88);

		for (Integer x : filterEven(lis)) {
			System.out.println(x);
		}

	}

}
