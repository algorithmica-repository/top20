package com.alg.top20.bst;

public class MyInteger {
	private int value;

	public MyInteger(int value) {
		super();
		this.value = value;
	}
	public int get() {
		return value;
	}
	public void set(int value) {
		this.value = value;
	}
	public void incr() {
		++this.value;
	}

}
