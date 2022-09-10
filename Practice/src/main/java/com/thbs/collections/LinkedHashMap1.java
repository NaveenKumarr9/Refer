package com.thbs.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap1 {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> animals = new LinkedHashMap<String, Integer>();
		animals.put("Dog", 1);
		animals.put("Cat", 2);
		animals.put("Horse", 3);

		System.out.println(animals);
		
		for (Map.Entry m : animals.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}

}
