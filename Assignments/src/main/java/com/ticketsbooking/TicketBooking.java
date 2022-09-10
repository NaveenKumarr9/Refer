package com.ticketsbooking;

import java.util.Date;
import java.util.Objects;

public class TicketBooking {

	private String stageEventShow;
	private Date bookingTime;
	private String seatNumber;
	private double price;
	// private String date;

	public TicketBooking() {
		super();
	}

	public TicketBooking(String stageEventShow, Date bookingTime, String seatNumber, double price) {
		super();
		this.stageEventShow = stageEventShow;
		this.bookingTime = bookingTime;
		this.seatNumber = seatNumber;
		this.price = price;
	}

	public String getStageEventShow() {
		return stageEventShow;
	}

	public void setStageEventShow(String stageEventShow) {
		this.stageEventShow = stageEventShow;
	}

	public Date getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	@Override
	public String toString() {
		return "TIcketBooking [stageEventShow=" + stageEventShow + ", bookingTime=" + bookingTime + ", seatNumber="
				+ seatNumber + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingTime, price, seatNumber, stageEventShow);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketBooking other = (TicketBooking) obj;
		return Objects.equals(bookingTime, other.bookingTime) && Objects.equals(price, other.price)
				&& Objects.equals(seatNumber, other.seatNumber) && Objects.equals(stageEventShow, other.stageEventShow);
	}

	public void setBookingTime(String string, String format) {
		
		
	}

}
