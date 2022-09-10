package com.creditcard.ass;

public class Customer {

	private String name;
	private int crn;

	public Customer(String name, int crn) {
		super();
		this.name = name;
		this.crn = crn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCrn() {
		return crn;
	}

	public void setCrn(int crn) {
		this.crn = crn;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", crn=" + crn + "]";
	}

}
