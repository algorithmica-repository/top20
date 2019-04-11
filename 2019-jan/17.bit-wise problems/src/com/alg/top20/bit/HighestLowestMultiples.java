package com.alg.top20.bit;

public class HighestLowestMultiples {

	public static int nextHighest(int n) {
		return (n + 7) & ~7;
	}
	
	public static int immediateLowest(int n) {
		return n & ~7;
		//return n & -8
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(nextHighest(n));
		System.out.println(immediateLowest(n));
	}

}
