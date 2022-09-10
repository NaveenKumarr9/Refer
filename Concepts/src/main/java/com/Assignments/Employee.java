package com.Assignments;

public class Employee {

	private int id;
	private String name;
	private double salary;
	private double commision;
	private String designation;
	private double bouns;

	public Employee(int id, String name, double salary, double commision, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.commision = commision;
		this.designation = designation;
		
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getCommision() {
		return commision;
	}

	public void setCommision(double commision) {
		this.commision = commision;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getBouns() {
		return bouns;
	}

	public void setBouns(double bouns) {
		this.bouns = bouns;
	}

	static double bounsCalculator(Employee emp) {
		if (emp.getDesignation().equals("Manager")) {
			return (emp.getSalary() * 30) / 100;
		} else if (emp.getDesignation().equals("Lead")) {
			return (emp.getSalary() * 25) / 100;
		} else {
			return (emp.getSalary() * 20) / 100;
		}
	}

	public static void main(String[] args) {

		Employee emp1 = new Employee(101, "Naveen", 50000, 2000, "Manager");
		Employee emp2 = new Employee(102, "Kumar", 20000, 1000, "Lead");
		Employee emp3 = new Employee(103, "prem", 30000, 1500, "Associate");

		System.out.println(bounsCalculator(emp1) + emp1.getSalary() + emp1.getCommision());
		System.out.println(bounsCalculator(emp2) + emp2.getSalary() + emp2.getCommision());
		System.out.println(bounsCalculator(emp3) + emp3.getSalary() + emp3.getCommision());
	}

}
