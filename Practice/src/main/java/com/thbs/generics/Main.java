package com.thbs.generics;

public class Main {
	public static void main(String[] args) {

		Generics<Integer> intg = new Generics<>(5);
		System.out.println(intg.getData());

		Generics<String> string = new Generics<>("Naveen");
		System.out.println(string.getData());
	}
}
