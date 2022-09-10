package com.thbs.strings;

class Example1 {
	public static void main(String[] args) {
		String ex = "Naveen";
		System.out.println(ex);
	}
}
class Example2{
	public static void main(String[] args) {
		char ch[] = {'N','A','V','E','E','N'};
		String string = new String(ch);
		System.out.println(string);	
	}
}
class Example3 {
	public static void main(String[] args) {
		String s1 = "Naveen";
		String s2 = "Naveen";
		String s3 = "Kumar";
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s2.equals(s1));
	}
}
class Example4 {
	public static void main(String[] args) {
		String s1 = "Naveen";
		String s2 = "NAVEEN";

		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
	}
}
class Example5 {
	public static void main(String[] args) {
		String s1 = "Naveen";
		String s2 = "Naveen";
		String s3 = new String("Naveen");

		System.out.println(s1==s2);
		System.out.println(s1==s3);
	}
}
class Example6 {
	public static void main(String[] args) {
		String s = "Naveen" + " Kumar";
		System.out.println(s);
	}
}
class Example7 {
	public static void main(String[] args) {
		String s1 = "Naveen ";
		String s2 = "Kumar";
		String s3 = s1.concat(s2);
		System.out.println(s3);
	}
}
class Example8 {
	public static void main(String[] args) {
		String s = "Naveen ";
		System.out.println(s.toUpperCase());    
		System.out.println(s.toLowerCase());    
		System.out.println(s);
	}
}