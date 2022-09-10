package com.thbs.collections;

import java.util.HashSet;

public class HashSet1 {

	public static void main(String[] args) {
		HashSet<String> animals = new HashSet<String>();
		animals.add("Dog");
		animals.add("Horse");
		animals.add("Cat");
		animals.add("Tiger");
		animals.add("Lion");
		animals.add("Lion");

		System.out.println(animals);

		animals.remove("Dog");
		System.out.println(animals);

		/*
		 * for (String s : animals) { System.out.println(s); }
		 */

		/*
		 * Iterator<String> i=animals.iterator(); while(i.hasNext()) {
		 * System.out.println(i.next()); }
		 */
	}

}
