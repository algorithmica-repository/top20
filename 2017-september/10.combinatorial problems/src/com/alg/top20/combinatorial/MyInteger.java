package com.alg.top20.combinatorial;


public class MyInteger {
	int value;
	public MyInteger(int value) {
		this.value = value;
	}
	public int get() {
		return value;
	}
	public void set(int value) {
		this.value = value;
	}
	public void incr(int i) {
		value += i;
	}
}
