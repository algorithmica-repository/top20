package com.alg.top20.bit;

public class HigherLowerMultiplesof8 {

	public static int prevLowest(int n) {
		return n & ~7;
	}
	
	public static int nextHighest1(int n) {
		return (n + 7) & ~7;
	}
	
	public static int nextHighest2(int n) {
		return (n | 7) + 1;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(prevLowest(n));
		System.out.println(nextHighest1(n));
		System.out.println(nextHighest2(n));
	}

}
