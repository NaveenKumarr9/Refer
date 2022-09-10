package com.thbs.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedList1 {
	public static void main(String[] args) {
		List<String> animals = new LinkedList<String>();
		animals.add("Dog");
		animals.add("Cat");
		animals.add("Horse");
		
		System.out.println("Animals>" + animals);

		Collections.sort(animals);

		for (String s : animals) {
			System.out.println(s);
		}
	}

}
