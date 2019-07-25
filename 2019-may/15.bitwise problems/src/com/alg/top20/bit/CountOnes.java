package com.alg.top20.bit;

public class CountOnes {

	public static int countOnes1(int n) {
		int mask = 1 << 31;
		int count = 0;
		for(int i  = 0; i < 32; ++i) {
			if( (n & mask) != 0)
				++count;
			mask = mask >>> 1;
		}
		return count;
	}
	
	public static int countOnes2(int n) {
		int mask = 0x0000000F;
		int[] ones = {0, 1, 1, 2, 1, 2, 2, 3, 1,
					2, 2, 3, 2, 3, 3, 4};
		int count = 0;
		while(n != 0) {
			count += ones[ (n & mask) ]; 
			n = n >>> 4;
		}
		return count;
	}
	
	public static int countOnes3(int n) {
		int count = 0;
		while(n != 0) {
			n = n & (n-1);
			++count;
		}
		return count;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BitWiseUtils.showBits(n);
		System.out.println(countOnes3(n));
	}

}
