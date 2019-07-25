package com.alg.top20.bit;

public class BoundaryAlignment {

	public static int immediate_lowest_8(int n) {
		return n & ~7;
	}
	public static int immediate_highest_8(int n) {
		return (n + 7) & ~7;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(immediate_highest_8(n));
		System.out.println(immediate_lowest_8(n));

	}

}
