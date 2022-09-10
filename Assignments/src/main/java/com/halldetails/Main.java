package com.halldetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		List<Hall> set = new ArrayList<>();
		// Hall hall = new Hall();
		String lines;
		String[] split;

		System.out.println("Enter the number of halls:");
		int data = scan.nextInt();
		String temp = scan.nextLine();
		for (int i = 0; i < data; i++) {

			lines = scan.nextLine();
			split = lines.split(",");
			set.add(new Hall(split[0], Double.parseDouble(split[1]), split[2]));
		}
		System.out.format("%-15s %-10s %s\n", "Name", "Cost", "Owner");

		Collections.sort(set, (o1, o2) -> o1.getOwner().compareTo(o2.getOwner()));

		for (Hall hall : set) {
			System.out.printf("%-15s %-10s %s\n", hall.getName(), hall.getCostPerDay(), hall.getOwner());
		}
		scan.close();

	}
}
