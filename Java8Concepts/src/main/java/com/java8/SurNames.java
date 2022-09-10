package com.java8;

import java.util.Arrays;
import java.util.List;

public class SurNames {
	public static void main(String[] args) {

		List<String> firstname = Arrays.asList("Naveen", "Ganesh","Ravi");
		List<String> lastname = Arrays.asList(" Kamatham", " Renikunta","   Somu");

		firstname.stream().map(x -> x + lastname.get(firstname.indexOf(x))).forEach(x -> System.out.println(x));

		/*
		 * List<String> result = new ArrayList<>();
		 * 
		 * for (int i = 0; i < firstname.size(); i++) { result.add(firstname.get(i) +
		 * " " + lastname.get(i)); } System.out.println(result);
		 * 
		 * result.stream().filter(x -> ).forEach(y -> System.out.println(y));
		 */
	}
}
