package com.Assignments;

public class Student {
	int rollNo;

	Student(int rollNo) {
		this.rollNo = rollNo;
	}

	public static void main(String[] args) {

		Student s1 = new Student(111);
		Student s2 = new Student(105);
		Student s3 = new Student(103);
		Student[] st = { s1, s2, s3 };
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i].rollNo);
		}
		for (int i = 0; i < st.length - 1; i++) {
			if (st[i].rollNo > st[i + 1].rollNo) {
				Student temp = st[i];
				st[i] = st[i + 1];
				st[i + 1] = temp;
			}
		}
		System.out.println("After Sorting");
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i].rollNo);
		}
	}

}
