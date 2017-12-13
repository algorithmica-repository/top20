package com.alg.top20.bittricks;

public class HigherLowerMultiples {

	public static int nextHighestMult8(int n) {
		return (n+7) & ~7;
	}
	
	public static int prevLowestMult8(int n) {
		return n & ~7;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(prevLowestMult8(n));
		System.out.println(nextHighestMult8(n));
	}

}
