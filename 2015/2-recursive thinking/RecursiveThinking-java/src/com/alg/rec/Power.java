package com.alg.rec;

public class Power {
	
	public static long doPower1(int x, int n) {
		long res = 1;
		for(int i = 1; i <= n; ++i)
			res = res * x;
		return res;
	}
	
	public static long doPower2(int x, int n) {
		if(n == 0) return 1;
		if(n == 1) return x;
		long res = doPower2(x, n/2);
		if(n%2 == 0) return res * res;
		else return res * res * x;
	}
	
	public static void main(String[] args) {
		System.out.println(doPower1(2,10));
		System.out.println(doPower2(2,10));
	}

}
