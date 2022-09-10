package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 9, 3, 5, 4, 8, 6, 7, 1);

		System.out.println("Before Adding:" + list);

		List<Integer> list2 = list.stream()
				.map(i -> i + 1)
				.collect(Collectors.toList());

		System.out.println("After Adding :" + list2);

		List<Integer> list1 = list.stream()
				.filter(num -> num % 2 == 0)
				.collect(Collectors.toList());

		System.out.println("Even Numbers : " + list1);

		Stream<Integer> list3 = list.stream()
				.sorted((num1, num2) -> num2.compareTo(num1));
				//.collect(Collectors.toList());

		System.out.println("Descending Order:" + list3);
		
		System.out.println("Sorted Order:" + list.stream().sorted().collect(Collectors.toList()));
		
		
	}

}
