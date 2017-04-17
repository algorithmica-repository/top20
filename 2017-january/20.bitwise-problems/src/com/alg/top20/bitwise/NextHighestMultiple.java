package com.alg.top20.bitwise;

public class NextHighestMultiple {

	public static int nextHighestMultiple8Sol1(int n) {
		return ((n-1) / 8 + 1) * 8;
	}
	
	public static int nextHighestMultiple8Sol2(int n) {
		return (n + 7) & ~7;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(nextHighestMultiple8Sol1(n));
		System.out.println(nextHighestMultiple8Sol2(n));
	}

}
