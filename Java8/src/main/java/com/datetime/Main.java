package com.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getDayOfYear());
		
		System.out.println(date.plusDays(10));
		System.out.println(date.minusDays(10));
		
		System.out.println(date.plusMonths(2));
		System.out.println(date.minusMonths(2));
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		LocalDateTime cur = LocalDateTime.now();
		System.out.println(cur);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		

	}

}
