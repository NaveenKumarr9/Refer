package com.StudentFIlter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DeptFilter {

	public static void main(String[] args) {

		Department d1 = new Department(111, "CSE");
		Department d2 = new Department(112, "ECE");
		Department d3 = new Department(113, "EEE");

		Student s1 = new Student(101, "Sumit", d1, 90, 95, 93);
		Student s2 = new Student(102, "Rajesh", d1, 87, 95, 93);
		Student s3 = new Student(103, "Suraj", d2, 66, 95, 78);
		Student s4 = new Student(104, "Tom", d2, 79, 95, 93);
		Student s5 = new Student(105, "Shiva", d3, 90, 78, 93);
		Student s6 = new Student(106, "Jay", d3, 90, 95, 93);
		Student s7 = new Student(107, "Sagar", d3, 83, 67, 93);

		List<Student> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7);

		Map<Department, List<Student>> res = list.stream().collect(Collectors.groupingBy(Student::getDept_id));

		//System.out.println(res);

		for (Department dep : res.keySet()) {
			System.out.println(dep + " =" + res.get(dep));
		}

	}
}
