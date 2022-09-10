package com.Assignments;

public class StudentSort {

	private int rollNo;
	private String name;

	public StudentSort(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	static StudentSort[] sort(StudentSort[] st) {
		for (int i = 0; i < st.length; i++) {
			for (int j = i + 1; j < st.length; j++) {
				if (st[i].getRollNo() > st[j].getRollNo()) {
					StudentSort temp = st[i];
					st[i] = st[j];
					st[j] = temp;
				}
			}
		}
		return st;
	}

	public static void main(String[] args) {

		StudentSort s1 = new StudentSort(111, "Naveen");
		StudentSort s2 = new StudentSort(105, "Kumar");
		StudentSort s3 = new StudentSort(103, "Vishnu");
		StudentSort[] st = { s1, s2, s3 };

		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i].getRollNo());
		}
		sort(st);
		System.out.println("------");
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i].getRollNo());
		}

	}

}
