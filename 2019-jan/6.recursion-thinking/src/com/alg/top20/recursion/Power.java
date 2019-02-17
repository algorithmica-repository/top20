package com.alg.top20.recursion;

public class Power {

	public static long pow1(int x, int n) {
		return 0;
	}
	public static long pow2(int x, int n) {
		if(n == 0) return 1;
		if(n == 1) return x;
		if(n == 2) return x * x;
		long tmp = pow2(x, n/2);
		if(n % 2 == 0)
			return tmp * tmp;
		else 
			return tmp * tmp * x;
	}
	//todo: fix the issue
	public static long pow3(int x, int n) {
		long res = 1, tmp = x;
		for(int i = n; i > 1; i /= 2) {
			tmp = tmp * tmp;
			if(i % 2 == 1) tmp *= x;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
