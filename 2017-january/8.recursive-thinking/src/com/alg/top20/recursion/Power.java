package com.alg.top20.recursion;

public class Power {

	public static long pow1(int x,long n) {
		long res = 1;
		for(int i = 0; i < n; ++i)
			res = res * x;
		return res;			
	}
	
	public static long pow2(int x,long n) {
		if(n == 0) return 1;
		if(n == 1) return x;
		long tmp = pow2(x,n/2);
		if( n % 2 == 0)
			return tmp * tmp;
		else
			return tmp * tmp * x;			
	}
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		long n = Long.parseLong(args[1]);
		System.out.println(pow2(x,n));
	}

}
