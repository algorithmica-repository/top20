package com.alg.top20.recursion;

public class Power {
	
	public static long pow1(int x, int n) {
		long res = 1;
		for(int i = 1; i <= n; ++i) {
			res *= x;
		}
		return res;
	}
	
	public static long pow2(int x, int n) {
		if(n == 0) return 1;
		if(n == 1) return x;
		if(n == 2) return x*x;
		long tmp = pow2(x, n/2);
		if(n % 2 == 0)
			return tmp * tmp;
		else
			return tmp * tmp * x;
	}

	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		System.out.println(pow1(x, n));
		System.out.println(pow2(x, n));
	}

}
