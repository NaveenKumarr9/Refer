package com.DateTimeApi;

import java.time.LocalDate;
import java.util.Scanner;

public class DateTIme {

	public static void main(String[] args) {

		System.out.println("Enter a Number");
		Scanner scan = new Scanner(System.in);
		String day = scan.next();
		LocalDate date = LocalDate.of(Integer.parseInt(day), 1, 1);
		System.out.println(date.getDayOfWeek());
		System.out.println(" number of days you want to add ");
		date = date.plusDays(scan.nextLong());
		scan.close();
		System.out.println(date.getDayOfWeek());

	}

}
