package com.alg.top20.recursion;

public class Power {

	public static long pow(int x, int n) {
		if(n == 0) return 1;
		if(n == 1) return x;
		long tmp = pow(x,n/2);
		if(n % 2 == 0)
			return tmp * tmp;
		else
			return tmp * tmp * x;
	}
	public static void main(String[] args) {
		System.out.println(pow(2,19));
	}

}
