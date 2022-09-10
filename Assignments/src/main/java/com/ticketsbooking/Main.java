package com.ticketsbooking;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		TicketBooking tb = new TicketBooking();
		List<TicketBooking> list = new ArrayList<>();

		System.out.println("Enter the number of bookings:");
		int data = sc.nextInt();
		String s[];
		for (int i = 0; i < data; i++) {

			Date date = new Date();  
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
			System.out.println("Enter the details of booking " + (i + 1));
			sc.next();
			String line = sc.next();
			s = line.split(",");
			tb.setStageEventShow(s[0]);

			 tb.setBookingTime((s[1]),formatter.format(date));
			// tb.setBookingTime();
			tb.setSeatNumber(s[2]);
			tb.setPrice(Double.parseDouble(s[3]));
			list.add(new TicketBooking(tb.getStageEventShow(), tb.getBookingTime(), tb.getSeatNumber(), tb.getPrice()));
		}
		Collections.sort(list, new PriceAndBookingTimeComparator());

		 System.out.println(list);

	}
}
