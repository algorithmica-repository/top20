package com.alg.top20.recursion;

public class Power {

	public static long pow(int x, int n) {
		if(0 == n) return 1;
		if(1 == n) return x;
		long tmp = pow(x,n/2);
		if(n%2 == 0)
			return tmp * tmp;
		else 	
		    return tmp * tmp * x;
	}
	public static void main(String[] args) {
		System.out.println(pow(2,16));
	}

}
