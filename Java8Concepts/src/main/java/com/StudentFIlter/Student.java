package com.StudentFIlter;

public class Student {
	private int id;
	private String name;
	private Department dept_id;
	private int cmarks, pmarks, mmarks, total;

	public Student(int id, String name, Department dept_id, int cmarks, int pmarks, int mmarks) {
		super();
		this.id = id;
		this.name = name;
		this.dept_id = dept_id;
		this.cmarks = cmarks;
		this.pmarks = pmarks;
		this.mmarks = mmarks;

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

	public Department getDept_id() {
		return dept_id;
	}

	public void setDept_id(Department dept_id) {
		this.dept_id = dept_id;
	}

	public int getCmarks() {
		return cmarks;
	}

	public void setCmarks(int cmarks) {
		this.cmarks = cmarks;
	}

	public int getPmarks() {
		return pmarks;
	}

	public void setPmarks(int pmarks) {
		this.pmarks = pmarks;
	}

	public int getMmarks() {
		return mmarks;
	}

	public void setMmarks(int mmarks) {
		this.mmarks = mmarks;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Student3 [id=" + id + ", name=" + name + ", dept_id=" + dept_id + ", cmarks=" + cmarks + ", pmarks="
				+ pmarks + ", mmarks=" + mmarks + "]";
	}

}
