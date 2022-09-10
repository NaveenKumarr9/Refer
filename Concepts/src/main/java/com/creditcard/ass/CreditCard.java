package com.creditcard.ass;

import java.util.Objects;

public class CreditCard implements Comparable<CreditCard> {

	private int no;
	private String name;
	private int cvv;
	private int expirydate;

	public CreditCard(int no, String name, int cvv, int expirydate) {
		super();
		this.no = no;
		this.name = name;
		this.cvv = cvv;
		this.expirydate = expirydate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(int expirydate) {
		this.expirydate = expirydate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "CreditCard [expirydate=" + expirydate + ", name=" + name + " ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(expirydate, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		return expirydate == other.expirydate && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(CreditCard cc) {
		int compareexpirydate = ((CreditCard) cc).getExpirydate();
		return this.expirydate - compareexpirydate;
	}

}
