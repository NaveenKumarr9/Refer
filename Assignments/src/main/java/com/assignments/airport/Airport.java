package com.assignments.airport;

public class Airport {
	private String iataAirportCode;
	private String name;
	private String city;

	public Airport() {
		super();
	}

	public Airport(String iataAirportCode, String name, String city) {
		super();
		this.iataAirportCode = iataAirportCode;
		this.name = name;
		this.city = city;
	}

	public String getIataAirportCode() {
		return iataAirportCode;
	}

	public void setIataAirportCode(String iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return iataAirportCode+"--" + name+"--" + city;
	}

}
