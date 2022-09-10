package com.Lambda;

import java.util.ArrayList;
import java.util.List;

public class Lambda {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Naveen");
		list.add("Kumar");
		list.add("Ganesh");
		list.add("Sreenu");

		list.forEach((n) -> System.out.println(n));
	}

}
