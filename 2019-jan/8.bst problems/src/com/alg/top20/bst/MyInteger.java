package com.alg.top20.bst;

public class MyInteger {
	private int data;
	public MyInteger(int data) {
		this.data = data;
	}
	public int get() {
		return data;
	}
	public void set(int data) {
		this.data = data;
	}
	public void increment(int value) {
		data += value;
	}
}
