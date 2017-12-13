package com.alg.top20.bittricks;

public class IsPowerOf2 {

	public static boolean isPowerOf2(int n) {
		return (n & (n-1)) == 0;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BitWiseUtilities.display(n);
		System.out.println(isPowerOf2(n));

	}

}
