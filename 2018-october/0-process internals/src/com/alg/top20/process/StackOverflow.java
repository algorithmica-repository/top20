package com.alg.top20.process;

public class StackOverflow {
	static int count = 0;

	public static void dummy(int a, int b) {
		try {
			++count;
			dummy(a, b);
		} catch (StackOverflowError e) {
			System.out.println(count);
		}
	}

	public static void main(String[] args) {
		dummy(10, 20);
	}

}
