package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentSort {

	public static void main(String[] args) {

		Student st1 = new Student(104, "Naveen");
		Student st2 = new Student(103, "Vishnu");
		Student st3 = new Student(102, "Sai");

		List<Student> stList = new ArrayList<>();

		stList.add(st1);
		stList.add(st2);
		stList.add(st3);

		System.out.println("----Before Sorting----");

		for (Student st : stList) {
			System.out.println(st);
		}

		Collections.sort(stList);

		System.out.println("----After Sorting----");
		for (Student st : stList) {
			System.out.println(st);
		}

	}
}
