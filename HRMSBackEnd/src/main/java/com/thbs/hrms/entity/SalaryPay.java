package com.thbs.hrms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class SalaryPay 
{
	@Id @GeneratedValue
	private Long id;
	private Long empId;
	private int month;
	private int year;
	private Long deduction;
	private double salary;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Long getDeduction() {
		return deduction;
	}
	public void setDeduction(Long deduction) {
		this.deduction = deduction;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "SalaryPay [id=" + id + ", empId=" + empId + ", month=" + month + ", year=" + year + ", deduction="
				+ deduction + ", salary=" + salary + "]";
	}
	
}
