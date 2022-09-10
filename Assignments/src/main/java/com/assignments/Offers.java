package com.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Offers {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		List<String> a1 = new ArrayList<>();
		List<String> a2 = new ArrayList<>();
		List<String> a3 = new ArrayList<>();

		System.out.println("Enter the number of passengers in First friday flight from Chennai to Coimbatore");
		int data = scan.nextInt();
		System.out.println("Enter the passengers Names");
		for (int i = 0; i < data; i++) {
			a1.add(scan.next());
		}

		System.out.println("Enter the number of passengers in Second friday flight from Chennai to Coimbatore");
		data = scan.nextInt();
		System.out.println("Enter the passengers Names");
		for (int i = 0; i < data; i++) {
			a2.add(scan.next());
		}
		System.out.println("Enter the number of passengers in Second friday flight from Chennai to Coimbatore");
		data = scan.nextInt();
		System.out.println("Enter the passengers Names");
		for (int i = 0; i < data; i++) {
			a3.add(scan.next());
		}

		System.out.println("Selected passengers for discount:");
		List<String> common = new ArrayList<>();
		for (String i : a1) {
			for (String j : a2) {
				if (i.equals(j)) {
					common.add(i);
					break;
				}
			}
		}
		for (String i : common) {
			for (String j : a3) {
				if (i.equals(j)) {
					System.out.println(i);
					break;
				}
			}
		}

	}

}
