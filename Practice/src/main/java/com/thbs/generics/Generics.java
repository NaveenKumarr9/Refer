package com.thbs.generics;

public class Generics<T> {

	private T data;

	public Generics(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}
}