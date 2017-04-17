package com.alg.top20.bitwise;

public class CountOnes {
	
	public static int countOnes1(int n) {
		int nOnes = 0;
		for(int i = 0; i < 32;++i) {
			if( (n & (1 << i)) != 0)
				++nOnes;
		}
		return nOnes;
	}
	
	public static int countOnes2(int n) {
		int nOnes = 0;
		while(n != 0) {
			Utils.showBits(n);
			Utils.showBits(n-1);
			++nOnes;
			n = n & (n-1);
		} 
		return nOnes;
	}
	
	public static int countOnes3(int n) {
		int nOnes = 0;
		int[] cache = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
		
		int mask = 0xF;
		while(n != 0) {
			nOnes += cache[n & mask];
			n >>>= 4;
		}
		return nOnes;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(countOnes2(n));
		System.out.println(countOnes3(n));
	}

}
