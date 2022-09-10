package com.ticketsbooking;

import java.util.Comparator;

public class PriceAndBookingTimeComparator implements Comparator<TicketBooking> {

	@Override
	public int compare(TicketBooking o1, TicketBooking o2) {
		if (o1.getPrice() != o2.getPrice()) {
			return Math.subtractExact((int) o1.getPrice(), (int) o2.getPrice());
		} else {
			o1.getBookingTime().compareTo(o2.getBookingTime());
		}
		return 0;
	}

}
