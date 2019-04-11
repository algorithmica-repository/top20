package com.alg.top20.bit;

public class CountOnes {

	public static int countOnes1(int n) {
		int mask = 1, nones = 0;;
		while(n != 0) {
			if((n & mask) != 0)
				++nones;
			n = n >>> 1;
		}
		return nones;
	}
	
	public static int countOnes2(int n) {
		int mask = 0xF, nones = 0;;
		int[] ones = {0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4};
		while(n != 0) {
			nones = nones + ones[n&mask];
			n = n >>> 4;
		}	
		return nones;
	}
	
	public static int countOnes3(int n) {
		int nones = 0;
		while(n != 0) {
			++nones;
			n = n & (n-1);
		}
		return nones;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BitwiseUtils.showBits(n);
		System.out.println(countOnes3(n));
	}

}
