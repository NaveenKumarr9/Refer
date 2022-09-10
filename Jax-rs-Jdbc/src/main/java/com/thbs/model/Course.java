package com.thbs.model;

public class Course {

	private int id;
	private String name;
	private int duration;
	private double fee;

	public Course() {
		super();
	}

	public Course(int id, String name, int duration, double fee) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.fee = fee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

}
