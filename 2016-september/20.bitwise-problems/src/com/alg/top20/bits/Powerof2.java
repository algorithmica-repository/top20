package com.alg.top20.bits;

public class Powerof2 {

	public static boolean isPowerOf2Sol1(int n) {
		int res = 1;
		for(int i = 0; i < n/2; ++i) {
			if(res == n) return true;
			res = res * 2;
		}
		return false;
	}
	
	public static boolean isPowerOf2Sol2(int n) {
		System.out.println(Math.log(n)/Math.log(2));
		return (Math.log(n)/Math.log(2)) % 1 == 0;
	}
	
	public static boolean isPowerOf2Sol3(int n) {
		int nones = 0;
		for(int k = 32; k >= 1; --k) {
			if((n & 1<<(k-1)) != 0)
				++nones;
		}
		return nones == 1;
	}
	
	public static boolean isPowerOf2Sol4(int n) {
		return (n & (n-1)) == 0;
	}
	public static void main(String[] args) {
		System.out.println(isPowerOf2Sol4(14));
		System.out.println(isPowerOf2Sol4(16));
		System.out.println(isPowerOf2Sol4(32134568));
		

	}

}
