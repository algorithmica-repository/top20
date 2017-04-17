package com.alg.top20.bitwise;

public class PowerOf2 {

	public static boolean isPowerOf2Sol1(int n) {
		int nOnes = 0;
		for(int i = 0; i < 32;++i) {
			if( (n & (1 << i)) != 0)
				++nOnes;
		}
		return nOnes == 1;
	}
	
	public static boolean isPowerOf2Sol2(int n) {
		return (n & (n-1)) == 0;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Utils.showBits(n);
		Utils.showBits(n-1);
		System.out.println(isPowerOf2Sol1(n));
		System.out.println(isPowerOf2Sol2(n));
	}

}
