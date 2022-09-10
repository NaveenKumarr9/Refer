package com.FunctionalInterface;


public interface Animal {

	public void bird(int age);
	//public void cat();

	default String cat(String name) {
		return name;
	}

}
