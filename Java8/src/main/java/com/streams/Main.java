package com.streams;

import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Map<String, Integer> map = new TreeMap<>();
		map.put("Naveen", 1);
		map.put("Ajay", 5);
		map.put("Prem", 9);

		map.forEach((k, v) -> System.out.println("Key - " + k + " | value - " + v));
		
		//map.replaceAll((k,v) -> 6);
		System.out.println(map);

	}

}
