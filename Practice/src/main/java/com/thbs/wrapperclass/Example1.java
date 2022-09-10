package com.thbs.wrapperclass;

class Example1 {
	public static void main(String[] args) {
		int a = 10;
		Integer i = Integer.valueOf(a);
		System.out.println(i);
	}
}

class Example2 {
	public static void main(String[] args) {
		int a = 10;

		Integer intobj = a;
		System.out.println(intobj);

		int intval = intobj;
		System.out.println(intval);

	}
}

class Example3 {
	public static void printInteger(Integer i) {
		System.out.println(i);
	}

	public static void main(String[] args) {
		int a = 10;
		printInteger(a);
	}
}

class Example4{
	public static void printInt(int i) {
		System.out.println(i);
	}
	public static void main(String[] args) {
		Integer a = new Integer(10);
		printInt(a);
	}
}
