package com.alg.top20.recursion;

public class Power {

	//TC:O(n) SC:O(1)
	public static long pow1(long x,long n) {
		long res = 1;
		for(int i = 1; i <= n; ++i)
			res *= x;
		return res;
	}
	//TC:O(log n)   SC:O(log n)
	public static long pow2(long x, long n) {
		//the base case to stop recursion and solve the problem
		if(n == 1) 
			return x;
		//reduction of problem
		long res = pow2(x, n/2);
		//solution building 
		if(n % 2 == 0)
			return res * res;
		else
			return res * res * x;
	}
	public static void main(String[] args) {
		long x = Long.parseLong(args[0]);
		long n = Long.parseLong(args[1]);
		long res = pow2(x,n);
		System.out.println(res);
	}

}
