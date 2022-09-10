package com.thbs.model;

public class Course {

	private int id;
	private String name;
	private String duration;
	private double fee;

	public Course() {
		super();
	}

	public Course(int id, String name, String duration, double fee) {
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

}
