package com.thbs.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList1 {
	public static void main(String[] args) {
		ArrayList<String> animals = new ArrayList<String>();
		animals.add("Dog");
		animals.add("Cat");
		animals.add("Horse");

		System.out.println("Animals->" + animals);
		Collections.sort(animals);
		
		for(String a : animals ) {
			System.out.println(a);
		}
	}
}
