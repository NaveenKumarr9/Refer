package com.assignments.airport;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Map<String, Airport> mp = new TreeMap<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of airports");
		int data = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < data; i++) {
			System.out.println("Enter the details of the airport " + (i + 1));
			String code = sc.nextLine();
			String name = sc.nextLine();
			String city = sc.nextLine();
			Airport air = new Airport(code, name, city);
			mp.put(air.getIataAirportCode(), air);

		}
		System.out.println("Airport Details");
		for (Map.Entry m : mp.entrySet()) {
			System.out.println(m.getValue());
		}

	}

}
