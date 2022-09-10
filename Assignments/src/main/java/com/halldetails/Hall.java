package com.halldetails;

public class Hall {

	private String name;
	private Double costPerDay;
	private String owner;

	public Hall() {
		super();
	}

	public Hall(String name, Double costPerDay, String owner) {
		super();
		this.name = name;
		this.costPerDay = costPerDay;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCostPerDay() {
		return costPerDay;
	}

	public void setCostPerDay(Double costPerDay) {
		this.costPerDay = costPerDay;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		
		return  name  + "     "+costPerDay + owner ;
	}

}
