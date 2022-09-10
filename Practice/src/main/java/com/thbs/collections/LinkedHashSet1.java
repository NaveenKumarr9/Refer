package com.thbs.collections;

import java.util.LinkedHashSet;

public class LinkedHashSet1 {
	public static void main(String[] args) {
		LinkedHashSet<String> animals = new LinkedHashSet<String>();
		animals.add("Dog");
		animals.add("Horse");
		animals.add("Cat");
		animals.add("Tiger");
		animals.add("Lion");
		//animals.add("Lion");

		System.out.println(animals);
	}

}
