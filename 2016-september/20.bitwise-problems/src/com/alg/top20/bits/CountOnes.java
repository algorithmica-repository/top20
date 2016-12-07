package com.alg.top20.bits;

public class CountOnes {

	public static int countOnes1(int n) {
		int nones = 0;
		for(int k = 32; k >= 1; --k) {
			if((n & 1<<(k-1)) != 0)
				++nones;
		}
		return nones;
	}
	
	public static int countOnes2(int n) {
		int nones = 0;
		while(n != 0) {
			n = n & (n-1);
			++nones;
		}
		return nones;
	}
	
	public static int countOnes3(int n) {
		int nones = 0;
		int mask = 0xC0000000;
		int rshift = 30;
		int[] ones = { 0, 1, 1, 2};
		for(int k = 1; k <= 16; ++k) {
			BitwiseOperators.show_bits((n & mask) >>>rshift);
			nones = nones  + ones[(n & mask) >>>rshift];
			mask = mask >>> 2;
			rshift -= 2;
		}
		return nones;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BitwiseOperators.show_bits(n);
		System.out.println(countOnes3(n));
		//System.out.println(countOnes2(n));

	}

}
