package com.alg.top20.trees;

class MyInteger {
	private int max;
	public MyInteger() {
		max = Integer.MIN_VALUE;
	}
	public int get() {
		return max;
	}
	public void set(int val) {
		max = val;
	}
}
