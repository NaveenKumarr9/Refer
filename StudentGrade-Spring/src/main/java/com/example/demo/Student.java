package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	private @Id @GeneratedValue Long id;
	private String name;
	private Long marks;
	private String grade;

	Student() {
	}

	public Student(Long id, String name, Long marks, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.marks = marks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMarks() {
		return marks;
	}

	public void setMarks(Long marks) {
		this.marks = marks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + id + ", name=" + name + ", marks=" + marks + ", grade=" + grade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(grade, marks, name, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(grade, other.grade) && Objects.equals(marks, other.marks)
				&& Objects.equals(name, other.name) && Objects.equals(id, other.id);
	}

}