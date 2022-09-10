package com.thbs.collections;

import java.util.TreeSet;

public class TreeSet1 {
	public static void main(String[] args) {
		TreeSet<String> animals = new TreeSet<String>();
		animals.add("Dog");
		animals.add("Horse");
		animals.add("Cat");
		animals.add("Tiger");
		animals.add("Lion");
		animals.add("Lion");
		
		System.out.println(animals);
	}

}
